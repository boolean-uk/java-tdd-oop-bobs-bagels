package com.booleanuk.core;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;

public class Order {
    private final Basket basket;
    private Double totalCost;

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
        applyDiscount(basket, bagelCounter);

        return bagelCounter;
    }

    public double getTotalCost() {
        int numBagels = getNumberOfItems(this.getBasket());

        // Add discount for 12 and 6 bagel sets.
        numBagels = addDiscount(numBagels, 12, 3.99);
        addDiscount(numBagels, 6, 2.49);

        for (int i = 0; i < this.basket.getProducts().size(); i++) {
            Product product = this.basket.getProducts().get(i);

            // Add filling price to the total.
            if (isBagel(product)) {
                addFillingPriceToTotalCost((Bagel) product);
            }

            // Check for coffee and bagel pairs and give discount.
            int j = i+1;
            while (j < this.basket.getProducts().size()) {
                Product nextProduct = this.basket.getProducts().get(j);
                checkCoffeeAndBagelPair(product, nextProduct);
                checkCoffeeAndBagelPair(nextProduct, product);
                j++;
            }

            // Give normal price if product does not have a discount.
            if (!product.getHasDiscount()) {
                this.totalCost += product.getPrice();
            }
        }

        return deliverAndResetTotalCost(this.totalCost);
    }

    private int addDiscount(int numBagels, int limit, double discount) {
        while (numBagels >= limit) {
            this.totalCost += discount;
            numBagels -= limit;
        }
        return numBagels;
    }

    // Used to find numbers of sets for 12 and 6 bagels.
    private void applyDiscount(Basket basket, Integer bagelCounter) {
        int twelveSet = bagelCounter / 12;
        int remainingAfterTwelve = bagelCounter % 12;
        int sixSet = remainingAfterTwelve / 6;

        markAsDiscounted(basket, (twelveSet * 12));
        markAsDiscounted(basket, (sixSet * 6));
    }

    // Internal helper method.
    private void addFillingPriceToTotalCost(Bagel bagel) {
        if (!bagel.getFillings().isEmpty()) {
            bagel.getFillings().forEach(filling -> this.totalCost += filling.getPrice());
        }
    }

    // Internal helper method.
    private void checkCoffeeAndBagelPair(Product product, Product next) {
        if (next instanceof Bagel && product instanceof Coffee) {
            if (!next.getHasDiscount() && !product.getHasDiscount()) {
                this.totalCost += 1.25;
                next.setHasDiscount(true);
                product.setHasDiscount(true);
            }
        }
    }

    // Internal helper method.
    private void markAsDiscounted(Basket basket, int bagelsToMark) {
        for (Product product : basket.getProducts()) {
            if (isBagel(product) && bagelsToMark > 0) {
                if (product.getHasDiscount()) continue;
                product.setHasDiscount(true);
                bagelsToMark--;
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
}
