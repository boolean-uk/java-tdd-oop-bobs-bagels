package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bagel {
    String bagel;
    ArrayList<Inventory> basketList;

    ArrayList<Inventory> inventoryList;
    int key=0;

    int capacity = 0;
    public Bagel(){
        this.capacity = 15;
        this.basketList = new ArrayList<>(capacity);
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


    public String addBagel(String SKU){
        for(Inventory item : inventoryList){
            if(item.SKU.equals(SKU)){
                basketList.add(item);
                return SKU;
            }
        }
        System.out.println("Product not found in inventory: " + SKU);
        return null;
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
//        Inventory a = new Inventory("bagel1");
//        bagel.basketList.add(a);
        //bagel.inventoryList.remove(a);
        System.out.println(bagel.inventoryAllPrint());
        bagel.addBagel("BGLO");
        bagel.addBagel("BGLO");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLP");
        bagel.addBagel("BGLE");
        bagel.addBagel("BGLE");
        bagel.addBagel("BGLE");
        bagel.addBagel("BGLE");
        bagel.addBagel("BGLE");
        bagel.addBagel("BGLE");
        bagel.addBagel("COFB");
        bagel.addBagel("COFB");
        bagel.addBagel("COFB");
        System.out.println(bagel.basketList.toString());
        System.out.println(bagel.totalCost());

    }
    public double totalCost(){
        double totalCost=0;
        int countOnion = 0;
        int countPlain = 0;
        int countEverything = 0;
        int count = 0;
        int countCoffe=0;
        boolean coffeeBagel = false;
        double totalSaved = 0.0;

        for (int i = 0; i < basketList.size(); i++){
            if (basketList.get(i).SKU.equals("BGLO")){
                countOnion++;
                count++;
            }else if (basketList.get(i).SKU.equals("BGLP")){
                countPlain++;
                count++;
            }else if (basketList.get(i).SKU.equals("BGLE")){
                countEverything++;
                count++;
            }else if (basketList.get(i).SKU.equals("COFB")){
                coffeeBagel = true;
                count++;
                countCoffe++;
            }
            totalCost += basketList.get(i).price;
        }
        if (countOnion >= 6){
            int discountGroupsOnion = countOnion / 6;
            totalCost -= discountGroupsOnion * (0.49 * 6 - 2.49);
            totalSaved += 2.49;
        }
        if (countPlain >= 12){
            int discountGroupsPlain = countPlain / 12;
            totalCost -= discountGroupsPlain * (0.39 * 12 - 3.99);
            totalSaved += 3.99;
        }
        if (countEverything >= 6){
            int discountGroupsEverything = countEverything / 6;
            totalCost -= discountGroupsEverything * (0.49 * 6 - 2.49);
            totalSaved += 2.49;
        }
        if (coffeeBagel && countCoffe == 1){
            totalCost -= (0.99 + 0.49 - 1.25);
            totalSaved += 1.25;
        }

        System.out.println(countOnion);
        System.out.println(countPlain);
        System.out.println(countEverything);
        System.out.println(countCoffe);
        System.out.println(count);

        double finalValue = Math.round(totalCost * 100) / 100.0;
        printReceipt(finalValue, count, totalSaved);
        return finalValue;
    }
    public void printReceipt(double totalCost, int totalProducts, double saved){
        LocalDateTime date = LocalDateTime.now();

        String newDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        for (Inventory item : basketList) {
            System.out.println("SKU: " + item.SKU + ", Name: " + item.name + ", Variant: " + item.variant + ", Price: " + item.price);
        }
        System.out.println("        ~~~ Bob's Bagels ~~~       \n" +
                            "        " + newDate +             "\n" +
                            "----------------------------------\n" +
                            "Products----------Quant-Price\n" +
                            formatTableOrder() +

                            "----------------------------------\n" +
                            "Total              " + totalProducts + "   £" + totalCost + "\n" +
                            "\n    You saved a total of £"+saved+"\n" +
                            "             Thank you        \n" +
                            "          for your order!        ");
    }

    public String formatTableOrder(){
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, Double> priceMap = new HashMap<>();

        for (int i = 0; i<basketList.size(); i++) {
            String key = basketList.get(i).variant + " " + basketList.get(i).name;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            priceMap.put(key, basketList.get(i).price);
        }

        StringBuilder out = new StringBuilder();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String key = entry.getKey();
            double discount =0.00;
            int count = entry.getValue();
            double total = count * priceMap.get(key);
            out.append(String.format("%-18s %2d   £%.2f\n", key, count, total));
            if (key.contains("Onion")){
                if (count >= 6){
                    discount = 0.45;
                    String sdis =  "(-£"+discount+")";
                    out.append(String.format("%-10s %-8s   %-1s\n", " "," ",sdis));
                }
            }
            if (key.contains("Plain")){
                if (count >= 12){
                    discount = 0.69;
                    String sdis =  "(-£"+discount+")";
                    out.append(String.format("%-10s %-8s   %-1s\n", " "," ",sdis));
                }
            }
            if (key.contains("Everything")){
                if (count >= 6){
                    discount = 0.45;
                    String sdis =  "(-£"+discount+")";
                    out.append(String.format("%-10s %-8s   %-1s\n", " "," ",sdis));
                }
            }


        }
        return out.toString();
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

    public boolean searchStock(String product){
        initializeArr();
        boolean value = false;

        for (int i = 0; i < inventoryList.size(); i++){
            if (inventoryList.get(i).SKU.equals(product)){
                value= true;
            }
        }
        return value;
    }

}

