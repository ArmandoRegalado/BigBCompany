package nef.naitineityfor.bigbcompany.desc;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.aa.EncuestasArrayAdapter;
import nef.naitineityfor.bigbcompany.aa.NoticiasArrayAdapter;
import nef.naitineityfor.bigbcompany.db.EncuestasSQLite;
import nef.naitineityfor.bigbcompany.db.NoticiasSQLite;
import nef.naitineityfor.bigbcompany.dbobjects.Encuesta;
import nef.naitineityfor.bigbcompany.dbobjects.Noticia;
import nef.naityeityfor.bigbcompany.R;
import nef.naityeityfor.bigbcompany.R.id;
import nef.naityeityfor.bigbcompany.R.layout;
import nef.naityeityfor.bigbcompany.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class ActDescEncuesta extends Activity {

	private TextView textViewTitulo;
	private TextView textViewContenido;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_desc_encuenta);
		
		
		//Referencia a los elementos del layaut
		textViewTitulo = (TextView) findViewById( R.id.txtTituloEncuesta);
		textViewContenido = (TextView) findViewById( R.id.txtContEncuest);
		ListView listView = (ListView) findViewById(R.id.encuestasListView);
		
		Log.i("SELECT","----------ENTRAMOS A LA DESCRIPCIÓN---------");
		
		
		// Construct the data source
		EncuestasSQLite TBL = new EncuestasSQLite(this);
		ArrayList<Encuesta> arrayOfEncuestas = TBL.read();
		// Create the adapter to convert the array to views
		EncuestasArrayAdapter adapter = new EncuestasArrayAdapter(this, arrayOfEncuestas);
				
		//Obteniendo parametros de paso de actividad
		Intent intent = getIntent();
		Bundle bundle = new Bundle();
		bundle = intent.getExtras();
		
		Encuesta encuesta = adapter.getItem(bundle.getInt("id"));
		String titulo = encuesta.get_titulo_enc();
		String descripcion = encuesta.get_descripcion_enc();
		
		textViewTitulo.setTextSize(15);
		textViewTitulo.setText( titulo );
		
		//textViewContenido.setTextSize(15);
		textViewContenido.setText( descripcion );		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_desc_encuenta, menu);
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
}
