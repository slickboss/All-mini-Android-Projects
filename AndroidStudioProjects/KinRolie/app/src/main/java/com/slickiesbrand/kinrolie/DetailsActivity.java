package com.slickiesbrand.kinrolie;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.slickiesbrand.kinrolie.DataProvider;
import com.slickiesbrand.kinrolie.Product;
import com.slickiesbrand.kinrolie.ProductActivity;
import com.slickiesbrand.kinrolie.R;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class DetailsActivity extends AppCompatActivity {

    private static String email = "kennyfragile007@gmail.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        String productId = getIntent().getStringExtra(ProductActivity.PRODUCT_ID);
        Product product = DataProvider.productMap.get(productId);


        TextView tv = (TextView) findViewById(R.id.nameText);
        tv.setText(product.getName());



        TextView desc = (TextView) findViewById(R.id.descriptionText);
        desc.setText(product.getDescription());




        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(product.getPrice());
        TextView priceText = (TextView) findViewById(R.id.priceText);
        priceText.setText(price);

        ImageView iv = (ImageView) findViewById(R.id.imageViewProd);
        Bitmap bitmap = getBitmapFromAsset(product.getProductId());
        iv.setImageBitmap(bitmap);








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }






    private Bitmap getBitmapFromAsset(String productId) {


        AssetManager assetManager = getAssets();

        InputStream stream = null;
        try {
            stream = assetManager.open(productId + ".jpg");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }








}
