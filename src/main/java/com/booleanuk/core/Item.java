package com.booleanuk.core;

import java.util.HashMap;

public class Item {
    private String name;
    private String sKU;

    public Item(String name, String sKU) {
        this.name = name;
        this.sKU = sKU;
    }

    public String getName() {
        return name;
    }

    public String getsKU() {
        return sKU;
    }


}
