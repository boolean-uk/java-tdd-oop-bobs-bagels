package com.booleanuk.core;

import java.util.HashMap;

public class Item {
    private final String name;
    private final String sKU;


    public Item(String name, String sKU) {
            this.name = name;
            this.sKU = sKU;
    }

    public String getName() {
        return this.name;
    }

    public String getsKU() {
        return this.sKU;
    }


}
