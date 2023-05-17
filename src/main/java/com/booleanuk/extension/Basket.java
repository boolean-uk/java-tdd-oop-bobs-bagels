package com.booleanuk.extension;


import javax.swing.*;
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
        double total =0.0;
        double costBeforeDiscount =0.0;
        int leftoverBagels =0, numberOfCoffes =0;
        for(AbstractItem item:this.items){
            if(item.getName().equals("Bagel")){
                int quantity = item.getQuantity();
                while(true){
                    if(quantity>=12){
                        total += 3.99;
                        if (item.getFillings().size()>0){
                            total+=((Bagel)item).getFillingsTotalPrice();
                        }
                        quantity -= 12;
                        item.setQuantity(quantity);
                    }else if(quantity>=6){
                        total += 2.49;
                        if (item.getFillings().size()>0){
                            total+=((Bagel)item).getFillingsTotalPrice();
                        }
                        quantity -= 6;
                        item.setQuantity(quantity);
                    }else {
                        leftoverBagels += quantity;
                        item.setQuantity(quantity);
                        break;
                    }
                }
            }
            if(item.getName().equals("Coffee")){
                numberOfCoffes+= item.getQuantity();
            }
            costBeforeDiscount += item.getPrice() * item.getQuantity();
            System.out.println("Before discount: "+costBeforeDiscount);
        }
        if(leftoverBagels > numberOfCoffes){
            leftoverBagels = numberOfCoffes;
        }
        for(int i=0;i<leftoverBagels;i++){
            total += 1.25;
            for(int j=0;j<this.items.size();j++){
                if(this.items.get(j).getName().equals("Bagel")){
                    this.removeItem(this.items.get(j));
                }
            }
            for(int j=0;j<this.items.size();j++) {
                if (this.items.get(j).getName().equals("Coffee")) {
                    this.removeItem(this.items.get(j));
                }
            }
        }
        for(AbstractItem item:this.items){
            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }

}
