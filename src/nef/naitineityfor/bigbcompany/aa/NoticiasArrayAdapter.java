package nef.naitineityfor.bigbcompany.aa;

import java.util.ArrayList;

import nef.naitineityfor.bigbcompany.dbobjects.Noticia;
import nef.naityeityfor.bigbcompany.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NoticiasArrayAdapter extends ArrayAdapter<Noticia>{
	
	public NoticiasArrayAdapter(Context context, ArrayList<Noticia> noticias) {
        super(context, R.layout.row_noticia, noticias);
        Log.i("NEFBBC", "UserAdapter - super" );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// Get the data item for this position
     	Noticia noticia = getItem(position); 
     	Log.i("NEFBBC", "NoticiaAdapter - position" );
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_noticia, parent, false);
           Log.i("NEFBBC", "NoticiaAdapter - null" );
        }
        // Lookup view for data population
        //TextView imagen_not = (TextView) convertView.findViewById(R.id.imagen_not);
        TextView titulo_not = (TextView) convertView.findViewById(R.id.titulo_not);
        TextView cant_likes = (TextView) convertView.findViewById(R.id.cant_likes);
        Log.i("NEFBBC", "NoticiaAdapter - TextView look view" );
        
        // Populate the data into the template view using the data object
        //imagen_not.setText(noticia.get_imagen_not());
        titulo_not.setText(noticia.get_titulo_not());
        cant_likes.setText(noticia.get_cant_likes().toString());
        Log.i("NEFBBC", "NoticiaAdapter - Populate" );
    
        // Return the completed view to render on screen
        return convertView;
    }
}
