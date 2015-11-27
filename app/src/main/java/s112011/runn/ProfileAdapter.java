package s112011.runn;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileAdapter extends ArrayAdapter<ProfileDTO> {

    Activity context;
   ArrayList<ProfileDTO> names;
   ArrayList<Integer> images;


    public ProfileAdapter(Activity context, ArrayList<ProfileDTO> names){
             super(context, R.layout.list_element,names );
            this.context = context;
            this.names = names;
            this.images = images;



    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_element, null, true);
        TextView name = (TextView) rowView.findViewById(R.id.list_elem_heading);

        name.setText(names.get(position).getName());

        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_elem_pic);

        imageView.setImageResource(R.mipmap.a + position);

        TextView location = (TextView) rowView.findViewById(R.id.listeelem_beskrivelse);
        location.setText(names.get(position).getLocation());
        return rowView;
    }
}







