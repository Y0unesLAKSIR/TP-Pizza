package com.iir4g8.tp_pizza.beans;

public class Pizza {

    private int id;
    private String name;
    private int prepTime; // in minutes
    private int imageResource;
    private String recipe;

    private static int counter;

    public Pizza() {
    }

    public Pizza(String name, int prepTime, int imageResource, String recipe) {
        this.id = ++counter;
        this.name = name;
        this.prepTime = prepTime;
        this.imageResource = imageResource;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
