package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.sql.Time;


public class DisplayDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_driver);

        TextView estimatedTime = (TextView) findViewById(R.id.txtEstimatedTime);

        //setting up random time
        final Random random = new Random();
        final int millisInDay = 24*60*60*1000;
        Time time = new Time((long)random.nextInt(millisInDay));
        //displaying random time
        estimatedTime.setText("Driver ETA: " +time);



    }
}