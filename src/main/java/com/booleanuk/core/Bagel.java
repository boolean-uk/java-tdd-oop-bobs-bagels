package com.booleanuk.core;


public class Bagel extends Product {

    private Filling filling;

    public Bagel(double price, String sku, String variant){
        super("Bagel", price, sku, variant);
        this.filling = setFilling();
    }
    public Bagel(double price, String sku, String variant, Filling filling){
        super("Bagel", price, sku, variant);
        this.filling = setFilling(filling);
    }

    public void addFilling(Bagel bagel, Filling filling){
        if(bagel.getFilling() == null){
            bagel.setFilling(filling);
        }
    }

    public Filling getFilling() {
        System.out.println();
        return filling;
    }

    public Filling setFilling(Filling filling) {
        return this.filling = filling;
    }


    public Filling setFilling() {
        return this.filling = null;
    }


    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Filling filling = new Filling(inv.getItemBySku("FILB").getPrice(), inv.getItemBySku("FILB").getSku(), inv.getItemBySku("FILB").getVariant());

        //Bagel bagel = new Bagel(5.00, "BGLP", "Plain");
        Bagel bagel2 = new Bagel(5.00, "BGLP", "Plain", filling);
        System.out.println(bagel2.getFilling().getPrice());
    }
}
