package com.slickiesbrand.w_w.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slickiesbrand.w_w.R;

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
