package com.booleanuk.extension;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<AbstractItem> inventoryItems;

    public Inventory() {
        this.inventoryItems = new ArrayList<>();
        this.inventoryItems.add(new Bagel(Sku.BGLO,0.49,0,"Bagel","Onion"));
        this.inventoryItems.add(new Bagel(Sku.BGLP,0.39,0,"Bagel","Plain"));
        this.inventoryItems.add(new Bagel(Sku.BGLE,0.49,0,"Bagel","Everything"));
        this.inventoryItems.add(new Bagel(Sku.BGLS,0.49,0,"Bagel","Sesame"));
        this.inventoryItems.add(new Coffee(Sku.COFB,0.99,0,"Coffee","Black"));
        this.inventoryItems.add(new Coffee(Sku.COFW,1.19,0,"Coffee","White"));
        this.inventoryItems.add(new Coffee(Sku.COFC,1.29,0,"Coffee","Capuccino"));
        this.inventoryItems.add(new Coffee(Sku.COFL,1.29,0,"Coffee","Latte"));
        this.inventoryItems.add(new Filling(Sku.FILB,0.12,0,"Filling","Bacon"));
        this.inventoryItems.add(new Filling(Sku.FILE,0.12,0,"Filling","Egg"));
        this.inventoryItems.add(new Filling(Sku.FILC,0.12,0,"Filling","Cheese"));
        this.inventoryItems.add(new Filling(Sku.FILX,0.12,0,"Filling","Cream Cheese"));
        this.inventoryItems.add(new Filling(Sku.FILS,0.12,0,"Filling","Smoked Salmon"));
        this.inventoryItems.add(new Filling(Sku.FILH,0.12,0,"Filling","Ham"));
    }

    public ArrayList<AbstractItem> getInventoryItems() {
        return inventoryItems;
    }

    public double showPrice(AbstractItem item){
        for(AbstractItem i:this.inventoryItems){
            if(i.getSku().equals(item.getSku())){
                System.out.println("Item price: "+item.getPrice());
                return i.getPrice();
            }
        }
        System.out.println("Item is not in inventory");
        return -1.0;
    }
    public boolean isValid(AbstractItem item){
        for(AbstractItem i:this.inventoryItems){
            if (i.getSku().equals(item.getSku()) && i.getName().equals(item.getName()) && i.getVariant().equals(item.getVariant())) {
                return true;
            }
        }
        return false;
    }
    public void showFillings(){
        for(AbstractItem item: this.inventoryItems){
            if(item.getName().equals("Filling")){
                System.out.println(item);
            }
        }
    }
}
