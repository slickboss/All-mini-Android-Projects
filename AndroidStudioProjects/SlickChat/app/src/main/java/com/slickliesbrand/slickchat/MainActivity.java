package com.slickliesbrand.slickchat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;
import java.util.HashMap;

import java.util.Map;
import android.view.View.OnClickListener;
import android.content.Context;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Firebase mFirebaseRef;
    private EditText mMessageEdit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // FIREBASE CODES
        Firebase.setAndroidContext(this);
        mFirebaseRef = new Firebase("https://intense-inferno-8510.firebaseio.com");

        mMessageEdit = (EditText) this.findViewById(R.id.message_text);

        //End of Firebase Code

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

            // FIREBASE CODES

            public void onSendButtonClick(View v) {
                String message = mMessageEdit.getText().toString();
                Map<String,Object> values = new HashMap<>();
                values.put("name", "puf");
                values.put("message", message);
                mFirebaseRef.push().setValue(values);
                mMessageEdit.setText("");
            }
            // end of FIREBASE CODES
        });






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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
