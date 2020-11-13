package com.newtech.android.fragmentpratice.model;

import java.io.Serializable;

public class DonutDTO implements Serializable {
    private int id;
    private String name;
    private String shortDesc;
    private String restaurantInfo;
    private double price;
    private int image;

    public DonutDTO(int id, String name, String shortDesc, String restaurantInfo, double price, int image) {
        this.id = id;
        this.name = name;
        this.shortDesc = shortDesc;
        this.restaurantInfo = restaurantInfo;
        this.price = price;
        this.image = image;
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(String restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
