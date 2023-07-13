package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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

        int specialOfferQuantity = product.getSpecialOfferQuantity();
        float specialOfferPrice = product.getSpecialOfferPrice();

        if(specialOfferQuantity > 0 && specialOfferQuantity <= quantity) {
            partialCost += (quantity / specialOfferQuantity) * specialOfferPrice;
            quantity -= (quantity / specialOfferQuantity) * specialOfferQuantity;
        }

        partialCost += product.getPrice() * quantity;

        return partialCost;
    }

    private float getProductDiscount(Product product, int quantity) {
        float discountAmount = 0;

        int specialOfferQuantity = product.getSpecialOfferQuantity();
        float specialOfferPrice = product.getSpecialOfferPrice();

        if(specialOfferQuantity <= 0 || specialOfferQuantity > quantity)
            return 0;

        discountAmount += (float) Math.round((quantity / specialOfferQuantity)
                * ((product.getPrice() * specialOfferQuantity) - specialOfferPrice) * 100) / 100;

        return discountAmount;
    }

    public String getReceipt() {
        LocalDateTime ldt = LocalDateTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ~~~ Bob's Bagels ~~~    \n\n")
                .append("    " + ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "   \n\n")
                .append("-".repeat(28) + "\n\n");

        for(Map.Entry<Product, Integer> product : products.entrySet()){
            String bagelName = product.getKey().getName();
            String bagelVariant = product.getKey().getVariant();
            int bagelQuantity = product.getValue();
            float bagelPrice = getPartialCost(product.getKey(), bagelQuantity);
            float discountAmount = getProductDiscount(product.getKey(), bagelQuantity);

            stringBuilder.append(rightpad(bagelVariant + " " + bagelName, 18)
                    + rightpad(String.valueOf(bagelQuantity), 4)
                    + "£" + bagelPrice + "\n");
            if(discountAmount > 0)
                stringBuilder.append(leftpad("(-£" + discountAmount + ")", 29) + "\n");
        }

        stringBuilder.append("\n" + "-".repeat(28) + "\n\n")
                .append("Total                £" + getTotalCost() + "\n\n")
                .append("        Thank you\n")
                .append("      for your order! \n");

        return stringBuilder.toString();
    }

    private String leftpad(String text, int length) { return String.format("%" + length + "." + length + "s", text); }
    private String rightpad(String text, int length) { return String.format("%-" + length + "." + length + "s", text); }
}
