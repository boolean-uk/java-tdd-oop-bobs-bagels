package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Product{

    BagelVariant bagelVariant;




    public Bagel(){
        super();
    }

    @Override
    public double getTotalCostOfProduct() {
      double  totalCostOfProduct = this.getPrice();
        for (Product filling :
                this.getFillings()) {
            totalCostOfProduct+=filling.getPrice();
        }

        return totalCostOfProduct;
    }

    public Bagel(String name, double price, String skw, BagelVariant bagelVariant)
    {
        super(name, price, skw);
        this.bagelVariant = bagelVariant;
    }





}
