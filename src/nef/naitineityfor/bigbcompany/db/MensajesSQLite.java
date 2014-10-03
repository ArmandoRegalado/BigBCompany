package nef.naitineityfor.bigbcompany.db;

import java.util.ArrayList;
import java.util.Iterator;

import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_MENSAJE;
import nef.naitineityfor.bigbcompany.dbobjects.Mensaje;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MensajesSQLite {

	 SQLHelper mDbHelper;
	 SQLiteDatabase db;

	 /** Constructor de clase */
	 public MensajesSQLite(Context context) {
		 mDbHelper = new SQLHelper( context );
	 }
	
	//Put, Read, Delete and Update info
	
	public long put(Mensaje mensaje){
		Log.i("NEFBBC", "put - entra" );
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		Log.i("NEFBBC", "put - db" );
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE, mensaje.get_id_mensaje());
		values.put(TBL_MENSAJE.COLUMN_NAME_EMAIL_REMITENTE, mensaje.get_email_remitente());
		values.put(TBL_MENSAJE.COLUMN_NAME_EMAIL_DESTINATARIO, mensaje.get_email_destinatario());
		values.put(TBL_MENSAJE.COLUMN_NAME_CONT_MENSAJE, mensaje.get_cont_mensaje());
		values.put(TBL_MENSAJE.COLUMN_NAME_ENVIADO, mensaje.get_enviado());
		values.put(TBL_MENSAJE.COLUMN_NAME_RECIBIDO, mensaje.get_recibido());
		Log.i("NEFBBC", "put - content values" );
		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
				 TBL_MENSAJE.TABLE_NAME,
				 null,//TBL_USR.COLUMN_NAME_NULLABLE,
		         values);
		Log.i("NEFBBC", "put - newRowId" );
		return newRowId;
	}
	
	public ArrayList<Mensaje> read(){

		ArrayList<Mensaje> Mensajes = null;
		Log.i("NEFBBC", "read - entra" );
		db = mDbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
			TBL_MENSAJE._ID,
			TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE,
			TBL_MENSAJE.COLUMN_NAME_EMAIL_REMITENTE,
			TBL_MENSAJE.COLUMN_NAME_EMAIL_DESTINATARIO,
			TBL_MENSAJE.COLUMN_NAME_CONT_MENSAJE,
			TBL_MENSAJE.COLUMN_NAME_ENVIADO,
			TBL_MENSAJE.COLUMN_NAME_RECIBIDO,
			//...
		    };
		Log.i("NEFBBC", "read - projection" );
		// How you want the results sorted in the resulting Cursor
		String sortOrder =
		    TBL_MENSAJE._ID + " DESC";
		Log.i("NEFBBC", "read - order" );
		Cursor c = db.query(
		    TBL_MENSAJE.TABLE_NAME,  // The table to query
		    projection,                               // The columns to return
		    null,//selection,                                // The columns for the WHERE clause
		    null,//selectionArgs,                            // The values for the WHERE clause
		    null,                                     // don't group the rows
		    null,                                     // don't filter by row groups
		    sortOrder                                 // The sort order
		    );
		Log.i("NEFBBC", "read - query" );
		if( c.moveToFirst() )
		   {
			Mensajes = new ArrayList <Mensaje>();
			Log.i("NEFBBC", "read - first" );
		    do{
				long itemId = c.getLong(c.getColumnIndexOrThrow(TBL_MENSAJE._ID));
				long id_mensaje = c.getLong(c.getColumnIndexOrThrow(TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE));
				String email_remitente = c.getString(c.getColumnIndexOrThrow(TBL_MENSAJE.COLUMN_NAME_EMAIL_REMITENTE));
				String email_destinatario = c.getString(c.getColumnIndexOrThrow(TBL_MENSAJE.COLUMN_NAME_EMAIL_DESTINATARIO));
				String cont_mensaje = c.getString(c.getColumnIndexOrThrow(TBL_MENSAJE.COLUMN_NAME_CONT_MENSAJE));
				String enviado = c.getString(c.getColumnIndexOrThrow(TBL_MENSAJE.COLUMN_NAME_ENVIADO));
				String recibido = c.getString(c.getColumnIndexOrThrow(TBL_MENSAJE.COLUMN_NAME_RECIBIDO));
				
				Mensajes.add(new Mensaje(id_mensaje, email_remitente, email_destinatario, cont_mensaje, enviado, recibido));
				Log.i("NEFBBC", "read - add " + itemId);
				
		    }while( c.moveToNext() );
		   }
		
		return Mensajes;
	}
	
	public void delete(String rowId){
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		// Define 'where' part of query.
		String selection = TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE + " LIKE ?";
		// Specify arguments in placeholder order.
		String[] selectionArgs = { String.valueOf(rowId) };
		// Issue SQL statement.
		db.delete(TBL_MENSAJE.TABLE_NAME, selection, selectionArgs);
	}
	
	public int update(String rowId, Mensaje mensaje){
		db = mDbHelper.getReadableDatabase();

		// New value for one column
		ContentValues values = new ContentValues();
		values.put(TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE, mensaje.get_id_mensaje());
		values.put(TBL_MENSAJE.COLUMN_NAME_EMAIL_REMITENTE, mensaje.get_email_remitente());
		values.put(TBL_MENSAJE.COLUMN_NAME_EMAIL_DESTINATARIO, mensaje.get_email_destinatario());
		values.put(TBL_MENSAJE.COLUMN_NAME_CONT_MENSAJE, mensaje.get_cont_mensaje());
		values.put(TBL_MENSAJE.COLUMN_NAME_ENVIADO, mensaje.get_enviado());
		values.put(TBL_MENSAJE.COLUMN_NAME_RECIBIDO, mensaje.get_recibido());

		// Which row to update, based on the ID
		String selection = TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE + " LIKE ?";
		String[] selectionArgs = { String.valueOf(rowId) };

		int count = db.update(
		    TBL_MENSAJE.TABLE_NAME,
		    values,
		    selection,
		    selectionArgs);
		
		return count;
	}
	
	public void print(){
		Log.i("NEFBBC", "print - inicio" );
		ArrayList<Mensaje> Mensajes = read();
		Log.i("NEFBBC", "print - registros = " + Mensajes.size());
		Iterator<Mensaje> myIterator = Mensajes.iterator();
		Log.i("NEFBBC", "print - iterator" );
		while(myIterator.hasNext()){
			Mensaje elemento = myIterator.next();
			Log.i("NEFBBC", "print - " + elemento.get_id_mensaje());
		}
		Log.i("NEFBBC", "print - while" );
	}
	
}
