package com.slickiesbrand.mycoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ProductActivity extends AppCompatActivity {


    public static final String PRODUCT_ID = "PRODUCT_ID" ;
    private List<Product> products = DataProvider.productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //      String[] items = getResources().getStringArray(R.array.gallery);
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this,
//                        android.R.layout.simple_list_item_1,
//                        android.R.id.text1, items);

        ProductListAdapter adapter = new ProductListAdapter(
                this, R.layout.list_item, products
        );
        ListView lv = (ListView) findViewById(R.id.listViewProd);
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProductActivity.this, DetailsActivity.class);

                // switching the items to current items
                   Product product = products.get(position);
                   intent.putExtra(PRODUCT_ID, product.getProductId());


                startActivity(intent);
            }
        });






    }


}
