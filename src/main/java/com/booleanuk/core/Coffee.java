package com.booleanuk.core;

public class Coffee extends Item{
    public Coffee(String type){
        this.setPurchase(false);

        switch (type) {
            case "Black":
                this.setSku("COFB");
                this.setName("Black Coffee");
                this.setPrice(0.99);
                this.setPurchase(true);
                this.setType("Coffee");
                break;
            case "White":
                this.setSku("COFW");
                this.setName("White Coffee");
                this.setPrice(1.19);
                this.setPurchase(true);
                this.setType("Coffee");
                break;
            case "Capuccino":
                this.setSku("COFC");
                this.setName("Capuccino");
                this.setPrice(1.29);
                this.setPurchase(true);
                this.setType("Coffee");
                break;
            case "Latte":
                this.setSku("COFL");
                this.setName("Latte");
                this.setPrice(1.29);
                this.setPurchase(true);
                this.setType("Coffee");
                break;
            default:
                System.out.println("Not available");


        }

    }
}
