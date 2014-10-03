package nef.naitineityfor.bigbcompany.aa;

import nef.naitineityfor.bigbcompany.ActMensajes;
import nef.naityeityfor.bigbcompany.R;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ContactosListViewOnItemClickLstnr implements OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.i("NEFBBC", "listItem Click - enter");
    	Context context = view.getContext();
		Log.i("NEFBBC", "listItem Click - context");
        TextView mensajesListViewItem = ((TextView) view.findViewById(R.id.mensajesListView));
		Log.i("NEFBBC", "listItem Click - mensajesListViewItem");
        // get the clicked item name
        //String listItemText = mensajesListViewItem.getText().toString();
		//Log.i("NEFBBC", "listItem Click - listItemText");
        // get the clicked item ID
        //String listItemId = mensajesListViewItem.getTag().toString();
		//Log.i("NEFBBC", "listItem Click - listItemId"+listItemId);
		//Log.i("NEFBBC", "listItem Click - setAdapter - iID: " + listItemId);
        //Intent intent = new Intent(this, ActMensajes.class);
	    //startActivity(intent);
		Intent intent = new Intent(context, ActMensajes.class);
		view.getContext().startActivity(intent);
    }
}
