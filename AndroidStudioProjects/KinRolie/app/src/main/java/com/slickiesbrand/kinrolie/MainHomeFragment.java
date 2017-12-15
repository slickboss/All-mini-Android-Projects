package com.slickiesbrand.kinrolie;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.slickiesbrand.kinrolie.Adapters.ListAdapter;
import com.slickiesbrand.kinrolie.Adapters.MyFragmentPagerAdapter;
import com.slickiesbrand.kinrolie.innerFragments.GalleryFragment;
import com.slickiesbrand.kinrolie.innerFragments.HomeFragment;
import com.slickiesbrand.kinrolie.innerFragments.ProductFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainHomeFragment extends Fragment {



    public MainHomeFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_home, container, false);


    }
}




