package com.booleanuk.core;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
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
        HashMap<String, Integer> productCountNew= new HashMap<>();
    productCountNew.putAll(productCount);
    BigDecimal sum = BigDecimal.ZERO;

    //sum bagel discounts
    for (String keySKU : productCountNew.keySet()) {
        int totalProductsOfThisSKU = productCountNew.get(keySKU);

        if (keySKU.equals("BGLP") && totalProductsOfThisSKU >= 12) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 12)
                    .multiply(BigDecimal.valueOf(3.99));
            productCountNew.put("BGLP",productCountNew.get("BGLP")-((int)productCountNew.get("BGLP")/12)*12);

            //BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 12)
                  //  .multiply(BigDecimal.valueOf(0.39));
            sum = sum.add(discount);//.add(remaining);
        } else if (keySKU.equals("BGLO")) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6).multiply(BigDecimal.valueOf(2.49));
            System.out.println(((int)productCountNew.get("BGLO")/6)*6);
            productCountNew.put("BGLO",productCountNew.get("BGLO")-((int)productCountNew.get("BGLO")/6)*6);
            System.out.println(discount);
           // BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 6).multiply(BigDecimal.valueOf(0.49));
            sum = sum.add(discount);//.add(remaining);
        } else if (keySKU.equals("BGLE")) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6).multiply(BigDecimal.valueOf(2.49));
            productCountNew.put("BGLE",productCountNew.get("BGLE")-((int)productCountNew.get("BGLE")/6)*6);
           // BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 6)
            //        .multiply(BigDecimal.valueOf(0.49));
            sum = sum.add(discount);//.add(remaining);
        } else {
            //sum = sum.add(BigDecimal.valueOf(totalProductsOfThisSKU).multiply(BigDecimal.valueOf(0.49)));
        }
    }

    int count_black_coffee = productCountNew.getOrDefault("COFB",0);
    int[] bagels_remaining= {productCountNew.getOrDefault("BGLP",0), productCountNew.getOrDefault("BGLO",0), productCountNew.getOrDefault("BGLE",0),productCountNew.getOrDefault("BGLS",0)};
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
    //calculate new remainings of bagels without discount
    productCountNew.put("BGLP",bagels_remaining[0]);
    productCountNew.put("BGLO",bagels_remaining[1]);
    productCountNew.put("BGLE",bagels_remaining[2]);
    productCountNew.put("BGLS",bagels_remaining[3]);

    System.out.println("coffee_discounts: " +coffee_discounts);
    //calculate black coffees remaining without discount
    productCountNew.put("COFB",productCountNew.getOrDefault("COFB",0)-coffee_discounts);
    sum =sum.add(BigDecimal.valueOf((coffee_discounts*1.25)));
    for(String SKU: productCountNew.keySet()){
        sum = sum.add(BigDecimal.valueOf(inventoryProducts.get(SKU).getProductCost()).multiply(BigDecimal.valueOf(productCountNew.getOrDefault(SKU,0))));

    }

    //calculate all fillings in bagels
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
