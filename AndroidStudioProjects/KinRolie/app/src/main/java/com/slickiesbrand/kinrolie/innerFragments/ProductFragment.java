package com.slickiesbrand.kinrolie.innerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.slickiesbrand.kinrolie.Adapters.ListAdapter;

import com.slickiesbrand.kinrolie.R;








public class ProductFragment extends DialogFragment{



    ListView lv;


    String[] titles= {"Snails", "Chicken", "Small Hen", "Feeding Chicken", "Feeding Snails", "Sample of Snail"};

    String[] infos= {"About Snails", "About Chicken", "Small Hen", "Feeding Chicken", "Feeding Snails", "Sample of Snail"};

    String[] status= {"Available", "In stock", "Off the shore", "Pending", "Available", "Available"};

    int[]images = {R.drawable.prod1, R.drawable.prod0, R.drawable.prod2, R.drawable.prod3, R.drawable.prod4, R.drawable.prod5,};






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView=inflater.inflate(R.layout.fragment_product, container, false);

        //INITIALISING
        lv= (ListView) rootView.findViewById(R.id.listVshow);

        //SET DIALOGUE TITLE

//        getDialog().setTitle("WOLEWALE Farm");

        //CREATE ADAPTER OBJ AND SET LIST VIEW

        Adapter adapter = new ListAdapter(getActivity(), titles, infos,status, images);
        lv.setAdapter((android.widget.ListAdapter) adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   Toast.makeText(this, titles[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), titles[position], Toast.LENGTH_SHORT).show();
            }
        });





        return rootView;
    }
}

















/**
 * Created by SLICKBOSS on 7/8/2016.



public class ProductFragment extends Fragment {


     ListView lv;


     String[] titles= {"Snails", "Chicken", "Small Hen", "Feeding Chicken", "Feeding Snails", "Sample of Snail"};

     String[] infos= {"About Snails", "About Chicken", "Small Hen", "Feeding Chicken", "Feeding Snails", "Sample of Snail"};

     String[] status= {"Available", "In stock", "Off the shore", "Pending", "Available", "Available"};

     int[]images = {R.drawable.prod1, R.drawable.prod0, R.drawable.prod2, R.drawable.prod3, R.drawable.prod4, R.drawable.prod5,};






    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product, container, false);





        // Inflate the layout for this fragment






        lv= (ListView) rootView.findViewById(R.id.listView1);

        Adapter  adapter= new ListAdapter(this, titles, infos, status, images);
        //  Adapter adapter = new Adapter(this, titles, infos, status, images);
        lv.setAdapter((android.widget.ListAdapter) adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(this, titles[position], Toast.LENGTH_SHORT).show();
            //    Toast.makeText(ProductFragment.this, titles[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;






    }


}


 */