package com.booleanuk.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Basket {

    private int capacity;
    private HashMap<Product, Integer> basketList = new HashMap<>();
    private int productsQuantity;

    private Inventory inventory = new Inventory();

    public Basket() {
        this.capacity = 5;
    }

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public HashMap<Product, Integer> getBasketList() {
        return basketList;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getProductsQuantity() {
        return productsQuantity;
    }

    public String addProduct(Product product) {
        if (inventory.checkIfProductInInventory(product)) {
            if (product.getName().equals("Filling")) {
                List<Product> products = basketList.keySet()
                        .stream()
                        .filter(integer -> integer.getName().equals("Bagel"))
                        .toList();
                if (products.isEmpty()) return "There is no empty bagel to add filling";
                else {
                    System.out.println(products);
                    for (Product p : products) {
                        Bagel bagel;
                        if (p.getClass().equals(Bagel.class)) bagel = (Bagel) p;
                        else {
                            bagel = p.toBagel();
                        }
                        if (bagel.getFilling() == null) {
                            Product bagelOld = basketList.keySet().stream().
                                    filter(integer -> (integer.getSku().equals(bagel.getSku())
                                            && integer.getName().equals(bagel.getName())
                                            && integer.getVariant().equals(bagel.getVariant())
                                            && integer.getPrice() == bagel.getPrice())).findAny().get();
                            bagel.chooseFilling(product);
                            basketList.put(bagel, basketList.remove(bagelOld));
                            return "Product added";
                        }
                    }
                    return "There is no empty bagel to add filling";
                }
            }
            productsQuantity += 1;
            if (isOverfilled()) {
                productsQuantity -= 1;
                return "Basket is full";
            } else if (basketList.containsKey(product)) {
                basketList.replace(product, basketList.get(product) + 1);
                return "Product added";
            } else {
                basketList.put(product, 1);
                return "Product added";
            }
        } else return "Product is not in inventory";

    }

    public String addProduct(Product product, int quantity) {
        if (inventory.checkIfProductInInventory(product)) {
            if (product.getName().equals("Filling") && quantity > 1) return "You can add only 1 filling";
            else if(product.getName().equals("Filling") && quantity == 1){
               return addProduct(product);
            }
            productsQuantity += quantity;
            if (isOverfilled()) {
                productsQuantity -= quantity;
                return "Basket is full";
            } else if (basketList.containsKey(product)) {
                basketList.replace(product, basketList.get(product) + quantity);
                return "Product added";
            } else {
                basketList.put(product, quantity);
                return "Product added";
            }
        } else return "Product is not in inventory";
    }

    public String addProduct(String sku) {
        Product product = inventory.getProductBySKU(sku);
        if (product != null) {
            return this.addProduct(product);
        } else return "Product is not in inventory";
    }

    public String addProduct(String sku, int quantity) {
        Product product = inventory.getProductBySKU(sku);
        if (product != null) {
            if (product.getName().equals("Filling") && quantity > 1) return "You can add only 1 filling";
            else if(product.getName().equals("Filling") && quantity == 1){
                return addProduct(product);
            }
            return addProduct(product, quantity);
        } else return "Product is not in inventory";
    }

    public String addBagelByVariant(String variant) {
        Product product = inventory.getProductByNameAndVariant("Bagel", variant);
        if (product != null) {
            return this.addProduct(product);
        } else return "Product is not in inventory";
    }

    public String addBagelByVariant(String variant, int quantity) {
        Product product = inventory.getProductByNameAndVariant("Bagel", variant);
        if (product != null) {
            if (product.getName().equals("Filling") && quantity > 1) return "You can add only 1 filling";
            else if(product.getName().equals("Filling") && quantity == 1){
                return addProduct(product);
            }
            return addProduct(product, quantity);
        } else return "Product is not in inventory";
    }

    public boolean isOverfilled() {
        return productsQuantity > capacity;
    }


}
