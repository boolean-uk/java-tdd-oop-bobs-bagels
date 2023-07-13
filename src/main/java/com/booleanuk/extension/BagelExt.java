package com.booleanuk.extension;

import java.util.ArrayList;

public class BagelExt {


    private SKU sku;
    private String name;
    private double price;
    private FillingExt fillingExt;


    public BagelExt(SKU sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }


    public SKU getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public FillingExt getFillingExt() {
        return fillingExt;
    }

    public void setFillingExt(FillingExt fillingExt) {
        this.fillingExt = fillingExt;
    }
}
