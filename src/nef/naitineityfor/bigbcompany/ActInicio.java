package nef.naitineityfor.bigbcompany;



import nef.naitineityfor.bigbcompany.db.ContactosSQLite;
import nef.naitineityfor.bigbcompany.db.EncuestasSQLite;
import nef.naitineityfor.bigbcompany.db.MensajesSQLite;
import nef.naitineityfor.bigbcompany.db.NoticiasSQLite;
import nef.naitineityfor.bigbcompany.dbobjects.Contacto;
import nef.naitineityfor.bigbcompany.dbobjects.Encuesta;
import nef.naitineityfor.bigbcompany.dbobjects.Mensaje;
import nef.naitineityfor.bigbcompany.dbobjects.Noticia;
import nef.naityeityfor.bigbcompany.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ActInicio extends Activity {
	private AlertDialog.Builder dialogBuilder;

	/** Called when the user clicks the abrirMenu button */
	public void abrirActUsuario(View view) {
	    // Do something in response to button
		EditText txtUser = (EditText) findViewById(R.id.etUsuario);
		EditText txtPass = (EditText) findViewById(R.id.etPsw);
		String user= txtUser.getText().toString();
		String psw= txtPass.getText().toString();
		if(user.equals("Admin") && psw.equals("Compartamos")){
			dialogBuilder = new AlertDialog.Builder(this);
			dialogBuilder.setTitle("Accesos Correcto");
			dialogBuilder.setMessage("Bienvenido!!");
			AlertDialog dialogoF = dialogBuilder.create();
			dialogoF.show();
			Intent intent = new Intent(this, ActUsuario.class);
		    startActivity(intent);
			//Login Valido
		}else{
			dialogBuilder = new AlertDialog.Builder(this);
			dialogBuilder.setTitle("Accesos Incorrecto");
			dialogBuilder.setMessage("Usuario/Contrase�a incorrectos, por favor intenta de nuevo.");
			AlertDialog dialogoF = dialogBuilder.create();
			dialogoF.show();
			//Login Erroneo
		}
		
		
	    
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_inicio);
		initDB();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_inicio, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void initDB(){
		Log.i("NEFBBC", "Inicio de aplicaci�n" );
		ContactosSQLite TBL = new ContactosSQLite(this);
		Log.i("NEFBBC", "Se crea la instanacia BD" );
		Contacto c1 = new Contacto(1,"Ariadna Rosas Burgos","ariadna.rosas",".img");
		Contacto c2 = new Contacto(2,"Jesus Daniel Morales Rangel","jesus.morales",".img");
		Contacto c3 = new Contacto(3,"Jose Carmona Guerrero","jose.carmona",".img");
		Contacto c4 = new Contacto(4,"Juan Miguel Rivera Ortega","juan.rivera",".img");
		Contacto c5 = new Contacto(5,"Julio Cesar Castro P�rez","julio.castro",".img");
		Log.i("NEFBBC", "Se crean 5 contactos" );
		TBL.put(c1);
		TBL.put(c2);
		TBL.put(c3);
		TBL.put(c4);
		TBL.put(c5);
		Log.i("NEFBBC", "Se insertan los 5 contactos" );
		TBL.read();
		Log.i("NEFBBC", "Se leen los 5 contactos" );
		TBL.print();
		Log.i("NEFBBC", "Se imprimen los 5 contactos" );
		Contacto c6 = new Contacto(1,"Lizbeth Rayo Alfaro","lizbeth.rayo",".img");
		Contacto c7 = new Contacto(2,"Luis Valverde","luis.valverde",".img");
		Contacto c8 = new Contacto(3,"Mar�a Teresa Escobar Reyes","maria.escobar",".img");
		Contacto c9 = new Contacto(4,"Martha Cecilia Hernandez Ram�rez","martha.hernandez",".img");
		Contacto c10 = new Contacto(5,"Nancy Sofia Sobrado Villegas","nancy.sobrado",".img");
		TBL.put(c6);
		TBL.put(c7);
		TBL.put(c8);
		TBL.put(c9);
		TBL.put(c10);
		Log.i("NEFBBC", "Se insertan otros 5 contactos" );
		
		NoticiasSQLite TBL2 = new NoticiasSQLite(this);
		TBL2.put(new Noticia(1,"C�mo podemos generar electricidad al masticar","�Te imaginas poder recargar un peque�o dispositivo solo mascando chicle? Para eso hay que ajustarse una correa a la barbilla. Te contamos c�mo funciona el prototipo que acaban de presentar ingenieros canadienses.","imagen_not1", "00/00/00",233, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(2,"Gigante medi�tico acusa a Google de monopolio","El gigante medi�tico News Corp acus� a Google de abusar su posici�n dominante como el motor de b�squeda m�s popular de internet.","imagen_not2", "00/00/00",777, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(3,"5 ventajas y 5 desventajas del iPhone 6","Seg�n Apple, el iPhone 6 abre \"una nueva generaci�n de iPhone que es mejor, se mida como se mida\". Pero �qu� tiene de especial este tel�fono? y �qu� se le critica?","imagen_not3", "00/00/00",682, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(4,"La NASA selecciona los \"taxis\" espaciales del futuro","Para finales de 2017 ser�n naves de las compa��as privadas Boeing y SpaceX las que lleven al espacio a los astronautas de la NASA, la agencia espacial estadounidense.","imagen_not4", "00/00/00",481, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(5,"Yo, �una app revolucionaria o una tonter�a?","Una nueva app de mensajer�a est� acaparando miradas, elogios y cr�ticas. En nuestro blog de tecnolog�a les decimos de qu� se trata.","imagen_not5", "00/00/00",355, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(6,"�Es la impresi�n de casas el futuro de la construcci�n?","Dos tendencias est�n transformando la industria de la construcci�n: la cultura del \"hazlo t� mismo\" y la tecnolog�a de la impresi�n en 3D. �Qu� pasa cuando ambas se combinan?","imagen_not6", "00/00/00",896, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(7,"Por qu� hablar por m�vil en Argentina es casi imposible","A pesar de tener una de las mayores cantidades de celulares por habitante de la regi�n, el pa�s sudamericano es el que usa menos espectro radioel�ctrico, lo que dificulta la comunicaci�n.","imagen_not7", "00/00/00",924, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(8,"�Qu� pasar� con Minecraft en manos de Microsoft?","La multitudinaria comunidad de fans de Minecraft se mantiene a la expectativa ahora que su juego favorito pasa a depender del gigante inform�tico Microsoft. Temen perder la libertad y frescura que caracteriza al juego.","imagen_not8", "00/00/00",348, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(9,"Apple facilita herramienta para borrar el �lbum de U2","La banda irlandesa ofreci� su �litmo disco de forma gratuita en la plataforma musical de Apple pero algunos usuarios se quejaron de que se hab�a instalado en sus bibliotecas sin que dieran su permiso.","imagen_not9", "00/00/00",569, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(10,"10 datos para entender la magnitud de Alibaba","Pronto la marca china tendr� una exposici�n similar a la de otros gigantes globales del mundo de internet, como Facebook, Amazon o eBay. Le presentamos 10 datos curiosos para entender este fen�meno.","imagen_not10", "00/00/00",643, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(11,"Microsoft compra Minecraft por US$2.500 millones","El jefe de Xbox, Phil Spencer, anunci� que la negociaci�n se concret� este lunes. Minecraft ha vendido 54 millones de copias en todo el mundo.","imagen_not11", "00/00/00",155, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(12,"La v�a exclusiva para peatones adictos al tel�fono","El ayuntamiento de Chongqing, en China, delimit� con marcas en el suelo dos carriles o v�as separadas para los peatones, uno para quienes caminan con los ojos puestos en la pantalla y otro para los que no.","imagen_not12", "00/00/00",122, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(13,"Mundo Tecnol�gico: primer auto impreso en 3D","Crean en Chicago un carro con una impresora en 3D; Twitter y otros sitios web expresan su apoyo a la neutralidad de la red; Minecraft en la mira de Microsoft y tras de cinco a�os de trabajo llega el videojuego Destiny.","imagen_not13", "00/00/00",184, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(14,"Trucos para ser un as de la fotograf�a digital","�Desear�as que las fotos de tus vacaciones fueran m�s n�tidas, mejor enfocadas, m�s contrastadas? Exposici�n, apertura e iluminaci�n siguen siendo las claves de las buenas im�genes en la era de las c�maras digitales.","imagen_not14", "00/00/00",160, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(15,"El arte de miniaturizar la tecnolog�a","Ben Heck es un experto en inform�tica retro y se especializa en transformar consolas de videojuegos. Pero adem�s tiene un coraz�n sensible que nos abre al final de la nota.","imagen_not15", "00/00/00",111, "01/01/01", "02/02/02"));
		
		EncuestasSQLite TBL3 = new EncuestasSQLite(this);
		TBL3.put(new Encuesta(1,1,1,"Satisfacci�n del cliente","Las encuestas de satisfacci�n son el m�todo m�s econ�mico y eficiente de obtener informaci�n de los clientes. Hay muchos tipos de encuestas de satisfacci�n.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(2,1,1,"Clima laboral","El clima organizacional influye directamente en la productividad de la compa��a. Env�e una encuesta de clima bien planteada, estructurada y dise�ada.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(3,1,1,"Marketing y comunicaci�n","Conozca el comportamiento de sus clientes potenciales, realice un seguimiento de su competencia, mida el nivel de aceptaci�n de un nuevo producto/servicio.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(4,1,1,"RRHH y capacitaci�n","Automatice procesos complejos y olv�dese del papel. Utilice encuestas online para evaluaciones 360�, entrevistas de salida y evaluaciones de cursos de formaci�n.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(5,1,1,"P�ginas web y portales","Recoja la opinion de sus visitantes, de sus sucriptores o de sus fans en facebook. Personalice el aspecto de sus encuestas y h�galas interactivas con video, sonido e imagen.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(6,1,1,"Universidades y ONGs","e-encuesta.com cuenta con un gran n�mero de prestigiosas Universidades entre sus clientes. Universidades y ONGs disfrutan de descuentos especiales.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(7,1,1,"Evaluaci�n comunicaci�n interna","Por favor, dedique de 10 a 15 minutos a responder esta encuesta. Los resultados servir�n para mejorar la calidad de nuestro trabajo. Sus respuestas ser�n tratadas de forma CONFIDENCIAL Y AN�NIMA. Es importante que responda con sinceridad.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(8,1,1,"Lanzamiento de un nuevo servicio","Por favor rellene esta peque�a encuesta. La informaci�n que nos prorcione ser� utilizada para conocer el grado de aceptaci�n en el mercado de un nuevo servicio. La encuesta dura cinco minutos aproximadamente. Gracias.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(9,1,1,"Encuesta imagen marca","Por favor, valore cada una de estas marcas de acuerdo con su grado de Confianza","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(10,1,1,"Entrevista de salida","Por favor, dedique unos minutos a completar esta encuesta. La informaci�n obtenida servir� para entender los motivos de su baja en la empresa. Sus respuestas ser�n tratadas de forma CONFIDENCIAL Y AN�NIMA y ser�n analizadas de forma agregada.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(11,1,1,"Programa de Beneficios sociales","La siguiente encuesta le tomar� cinco minutos. La informaci�n que entregue permanecer� en el anonimato y sus respuestas ser�n estrictamente confidenciales. Agradecemos su sinceridad.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(12,1,1,"Evaluaci�n del candidato","Informaci�n sobre el candidato y sobre el puesto","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(13,1,1,"Satisfacci�n del cliente - Hospital","Por favor, dedique unos minutos a rellenar este cuestionario. Su opini�n es muy importante para mejorar nuestro servicio. Gracias","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(14,1,1,"Servicio de transporte","Por favor, dedique unos minutos a completar esta encuesta. Las informaci�n que nos proporcione servir� para mejorar el servicio.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(15,1,1,"Satisfacci�n del cliente - Hotel","Ay�danos a mejorar el servicio. Queremos ofrecerte los mejores hoteles. Por favor dedica 5 minutos a comletar esta encuesta. Graias","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		
		MensajesSQLite TBL4 = new MensajesSQLite(this);
		TBL4.put(new Mensaje(1,"adalberto.marin","silvia.cendejas","Hola. �Qu� deporte practic�is vosotros?","13:27","rec1-23:59"));
		TBL4.put(new Mensaje(2,"adalberto.marin","silvia.cendejas","Hola. Nosotros practicamos tenis y golf. �Vosotros practic�is tenis?","13:33","rec2-23:59"));
		TBL4.put(new Mensaje(3,"silvia.cendejas","adalberto.marin","No, no lo practicamos, pero practicamos golf. �Vuestros amigos practican golf?","13:38","rec3-23:59"));
		TBL4.put(new Mensaje(4,"adalberto.marin","silvia.cendejas","S�, lo practican. Juegan muy bien a golf. �Tal vez podr�amos practicar juntos golf alg�n d�a?","13:45","rec4-23:59"));
		TBL4.put(new Mensaje(5,"silvia.cendejas","adalberto.marin","Muy bien. Buena idea. �Qu� os parece el pr�ximo s�bado?","14:15","rec5-23:59"));
		TBL4.put(new Mensaje(6,"silvia.cendejas","adalberto.marin","Excelente.","14:20","rec6-23:59"));
		TBL4.put(new Mensaje(7,"silvia.cendejas","adalberto.marin","�Por fin es primavera!, ya llega el buen tiempo.","14:27","rec7-23:59"));
		TBL4.put(new Mensaje(8,"adalberto.marin","silvia.cendejas","Se acab� el fr�o y empiezan las alergias�","15:53","rec8-23:59"));
		TBL4.put(new Mensaje(9,"adalberto.marin","silvia.cendejas","�Tienes alergia?","11:02","rec9-23:59"));
		TBL4.put(new Mensaje(10,"silvia.cendejas","adalberto.marin","S�, en primavera no paro de estornudar.","11:10","rec10-23:59"));
		TBL4.put(new Mensaje(11,"adalberto.marin","silvia.cendejas","�Eso es horrible!","11:13","rec11-23:59"));
		TBL4.put(new Mensaje(12,"silvia.cendejas","adalberto.marin","S�, pero me gusta la primavera.","11:13","rec12-23:59"));
		TBL4.put(new Mensaje(13,"adalberto.marin","silvia.cendejas","�Es la estaci�n del amor!","11:17","rec13-23:59"));
		TBL4.put(new Mensaje(14,"adalberto.marin","silvia.cendejas","S�, adem�s ya est�n cerca las vacaciones de verano.","17:45","rec14-23:59"));
		TBL4.put(new Mensaje(15,"silvia.cendejas","adalberto.marin","�D�nde estabas ayer por la noche?","17:56","rec15-23:59"));
		TBL4.put(new Mensaje(16,"adalberto.marin","silvia.cendejas","Estaba en casa de mi madre.","18:03","rec16-23:59"));
		TBL4.put(new Mensaje(17,"silvia.cendejas","adalberto.marin","No, no estabas ah�. Estabas en un bar con tus amigos. Yo estaba con mi amiga Ana y os vimos.","17:23","rec17-23:59"));
	}
}
