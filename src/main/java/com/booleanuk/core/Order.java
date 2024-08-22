package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;

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

    private int[] getNumberOfItems(Basket basket)  {
        int bagelCounter = 0;
        int coffeeCounter = 0;

        for (Product product : basket.getProducts()) {
            if (product instanceof Bagel) {
                bagelCounter++;
            }
            if (product instanceof Coffee) {
                coffeeCounter++;
            }
        }

        if (bagelCounter == 12) {
            for (Product product : basket.getProducts()) {
                if (product instanceof Bagel) {
                    product.setHasDiscount(true);
                }
            }
        }
        else if (bagelCounter < 12 && bagelCounter >= 6) {
            int discountBagels = 0;
            for (Product product : basket.getProducts()) {
                if (product instanceof Bagel && discountBagels < 6) {
                    product.setHasDiscount(true);
                    discountBagels++;
                }
            }
        }
        else if (bagelCounter > 12) {
            int discountBagels = 0;
            for (Product product : basket.getProducts()) {
                if (product instanceof Bagel && discountBagels < 12) {
                    product.setHasDiscount(true);
                    discountBagels++;
                }
            }
        }

        return new int[] { bagelCounter, coffeeCounter };
    }

    public double getTotalCost() {
        int[] items = getNumberOfItems(this.getBasket());
        int numBagels = items[0];

        Double discount = getCorrectDiscount(numBagels);
        if (discount != null) {
            this.totalCost += discount;
        }

        for (int i = 0; i < this.basket.getProducts().size(); i++) {
            Product product = this.basket.getProducts().get(i);
            if (product.getHasDiscount()) {
                continue;
            }

            if (product instanceof Bagel bagel) {
                addFillingPriceToTotalCost(bagel);
            }

            int j = i+1;
            while (j < this.basket.getProducts().size()) {
                Product nextProduct = this.basket.getProducts().get(j);
                checkCoffeeAndBagelPair(product, nextProduct);
                j++;
            }

            if (!product.getHasDiscount()) {
                this.totalCost += product.getPrice();
            }
        }

        return totalCost;
    }


    private void addFillingPriceToTotalCost(Bagel bagel) {
        if (!bagel.getFillings().isEmpty()) {
            bagel.getFillings().forEach(filling -> this.totalCost += filling.getPrice());
        }
    }

    private Double getCorrectDiscount(int num) {
        return num >= 6 && num < 12 ? discount1 : num < 6 ? null : discount2;
    }

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

    public static void main(String[] args) throws FullBasketException {

        Order order = new Order();
        Basket basket1 = order.getBasket();
        basket1.changeCapacity(20);

        basket1.addProduct(BagelType.PLAIN);
        basket1.addProduct(BagelType.PLAIN);
        basket1.addProduct(BagelType.PLAIN);
        basket1.addProduct(BagelType.PLAIN);
        basket1.addProduct(BagelType.PLAIN);
        basket1.addProduct(BagelType.PLAIN);


        Double price = order.getTotalCost();
        System.out.println("Total price is " + String.format("%.02f", price));
    }
}
