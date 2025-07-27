package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStockPrice = findViewById(R.id.buttonStockPrice);
        ImageButton buttonLearn = findViewById(R.id.buttonLearn);
        Button buttonOption = findViewById(R.id.buttonOther1);
        //Button buttonOther2 = findViewById(R.id.buttonOther2);

        // Set up button click listeners
        buttonLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearnDerivativesActivity.class);
                startActivity(intent);
            }
        });

        buttonStockPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, API.class);
                startActivity(i); // Start the new activity
            }
        });

        buttonOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, Options.class);
                startActivity(i1); // Start the new activity
            }
        });
}
}
