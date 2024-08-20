package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static final ArrayList<Item> menu = new ArrayList<>();
    public static final ArrayList<Filling> fillingMenu = new ArrayList<>();

    static {
        initializeMenu();
    }

    private static void initializeMenu(){
        menu.add(new Bagel("BGLO", 49, "Bagel", "Onion"));
        menu.add(new Bagel("BGLP", 39, "Bagel", "Plain"));
        menu.add(new Bagel("BGLE", 49, "Bagel", "Everything"));
        menu.add(new Bagel("BGLS", 49, "Bagel", "Sesame"));
        menu.add(new Coffee("COFB", 99, "Coffee", "Black"));
        menu.add(new Coffee("COFW", 119, "Coffee", "White"));
        menu.add(new Coffee("COFC", 120, "Coffee", "Capuccino"));
        menu.add(new Coffee("COFL", 129, "Coffee", "Latte"));

        fillingMenu.add(new Filling("FILB", 12, "Filling", "Bacon"));
        fillingMenu.add(new Filling("FILE", 12, "Filling", "Egg"));
        fillingMenu.add(new Filling("FILC", 12, "Filling", "Cheese"));
        fillingMenu.add(new Filling("FILX", 12, "Filling", "Cream Cheese"));
        fillingMenu.add(new Filling("FILS", 12, "Filling", "Smoked Salmon"));
        fillingMenu.add(new Filling("FILH", 12, "Filling", "Ham"));
    }

    public static Item getItemFromMenu(String name, String variant){
        for (Item i : menu){
            if (Objects.equals(i.variant, variant) & Objects.equals(i.name, name))
            {
                switch (name) {
                    case "Bagel" -> {
                        return new Bagel(i.sku, i.price, i.name, i.variant);
                    }
                    case "Coffee" -> {
                        return new Coffee(i.sku, i.price, i.name, i.variant);
                    }
                }
            }
        }
        return null;
    }

    public static Boolean itemIsOnTheMenu(Item item){
        for (Item i : menu){
            if (Objects.equals(i.sku, item.sku) & Objects.equals(i.price, item.price)
                    & Objects.equals(i.name, item.name) & Objects.equals(i.variant, item.variant))
                return true;
        }
        return false;
    }

    public static Filling getFillingFromMenu(String name, String variant){
        for (Filling f : fillingMenu){
            if (Objects.equals(f.name, name) & Objects.equals(f.variant, variant)){
                return new Filling(f.sku, f.price, f.name, f.variant);
            }
        }
        return null;
    }


    public static Item selectItemFromMenu(){
        Scanner input = new Scanner(System.in);
        printMenu();
        System.out.println("Select item to add to your basket, or press 0 to go back.\n\n");
        int choice = input.nextInt();

        if (Objects.equals(0, choice)){
            return null;
        }

        return menu.get(choice-1);
    }

    public static void printMenu(){
        System.out.println("\t\t~Menu~");
        int number = 1;
        for (Item i : menu){
            System.out.println(number + ". " + i.name + " " + i.variant + " " + (float) i.price/100);
            number++;
        }
    }

    public static void printFillingMenu(){
        System.out.println("\t\t~Fillings~");
        int number = 1;
        for (Item i : fillingMenu){
            System.out.println(number + ". " + i.variant + " " + (float) i.price/100);
            number++;
        }
    }


}
