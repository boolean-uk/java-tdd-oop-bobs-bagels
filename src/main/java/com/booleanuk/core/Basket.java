package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.*;
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
            if (product.name.equals("Filling")) {
                List<Product> products = basketList.keySet()
                        .stream()
                        .filter(integer -> integer.name.equals("Bagel"))
                        .toList();
                if (products.isEmpty()) return "There is no empty bagel to add filling";
                else {
                    for (Product p : products) {
                        Bagel bagel;
                        if (p.getClass().equals(Bagel.class)) bagel = (Bagel) p;
                        else {
                            bagel = p.toBagel();
                        }
                        if (bagel.getFilling() == null) {
                            Product bagelOld = basketList.keySet().stream().
                                    filter(item -> (item.sku.equals(bagel.sku)
                                            && item.name.equals(bagel.name)
                                            && item.variant.equals(bagel.variant)
                                            && item.price == bagel.price)).findAny().get();
                            bagel.chooseFilling((Filling)product);
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
            if (product.name.equals("Filling") && quantity > 1) return "You can add only 1 filling";
            else if (product.name.equals("Filling") && quantity == 1) {
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
            if (product.name.equals("Filling") && quantity > 1) return "You can add only 1 filling";
            else if (product.name.equals("Filling") && quantity == 1) {
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
            if (product.name.equals("Filling") && quantity > 1) return "You can add only 1 filling";
            else if (product.name.equals("Filling") && quantity == 1) {
                return addProduct(product);
            }
            return addProduct(product, quantity);
        } else return "Product is not in inventory";
    }

    public boolean isOverfilled() {
        return productsQuantity >= capacity;
    }


    public String removeProduct(Product product) {
        if (inventory.checkIfProductInInventory(product)) {
            Optional<Product> productToRemove = basketList.keySet().stream().
                    filter(item -> (item.sku.equals(product.sku)
                            && item.name.equals(product.name)
                            && item.variant.equals(product.variant)
                            && item.price == product.price)).findAny();
            if (productToRemove.isPresent()) {
                productsQuantity -= basketList.get(productToRemove.get());
                basketList.remove(productToRemove.get());
                return "Product removed";
            } else {
                return "Product is not in the basket";
            }
        } else return "Product is not in inventory";
    }

    public String removeProduct(Product product, int quantity) {
        if (inventory.checkIfProductInInventory(product)) {
            Optional<Product> productToRemove = basketList.keySet().stream().
                    filter(item -> (item.sku.equals(product.sku)
                            && item.name.equals(product.name)
                            && item.variant.equals(product.variant)
                            && item.price == product.price)).findAny();
            if (productToRemove.isPresent()) {
                if (basketList.get(productToRemove.get()) < quantity) {
                    return "Quantity of this product is less than given";
                } else if (basketList.get(productToRemove.get()) == quantity) {
                    productsQuantity -= quantity;
                    basketList.remove(productToRemove.get());
                    return "Products removed";
                } else {
                    productsQuantity -= quantity;
                    basketList.replace(productToRemove.get(), quantity);
                    return "Products removed";
                }
            } else {
                return "Product is not in the basket";
            }
        } else return "Product is not in inventory";
    }

    public String removeProduct(String sku) {
        Product product = inventory.getProductBySKU(sku);
        if (product != null) {
            return this.removeProduct(product);
        } else return "Product is not in inventory";
    }

    public String removeProduct(String sku, int quantity) {
        Product product = inventory.getProductBySKU(sku);
        if (product != null) {
            return this.removeProduct(product, quantity);
        } else return "Product is not in inventory";
    }

    public String changeCapacity(int newCapacity) {
        if (this.capacity < newCapacity) {
            this.capacity = newCapacity;
            return "Capacity changed";
        } else if (this.capacity > newCapacity) {
            if (this.productsQuantity <= newCapacity) {
                this.capacity = newCapacity;
                return "Capacity changed";
            } else {
                return "Capacity can not be changed";
            }
        } else return "Nothing to change";
    }

    public double totalCost() {
        double totalCost = 0.00;
        Map<Product, Integer> tmp = new HashMap<>(basketList);
        for (Map.Entry<Product, Integer> entry : basketList.entrySet()) {
            if ((entry.getKey().sku.equals("BGLO") || entry.getKey().sku.equals("BGLE"))
                    ) {
                if(entry.getValue() >= 6){
                    int quantityOfSpecialPrice = entry.getValue() / 6;
                    int rest = entry.getValue() % 6;
                    totalCost += quantityOfSpecialPrice * 2.49;
                    tmp.replace(entry.getKey(), rest);
                    totalCost += rest * entry.getKey().price;
                }else totalCost += entry.getValue() * entry.getKey().price;

            } else if (entry.getKey().sku.equals("BGLP")
                    && entry.getValue() >= 12) {
                int quantityOfSpecialPrice = entry.getValue() / 12;
                int rest = entry.getValue() % 12;
                totalCost += quantityOfSpecialPrice * 3.99;
                tmp.replace(entry.getKey(), rest);
            }
        }

        int plainBagelsCount = tmp.entrySet().stream().filter(e -> e.getKey().getSku().equals("BGLP")).findAny().get().getValue();
        int coffeeCount = tmp.entrySet().stream().filter(e -> e.getKey().getSku().equals("COFB")).findAny().get().getValue();

        boolean coffeeIsMin = coffeeCount <= plainBagelsCount;

        int minElements = Math.min(plainBagelsCount, coffeeCount);
        int maxElements = Math.max(plainBagelsCount, coffeeCount);


        totalCost += minElements * 1.25;
        maxElements -= minElements;
        for(int i = 0; i < maxElements; i++){
            if(coffeeIsMin) totalCost += 0.39;
            else totalCost += 0.99;
        }

        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.parseDouble(twoDForm.format(totalCost));
    }
}
