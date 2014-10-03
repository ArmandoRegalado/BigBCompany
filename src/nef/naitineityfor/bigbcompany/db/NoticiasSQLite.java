package nef.naitineityfor.bigbcompany.db;

import java.util.ArrayList;
import java.util.Iterator;

import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_NOTICIA;
import nef.naitineityfor.bigbcompany.dbobjects.Noticia;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class NoticiasSQLite {

	 SQLHelper mDbHelper;
	 SQLiteDatabase db;

	 /** Constructor de clase */
	 public NoticiasSQLite(Context context) {
		 mDbHelper = new SQLHelper( context );
	 }
	
	//Put, Read, Delete and Update info
	
	public long put(Noticia noticia){
		Log.i("NEFBBC", "put - entra" );
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		Log.i("NEFBBC", "put - db" );
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA, noticia.get_id());
		values.put(TBL_NOTICIA.COLUMN_NAME_TITULO_NOT, noticia.get_titulo_not());
		values.put(TBL_NOTICIA.COLUMN_NAME_CONTENIDO_NOT, noticia.get_contenido_not());
		values.put(TBL_NOTICIA.COLUMN_NAME_IMAGEN_NOT, noticia.get_imagen_not());
		values.put(TBL_NOTICIA.COLUMN_NAME_FECH_PUB, noticia.get_fech_pub());
		values.put(TBL_NOTICIA.COLUMN_NAME_CANT_LIKES, noticia.get_cant_likes());
		values.put(TBL_NOTICIA.COLUMN_NAME_FECH_LEC, noticia.get_fech_lec());
		values.put(TBL_NOTICIA.COLUMN_NAME_FECH_LIKE, noticia.get_fech_like());
		Log.i("NEFBBC", "put - content values" );
		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
				 TBL_NOTICIA.TABLE_NAME,
				 null,//TBL_USR.COLUMN_NAME_NULLABLE,
		         values);
		Log.i("NEFBBC", "put - newRowId" );
		return newRowId;
	}
	
	public ArrayList<Noticia> read(){

		ArrayList<Noticia> Noticias = null;
		Log.i("NEFBBC", "read - entra" );
		db = mDbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
			TBL_NOTICIA._ID,
			TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA,
			TBL_NOTICIA.COLUMN_NAME_TITULO_NOT,
			TBL_NOTICIA.COLUMN_NAME_CONTENIDO_NOT,
			TBL_NOTICIA.COLUMN_NAME_IMAGEN_NOT,
			TBL_NOTICIA.COLUMN_NAME_FECH_PUB,
			TBL_NOTICIA.COLUMN_NAME_CANT_LIKES,
			TBL_NOTICIA.COLUMN_NAME_FECH_LEC,
			TBL_NOTICIA.COLUMN_NAME_FECH_LIKE,
		    //...
		    };
		Log.i("NEFBBC", "read - projection" );
		// How you want the results sorted in the resulting Cursor
		String sortOrder =
		    TBL_NOTICIA.COLUMN_NAME_FECH_PUB + " DESC";
		Log.i("NEFBBC", "read - order" );
		Cursor c = db.query(
		    TBL_NOTICIA.TABLE_NAME,  // The table to query
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
			Noticias = new ArrayList <Noticia>();
			Log.i("NEFBBC", "read - first" );
		    do{
				long itemId = c.getLong(c.getColumnIndexOrThrow(TBL_NOTICIA._ID));
				long id_noticia = c.getLong(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA));
				String titulo_not = c.getString(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_TITULO_NOT));
				String contenido_not = c.getString(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_CONTENIDO_NOT));
				String imagen_not = c.getString(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_IMAGEN_NOT));
				String fech_pub = c.getString(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_FECH_PUB));
				Integer cant_likes = c.getInt(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_CANT_LIKES));
				String fech_lec = c.getString(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_FECH_LEC));
				String fech_like = c.getString(c.getColumnIndexOrThrow(TBL_NOTICIA.COLUMN_NAME_FECH_LIKE));
				
				Noticias.add(new Noticia(id_noticia, titulo_not, contenido_not, imagen_not, fech_pub, cant_likes, fech_lec, fech_like));
				Log.i("NEFBBC", "read - add " + itemId);
				
		    }while( c.moveToNext() );
		   }
		
		return Noticias;
	}
	
	public void delete(String rowId){
		// Gets the data repository in write mode
		db = mDbHelper.getWritableDatabase();
		// Define 'where' part of query.
		String selection = TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA + " LIKE ?";
		// Specify arguments in placeholder order.
		String[] selectionArgs = { String.valueOf(rowId) };
		// Issue SQL statement.
		db.delete(TBL_NOTICIA.TABLE_NAME, selection, selectionArgs);
	}
	
	public int update(String rowId, Noticia noticia){
		db = mDbHelper.getReadableDatabase();

		// New value for one column
		ContentValues values = new ContentValues();
		values.put(TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA, noticia.get_id());
		values.put(TBL_NOTICIA.COLUMN_NAME_TITULO_NOT, noticia.get_titulo_not());
		values.put(TBL_NOTICIA.COLUMN_NAME_CONTENIDO_NOT, noticia.get_contenido_not());
		values.put(TBL_NOTICIA.COLUMN_NAME_IMAGEN_NOT, noticia.get_imagen_not());
		values.put(TBL_NOTICIA.COLUMN_NAME_FECH_PUB, noticia.get_fech_pub());
		values.put(TBL_NOTICIA.COLUMN_NAME_CANT_LIKES, noticia.get_cant_likes());
		values.put(TBL_NOTICIA.COLUMN_NAME_FECH_LEC, noticia.get_fech_lec());
		values.put(TBL_NOTICIA.COLUMN_NAME_FECH_LIKE, noticia.get_fech_like());

		// Which row to update, based on the ID
		String selection = TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA + " LIKE ?";
		String[] selectionArgs = { String.valueOf(rowId) };

		int count = db.update(
		    TBL_NOTICIA.TABLE_NAME,
		    values,
		    selection,
		    selectionArgs);
		
		return count;
	}
	
	public void print(){
		Log.i("NEFBBC", "print - inicio" );
		ArrayList<Noticia> Noticias = read();
		Log.i("NEFBBC", "print - registros = " + Noticias.size());
		Iterator<Noticia> myIterator = Noticias.iterator();
		Log.i("NEFBBC", "print - iterator" );
		while(myIterator.hasNext()){
			Noticia elemento = myIterator.next();
			Log.i("NEFBBC", "print - " + elemento.get_id());
		}
		Log.i("NEFBBC", "print - while" );
	}
	
}
