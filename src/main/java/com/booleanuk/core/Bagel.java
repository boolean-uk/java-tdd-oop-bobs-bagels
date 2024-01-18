package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {
    String bagel;
    ArrayList<Inventory> basketList;

    ArrayList<Inventory> inventoryList;
    int key=0;

    int capacity=0;
    public Bagel(){
        this.capacity= 15;
        this.basketList=new ArrayList<>(capacity);
        this.inventoryList = new ArrayList<>();
        initializeArr();
    }
    public void initializeArr(){
        Inventory inventory1 = new Inventory("BGLO",0.49 ,"Bagel", "Onion");
        Inventory inventory2 = new Inventory("BGLP",0.39,"Bagel", "Plain");
        Inventory inventory4 = new Inventory("BGLE",0.49,"Bagel", "Everything");
        Inventory inventory5 = new Inventory("BGLS",0.49,"Bagel", "Sesame");
        Inventory inventory6 = new Inventory("COFB",0.99,"Coffee", "Black");
        Inventory inventory7 = new Inventory("COFW",1.19,"Coffee", "White");
        Inventory inventory8 = new Inventory("COFC",1.29,"Coffee", "Capuccino");
        Inventory inventory9 = new Inventory("COFL",1.29,"Coffee", "Latte");
        Inventory inventory10 = new Inventory("FILB",0.12,"Filling", "Bacon");
        Inventory inventory11 = new Inventory("FILE",0.12,"Filling", "Egg");
        Inventory inventory12 = new Inventory("FILC",0.12,"Filling", "Cheese");
        Inventory inventory13 = new Inventory("FILX",0.12,"Filling", "Cream Cheese");
        Inventory inventory14 = new Inventory("FILS",0.12,"Filling", "Smoked Salmon");
        Inventory inventory15 = new Inventory("FILH",0.12,"Filling", "Ham");
        this.inventoryList.add(inventory1);
        this.inventoryList.add(inventory2);
        this.inventoryList.add(inventory4);
        this.inventoryList.add(inventory5);
        this.inventoryList.add(inventory6);
        this.inventoryList.add(inventory7);
        this.inventoryList.add(inventory8);
        this.inventoryList.add(inventory9);
        this.inventoryList.add(inventory10);
        this.inventoryList.add(inventory11);
        this.inventoryList.add(inventory12);
        this.inventoryList.add(inventory13);
        this.inventoryList.add(inventory14);
        this.inventoryList.add(inventory15);
    }


    public String addBagel(String bagel, double price, String product, String variant){
        if (basketList.contains(bagel)){
            return null;
        }
        Inventory tempInv = new Inventory(bagel,price,product,variant);
        basketList.add(tempInv);
        return bagel;
    }

    public boolean removeBagel(String bagel){
        for (int i = 0; i<basketList.size(); i++){
            if (basketList.get(i).SKU.equals(bagel)){
                basketList.remove(i);
                return true;
            }
        }
        System.out.println("Basket does not contain this " + bagel);
        return false;
    }

    public boolean basketFull(){
        if (basketList.size()>capacity){
            System.out.println("Basket Full");
            return true;
        }
        System.out.println("Basket has space");
        return false;
    }
    public int changeCap(int cap){
        this.capacity=cap;
        return this.capacity;
    }
    public static void main(String[] args) {
        Bagel bagel = new Bagel();
        Inventory a = new Inventory("bagel1");
        bagel.basketList.add(a);
        //bagel.inventoryList.remove(a);
        System.out.println(bagel.basketList.toString());
        System.out.println(bagel.inventoryAllPrint());
    }
    public double totalCost(){
        double totalCost=0;
        for (int i = 0; i < basketList.size(); i++){
            totalCost += basketList.get(i).price;
        }
        return totalCost;
    }

    public boolean inventoryAllPrint(){
        String inv = " ";
        initializeArr();
        for (int i = 0; i < inventoryList.size(); i++){
            inv += "SKU = " + inventoryList.get(i).SKU+ '\n' ;
            inv += "Price = " + inventoryList.get(i).price+ '\n' ;
            inv += "Name = " + inventoryList.get(i).name + '\n';
            inv += "Variant = " + inventoryList.get(i).variant + '\n'+'\n'+'\n';
        }
        System.out.println(inv);
        return true;
    }
    public String chooseFilling(String filling){
        String out="";
        initializeArr();
        for (int i = 0; i < inventoryList.size(); i++){
            if (inventoryList.get(i).variant.equals(filling)){
                out = inventoryList.get(i).SKU;
            }
        }
        if (out.equals("")){
            return "Error";
        }
        return out;
    }
    public double costFilling(String filling){
        double out=0.0;
        initializeArr();
        for (int i = 0; i < inventoryList.size(); i++){
            if (inventoryList.get(i).variant.equals(filling)){
                out = inventoryList.get(i).price;
            }
        }
        return out;
    }

}

