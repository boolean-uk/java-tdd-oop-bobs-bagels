package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Basket {
    private final ArrayList<Product> products;
    private final ArrayList<Product> unDiscountedProducts;
    private int basketSize;

    public Basket(int basketSize) {
        products = new ArrayList<>();
        unDiscountedProducts = new ArrayList<>();
        this.basketSize = basketSize;
    }

    public int size() {
        return products.size();
    }

    public void addProduct(Product product) {
        if (products.size() < basketSize) {
            products.add(product);
            unDiscountedProducts.add(product);
        }
    }

    public static void main(String[] args) {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 18; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        }
        System.out.println(b.findDiscount());
    }

    public float findDiscount() {
        ArrayList<Product> bagels = new ArrayList<>();
        for (Product p: unDiscountedProducts) {
            if (p instanceof Bagel) {
                bagels.add(p);
            }
        }
        // Sort and compare bread cost
        bagels.sort((o1, o2) -> (int) (1000 * (((Bagel) o2).calculateBreadCost() - ((Bagel) o1).calculateBreadCost())));
        if (bagels.size() >= 12) {
            return calculateDiscount(bagels, 12, 3.99f) + findDiscount();
        } else if (bagels.size() >= 6) {
            return calculateDiscount(bagels, 6, 2.49f) + findDiscount();
        } else if (bagels.size() < unDiscountedProducts.size()) {
            // Sort so Bagels are first, after that, sort by cost.
            unDiscountedProducts.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1 instanceof Bagel && o2 instanceof Bagel) {
                        return (int) (1000 * (((Bagel) o2).calculateBreadCost() - ((Bagel) o1).calculateBreadCost()));
                    } else if (o1 instanceof Coffee && o2 instanceof Coffee) {
                        return (int) (1000 * (o2.calculateCost() - o1.calculateCost()));
                    } else if (o1 instanceof Bagel) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });


            int coffeeBagelDeals = (unDiscountedProducts.size() - Math.abs(unDiscountedProducts.size() - bagels.size()));
            float sumCost = 0.0f;
            for (int i = 0; i < coffeeBagelDeals; i++) {
                unDiscountedProducts.removeFirst();
            }
            for (int i = 0; i < coffeeBagelDeals; i++) {
                sumCost += unDiscountedProducts.get(i).calculateCost() + ((Bagel) bagels.get(i)).calculateBreadCost();
            }
            return sumCost - 1.25f * coffeeBagelDeals;
        }
        return 0;
    }

    private float calculateDiscount(ArrayList<Product> items, int num, float dis) {
        float sumCost = 0.0f;
        float sumBreadCost = 0.0f;
        for (int i = 0; i < num; i++) {
            sumCost += items.get(i).calculateCost();
            sumBreadCost += ((Bagel)items.get(i)).calculateBreadCost();
            unDiscountedProducts.remove(items.get(i));
        }
        return sumBreadCost - dis;
    }

    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new NoSuchElementException("No such product exists");
        }
        products.remove(product);
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setBasketSize(int basketSize) {
        if (basketSize < products.size()) {
            products.clear();
        }
        this.basketSize = basketSize;
    }

    public float calculateCost() {
        float sum = 0.0f;
        for (Product p: products) {
            sum += p.calculateCost();
        }
        return sum;
    }
}
