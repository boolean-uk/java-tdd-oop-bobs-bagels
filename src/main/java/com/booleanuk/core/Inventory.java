package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<Filling> allFillings = new ArrayList<>();
    private static ArrayList<Bagel> allBagels = new ArrayList<>();
    private static ArrayList<Coffee> allCoffees = new ArrayList<>();

    public Inventory() {
        if(allFillings.isEmpty() || allCoffees.isEmpty() || allBagels.isEmpty())
            addToInventory();
    }

    private static void addToInventory() {
        allBagels.add(new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION));
        allBagels.add(new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN));
        allBagels.add(new Bagel("Everything", 0.49, "BGLE", BagelVariant.EVERYTHING));
        allBagels.add(new Bagel("Sesame", 0.49, "BGLS", BagelVariant.SESAME));
        allCoffees.add(new Coffee("Black",0.99,"COFB",CoffeeVariant.BLACK));
        allCoffees.add(new Coffee("White",1.19,"COFW",CoffeeVariant.WHITE));
        allCoffees.add(new Coffee("Capuccino",1.29,"COFC",CoffeeVariant.CAPUCCINO));
        allCoffees.add(new Coffee("Latte",1.29,"COFL",CoffeeVariant.LATTE));
        allFillings.add(new Filling("Bacon",0.12,"FILB",FillingVariant.BACON));
        allFillings.add(new Filling("Egg",0.12,"FILB",FillingVariant.EGG));
        allFillings.add(new Filling("Cheese",0.12,"FILB",FillingVariant.CHEESE));
        allFillings.add(new Filling("Cream Cheese",0.12,"FILB",FillingVariant.CREAM_CHEESE));
        allFillings.add(new Filling("Smoked Salmon",0.12,"FILB",FillingVariant.SMOKED_SALMON));
        allFillings.add(new Filling("Ham",0.12,"FILB",FillingVariant.HAM));
    }



    public  boolean isInTheInventory(Product product1){
        for (Product product :
                allBagels) {
            if(product1.equals(product)){
                return  true;
            }
        }
        for (Product product :
                allFillings) {
            if(product1.equals(product)){
                return  true;
            }
        }
        for (Product product :
                allCoffees) {
            if(product1.equals(product)){
                return  true;
            }
        }
        return false;
    }


    public String returnAllFilling(){
        StringBuilder sb = new StringBuilder("All Filling Cost:\n");
        for (Filling filling :
                allFillings) {
            sb.append("Filling: ").append(filling.getName()).append(" Price: ").append(filling.getPrice()).append("\n");
        }

        return sb.toString();
    }

    public String returnAllBagels(){
        StringBuilder sb = new StringBuilder("All Bagel Cost:\n");
        for (Bagel bagel :
                allBagels) {
            sb.append("Bagel: ").append(bagel.getName()).append(" Price: ").append(bagel.getPrice()).append("\n");
        }
        return sb.toString();
    }


    public String returnAllCoffees(){
        StringBuilder sb = new StringBuilder("All Coffees Cost:\n");
        for (Coffee coffee :
                allCoffees) {
            sb.append("Coffee: ").append(coffee.getName()).append(" Price: ").append(coffee.getPrice()).append("\n");
        }
        return sb.toString();
    }
}
