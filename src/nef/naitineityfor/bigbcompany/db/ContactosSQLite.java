package nef.naitineityfor.bigbcompany.db;

import java.util.ArrayList;
import java.util.Iterator;

import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_CONTACTO;
import nef.naitineityfor.bigbcompany.dbobjects.Contacto;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ContactosSQLite {

	 SQLHelper mDbHelper;
	 SQLiteDatabase db;

	 /** Constructor de clase */
	 public ContactosSQLite(Context context) {
		 mDbHelper = new SQLHelper( context );
	 }
	
	//Put, Read, Delete and Update info
	
	public long put(Contacto contacto){
		Log.i("NEFBBC", "put - entra" );
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		Log.i("NEFBBC", "put - db" );
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO, contacto.get_id());
		values.put(TBL_CONTACTO.COLUMN_NAME_NOMBRE_CONTACTO, contacto.get_nombre());
		values.put(TBL_CONTACTO.COLUMN_NAME_EMAIL_CONTACTO, contacto.get_email());
		values.put(TBL_CONTACTO.COLUMN_NAME_IMG_CONTACTO, contacto.get_img());
		Log.i("NEFBBC", "put - content values" );
		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
				 TBL_CONTACTO.TABLE_NAME,
				 null,//TBL_USR.COLUMN_NAME_NULLABLE,
		         values);
		Log.i("NEFBBC", "put - newRowId" );
		return newRowId;
	}
	
	public ArrayList<Contacto> read(){

		ArrayList<Contacto> Contactos = null;
		Log.i("NEFBBC", "read - entra" );
		db = mDbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
			TBL_CONTACTO._ID,
			TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO,
			TBL_CONTACTO.COLUMN_NAME_NOMBRE_CONTACTO,
			TBL_CONTACTO.COLUMN_NAME_EMAIL_CONTACTO,
			TBL_CONTACTO.COLUMN_NAME_IMG_CONTACTO,
		    //...
		    };
		Log.i("NEFBBC", "read - projection" );
		// How you want the results sorted in the resulting Cursor
		String sortOrder =
		    TBL_CONTACTO.COLUMN_NAME_EMAIL_CONTACTO + " DESC";
		Log.i("NEFBBC", "read - order" );
		Cursor c = db.query(
		    TBL_CONTACTO.TABLE_NAME,  // The table to query
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
			Contactos = new ArrayList <Contacto>();
			Log.i("NEFBBC", "read - first" );
		    do{
				long itemId = c.getLong(c.getColumnIndexOrThrow(TBL_CONTACTO._ID));
				long id_contacto = c.getLong(c.getColumnIndexOrThrow(TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO));
				String nombre_contacto = c.getString(c.getColumnIndexOrThrow(TBL_CONTACTO.COLUMN_NAME_NOMBRE_CONTACTO));
				String email_contacto = c.getString(c.getColumnIndexOrThrow(TBL_CONTACTO.COLUMN_NAME_EMAIL_CONTACTO));
				String img_contacto = c.getString(c.getColumnIndexOrThrow(TBL_CONTACTO.COLUMN_NAME_IMG_CONTACTO));
				Log.i("NEFBBC", "read - usr " + itemId + id_contacto + nombre_contacto + email_contacto + img_contacto);
				
				Contactos.add(new Contacto(id_contacto, nombre_contacto, email_contacto, img_contacto));
				
		    }while( c.moveToNext() );
		   }
		
		return Contactos;
	}
	
	public void delete(String rowId){
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		// Define 'where' part of query.
		String selection = TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO + " LIKE ?";
		// Specify arguments in placeholder order.
		String[] selectionArgs = { String.valueOf(rowId) };
		// Issue SQL statement.
		db.delete(TBL_CONTACTO.TABLE_NAME, selection, selectionArgs);
	}
	
	public int update(String rowId, Contacto contacto){
		db = mDbHelper.getReadableDatabase();

		// New value for one column
		ContentValues values = new ContentValues();
		values.put(TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO, contacto.get_id());
		values.put(TBL_CONTACTO.COLUMN_NAME_NOMBRE_CONTACTO, contacto.get_nombre());
		values.put(TBL_CONTACTO.COLUMN_NAME_EMAIL_CONTACTO, contacto.get_email());
		values.put(TBL_CONTACTO.COLUMN_NAME_IMG_CONTACTO, contacto.get_img());

		// Which row to update, based on the ID
		String selection = TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO + " LIKE ?";
		String[] selectionArgs = { String.valueOf(rowId) };

		int count = db.update(
		    TBL_CONTACTO.TABLE_NAME,
		    values,
		    selection,
		    selectionArgs);
		
		return count;
	}
	
	public void print(){
		Log.i("NEFBBC", "print - inicio" );
		ArrayList<Contacto> Contactos = read();
		Log.i("NEFBBC", "print - registros = " + Contactos.size());
		Iterator<Contacto> myIterator = Contactos.iterator();
		Log.i("NEFBBC", "print - iterator" );
		while(myIterator.hasNext()){
			Contacto elemento = myIterator.next();
			Log.i("NEFBBC", "print - " + elemento.get_id() + elemento.get_nombre() + elemento.get_email() + elemento.get_img());
		}
		Log.i("NEFBBC", "print - while" );
	}
	
}
