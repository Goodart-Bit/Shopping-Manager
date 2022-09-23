package com.example.shoppingmanager;

public class Product {
    private String name;
    private String type;
    private String price;
    private String details;

    public Product(String name, String type, String price, String details) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.details = details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String toString(){
        return "Name: " + name + "\n" +
                "  Type: " + type + "\n" +
                "  Price: " + price + "\n" +
                "  Details: " + details;
    }
}
