package com.booleanuk.extension;

public enum SkuExt {


    BGLO("Onion"), BGLP("Plain"), BGLE("Everything"), BGLS("Sesame"),
    COFB("Black"), COFW("White"), COFC("Capuccino"), COFL("Latte"),
    FILB("Bacon"), FILE("EGG"), FILC("Cheese"), FILX("Cream_Cheese"), FILS("Smoked_Salmon"), FILH("Ham");


    private final String variant;

    SkuExt(String variant) {
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
