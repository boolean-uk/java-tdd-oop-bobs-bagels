package com.booleanuk.extension;

import java.util.HashMap;

public class Inventory {
    private static final HashMap<String, Product> products = new HashMap<>() {{
        put("BGLO", new Product("BGLO", 49, "Bagle", "Onion"));
        put("BGLP", new Product("BGLP", 39, "Bagle", "Plain"));
        put("BGLE", new Product("BGLE", 49, "Bagle", "Everything"));
        put("BGLS", new Product("BGLS", 49, "Bagle", "Sesame"));

        put("COFB", new Product("COFB", 99, "Coffee", "Black"));
        put("COFW", new Product("COFW", 119, "Coffee", "White"));
        put("COFC", new Product("COFC", 129, "Coffee", "Capuccino"));
        put("COFL", new Product("COFL", 129, "Coffee", "Latte"));

        put("FILB", new Product("FILB", 12, "Filling", "Bacon"));
        put("FILE", new Product("FILE", 12, "Filling", "Egg"));
        put("FILC", new Product("FILC", 12, "Filling", "Cheese"));
        put("FILX", new Product("FILX", 12, "Filling", "Cream Cheese"));
        put("FILS", new Product("FILS", 12, "Filling", "Smoked Salmon"));
        put("FILH", new Product("FILH", 12, "Filling", "Ham"));
    }};

    private static final HashMap<String, Discount> discounts = new HashMap<>()
    {{
        put("BGLO", new Discount(6,249));
        put("BGLP", new Discount(12,399));
        put("BGLE", new Discount(6,249));
    }};
    public static HashMap<String, Product> getProducts() {
        return products;
    }

    public static int getDiscount(String productSku, HashMap<String, Integer> basketProducts){
        if(!discounts.containsKey(productSku))
            return 0;

        Discount discount = discounts.get(productSku);
        int size = discount.getDiscountPackSize();
        int discountPacks = basketProducts.get(productSku) / size;
        basketProducts.put(productSku, basketProducts.get(productSku) - discountPacks * size);
        return discountPacks * size * products.get(productSku).getPrice() - discountPacks * discount.getPackPriceAfterDiscount();
    }
}
