package com.slickliesbrand.wolewale.Activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.slickliesbrand.wolewale.Events.DrawerSectionItemClicked;
import com.slickliesbrand.wolewale.R;
import com.slickliesbrand.wolewale.Utils.EventBus;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // setting the action button display at the top tool menu
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
        //  getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);


        // initialize the drawer layout and toggle
         mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,  R.string.drawer_opened, R.string.drawer_closed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            //    getSupportActionBar().setTitle(R.string.drawer_opened);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(R.string.drawer_opened);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (getSupportActionBar() !=null)
                    getSupportActionBar().setTitle(R.string.drawer_closed);
            }
        };






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
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

        if(mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getInstance().unregister(this);
        super.onStop();

    }
    @Subscribe
    public void OnDrawerSectionItemClicked(DrawerSectionItemClicked event) {
      //  Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "MainActivity: Section Clicked:" +event.section, Toast.LENGTH_SHORT).show();
    }


}
