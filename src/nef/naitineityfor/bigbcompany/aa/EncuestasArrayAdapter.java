package nef.naitineityfor.bigbcompany.aa;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.dbobjects.Encuesta;
import nef.naityeityfor.bigbcompany.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EncuestasArrayAdapter extends ArrayAdapter<Encuesta>{
	
	public EncuestasArrayAdapter(Context context, ArrayList<Encuesta> encuestas) {
        super(context, R.layout.row_encuesta, encuestas);
        Log.i("NEFBBC", "UserAdapter - super" );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// Get the data item for this position
     	Encuesta encuesta = getItem(position); 
     	Log.i("NEFBBC", "EncuestaAdapter - position" );
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_encuesta, parent, false);
           Log.i("NEFBBC", "EncuestaAdapter - null" );
        }
        // Lookup view for data population
        TextView titulo_enc = (TextView) convertView.findViewById(R.id.titulo_enc);
        TextView descripcion_enc = (TextView) convertView.findViewById(R.id.descripcion_enc);
        Log.i("NEFBBC", "EncuestaAdapter - TextView look view" );
        
        // Populate the data into the template view using the data object
        titulo_enc.setText(encuesta.get_titulo_enc());
        descripcion_enc.setText(encuesta.get_descripcion_enc().substring(0,35)+"...");
        Log.i("NEFBBC", "EncuestaAdapter - Populate" );
    
        // Return the completed view to render on screen
        return convertView;
    }
}
