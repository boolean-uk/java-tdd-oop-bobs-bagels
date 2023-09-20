package com.booleanuk.extension;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> productInventory = new HashMap<>();
    private HashMap<String, SpecialOffer> specialOffers = new HashMap<>();

    public HashMap<String, Product> getProductInventory() {
        return new HashMap<>(productInventory);
    }

    public void addProduct(Product product) {
        if (!productInventory.containsKey(product.getSKU())) {
            productInventory.put(product.getSKU(), product);
        }
    }

    public boolean isProductAvailable(String SKU) {
        return productInventory.containsKey(SKU);
    }

    public double getProductPrice(String SKU) {
        return productInventory.get(SKU).getPrice();
    }

    public void addSpecialOffer(SpecialOffer offer) {
        specialOffers.put(offer.getSKU(), offer);
    }

    public SpecialOffer getSpecialOffer(String SKU) {
        return specialOffers.get(SKU);
    }

}
