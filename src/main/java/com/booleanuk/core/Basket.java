package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private List<Product> basket;
    private List<Product> inventory;
    private double total;
    private int capacity;


    public Basket(Inventory inv){
        this.inventory = inv.getProducts();
        this.basket = setBasket();
        this.total = setTotal();
        this.capacity = setCapacity();
    }

    public boolean add(Product product){
        for (Product value : inventory) {
            if (Objects.equals(value.getSku(), product.getSku())) {
                basket.add(product);
                System.out.println("Added " + product.getItemName() + " with the price of: $" + product.getPrice());
                this.total += product.getPrice();
                return true;
            }
        }
        System.out.println("Could not add bagel");
        return false;
    }

    public double totalCost(){
        System.out.println("Total cost of basket: $" + this.total);
        return this.total;
    }

    public boolean remove(String productSKU){
        for (int i = 0; i < basket.size(); i++) {
            if(Objects.equals(basket.get(i).getSku(), productSKU)){
                System.out.println("Removing " + basket.get(i).getItemName() + " from list");
                basket.remove(basket.get(i));
                return true;
            }
        }
        System.out.println("Product not found not found");
        return false;
    }

    public boolean checkIfBasketIsFull(){
        if(basket.size() >= capacity){
            System.out.println("Basket is full");
            return true;
        }
        System.out.println("Basket is not full");
        return false;
    }

    public void changeCapacity(int capacity){
        this.capacity = capacity;
    }

    public double setTotal(){
        return 0;
    }
    public double getTotal(){
        return this.total;
    }
    public List<Product> setBasket(){
        return new ArrayList<>();
    }
    public List<Product> getBasket(){
        return this.basket;
    }
    public int setCapacity(){
        return 5;
    }

    public void clearList(){
        this.basket.clear();
    }
}
