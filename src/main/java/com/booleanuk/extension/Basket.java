package com.booleanuk.extension;


import java.util.ArrayList;

public class Basket {
    private ArrayList<AbstractItem> items;
    private int capacity;
    private Inventory inventory;
    public Basket(){
        this.items = new ArrayList<>();
        this.capacity = 5; //default value?
        this.inventory = new Inventory();
    }

    public Basket(int capacity) {
        this.items = new ArrayList<>();
        this.inventory = new Inventory();
        setCapacity(capacity);
    }

    public ArrayList<AbstractItem> getItems() {
        return this.items;
    }

    public void setCapacity(int capacity) {
        if(capacity<=0){
            System.out.println("Cannot change the basket capacity to something negative!");
        }else if(capacity<this.items.size()){
            System.out.println("Cannot change capacity to something smaller than the current number of items in the basket!");
        }else {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void addItem(AbstractItem item){
        if(this.items.size()>=capacity){
            System.out.println("Your basket is full!");
        }else if(!this.inventory.isValid(item)){
            System.out.println("Item is not valid");
        }else {
            if (items.stream().anyMatch(i->i.getSku().equals(item.getSku()))){
                items.forEach((i)->{
                    if (i.getSku().equals(item.getSku())){
                        i.setQuantity(i.getQuantity()+1);
                    }});
            }else {
                this.items.add(item);
            }
        }
    }
    public void addItem(Sku sku){
        for(AbstractItem item:this.inventory.getInventoryItems()){
            if(sku.equals(item.getSku())){
                this.addItem(item);
                return;
            }
        }
        System.out.println("Invalid SKU");
    }
    public void removeItem(AbstractItem item){
        for(int i=0; i < this.items.size();i++){
            if (this.items.get(i).getSku().equals(item.getSku())){
                item.setQuantity(item.getQuantity()-1);
                if (item.getQuantity() < 1){
                   items.remove(i);
                }
                System.out.println("Remove item succeeded!");
                return;
            }
        }
        System.out.println("Remove item failed!");
    }
    public void removeItem(String sku){
        for(AbstractItem item:this.items){
            if(sku.equals(item.getSku())){
                this.removeItem(item);
                return;
            }
        }
        System.out.println("Invalid SKU");
    }
    public double getTotalPrice(){
        double total =0;
        for (AbstractItem item :items) {
            total += item.calculateDiscount();
        }
        return total;
    }
}
