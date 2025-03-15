package com.iir4g8.tp_pizza

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var liste: ListView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        // Initialize ListView
        liste = findViewById(R.id.liste)
        
        // Set up the share button click listener
        val shareButton: ImageButton = findViewById(R.id.shareButton)
        shareButton.setOnClickListener {
            shareApp()
        }
        
        // Apply window insets to the root view
        val rootView = findViewById<android.view.View>(android.R.id.content)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    
    private fun shareApp() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Recipes App")
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome Pizza Recipes app!")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
