package nef.naitineityfor.bigbcompany;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.aa.NoticiasArrayAdapter;
import nef.naitineityfor.bigbcompany.db.NoticiasSQLite;
import nef.naitineityfor.bigbcompany.dbobjects.Noticia;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ActNoticias extends Activity {
	
	public  final  static  String EXTRA_MESSAGE =  "com.example.ListViewTest.MESSAGE" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_noticias);
		initNoticiasArray();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_noticias, menu);
		return true;
	}

	public void abrirActUsuario(View view) {
    // Do something in response to button
    Intent intent = new Intent(this, ActUsuario.class);
    startActivity(intent);
	}
	
	/*public void abrirActNoticias(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActNoticias.class);
	    startActivity(intent);
	}*/
	
	public void abrirActContactos(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActContactos.class);
	    startActivity(intent);
	}
	
	public void abrirActEncuestas(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActEncuestas.class);
	    startActivity(intent);
	}
	
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
	    	//abrirActNoticias(null);
	        return true;
	    case R.id.action_contactos:
	    	abrirActContactos(null);
	        return true;
	    case R.id.action_encuestas:
	    	abrirActEncuestas(null);
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
		}
	}
	
	public void initNoticiasArray(){
		Log.i("NEFBBC", "list - start" );

		NoticiasSQLite TBL = new NoticiasSQLite(this);
		Log.i("NEFBBC", "list - SQLiteTable" );
		
		// Construct the data source
		ArrayList<Noticia> arrayOfNoticias = TBL.read();
		// Create the adapter to convert the array to views
		NoticiasArrayAdapter adapter = new NoticiasArrayAdapter(this, arrayOfNoticias);
		// Attach the adapter to a ListView
		ListView listView = (ListView) findViewById(R.id.noticiasListView);
		listView.setAdapter(adapter);
		
		Log.i("SELECT","----------llegamos 1---------");
		
		
		// Capturamos el evento clik de la lista de Noticias
		listView.setOnItemClickListener(new OnItemClickListener() { 
			public void onItemClick(AdapterView<?> customerAdapter, View view, int selectedInt, long selectedLong) {
				Log.i("SELECT","----------ROW---------"+selectedInt+" , " + selectedLong);
				Bundle bundle = new Bundle();
				bundle.putInt("id", selectedInt);
				Intent noticia =  new  Intent(ActNoticias.this , ActDescNoticia.class); 
                noticia.putExtras(bundle); 
                startActivity ( noticia );
                
			}
		});
	}
	
}
	

