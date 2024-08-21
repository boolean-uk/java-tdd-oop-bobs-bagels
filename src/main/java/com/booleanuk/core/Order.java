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
            if (product instanceof Bagel bagel) {
                if (bagelCounter < 12) {
                    bagel.setDiscounted(true);
                }
                bagelCounter++;
            }
            if (product instanceof Coffee) {
                coffeeCounter++;
            }
        }

        boolean remove = bagelCounter < 12 && bagelCounter > 6;
        if (remove) {
            for (int i = 6; i < bagelCounter; i++) {
                Product product = basket.getProducts().get(i);
                if (product instanceof Bagel) {
                    basket.getProducts().get(i).setDiscounted(false);
                }
            }
        }

        if (bagelCounter < 6) {
            basket.getProducts().forEach(item -> {
                if (item instanceof Bagel bagel) {
                    bagel.setDiscounted(false);
                }
            });
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

        for (Product product : this.basket.getProducts()) {
            if (product instanceof Bagel bagel) {
                addFillingPriceToTotalCost(bagel);
            }
            if (!product.getDiscounted()) {
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

    public static void main(String[] args) throws FullBasketException {

        Order order = new Order();
        Basket basket1 = order.getBasket();
        basket1.changeCapacity(20);

        Bagel bagelWithFilling = new Bagel().createBagelWithFilling(
                BagelType.ONION
        );
        basket1.addProduct(bagelWithFilling);
        basket1.addProduct(BagelType.PLAIN);

        Double price = order.getTotalCost();
        System.out.println("Total price is " + String.format("%.02f", price));
    }
}
