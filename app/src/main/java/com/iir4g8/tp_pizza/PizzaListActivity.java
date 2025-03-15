package com.iir4g8.tp_pizza;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.iir4g8.tp_pizza.adapter.PizzaAdapter;
import com.iir4g8.tp_pizza.beans.Pizza;
import com.iir4g8.tp_pizza.service.PizzaService;

public class PizzaListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private PizzaService pizzaService = PizzaService.getInstance();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);
        listView = findViewById(R.id.liste);

        if (pizzaService.findAll().isEmpty()) {
            // Add sample pizza data
            pizzaService.create(new Pizza("Margherita", 30, R.mipmap.pizza1,
                "Classic Italian pizza with tomato sauce, mozzarella, and basil.\n\n" +
                "Ingredients:\n" +
                "- Pizza dough\n" +
                "- 1/2 cup tomato sauce\n" +
                "- 8 oz fresh mozzarella, sliced\n" +
                "- Fresh basil leaves\n" +
                "- 2 tbsp olive oil\n" +
                "- Salt to taste\n\n" +
                "Instructions:\n" +
                "1. Preheat oven to 475°F (245°C).\n" +
                "2. Roll out the dough into a 12-inch circle.\n" +
                "3. Spread tomato sauce evenly over the dough.\n" +
                "4. Arrange mozzarella slices on top.\n" +
                "5. Bake for 10-12 minutes until crust is golden.\n" +
                "6. Remove from oven and top with fresh basil leaves.\n" +
                "7. Drizzle with olive oil and sprinkle with salt.\n" +
                "8. Slice and serve immediately."));
                
            pizzaService.create(new Pizza("Pepperoni", 35, R.mipmap.pizza9,
                "American favorite topped with spicy pepperoni slices.\n\n" +
                "Ingredients:\n" +
                "- Pizza dough\n" +
                "- 1/2 cup tomato sauce\n" +
                "- 1 1/2 cups shredded mozzarella\n" +
                "- 3-4 oz pepperoni slices\n" +
                "- 1 tbsp olive oil\n" +
                "- 1 tsp dried oregano\n\n" +
                "Instructions:\n" +
                "1. Preheat oven to 475°F (245°C).\n" +
                "2. Roll out the dough into a 12-inch circle.\n" +
                "3. Spread tomato sauce evenly over the dough.\n" +
                "4. Sprinkle mozzarella cheese over the sauce.\n" +
                "5. Arrange pepperoni slices on top.\n" +
                "6. Sprinkle with oregano and drizzle with olive oil.\n" +
                "7. Bake for 12-15 minutes until cheese is bubbly and crust is golden.\n" +
                "8. Let cool for 2 minutes before slicing and serving."));
                
            pizzaService.create(new Pizza("Hawaiian", 40, R.mipmap.pizza3,
                "Sweet and savory pizza topped with ham and pineapple.\n\n" +
                "Ingredients:\n" +
                "- Pizza dough\n" +
                "- 1/2 cup tomato sauce\n" +
                "- 1 1/2 cups shredded mozzarella\n" +
                "- 4 oz ham, diced\n" +
                "- 4 oz pineapple chunks, drained\n" +
                "- 1 tbsp olive oil\n\n" +
                "Instructions:\n" +
                "1. Preheat oven to 475°F (245°C).\n" +
                "2. Roll out the dough into a 12-inch circle.\n" +
                "3. Spread tomato sauce evenly over the dough.\n" +
                "4. Sprinkle mozzarella cheese over the sauce.\n" +
                "5. Distribute ham and pineapple evenly on top.\n" +
                "6. Drizzle with olive oil.\n" +
                "7. Bake for 12-15 minutes until cheese is melted and crust is golden.\n" +
                "8. Let cool slightly before slicing and serving."));
                
            pizzaService.create(new Pizza("Vegetarian", 45, R.mipmap.pizza6,
                "Healthy pizza loaded with colorful vegetables.\n\n" +
                "Ingredients:\n" +
                "- Pizza dough\n" +
                "- 1/2 cup tomato sauce\n" +
                "- 1 1/2 cups shredded mozzarella\n" +
                "- 1/2 bell pepper, sliced\n" +
                "- 1/2 red onion, thinly sliced\n" +
                "- 1/2 cup mushrooms, sliced\n" +
                "- 1/4 cup black olives, sliced\n" +
                "- 1 tbsp olive oil\n" +
                "- 1 tsp dried basil\n" +
                "- 1 tsp dried oregano\n\n" +
                "Instructions:\n" +
                "1. Preheat oven to 475°F (245°C).\n" +
                "2. Roll out the dough into a 12-inch circle.\n" +
                "3. Spread tomato sauce evenly over the dough.\n" +
                "4. Sprinkle mozzarella cheese over the sauce.\n" +
                "5. Arrange vegetables on top.\n" +
                "6. Sprinkle with dried herbs and drizzle with olive oil.\n" +
                "7. Bake for 15-18 minutes until vegetables are tender and crust is golden.\n" +
                "8. Let cool slightly before slicing and serving."));
        }
        
        listView.setAdapter(new PizzaAdapter(this, pizzaService.findAll()));
        listView.setOnItemClickListener(this);

        ImageButton shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Recipes App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this amazing Pizza Recipes app!");
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final TextView idView = view.findViewById(R.id.idf);
        TextView nameView = view.findViewById(R.id.nom);

        Intent intent = new Intent(PizzaListActivity.this, PizzaDetailsActivity.class);
        intent.putExtra("pizza_id", idView.getText().toString());
        startActivity(intent);

    }
}

