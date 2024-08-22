package com.booleanuk.core;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Objects;

public class Basket {
    HashMap<Product, Integer> currentBasket;
    Inventory inventory;
    private int basketCapacity = 10;
    private int productCount = 0;

    public Basket(){
        currentBasket = new HashMap<>();
        inventory = new Inventory();
    }

    private int getProductCount(){
        return productCount;
    }

    public int retrieveProductCount(){
        return getProductCount();
    }

    private int getBasketCapacity(){
        return basketCapacity;
    }

    public int retrieveBasketCapacity(){
        return getBasketCapacity();
    }

    public int getQuantity(String sku){
        Product product = inventory.getItem(sku);

        if (currentBasket.containsKey(product)){
            return currentBasket.get(product);
        }

        return 0;
    }

    public int getQuantity(String sku, String fillingSKu){
        Product product = inventory.getItem(sku, fillingSKu);

        if (currentBasket.containsKey(product)){
            return currentBasket.get(product);
        }

        return 0;
    }

    public String add(String sku) {

        if (productCount >= basketCapacity){
            return "Basket is full";
        }

        Product product = inventory.getItem(sku);

        if(currentBasket.containsKey(product)){
            currentBasket.put(product, currentBasket.get(product) + 1);
            productCount++;

            return "Existing product added to basket";
        }

        currentBasket.put(inventory.getItem(sku), 1);
        productCount++;

        return "New product added to basket";
        }

    public String add(String sku, String fillingSku) {
        if (productCount >= basketCapacity){
            return "Basket is full";
        }

        Product newProduct = inventory.getItem(sku, fillingSku);

        if(currentBasket.containsKey(newProduct)){
            currentBasket.put(newProduct, currentBasket.get(newProduct) + 1);
            productCount++;

            return "Existing product added to basket";
        }

        currentBasket.put(inventory.getItem(sku, fillingSku), 1);
        productCount++;

        return "New product added to basket";
    }

    public String remove(String sku){
        Product product = inventory.getItem(sku);

        if(currentBasket.containsKey(product)){
            if (Objects.equals(currentBasket.get(product), 1)){
                currentBasket.remove(product);
                productCount--;

                return "This product is removed";
            }

            currentBasket.put(product, currentBasket.get(product) - 1);
            productCount--;

            return "One product is removed";
        }
        return "This product does not exist in basket!";
    }

    public String remove(String sku, String fillingSku){
        Product product = inventory.getItem(sku, fillingSku);

        if(currentBasket.containsKey(product)){
            if (Objects.equals(currentBasket.get(product), 1)){
                currentBasket.remove(product);
                productCount--;

                return "This product is removed";
            }

            currentBasket.put(product, currentBasket.get(product) - 1);
            productCount--;

            return "One product is removed";
        }
        return "This product does not exist in basket!";
    }

    public void changeCapacity(int newSize){
        basketCapacity = newSize;
    }

    public double costOfProduct(Product product){
        if (product instanceof Bagel){
            Bagel bagel = (Bagel) product;

            if(bagel.getFilling() != null){
                return product.retrievePrice() + bagel.getFilling().retrievePrice();
            }
        }
        return product.retrievePrice();
    }

    public double totalCost(){
        double sum = 0;

        for(Product product: currentBasket.keySet()){

            double price = product.retrievePrice();
            double quantity = currentBasket.get(product);

            sum += price * quantity;
        }

        return sum;
    }
}
