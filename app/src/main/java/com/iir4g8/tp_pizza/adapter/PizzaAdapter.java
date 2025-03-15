package com.iir4g8.tp_pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.iir4g8.tp_pizza.R;
import com.iir4g8.tp_pizza.beans.Pizza;

public class PizzaAdapter extends BaseAdapter {
    private List<Pizza> pizzas;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Pizza> pizzas) {
        this.pizzas = pizzas;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.pizza_item, null);

        TextView idp = convertView.findViewById(R.id.idf);
        TextView name = convertView.findViewById(R.id.nom);
        TextView prepTime = convertView.findViewById(R.id.quantite);
        ImageView photo = convertView.findViewById(R.id.photo);

        idp.setText(String.valueOf(pizzas.get(position).getId()));
        name.setText(pizzas.get(position).getName());
        prepTime.setText(pizzas.get(position).getPrepTime() + " min");
        photo.setImageResource(pizzas.get(position).getImageResource());

        return convertView;
    }
}
