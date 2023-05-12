package com.booleanuk.core;

enum FILLINGTYPE {
    BACON,
    EGG,
    CHEESE,
    CREAMCHEESE,
    SMOKEDSALMON,
    HAM
}
public class Filling extends Item {
    final FILLINGTYPE type;

    public FILLINGTYPE getType() { return type; }

    public Filling(FILLINGTYPE type) {
        this.type = type;
        switch(type) {
            case BACON:         this.SKU = "FILB"; this.cost = 0.12; break;
            case EGG:           this.SKU = "FILE"; this.cost = 0.12; break;
            case CHEESE:        this.SKU = "FILC"; this.cost = 0.12; break;
            case CREAMCHEESE:   this.SKU = "FILX"; this.cost = 0.12; break;
            case SMOKEDSALMON:  this.SKU = "FILS"; this.cost = 0.12; break;
            case HAM:           this.SKU = "FILH"; this.cost = 0.12; break;
        }
    }

    @Override
    public boolean getAvailable() {
        return Inventory.fillingAvailable(this.getType());
    }
}
