package com.booleanuk.core;

public class BasketItem implements Item{
    private String name;
    private String type;
    private String nametype;
    private int quantity;
    private double price;
    private String[] fillings;
    private int numFillings;
    private int numDiscountItems = 0;
    private int num12Discount = 0;
    private int num6Discount = 0;
    private double discountPrice = 0.0;
    private double saved = 0.0;

    public BasketItem(String name, String type, int quantity, double price) {
        this.name = name;
        this.type = type;
        this.nametype = name + " " + type;
        this.quantity = quantity;
        this.price = price;
    }

    public BasketItem(String name, String nametype, int quantity, double price, String[] fillings) {
        this.name = name;
        this.nametype = nametype;
        this.quantity = quantity;
        this.price = price;
        this.fillings = fillings;
        this.numFillings = fillings.length;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    public String getNametype() {
        return nametype;
    }

    public String[] getFillings() {
        return fillings;
    }

    public void setFillings(String[] fillings) {
        this.fillings = fillings;
    }

    public int getNumFillings() {
        return numFillings;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setType(String type) {
        this.type = type;
    }

    public int getNumDiscountItems() {
        return numDiscountItems;
    }

    public void setNumDiscountItems(int numDiscountItems) {
        this.numDiscountItems = numDiscountItems;
    }

    public int getNum12Discount() {
        return num12Discount;
    }

    public void setNum12Discount(int num12Discount) {
        this.num12Discount = num12Discount;
    }

    public int getNum6Discount() {
        return num6Discount;
    }

    public void setNum6Discount(int num6Discount) {
        this.num6Discount = num6Discount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getSaved() {
        return saved;
    }

    public void setSaved(double saved) {
        this.saved = saved;
    }

    public void resetDiscount() {
        this.numDiscountItems = 0;
        this.num12Discount = 0;
        this.num6Discount = 0;
        this.discountPrice = 0.0;
        this.saved = 0.0;
    }
}
