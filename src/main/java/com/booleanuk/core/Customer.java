package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Customer {

    private Basket basket;
    private Map<String, ArrayList<Double>> discounts;


    public Customer() {
        this.discounts = new HashMap<>();


    }

    public double getTotalCost(Map<Item,Integer> items) {
        double cost = 0.00;
        int discount12 = 0;
        int discount6 = 0;
        this.discounts = new HashMap<>();
        ArrayList<Item> restBagelsList = new ArrayList<>();
        ArrayList<Item> restCoffeesList = new ArrayList<>();

        Inventory inventory = new Inventory();
        for(Map.Entry<Item, Integer> entry : items.entrySet()) {

            if(inventory.getBagels().containsKey(entry.getKey().getSkuCode())) {

                int quantity = entry.getValue();

                while(quantity >= 12) {
                    quantity -= 12;
                    discount12++;
                    this.addDiscount(entry.getKey().getSkuCode(), (entry.getKey().getPrice()* 12) - 3.99);

                }

                if(quantity >= 6) {
                    quantity-= 6;
                    discount6++;
                    this.addDiscount(entry.getKey().getSkuCode(), (entry.getKey().getPrice()*6) - 2.49);
                }


                for(int i = 0; i < quantity; i++) {
                    restBagelsList.add(entry.getKey());

                }
            }



            if(inventory.getCoffees().containsKey(entry.getKey().getSkuCode())) {
                for(int i = 0; i < entry.getValue(); i++) {
                    restCoffeesList.add(entry.getKey());
                }

            }
            if(inventory.getFillings().containsKey(entry.getKey().getSkuCode())) {
                cost += entry.getKey().getPrice();
            }
        }

        if(restCoffeesList.size() <= restBagelsList.size()) {
                for (int i = 0; i < restBagelsList.size(); i++) {
                    if(i <= restCoffeesList.size() -1) {
                        cost += 1.25;
                        this.addDiscount("CoffeeBagelDeal" ,  restBagelsList.get(i).getPrice() + restCoffeesList.get(i).getPrice() - 1.25);

                    } else {
                        cost += restBagelsList.get(i).getPrice();
                    }

                }
        } else {
            for (int i = 0; i < restCoffeesList.size(); i++) {
                if(i <= restBagelsList.size() -1 ) {
                    cost += 1.25;
                    this.addDiscount("CoffeeBagelDeal" ,  restBagelsList.get(i).getPrice() + restCoffeesList.get(i).getPrice() - 1.25);
            } else {
                    cost += restCoffeesList.get(i).getPrice();
                }
            }
        }

            cost +=discount12 *3.99;
            cost +=discount6 *2.49;


        BigDecimal costRounded = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);

        return Double.parseDouble(String.valueOf(costRounded));

        }

    private void addDiscount(String sku, double v) {
        if(this.discounts.get(sku) != null) {
            ArrayList<Double> newList = new ArrayList<>(this.discounts.get(sku));
            newList.add(v);
            this.discounts.put(sku, newList);
        } else {
            ArrayList<Double> newList = new ArrayList<>();
            newList.add(v);
            this.discounts.put(sku, newList);
        }
    }

    public double getCostOfItem(Item item) {
        return item.getPrice();
    }

    public boolean setBasket(Basket basket) {
        this.basket = basket;
        return true;

    }

    public Basket getBasket() {
        return this.basket;
    }

/*
    public double getCostOfFillingsInBasket(Map<Item, Integer> basket) {
        return this.getTotalCost(basket.entrySet().stream().filter(item -> item.getKey().getName().equalsIgnoreCase("Filling")).collect(Collectors.toList()));
    }
*/


    public Map<String, Double> getFillingsInInventory() {
        Inventory inventory = new Inventory();

        return inventory.getFillings();


    }


    public boolean order(String skuCode) {
        Inventory inventory = new Inventory();

        return inventory.getInventoryMap().containsKey(skuCode);
    }

    public Map<String, ArrayList<Double>> getDiscounts() {
        return this.discounts;
    }

}