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
        menu.add(new Bagel("BGLO", "Onion Bagel", 49));
        menu.add(new Bagel("BGLP", "Plain Bagel", 39));
        menu.add(new Bagel("BGLE", "Everything Bagel", 49));
        menu.add(new Bagel("BGLS",  "Sesame Bagel", 49));
        menu.add(new Coffee("COFB",  "Black Coffee", 99));
        menu.add(new Coffee("COFW",  "White Coffee", 119));
        menu.add(new Coffee("COFC",  "Capuccino", 120));
        menu.add(new Coffee("COFL",  "Latte", 129));

        fillingMenu.add(new Filling("FILB", "Bacon", 12));
        fillingMenu.add(new Filling("FILE", "Egg", 12));
        fillingMenu.add(new Filling("FILC", "Cheese", 12));
        fillingMenu.add(new Filling("FILX", "Cream Cheese", 12));
        fillingMenu.add(new Filling("FILS", "Smoked Salmon", 12));
        fillingMenu.add(new Filling("FILH", "Ham", 12));
    }

    public static Item getItemFromMenu(String name){
        for (Item i : menu){
            if (Objects.equals(i.getName(), name))
            {
                if (name.contains("Bagel")){
                    return new Bagel(i.getSKU(), i.getName(), i.getPrice());
                }
                return new Coffee(i.getSKU(), i.getName(), i.getPrice());
            }
        }
        return null;
    }

    public static Boolean itemIsOnTheMenu(Item item){
        for (Item i : menu){
            if (itemsAreEqual(i, item))
                return true;
        }
        return false;
    }

    private static boolean itemsAreEqual(Item item1, Item item2){
        return Objects.equals(item1.getSKU(), item2.getSKU()) & Objects.equals(item1.getName(), item2.getName());
    }

    public static Filling getFillingFromMenu(String name){
        for (Filling f : fillingMenu){
            if (Objects.equals(f.getName(), name)){
                return new Filling(f.getSKU(), f.getName(), f.getPrice());
            }
        }
        return null;
    }

    public static Item selectItemFromMenu() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (Objects.equals(0, choice)){
            return null;
        }

        Item selectedItem = menu.get(choice-1);

        if (selectedItem instanceof Bagel){
            return new Bagel(selectedItem.getSKU(), selectedItem.getName(), selectedItem.getPrice());
        }

        else {
            return new Coffee(selectedItem.getSKU(), selectedItem.getName(), selectedItem.getPrice());
        }
    }

    public static void printMenu(){
        System.out.println("\t\t~Menu~");
        int number = 1;
        for (Item i : menu){
            System.out.println(number + ". " + i.getName() + " " + (float) i.getPrice()/100);
            number++;
        }
    }

    public static void printFillingMenu(){
        System.out.println("\t\t~Fillings~");
        int number = 1;
        for (Item i : fillingMenu){
            System.out.println(number + ". " + i.getName() + " " + (float) i.getPrice()/100);
            number++;
        }
    }
}
