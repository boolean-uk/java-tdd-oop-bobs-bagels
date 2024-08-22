package com.booleanuk.core;

import com.booleanuk.extension.DiscountHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private List<Product> basket;
    private int capacity;
    Inventory inventory;

    public Basket(){
        this.basket = setBasket();
        this.inventory = new Inventory();
        this.capacity = setCapacity();
    }

    public void getFillings(Inventory inv){
        for (int i = 0; i < inv.getProducts().size(); i++) {
            if(Objects.equals(inv.getProducts().get(i).getItemName(), "Filling")){
                System.out.println("Filling : "+ inv.getProducts().get(i).getVariant());
            }
        }
    }

    public boolean add(Product product){
        if(inventory.ProductInList(product.getSku()) && !checkIfBasketIsFull()){
            basket.add(product);
            System.out.println("Added " + product.getItemName() + " with the price of: $" + product.getPrice());
            return true;
        }
        System.out.println("Could not add product");
        return false;
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

    public double calculateTotal(){
        double cost = 0;
        for (Product product : this.basket) {
            cost += product.getPrice();
        }
        double discount;
        discount = DiscountHandler.applyDiscount(this);
        // System.out.println("DISCOUNT IS : " + discount);
        double total = cost - discount;
        String formattedDoubleString = String.format("%.2f", total);
        return Double.parseDouble(formattedDoubleString);
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
