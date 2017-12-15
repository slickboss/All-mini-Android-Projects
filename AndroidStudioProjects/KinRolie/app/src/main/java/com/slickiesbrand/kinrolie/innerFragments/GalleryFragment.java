package com.slickiesbrand.kinrolie.innerFragments;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.slickiesbrand.kinrolie.R;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
/**
 * Created by SLICKBOSS on 7/8/2016.
 */


public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);



        // Inflate the layout for this fragment
        return rootView;
    }


}










/**
GridView gv;
ArrayList<File> list;

public GalleryFragment() {
    // Required empty public constructor
}




@Nullable
//@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



    list = imageReader(Environment.getExternalStorageDirectory());


    gv = (GridView) container.findViewById(R.id.gridView);
    gv.setAdapter( new GridAdapter());


    View rootView=inflater.inflate(R.layout.fragment_gallery, container, false);

    // Inflate the layout for this fragment
    return rootView;
}

class GridAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView= getLayoutInflater().inflate(R.layout.single_grid, parent, false);

        return null;
    }
}


ArrayList<File> imageReader(File root){

    ArrayList<File> a = new ArrayList<>();

    File[] files = root.listFiles();
    for(int i=0; i<files.length; i++){
        if (files[i].isDirectory()){
            a.addAll(imageReader(files[i]));
        }else {
            if(files[i].getName().endsWith(".jpg") ){
            a.add(files[i]);
            }
        }



    }

    return a;

}




}
**/