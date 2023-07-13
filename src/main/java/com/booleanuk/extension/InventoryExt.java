package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.util.ArrayList;

public class InventoryExt {


    private ArrayList<BagelExt> allBagelsInInventory = new ArrayList<>();
    private ArrayList<CoffeeExt> allCoffeesInInventory = new ArrayList<>();
    ArrayList<FillingExt> allFilingsInInventory = new ArrayList<>();


    public InventoryExt() {
        addToInventory();
    }

    private  void addToInventory() {
        allBagelsInInventory.add( new BagelExt(SKU.BGLO, "Bagel", 0.49));
        allBagelsInInventory.add(new BagelExt(SKU.BGLP, "Bagel", 0.39));
        allBagelsInInventory.add(new BagelExt(SKU.BGLE, "Bagel", 0.49));
        allBagelsInInventory.add( new BagelExt(SKU.BGLS, "Bagel", 0.49));
        allCoffeesInInventory.add(new CoffeeExt(SKU.COFB, "Coffee", 0.99));
        allCoffeesInInventory.add(new CoffeeExt(SKU.COFW, "Coffee", 1.19));
        allCoffeesInInventory.add(new CoffeeExt(SKU.COFC, "Coffee", 1.29));
        allCoffeesInInventory.add(new CoffeeExt(SKU.COFL, "Coffee", 1.29));
        allFilingsInInventory.add(new FillingExt(SKU.FILB, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SKU.FILE, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SKU.FILC, "Filling", 0.12));
        allFilingsInInventory.add( new FillingExt(SKU.FILX, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SKU.FILS, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SKU.FILX, "Filling", 0.12));
    }

    public ArrayList<BagelExt> getAllBagelsInInventory() {
        return allBagelsInInventory;
    }

    public ArrayList<CoffeeExt> getAllCoffeesInInventory() {
        return allCoffeesInInventory;
    }

    public ArrayList<FillingExt> getAllFilingsInInventory() {
        return allFilingsInInventory;
    }
}
