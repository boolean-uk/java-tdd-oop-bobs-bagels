package com.booleanuk.core;

public class Bagel {
    private BagelVariant bagelType;
    private FillingVariant fillingType;

    public Bagel(BagelVariant bv, FillingVariant fv) {
        this.bagelType = bv;
        this.fillingType = fv;
    }
}
