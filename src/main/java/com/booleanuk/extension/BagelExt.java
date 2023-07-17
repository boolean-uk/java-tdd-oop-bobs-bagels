package com.booleanuk.extension;

public class BagelExt {


    private SkuExt skuExt;
    private String name;
    private double price;
    private FillingExt fillingExt;


    public BagelExt() {
    }

    public BagelExt(SkuExt skuExt, String name, double price) {
        this.skuExt = skuExt;
        this.name = name;
        this.price = price;
    }


    public SkuExt getSku() {
        return skuExt;
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
