package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        inventory.add(new Product("DIS1", 0.39d, "12 Bagels", "Ham"));
        inventory.add(new Product("DIS2", 0.49d, "6 Bagels", "Ham"));
        inventory.add(new Product("DIS3", 0.99d, "COffee - Bagel", "Ham"));
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
                    System.out.println("Cannot buy filling on it's own, add it to a bagel");
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
                        System.out.println("Adding filling " + filling.getVariant() + " to " + p.getVariant() + " bagel at a cost of " + filling.getPrice());
                        ((Bagel) p).setFilling((Filling) filling);
                        totalPrice += filling.getPrice();
                        return true;
                        }
                }
            }
        }
        System.out.println("Couldn't find the bagel in basket");
        return false;
    }

    //TODO
    //REfactor addDiscount() to use helper methods and reduce code repetition
    public double addDiscount() {
        int bagelCounter = 0;
        int coffeeCounter = 0;
        ArrayList<Bagel> discountedBagelsList = new ArrayList<>();
        ArrayList<Product> coffeeList = new ArrayList<>();

        //Count bagels
        for (Product p : basketContent) {
            if (p.getName().equals("Bagel")) {
                bagelCounter += 1;
                discountedBagelsList.add((Bagel) p);
            }
            if (p.getName().equals("Coffee")) {
                coffeeCounter += 1;
                coffeeList.add(p);
            }
        }

        //Figure out how many discounts and remaining items after discounts
        int bagelDiscounts12 = bagelCounter / 12; // 20 / 12 = 1
        int bagelsAfterDiscount12 = bagelCounter % 12; // 20 % 12 = 8


        for (int i = 0; i < bagelDiscounts12; i++){
            //remove the cost of the 12 individual bagels,
            for(int j = 0; j < 12; j++){
                totalPrice -= discountedBagelsList.get(j).getPrice(); // Deducting the price of the bagel from the total
            }
            //remove the 12 discounted bagels
            for(int j = 0; j < 12; j++){
                discountedBagelsList.removeFirst();
            }
            totalPrice+= 3.99; // For each 12 stack discount, add this price to the total
        }

        if(bagelsAfterDiscount12 >= 6){
            //apply the 6 bagel discount
            for(int j = 0; j < 6; j++){
                totalPrice -= discountedBagelsList.get(j).getPrice();
            }
            totalPrice += 2.49;
            bagelsAfterDiscount12 -= 6;
        }

        //Calculate coffee + bagel pairs for the remaining discounts
        for(int i = 0; i < bagelsAfterDiscount12; i++){
            if(!coffeeList.isEmpty()){
                totalPrice -= discountedBagelsList.get(i).getPrice();
                totalPrice -= coffeeList.get(i).getPrice();
                totalPrice += 1.25d;
            }
        }

        System.out.println("Total price after discounts " + String.format("%.02f",totalPrice));

        return totalPrice;
    }

    public void printReceipt() {
        // Maps to store the count and price for each bagel variant
        Map<String, Integer> bagelVariantCount = new HashMap<>();
        Map<String, Double> bagelVariantPrice = new HashMap<>();
        Map<String, Integer> coffeeVariantCount = new HashMap<>();
        Map<String, Double> coffeeVariantPrice = new HashMap<>();
        Map<String, Integer> fillingVariantCount = new HashMap<>();
        Map<String, Double> fillingVariantPrice = new HashMap<>();

        System.out.println();
        System.out.println("  ~~~ Bob's Bagels ~~~   ");
        System.out.println("----------------------------");

        // Loop through basket items and count the products, add it to count maps
        for (Product p : basketContent) {
            if (p.getName().equals("Bagel")) {
                addToMaps(p, bagelVariantCount, bagelVariantPrice);

                // if bagel doesn't hava filling
                if (((Bagel) p).getFilling() != null) {
                    addToMaps(p, fillingVariantCount, fillingVariantPrice);
                }

            } else if (p.getName().equals("Coffee")) {
                addToMaps(p, coffeeVariantCount, coffeeVariantPrice);
            }
        }

        printReceiptLines("Bagels", bagelVariantCount, bagelVariantPrice);
        printReceiptLines("Fillings", fillingVariantCount, fillingVariantPrice);
        printReceiptLines("Coffees", fillingVariantCount, fillingVariantPrice);

        double originalPrice = calculateTotal();
        //double originalPrice = calculateTotal(bagelVariantPrice) + calculateTotal(fillingVariantPrice) + calculateTotal(coffeeVariantPrice); //Recalculate undiscounted price (Not ideal solution)
        double savings = originalPrice - totalPrice;
        System.out.println("----------------------------");
        System.out.println("Original price: $" + String.format("%.02f", originalPrice));
        System.out.println("Price after discounts: $" + String.format("%.02f", totalPrice)); // Totalprice calculated in Discount

        if(savings > 0){
            System.out.println("You saved a total of: $" + String.format("%.02f", savings) + " on this shop :)");
        }
    }

    private void addToMaps(Product p, Map<String, Integer> countMap, Map<String, Double> priceMap){
        String variant = p.getVariant();
        countMap.put(variant, countMap.getOrDefault(variant, 0) +1);
        priceMap.put(variant, priceMap.getOrDefault(variant, 0.0) + p.getPrice());

    }

    private void printReceiptLines(String productType, Map<String, Integer> countMap, Map<String, Double> priceMap){
        for (String variant: countMap.keySet()){
            int count = countMap.get(variant); //Amount of products in the order
            double price = priceMap.get(variant);
            if(count > 0){
                System.out.println(count + "X " + variant + " " + productType + " = $" + String.format("%.02f", price));
            }
        }
    }

    private double calculateTotal(){
        double total = 0;
        for (Product p: basketContent){
            total += p.getPrice();
            if(p.getName().equals("Bagel")){
                if(((Bagel) p).getFilling()!= null){
                    total += ((Bagel) p).getFilling().getPrice();
                }

            }
        }
        return total;
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
