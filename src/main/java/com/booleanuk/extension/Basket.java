package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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

        BigDecimal discount = calculateDiscounts().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.subtract(discount);
    }

    public Map<Product, BigDecimal> calculateDiscounts() {
        Map<Product, Long> quantities = getProductQuantities();
        Map<Product, BigDecimal> discounts = new HashMap<>();

        Map<String, List<Bagel>> discountedBagels = getBagels().stream().collect(groupingBy(Bagel::getSku));

        quantities.forEach((product, quantity) -> {
            switch (product.getSku()) {
                case "BGLO", "BGLE" -> {
                    long discounted = quantity / 6;
                    discounts.put(product, BigDecimal.valueOf(discounted * 0.45));
                    discountedBagels.get(product.getSku()).subList(0, (int) (discounted * 6)).clear();
                }
                case "BGLP" -> {
                    long discounted = quantity / 12;
                    discounts.put(product, BigDecimal.valueOf(discounted * 0.69));
                    discountedBagels.get(product.getSku()).subList(0, (int) (discounted * 12)).clear();
                }
            }
        });

        quantities.forEach((product, quantity) -> {
            if (product.getSku().equals("COFB")) {
                List<Bagel> bagels = discountedBagels.values().stream()
                        .flatMap(List::stream)
                        .sorted(Comparator.comparing(Bagel::getPrice))
                        .toList();

                BigDecimal discount = BigDecimal.ZERO;

                BigDecimal coffeePrice = product.getPrice();
                long coffeeQuantity = quantity;

                for (Bagel bagel : bagels) {
                    if (coffeeQuantity == 0)
                        break;

                    BigDecimal bagelPrice = bagel.getPrice();
                    discount = discount.add(coffeePrice.add(bagelPrice).subtract(BigDecimal.valueOf(1.25)));
                    coffeeQuantity--;
                }

                discounts.put(product, discount);
            }
        });
        return discounts;
    }

    private Map<Product, Long> getProductQuantities() {
        return products.stream().collect(groupingBy(product -> product, Collectors.counting()));
    }

    private List<Bagel> getBagels() {
        return products.stream().filter(p -> p.getName().equals("Bagel")).map(p -> (Bagel) p).toList();
    }
}
