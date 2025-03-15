package com.iir4g8.tp_pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.iir4g8.tp_pizza.beans.Pizza;
import com.iir4g8.tp_pizza.service.PizzaService;

public class PizzaDetailsActivity extends AppCompatActivity {
    private PizzaService pizzaService;
    private ImageView imageView;
    private TextView recipeText;
    private TextView nameText;
    private TextView prepTimeText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_details);
        
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("pizza_id"));
        
        pizzaService = PizzaService.getInstance();
        imageView = findViewById(R.id.photo);
        nameText = findViewById(R.id.nom);
        recipeText = findViewById(R.id.desc);
        prepTimeText = findViewById(R.id.prepTime);

        Pizza pizza = pizzaService.findById(id);
        if (pizza != null) {
            imageView.setImageResource(pizza.getImageResource());
            recipeText.setText(pizza.getRecipe());
            nameText.setText(pizza.getName());
            prepTimeText.setText("Preparation Time: " + pizza.getPrepTime() + " min");
        }

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Recipe: " + nameText.getText().toString());
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this amazing recipe for " + 
                                    nameText.getText().toString() + "!\n\n" + recipeText.getText().toString());
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}
