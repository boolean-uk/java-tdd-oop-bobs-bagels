package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.booleanuk.core.Menu.fillingMenu;
import static com.booleanuk.core.Menu.printFillingMenu;

public class Bagel extends Item {
    ArrayList<Filling> fillings = new ArrayList<>();

    public Bagel(String sku, Integer price, String name, String variant){
        super(sku, price, name, variant);
    }

    public String addFilling(Filling filling){
        if (filling != null){
            fillings.add(filling);
            this.price += filling.price;
            return filling.variant + " added to your bagel.";
        }
        else
            return "Invalid filling. Please try again";
    }

    public void addFillingsToBagel(Scanner input){
        printFillingMenu();
        System.out.println("Select fillings to add to your bagel, or press 0 to continue.");

        int selectedFilling;
        while (true){
            selectedFilling = input.nextInt();

            if (Objects.equals(0, selectedFilling)){
                break;
            }

            else if (selectedFilling < fillingMenu.size()+1){
                Filling filling = fillingMenu.get(selectedFilling-1);
                addFilling(filling);
                System.out.println(filling.variant + " added to the bagel.");
            }

            else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }

    public boolean fillingsAreIdentical(Bagel b1, Bagel b2){
        ArrayList<Filling> temp = b2.fillings;

        for (Filling f : b1.fillings){
            temp.removeIf(g -> f.variant.equals(g.variant));
        }
        return temp.isEmpty();
    }
}

