package nef.naitineityfor.bigbcompany;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import nef.naitineityfor.bigbcompany.aa.MensajesArrayAdapter;
import nef.naitineityfor.bigbcompany.db.MensajesSQLite;
import nef.naitineityfor.bigbcompany.dbobjects.Mensaje;
import nef.naityeityfor.bigbcompany.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ActMensajes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_mensajes);
		initMensajesArray();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_mensajes, menu);
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
	
	public void initMensajesArray(){
		Log.i("XXX", "list - start" );

		MensajesSQLite TBL = new MensajesSQLite(this);
		Log.i("XXX", "list - SQLiteTable" );
		
		// Construct the data source
		ArrayList<Mensaje> arrayOfMensajes = TBL.read();
		Log.i("XXX", "list - TBLread" );
		// Create the adapter to convert the array to views
		MensajesArrayAdapter adapter = new MensajesArrayAdapter(this, arrayOfMensajes);
		Log.i("XXX", "list -adapter" );
		// Attach the adapter to a ListView
		ListView listView = (ListView) findViewById(R.id.mensajesListView);
		Log.i("XXX", "list - listview" );
		listView.setAdapter(adapter);
		Log.i("XXX", "list - setAdapter" );
	}
	
	public void enviarMensaje(View view) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String date = sdf.format(new Date());
		
		EditText ET_mensaje = (EditText) findViewById(R.id.editText_mensaje);

		MensajesSQLite TBLmensaje = new MensajesSQLite(this);
		TBLmensaje.put(new Mensaje(1,"adalberto.marin","silvia.cendejas",ET_mensaje.getText().toString(),date.toString(),"rec1-23:59"));
		ET_mensaje.setText("");
		this.recreate();
	}
}
