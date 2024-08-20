package com.booleanuk.core;

import java.util.HashMap;
import java.util.Objects;

public class Basket {
    HashMap<Product, Integer> currentBasket;
    private int basketCapacity = 10;
    private int productCount = 0;

    public Basket(){
        currentBasket = new HashMap<>();
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


    public String add(Product chosenProduct) {

        if(productCount >= basketCapacity){
            return "Basket is full!";
        }

        //Check i bagel exists in basket
        if(Objects.equals("Filling", chosenProduct.retrieveName())){
            boolean hasBagel = false;

            for(Product product : currentBasket.keySet()){
                if(Objects.equals("Bagel", product.retrieveName())){
                    hasBagel = true;
                    break;
                }
            }
            if(Objects.equals(false, hasBagel)){
                return "You will need a bagel for that or it will be messy";
            }
        }

        String chosenSku = chosenProduct.retrieveSku();
        for (Product product : currentBasket.keySet()) {
            String sku = product.retrieveSku();

            if (Objects.equals(sku, chosenSku)) {
                int currentQuantity = currentBasket.get(product);

                currentBasket.put(product, currentQuantity + 1);
                productCount++;

                return "Existing product added to basket";
                }
            }
            currentBasket.put(chosenProduct, 1);
            productCount++;

            return "New product added to basket";
        }


    public String remove(Product chosenProduct){

        //Check if bagel count is over one
        String chosenSku = chosenProduct.retrieveSku();

        for(Product product : currentBasket.keySet()){
            String sku = product.retrieveSku();

            if(Objects.equals(sku, chosenSku)){
                if(currentBasket.get(product) <= 1){
                    currentBasket.remove(product);
                    productCount--;

                    return "This product is removed";
                }
                else {
                    int currentQuantity = currentBasket.get(product);

                    currentBasket.put(product, currentQuantity - 1);
                    productCount--;

                    return "One product is removed";
                }
            }
        }
        return "This product does not exist in basket!";

    }

    public void changeCapacity(int newSize){
        basketCapacity = newSize;
    }

    public double costOfProduct(Product chosenProduct){
        return chosenProduct.retrievePrice();
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
