package com.booleanuk.core;

import java.util.HashMap;

public class Bagel extends Item {

    private String filling;

    public Bagel(String name, String sKU) {
        super(name, sKU);
        this.filling = "Nothing";
    }

    public String getFilling() {
        return this.filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }
}
