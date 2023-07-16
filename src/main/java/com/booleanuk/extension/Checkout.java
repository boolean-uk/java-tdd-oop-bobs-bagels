package com.booleanuk.extension;

import java.util.*;

public class Checkout {
    private final HashMap<String, Integer> costs;
    private final HashMap<String, Integer> amounts;
    private final HashMap<String, Integer> discounts;
    private final double totalCost;
    private final double totalDiscount;
    private final Basket basket;

    public Checkout(Basket basket) {
        this.basket = basket;
        this.costs = new HashMap<>();
        this.amounts = new HashMap<>();
        this.discounts = new HashMap<>();

        this.totalCost = countBasketCostWithDiscounts();
        this.totalDiscount = countBasketCostWithoutDiscounts(basket) - this.totalCost;

    }

    public static int getProductsCost(String productSKU, int quantity) {
        return Inventory.checkCostOfTheProduct(productSKU) * quantity;
    }

    private static int getMultiPricedProductsCost(String productSKU, HashMap<String, Integer> basketProducts) {
        var bargains = Inventory.getBargains(productSKU);

        if (bargains.isEmpty())
            return 0;

        bargains.sort(Comparator.comparingInt(Bargain::packSize));
        Collections.reverse(bargains);

        int cost = 0;
        for (Bargain b: bargains) {
            int packs = basketProducts.get(productSKU) / b.packSize();
            basketProducts.computeIfPresent(productSKU, (k, v) -> v - packs * b.packSize());
            cost += packs * b.packCost();
        }

        return cost;
    }

    public static double countBasketCostWithoutDiscounts(Basket basket){
        return (double) basket.getProductsCount()
                .entrySet()
                .stream()
                .map(s -> getProductsCost(s.getKey(), s.getValue()))
                .reduce(Integer::sum)
                .orElse(0) / 100;
    }

    public static double countBasketCostWithDiscounts(Basket basket) {
        int cost = 0;
        HashMap<String, Integer> productsInBasket = new HashMap<>(basket.getProductsCount());

        for (String productSKU : productsInBasket.keySet())
            cost += getMultiPricedProductsCost(productSKU, productsInBasket);

        cost += getProductsCombinationsCost(productsInBasket);

        for (String productSKU : productsInBasket.keySet())
            cost += getProductsCost(productSKU, productsInBasket.get(productSKU));

        return (double) cost / 100;
    }

    private double countBasketCostWithDiscounts() {
        int cost = 0;
        HashMap<String, Integer> productsInBasket = new HashMap<>(basket.getProductsCount());

        for (String productSKU : productsInBasket.keySet()) {
            int prevAmount = productsInBasket.get(productSKU);
            int c = getMultiPricedProductsCost(productSKU, productsInBasket);
            int actualAmount = productsInBasket.get(productSKU);

            updateProductsTrackMaps(productSKU, c, prevAmount - actualAmount);
            cost += c;
        }

        cost += getAndTrackProductsCombinationsCost(productsInBasket);

        for (String productSKU : productsInBasket.keySet()) {
            int quantity = productsInBasket.get(productSKU);
            int c = getProductsCost(productSKU, quantity);
            updateProductsTrackMaps(productSKU, c, quantity);
            cost += c;
        }

        updateDiscountsTrackMap();

        return (double) cost / 100;
    }

    private void updateProductsTrackMaps(String productSKU, int cost, int quantity) {
        if (cost == 0 || quantity == 0)
            return;

        this.costs.computeIfPresent(productSKU, (k, v) -> v + cost);
        this.costs.putIfAbsent(productSKU, cost);

        this.amounts.computeIfPresent(productSKU, (k, v) -> v + quantity);
        this.amounts.putIfAbsent(productSKU, quantity);
    }

    private void updateDiscountsTrackMap() {
        for (String productSKU: costs.keySet()) {
            int discount;

            if (Inventory.productNotInInventory(productSKU)) {
                discount = getCombinationBargainProductsRawCost(productSKU)
                        - this.costs.get(productSKU);
            } else
                discount = getProductsCost(productSKU, this.amounts.get(productSKU))
                        - this.costs.get(productSKU);

            if (discount != 0)
                this.discounts.put(productSKU, discount);
        }
    }

    private int getCombinationBargainProductsRawCost(String productSKU) {
        int cost = 0;

        var combinationBargain = Inventory.getCombinationBargains()
                .stream()
                .filter(b -> b.name().equals(productSKU))
                .findAny().orElse(null);

        if (combinationBargain != null)
            cost = combinationBargain.productsSKUs()
                .stream()
                .map(s -> getProductsCost(s, this.amounts.get(productSKU)))
                .reduce(Integer::sum)
                .orElse(0);

        return cost;
    }

    private static int getProductsCombinationsCost(HashMap<String, Integer> basketProducts){
        int cost = 0;

        var combinationBargains = new ArrayList<>(
                Inventory.getCombinationBargains()
        );

        sortCombinationBargainsByLeastProfitable(combinationBargains);

        for (CombinationBargain cb: combinationBargains) {
            var combinationProductSKUs = cb.productsSKUs();

            if (!basketProducts.keySet().containsAll(combinationProductSKUs))
                continue;

            while (productsInBasketProducts(combinationProductSKUs, basketProducts))
            {
                for (String combinationProductSKU : combinationProductSKUs)
                    basketProducts.computeIfPresent(combinationProductSKU, (k, v) -> v - 1);
                cost += cb.price();
            }
        }

        return cost;
    }

    private int getAndTrackProductsCombinationsCost(HashMap<String, Integer> basketProducts){
        int cost = 0;

        var combinationBargains = new ArrayList<>(
                Inventory.getCombinationBargains()
        );

        sortCombinationBargainsByLeastProfitable(combinationBargains);

        for (CombinationBargain cb: combinationBargains) {
            var combinationProductSKUs = cb.productsSKUs();

            if (!basketProducts.keySet().containsAll(combinationProductSKUs))
                continue;

            int quantity = 0;
            int combinationCost = 0;
            while (productsInBasketProducts(combinationProductSKUs, basketProducts))
            {
                quantity++;
                for (String combinationProductSKU : combinationProductSKUs)
                    basketProducts.computeIfPresent(combinationProductSKU, (k, v) -> v - 1);

                combinationCost += cb.price();
            }

            updateProductsTrackMaps(cb.name(), combinationCost, quantity);
            cost += combinationCost;
        }

        return cost;
    }

    private static boolean productsInBasketProducts(List<String> productSKUs, HashMap<String, Integer> basketProducts) {
        return basketProducts.entrySet()
                .stream()
                .filter(s -> productSKUs.contains(s.getKey()))
                .allMatch((s -> s.getValue() > 0));
    }

    private static void sortCombinationBargainsByLeastProfitable(List<CombinationBargain> combinationBargains) {
        combinationBargains.sort(Comparator.comparing(
                k -> k.productsSKUs()
                        .stream()
                        .map(Inventory::checkCostOfTheProduct)
                        .reduce(Integer::sum)
                        .orElse(0)));
    }

    public HashMap<String, Integer> getCosts() {
        return costs;
    }

    public HashMap<String, Integer> getAmounts() {
        return amounts;
    }

    public HashMap<String, Integer> getDiscounts() {
        return discounts;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public Receipt getReceipt() {
        return new Receipt(
                this.costs,
                this.amounts,
                this.discounts,
                this.totalCost,
                this.totalDiscount
        );
    }
}
