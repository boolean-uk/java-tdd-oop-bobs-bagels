package com.booleanuk.core;
import java.util.HashMap;

public class Inventory {
    HashMap<String, String[]> bagels;
    HashMap<String, String[]> fillings;
    HashMap<String, String[]> coffees;

    public Inventory(){
        this.bagels = new HashMap<>();
        this.fillings = new HashMap<>();
        this.coffees = new HashMap<>();

        this.bagels.put("BGLO", new String[]{"BGLO", "0.49", "Bagel", "Onion"});
        this.bagels.put("BGLP", new String[]{"BGLP", "0.39", "Bagel", "Plain"});
        this.bagels.put("BGLE", new String[]{"BGLE",	"0.49",	"Bagel", "Everything"});
        this.bagels.put("BGLS", new String[]{"BGLS",	"0.49",	"Bagel", "Sesame"});

        this.fillings.put("FILB", new String[]{"FILB",	"0.12",	"Filling",	"Bacon"});
        this.fillings.put("FILE", new String[]{"FILE",	"0.12",	"Filling",	"Egg"});
        this.fillings.put("FILC", new String[]{"FILC",	"0.12",	"Filling",	"Cheese"});
        this.fillings.put("FILX", new String[]{"FILX", "0.12", "Filling",	"Cream Cheese"});
        this.fillings.put("FILS", new String[]{"FILS",	"0.12",	"Filling",	"Smoked Salmon"});
        this.fillings.put("FILH", new String[]{"FILH",	"0.12",	"Filling",	"Ham"});

        this.coffees.put("COFB", new String[]{"COFB",	"0.99",	"Coffee",	"Black"});
        this.coffees.put("COFW", new String[]{"COFW",	"1.19",	"Coffee",	"White"});
        this.coffees.put("COFC", new String[]{"COFC",	"1.29",	"Coffee",	"Cappuccino"});
        this.coffees.put("COFL", new String[]{"COFL",	"1.29",	"Coffee",	"Latte"});

    }

    public Product getItem(String referenceSku){
        String[] isBagel = bagels.get(referenceSku);
        String[] isCoffee = coffees.get(referenceSku);

        if(isBagel != null){
            return new Bagel(isBagel[0], Double.valueOf(isBagel[1]), isBagel[2], isBagel[3], null);
        }
        else if (isCoffee != null){
            return new Coffee(isCoffee[0], Double.valueOf(isCoffee[1]), isCoffee[2], isCoffee[3]);
        }
        else {

            //Just adding filling sku will return null;
            return null;
        }
    }

    public Product getItem(String referenceSku, String referenceFillingSku){
        String[] isBagel = bagels.get(referenceSku);
        String[] isFilling = fillings.get(referenceFillingSku);


        if(isBagel != null && isFilling != null){
            return new Bagel(isBagel[0], Double.valueOf(isBagel[1]), isBagel[2], isBagel[3], new Filling(isFilling[0], Double.valueOf(isFilling[1]), isFilling[2], isFilling[3]));

        }
        else {
            return null;
        }
    }
}