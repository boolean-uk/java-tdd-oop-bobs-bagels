package com.booleanuk.core;

public interface ItemInterface {
    public String getType();
    public double getPrice();
    public String getSku();
    public String getVariant();
    public void setType(String type);
    public void setPrice(double price);
    public void setSku(String sku);
    public void setVariant(String variant);

    @Override
    public String toString();

}
