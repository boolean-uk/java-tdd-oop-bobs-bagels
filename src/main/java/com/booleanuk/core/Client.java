package com.booleanuk.core;

import java.util.List;
import java.util.stream.Collectors;

public class Client {
    private static int nextId = 0;
    private int id;
    private Basket basket;

    public Client() {
        this.id = nextId++;
        this.basket = new Basket();
    }

    public void orderBagel(String bagelVariant, List<String> filling){
        Bagel bagel = Manager.getBagelByVariant(bagelVariant);
        List<Filling> fillings = Manager.getFillingsByVariants(filling);

        bagel.setFillings(fillings);
        basket.addToBasket(bagel);
    }

    public List<Product> getBasketContents() {
        return basket.getContents();
    }

    private List<Bagel> getAllBagelsFromBasket() {
        return getBasketContents().stream()
                .filter(product -> product instanceof Bagel)
                .map(product -> (Bagel) product)
                .collect(Collectors.toList());
    }

    public Bagel getBagelIfPresent(String bagelVariant, List<String> fillings) {
        for (Bagel bagel : getAllBagelsFromBasket()) {
            List<String> fillingVariants = bagel.getFillings().stream()
                    .map(Filling::getVariant)
                    .toList();
            if (bagel.getVariant().equals(bagelVariant) && fillingVariants.equals(fillings)) {
                return bagel;
            }
        }
        return null;
    }

    public void cancelOrder(Bagel bagel) {
        basket.removeFromBasket(bagel);
    }

    public double getTotalBasketCost() {
        return basket.getTotalCost();
    }

    public double getFillingPrice(String fillingVariant) {
        Filling filling = Manager.getFillingByVariant(fillingVariant);
        return filling.getPrice();
    }

    public double getBagelPrice(String bagelVariant) {
        Bagel bagel = Manager.getBagelByVariant(bagelVariant);
        return bagel.getPrice();
    }

    public boolean isBasketFull() {
        return basket.isBasketFull();
    }


}
