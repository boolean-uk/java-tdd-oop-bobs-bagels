package com.booleanuk.core.basket;

import com.booleanuk.core.Inventory.Discount;
import com.booleanuk.core.Inventory.Inventory;
import com.booleanuk.core.Inventory.MultipleProductsDiscount;
import com.booleanuk.core.Inventory.SingleProductDiscount;
import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.Filling;
import com.booleanuk.core.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Basket implements BasketOperations {
    private final Inventory inventory = Inventory.getInstance();
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
            throw new BasketOverfillException("Basket overfill");
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
        return (products.size() == capacity);
    }

    @Override
    public boolean isProductInBasket(Product product) {
        return products.contains(product);

    }

    @Override
    public BasketSummary summarizeBasket() {

        HashMap<Product, BigDecimal> savings = new HashMap<>();
        BigDecimal total = BigDecimal.ZERO;

        total = summarizeBasketWithoutDiscounts(total);

        total = applyDiscounts(savings, total);

        return new BasketSummary(total, savings);
    }

    private BigDecimal applyDiscounts(HashMap<Product, BigDecimal> savings, BigDecimal total) {

        for (Discount discount : inventory.getAvailableDiscounts()) {
            if (isDiscountRequirementsMet(discount)) {

                if (isSingleProductDiscount(discount)) {
                    SingleProductDiscount singleProductDiscount = (SingleProductDiscount) discount;
                    if (isProductAlreadyDiscounted(savings, singleProductDiscount)) {
                        total = applySingleDiscount(savings, total, singleProductDiscount);
                    }
                }
                if (isMultipleProductsDiscount(discount)) {
                    MultipleProductsDiscount multipleProductsDiscount = (MultipleProductsDiscount) discount;
                    if (isProductAlreadyDiscounted(savings, multipleProductsDiscount)) {
                        total = applyMultipleProductsDiscount(savings, total, multipleProductsDiscount);
                    }
                }
            }
        }
        return total;
    }

    private BigDecimal applySingleDiscount(HashMap<Product, BigDecimal> savings, BigDecimal total, SingleProductDiscount discount) {


        BigDecimal discountedValue = discount.getDiscountedPrice().multiply(getAmountOfDiscountOccurrences(discount));
        BigDecimal productsValue = discount.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(discount.getRequiredAmount())
                        .multiply(getAmountOfDiscountOccurrences(discount)));

        total = total.subtract(productsValue);

        addSavedMoney(savings, discount);

        if (total.compareTo((BigDecimal.ZERO)) < 0) {
            total = BigDecimal.ZERO;
        }

        return total.add(discountedValue);
    }

    private BigDecimal applyMultipleProductsDiscount(HashMap<Product, BigDecimal> savings, BigDecimal total, MultipleProductsDiscount discount) {


        BigDecimal discountedValue = discount.getDiscountedPrice().multiply(getAmountOfDiscountOccurrences(discount));

        BigDecimal productsValue = discount.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(discount.getRequiredAmount()))
                .add(discount.getOptionalRequiredProduct().getPrice());

        total = total
                .subtract(productsValue);

        addSavedMoney(savings, discount);

        if (total.compareTo((BigDecimal.ZERO)) < 0) {
            total = BigDecimal.ZERO;
        }

        return total.add(discountedValue);
    }

    private boolean isMultipleProductsDiscount(Discount discount) {
        return discount instanceof MultipleProductsDiscount;
    }

    private BigDecimal summarizeBasketWithoutDiscounts(BigDecimal total) {
        for (Product product : products) {
            if (product instanceof Bagel) {
                total = total.add(((Bagel) product).getPriceWithFilling());
            } else {
                total = total.add(product.getPrice());
            }
        }
        return total;
    }

    private BigDecimal getAmountOfDiscountOccurrences(Discount discount) {
        return BigDecimal.valueOf(Collections.frequency(products, discount.getProduct())).divideToIntegralValue(BigDecimal.valueOf(discount.getRequiredAmount()));
    }

    private boolean isSingleProductDiscount(Discount discount) {
        return discount instanceof SingleProductDiscount;
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

    private boolean isProductAlreadyDiscounted(HashMap<Product, BigDecimal> savings, Discount discount) {
        if (discount instanceof MultipleProductsDiscount multipleProductsDiscount) {
            return !savings.containsKey(multipleProductsDiscount.getProduct()) && !savings.containsKey(multipleProductsDiscount.getOptionalRequiredProduct());
        }
        return !savings.containsKey(discount.getProduct());
    }

    public String listBasket() {
        StringBuilder basket = new StringBuilder();
        int number = 0;
        for (Product product : products) {
            if (product instanceof Bagel) {
                basket.append(String.format("%-25s %10s", number + "." + product, "$" + product.getPrice())).append("\n");
                for (Filling filling : ((Bagel) product).getFillings()) {
                    basket.append(String.format("%-25s %10s", "  ^" + filling, "$" + filling.getPrice())).append("\n");
                }
            } else
                basket.append(String.format("%-25s %10s", number + "." + product.toString(), "$" + product.getPrice())).append("\n");

            number++;
        }
        return basket.toString();
    }
}
