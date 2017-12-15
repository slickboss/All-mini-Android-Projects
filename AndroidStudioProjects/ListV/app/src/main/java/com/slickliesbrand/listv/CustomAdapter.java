package com.slickliesbrand.listv;



import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by SLICKBOSS on 7/3/2016.
 */
class CustomAdapter extends ArrayAdapter<String>{
    public CustomAdapter(Context context, String[] slickitem) {
        super(context, R.layout.custom_row, slickitem);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater slickinflater = LayoutInflater.from(getContext());
        View customView = slickinflater.inflate(R.layout.custom_row, parent, false);

        String singleSlickItem = getItem(position);
        TextView slicksText = (TextView) customView.findViewById(R.id.slickText);
        ImageView slickimage = (ImageView) customView.findViewById(R.id.slickImage);

        slicksText.setText(singleSlickItem);
        slickimage.setImageResource(R.drawable.and);
        return customView;
    }
}
