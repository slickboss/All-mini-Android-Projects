package com.slickiesbrand.slickishdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.slickiesbrand.slickishdrawer.Adapters.NavListAdapter;
import com.slickiesbrand.slickishdrawer.Fragments.Fragment_Gallery;
import com.slickiesbrand.slickishdrawer.Fragments.Fragment_Home;
import com.slickiesbrand.slickishdrawer.Fragments.Fragment_Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    List<NavItem> listNavItems;
    List<Fragment> listFragments;



    ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {







        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
                     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                       ab.setDisplayHomeAsUpEnabled(true);
        }

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      // assert getSupportActionBar() != null;
      //  getSupportActionBar().setDisplayShowCustomEnabled(true);
     //  if(getSupportActionBar() != null)
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         //   getSupportActionBar().setDisplayShowCustomEnabled(true);
       //    getSupportActionBar().setDisplayShowHomeEnabled(true);
      //  getSupportActionBar().setHomeButtonEnabled(true);



         //    getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
           //  getSupportActionBar().setDisplayShowHomeEnabled(true);
           //  getSupportActionBar().setHomeButtonEnabled(true);
            // getSupportActionBar().setDisplayShowCustomEnabled(true);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


       // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
      // getSupportActionBar().setHomeButtonEnabled(true);

      // getSupportActionBar().setDisplayShowCustomEnabled(true);

        /// NEW CODES 17

        // initialize the drawer layout and toggle

//  //      mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,  R.string.drawer_opened, R.string.drawer_closed){
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                //    getSupportActionBar().setTitle(R.string.drawer_opened);
//                if (getSupportActionBar() != null)
//                    getSupportActionBar().setTitle(R.string.drawer_opened);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//                if (getSupportActionBar() !=null)
//                    getSupportActionBar().setTitle(R.string.drawer_closed);
//            }
//        };











        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_Layout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav = (ListView) findViewById(R.id.nav_list);

        listNavItems = new ArrayList<NavItem>();
        listNavItems.add(new NavItem("Home", "Home Page", R.drawable.ic_action_home_));
        listNavItems.add(new NavItem("Product", "Product", R.drawable.ic_action_home_));
         listNavItems.add(new NavItem("Gallery", "Gallery", R.drawable.ic_action_home_));


        NavListAdapter navListAdapter = new NavListAdapter(getApplicationContext(), R.layout.item_nav_list, listNavItems);

        lvNav.setAdapter(navListAdapter);

        listFragments = new ArrayList<Fragment>();
        listFragments.add(new Fragment_Home());
        listFragments.add(new Fragment_Product());
        listFragments.add(new Fragment_Gallery());


        // load first fragment as default

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_page, listFragments.get(0)).commit();

        setTitle(listNavItems.get(0).getTitle());
        lvNav.setItemChecked(0, true);
        drawerLayout.closeDrawer(drawerPane);

        //set listener for navigation items:

        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // replace the fragments with the selection correspondingly:

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.main_page, listFragments.get(position))
                        .commit();

                setTitle(listNavItems.get(position).getTitle());
                lvNav.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerPane);

            }
        });


        // create listener for drawer layout:
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed) {

            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };


        drawerLayout.setDrawerListener(actionBarDrawerToggle);







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }




    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();
        if (id == R.id.main_page) {

            final Fragment_Home p = new Fragment_Home();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_page, p)
                    .commit();
            return true;
        } else if(id == R.id.prodxml) {
            final Fragment_Product p = new Fragment_Product();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.prodxml, p)
                    .commit();
            return true;

        }






       if (actionBarDrawerToggle.onOptionsItemSelected(item))
          return true;


//        //noinspection SimplifiableIfStatement
//   //     if (id == R.id.action_settings) {
//   //         return true;
//    //    }
//
        return super.onOptionsItemSelected(item);
   }


}
