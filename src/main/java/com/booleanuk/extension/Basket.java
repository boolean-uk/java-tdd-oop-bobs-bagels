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

    public boolean add(Product product){

        //If the product is not in inventory
        if(!Inventory.isValidProduct(product) || product.getName().equals("Filling")){
            return false;
        }

        //If basket is full
        if(isBasketFull()){
            return false;
        }
        //Add bagel
        this.products.add(product);

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
        ArrayList<Product> temporaryProducts = this.products;

        //Add all fillings first where discounts does not apply.
        for (Product product: temporaryProducts){
            if (product.getName().equals("Bagel")){
                for (Filling filling : product.getFillings()){
                    total += getCostOfProduct(filling);
                }
            }
        }


        for (Product product : products){
            total += product.getPrice();
        }

        double discount = calculateDiscounts();
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
                    discountPrice += (Inventory.getProductById(id).getPrice() * 12 ) - 3.99;
                    quantity -= 12;
                }
                while (quantity >= 6){
                    discountPrice += (Inventory.getProductById(id).getPrice() * 6 ) - 2.49;
                    quantity -= 6;
                }
            }
        }

        return discountPrice;
   }

//    private ArrayList<Product> calculateDiscounts(ArrayList<Product> temporaryProducts){
//
//        //Initilise map for keeping track of qantity of each product
//        HashMap<String, Integer> qtyMap = new HashMap<>();
//
//        //Initialise map to store what's being removed
//        HashMap<String, Integer> removeMap = new HashMap<>();
//
//
//        //Add all products to a map.
//        for (Product product : temporaryProducts) {
//            if (!qtyMap.containsKey(product.getId())) {
//                qtyMap.put(product.getId(), 1);
//            } else {
//                int currentAmount = qtyMap.get(product.getId());
//                qtyMap.put(product.getId(), currentAmount + 1);
//            }
//        }
//
//        //Calculate bagel discount.
//        for (String id : qtyMap.keySet()){
//            if(id.contains("BGL")){
//                int amount = qtyMap.get(id);
//                while (amount>= 12){
//                    amount -= 12;
//                    totalPrice += 3.99;
//                    qtyMap.put(id, amount-=12);
//                    removeMap.put(id, 12);                 }
//                while (amount >= 6){
//                    amount -= 6;
//                    totalPrice += 2.49;
//                    qtyMap.put(id, amount-=6);
//                    if(removeMap.containsKey(id)){
//                        removeMap.put(id, removeMap.get(id) + 6);
//                    }else{
//                        removeMap.put(id, 6);
//                    }
//                }
//            }
//        }
//
//        //Remove products from temporary products
//        for (String removedProductId : removeMap.keySet()){
//            int amount = removeMap.get(removedProductId);
//            Iterator<Product> iterator = temporaryProducts.iterator();
//            while (iterator.hasNext() && amount > 0) {
//                Product product = iterator.next();
//                if (removedProductId.equals(product.getId())) {
//                    iterator.remove();
//                    amount--;
//                }
//            }
//        }
//
//        //Calculate bagel+coffee discount.
//        System.out.println(qtyMap);
//        int bagelAmount = 0;
//        int coffeeAmount = 0;
//        for(String key : qtyMap.keySet()){
//            if (key.contains("BGL")){
//                 bagelAmount += qtyMap.get(key);
//            }
//            if (key.contains("COF")){
//                coffeeAmount += qtyMap.get(key);
//
//            }
//        }
//
//        int bagelAndCofees = 0;
//
//        bagelAndCofees += Math.min(coffeeAmount, bagelAmount);
//
//        System.out.println(removeMap + "removeMap");
//
//        return temporaryProducts;
//    }

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
}
