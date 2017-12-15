package com.compscitutorials.basigarcia.navigationdrawervideotutorial.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compscitutorials.basigarcia.navigationdrawervideotutorial.R;

/**
 * Created by SLICKBOSS on 7/8/2016.
 */



public class Fragment_Trends extends Fragment {


    public Fragment_Trends() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trends, container, false);



        // Inflate the layout for this fragment
        return rootView;
    }


}