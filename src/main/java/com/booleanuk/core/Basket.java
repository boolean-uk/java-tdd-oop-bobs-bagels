package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> inventory;
    private ArrayList<Product> basketContent;
    private int basketSize;
    private double totalPrice;

    public Basket(){
        this.inventory = new ArrayList<>();
        this.basketContent = new ArrayList<>();
        this.basketSize = 3;
        this.totalPrice = 0;
        inventory.add(new Bagel("BGLO", 0.49d, "Bagel", "Onion"));
        inventory.add(new Bagel("BGLP", 0.39d, "Bagel", "Plain"));
        inventory.add(new Bagel("BGLE", 0.49d, "Bagel", "Everything"));
        inventory.add(new Bagel("BGLS", 0.49d, "Bagel", "Sesame"));
        inventory.add(new Coffee("COFB", 0.99d, "Coffee", "Black"));
        inventory.add(new Coffee("COFW", 1.19d, "Coffee", "White"));
        inventory.add(new Coffee("COFC", 1.29d, "Coffee", "Cappuccino"));
        inventory.add(new Coffee("COFL", 1.29d, "Coffee", "Latte"));
        inventory.add(new Filling("FILB", 0.12d, "Filling", "Bacon"));
        inventory.add(new Filling("FILE", 0.12d, "Filling", "Egg"));
        inventory.add(new Filling("FILC", 0.12d, "Filling", "Cheese"));
        inventory.add(new Filling("FILX", 0.12d, "Filling", "Cream Cheese"));
        inventory.add(new Filling("FILS", 0.12d, "Filling", "Smoked Salmon"));
        inventory.add(new Filling("FILH", 0.12d, "Filling", "Ham"));
    }

    public Boolean addItem(String SKU){
        if(basketContent.size() >= basketSize){
            System.out.println("Basket full, cannot add more");
            return false;
        }


        //TODO
        //Replace instanceof with just .equals(p.getName())
        for (Product p: inventory){
            if (p.getSKU().equals(SKU)){ //Found product in inv, add to basket
                if (!(p instanceof Filling)){
                    if(p instanceof Bagel){
                        basketContent.add(new Bagel(p.getSKU(), p.getPrice(), p.getName(), p.getVariant()));
                        totalPrice += p.getPrice();
                        System.out.println("Bagel " + p.getVariant() + " added to basket at a cost of " + p.getPrice());
                    }
                    if(p instanceof Coffee){
                        basketContent.add(new Coffee(p.getSKU(), p.getPrice(), p.getName(), p.getVariant()));
                        totalPrice += p.getPrice();
                        System.out.println("Coffee " + p.getVariant() + " added to basket at a cost of " + p.getPrice());
                    }
                    return true;
                }else{
                    System.out.println("Cannot buy filling on it's own, add it to a bagel dummy");
                    return false;
                }
            }
        }

        System.out.println("Couldn't find item in inventory");
        return false;
    }

    public Boolean removeItem(String SKU){
        for (Product p: basketContent){
            if(p.getSKU().equals(SKU)){
                basketContent.remove(p);
                totalPrice -= p.getPrice();
                return true;
            }
        }

        System.out.println("Couldn't find the item in the basket");
        return false;
    }

    public int changeBasketSize(int newSize){
        setBasketSize(newSize);
        return newSize;
    }

    public Boolean addFilling(String bagelSKU, String fillingSKU){
        for (Product p: basketContent){
            if(p.getSKU().equals(bagelSKU) && (p instanceof Bagel)){

                //found bagel, now see if filling is in inventory
                for (Product filling: inventory){
                    if(filling.getSKU().equals(fillingSKU) && ((Bagel) p).getFilling() == null){
                        System.out.println("Adding filling " + filling.getVariant() + " to bagel at a cost of " + filling.getPrice());
                        ((Bagel) p).setFilling((Filling) filling);
                        totalPrice += filling.getPrice();
                        return true;
                    }
                }
                //System.out.println("Couldn't find the desired filling in stock");
                //return false;
            }
        }
        System.out.println("Couldn't find the bagel in basket");
        return false;
    }

    public double addDiscount() {
        System.out.println("Total price before discount " + totalPrice);
        int bagelCounter = 0;
        int coffeeCounter = 0;
        ArrayList<Bagel> discountedBagelsList = new ArrayList<>();

        //Count bagels
        for (Product p : basketContent) {
            if (p.getName().equals("Bagel")) {
                bagelCounter += 1;
                discountedBagelsList.add((Bagel) p);
            }
            if (p.getName().equals("Coffee")) {
                coffeeCounter += 1;
            }


        }

        //Figure out how many discounts and remaining items after discounts
        int bagelDiscounts12 = 0;
        int bagelsAfterDiscount12 = 0;

        if (bagelCounter >= 12) {
            bagelDiscounts12 = bagelCounter / 12;
            bagelsAfterDiscount12 = bagelCounter % 12;
        }


        for (int i = 0; i < bagelDiscounts12; i++){
            //remove the cost of the 12 individual bagels,
            for(int j = 0; j < 12; j++){
                totalPrice -= discountedBagelsList.get(j).getPrice();
                System.out.println("price deducted from " + discountedBagelsList.get(j));
            }

            //remove the 12 discounted bagels
            for(int j = 0; j < 12; j++){
                discountedBagelsList.removeFirst();
            }

            totalPrice+= 3.99; // For each 12 stack discount, add this price to the total
        }

        System.out.println("After applying 12 stack discount, there are now " + bagelsAfterDiscount12 + " bagels left");

        if(bagelsAfterDiscount12 >= 6){
            //apply the 6 bagel discount
            for(int j = 0; j < 6; j++){
                totalPrice -= discountedBagelsList.get(j).getPrice();
                System.out.println("price deducted from " + discountedBagelsList.get(j));
            }
            totalPrice += 2.49;
        }



        System.out.println("Total price after discounts " + totalPrice);

        return totalPrice;
    }

    //Sanity check
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.changeBasketSize(20);
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addFilling("BGLE", "FILC");
        basket.addFilling("BGLE", "FILC");



        //System.out.println(newPrice);
        System.out.println(basket.getBasketContent());
    }


    private int getBasketSize(){
        return this.basketSize;
    }

    private void setBasketSize(int newSize){
        this.basketSize = newSize;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getBasketContent() {
        return basketContent;
    }

    public void setBasketContent(ArrayList<Product> basketContent) {
        this.basketContent = basketContent;
    }
}
