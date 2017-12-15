package com.slickliesbrand.listv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] slickitems = {"home", "contact", "about", "services", "More", "Kiss"};
        ListAdapter slickAdapter = new CustomAdapter(this, slickitems);
        ListView slickListView =(ListView) findViewById(R.id.slickListView);
        slickListView.setAdapter(slickAdapter);

        // to make it clickabel
        slickListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String slick = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                }
        );



    }
}
