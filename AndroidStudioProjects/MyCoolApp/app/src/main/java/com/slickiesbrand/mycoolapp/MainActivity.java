package com.slickiesbrand.mycoolapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    // CUSTOMISE YOUR OWN MENU HERE from menu.add
    private static final int MENU_ITEM_LOGOUT = 1001;

    //CREATING A WEB LINK ACTIVITY and an EMAIL MSG Receiver
    private static String webUrl = "https://www.aaua.edu.ng";
    private static String email = "slickbozz@gmail.com";


    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //  fab.setOnClickListener(new View.OnClickListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send AN EMAIL CODE HERE
                String[] address = {email};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                intent.putExtra(Intent.EXTRA_TEXT, "please send an email to make an order or enquiry");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

//                EditText et = (EditText) findViewById(R.id.editText);
//                String entry = et.getText().toString();
//                Snackbar.make(view, "Your entered " + entry, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


            }
        });

        // THIS CODES MAKES GDG TEXT REPEATS 10 TIMES
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(getString(R.string.about_gdg_longtext) + "\n\n");
        }
        TextView tv = (TextView) findViewById(R.id.gdgText);
        tv.setText(builder.toString());


        // ONCLICK EVENT USING PURE JAVA
        Button button = (Button) findViewById(R.id.buttonClick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(coordinatorLayout, "Your select slick settings ", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                EditText et = (EditText) findViewById(R.id.editText);
                String entry = et.getText().toString();

                Snackbar.make(v, "Your entered " + entry, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        // WRITING IMAGE DISPLAY IN PURE JAVA
        //    ImageView iv = (ImageView) findViewById(R.id.photo);
        //    iv.setImageResource(R.drawable.photogdg);

        // OR LIKE BELOW
//        ImageView iv = (ImageView) findViewById(R.id.photo);
//        String imageName = "photogdg";
//        int res = getResources().getIdentifier(imageName, "drawable", getPackageName());
//        iv.setImageResource(res);

        //FIND IMAGE IN THE ASSET FOLDER
        ImageView iv = (ImageView) findViewById(R.id.photo);
        String imageName = "material_stock";
        try {
            InputStream stream = getAssets().open(imageName + ".png");
            Drawable d = Drawable.createFromStream(stream, null);
            iv.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        // USE IF AND ELSE IF STATEMENT FOR MULTIPLE FUNCTIONS
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            //      Toast.makeText(MainActivity.this, "You selected settings menu", Toast.LENGTH_SHORT).show();
//            Snackbar.make(coordinatorLayout, "Your select slick settings ", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();


        // OR USE SWITCH CASE STATEMENT HERE FOR MULTIPLE FUNCTIONS

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "You selected SETTINGS menu", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_about:
                //  Toast.makeText(MainActivity.this, "You selected ABOUT", Toast.LENGTH_SHORT).show();

                // THIS CODE Comprises of moving/switching from one activity to another activity
                // by using intent
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);

                return true;

            case MENU_ITEM_LOGOUT:
                Toast.makeText(MainActivity.this, "You selected LOGOUT", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.action_upload:
                Toast.makeText(MainActivity.this, "You selected UPLOAD Bar", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_events:
                Intent instinct = new Intent(this, EventsActivity.class);
                startActivity(instinct);
                return true;

            case R.id.action_product:
                Intent prod = new Intent(this, ProductActivity.class);
                startActivity(prod);
                return true;

            case R.id.action_aauaweb:
                // GO TO THE WEBSITE HERE
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);

                }
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    //THIS IS OnClickeVENT OF THE BUTTON

    public void buttonClickHandler(View view) {
        Toast.makeText(MainActivity.this, "You CLICK THE SUBMIT BUTTON", Toast.LENGTH_SHORT).show();
    }


}
