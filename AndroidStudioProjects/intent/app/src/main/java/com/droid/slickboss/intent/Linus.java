package com.droid.slickboss.intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
public class Linus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle windowsData = getIntent().getExtras();
        if (windowsData==null){
            return;
        }
        String windowsMessage = windowsData.getString("windowsMessage");
        final TextView Linustext = (TextView) findViewById(R.id.linustext);
        Linustext.setText(windowsMessage);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void onClick(View view) {
        Intent i =new Intent(this, Windows.class);
        startActivity(i);
    }



}

