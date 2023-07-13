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
    private final Store store = Store.getInstance();
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
    public BasketSummary summarizeBasket() {

        HashMap<Product, BigDecimal> savings = new HashMap<>();

        BigDecimal total = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        for (Discount discount : store.getAvailableDiscounts()) {
            if (isDiscountRequirementsMet(discount)) {
                if (isSingleProductDiscount(discount)) {

                    total = total.subtract(discount.getProduct().getPrice()
                            .multiply(BigDecimal.valueOf(discount.getRequiredAmount())
                                    .multiply(getAmountOfDiscountOccurrences(discount))));

                    addSavedMoney(savings, discount);

                } else {
                    total = total
                            .subtract(discount.getProduct().getPrice()
                                    .multiply(BigDecimal.valueOf(discount.getRequiredAmount())))
                            .subtract(discount.getOptionalRequiredProduct().getPrice());
                    addSavedMoney(savings, discount);
                }

                if (total.compareTo((BigDecimal.ZERO)) < 0) {
                    total = BigDecimal.ZERO;
                }
                total = total.add(discount.getDiscountedPrice()
                        .multiply(getAmountOfDiscountOccurrences(discount)));
            }
        }
        return new BasketSummary(total, savings);
    }

    private BigDecimal getAmountOfDiscountOccurrences(Discount discount) {
        return BigDecimal.valueOf(Collections.frequency(products, discount.getProduct())).divideToIntegralValue(BigDecimal.valueOf(discount.getRequiredAmount()));
    }

    private boolean isSingleProductDiscount(Discount discount) {
        return !(discount.getOptionalRequiredProduct() != null && products.contains(discount.getOptionalRequiredProduct()));
    }

    private boolean isDiscountRequirementsMet(Discount discount) {
        return products.contains(discount.getProduct()) && hasRequiredAmountOfThisProduct(discount);
    }

    private void addSavedMoney(HashMap<Product, BigDecimal> discounts, Discount discount) {
        BigDecimal productPrice = discount.getProduct().getPrice();
        BigDecimal requiredAmountOfProductToActivateDiscount = BigDecimal.valueOf(discount.getRequiredAmount());
        BigDecimal discountedPrice = discount.getDiscountedPrice();

        BigDecimal savedMoney = productPrice
                .multiply(requiredAmountOfProductToActivateDiscount)
                .subtract(discountedPrice);

        discounts.put(discount.getProduct(), savedMoney);
    }

    private boolean hasRequiredAmountOfThisProduct(Discount discount) {
        return Math.floor((double) Collections.frequency(products, discount.getProduct()) / discount.getRequiredAmount()) >= 1;
    }

    @Override
    public int getProductsAmount() {
        return this.products.size();

    }
}
