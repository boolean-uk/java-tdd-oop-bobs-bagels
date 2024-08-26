package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Basket {
    private final ArrayList<Product> products;
    private ArrayList<Product> unDiscountedProducts;
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
            // Sort so Bagels are first, coffee after. After sort by cost, but coffee is sorted inversely.
            unDiscountedProducts.sort((o1, o2) -> switch (o1) {
                case Bagel bagel when o2 instanceof Bagel ->
                        (int) (1000 * (((Bagel) o2).calculateBreadCost() - bagel.calculateBreadCost()));
                case Coffee ignored when o2 instanceof Coffee ->
                        (int) (1000 * (o1.calculateCost() - o2.calculateCost()));
                case Bagel ignored -> -1;
                case null, default -> 1;
            });


            int coffeeSize = products.size() - bagels.size();
            int coffeeBagelDeals = Math.min(bagels.size(), coffeeSize);
            float sumCost = 0.0f;
            for (int i = 0; i < coffeeBagelDeals; i++) {
                sumCost += unDiscountedProducts.get(unDiscountedProducts.size() - 1 - i).calculateCost() + ((Bagel) bagels.get(i)).calculateBreadCost();
            }
            return sumCost - 1.25f * coffeeBagelDeals;
        }
        return 0;
    }

    private float calculateDiscount(ArrayList<Product> items, int num, float dis) {
        float sumBreadCost = 0.0f;
        for (int i = 0; i < num; i++) {
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
        float discount = findDiscount();
        sum -= discount;
        unDiscountedProducts = new ArrayList<>(products);
        return sum;
    }

    record ReceiptInfo(HashMap<String, Integer> fillings,
                       ArrayList<Triple<HashMap<String, Integer>, Float, Float>> deals, ArrayList<Product> remaining) {
    }

    public ReceiptInfo receiptInformation() {
        HashMap<String, Integer> fillings = new HashMap<>(); // <filling, num> to display later
        ArrayList<Triple<HashMap<String, Integer>, Float, Float>> deals = new ArrayList<>(); // T< HM<name, num> , price, discount>>
        ArrayList<Product> remaining = new ArrayList<>();



        unDiscountedProducts = new ArrayList<>(products);
        ArrayList<Product> bagels = new ArrayList<>();
        for (Product p: unDiscountedProducts) {
            if (p instanceof Bagel) {
                for (Triple<String, String, Float> t: ((Bagel) p).getFillings()) {
                    if (fillings.containsKey(t.b())) {
                        fillings.replace(t.b(), fillings.get(t.b()) + 1);
                    } else {
                        fillings.put(t.b(), 1);
                    }
                }
                bagels.add(p);
            }
        }

        bagels.sort((o1, o2) -> (int) (1000 * (((Bagel) o2).calculateBreadCost() - ((Bagel) o1).calculateBreadCost())));

        boolean keepRunning = true;
        while (keepRunning) {
            if (bagels.size() >= 12) {
                HashMap<String, Integer> breadKinds = new HashMap<>();
                float breadCost = 3.99f;
                for (int i = 0; i < 12; i++) {
                    String bagelType = bagels.get(i).name();
                    if (breadKinds.containsKey(bagelType)) {
                        breadKinds.replace(bagelType, breadKinds.get(bagelType) + 1);
                    } else {
                        breadKinds.put(bagelType, 1);
                    }
                }
                float discount = calculateDiscount(bagels, 12, 3.99f);
                deals.add(new Triple<>(breadKinds, breadCost, -discount));
                for (int i = 0; i < 12; i++) {
                    bagels.removeFirst();
                }
            } else if (bagels.size() >= 6) {
                HashMap<String, Integer> breadKinds = new HashMap<>();
                float breadCost = 2.49f;
                for (int i = 0; i < 6; i++) {
                    String bagelType = bagels.get(i).name();
                    if (breadKinds.containsKey(bagelType)) {
                        breadKinds.replace(bagelType, breadKinds.get(bagelType) + 1);
                    } else {
                        breadKinds.put(bagelType, 1);
                    }
                }
                float discount = calculateDiscount(bagels, 6, 2.49f);
                deals.add(new Triple<>(breadKinds, breadCost, -discount));
                for (int i = 0; i < 6; i++) {
                    bagels.removeFirst();
                }
            } else if (bagels.size() < unDiscountedProducts.size()) {
                // Sort so Bagels are first, after that, sort by cost.
                unDiscountedProducts.sort((o1, o2) -> switch (o1) {
                    case Bagel bagel when o2 instanceof Bagel ->
                            (int) (1000 * (((Bagel) o2).calculateBreadCost() - bagel.calculateBreadCost()));
                    case Coffee ignored when o2 instanceof Coffee ->
                            (int) (1000 * (o2.calculateCost() - o1.calculateCost()));
                    case Bagel ignored -> -1;
                    case null, default -> 1;
                });


                HashMap<String, Integer> breadKinds = new HashMap<>();
                HashMap<String, Integer> coffeeType = new HashMap<>();
                ArrayList<Product> coffeeList = new ArrayList<>();

                for (Product p: unDiscountedProducts) {
                    if (p instanceof Coffee) {
                        coffeeList.add(p);
                    }
                }

                int coffeeBagelDeals = Math.min(bagels.size(), coffeeList.size());
                for (int i = 0; i < coffeeBagelDeals; i++) {
                    String bagelType = bagels.get(i).name();
                    if (breadKinds.containsKey(bagelType)) {
                        breadKinds.replace(bagelType, breadKinds.get(bagelType) + 1);
                    } else {
                        breadKinds.put(bagelType, 1);
                    }

                    String coffeeString = coffeeList.get(i).name();
                    if (coffeeType.containsKey(coffeeString)) {
                        coffeeType.replace(coffeeString, coffeeType.get(coffeeString) + 1);
                    } else {
                        coffeeType.put(coffeeString, 1);
                    }
                }

                for (int i = 0; i < coffeeBagelDeals; i++) {
                    HashMap<String, Integer> dealContents = new HashMap<>();
                    dealContents.put(coffeeList.get(i).name(), 1);
                    dealContents.put(unDiscountedProducts.getFirst().name(), 1);
                    float coffeeCost = ((Coffee) coffeeList.get(i)).getCoffeeType().c();
                    float bagelCost = ((Bagel) unDiscountedProducts.getFirst()).getBagelType().c();
                    float dis = 1.25f - coffeeCost - bagelCost;
                    deals.add(new Triple<>(dealContents, 1.25f, dis));
                    unDiscountedProducts.removeFirst();
                    unDiscountedProducts.remove(coffeeList.get(i));
                }
            } else {
                remaining.addAll(unDiscountedProducts);
                keepRunning = false;
            }
        }

        return new ReceiptInfo(fillings, deals, remaining);
    }

    public void clear() {
        products.clear();
        unDiscountedProducts.clear();
    }
}
