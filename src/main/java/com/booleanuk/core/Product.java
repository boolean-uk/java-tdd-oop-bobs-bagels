package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Product {

    private String name ="";
    private double price;
    private String skw;

    private ArrayList<Product> fillings = new ArrayList<>();

    public Product() {
    }

    public Product(String name, double price, String skw) {
        this.name = name;
        this.price = price;
        this.skw = skw;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSkw() {
        return skw;
    }

    public void setSkw(String skw) {
        this.skw = skw;
    }

    public ArrayList<Product> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<Product> fillings) {
        this.fillings = fillings;
    }

    public abstract double getTotalCostOfProduct();


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;

        return other.getName().equals(name);
    }

}
