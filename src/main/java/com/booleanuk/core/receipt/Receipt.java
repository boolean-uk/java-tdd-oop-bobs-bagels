package com.booleanuk.core.receipt;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Receipt {

    private Map<Product,Integer> listOfProducts=new HashMap<>();

    public void createReceipt(Basket basket)
    {
        for (Product product:basket.getProducts()) {
            if(!listOfProducts.containsKey(product))
            {
                listOfProducts.put(product,1);
            }
            else {
                listOfProducts.put(product, listOfProducts.get(product)+1);
            }
        }
    }
    public String printReceipt(Basket basket){
        createReceipt(basket);
        String header= "Bob's Bagels";


        String result="";
        for (Map.Entry<Product, Integer> entry : listOfProducts.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            result+=(key + " -> " + value);
            System.out.println(key + " -> " + value);
        }
        System.out.println("TOTAL PRICE:" + basket.summarizeBasket());
        return result;
    }


    public Map<Product, Integer> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(Map<Product, Integer> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
