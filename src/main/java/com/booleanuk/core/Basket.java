package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private List<Product> basket;
    private final List<Product> inventory;
    private final List<Product> fillings;

    private double total;
    private int capacity;


    public void getFillings(){
        Inventory inv = new Inventory();
        for (int i = 0; i < inv.getProducts().size(); i++) {
            if(Objects.equals(inv.getProducts().get(i).getItemName(), "Filling")){
                //System.out.println("Added item!");
                fillings.add(inv.getProducts().get(i));
            }
        }
    }


    public Basket(Inventory inv){
        this.inventory = inv.getProducts();
        this.basket = setBasket();
        this.total = setTotal();
        this.capacity = setCapacity();
        this.fillings = new ArrayList<>();
        getFillings();
    }


    public boolean add(Product product){
        if(checkIfBasketIsFull()){
            return false;
        }
        for (Product value : inventory) {
            // product is a filling
            if(product instanceof Filling){
                for (Product item : this.basket) {
                    //find bagel with empty filling
                    if (item instanceof Bagel) {
                        if (((Bagel) item).getFilling() == null) {
                            // add filling :D
                            ((Bagel) item).addFilling((Bagel) item, (Filling) product);
                            System.out.println("ADDED FILLING TO BAGEL");
                            return true;
                        }
                    }
                }
            }

            if (Objects.equals(value.getSku(), product.getSku())) {
                if(!checkIfBasketIsFull()){
                    basket.add(product);
                    System.out.println("Added " + product.getItemName() + " with the price of: $" + product.getPrice());
                    this.total += product.getPrice();
                    return true;
                }
            }
        }
        System.out.println("Could not add product");
        return false;
    }

    public boolean remove(String productSKU){
        for (int i = 0; i < basket.size(); i++) {
            if(Objects.equals(basket.get(i).getSku(), productSKU)){
                System.out.println("Removing " + basket.get(i).getItemName() + " from list");
                this.total -= basket.get(i).getPrice();
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
    public double totalCost(){
        System.out.println("Total cost of basket: $" + this.getTotal());
        return this.getTotal();
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
