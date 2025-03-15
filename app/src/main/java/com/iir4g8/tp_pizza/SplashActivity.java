package com.iir4g8.tp_pizza;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private ProgressBar loadingIndicator;
    private TextView loadingText;
    private static final int SPLASH_TIMEOUT = 3000; // 3 seconds
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize views
        logo = findViewById(R.id.logo);
        loadingIndicator = findViewById(R.id.loadingIndicator);
        loadingText = findViewById(R.id.loadingText);
        
        // Use Handler to delay the transition to the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity after the delay
                Intent intent = new Intent(SplashActivity.this, PizzaListActivity.class);
                startActivity(intent);
                finish(); // Close the splash activity
            }
        }, SPLASH_TIMEOUT);
    }
}
