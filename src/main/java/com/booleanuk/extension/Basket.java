package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private ArrayList<Product> products;
    private static int maxSize;


    public Basket(){
        this.products = new ArrayList<>();
        maxSize = 10;
    }

    public boolean add(Product product, int amount){

        //If the product is not in inventory
        if(!Inventory.isValidProduct(product) || product.getName().equals("Filling")){
            return false;
        }

        //If basket is full
        if(isBasketFull()){
            return false;
        }
        //Add bagels
        for(int i = 0; i<amount; i++){
            this.products.add(product);
        }
        return true;
    }

    public boolean remove(Product product){
        if (products.contains(product)){
            products.remove(product);
            return true;
        }
        return false;
    }

    protected boolean addFillings(Bagel bagel, ArrayList<Filling> fillings){
        if(products.contains(bagel)){
            return bagel.addFillings(fillings);
        }
        return false;
    }

    public static boolean setMaxSize(int max){
        if(max < 0){
            return false;
        }
        maxSize = max;
        return true;
    }

    public static int getMaxSize() {
        return maxSize;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getCostOfBasket(){
        double total = 0;
        //Clone basket to be able to remove from copy
        //ArrayList<Product> temporaryProducts = this.products;

        //Add all fillings first where discounts does not apply.
        for (Product product: products){
            if (product.getName().equals("Bagel")){
                for (Filling filling : product.getFillings()){
                    //total += roundDouble(getCostOfProduct(filling));
                    total += filling.getPrice();
                }
            }
        }


        for (Product product : products){
            //total += roundDouble(getCostOfProduct(product));
            System.out.println("id:" + product.getId() + "  price: " + product.getPrice());
            total += product.getPrice();
        }


        double discount = calculateDiscounts();

        System.out.println("total: " + total);
        System.out.println("discount: " + discount);
        System.out.println("res: " + roundDouble(total - discount));

        return roundDouble(total - discount);
    }


   private double calculateDiscounts(){
        double discountPrice = 0;
        Map<String, Integer> quantityMap = getQuantityMap();

        for(Map.Entry<String, Integer> entry: quantityMap.entrySet()){
            String id = entry.getKey();
            int quantity = entry.getValue();

            if (id.contains("BGL")){
                while (quantity >= 12){
                    //discountPrice += roundDouble((Inventory.getProductById(id).getPrice() * 12 ) - 3.99);
                    discountPrice += (Inventory.getProductById(id).getPrice() * 12 ) - 3.99;
                    quantityMap.put(id, quantityMap.get(id) - 12);
                    quantity -= 12;

                }
                while (quantity >= 6){
                    //discountPrice += roundDouble((Inventory.getProductById(id).getPrice() * 6 ) - 2.49);
                    discountPrice += (Inventory.getProductById(id).getPrice() * 6 ) - 2.49;
                    quantityMap.put(id, quantityMap.get(id) - 6);
                    quantity -= 6;
                }
            }
        }

        ArrayList<Product> coffeesLeft = new ArrayList<>();
        ArrayList<Product> bagelsLeft = new ArrayList<>();

       for(Map.Entry<String, Integer> entry: quantityMap.entrySet()){
           String id = entry.getKey();
           int quantity = entry.getValue();
           if (entry.getKey().contains("BGL")){
               for (int i = 0; i<quantity; i++){
                   bagelsLeft.add(Inventory.getProductById(id));
               }
           }else if (entry.getKey().contains("COF")){
               for (int i = 0; i<quantity; i++){
                   coffeesLeft.add(Inventory.getProductById(id));
               }
           }
       }

       //Sort lists on price

       sortList(coffeesLeft);
       sortList(bagelsLeft);

       int pairs = Math.min(coffeesLeft.size(), bagelsLeft.size());

       //System.out.println(pairs);

       for (int i = 0; i<pairs; i++){

           double coffeePrice = coffeesLeft.get(i).getPrice();
           double bagelPrice = bagelsLeft.get(i).getPrice();
           System.out.println(i + "st: Bagels price: " + bagelPrice);
           System.out.println(i+ "st Coffees Price: " + coffeePrice);
           discountPrice += ((coffeePrice + bagelPrice) - 1.25);

       }
        System.out.println(roundDouble(discountPrice));
        return roundDouble(discountPrice);
   }

    public double getCostOfProduct(Product product){
        double price = 0;
        if (product.getName().equals("Bagel")){
            price = product.getPrice();
            for(Filling filling : product.getFillings()){
                price += filling.getPrice();
            }
        }else {
            price = product.getPrice();
        }
        return price;
    }

    protected void clearBasket(){
        this.products.clear();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

    private HashMap<String, Integer> getQuantityMap(){
        HashMap<String, Integer> quantityMap = new HashMap<>();
        for (Product product : products) {
            if (!quantityMap.containsKey(product.getId())) {
                quantityMap.put(product.getId(), 1);
            } else {
                int currentAmount = quantityMap.get(product.getId());
               quantityMap.put(product.getId(), currentAmount + 1);
            }
        }
        return quantityMap;
    }

    private double roundDouble (double value){
        BigDecimal bigDecimalValue = new BigDecimal(value);
        bigDecimalValue = bigDecimalValue.setScale(2, RoundingMode.HALF_UP);
        double formattedValue = bigDecimalValue.doubleValue();
        return formattedValue;
    }

    private void sortList(ArrayList<Product> list){
        list.sort((p1,p2)
                ->  Double.compare(p1.getPrice(), p2.getPrice()));
    }
}
