//package com.booleanuk.extension;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//
//public class Discount {
//
//    int totalPrice;
//
//    public D(){
//
//    }
//
//    private ArrayList<Product> calculateDiscounts(ArrayList<Product> temporaryProducts){
//
//        //Initilise map for keeping track of qantity of each product
//        HashMap<String, Integer> qtyMap = new HashMap<>();
//
//        //Initialise map to store what's being removed
//        HashMap<String, Integer> removeMap = new HashMap<>();
//
//        //Clone basket to be able to remove from basket
//
//
//        //Add all products to a map.
//
//        for (Product product : temporaryProducts) {
//            if (!qtyMap.containsKey(product.getId())) {
//                qtyMap.put(product.getId(), 1);
//            } else {
//                int currentAmount = qtyMap.get(product.getId());
//                qtyMap.put(product.getId(), currentAmount + 1);
//            }
//        }
//
//        for (String id : qtyMap.keySet()){
//            if(id.contains("BGL")){
//                int amount = qtyMap.get(id);
//                while (amount>= 12){
//                    amount -= 12;
//                    totalPrice += 3.99;
//                    removeMap.put(id, 12);                 }
//                while (amount >= 6){
//                    amount -= 6;
//                    totalPrice += 2.49;
//                    removeMap.put(id, 6);
//                }
//            }
//        }
//
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
//        return temporaryProducts;
//    }
//