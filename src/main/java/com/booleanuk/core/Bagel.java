package com.booleanuk.core;

enum BAGELTYPE {
    ONION,
    PLAIN,
    EVERYTHING,
    SESAME
}
public class Bagel extends Item {
    final BAGELTYPE type;

    public BAGELTYPE getType() { return type; }

    public Bagel(BAGELTYPE type) {
        this.type = type;
        switch(type) {
            case ONION:         this.SKU = "BGLO"; this.cost = 0.49; break;
            case PLAIN:         this.SKU = "BGLP"; this.cost = 0.39; break;
            case EVERYTHING:    this.SKU = "GBLE"; this.cost = 0.49; break;
            case SESAME:        this.SKU = "BGLS"; this.cost = 0.49; break;
        }
    }

    @Override
    public boolean getAvailable() {
        return Inventory.bagelAvailable(this.getType());
    }
}
