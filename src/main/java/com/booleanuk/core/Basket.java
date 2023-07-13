package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Basket {
    public static int capacity = 2; //default size of the basket
    private Inventory inventory = Inventory.getInstance();

    private List<String> listOfItemsInBasket = new ArrayList<String>();

    public List<String> getListOfItemsInBasket()
    {
        return listOfItemsInBasket;
    }
    public boolean  addToBasket(String item)
    {
        if (listOfItemsInBasket.size()<capacity)
        {
            listOfItemsInBasket.add(item);
            return true;
        }
        else
            return false;


    }
    public boolean removeFromBasket(String item){
        if (listOfItemsInBasket.contains(item))
        {
            listOfItemsInBasket.remove(item);
            return true;
        }
    return false;
    }

    public static void setBasketCapacity(int capacity) {
        Basket.capacity = capacity;
    }

    public static int getCapacity() {
        return capacity;
    }

    public int getTotalCost() {
        int cost =0;
        int numberOfCoffees = countProduct("COFB");
        int numberOfBglp = countProduct("BGLP");
        int numberOfBglo = countProduct("BGLO");
        int numberOfBgle = countProduct("BGLE");
        int numberOfBgls = countProduct("BGLS");


        for(String item: listOfItemsInBasket)
        {
            if(!item.startsWith("BGL"))
            {
                cost += inventory.getPriceBySku(item);
            }
        }
        cost+=countCoffeeDiscount(numberOfBglp,numberOfCoffees);
        numberOfBglp=numberOfBglp-numberOfCoffees;
        cost+=countBagelDiscount(numberOfBglp,39);
        cost+=countBagelDiscount(numberOfBglo,49);
        cost+=countBagelDiscount(numberOfBgle,49);
        cost+=countBagelDiscount(numberOfBgls,49);
        return cost;
    }
    double countCoffeeDiscount(int numberOfBagels, int numberOfCoffees)
    {
        double cost=0;
        numberOfCoffees= numberOfBagels<numberOfCoffees ? numberOfBagels: numberOfCoffees;
        cost+=(125*numberOfCoffees)-(99*numberOfCoffees);
        return cost;
    }
    double countBagelDiscount(int numberOfBagels, double price)
    {
        int cost=0;
        cost+= 399*(numberOfBagels/12);
        numberOfBagels=numberOfBagels%12;
        cost+= 249*(numberOfBagels/6);
        numberOfBagels=numberOfBagels%6;
        cost+=numberOfBagels*price;
        return cost;
    }


    public int countProduct(String sku)
    {
        int products = 0;
        for(String item: listOfItemsInBasket)
        {
            if (item.startsWith(sku))
            {
                products++;
            }
        }
        return products;
    }

}
