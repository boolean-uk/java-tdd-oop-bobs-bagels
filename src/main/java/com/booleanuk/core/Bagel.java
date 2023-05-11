package com.booleanuk.core;

enum BAGELTYPE {
    ONION,
    SESAME,
    EVERYTHING
}
public class Bagel extends Item {
    private BAGELTYPE type;

    public BAGELTYPE getType() { return type; }

    public String toString() {
        return String.format(
                "name: %s\ncost: %s", this.getClass().getSimpleName(), this.getCost()
        );
    }
}
