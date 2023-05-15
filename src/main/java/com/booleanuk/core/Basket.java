package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;

import static com.booleanuk.core.Inventory.inventoryProducts;
import static com.booleanuk.core.Inventory.productIsInStock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Basket {

    private ArrayList<Product> products;
    private HashMap<String, Integer> productCount;
    private int capacity;


    public Basket(int capacity){
        this.products= new ArrayList<>();
        this.capacity = capacity;
        this.productCount= new HashMap<>();
    }
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

    public boolean add( String SKU){
        if(productIsInStock(SKU) && getCapacity()>products.size()){
            Product newProduct= new Product(SKU,inventoryProducts.get(SKU).getName(),inventoryProducts.get(SKU).getProductCost(),inventoryProducts.get(SKU).getVariant());
            products.add(newProduct);

//            //adds SKU to HashMap or updates its value
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
                return products.remove(product);
            }
        }
        return false;
    }

//
public double getTotalCost() {
    BigDecimal sum = BigDecimal.ZERO;

    for (String keySKU : productCount.keySet()) {
        int totalProductsOfThisSKU = productCount.get(keySKU);

        if (keySKU.equals("BGLP") && totalProductsOfThisSKU >= 12) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 12)
                    .multiply(BigDecimal.valueOf(3.99));
            BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 12)
                    .multiply(BigDecimal.valueOf(0.39));
            sum = sum.add(discount).add(remaining);
        } else if (keySKU.equals("BGLO") || keySKU.equals("BGLE")) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6)
                    .multiply(BigDecimal.valueOf(2.49));
            BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 6)
                    .multiply(BigDecimal.valueOf(0.49));
            sum = sum.add(discount).add(remaining);
        } else if (keySKU.substring(0,2).equals("COF") || productCount.containsKey("BGLP") || productCount.containsKey("BGLO") || productCount.containsKey("BGLE") || productCount.containsKey("BGLS")) {
            // TODO: 12-May-23 count coffee and bagels to calculate discount
        } else {
            sum = sum.add(BigDecimal.valueOf(totalProductsOfThisSKU).multiply(BigDecimal.valueOf(0.49)));
        }
    }

    for (Product product : products) {
        if (product.getName().equals("Bagel")) {
            for (Filling filling : product.getFillings()) {
                sum = sum.add(BigDecimal.valueOf(filling.getProductCost()));
            }
        }
    }

    return sum.doubleValue();
}

    public boolean printReceipt(){
        String pound = "\u00a3";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);
        System.out.println("~~~ Bob's Bagels ~~~"+ "\n" + formatDateTime +"\n");
        double sum = 0;
        for( String keySKU: productCount.keySet()){
            for (int i = 0; i < products.size(); i++) {
                Product currentProduct = products.get(i);
                if (currentProduct.getSKU().equals(keySKU)){
                    System.out.println(currentProduct.getVariant()+ " " +currentProduct.getName() +"    " +productCount.get(keySKU) +"     "+pound+ currentProduct.getProductCost()*productCount.get(keySKU));
                    sum += (double)currentProduct.getProductCost()*productCount.get(keySKU);
                    break;
                }
            }
        }
        for (int i = 0; i < getAllFillings().size(); i++) {
            System.out.println(getAllFillings().get(i).getVariant()+ " " +getAllFillings().get(i).getName()  +"     "+pound+ getAllFillings().get(i).getProductCost());
            sum += (double)getAllFillings().get(i).getProductCost();
        }
        System.out.println("Total   "+pound+ sum);
        System.out.println();
        System.out.println("Thank you for your order!");
        return true;
    }

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
}
