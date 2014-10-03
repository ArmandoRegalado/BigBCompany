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
			dialogBuilder.setMessage("Usuario/Contraseña incorrectos, por favor intenta de nuevo.");
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
		Log.i("NEFBBC", "Inicio de aplicación" );
		ContactosSQLite TBL = new ContactosSQLite(this);
		Log.i("NEFBBC", "Se crea la instanacia BD" );
		Contacto c1 = new Contacto(1,"Ariadna Rosas Burgos","ariadna.rosas",".img");
		Contacto c2 = new Contacto(2,"Jesus Daniel Morales Rangel","jesus.morales",".img");
		Contacto c3 = new Contacto(3,"Jose Carmona Guerrero","jose.carmona",".img");
		Contacto c4 = new Contacto(4,"Juan Miguel Rivera Ortega","juan.rivera",".img");
		Contacto c5 = new Contacto(5,"Julio Cesar Castro Pérez","julio.castro",".img");
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
		Contacto c8 = new Contacto(3,"María Teresa Escobar Reyes","maria.escobar",".img");
		Contacto c9 = new Contacto(4,"Martha Cecilia Hernandez Ramírez","martha.hernandez",".img");
		Contacto c10 = new Contacto(5,"Nancy Sofia Sobrado Villegas","nancy.sobrado",".img");
		TBL.put(c6);
		TBL.put(c7);
		TBL.put(c8);
		TBL.put(c9);
		TBL.put(c10);
		Log.i("NEFBBC", "Se insertan otros 5 contactos" );
		
		NoticiasSQLite TBL2 = new NoticiasSQLite(this);
		TBL2.put(new Noticia(1,"Cómo podemos generar electricidad al masticar","¿Te imaginas poder recargar un pequeño dispositivo solo mascando chicle? Para eso hay que ajustarse una correa a la barbilla. Te contamos cómo funciona el prototipo que acaban de presentar ingenieros canadienses.","imagen_not1", "00/00/00",233, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(2,"Gigante mediático acusa a Google de monopolio","El gigante mediático News Corp acusó a Google de abusar su posición dominante como el motor de búsqueda más popular de internet.","imagen_not2", "00/00/00",777, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(3,"5 ventajas y 5 desventajas del iPhone 6","Según Apple, el iPhone 6 abre \"una nueva generación de iPhone que es mejor, se mida como se mida\". Pero ¿qué tiene de especial este teléfono? y ¿qué se le critica?","imagen_not3", "00/00/00",682, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(4,"La NASA selecciona los \"taxis\" espaciales del futuro","Para finales de 2017 serán naves de las compañías privadas Boeing y SpaceX las que lleven al espacio a los astronautas de la NASA, la agencia espacial estadounidense.","imagen_not4", "00/00/00",481, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(5,"Yo, ¿una app revolucionaria o una tontería?","Una nueva app de mensajería está acaparando miradas, elogios y críticas. En nuestro blog de tecnología les decimos de qué se trata.","imagen_not5", "00/00/00",355, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(6,"¿Es la impresión de casas el futuro de la construcción?","Dos tendencias están transformando la industria de la construcción: la cultura del \"hazlo tú mismo\" y la tecnología de la impresión en 3D. ¿Qué pasa cuando ambas se combinan?","imagen_not6", "00/00/00",896, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(7,"Por qué hablar por móvil en Argentina es casi imposible","A pesar de tener una de las mayores cantidades de celulares por habitante de la región, el país sudamericano es el que usa menos espectro radioeléctrico, lo que dificulta la comunicación.","imagen_not7", "00/00/00",924, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(8,"¿Qué pasará con Minecraft en manos de Microsoft?","La multitudinaria comunidad de fans de Minecraft se mantiene a la expectativa ahora que su juego favorito pasa a depender del gigante informático Microsoft. Temen perder la libertad y frescura que caracteriza al juego.","imagen_not8", "00/00/00",348, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(9,"Apple facilita herramienta para borrar el álbum de U2","La banda irlandesa ofreció su úlitmo disco de forma gratuita en la plataforma musical de Apple pero algunos usuarios se quejaron de que se había instalado en sus bibliotecas sin que dieran su permiso.","imagen_not9", "00/00/00",569, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(10,"10 datos para entender la magnitud de Alibaba","Pronto la marca china tendrá una exposición similar a la de otros gigantes globales del mundo de internet, como Facebook, Amazon o eBay. Le presentamos 10 datos curiosos para entender este fenómeno.","imagen_not10", "00/00/00",643, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(11,"Microsoft compra Minecraft por US$2.500 millones","El jefe de Xbox, Phil Spencer, anunció que la negociación se concretó este lunes. Minecraft ha vendido 54 millones de copias en todo el mundo.","imagen_not11", "00/00/00",155, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(12,"La vía exclusiva para peatones adictos al teléfono","El ayuntamiento de Chongqing, en China, delimitó con marcas en el suelo dos carriles o vías separadas para los peatones, uno para quienes caminan con los ojos puestos en la pantalla y otro para los que no.","imagen_not12", "00/00/00",122, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(13,"Mundo Tecnológico: primer auto impreso en 3D","Crean en Chicago un carro con una impresora en 3D; Twitter y otros sitios web expresan su apoyo a la neutralidad de la red; Minecraft en la mira de Microsoft y tras de cinco años de trabajo llega el videojuego Destiny.","imagen_not13", "00/00/00",184, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(14,"Trucos para ser un as de la fotografía digital","¿Desearías que las fotos de tus vacaciones fueran más nítidas, mejor enfocadas, más contrastadas? Exposición, apertura e iluminación siguen siendo las claves de las buenas imágenes en la era de las cámaras digitales.","imagen_not14", "00/00/00",160, "01/01/01", "02/02/02"));
		TBL2.put(new Noticia(15,"El arte de miniaturizar la tecnología","Ben Heck es un experto en informática retro y se especializa en transformar consolas de videojuegos. Pero además tiene un corazón sensible que nos abre al final de la nota.","imagen_not15", "00/00/00",111, "01/01/01", "02/02/02"));
		
		EncuestasSQLite TBL3 = new EncuestasSQLite(this);
		TBL3.put(new Encuesta(1,1,1,"Satisfacción del cliente","Las encuestas de satisfacción son el método más económico y eficiente de obtener información de los clientes. Hay muchos tipos de encuestas de satisfacción.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(2,1,1,"Clima laboral","El clima organizacional influye directamente en la productividad de la compañía. Envíe una encuesta de clima bien planteada, estructurada y diseñada.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(3,1,1,"Marketing y comunicación","Conozca el comportamiento de sus clientes potenciales, realice un seguimiento de su competencia, mida el nivel de aceptación de un nuevo producto/servicio.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(4,1,1,"RRHH y capacitación","Automatice procesos complejos y olvídese del papel. Utilice encuestas online para evaluaciones 360º, entrevistas de salida y evaluaciones de cursos de formación.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(5,1,1,"Páginas web y portales","Recoja la opinion de sus visitantes, de sus sucriptores o de sus fans en facebook. Personalice el aspecto de sus encuestas y hágalas interactivas con video, sonido e imagen.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(6,1,1,"Universidades y ONGs","e-encuesta.com cuenta con un gran número de prestigiosas Universidades entre sus clientes. Universidades y ONGs disfrutan de descuentos especiales.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(7,1,1,"Evaluación comunicación interna","Por favor, dedique de 10 a 15 minutos a responder esta encuesta. Los resultados servirán para mejorar la calidad de nuestro trabajo. Sus respuestas serán tratadas de forma CONFIDENCIAL Y ANÓNIMA. Es importante que responda con sinceridad.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(8,1,1,"Lanzamiento de un nuevo servicio","Por favor rellene esta pequeña encuesta. La información que nos prorcione será utilizada para conocer el grado de aceptación en el mercado de un nuevo servicio. La encuesta dura cinco minutos aproximadamente. Gracias.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(9,1,1,"Encuesta imagen marca","Por favor, valore cada una de estas marcas de acuerdo con su grado de Confianza","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(10,1,1,"Entrevista de salida","Por favor, dedique unos minutos a completar esta encuesta. La información obtenida servirá para entender los motivos de su baja en la empresa. Sus respuestas serán tratadas de forma CONFIDENCIAL Y ANÓNIMA y serán analizadas de forma agregada.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(11,1,1,"Programa de Beneficios sociales","La siguiente encuesta le tomará cinco minutos. La información que entregue permanecerá en el anonimato y sus respuestas serán estrictamente confidenciales. Agradecemos su sinceridad.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(12,1,1,"Evaluación del candidato","Información sobre el candidato y sobre el puesto","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(13,1,1,"Satisfacción del cliente - Hospital","Por favor, dedique unos minutos a rellenar este cuestionario. Su opinión es muy importante para mejorar nuestro servicio. Gracias","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(14,1,1,"Servicio de transporte","Por favor, dedique unos minutos a completar esta encuesta. Las información que nos proporcione servirá para mejorar el servicio.","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		TBL3.put(new Encuesta(15,1,1,"Satisfacción del cliente - Hotel","Ayúdanos a mejorar el servicio. Queremos ofrecerte los mejores hoteles. Por favor dedica 5 minutos a comletar esta encuesta. Graias","fech_pub","fech_cont","text_pregunta",1,1,"resp_texto", 1,1));
		
		MensajesSQLite TBL4 = new MensajesSQLite(this);
		TBL4.put(new Mensaje(1,"adalberto.marin","silvia.cendejas","Hola. ¿Qué deporte practicáis vosotros?","13:27","rec1-23:59"));
		TBL4.put(new Mensaje(2,"adalberto.marin","silvia.cendejas","Hola. Nosotros practicamos tenis y golf. ¿Vosotros practicáis tenis?","13:33","rec2-23:59"));
		TBL4.put(new Mensaje(3,"silvia.cendejas","adalberto.marin","No, no lo practicamos, pero practicamos golf. ¿Vuestros amigos practican golf?","13:38","rec3-23:59"));
		TBL4.put(new Mensaje(4,"adalberto.marin","silvia.cendejas","Sí, lo practican. Juegan muy bien a golf. ¿Tal vez podríamos practicar juntos golf algún día?","13:45","rec4-23:59"));
		TBL4.put(new Mensaje(5,"silvia.cendejas","adalberto.marin","Muy bien. Buena idea. ¿Qué os parece el próximo sábado?","14:15","rec5-23:59"));
		TBL4.put(new Mensaje(6,"silvia.cendejas","adalberto.marin","Excelente.","14:20","rec6-23:59"));
		TBL4.put(new Mensaje(7,"silvia.cendejas","adalberto.marin","¡Por fin es primavera!, ya llega el buen tiempo.","14:27","rec7-23:59"));
		TBL4.put(new Mensaje(8,"adalberto.marin","silvia.cendejas","Se acabó el frío y empiezan las alergias…","15:53","rec8-23:59"));
		TBL4.put(new Mensaje(9,"adalberto.marin","silvia.cendejas","¿Tienes alergia?","11:02","rec9-23:59"));
		TBL4.put(new Mensaje(10,"silvia.cendejas","adalberto.marin","Sí, en primavera no paro de estornudar.","11:10","rec10-23:59"));
		TBL4.put(new Mensaje(11,"adalberto.marin","silvia.cendejas","¡Eso es horrible!","11:13","rec11-23:59"));
		TBL4.put(new Mensaje(12,"silvia.cendejas","adalberto.marin","Sí, pero me gusta la primavera.","11:13","rec12-23:59"));
		TBL4.put(new Mensaje(13,"adalberto.marin","silvia.cendejas","¡Es la estación del amor!","11:17","rec13-23:59"));
		TBL4.put(new Mensaje(14,"adalberto.marin","silvia.cendejas","Sí, además ya están cerca las vacaciones de verano.","17:45","rec14-23:59"));
		TBL4.put(new Mensaje(15,"silvia.cendejas","adalberto.marin","¿Dónde estabas ayer por la noche?","17:56","rec15-23:59"));
		TBL4.put(new Mensaje(16,"adalberto.marin","silvia.cendejas","Estaba en casa de mi madre.","18:03","rec16-23:59"));
		TBL4.put(new Mensaje(17,"silvia.cendejas","adalberto.marin","No, no estabas ahí. Estabas en un bar con tus amigos. Yo estaba con mi amiga Ana y os vimos.","17:23","rec17-23:59"));
	}
}
