package com.booleanuk.extension;

import java.util.ArrayList;

public class InventoryExt {


    private ArrayList<BagelExt> allBagelsInInventory = new ArrayList<>();
    private ArrayList<CoffeeExt> allCoffeesInInventory = new ArrayList<>();
    private ArrayList<FillingExt> allFilingsInInventory = new ArrayList<>();


    public InventoryExt() {
        addToInventory();
    }

    private  void addToInventory() {
        allBagelsInInventory.add( new BagelExt(SkuExt.BGLO, "Bagel", 0.49));
        allBagelsInInventory.add(new BagelExt(SkuExt.BGLP, "Bagel", 0.39));
        allBagelsInInventory.add(new BagelExt(SkuExt.BGLE, "Bagel", 0.49));
        allBagelsInInventory.add( new BagelExt(SkuExt.BGLS, "Bagel", 0.49));
        allCoffeesInInventory.add(new CoffeeExt(SkuExt.COFB, "Coffee", 0.99));
        allCoffeesInInventory.add(new CoffeeExt(SkuExt.COFW, "Coffee", 1.19));
        allCoffeesInInventory.add(new CoffeeExt(SkuExt.COFC, "Coffee", 1.29));
        allCoffeesInInventory.add(new CoffeeExt(SkuExt.COFL, "Coffee", 1.29));
        allFilingsInInventory.add(new FillingExt(SkuExt.FILB, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SkuExt.FILE, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SkuExt.FILC, "Filling", 0.12));
        allFilingsInInventory.add( new FillingExt(SkuExt.FILX, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SkuExt.FILS, "Filling", 0.12));
        allFilingsInInventory.add(new FillingExt(SkuExt.FILH, "Filling", 0.12));
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
