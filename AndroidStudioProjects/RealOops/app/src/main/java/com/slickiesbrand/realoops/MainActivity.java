package com.slickiesbrand.realoops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_ITEM_LOGOUT = 1001;

    //CREATING A WEB LINK ACTIVITY and an EMAIL MSG Receiver
    private static String webUrl = "https://www.aaua.edu.ng";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        // CUSTOMISE YOUR OWN MENU HERE
        menu.add(0, MENU_ITEM_LOGOUT, 102, R.string.logout);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "You selected SETTINGS menu", Toast.LENGTH_SHORT).show();
                return true;

       //     case R.id.action_about:
                //  Toast.makeText(MainActivity.this, "You selected ABOUT", Toast.LENGTH_SHORT).show();
                // THIS CODE Comprises of moving/switching from one activity to another activity
                // by using intent

            //    Intent intent = new Intent(this, AboutActivity.class);
            //    startActivity(intent);

       //         return true;

            case MENU_ITEM_LOGOUT:
                Toast.makeText(MainActivity.this, "You selected LOGOUT", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.action_upload:
                Toast.makeText(MainActivity.this, "You selected UPLOAD Bar", Toast.LENGTH_SHORT).show();
                return true;

//            case R.id.action_events:
//                Intent instinct = new Intent(this, EventsActivity.class);
//                startActivity(instinct);
//                return true;
//
//            case R.id.action_product:
//                Intent prod = new Intent(this, ProductActivity.class);
//                startActivity(prod);
//                return true;

            case R.id.action_trends:
//                Intent instinct = new Intent(this, EventsActivity.class);
//                startActivity(instinct);
                Toast.makeText(MainActivity.this, "You selected Trends Bar", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_OopsDay:
//                Intent prod = new Intent(this, ProductActivity.class);
//                startActivity(prod);
                Toast.makeText(MainActivity.this, " Oops of the dayBar", Toast.LENGTH_SHORT).show();
                return true;



            case R.id.action_oopsweb:
                // GO TO THE WEBSITE HERE
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);

                }
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
