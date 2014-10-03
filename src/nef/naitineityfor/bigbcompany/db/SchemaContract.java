package nef.naitineityfor.bigbcompany.db;

import android.provider.BaseColumns;

public class SchemaContract {

	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public SchemaContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TBL_CONTACTO implements BaseColumns {
        public static final String TABLE_NAME = "tbl_contacto";
        public static final String COLUMN_NAME_ID_CONTACTO = "id_contacto";
        public static final String COLUMN_NAME_NOMBRE_CONTACTO = "nombre_contacto";
        public static final String COLUMN_NAME_EMAIL_CONTACTO = "email_contacto";
        public static final String COLUMN_NAME_IMG_CONTACTO = "img_contacto";
        //...
    }
	
    public static abstract class TBL_NOTICIA implements BaseColumns {
        public static final String TABLE_NAME = "tbl_noticia";
        public static final String COLUMN_NAME_ID_NOTICIA = "id_noticia";
        public static final String COLUMN_NAME_TITULO_NOT = "titulo_not";
        public static final String COLUMN_NAME_CONTENIDO_NOT = "contenido_not";
        public static final String COLUMN_NAME_IMAGEN_NOT = "imagen_not";
        public static final String COLUMN_NAME_FECH_PUB = "fech_pub";
        public static final String COLUMN_NAME_CANT_LIKES = "cant_likes";
        public static final String COLUMN_NAME_FECH_LEC = "fech_lec";
        public static final String COLUMN_NAME_FECH_LIKE = "fech_like";
        //...
    }
    
    public static abstract class TBL_MENSAJE implements BaseColumns {
        public static final String TABLE_NAME = "tbl_mensaje";
        public static final String COLUMN_NAME_ID_MENSAJE = "id_mensaje";
        public static final String COLUMN_NAME_EMAIL_REMITENTE = "email_remitente";
        public static final String COLUMN_NAME_EMAIL_DESTINATARIO = "email_destinatario";
        public static final String COLUMN_NAME_CONT_MENSAJE = "cont_mensaje";
        public static final String COLUMN_NAME_ENVIADO = "enviado";
        public static final String COLUMN_NAME_RECIBIDO = "rebido";
        //...
    }
    
    public static abstract class TBL_ENCUESTA implements BaseColumns {
        public static final String TABLE_NAME = "tbl_encuesta";
        public static final String COLUMN_NAME_ID_ENCUESTA = "id_encuesta";
        public static final String COLUMN_NAME_ID_PREGUNTA = "id_pregunta";
        public static final String COLUMN_NAME_ID_RESPUESTA = "id_respuesta";
        public static final String COLUMN_NAME_TITULO_ENC = "titulo_enc";
        public static final String COLUMN_NAME_DESCRIPCION_ENC = "descripcion_enc";
        public static final String COLUMN_NAME_FECH_PUB = "fech_pub";
        public static final String COLUMN_NAME_FECH_CONT = "fech_const";
        public static final String COLUMN_NAME_TEXT_PREGUNTA = "text_pregunta";
        public static final String COLUMN_NAME_TIPO_PREGUNTA = "tipo_pregunta";
        public static final String COLUMN_NAME_TIPO_RESP = "tipo_resp";
        public static final String COLUMN_NAME_RESP_TEXTO = "resp_texto";
        public static final String COLUMN_NAME_RESP_NUMERO = "resp_numero";
        public static final String COLUMN_NAME_RESP_ELEGIDA = "resp_elegida";
        //...
    }
}
