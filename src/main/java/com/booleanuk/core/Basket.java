package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final HashMap<Product,Integer> items;
    private int capacity;
    private final int[] discounts;

    public Basket(int maxCapacity) {
        this.items = new HashMap<>();
        this.capacity = maxCapacity;
        this.discounts = new int[Discounts.values().length];
    }

    public int getCapacity() {
        return capacity;
    }

    private int getSize() {
        int size = 0;
        for (int item: this.items.values()){
            size += item;
        }
        return size;
    }

    public boolean addProduct(Product product){
        if (this.getSize() == this.capacity){
            return false;
        }
        int quantity = this.items.getOrDefault(product,0);
        this.items.put(product,quantity+1);
        return true;
    }

    public boolean removeProduct(Product product){
        boolean flag = true;
        int quantity = this.items.getOrDefault(product, 0);
        switch (quantity){
            case 0 -> flag = false;
            case 1 -> this.items.remove(product);
            default -> this.items.replace(product, quantity-1);
        }
        return flag;
    }

    public boolean setCapacity(int newCapacity) {
        if (newCapacity > this.capacity){
            this.capacity = newCapacity;
            return true;
        }
        System.out.println("New capacity must be bigger than the current one.");
        return false;
    }

    public double getTotalCost() {
        double cost = 0.00d;
        if (this.items.isEmpty()) return cost;
        for (Map.Entry<Product,Integer> item: this.items.entrySet()) {
            cost += (double) ((int) (item.getKey().getCost() * 100) * item.getValue()) / 100;
        }
        return cost - this.getDiscount();
    }

    public String showProducts() {
        if (getSize() == 0){
            return "Basket is empty.\n";
        }
        StringBuilder result = new StringBuilder();
        double cost;
        for (Map.Entry<Product,Integer> entry : this.items.entrySet()) {
            cost = (double) (int) (entry.getValue() * entry.getKey().getCost() * 100) / 100;
            result.append(entry.getValue()).append("x ").append(entry.getKey().getSku()).append(" = ").append(cost).append("$\n");
        }
        return String.valueOf(result);
    }

    public String calculateDiscount() {
        if (getSize() == 0){
            return "";
        }
        StringBuilder discountText = new StringBuilder();
        int times, quantity;
        double discountPrice;
        int bagelRemainder = 0;
        int coffeeRemainder = 0;
        for (Map.Entry<Product, Integer> entry : this.items.entrySet()){
            if (entry.getKey() instanceof Bagel){
                quantity = entry.getValue();
                times = quantity / 6;
                if (times > 0) {
                    this.discounts[0] = times;
                    discountPrice = times * Discounts.SixBagels.getAmount();
                    discountText.append(times).append("x SixBGLDiscount  (-").append(discountPrice).append("$)\n");
                    quantity -= times * 6;
                }
                times = quantity / 3;
                if (times > 0) {
                    this.discounts[1] = times;
                    discountPrice = times * Discounts.ThreeBagels.getAmount();
                    discountText.append(times).append("x ThreeBGLDiscount (-").append(discountPrice).append("$)\n");
                    quantity -= times * 3;
                }
                bagelRemainder += quantity;
            }
            if (entry.getKey() instanceof Coffee){
                coffeeRemainder += entry.getValue();
            }
        }
        if (bagelRemainder != 0 && coffeeRemainder != 0){
            if (bagelRemainder > coffeeRemainder) {
                bagelRemainder = coffeeRemainder;
            }
            this.discounts[2] = bagelRemainder;
            discountPrice = bagelRemainder * Discounts.CoffeeAndBagel.getAmount();
            discountText.append(bagelRemainder).append("x COFBGLDiscount (-").append(discountPrice).append("$)\n");
        }
        return String.valueOf(discountText);
    }

    public double getDiscount() {
        int multiplier;
        Discounts[] discounts = Discounts.values();
        double savedAmount = 0;
        for (int i=0; i<Discounts.values().length; i++) {
            multiplier = this.discounts[i];
            if (multiplier != 0) {
                savedAmount += multiplier * discounts[i].getAmount();
            }
        }
        return savedAmount;
    }
}
