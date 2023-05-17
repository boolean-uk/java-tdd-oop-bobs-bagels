package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static com.booleanuk.core.Inventory.inventoryProducts;
import static com.booleanuk.core.Inventory.productIsInStock;

public class Basket {

    private ArrayList<Product> products;
    private HashMap<String, Integer> productCount;
    private int capacity;
    Receipt receipt = new Receipt();
    String pound = "\u00a3";
    BigDecimal sumSaved = BigDecimal.ZERO;


    public Basket(int capacity){
        this.products= new ArrayList<>();
        this.capacity = capacity;
        this.productCount= new HashMap<>();
    }

    //Getters and Setters
    public ArrayList<Product> getProducts() {
        return this.products;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        if(capacity>getCapacity()){
            this.capacity = capacity;
        }
    }

    //gets all fillings added to the bagels of the basket
    public ArrayList<Filling> getAllFillings(){
        ArrayList<Filling> allFillings = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals("Bagel")) {
                for (Filling filling : product.getFillings()) {
                    allFillings.add(filling);
                }
            }
        }
        return allFillings;
    }

    public boolean add( String SKU){
        if(productIsInStock(SKU) && getCapacity()>products.size()){
            Product newProduct= new Product(SKU,inventoryProducts.get(SKU).getName(),inventoryProducts.get(SKU).getProductCost(),inventoryProducts.get(SKU).getVariant());
            products.add(newProduct);

            //adds SKU to HashMap or updates its value
            int thisProductInBasketCount;
            if(productCount.containsKey(SKU)){
                thisProductInBasketCount = productCount.get(SKU);
            }else{
                thisProductInBasketCount = 0;
            }

            thisProductInBasketCount++;
            productCount.put(SKU,thisProductInBasketCount);
            return true;
        }
        return false;
    }

    public boolean remove( String SKU){
        for (Product product:this.products) {
            if (product.getSKU().equals(SKU)) {
                int totalOfThisSKUinBasket = productCount.get(SKU);
                totalOfThisSKUinBasket--;
                if (totalOfThisSKUinBasket == 0) {
                    productCount.remove(SKU);   //removes it if no more of this SKU in basket
                } else{
                    productCount.put(SKU, totalOfThisSKUinBasket);  //updates hashmap
                }
                return products.remove(product);
            }
        }
        return false;
    }

    public double calculateSavings(String SKU, int productsDiscounted, BigDecimal discount){
        BigDecimal ammountSaved = BigDecimal.valueOf(productsDiscounted * inventoryProducts.get(SKU).getProductCost());
        ammountSaved = ammountSaved.subtract(discount);
        sumSaved = sumSaved.add(ammountSaved);
        double ammountSavedDouble = ammountSaved.doubleValue();

        return ammountSavedDouble;
    }

    public String displayInReceipt(double saving){
        String ammountSavedStr = "\n\t\t\t\t\t  (-"+pound+saving+")";
        return ammountSavedStr;
    }

    public double getTotalCost() {
        receipt = new Receipt();
        HashMap<String, Integer> productCountNew= new HashMap<>();
        productCountNew.putAll(productCount);
        BigDecimal sum = BigDecimal.ZERO;
        sumSaved = BigDecimal.ZERO;

        for (String keySKU : productCountNew.keySet()) {
            int totalProductsOfThisSKU = productCountNew.get(keySKU);
            Product currentProduct = inventoryProducts.get(keySKU);

            if (keySKU.equals("BGLP") && totalProductsOfThisSKU >= 12) {
                BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 12).multiply(BigDecimal.valueOf(3.99));

                //calculates ammount saved from this special offer
                double ammountSaved = calculateSavings(keySKU, (productCountNew.get(keySKU)/12)*12, discount);
                String ammountSavedStr = displayInReceipt(ammountSaved);
                //adds the ammount saved and the discount used to the receipt
                String discountPrice = pound+discount;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t\t"+ ((productCountNew.get(keySKU)/12)*12) +"\t"+ discountPrice+ammountSavedStr;
                receipt.getProductsBought().add(productToReceipt);

                productCountNew.put("BGLP",productCountNew.get("BGLP")-(productCountNew.get("BGLP")/12)*12);
                sum = sum.add(discount);

            } else if (keySKU.equals("BGLO") && totalProductsOfThisSKU >= 6) {
                BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6).multiply(BigDecimal.valueOf(2.49));

                //adds this discount to receipt
                double ammountSaved = calculateSavings(keySKU, (productCountNew.get(keySKU)/6)*6, discount);
                String ammountSavedStr = displayInReceipt(ammountSaved);
                String discountPrice = pound+discount;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t\t"+ ((productCountNew.get(keySKU)/6)*6) +"\t"+ discountPrice+ammountSavedStr;
                receipt.getProductsBought().add(productToReceipt);

                productCountNew.put("BGLO",productCountNew.get("BGLO")-(productCountNew.get("BGLO")/6)*6);
                sum = sum.add(discount);
            } else if (keySKU.equals("BGLE") && totalProductsOfThisSKU >= 6) {
                BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6).multiply(BigDecimal.valueOf(2.49));

                //adds this discount to receipt
                double ammountSaved = calculateSavings(keySKU, (productCountNew.get(keySKU)/6)*6, discount);
                String ammountSavedStr = displayInReceipt(ammountSaved);
                String discountPrice = pound+discount;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t"+ ((productCountNew.get(keySKU)/6)*6) +"\t\t"+ discountPrice+ammountSavedStr;
                receipt.getProductsBought().add(productToReceipt);

                productCountNew.put("BGLE",productCountNew.get("BGLE")-(productCountNew.get("BGLE")/6)*6);
                sum = sum.add(discount);
            }
        }

        int count_black_coffee = productCountNew.getOrDefault("COFB",0);
        int[] bagels_remaining= {productCountNew.getOrDefault("BGLP",0), productCountNew.getOrDefault("BGLE",0), productCountNew.getOrDefault("BGLO",0),productCountNew.getOrDefault("BGLS",0)};
        int coffee_discounts=0;
        //count black coffee discounts
        for(int i=0;i<bagels_remaining.length;i++){
            if(count_black_coffee>0 && bagels_remaining[i]>0){
                if(count_black_coffee<=bagels_remaining[i]){
                    coffee_discounts +=count_black_coffee;

                    bagels_remaining[i]-=count_black_coffee;
                    count_black_coffee -= count_black_coffee;
                }else{
                    coffee_discounts += bagels_remaining[i];
                    count_black_coffee -= bagels_remaining[i];

                    bagels_remaining[i]-=bagels_remaining[i];
                }
            }
        }


        BigDecimal ammountSaved = BigDecimal.ZERO;
        if (coffee_discounts>0){
            BigDecimal discount = BigDecimal.valueOf(coffee_discounts * 1.25);
            BigDecimal priceWithoutDiscount = BigDecimal.valueOf(coffee_discounts * 1.48);
            ammountSaved = priceWithoutDiscount.subtract(discount);
            if (productCountNew.getOrDefault("BGLP", 0) != bagels_remaining[0]) {
                ammountSaved = ammountSaved.subtract(BigDecimal.valueOf(productCountNew.get("BGLP")-bagels_remaining[0]).multiply(BigDecimal.valueOf(0.1)));
            }
            sumSaved = sumSaved.add(ammountSaved);
        }

        //calculate new remainings of bagels without discount
        productCountNew.put("BGLP",bagels_remaining[0]);
        productCountNew.put("BGLE",bagels_remaining[1]);
        productCountNew.put("BGLO",bagels_remaining[2]);
        productCountNew.put("BGLS",bagels_remaining[3]);

        //calculate black coffees remaining without discount
        productCountNew.put("COFB",productCountNew.getOrDefault("COFB",0)-coffee_discounts);
        sum =sum.add(BigDecimal.valueOf((coffee_discounts*1.25)));

        //adds this discount to receipt
        if ( coffee_discounts > 0) {
            String ammountSavedStr = displayInReceipt(ammountSaved.doubleValue());
            String discountPrice = pound+BigDecimal.valueOf((coffee_discounts*1.25));
            String productToReceipt = "Coffee and Bagel\t" + coffee_discounts +"\t"+ discountPrice+ammountSavedStr;
            receipt.getProductsBought().add(productToReceipt);
        }

        for(String SKU: productCountNew.keySet()){
            BigDecimal costOfProduct = BigDecimal.valueOf(inventoryProducts.get(SKU).getProductCost()).multiply(BigDecimal.valueOf(productCountNew.getOrDefault(SKU,0)));
            Product currentProduct = inventoryProducts.get(SKU);
            sum = sum.add(costOfProduct);

            if (costOfProduct.doubleValue()>0){
                //adds rest of products to receipt
                String discountPrice = pound+costOfProduct;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t"+ productCountNew.get(SKU) +"\t"+ discountPrice;
                receipt.getProductsBought().add(productToReceipt);
            }
        }
        if (getAllFillings().size()>0){
            double fillingsTotalPrice = getAllFillings().size() * 0.12;
            String productToReceipt = "Fillings" +"\t\t\t"+ getAllFillings().size() +"\t"+ pound+fillingsTotalPrice;
            receipt.getProductsBought().add(productToReceipt);
        }

        return sum.doubleValue();
    }

    public boolean printReceipt(){
        double totalPayed = getTotalCost();
        System.out.printf("\t ~~~ Bob's Bagels ~~~%n");
        System.out.printf("\t "+receipt.getDateTime()+"%n");
        System.out.printf("-----------------------------%n");
        for (int i = 0; i < receipt.getProductsBought().size(); i++) {
            System.out.printf(receipt.getProductsBought().get(i)+"%n");
        }
        System.out.printf("-----------------------------%n");
        System.out.printf("Total\t\t\t\t\t"+pound+ totalPayed+"%n");
        System.out.println("\n   You saved a total of "+pound+sumSaved+"\n\t    on this shop");
        System.out.printf("\n\t     Thank you \n\t  for your order!%n");
        return true;
    }

}
