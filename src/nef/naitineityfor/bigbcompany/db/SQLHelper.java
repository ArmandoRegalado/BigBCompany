package nef.naitineityfor.bigbcompany.db;

import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_CONTACTO;
import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_ENCUESTA;
import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_MENSAJE;
import nef.naitineityfor.bigbcompany.db.SchemaContract.TBL_NOTICIA;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class SQLHelper extends SQLiteOpenHelper {

	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_CONTACTO =
	    "CREATE TABLE " + TBL_CONTACTO.TABLE_NAME + " (" +
	    TBL_CONTACTO._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
	    TBL_CONTACTO.COLUMN_NAME_ID_CONTACTO + INTEGER_TYPE + COMMA_SEP +
	    TBL_CONTACTO.COLUMN_NAME_NOMBRE_CONTACTO + TEXT_TYPE + COMMA_SEP +
	    TBL_CONTACTO.COLUMN_NAME_EMAIL_CONTACTO + TEXT_TYPE + COMMA_SEP +
	    TBL_CONTACTO.COLUMN_NAME_IMG_CONTACTO + TEXT_TYPE +
	    //... // Any other options for the CREATE command
	    " )";
	
	private static final String SQL_CREATE_NOTICIA =
		    "CREATE TABLE " + TBL_NOTICIA.TABLE_NAME + " (" +
		    TBL_NOTICIA._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
		    TBL_NOTICIA.COLUMN_NAME_ID_NOTICIA + INTEGER_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_TITULO_NOT + TEXT_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_CONTENIDO_NOT + TEXT_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_IMAGEN_NOT + TEXT_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_FECH_PUB + TEXT_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_CANT_LIKES + INTEGER_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_FECH_LEC + TEXT_TYPE + COMMA_SEP +
		    TBL_NOTICIA.COLUMN_NAME_FECH_LIKE + TEXT_TYPE +
		    //... // Any other options for the CREATE command
		    " )";
	
	private static final String SQL_CREATE_MENSAJE =
		    "CREATE TABLE " + TBL_MENSAJE.TABLE_NAME + " (" +
		    TBL_MENSAJE._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
		    TBL_MENSAJE.COLUMN_NAME_ID_MENSAJE + INTEGER_TYPE + COMMA_SEP +
		    TBL_MENSAJE.COLUMN_NAME_EMAIL_REMITENTE + TEXT_TYPE + COMMA_SEP +
		    TBL_MENSAJE.COLUMN_NAME_EMAIL_DESTINATARIO + TEXT_TYPE + COMMA_SEP +
   		    TBL_MENSAJE.COLUMN_NAME_CONT_MENSAJE + TEXT_TYPE + COMMA_SEP +
		    TBL_MENSAJE.COLUMN_NAME_ENVIADO + TEXT_TYPE + COMMA_SEP +
		    TBL_MENSAJE.COLUMN_NAME_RECIBIDO + TEXT_TYPE +
		    //... // Any other options for the CREATE command
		    " )";
	
	private static final String SQL_CREATE_ENCUESTA =
		    "CREATE TABLE " + TBL_ENCUESTA.TABLE_NAME + " (" +
		    TBL_ENCUESTA._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
		    TBL_ENCUESTA.COLUMN_NAME_ID_ENCUESTA + INTEGER_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_ID_PREGUNTA + INTEGER_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_ID_RESPUESTA + INTEGER_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_TITULO_ENC + TEXT_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_DESCRIPCION_ENC + TEXT_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_FECH_PUB + TEXT_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_FECH_CONT + TEXT_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_TEXT_PREGUNTA + TEXT_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_TIPO_PREGUNTA + INTEGER_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_TIPO_RESP + INTEGER_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_RESP_TEXTO + TEXT_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_RESP_NUMERO + INTEGER_TYPE + COMMA_SEP +
		    TBL_ENCUESTA.COLUMN_NAME_RESP_ELEGIDA + INTEGER_TYPE +
		    //... // Any other options for the CREATE command
		    " )";

	private static final String SQL_DELETE_CONTACTO =
	    "DROP TABLE IF EXISTS " + TBL_CONTACTO.TABLE_NAME;
	
	private static final String SQL_DELETE_NOTICIA =
		    "DROP TABLE IF EXISTS " + TBL_NOTICIA.TABLE_NAME;
	
	private static final String SQL_DELETE_MENSAJE =
		    "DROP TABLE IF EXISTS " + TBL_MENSAJE.TABLE_NAME;
	
	private static final String SQL_DELETE_ENCUESTA =
		    "DROP TABLE IF EXISTS " + TBL_ENCUESTA.TABLE_NAME;
	
	public SQLHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public SQLHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}
	
	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "nefbbc.db";
    
    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_CONTACTO);
		db.execSQL(SQL_CREATE_NOTICIA);
		db.execSQL(SQL_CREATE_MENSAJE);
		db.execSQL(SQL_CREATE_ENCUESTA);
		Log.i("SQLite", "Se crea la base de datos " + DATABASE_NAME + " version " + DATABASE_VERSION );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
		Log.i("SQLite", "Control de versiones: Old Version=" + oldVersion + " New Version= " + newVersion  );
        db.execSQL(SQL_DELETE_CONTACTO);
        db.execSQL(SQL_DELETE_NOTICIA);
        db.execSQL(SQL_DELETE_MENSAJE);
        db.execSQL(SQL_DELETE_ENCUESTA);
        onCreate(db);
        Log.i("SQLite", "Se actualiza versión de la base de datos, New version= " + newVersion  );
	}
	
}

