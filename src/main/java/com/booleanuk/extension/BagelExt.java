package com.booleanuk.extension;

public class BagelExt extends  ProductExt{



    private FillingExt fillingExt;


    public BagelExt() {
    }

    public BagelExt(SkuExt skuExt, String name, double price) {
        super(skuExt,name,price);
    }




    public FillingExt getFillingExt() {
        return fillingExt;
    }

    public void setFillingExt(FillingExt fillingExt) {
        this.fillingExt = fillingExt;
    }

}
