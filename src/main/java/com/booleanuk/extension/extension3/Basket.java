package com.booleanuk.extension.extension3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Basket {
    private static final int DEFAULT_CAPACITY = 40;
    private static final BigDecimal DISCOUNT_SIX_BAGELS = BigDecimal.valueOf(2.49);
    private static final BigDecimal DISCOUNT_COFFEE_BAGEL = BigDecimal.valueOf(1.25);
    private static final BigDecimal DISCOUNT_TWELVE_BAGELS = BigDecimal.valueOf(3.99);
    private static int capacity = DEFAULT_CAPACITY;
    private int basketCapacity;
    private BigDecimal basketPrice = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;
    private ArrayList<Product> listOfProducts = new ArrayList<>();
    private ArrayList<ReceiptProduct> receiptList = new ArrayList<>();
    public void addProduct(Product product){
        listOfProducts.add(product);
    }

    public LinkedHashMap<Product, Integer> createProductMap(){
        LinkedHashMap<Product, Integer> productCountMap = new LinkedHashMap<>();
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
                addToReceiptList(product.getTypeOfProduct(), counter, tmpPrice, BigDecimal.ZERO);
                addToBasketPrice(tmpPrice);
                counter = 0;
            }
            if (counter >= 6 && counter < 12) {
                addToBasketPrice(DISCOUNT_SIX_BAGELS);
                BigDecimal discountForProduct = countDiscountForBagel(product.getPrice(), BigDecimal.valueOf(6), DISCOUNT_SIX_BAGELS);
                addToReceiptList(product.getTypeOfProduct(), 6, DISCOUNT_SIX_BAGELS, discountForProduct);
                addToDiscount(discountForProduct);
                counter -= 6;
            }
            if (counter >= 12) {
                addToBasketPrice(DISCOUNT_TWELVE_BAGELS);
                BigDecimal discountForProduct = countDiscountForBagel(product.getPrice(), BigDecimal.valueOf(12), DISCOUNT_TWELVE_BAGELS);
                addToReceiptList(product.getTypeOfProduct(), 12, DISCOUNT_TWELVE_BAGELS, discountForProduct);
                addToDiscount(discountForProduct);
                counter -= 12;
            }
        }
    }

    public BigDecimal countDiscountForBagel(BigDecimal productPrice, BigDecimal quantity, BigDecimal discount){
        return productPrice.multiply(quantity).subtract(discount);
    }

    public BigDecimal countDiscountForCoffeeBagel(BigDecimal productPrice, BigDecimal quantity, BigDecimal discount){
        return productPrice.multiply(quantity).subtract(discount.multiply(quantity));
    }

    public void addToDiscount(BigDecimal discount){
        this.discount = this.discount.add(discount);
    }

    public void addToReceiptList(ProductType productType, int quantity, BigDecimal value, BigDecimal discount){
        String name;
        if (isBagelProduct(productType)) {
            name = productType.getVariant() + " Bagel";
            receiptList.add(new ReceiptProduct(name, quantity, value, discount));
        }
        else if (productType.equals(ProductType.CBD)){
            receiptList.add(new ReceiptProduct(productType.getVariant(), quantity, value, discount));
        }
        else {
            name = productType.getVariant() + " Coffee";
            receiptList.add(new ReceiptProduct(name, quantity, value, discount));
        }
    }

    public void setBasketPrice(Product product, int counter){
        BigDecimal tmpPrice = product.getPrice().multiply(BigDecimal.valueOf(counter));
        addToReceiptList(product.getTypeOfProduct(), counter, tmpPrice, BigDecimal.ZERO);
        addToBasketPrice(tmpPrice);
    }

    public void setCoffeeBagelDiscount(Product product, int counter){
        BigDecimal tmpPrice = DISCOUNT_COFFEE_BAGEL.multiply(BigDecimal.valueOf(counter));
        BigDecimal discount = countDiscountForCoffeeBagel(product.getPrice(), BigDecimal.valueOf(counter), DISCOUNT_COFFEE_BAGEL);
        addToDiscount(discount);
        addToReceiptList(product.getTypeOfProduct(), counter, tmpPrice, discount);
        addToBasketPrice(tmpPrice);
    }

    private boolean isBagelProduct(ProductType productType) {
        return List.of(ProductType.BGLE, ProductType.BGLO, ProductType.BGLS, ProductType.BGLP).contains(productType);
    }

    public BigDecimal getPrice(){
        LinkedHashMap<Product, Integer> productCountMap = createProductMap();
        productCountMap.forEach((product, quantity) -> {
            if (product.getTypeOfProduct().equals(ProductType.BGLP) && quantity < 12)
                setBasketPrice(product, quantity);
            else if (isBagelProduct(product.getTypeOfProduct()))
                setBagelDiscount(product,quantity);
            else if (product.getTypeOfProduct().equals(ProductType.CBD))
                setCoffeeBagelDiscount(product, quantity);
            else
                setBasketPrice(product,quantity);
        });

        BigDecimal fillingPrice = listOfProducts.stream()
                .map(Product::getFillingPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        addFillingsToReceipt(fillingPrice);

        addToBasketPrice(fillingPrice);
        return basketPrice;
    }

    public void addFillingsToReceipt(BigDecimal fillingPrice){
        if (fillingPrice.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal numberOfFillings = fillingPrice.divide(BigDecimal.valueOf(0.12));
            receiptList.add(new ReceiptProduct("filling", numberOfFillings.intValue(), fillingPrice));
        }
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

        int totalWidth = 29;
        String centeredTitle = String.format("%" + (totalWidth - 5) + "s", "~~~ Bob's Bagels ~~~");
        String centeredDate = String.format("%" + (totalWidth + orderDate.length()) / 2 + "s", orderDate);
        sb.append(centeredTitle).append("\n");
        sb.append(centeredDate).append("\n");
        sb.append("-----------------------------\n");

        for (ReceiptProduct rp : receiptList) {
            sb.append(rp.toString()).append("\n");
        }

        sb.append("-----------------------------\n");
        sb.append(String.format("%-23s £%.2f", "Total", basketPrice)).append("\n\n");
        if (discount.compareTo(BigDecimal.ZERO) > 0) {
            sb.append("  You saved a total of £").append(discount).append("\n");
            sb.append("        on this shop").append("\n\n");
        }
        sb.append("        Thank you\n");
        sb.append("      for your order!");

        System.out.println(sb);

    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
//        Bagel bagel = new Bagel(ProductType.BGLO);
//        bagel.addFilling(FillingType.FILB);
//        bagel.addFilling(FillingType.FILB);
//        bagel.addFilling(FillingType.FILB);
//        bagel.addFilling(FillingType.FILB);
//        bagel.addFilling(FillingType.FILB);
//        basket.addProduct(bagel);
        basket.addProduct(new Bagel(ProductType.BGLP));
        basket.addProduct(new Bagel(ProductType.BGLP));
        basket.addProduct(new Bagel(ProductType.BGLP));
        basket.addProduct(new Bagel(ProductType.BGLP));
        basket.addProduct(new Bagel(ProductType.BGLP));
        basket.addProduct(new Bagel(ProductType.BGLP));
        basket.addProduct(new Bagel(ProductType.BGLP));

//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Bagel(ProductType.BGLO));
//        basket.addProduct(new Coffee(ProductType.COFW));
//        basket.addProduct(new CoffeeBagel(ProductType.BGLE));
//        basket.addProduct(new CoffeeBagel(ProductType.BGLP));
//        basket.addProduct(new CoffeeBagel(ProductType.BGLP));
//        basket.addProduct(new CoffeeBagel(ProductType.BGLP));



        basket.getReceipt();
    }
}