package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Order {

    private HashMap<String, Integer> basket = new HashMap<>();
    private UUID id;
    private Store store;
    private ArrayList<Integer> bagelList = new ArrayList<>();
    private ArrayList<Integer> coffeeList = new ArrayList<>();
    private ArrayList<Integer> fillingList = new ArrayList<>();

    public Order(Store store){
        this.id = UUID.randomUUID();
        this.store = store;
    }

    public HashMap<String, Integer> getBasket(){
        return basket;
    }

    public Store getStore(){
        return store;
    }

    public ArrayList<Integer> getBagelList(){
        return bagelList;
    }

    public ArrayList<Integer> getCoffeeList() {
        return coffeeList;
    }

    public ArrayList<Integer> getFillingList() {
        return fillingList;
    }

    public int size(){
        int result = 0;
        for(Integer i : basket.values()){
            result += i;
        }
        return result;
    }

    public boolean contains(String product){
        return basket.containsKey(product);
    }

    public int get(String product){
        return basket.get(product);
    }

    public void addProduct(String newProduct) throws Exception{
        if(!store.contains(newProduct)){
            throw new Exception("No such product in inventory!");
        }
        if(this.size() == store.getBasketCapacity()){
            System.out.println("Basket is full!");
            return;
        }
        int value;
        if(basket.containsKey(newProduct)){
            value = basket.get(newProduct) + 1;
        }
        else{
            value = 1;
        }
        basket.put(newProduct, value);
    }

    public boolean removeProduct(String productToRemove){
        if(!basket.containsKey(productToRemove)){
            System.out.println("No such product in basket!");
            return false;
        }
        basket.put(productToRemove, basket.get(productToRemove) - 1);
        if(basket.get(productToRemove) == 0){
            basket.remove(productToRemove);
        }
        return true;
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID newId){
        this.id = newId;
    }

    public int getPrice(){
        int result = 0;
        int singularBagels = 0;

        addPricesToLists();

        for(int i = 0; i < bagelList.size(); ++i){
            result += bagelList.get(i);
            singularBagels++;
            if((i+1) % 6 == 0){
                if(i+1 == 6){
                    result = 249;
                }
                else if((i+1) % 12 == 0){
                    result = 399 * ((i+1) / 12);
                }
                else{
                    result = (399 * ((i+1) / 12)) + 249;
                }
                singularBagels = 0;
            }
        }

        for(Integer coffeePrice : coffeeList){
            if(singularBagels > 0) {
                result -= bagelList.get(bagelList.size() - singularBagels);
                result += 125;
                singularBagels--;
            }
            else{
                result += coffeePrice;
            }
        }

        for(Integer fillingPrice : fillingList){
            result += fillingPrice;
        }

        return result;
    }

    private void addPricesToLists(){
        for(HashMap.Entry<String, Integer> entry : basket.entrySet()){
            String sku = entry.getKey();
            int amount = entry.getValue();
            if(sku.startsWith("BGL")){
                for(int i = 0; i < amount; ++i){
                    bagelList.add(store.getPrice(sku));
                }
            }
            else if(sku.startsWith("COF")){
                for(int i = 0; i < amount; ++i){
                    coffeeList.add(store.getPrice(sku));
                }
            }
            else{
                for(int i = 0; i < amount; ++i){
                    fillingList.add(store.getPrice(sku));
                }
            }
        }
        bagelList.sort(null);
        coffeeList.sort(null);
        fillingList.sort(null);
    }

}


