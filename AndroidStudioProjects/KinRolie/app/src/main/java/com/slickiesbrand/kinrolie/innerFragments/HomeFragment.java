package com.slickiesbrand.kinrolie.innerFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import com.slickiesbrand.kinrolie.Adapters.MyFragmentPagerAdapter;

import com.slickiesbrand.kinrolie.MainHomeFragment;
import com.slickiesbrand.kinrolie.R;
import com.slickiesbrand.kinrolie.innerFragments.GalleryFragment;
import com.slickiesbrand.kinrolie.innerFragments.HomeFragment;
import com.slickiesbrand.kinrolie.innerFragments.ProductFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends DialogFragment implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {


    ViewPager viewPager;
    TabHost tabHost;
    // int i=0;

    View rootView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        rootView=inflater.inflate(R.layout.tab_view_layout, container, false);


        initViewPager();
      initTabHost();




        // Inflate the layout for this fragment
        return rootView;
    }



    private void initTabHost() {

        // tabHost = new TabHost(getApplicationContext());      ******
        tabHost = (TabHost) rootView.findViewById(R.id.tabby);
        tabHost.setup();

        String[] tabNames = {"Home", "Product", "About"};

        for (int i = 0; i < tabNames.length; i++) {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);
        }

        tabHost.setOnTabChangedListener(this);
    }


        public class FakeContent implements TabHost.TabContentFactory{

            Context context;
            public FakeContent(Context mcontext){
                context = mcontext;
            }

            @Override
            public View createTabContent(String tag) {

                View fakeView = new View(context);
                fakeView.setMinimumHeight(0);
                fakeView.setMinimumWidth(0);
                return fakeView;
            }
        }





    private void initViewPager() {

        // setting up view pager adapter          *****************
        viewPager = (ViewPager)rootView.findViewById(R.id.view_pager);

        List<Fragment> listFragments = new Vector<Fragment>();
        listFragments.add(new HomeFragment());
        listFragments.add(new MainHomeFragment());
        listFragments.add(new GalleryFragment());
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), listFragments);
        viewPager.setAdapter((myFragmentPagerAdapter));
        viewPager.setOnPageChangeListener(this);

    }








    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    //viewerPager Listener
    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //tabHost Listener
    @Override
    public void onTabChanged(String tabId) {
        int selectedItem =tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);
                                                            // **************
        HorizontalScrollView hScrollView = (HorizontalScrollView) rootView.findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()- (hScrollView.getWidth())- tabView.getWidth() / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }











}

















    /**



    ViewPager viewPager;
    TabHost tabHost;
    public  MyFragmentPagerAdapter myFragmentPagerAdapter;
    int i=0;
    View rootView;

    public HomeFragment() {
        // Required empty public constructor
    }











    //  @Override
    //  public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //          Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    //    return inflater.inflate(R.layout.fragment_main_home, container, false);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    //    View rootView=inflater.inflate(R.layout.fragment_product, container, false);
       View rootView = inflater.inflate(R.layout.tab_view_layout, container, false);



        i++;


        this.initialiseViewPager();
        this.initialiseTabHost(savedInstanceState);

        return rootView;
    }





    class FakeContent implements TabHost.TabContentFactory {

        private final  Context mContext;
        public FakeContent(Context context){
            mContext=context;
        }

        @Override
        public View createTabContent(String tag) {

            View v = new View(mContext);
            v.setMinimumHeight(0);
            v.setMinimumWidth(0);
            return v;
        }
    }


    private  void initialiseViewPager() {
        List<Fragment> fragments = new Vector<Fragment>();

        fragments.add(new HomeFragment());
        fragments.add(new ProductFragment());
        fragments.add(new GalleryFragment());

        this.myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getChildFragmentManager(), fragments
        );

        this.viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        this.viewPager.setAdapter(this.myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }


    private  void initialiseTabHost(Bundle args){
        tabHost = (TabHost) rootView.findViewById(R.id.tabby);
        tabHost.setup();

        for(int i=1; i<=3; i++){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec("Tab" +1);
            tabSpec.setIndicator("Tab" +1);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);

        }

        tabHost.setOnTabChangedListener(this);
    }




    @Override
    public void onTabChanged(String tabId) {
        int selectedItem =tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);
        //  this.myFragmentPagerAdapter = new MyFragmentPagerAdapter()
        HorizontalScrollView hScrollView = (HorizontalScrollView) rootView.findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()- (hScrollView.getWidth())- tabView.getWidth() / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }






    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    //viewerPager Listener
    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //tabHost Listener








/**
 private void initViewPager() {

 // setting up view pager adapter
 viewPager = (ViewPager) findViewById(R.id.view_pager);

 List<Fragment> listFragments = new ArrayList<Fragment>();
 listFragments.add(new HomeFragment());
 listFragments.add(new ProductFragment());
 listFragments.add(new GalleryFragment());
 MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), listFragments);
 viewPager.setAdapter((myFragmentPagerAdapter));
 viewPager.setOnPageChangeListener(this);

 }









}

**/





