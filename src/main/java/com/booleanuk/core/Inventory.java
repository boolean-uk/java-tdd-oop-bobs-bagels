package com.booleanuk.core;

public interface Inventory {



    String getSku();

    void setSku(String sku);

    String getItemType();

    void setItemType(String itemType);

    String getName();

    void setName(String name);

    double getPrice();

    void setPrice(double price);
}
