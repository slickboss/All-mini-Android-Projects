package com.slickiesbran.alcapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int counter;
    int quantity=1;


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
                Snackbar.make(view, "Get aCoffee and getCoded", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
// ORDERS CODE HERE

    public void submitOrder(View view){
          displayPrice(quantity * 5);
     //   display(quantity);
    }



// These methods are called when minus or plus button are clicked
    public void increment(View view){

            quantity = quantity + 1;
            display(quantity);
    }


    public void decrement(View view){
        quantity = quantity - 1;
        display(quantity);
    }

// String order for quantity

    public void submitOrder2(View view){

        String priceMessage = "You ordered for " + quantity + " cups of coffee" + "Total Price $" +(quantity*5)
                + "\n" + "Thank You Coder";
         priceMessage= priceMessage +  "\nprogrammersLoveCoffee";
        // OR int price = quantity * 5;
        // String priceMessage = " Total Amount" + price ;
        displayMessage(priceMessage);
        //   display(quantity);
    }


// this method is basically for integer variables


    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantityTV);
        quantityTextView.setText(" " + number);
    }


// this method displays the given price value on the screen
    public void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.priceTV);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

// Now lets work on strings
    public void displayMessage(String message) {
        TextView priceTextView2 = (TextView) findViewById(R.id.priceTV2);
        priceTextView2.setText(message);
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
