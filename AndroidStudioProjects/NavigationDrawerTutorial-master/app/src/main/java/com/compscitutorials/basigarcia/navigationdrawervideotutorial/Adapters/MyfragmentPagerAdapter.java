package com.compscitutorials.basigarcia.navigationdrawervideotutorial.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SLICKBOSS on 7/9/2016.
 */


public class MyfragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragments;
    public MyfragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}