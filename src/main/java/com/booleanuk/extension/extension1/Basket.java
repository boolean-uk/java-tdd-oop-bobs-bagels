package com.booleanuk.extension.extension1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private static final int DEFAULT_CAPACITY = 40;
    private static final BigDecimal DISCOUNT_SIX_BAGELS = BigDecimal.valueOf(2.49);
    private static final BigDecimal DISCOUNT_TWELVE_BAGELS = BigDecimal.valueOf(3.99);
    private static int capacity = DEFAULT_CAPACITY;
    private int basketCapacity;
    private BigDecimal basketPrice = BigDecimal.ZERO;
    private ArrayList<Product> listOfProducts = new ArrayList<>();
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
                addToBasketPrice(product.getPrice().multiply(BigDecimal.valueOf(counter)));
                counter = 0;
            }
            if (counter >= 6 && counter < 12) {
                addToBasketPrice(DISCOUNT_SIX_BAGELS);
                counter -= 6;
            }
            if (counter >= 12) {
                addToBasketPrice(DISCOUNT_TWELVE_BAGELS);
                counter -= 12;
            }
        }
    }

    public void setBasketPrice(Product product, int counter){
        addToBasketPrice(product.getPrice().multiply(BigDecimal.valueOf(counter)));
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
}