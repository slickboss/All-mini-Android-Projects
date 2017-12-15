package com.slickiesbrand.slickishdrawer.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slickiesbrand.slickishdrawer.R;

/**
 * Created by SLICKBOSS on 7/12/2016.
 */
public class Fragment_Home extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_main, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
