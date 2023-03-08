package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CostEstimate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_estimate);

        Button goBackButton = (Button) findViewById(R.id.goBackBtn);
        Button requestRideButton = (Button) findViewById(R.id.requestRideBtn);
        TextView milesResult = (TextView) findViewById(R.id.txtMilesResult);
        TextView carResult = (TextView) findViewById(R.id.txtCarResult);
        TextView finalCost = (TextView) findViewById(R.id.txtFinalCost);
        ImageView carResultImage = (ImageView) findViewById(R.id.theCarResultImg) ;

        //getting shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        //setting up string to display data
        String theMilesResult = sharedPreferences.getString("userMiles","");
        String theCarResult = sharedPreferences.getString("rideChoice","");
        String theFinalCost = sharedPreferences.getString("totalCost","");

        //setting the text views
        milesResult.setText("Trip Miles: " + theMilesResult);
        carResult.setText("Car Selection: " + theCarResult);
        finalCost.setText("Trip Cost: " + "$"+theFinalCost);

        //setting car result image
        if(theCarResult.equals("SmartCar")){
            carResultImage.setImageResource(R.drawable.smartcar);


        }
        else if(theCarResult.equals("TraditionalSedan")){
            carResultImage.setImageResource(R.drawable.supra);


        }
        else if(theCarResult.equals("MiniVan")){
            carResultImage.setImageResource(R.drawable.minivan);

        }


        //setting up buttons to go to different views
        //going back to main screen
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CostEstimate.this,MainActivity.class));
            }
        });
        //getting driver ETA Screen
        requestRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CostEstimate.this,DisplayDriver.class));
            }
        });


    }
}