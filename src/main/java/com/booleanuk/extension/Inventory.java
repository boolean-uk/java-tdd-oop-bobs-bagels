package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private static final HashMap<String, Product> products = new HashMap<>() {{
        put("BGLO", new Product("BGLO", 49, "Bagel", "Onion"));
        put("BGLP", new Product("BGLP", 39, "Bagel", "Plain"));
        put("BGLE", new Product("BGLE", 49, "Bagel", "Everything"));
        put("BGLS", new Product("BGLS", 49, "Bagel", "Sesame"));

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

    private static final List<CombinationBargain> combinationBargains = CombinationBargain.coffeePlusBagel();

    private static final HashMap<String, List<Bargain>> bargains = new HashMap<>() {{
        put("BGLO", new ArrayList<>() {{
            add(Bargain.bargain6Bagels());
            add(Bargain.bargain12Bagels());
        }});
        put("BGLP", new ArrayList<>() {{
            add(Bargain.bargain6Bagels());
            add(Bargain.bargain12Bagels());
        }});
        put("BGLE", new ArrayList<>() {{
            add(Bargain.bargain6Bagels());
            add(Bargain.bargain12Bagels());
        }});
        put("BGLS", new ArrayList<>() {{
            add(Bargain.bargain6Bagels());
            add(Bargain.bargain12Bagels());
        }});
    }};

    public static HashMap<String, Product> getProducts() {
        return products;
    }

    public static List<Bargain> getBargains(String productSKU) {
        return bargains.getOrDefault(productSKU, List.of());
    }

    public static List<CombinationBargain> getCombinationBargains() {
        return combinationBargains;
    }

    public static boolean productNotInInventory(String productSKU) {
        return !products.containsKey(productSKU);
    }

    public static int checkCostOfTheProduct(String productSKU){
        if (productNotInInventory(productSKU))
            return 0;

        return products.get(productSKU)
                .price();
    }

    public static Product getProduct(String productSKU) {
        return products.getOrDefault(productSKU, null);
    }

    public static String getProductDescription(String productSKU) {
        if (productNotInInventory(productSKU))
            return productSKU;

        Product product = getProduct(productSKU);
        return product.variant() + " " + product.name();
    }
}
