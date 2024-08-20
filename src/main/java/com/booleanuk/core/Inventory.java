package com.booleanuk.core;
import java.util.HashMap;

public class Inventory {
    HashMap<String, String[]> bagels;
    HashMap<String, String[]> filling;
    HashMap<String, String[]> coffees;

    public Inventory(){
        this.bagels = new HashMap<>();
        this.filling = new HashMap<>();
        this.coffees = new HashMap<>();

        this.bagels.put("BGLO", new String[]{"BGLO", "0.49", "Bagel", "Onion"});
        this.bagels.put("BGLP", new String[]{"BGLP", "0.39", "Bagel", "Plain"});
        this.bagels.put("BGLE", new String[]{"BGLE",	"0.49",	"Bagel", "Everything"});
        this.bagels.put("BGLS", new String[]{"BGLS",	"0.49",	"Bagel", "Sesame"});

        this.filling.put("FILB", new String[]{"FILB",	"0.12",	"Filling",	"Bacon"});
        this.filling.put("FILE", new String[]{"FILE",	"0.12",	"Filling",	"Egg"});
        this.filling.put("FILC", new String[]{"FILC",	"0.12",	"Filling",	"Cheese"});
        this.filling.put("FILS", new String[]{"FILS",	"0.12",	"Filling",	"Smoked Salmon"});
        this.filling.put("FILH", new String[]{"FILH",	"0.12",	"Filling",	"Ham"});

    }

    public Product getItem(String referenceSku){
        String[] isBagel = bagels.get(referenceSku);
        String[] isFilling = filling.get(referenceSku);

        if(isBagel != null){
            return new Bagel(isBagel[0], Double.valueOf(isBagel[1]), isBagel[2], isBagel[3]);
        }

        else if (isFilling != null){
            return new Filling(isFilling[0], Double.valueOf(isFilling[1]), isFilling[2], isFilling[3]);
        }

        else {
            return null;
        }



    }

}
