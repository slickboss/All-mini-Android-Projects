package com.slickliesbrand.wolewale.Views;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.slickliesbrand.wolewale.Adapters.DrawerNavigationListAdapter;

import org.w3c.dom.Attr;

/**
 * Created by SLICKBOSS on 7/6/2016.
 */    /**
public class DrawerNavigationListView extends ArrayAdapter<Attr> {

    Context context;
    AttributeSet attrs;
    int defStyleAttr;


        public DrawerNavigationListView(Context context, int defStyleAttr,  AttributeSet[attrs] attrs) {
         super(context, attrs, defStyleAttr);

        DrawerNavigationListAdapter adapter = new DrawerNavigationListAdapter(getContext(), 0);
        adapter.add("HOME");
        adapter.add("PRODUCTS");
        adapter.add("CONTACTS");


        setAdapter(adapter);
        setOnItemClickListener(this);

    }


}

}

/**

public class DrawerNavigationListView extends ArrayAdapter<AttributeSet> {
    Context context;
    AttributeSet attrs;
    int


    public DrawerNavigationListView(Context context, AttributeSet[] objects, int resource) {
        super(context, resource, objects);
    }
}


**/


