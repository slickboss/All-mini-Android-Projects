package com.slickiesbrand.kinrolie.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import com.slickiesbrand.kinrolie.R;

/**
 * Created by SLICKBOSS on 7/18/2016.

public class Adapter extends ArrayAdapter<String> {
        Context c;
        String[] title;
    String[] status;
    String[] info;
    int[] images;




    public Adapter(Context context, String[] title, String[] status, String[] info, int[] images) {
        super(context, R.layout.model, title);

        this.c =context;
        this.title=title;
        this.info=info;
        this.status=status;
        this.images=images;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.model, null);

        }


        return super.getView(position, convertView, parent);
    }
}
 */