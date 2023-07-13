package com.booleanuk.core;

import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private final LinkedHashMap<Product, Integer> products;
    private final Inventory inventory;
    private int basketCapacity;
    private int basketQuantity;

    public Basket(Inventory inventory, int quantity) {
        this.products = new LinkedHashMap<>();
        this.inventory = inventory;
        this.basketCapacity = quantity;
    }

    public boolean addProduct(String sku, int quantity) {
        if(quantity <= 0)
            return false;
        Product newProduct = inventory.getProduct(sku);

        if(newProduct == null)
            return false;

        if(basketCapacity - basketQuantity < quantity)
            return false;

        if(products.containsKey(newProduct)) {
            products.replace(newProduct, quantity + products.get(newProduct));
            basketQuantity += quantity;
            return true;
        }
        products.put(newProduct, quantity);
        basketQuantity += quantity;
        return true;
    }

    public boolean removeProduct(String sku, int quantity) {
        if(quantity <= 0)
            return false;

        Product newProduct = inventory.getProduct(sku);
        if(!products.containsKey(newProduct))
            return false;
        if(products.get(newProduct) < quantity)
            return false;
        if(products.get(newProduct) == quantity) {
            products.remove(newProduct);
            basketQuantity -= quantity;
            return true;
        }

        products.replace(newProduct, products.get(newProduct) - quantity);
        basketQuantity -= quantity;
        return true;
    }

    public boolean changeBasketCapacity(int newCapacity) {
        if(newCapacity < 0 || newCapacity < this.basketQuantity)
            return false;

        this.basketCapacity = newCapacity;
        return true;
    }

    public float getTotalCost() {
        float totalCost = 0;

        for(Map.Entry<Product, Integer> product : products.entrySet()){
            totalCost += getPartialCost(product.getKey(), product.getValue());
        }

        return totalCost;
    }

    private float getPartialCost(Product product, int quantity) {
        float partialCost = 0;

        partialCost += product.getPrice() * quantity;

        return partialCost;
    }
}
