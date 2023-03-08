package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double  initialFee = 3;
    double additionalFee;
    double mileageRate = 3.25;
    double userMiles;
    double totalCost;
    double mileageCost;
    String rideChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText enteredUserMiles = (EditText) findViewById(R.id.txtUserMiles);
        Spinner userRideOption = (Spinner) findViewById(R.id.theRideOptions);
        Button theButton = (Button) findViewById(R.id.btnEstimateCost);


        //the method to calculate the cost and send the user to the estimate cost screen
        //calculated cost and ride option passed through shared preference

        theButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMiles = Integer.parseInt(enteredUserMiles.getText().toString());
                String theUserMiles = new Double(userMiles).toString();
                rideChoice = userRideOption.getSelectedItem().toString();

                //if statement to check user ride option and change additional  cost based on ride choice

                if(rideChoice.equals("SmartCar")){
                    additionalFee=2;

                }
                else if(rideChoice.equals("TraditionalSedan")){
                    additionalFee=0;
                }
                else if(rideChoice.equals("MiniVan")){
                    additionalFee=5;
                }


                //calculating mile cost
                mileageCost = userMiles * mileageRate;

                //calculating total cost

                totalCost = mileageCost + initialFee + additionalFee;

                String theTotalCost = new Double(totalCost).toString();


                //testing math with toast
                String toastTest = "Final price: " +"$" + totalCost + "Selected Vehicle:" +rideChoice;
                Toast.makeText(getApplicationContext(),toastTest ,Toast.LENGTH_LONG).show();


                //creating preferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //adding data to be passed to preferences
                editor.putString("rideChoice",rideChoice);
                editor.putString("userMiles",theUserMiles);
                editor.putString("totalCost",theTotalCost);

                //applying editor

                editor.apply();

                //going to cost estimate activity
                startActivity(new Intent(MainActivity.this,CostEstimate.class));


            }
        });


    }
}