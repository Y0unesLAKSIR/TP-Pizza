package com.iir4g8.tp_pizza.service;

import java.util.ArrayList;
import java.util.List;

import com.iir4g8.tp_pizza.beans.Pizza;
import com.iir4g8.tp_pizza.dao.IDao;

public class PizzaService implements IDao<Pizza> {
    private List<Pizza> pizzas;
    private static PizzaService instance;

    private PizzaService() {
        this.pizzas = new ArrayList<>();
    }

    public static PizzaService getInstance() {
        if(instance == null)
            instance = new PizzaService();
        return instance;
    }

    @Override
    public boolean create(Pizza o) {
        return pizzas.add(o);
    }

    @Override
    public boolean update(Pizza o) {
        return false;
    }

    @Override
    public boolean delete(Pizza o) {
        return pizzas.remove(o);
    }

    @Override
    public Pizza findById(int id) {
        for(Pizza p : pizzas){
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    @Override
    public List<Pizza> findAll() {
        return pizzas;
    }
}
