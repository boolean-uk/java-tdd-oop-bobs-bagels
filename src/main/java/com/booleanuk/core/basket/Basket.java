package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.store.Discount;
import com.booleanuk.core.store.Store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Basket implements BasketOperations {
    private List<Product> products = new ArrayList<>(0);
    private int capacity = 5;

    public Basket() {
    }

    public Basket(int capacity) {
        setCapacity(capacity);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity cant be smaller than 1");
        }
        this.capacity = capacity;
    }

    @Override
    public boolean addProduct(Product product) {
        if (isFull()) {
            return false;
        }
        products.add(product);
        return true;
    }


    public boolean addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (isFull()) {
                return false;
            }
            products.add(product);
        }
        return true;
    }

    @Override
    public boolean removeProduct(Product product) {
        if (!products.contains(product)) {
            return false;
        }
        products.remove(product);
        return true;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isProductInBasket(Product product) {
        return products.contains(product);

    }

    @Override
    public BigDecimal summarizeBasket() {
        Store store = Store.getInstance();

        HashMap<Product, BigDecimal> discounts = new HashMap<>();


        BigDecimal sum = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

//        BigDecimal sum = BigDecimal.valueOf(products.stream().mapToDouble(Product::getPrice).sum());

        for (Discount discount : store.getAvailableDiscounts()) {
            if (products.contains(discount.getProduct()) && Collections.frequency(products, discount.getProduct()) == discount.getRequiredAmount()) {
                if (discount.getOptionalRequiredProduct() != null && products.contains(discount.getOptionalRequiredProduct())) {

//                    Calculate received discount on this item
                    var productDiscount = discount.getProduct().getPrice().multiply(BigDecimal.valueOf(discount.getRequiredAmount())).subtract(discount.getDiscountedPrice());
                    discounts.put(discount.getProduct(), productDiscount);

                    sum = sum
                            .subtract(discount.getProduct().getPrice()
                                    .multiply(BigDecimal.valueOf(discount.getRequiredAmount())))
                            .subtract(discount.getOptionalRequiredProduct().getPrice());
                } else {

//                    Calculate received discount on this item
                    var productDiscount = discount.getProduct().getPrice().multiply(BigDecimal.valueOf(discount.getRequiredAmount())).subtract(discount.getDiscountedPrice());
                    discounts.put(discount.getProduct(), productDiscount);

                    sum = sum
                            .subtract(discount.getProduct().getPrice()
                                    .multiply(BigDecimal.valueOf(discount.getRequiredAmount())));
                }

                if (BigDecimal.ZERO.equals(sum)) sum = BigDecimal.ZERO;
                sum = sum.add(discount.getDiscountedPrice());
            }
        }
        return sum;
    }

    @Override
    public int getProductsAmount() {
        return this.products.size();

    }
}
