package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.booleanuk.core.Menu.fillingMenu;
import static com.booleanuk.core.Menu.printFillingMenu;

public class Bagel implements Item {
    private final ArrayList<Filling> fillings = new ArrayList<>();
    private final String sku;
    private final String name;
    private int price;

    public Bagel(String sku, String name, int price){
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSKU() { return this.sku; }

    public int getPrice() { return this.price; }

    public String getName(){ return this.name; }

    public ArrayList<Filling> getFillings() { return this.fillings; }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Bagel bagel = (Bagel) o;
        return (bagel.sku.equals(this.sku)
                && bagel.price == this.price
                && bagel.name.equals(this.name)
                && bagel.fillings.equals(this.fillings));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.sku, this.price, this.name, this.fillings);
    }


    public String addFilling(Filling filling){
        if (filling != null){
            this.fillings.add(filling);
            this.price += filling.getPrice();
            return filling.getName() + " added to your bagel.";
        }
        else
            return "Invalid filling. Please try again";
    }

    public void addFillingsToBagel(Scanner input){
        int selectedFilling;
        while (true){
            selectedFilling = input.nextInt();

            if (Objects.equals(0, selectedFilling)){
                break;
            }

            else if (selectedFilling < fillingMenu.size()+1){
                Filling filling = fillingMenu.get(selectedFilling-1);
                addFilling(filling);
                System.out.println(filling.getName() + " added to the bagel.");
            }

            else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}

