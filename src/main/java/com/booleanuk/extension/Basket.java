package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Basket {

    private List<Product> products;
    private int capacity;

    public Basket( int capacity) {
        products = new ArrayList<>(0);
        this.capacity = capacity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        int sum = products.size();
        for(Product p : products){
            sum+= p.getSize();
        }
        if(sum<capacity) return false;
        return true;
    }

    public void add(Product product){
        if(isFull()) return;
        products.add(product);
    }

    public boolean doesProductExist(Product product) {
        if(products.contains(product)) return true;
        return false;
    }
    public void remove(Product product) {
        if(doesProductExist(product)) products.remove(product);
    }

    public BigDecimal totalCost() {
        BigDecimal sum = BigDecimal.ZERO;
        for(Product p : products){
            sum=sum.add(p.getPrice());
        }
        return sum;
    }

    public Map<Product, BigDecimal> calculateDiscounts() {
        Map<Product, Integer> quantities = new HashMap<>();
        Map<Product, Integer> nonDiscountedQuantities = new HashMap<>();
        Map<Product, BigDecimal> discounts = new HashMap<>();

        for(Product p : products) {
            quantities.putIfAbsent(p, 0);
            quantities.put(p, quantities.get(p) + 1);
        }

        quantities.forEach((product, quantity) -> {
            switch (product.getSku()) {
                case "BGLO", "BGLE" -> {
                    int discounted = quantity / 6;
                    discounts.put(product, BigDecimal.valueOf(discounted * 0.45));
                    nonDiscountedQuantities.put(product, quantity % 6);
                }
                case "BGLP" -> {
                    int discounted = quantity / 12;
                    discounts.put(product, BigDecimal.valueOf(discounted * 0.69));
                    nonDiscountedQuantities.put(product, quantity % 12);
                }
//                case "COFB" -> {
//                    Optional<BigDecimal> cheapestBagelCost = products.stream()
//                            .filter(p -> p.getName().equals("Bagel"))
//                            .map(p -> (Bagel) p)
//                            .map(Bagel::getBagelPrice)
//                            .sorted()
//                            .findFirst();
//
//                    cheapestBagelCost.ifPresent(cbc -> {
//                        BigDecimal discount = cbc.add(product.getPrice()).subtract(BigDecimal.valueOf(1.25));
//                        discounts.put(product, discount);
//                    });
//                }
            }

        });

        quantities.forEach((product, quantity) -> {
            if(!product.getSku().equals("COFB"))
                return;


        });
    }
}
