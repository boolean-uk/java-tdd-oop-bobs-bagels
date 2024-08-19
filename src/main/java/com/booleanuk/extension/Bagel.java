package com.booleanuk.extension;

import java.util.ArrayList;

public class Bagel extends Item {

    private final ArrayList<Filling> fillings;

    public Bagel(String SKU, int id) {
        fillings = new ArrayList<>();
        this.setName("Bagel");
        this.setId(id);
        this.setDiscountPrice(-1);
        switch (SKU){
            case "BGLO": {
                this.setSKU(SKU);
                this.setVariant("Onion");
                this.setPrice(490);
                break;
            }
            case "BGLP": {
                this.setSKU(SKU);
                this.setVariant("Plain");
                this.setPrice(390);
                break;
            }
            case "BGLE": {
                this.setSKU(SKU);
                this.setVariant("Everything");
                this.setPrice(490);
                break;
            }
            case "BGLS": {
                this.setSKU(SKU);
                this.setVariant("Sesame");
                this.setPrice(490);
                break;
            }
        }
    }
    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    public void addFillings(Filling filling) {
        this.fillings.add(filling);
    }

    @Override
    public boolean removeFilling(int id) {
        for (int i = 0; i < this.fillings.size(); i++) {
            if (this.fillings.get(i).getId() == id) {
                this.fillings.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Filling filling : this.fillings) {
            total += filling.getTotal();
        }
        if (this.getDiscountPrice() != -1) {
            total += this.getDiscountPrice();
            System.out.println(this.getName() + ", " + this.getVariant() + ", price: " + this.getDiscountPrice());
            return total;
        }
        total += this.getPrice();
        System.out.println(this.getName() + ", " + this.getVariant() + ", price: " + this.getPrice());
        return total;
    }
}
