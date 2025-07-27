package com.example.api; // Update with your actual package name

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LearnDerivativesActivity extends AppCompatActivity {

    private TextView tvDerivatives, tvDerivativesContent;
    private TextView tvFutures, tvFuturesContent;
    private TextView tvOptions, tvOptionsContent;
    private TextView tvCallPut, tvCallPutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_derivatives);


        tvDerivatives = findViewById(R.id.tv_derivatives);
        tvDerivativesContent = findViewById(R.id.tv_derivatives_content);
        tvFutures = findViewById(R.id.tv_futures);
        tvFuturesContent = findViewById(R.id.tv_futures_content);
        tvOptions = findViewById(R.id.tv_options);
        tvOptionsContent = findViewById(R.id.tv_options_content);
        tvCallPut = findViewById(R.id.tv_call_put);
        tvCallPutContent = findViewById(R.id.tv_call_put_content);


        tvDerivatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(tvDerivativesContent);
            }
        });

        tvFutures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(tvFuturesContent);
            }
        });

        tvOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(tvOptionsContent);
            }
        });

        tvCallPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(tvCallPutContent);
            }
        });
    }

    // Method to toggle visibility
    private void toggleVisibility(View view)
    {
        if (view.getVisibility() == View.VISIBLE)
        {
            view.setVisibility(View.GONE);
        }
        else
        {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
