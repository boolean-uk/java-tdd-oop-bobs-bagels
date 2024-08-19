package com.booleanuk.extension;

public class Coffee extends Item {

    public Coffee(String SKU, int id) {
        this.setId(id);
        this.setName("Coffee");
        this.setDiscountPrice(-1);
        switch (SKU) {
            case "COFB": {
                this.setSKU(SKU);
                this.setVariant("Black");
                this.setPrice(990);
                break;
            }
            case "COFW": {
                this.setSKU(SKU);
                this.setVariant("White");
                this.setPrice(1190);
                break;
            }
            case "COFC": {
                this.setSKU(SKU);
                this.setVariant("Capuccino");
                this.setPrice(1290);
                break;
            }
            case "COFL": {
                this.setSKU(SKU);
                this.setVariant("Latte");
                this.setPrice(1290);
                break;
            }
        }
    }
}
