package com.booleanuk.extension;

public class DiscountItem implements Item {

    private String name1;
    private String name2;
    private String type;
    private String nametype;
    private double price;
    private int quantity;

    public DiscountItem(String name1, double price, int quantity) {
        this.name1 = name1;
        this.name2 = "";
        this.price = price;
        this.quantity = quantity;
    }

    public DiscountItem(String name1, String name2, double price, int quantity) {
        this.name1 = name1;
        this.name2 = name2;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name1;
    }

    public String getName2() {
        return name2;
    }



    public String getType() {
        return type;
    }

    public String getNametype() {
        return nametype;
    }

    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
