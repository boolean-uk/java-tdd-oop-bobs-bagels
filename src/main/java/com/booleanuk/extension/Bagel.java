package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.util.ArrayList;

public class Bagel extends AbstractItem  {
    private ArrayList<Filling> fillings;

    public Bagel(Sku sku, double price, double saving, int quantity, String name, String variant)
    {
        super(sku,  price,  saving, quantity,  name, variant);
        this.fillings = new ArrayList<>();
    }
    @Override
    public void display() {

    }

    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    @Override
    public double calculateDiscount() {

        double totalPrice = 0.00;
        double totalSaving = 0.00;
        int checkQuantity = this.getQuantity();

        int quantityLeft=0;

        // Loop through each item in the basket
//        for (Item item : items) {


            // For each item calculate the price based on discount
            while (true) {
                if (checkQuantity >= 12) {
                    totalPrice += 3.99;
                    // Loop through fillings
                    for (Filling filling : this.getFillings()) {
                        totalPrice += filling.getPrice();
                    }
                    //item.setQuantity(item.getQuantity() - 12);
                    checkQuantity-=12;
                } else if (checkQuantity >= 6) {
                    // Loop through fillings
                    totalPrice += 2.49;
                    for (Filling filling : this.getFillings()) {
                        totalPrice += filling.getPrice();
                    }
                    //item.setQuantity(item.getQuantity() - 6);
                    checkQuantity -=6;
                } else {
                    totalPrice += this.getPrice() * checkQuantity;
                    for (Filling filling : this.getFillings()) {
                        totalPrice += filling.getPrice();
                    }
                    break;
                }
            }
            // Calculate saving if any
            if (this.getQuantity() >=6){

                double fillingPrice=0.0;
                for (Filling filling : this.getFillings()) {
                    fillingPrice += filling.getPrice();
                }

                totalSaving+= (this.getPrice()*fillingPrice)-totalPrice;
                this.setSaving(totalSaving);
            }
//            if(this.getName().equals("Bagel"))
//            {
//                quantityLeft+=checkQuantity;
//            }
       // }
//        if(items.stream().anyMatch(item -> item.getName().equals("Coffe"))){
//            // Do something with coffee dscount and add to the totalPrice
//        }
        return totalPrice;
    }
}
