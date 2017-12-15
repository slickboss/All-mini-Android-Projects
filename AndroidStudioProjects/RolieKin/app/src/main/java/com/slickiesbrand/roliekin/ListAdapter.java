package com.slickiesbrand.roliekin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SLICKBOSS on 7/15/2016.
 */
public class ListAdapter extends ArrayAdapter<String>{

    String[]titles={};
    String[]infos={};
    String[]status={};
    int[] imgs={};
    Context c;
    LayoutInflater inflater;
     public ListAdapter(Context context, String[]titles, String[]infos, String[]status, int[] imgs) {
        super(context, R.layout.model, titles);

         this.c =context;
         this.titles=titles;
         this.infos=infos;
         this.status=status;
         this.imgs=imgs;
    }

    // INNER CLASS TO HOLD OUR VIEWS
    public class ViewHolder{
        TextView titleTv;
        TextView infoTv;
        TextView statusTv;
        ImageView imgTv;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.model, null);

        }

        // OUR VIEWHOLDER OBJECT
        final ViewHolder holder = new ViewHolder();

        // INITIALISE OUR VIEWS

        holder.titleTv=(TextView) convertView.findViewById(R.id.text_title);
        holder.infoTv=(TextView) convertView.findViewById(R.id.text_info);
        holder.statusTv=(TextView) convertView.findViewById(R.id.text_status);
        holder.imgTv=(ImageView) convertView.findViewById(R.id.image_icon);

        //ASSIGN OUR DATA
        holder.imgTv.setImageResource(imgs[position]);
        holder.titleTv.setText(titles[position]);
        holder.infoTv.setText(infos[position]);
        holder.statusTv.setText(status[position]);

        return convertView;
    }
}
