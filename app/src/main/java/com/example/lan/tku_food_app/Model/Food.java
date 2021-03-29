package com.example.lan.tku_food_app.Model;

public class Food {
    private String Name,Image,Price,Calories,Restaurant,MenuId,Nutrition;

    public Food() {
    }

    public Food(String name, String image, String price, String calories, String restaurant, String menuId, String nutrition) {
        Name = name;
        Image = image;
        Price = price;
        Calories = calories;
        Restaurant = restaurant;
        Nutrition = nutrition;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String restaurant) {
        Restaurant = restaurant;
    }

    public String getNutrition() {
        return Nutrition;
    }

    public void setNutrition(String nutrition) {
        Nutrition = nutrition;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
