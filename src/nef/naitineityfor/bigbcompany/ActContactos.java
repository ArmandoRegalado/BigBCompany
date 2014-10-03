package nef.naitineityfor.bigbcompany;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.aa.ContactosArrayAdapter;
import nef.naitineityfor.bigbcompany.aa.ContactosListViewOnItemClickLstnr;
import nef.naitineityfor.bigbcompany.db.ContactosSQLite;
import nef.naitineityfor.bigbcompany.dbobjects.Contacto;
import nef.naityeityfor.bigbcompany.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ActContactos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_contactos);
		initContactosArray();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_contactos, menu);
		
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
	
	/*public void abrirActContactos(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActContactos.class);
	    startActivity(intent);
	}*/
	
	public void abrirActEncuestas(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActEncuestas.class);
	    startActivity(intent);
	}
	
	public void abrirActMesajes(View view) {
	    // Do something in response to button
	    Intent intent = new Intent(this, ActMensajes.class);
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
	    	abrirActNoticias(null);
	        return true;
	    case R.id.action_contactos:
	    	//abrirActContactos(null);
	        return true;
	    case R.id.action_encuestas:
	    	abrirActEncuestas(null);
	        return true;
	    case R.id.action_search:
	    	//abrirActMesajes(null);
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
		}
	}
	
	public void initContactosArray(){
		Log.i("NEFBBC", "list - start" );

		ContactosSQLite TBL = new ContactosSQLite(this);
		Log.i("NEFBBC", "list - SQLiteTable" );
		
		// Construct the data source
		ArrayList<Contacto> arrayOfContactos = TBL.read();
		Log.i("NEFBBC", "list - TBLread" );
		// Create the adapter to convert the array to views
		ContactosArrayAdapter adapter = new ContactosArrayAdapter(this, arrayOfContactos);
		Log.i("NEFBBC", "list -adapter" );
		// Attach the adapter to a ListView
		ListView listView = (ListView) findViewById(R.id.contactosListView);
		Log.i("NEFBBC", "list - listview" );
		listView.setAdapter(adapter);
		Log.i("NEFBBC", "list - setAdapter" );
        listView.setOnItemClickListener(new ContactosListViewOnItemClickLstnr());
	}
}
