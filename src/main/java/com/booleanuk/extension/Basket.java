package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private ArrayList<Discount> appliedDiscounts;
    private Map<String, Integer>discountedProducts;
    private ArrayList<Product> products;
    private static int maxSize;


    public Basket(){
        this.appliedDiscounts = new ArrayList<>();
        this.discountedProducts = new HashMap<>();
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
        //Add all fillings first where discounts does not apply.
        for (Product product: products){
            total += product.getPrice();
            if (product.getName().equals("Bagel")){
                for (Filling filling : product.getFillings()){
                    //total += roundDouble(getCostOfProduct(filling));
                    total += filling.getPrice();
                }
            }
        }

        double discount = calculateDiscounts();

        System.out.println("total: " + total);
        System.out.println("discount: " + discount);
        System.out.println("res: " + roundDouble(total - discount));

        return roundDouble(total - discount);
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



    private double roundDouble (double value){
        BigDecimal bigDecimalValue = new BigDecimal(value);
        bigDecimalValue = bigDecimalValue.setScale(2, RoundingMode.HALF_UP);
        return bigDecimalValue.doubleValue();
    }

    private void sortList(ArrayList<Product> list){
        list.sort((p1,p2)
                ->  Double.compare(p1.getPrice(), p2.getPrice()));
    }

    public HashMap<Product, Integer> getQuantityMapWithProducts(){
        HashMap<Product, Integer> quantityMap = new HashMap<>();
        for (Product product : products) {
            if (!quantityMap.containsKey(product)) {
                quantityMap.put(product, 1);
            } else {
                int currentAmount = quantityMap.get(product);
                quantityMap.put(product, currentAmount + 1);
            }
        }
        return quantityMap;
    }
    public HashMap<String, Integer> getQuantityMap(){
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
    public ArrayList<Discount> getAppliedDiscounts() {
        return appliedDiscounts;
    }

    public Map<String, Integer> getDiscountedProducts() {
        return discountedProducts;
    }

    private double calculateDiscounts(){
        double discountPrice = 0;
        Map<String, Integer> quantityMap = getQuantityMap();

        //Calculate the discount for 12 and 6 bagels
        discountPrice += calculateBagelDiscount(quantityMap);

        //Calculate discounts for coffee and bagel together
        discountPrice += calculateBagelAndCoffeeDiscount(quantityMap);

        return roundDouble(discountPrice);
    }
    private double calculateBagelDiscount(Map<String, Integer> quantityMap){
        double discountPrice = 0;

        for(Map.Entry<String, Integer> entry: quantityMap.entrySet()){

            String id = entry.getKey();

            int quantity = entry.getValue();

            if (id.contains("BGL")){
                int amountOfDiscountedProducts = 0;
                while (quantity >= 12){
                    double discountfor12 = (Inventory.getProductById(id).getPrice() * 12 ) - 3.99;
                    discountPrice += (Inventory.getProductById(id).getPrice() * 12 ) - 3.99;
                    quantityMap.put(id, quantityMap.get(id) - 12);
                    //this.discountedProducts.put(id, 12);
                    amountOfDiscountedProducts += 12;
                    appliedDiscounts.add(new Discount(3.99, 12,
                            (Inventory.getProductById(id).getVariant()) + " " + (Inventory.getProductById(id).getName()),
                            discountfor12));
                    quantity -= 12;
                }



                while (quantity >= 6){
                    double discountfor6 = (Inventory.getProductById(id).getPrice() * 6 ) - 2.49;
                    discountPrice += (Inventory.getProductById(id).getPrice() * 6 ) - 2.49;
                    quantityMap.put(id, quantityMap.get(id) - 6);
                    //this.discountedProducts.put(id, 6);
                    amountOfDiscountedProducts += 6;
                    appliedDiscounts.add(new Discount(2.49, 6,
                            (Inventory.getProductById(id).getVariant()) + " " + (Inventory.getProductById(id).getName()),
                            discountfor6));
                    quantity -= 6;
                }

                this.discountedProducts.put(id, amountOfDiscountedProducts);
            }
        }

        return discountPrice;
    }

    private double calculateBagelAndCoffeeDiscount(Map<String, Integer> quantityMap){
        double discountPrice = 0;
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
        int pairs = 0;

        if(!coffeesLeft.isEmpty() || !bagelsLeft.isEmpty()){
            pairs = Math.min(coffeesLeft.size(), bagelsLeft.size());
        }

        double discountAmountForCoffeeAndBagel = 0;

        if (pairs > 0){
            for (int i = 0; i<pairs; i++){

                double coffeePrice = coffeesLeft.get(i).getPrice();
                double bagelPrice = bagelsLeft.get(i).getPrice();

                discountPrice += ((coffeePrice + bagelPrice) - 1.25);
                discountAmountForCoffeeAndBagel += ((coffeePrice + bagelPrice) - 1.25);

                addToDiscountedProducts(coffeesLeft, i);
                addToDiscountedProducts(bagelsLeft, i);

            }

            this.appliedDiscounts.add(new Discount(1.25 * pairs, pairs, "Bagel & Coffee", discountAmountForCoffeeAndBagel));
        }

        return discountPrice;
    }

    private void addToDiscountedProducts(ArrayList<Product> listOfProduct, int i){

        if (!discountedProducts.containsKey(listOfProduct.get(i).getId())) {
            discountedProducts.put(listOfProduct.get(i).getId(), 1);
        } else {
            int currentAmount = discountedProducts.get(listOfProduct.get(i).getId());
            discountedProducts.put(listOfProduct.get(i).getId(), currentAmount + 1);
        }
    }
}
