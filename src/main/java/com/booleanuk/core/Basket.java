package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Basket {
    private static final int DEFAULT_CAPACITY = 3;
    private static int capacity = DEFAULT_CAPACITY;
    private int basketCapacity;

    private ArrayList<Product> products = new ArrayList<>();

    public Basket() {
        this.basketCapacity = capacity;
    }

    public void addProduct(Product product){
        if (products.size() < basketCapacity)
            products.add(product);
        else
            throw new IllegalStateException("Capacity full you can not add more products");
    }

    public void removeProduct(Product product){
        if (products.contains(product))
            products.remove(product);
        else
            throw new IllegalStateException("You do not have that product on your basket");
    }

    public ArrayList<Product> getBagelsInBasket() {
        return products;
    }

    public BigDecimal getBasketPrice(){
       return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void changeBasketCapacity(int newCapacity){
        capacity = newCapacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getBasketCapacity(){
        return basketCapacity;
    }

    public void getFillingTypes(){
        for (FillingType fType : FillingType.values()){
            System.out.println(
                    fType + " " + fType.getVariant()+ " " + fType.getPrice()
            );
        }
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.getFillingTypes();
    }
}