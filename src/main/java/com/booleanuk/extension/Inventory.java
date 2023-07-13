package com.booleanuk.extension;

import java.util.HashMap;

public class Inventory {
    private static final HashMap<String, Product> products = new HashMap<>() {{
        put("BGLO", new Product("BGLO", 0.49d, "Bagle", "Onion"));
        put("BGLP", new Product("BGLP", 0.39d, "Bagle", "Plain"));
        put("BGLE", new Product("BGLE", 0.49d, "Bagle", "Everything"));
        put("BGLS", new Product("BGLS", 0.49d, "Bagle", "Sesame"));

        put("COFB", new Product("COFB", 0.99d, "Coffee", "Black"));
        put("COFW", new Product("COFW", 1.19d, "Coffee", "White"));
        put("COFC", new Product("COFC", 1.29d, "Coffee", "Capuccino"));
        put("COFL", new Product("COFL", 1.29d, "Coffee", "Latte"));

        put("FILB", new Product("FILB", 0.12d, "Filling", "Bacon"));
        put("FILE", new Product("FILE", 0.12d, "Filling", "Egg"));
        put("FILC", new Product("FILC", 0.12d, "Filling", "Cheese"));
        put("FILX", new Product("FILX", 0.12d, "Filling", "Cream Cheese"));
        put("FILS", new Product("FILS", 0.12d, "Filling", "Smoked Salmon"));
        put("FILH", new Product("FILH", 0.12d, "Filling", "Ham"));
    }};

    private static final HashMap<String, Discount> discounts = new HashMap<>()
    {{
        put("BGLO", new Discount(6,2.49));
        put("BGLP", new Discount(12,3.99));
        put("BGLE", new Discount(6,2.49));
    }};
    public static HashMap<String, Product> getProducts() {
        return products;
    }

    public static double getDiscount(String productSku, HashMap<String, Integer> basketProducts){
        if(!discounts.containsKey(productSku))
            return 0;

        Discount discount = discounts.get(productSku);
        int size = discount.getDiscountPackSize();
        int discountPacks = basketProducts.get(productSku) / size;
        basketProducts.put(productSku, basketProducts.get(productSku) - discountPacks * size);
        return discountPacks * size * products.get(productSku).getPrice() - discountPacks * discount.getPackPriceAfterDiscount();
    }
}
