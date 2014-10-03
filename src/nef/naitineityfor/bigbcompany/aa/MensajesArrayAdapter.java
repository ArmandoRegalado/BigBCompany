package nef.naitineityfor.bigbcompany.aa;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.dbobjects.Mensaje;
import nef.naityeityfor.bigbcompany.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MensajesArrayAdapter extends ArrayAdapter<Mensaje>{
	
	public MensajesArrayAdapter(Context context, ArrayList<Mensaje> mensajes) {
        super(context, R.layout.row_mensaje, mensajes);
        Log.i("NEFBBC", "UserAdapter - super" );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// Get the data item for this position
     	Mensaje mensaje = getItem(position); 
     	Log.i("NEFBBC", "MensajeAdapter - position" );
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_mensaje, parent, false);
           Log.i("NEFBBC", "MensajeAdapter - null" );
        }
        // Lookup view for data population
        TextView cont_mensaje = (TextView) convertView.findViewById(R.id.cont_mensaje);
        TextView time = (TextView) convertView.findViewById(R.id.time);
        Log.i("NEFBBC", "MensajeAdapter - TextView look view" );
        
        // Populate the data into the template view using the data object
        //email_remitente.setText(mensaje.get_email_remitente());
        cont_mensaje.setText(mensaje.get_cont_mensaje());
        time.setText(mensaje.get_enviado());
        Log.i("NEFBBC", "MensajeAdapter - Populate" );
    
        // Return the completed view to render on screen
        return convertView;
    }
}
