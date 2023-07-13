package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Product{

    BagelVariant bagelType;
	ArrayList<Filling> fillings;



    public Bagel(){
        super();
    }
    public Bagel(String name, double price, String skw) {
        super(name, price, skw);
    }


}
