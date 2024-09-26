package com.booleanuk.extension;
import com.booleanuk.core.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

public class Discount extends Basket{
    private Basket basket;
    private Inventory inventory;

    public Discount(Basket basket) {
        super(new Inventory(), 8);
        this.basket = basket;
    }


    public double calculateTotalCostWithDiscount(Basket basket){
        double newTotalCost = 0;

        Map<Product, Integer> itemQuantity = new HashMap<>();
        for (Product item : basket.getItemBasket()){
            itemQuantity.put(item,itemQuantity.getOrDefault(item, 0)+1);
        }

        for (Map.Entry<Product, Integer> entry : itemQuantity.entrySet()){
            Product item = entry.getKey();
            int quantity = entry.getValue();

            if (shouldGetDiscount(item.getSku(), quantity)){
                newTotalCost += calculateBundleDiscount(quantity);
            }
            else {
                newTotalCost += item.getPrice() * quantity;
            }
        }

        return Math.floor(newTotalCost *100) /100;
    }

    private boolean shouldGetDiscount(String sku, int quantity){
        return (quantity == 6 || quantity==12) && sku.startsWith("BGL");
    }

    public double calculateBundleDiscount(int quantity){
        double discountPrice = 0;
        if (quantity == 12){
            discountPrice = 3.99;
        } else if (quantity == 6) {
            discountPrice = 2.49;
        }
        return discountPrice;
    }
}
