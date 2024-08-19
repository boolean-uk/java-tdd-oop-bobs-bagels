package com.booleanuk.core;

public class Store {
    private int capacity = 6;
    private final Product[] inventory = new Product[14];
    private Product bagels1, bagels2, bagels3, bagels4;
    private Product coffee1, coffee2, coffee3, coffee4;
    private Product fillings1, fillings2, fillings3, fillings4, fillings5, fillings6, fillings7;


    public Store() {
        bagels1 = new Bagels("BGLO", 0.49, "Onion");
        bagels2 = new Bagels("BGLP", 0.39, "Plain");
        bagels3 = new Bagels("BGLE", 0.49, "Everything");
        bagels4 = new Bagels("BGLS", 0.49, "Sesame");

        coffee1 = new Coffee("COFB", 0.99, "Black");
        coffee2 = new Coffee("COFW", 1.19, "White");
        coffee3 = new Coffee("COFC", 1.29, "Cappuccino");
        coffee4 = new Coffee("COFL", 1.29, "Latte");

        fillings1 = new Fillings("FILB", 0.12, "Bacon");
        fillings2 = new Fillings("FILE", 0.12, "Egg");
        fillings3 = new Fillings("FILC", 0.12, "Cheese");
        fillings4 = new Fillings("FILX", 0.12, "Cream Cheese");
        fillings5 = new Fillings("FILS", 0.12, "Smoked Salmon");
        fillings6 = new Fillings("FILH", 0.12, "Ham");

        fillings7 = new Fillings("FILP", 0.12, "Pepperoni"); // not in inventory

        inventory[0] = bagels1;
        inventory[1] = bagels2;
        inventory[2] = bagels3;
        inventory[3] = bagels4;

        inventory[4] = coffee1;
        inventory[5] = coffee2;
        inventory[6] = coffee3;
        inventory[7] = coffee4;

        inventory[8] = fillings1;
        inventory[9] = fillings2;
        inventory[10] = fillings3;
        inventory[11] = fillings4;
        inventory[12] = fillings5;
        inventory[13] = fillings6;


    }

    public void updateCapacity(int capacity) {
        this.capacity += capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public boolean findProductInInventory(String SKU) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getSKU().equals(SKU)) {
                return true;
            }
        }
        return false;
    }

   /* private String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }*/

    public Product getBagels1() {
        return bagels1;
    }

    public Product getBagels2() {
        return bagels2;
    }

    public Product getBagels3() {
        return bagels3;
    }

    public Product getBagels4() {
        return bagels4;
    }

    public Product getCoffee1() {
        return coffee1;
    }

    public Product getCoffee2() {
        return coffee2;
    }

    public Product getCoffee3() {
        return coffee3;
    }

    public Product getCoffee4() {
        return coffee4;
    }

    public Product getFillings1() {
        return fillings1;
    }

    public Product getFillings2() {
        return fillings2;
    }

    public Product getFillings3() {
        return fillings3;
    }

    public Product getFillings4() {
        return fillings4;
    }

    public Product getFillings5() {
        return fillings5;
    }

    public Product getFillings6() {
        return fillings6;
    }

    public Product getFillings7() {
        return fillings7;
    }
}
