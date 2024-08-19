package com.booleanuk.core;

public class Coffee extends Item{
    Coffee(String type){
        this.setPurchase(false);

        switch (type) {
            case "Black":
                this.setSku("COFB");
                this.setName("Black");
                this.setPrice(0.99);
                this.setPurchase(true);
                break;
            case "White":
                this.setSku("COFW");
                this.setName("White");
                this.setPrice(1.19);
                this.setPurchase(true);
                break;
            case "Capuccino":
                this.setSku("COFC");
                this.setName("Capuccino");
                this.setPrice(1.29);
                this.setPurchase(true);
                break;
            case "Latte":
                this.setSku("COFL");
                this.setName("Latte");
                this.setPrice(1.29);
                this.setPurchase(true);
                break;
            default:
                System.out.println("Not available");


        }

    }
}
