package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private static final HashMap<String, Product> products = new HashMap<>() {{
        put("BGLO", new Bagel("BGLO", 49,  "Onion"));
        put("BGLP", new Bagel("BGLP", 39,  "Plain"));
        put("BGLE", new Bagel("BGLE", 49,  "Everything"));
        put("BGLS", new Bagel("BGLS", 49,  "Sesame"));

        put("COFB", new Coffee("COFB", 99,  "Black"));
        put("COFW", new Coffee("COFW", 119,  "White"));
        put("COFC", new Coffee("COFC", 129,  "Capuccino"));
        put("COFL", new Coffee("COFL", 129,  "Latte"));

        put("FILB", new Filling("FILB", 12,  "Bacon"));
        put("FILE", new Filling("FILE", 12,  "Egg"));
        put("FILC", new Filling("FILC", 12,  "Cheese"));
        put("FILX", new Filling("FILX", 12,  "Cream Cheese"));
        put("FILS", new Filling("FILS", 12, "Smoked Salmon"));
        put("FILH", new Filling("FILH", 12,  "Ham"));
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
