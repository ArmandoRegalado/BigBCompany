package nef.naitineityfor.bigbcompany.db;

import java.util.ArrayList;
import java.util.Iterator;

import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_ENCUESTA;
import nef.naitineityfor.bigbcompany.dbobjects.Encuesta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EncuestasSQLite {

	 SQLHelper mDbHelper;
	 SQLiteDatabase db;

	 /** Constructor de clase */
	 public EncuestasSQLite(Context context) {
		 mDbHelper = new SQLHelper( context );
	 }
	
	//Put, Read, Delete and Update info
	
	public long put(Encuesta encuesta){
		Log.i("NEFBBC", "put - entra" );
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		Log.i("NEFBBC", "put - db" );
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA, encuesta.get_id_encuesta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_ID_PREGUNTA, encuesta.get_id_pregunta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_ID_RESPUESTA, encuesta.get_id_respuesta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_TITULO_ENC, encuesta.get_titulo_enc());
		values.put(TBL_ENCUESTA.COLUMN_NAME_DESCRIPCION_ENC, encuesta.get_descripcion_enc());
		values.put(TBL_ENCUESTA.COLUMN_NAME_FECH_PUB, encuesta.get_fech_pub());
		values.put(TBL_ENCUESTA.COLUMN_NAME_FECH_CONT, encuesta.get_fech_cont());
		values.put(TBL_ENCUESTA.COLUMN_NAME_TEXT_PREGUNTA, encuesta.get_text_pregunta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_TIPO_PREGUNTA, encuesta.get_tipo_pregunta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_RESP_TEXTO, encuesta.get_resp_texto());
		values.put(TBL_ENCUESTA.COLUMN_NAME_RESP_NUMERO, encuesta.get_resp_numero());
		values.put(TBL_ENCUESTA.COLUMN_NAME_RESP_ELEGIDA, encuesta.get_resp_elegida());

		Log.i("NEFBBC", "put - content values" );
		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
				 TBL_ENCUESTA.TABLE_NAME,
				 null,//TBL_USR.COLUMN_NAME_NULLABLE,
		         values);
		Log.i("NEFBBC", "put - newRowId" );
		return newRowId;
	}
	
	public ArrayList<Encuesta> read(){

		ArrayList<Encuesta> Encuestas = null;
		Log.i("NEFBBC", "read - entra" );
		db = mDbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
			TBL_ENCUESTA._ID,
			TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA,
			TBL_ENCUESTA.COLUMN_NAME_ID_PREGUNTA,
			TBL_ENCUESTA.COLUMN_NAME_ID_RESPUESTA,
			TBL_ENCUESTA.COLUMN_NAME_TITULO_ENC,
			TBL_ENCUESTA.COLUMN_NAME_DESCRIPCION_ENC,
			TBL_ENCUESTA.COLUMN_NAME_FECH_PUB,
			TBL_ENCUESTA.COLUMN_NAME_FECH_CONT,
			TBL_ENCUESTA.COLUMN_NAME_TEXT_PREGUNTA,
			TBL_ENCUESTA.COLUMN_NAME_TIPO_PREGUNTA,
			TBL_ENCUESTA.COLUMN_NAME_TIPO_RESP,
			TBL_ENCUESTA.COLUMN_NAME_RESP_TEXTO,
			TBL_ENCUESTA.COLUMN_NAME_RESP_NUMERO,
			TBL_ENCUESTA.COLUMN_NAME_RESP_ELEGIDA,
			//...
		    };
		Log.i("NEFBBC", "read - projection" );
		// How you want the results sorted in the resulting Cursor
		String sortOrder =
		    TBL_ENCUESTA.COLUMN_NAME_FECH_PUB + " DESC";
		Log.i("NEFBBC", "read - order" );
		Cursor c = db.query(
		    TBL_ENCUESTA.TABLE_NAME,  // The table to query
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
			Encuestas = new ArrayList <Encuesta>();
			Log.i("NEFBBC", "read - first" );
		    do{
				long itemId = c.getLong(c.getColumnIndexOrThrow(TBL_ENCUESTA._ID));
				long id_encuesta = c.getLong(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA));
				long id_pregunta = c.getLong(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_ID_PREGUNTA));
				long id_respuesta = c.getLong(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_ID_RESPUESTA));
				String titulo_enc = c.getString(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_TITULO_ENC));
				String descripcion_enc = c.getString(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_DESCRIPCION_ENC));
				String fech_pub = c.getString(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_FECH_PUB));
				String fech_cont = c.getString(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_FECH_CONT));
				String text_pregunta = c.getString(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_TEXT_PREGUNTA));
				Integer tipo_pregunta = c.getInt(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_TIPO_PREGUNTA));
				Integer tipo_resp = c.getInt(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_TIPO_RESP));
				String resp_texto = c.getString(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_RESP_TEXTO));
				Integer resp_numero = c.getInt(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_RESP_NUMERO));
				long resp_elegida = c.getLong(c.getColumnIndexOrThrow(TBL_ENCUESTA.COLUMN_NAME_RESP_ELEGIDA));
				
				Encuestas.add(new Encuesta(id_encuesta, id_pregunta, id_respuesta, titulo_enc, descripcion_enc, fech_pub, fech_cont, text_pregunta, tipo_pregunta, tipo_resp, resp_texto, resp_numero, resp_elegida));
				Log.i("NEFBBC", "read - add " + itemId);
				
		    }while( c.moveToNext() );
		   }
		
		return Encuestas;
	}
	
	public void delete(String rowId){
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		// Define 'where' part of query.
		String selection = TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA + " LIKE ?";
		// Specify arguments in placeholder order.
		String[] selectionArgs = { String.valueOf(rowId) };
		// Issue SQL statement.
		db.delete(TBL_ENCUESTA.TABLE_NAME, selection, selectionArgs);
	}
	
	public int update(String rowId, Encuesta encuesta){
		db = mDbHelper.getReadableDatabase();

		// New value for one column
		ContentValues values = new ContentValues();
		values.put(TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA, encuesta.get_id_encuesta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_ID_PREGUNTA, encuesta.get_id_pregunta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_ID_RESPUESTA, encuesta.get_id_respuesta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_TITULO_ENC, encuesta.get_titulo_enc());
		values.put(TBL_ENCUESTA.COLUMN_NAME_DESCRIPCION_ENC, encuesta.get_descripcion_enc());
		values.put(TBL_ENCUESTA.COLUMN_NAME_FECH_PUB, encuesta.get_fech_pub());
		values.put(TBL_ENCUESTA.COLUMN_NAME_FECH_CONT, encuesta.get_fech_cont());
		values.put(TBL_ENCUESTA.COLUMN_NAME_TEXT_PREGUNTA, encuesta.get_text_pregunta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_TIPO_PREGUNTA, encuesta.get_tipo_pregunta());
		values.put(TBL_ENCUESTA.COLUMN_NAME_RESP_TEXTO, encuesta.get_resp_texto());
		values.put(TBL_ENCUESTA.COLUMN_NAME_RESP_NUMERO, encuesta.get_resp_numero());
		values.put(TBL_ENCUESTA.COLUMN_NAME_RESP_ELEGIDA, encuesta.get_resp_elegida());
		
		// Which row to update, based on the ID
		String selection = TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA + " LIKE ?";
		String[] selectionArgs = { String.valueOf(rowId) };

		int count = db.update(
		    TBL_ENCUESTA.TABLE_NAME,
		    values,
		    selection,
		    selectionArgs);
		
		return count;
	}
	
	public void print(){
		Log.i("NEFBBC", "print - inicio" );
		ArrayList<Encuesta> Encuestas = read();
		Log.i("NEFBBC", "print - registros = " + Encuestas.size());
		Iterator<Encuesta> myIterator = Encuestas.iterator();
		Log.i("NEFBBC", "print - iterator" );
		while(myIterator.hasNext()){
			Encuesta elemento = myIterator.next();
			Log.i("NEFBBC", "print - " + elemento.get_id_encuesta());
		}
		Log.i("NEFBBC", "print - while" );
	}
	
}
