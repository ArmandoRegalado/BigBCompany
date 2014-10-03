package nef.naitineityfor.bigbcompany.desc;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.ActNoticias;
import nef.naitineityfor.bigbcompany.aa.NoticiasArrayAdapter;
import nef.naitineityfor.bigbcompany.db.NoticiasSQLite;
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

public class ActDescNoticia extends Activity {
	
	private TextView textViewTitulo;
	private TextView textViewContenido;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_desc_noticia);
		
		//Referencia a los elementos del layaut
		textViewTitulo = (TextView) findViewById( R.id.txtTituloNoticia);
		textViewContenido = (TextView) findViewById( R.id.txtContNoti);
		ListView listView = (ListView) findViewById(R.id.noticiasListView);
		
		Log.i("SELECT","----------ENTRAMOS A LA DESCRIPCIÓN---------");
		
		
		// Construct the data source
		NoticiasSQLite TBL = new NoticiasSQLite(this);
		ArrayList<Noticia> arrayOfNoticias = TBL.read();
		// Create the adapter to convert the array to views
		NoticiasArrayAdapter adapter = new NoticiasArrayAdapter(this, arrayOfNoticias);
				
		//Obteniendo parametros de paso de actividad
		Intent intent = getIntent();
		Bundle bundle = new Bundle();
		bundle = intent.getExtras();
		
		Noticia noticia = adapter.getItem(bundle.getInt("id"));
		String titulo = noticia.get_titulo_not();
		String contenido = noticia.get_contenido_not();
		
		textViewTitulo.setTextSize(15);
		textViewTitulo.setText( titulo );
		
		//textViewContenido.setTextSize(15);
		textViewContenido.setText( contenido );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_desc_noticia, menu);
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
