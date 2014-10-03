package nef.naitineityfor.bigbcompany.aa;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.dbobjects.Contacto;
import nef.naityeityfor.bigbcompany.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactosArrayAdapter extends ArrayAdapter<Contacto>{
	
	public ContactosArrayAdapter(Context context, ArrayList<Contacto> contactos) {
        super(context, R.layout.row_contacto, contactos);
        Log.i("NEFBBC", "UserAdapter - super" );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// Get the data item for this position
     	Contacto contacto = getItem(position); 
     	Log.i("NEFBBC", "ContactoAdapter - position" );
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_contacto, parent, false);
           Log.i("NEFBBC", "ContactoAdapter - null" );
        }
        // Lookup view for data population
        //TextView img_contacto = (TextView) convertView.findViewById(R.id.img_contacto);
        //Log.i("NEFBBC", "ContactoAdapter - email_contacto" );
        TextView nombre_contacto = (TextView) convertView.findViewById(R.id.nombre_contacto);
        Log.i("NEFBBC", "ContactoAdapter - id_contacto" );
        TextView email_contacto = (TextView) convertView.findViewById(R.id.email_contacto);
        Log.i("NEFBBC", "ContactoAdapter - nombre_contacto" );
        
        // Populate the data into the template view using the data object
        //img_contacto.setText(contacto.get_img());
        //Log.i("NEFBBC", "ContactoAdapter - GETimg" );
        nombre_contacto.setText(contacto.get_nombre());
        Log.i("NEFBBC", "ContactoAdapter - GETnombre" );
        email_contacto.setText(contacto.get_email());
        Log.i("NEFBBC", "ContactoAdapter - GETemail" );
    
        // Return the completed view to render on screen
        return convertView;
    }
}
