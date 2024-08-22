package com.booleanuk.core;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Order {
    private final Basket basket;
    private Double totalCost;
    private final Double discount1 = 2.49;
    private final Double discount2 = 3.99;
    private final Double discount3 = 1.25;

    public Order() {
        this.basket = new Basket();
        this.totalCost = 0.0;
    }

    public Basket getBasket() {
        return basket;
    }

    private int getNumberOfItems(Basket basket)  {
        int bagelCounter = 0;

        for (Product product : basket.getProducts()) {
            if (isBagel(product)) bagelCounter++;
        }

        int test = bagelCounter % 12;
        if (bagelCounter == 12) {
            for (Product product : basket.getProducts()) {
                if (isBagel(product)) {
                    product.setHasDiscount(true);
                }
            }
        }
        else if (bagelCounter < 12 && bagelCounter >= 6) {
            markAsDiscounted(6);
        }
        else if (bagelCounter > 12) {
            markAsDiscounted(12);
        }

        ArrayList<Product> unmarked = this.basket.getProducts().stream()
                .filter(item -> !item.getHasDiscount())
                .collect(Collectors.toCollection(ArrayList::new));

        int start = this.basket.getProducts().size() - unmarked.size();
        int end = start % unmarked.size() + 1;
        if ((bagelCounter > 12) && (unmarked.size() > 6)) {
            markAsDiscounted(start, end);
        }

        return bagelCounter;
    }

    public double getTotalCost() {
        int numBagels = getNumberOfItems(this.getBasket());

        int num = 0;
        for (Product product : this.basket.getProducts()) {
            if (product instanceof Bagel bagel) {

                if (bagel.getHasDiscount()) {
                    num += 1;
                }
            }
        }

        System.out.println("Number of bagels marked as discounted: " + num);

        // This checks for 6 and 12 bagel discounts.
        while (numBagels >= 6) {
            Double discount = getCorrectDiscount(numBagels);
            if (discount != null) {
                if (discount.equals(discount2)) {
                    numBagels -= 12;
                }
                else if (discount.equals(discount1)) {
                    numBagels -= 6;
                }
                this.totalCost += discount;
            }
        }


        for (int i = 0; i < this.basket.getProducts().size(); i++) {
            Product product = this.basket.getProducts().get(i);

            // Skip to next iteration.
            if (product.getHasDiscount()) {
                continue;
            }

            // Add filling price to the total.
            if (product instanceof Bagel bagel) {
                addFillingPriceToTotalCost(bagel);
            }

            // Check for coffee and bagel pairs and give discount.
            int j = i+1;
            while (j < this.basket.getProducts().size()) {
                Product nextProduct = this.basket.getProducts().get(j);
                checkCoffeeAndBagelPair(product, nextProduct);
                j++;
            }

            // If the item does not have a discount, just get the normal price.
            if (!product.getHasDiscount()) {
                this.totalCost += product.getPrice();
            }
        }

        return deliverAndResetTotalCost(this.totalCost);
    }

    // Internal helper method.
    private void addFillingPriceToTotalCost(Bagel bagel) {
        if (!bagel.getFillings().isEmpty()) {
            bagel.getFillings().forEach(filling -> this.totalCost += filling.getPrice());
        }
    }

    // Internal helper method.
    private Double getCorrectDiscount(int num) {
        return num >= 6 && num < 12 ? discount1 : num < 6 ? null : discount2;
    }

    // Internal helper method.
    private void checkCoffeeAndBagelPair(Product product, Product next) {
        if (next instanceof Bagel && product instanceof Coffee) {
            if (!next.getHasDiscount() && !product.getHasDiscount()) {
                this.totalCost += discount3;
                next.setHasDiscount(true);
                product.setHasDiscount(true);
            }
        }
        else if (next instanceof Coffee && product instanceof Bagel) {
            if (!next.getHasDiscount() && !product.getHasDiscount()) {
                this.totalCost += discount3;
                next.setHasDiscount(true);
                product.setHasDiscount(true);
            }
        }
    }

    // Internal helper method.
    private void markAsDiscounted(int limit) {
        int discountBagels = 0;
        for (Product product : basket.getProducts()) {
            if (product instanceof Bagel && discountBagels < limit) {
                product.setHasDiscount(true);
                discountBagels++;
            }
        }
    }

    private void markAsDiscounted(int start, int limit) {
        for (int i = start; i < (start + limit); i++) {
            Product product = this.basket.getProducts().get(i);
            if (product instanceof Bagel) {
                product.setHasDiscount(true);
            }
        }
    }

    // Internal helper method.
    private boolean isBagel(Product product) {
        return product instanceof Bagel;
    }

    // Internal helper method.
    private Double deliverAndResetTotalCost(Double total) {
        double cost = total;
        this.totalCost = 0.0;
        return cost;
    }

    public static void main(String[] args) throws FullBasketException {

        Order order = new Order();
        Basket basket1 = order.getBasket();
        basket1.changeCapacity(30);

        for (int i = 0; i < 12; i++) {
            basket1.addProduct(BagelType.PLAIN);
        }

        for (int i = 0; i < 7; i++) {
            basket1.addProduct(BagelType.EVERYTHING);
        }

        String total = String.format("%.02f", order.getTotalCost());
        System.out.println(total);
    }
}
