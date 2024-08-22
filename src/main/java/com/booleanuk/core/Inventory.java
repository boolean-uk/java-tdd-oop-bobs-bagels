package com.booleanuk.core;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.EverythingBagel;
import com.booleanuk.core.products.bagels.OnionBagel;
import com.booleanuk.core.products.bagels.PlainBagel;
import com.booleanuk.core.products.bagels.SesameBagel;
import com.booleanuk.core.products.coffees.BlackCoffee;
import com.booleanuk.core.products.coffees.CapuccinoCoffee;
import com.booleanuk.core.products.coffees.LatteCoffee;
import com.booleanuk.core.products.coffees.WhiteCoffee;
import com.booleanuk.core.products.fillings.*;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private HashMap<Product, Integer> inventory; // <Product, the quantity of this product in stock>

    public Inventory() {
        this.inventory = new HashMap<>();

        // Some hardcoded products just for testing
        // Bagels
        this.inventory.put(new OnionBagel(), 1);
        this.inventory.put(new PlainBagel(), 1);
        this.inventory.put(new EverythingBagel(), 1);
        this.inventory.put(new SesameBagel(), 1);

        // Fillings
        this.inventory.put(new SmokedSalmonFilling(), 1);
        this.inventory.put(new BaconFilling(), 1);
        this.inventory.put(new CheeseFilling(), 1);
        this.inventory.put(new CreamCheeseFilling(), 1);
        this.inventory.put(new EggFilling(), 1);
        this.inventory.put(new HamFilling(), 1);

        // Coffee
        this.inventory.put(new WhiteCoffee(), 1);
        this.inventory.put(new BlackCoffee(), 1);
        this.inventory.put(new CapuccinoCoffee(), 1);
        this.inventory.put(new LatteCoffee(), 1);
    }

    public boolean productIsInStock(Product p) {
        for (Map.Entry<Product, Integer> kvp : this.inventory.entrySet()) {
            if (kvp.getKey().getSKU().equals(p.getSKU()) && kvp.getValue() > 0) return true;
        }
        return false;
    }

    public boolean decreaseQuantity(Product p) {
        for (Map.Entry<Product, Integer> kvp : this.inventory.entrySet()) {
            if (kvp.getKey().getSKU().equals(p.getSKU()) && kvp.getValue() > 0) {
                this.inventory.replace(kvp.getKey(), kvp.getValue() - 1);
                return true;
            }
        }
        return false;
    }


    public HashMap<Product, Integer> getInventory() {
        return this.inventory;
    }

}
