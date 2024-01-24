package com.booleanuk.core;

public interface Item {
    enum Name {
        BAGEL, COFFEE, FILLING
    }
    enum Variant {
        ONION, PLAIN, EVERYTHING, SESAME, BLACK, WHITE, CAPUCCINO, LATTE, BACON, EGG, CHEESE, CREAM_CHEESE, SMOKED_SALMON, HAM
    }

    Item copy();

    @Override
   String toString();

    /**
     * Setters for member variables
     */

    String getSKU();

    double getPrice();

    Item.Name getName();

    Item.Variant getVariant();

    Item getFilling();

    /**
     * Setters for member variables
     */

    void setSKU(String SKU);

    void setPrice(double price);

    void setName(Item.Name name);

    void setVariant(Item.Variant variant);

    void setFilling(Item filling);

}
