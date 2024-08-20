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
                this.setPrice(4900);
                break;
            }
            case "BGLP": {
                this.setSKU(SKU);
                this.setVariant("Plain");
                this.setPrice(3900);
                break;
            }
            case "BGLE": {
                this.setSKU(SKU);
                this.setVariant("Everything");
                this.setPrice(4900);
                break;
            }
            case "BGLS": {
                this.setSKU(SKU);
                this.setVariant("Sesame");
                this.setPrice(4900);
                break;
            }
        }
    }

    @Override
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
    public int getTotal() {
        int total = 0;
        for (Filling filling : this.fillings) {
            total += filling.getTotal();
        }
        if (this.getDiscountPrice() != -1) {
            total += this.getDiscountPrice();
            return total;
        }
        total += this.getPrice();
        return total;
    }
}
