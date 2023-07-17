package com.booleanuk.extension.extension2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Basket {
    private static final int DEFAULT_CAPACITY = 40;
    private static final BigDecimal DISCOUNT_SIX_BAGELS = BigDecimal.valueOf(2.49);
    private static final BigDecimal DISCOUNT_TWELVE_BAGELS = BigDecimal.valueOf(3.99);
    private static int capacity = DEFAULT_CAPACITY;
    private int basketCapacity;
    private BigDecimal basketPrice = BigDecimal.ZERO;
    private ArrayList<Product> listOfProducts = new ArrayList<>();

    private ArrayList<ReceiptProduct> receiptList = new ArrayList<>();
    public void addProduct(Product product){
        listOfProducts.add(product);
    }

    public Map<Product, Integer> createProductMap(){
        Map<Product, Integer> productCountMap = new HashMap<>();
        for (Product product : listOfProducts) {
            if (productCountMap.containsKey(product)) {
                int count = productCountMap.get(product);
                productCountMap.put(product, count + 1);
            } else {
                productCountMap.put(product, 1);
            }
        }

        return productCountMap;
    }

    public void setBagelDiscount(Product product, int counter){
        while (counter != 0){
            if (counter < 6){
                BigDecimal tmpPrice = product.getPrice().multiply(BigDecimal.valueOf(counter));
                addToReceiptList(product.getTypeOfProduct(), counter, tmpPrice);
                addToBasketPrice(tmpPrice);
                counter = 0;
            }
            if (counter >= 6 && counter < 12) {
                addToReceiptList(product.getTypeOfProduct(), counter, DISCOUNT_SIX_BAGELS);
                addToBasketPrice(DISCOUNT_SIX_BAGELS);
                counter -= 6;
            }
            if (counter >= 12) {
                addToReceiptList(product.getTypeOfProduct(), counter, DISCOUNT_TWELVE_BAGELS);
                addToBasketPrice(DISCOUNT_TWELVE_BAGELS);
                counter -= 12;
            }
        }
    }

    public void addToReceiptList(ProductType productType, int quantity, BigDecimal value){
        String name;
        if (isBagelProduct(productType)) {
            name = productType.getVariant() + " Bagel";
            receiptList.add(new ReceiptProduct(name, quantity, value));
        }
        else {
            name = productType.getVariant() + " Coffee";
            receiptList.add(new ReceiptProduct(name, quantity, value));
        }
    }

    public void setBasketPrice(Product product, int counter){
        BigDecimal tmpPrice = product.getPrice().multiply(BigDecimal.valueOf(counter));
        addToReceiptList(product.getTypeOfProduct(), counter, tmpPrice);
        addToBasketPrice(tmpPrice);
    }

    private boolean isBagelProduct(ProductType productType) {
        return List.of(ProductType.BGLE, ProductType.BGLO, ProductType.BGLS, ProductType.BGLP).contains(productType);
    }

    public BigDecimal getPrice(){
        Map<Product, Integer> productCountMap = createProductMap();
        productCountMap.forEach((product, quantity) -> {
            if (isBagelProduct(product.getTypeOfProduct()))
                setBagelDiscount(product,quantity);
            else
                setBasketPrice(product,quantity);
        });

        BigDecimal fillingPrice = listOfProducts.stream()
                .map(Product::getFillingPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        addToBasketPrice(fillingPrice);
        return basketPrice;
    }

    public void addToBasketPrice(BigDecimal value){
        basketPrice = basketPrice.add(value);
    }

    public Basket() {
        this.basketCapacity = capacity;
    }

    public void changeBasketCapacity(int newCapacity){
        capacity = newCapacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getBasketCapacity(){
        return basketCapacity;
    }


    public void getFillingTypes(){
        for (FillingType fType : FillingType.values()){
            System.out.println(
                    fType + " " + fType.getVariant()+ " " + fType.getPrice()
            );
        }
    }

    public void getReceipt(){
        getPrice();

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String orderDate = LocalDateTime.now().format(formatter);

        // Wyśrodkowanie tytułu Bob's Bagels
        int totalWidth = 29;
        String centeredTitle = String.format("%" + (totalWidth - 5) + "s%n%n", "~~~ Bob's Bagels ~~~");
        String centeredDate = String.format("%" + (totalWidth + orderDate.length()) / 2 + "s%n%n", orderDate);
        sb.append(centeredTitle);
        sb.append(centeredDate);
        sb.append("-----------------------------\n");


        for (ReceiptProduct rp : receiptList) {
            sb.append(rp.toString()).append("\n");
        }

        sb.append("-----------------------------\n");
        sb.append(String.format("%-23s £%.2f%n", "Total", basketPrice)).append("\n");
        sb.append("          Thank you\n");
        sb.append("        for your order!");

        System.out.println(sb);
    }


    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Bagel(ProductType.BGLO));
        basket.addProduct(new Coffee(ProductType.COFW));

        basket.getReceipt();
    }
}