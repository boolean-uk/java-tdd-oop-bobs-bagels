package com.booleanuk.core;

public interface Item {


    public String getSku();

    public void setSku(String sku);

    public double getPrice();

    public void setPrice(double price);

    public String getName();

    public void setName(String name);

    public String getVariant();

    public void setVariant(String variant);
    @Override
    public String toString();

}
