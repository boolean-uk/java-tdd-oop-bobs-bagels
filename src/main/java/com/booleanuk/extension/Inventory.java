package com.booleanuk.extension;



import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventoryItems;

    public Inventory() {
        this.inventoryItems = new ArrayList<>();
        this.inventoryItems.add(new Bagel("BGLO",0.49,"Bagel","Onion"));
        this.inventoryItems.add(new Bagel("BGLP",0.39,"Bagel","Plain"));
        this.inventoryItems.add(new Bagel("BGLE",0.49,"Bagel","Everything"));
        this.inventoryItems.add(new Bagel("BGLS",0.49,"Bagel","Sesame"));
        this.inventoryItems.add(new Coffee("COFB",0.99,"Coffee","Black"));
        this.inventoryItems.add(new Coffee("COFW",1.19,"Coffee","White"));
        this.inventoryItems.add(new Coffee("COFC",1.29,"Coffee","Capuccino"));
        this.inventoryItems.add(new Coffee("COFL",1.29,"Coffee","Latte"));
        this.inventoryItems.add(new Filling("FILB",0.12,"Filling","Bacon"));
        this.inventoryItems.add(new Filling("FILE",0.12,"Filling","Egg"));
        this.inventoryItems.add(new Filling("FILC",0.12,"Filling","Cheese"));
        this.inventoryItems.add(new Filling("FILX",0.12,"Filling","Cream Cheese"));
        this.inventoryItems.add(new Filling("FILS",0.12,"Filling","Smoked Salmon"));
        this.inventoryItems.add(new Filling("FILH",0.12,"Filling","Ham"));
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public double showPrice(Item item){
        for(Item i:this.inventoryItems){
            if(i.getSku().equals(item.getSku())){
                System.out.println("Item price: "+item.getPrice());
                return i.getPrice();
            }
        }
        System.out.println("Item is not in inventory");
        return -1.0;
    }
    public boolean isValid(Item item){
        for(Item i:this.inventoryItems){
            if (i.getSku().equals(item.getSku()) && i.getName().equals(item.getName()) && i.getVariant().equals(item.getVariant())) {
                return true;

            }
        }
        return false;
    }
    public void showFillings(){
        for(Item item: this.inventoryItems){
            if(item.getName().equals("Filling")){
                System.out.println(item);
            }
        }
    }
}
