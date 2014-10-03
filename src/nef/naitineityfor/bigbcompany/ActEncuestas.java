package nef.naitineityfor.bigbcompany;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.aa.EncuestasArrayAdapter;
import nef.naitineityfor.bigbcompany.db.EncuestasSQLite;
import nef.naitineityfor.bigbcompany.dbobjects.Encuesta;
import nef.naitineityfor.bigbcompany.desc.ActDescEncuesta;
import nef.naitineityfor.bigbcompany.desc.ActDescNoticia;
import nef.naityeityfor.bigbcompany.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ActEncuestas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_encuestas);
		initEncuestasArray();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_encuestas, menu);
		return true;
	}

	public void abrirActUsuario(View view) {
    // Do something in response to button
    Intent intent = new Intent(this, ActUsuario.class);
    startActivity(intent);
	}
	
	public void abrirActNoticias(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActNoticias.class);
	    startActivity(intent);
	}
	
	public void abrirActContactos(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActContactos.class);
	    startActivity(intent);
	}
	
	/*public void abrirActEncuestas(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActEncuestas.class);
	    startActivity(intent);
	}*/
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		switch (item.getItemId()) {
	    case R.id.action_usuario:
	    	abrirActUsuario(null);
	        return true;
	    case R.id.action_noticias:
	    	abrirActNoticias(null);
	        return true;
	    case R.id.action_contactos:
	    	abrirActContactos(null);
	        return true;
	    case R.id.action_encuestas:
	    	//abrirActEncuestas(null);
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
		}
	}
	
	public void initEncuestasArray(){
		Log.i("NEFBBC", "list - start" );

		EncuestasSQLite TBL = new EncuestasSQLite(this);
		Log.i("NEFBBC", "list - SQLiteTable" );
		
		// Construct the data source
		ArrayList<Encuesta> arrayOfEncuestas = TBL.read();
		// Create the adapter to convert the array to views
		EncuestasArrayAdapter adapter = new EncuestasArrayAdapter(this, arrayOfEncuestas);
		// Attach the adapter to a ListView
		ListView listView = (ListView) findViewById(R.id.encuestasListView);
		listView.setAdapter(adapter);
		
		
		// Capturamos el evento clik de la lista de Noticias
		listView.setOnItemClickListener(new OnItemClickListener() { 
			public void onItemClick(AdapterView<?> customerAdapter, View view, int selectedInt, long selectedLong) {
				Log.i("SELECT","----------ROW---------"+selectedInt+" , " + selectedLong);
				Bundle bundle = new Bundle();
				bundle.putInt("id", selectedInt);
				Intent encuesta =  new  Intent(ActEncuestas.this , ActDescEncuesta.class); 
				encuesta.putExtras(bundle); 
                startActivity ( encuesta );
                
			}
		});
		
		
	}
}
