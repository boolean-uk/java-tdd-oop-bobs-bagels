package com.booleanuk.core;

import java.util.*;

public class Controller {
    private final View view;
    private static final HashMap<String, Triple<String, String, Float>> privatePrices = new HashMap<>() {{
        put("BGLO", new Triple<>("Bagel", "Onion", 0.49f));
        put("BGLP", new Triple<>("Bagel", "Plain", 0.39f));
        put("BGLE", new Triple<>("Bagel", "Everything", 0.49f));
        put("BGLS", new Triple<>("Bagel", "Sesame", 0.49f));
        put("FILB", new Triple<>("Filling", "Bacon", 0.12f));
        put("FILE", new Triple<>("Filling", "Egg", 0.12f));
        put("FILC", new Triple<>("Filling", "Cheese", 0.12f));
        put("FILX", new Triple<>("Filling", "Cream Cheese", 0.12f));
        put("FILS", new Triple<>("Filling", "Smoked Salmon", 0.12f));
        put("FILH", new Triple<>("Filling", "Ham", 0.12f));
        put("COFB", new Triple<>("Coffee", "Black", 0.99f));
        put("COFW", new Triple<>("Coffee", "White", 1.19f));
        put("COFC", new Triple<>("Coffee", "Cappuccino", 1.29f));
        put("COFL", new Triple<>("Coffee", "Latte", 1.29f));
    }};
    public static final Map<String, Triple<String, String, Float>> prices = Collections.unmodifiableMap(privatePrices);
    private Basket basket;
    private int basketSize;

    public Controller(View view, Basket basket, int basketSize) {
        this.view = view;
        this.basket = basket;
        this.basketSize = basketSize;
    }

    public static void main(String[] args) {
        int bSize = 50;
        Controller controller = new Controller(new View(), new Basket(bSize), bSize);

        for (int i = 0; i < 14; i++) {
            ArrayList<Triple<String, String, Float>> fillings = new ArrayList<>() {{
                add(Controller.prices.get("FILE"));
                add(Controller.prices.get("FILH"));
            }};
            controller.basket.addProduct(new Bagel(Controller.prices.get("BGLE"), fillings));
            controller.basket.addProduct(new Bagel(Controller.prices.get("BGLP"), fillings));
        }
        controller.view.printReceipt(controller.basket.calculateCost(), controller.basket.findDiscount(), controller.basket.receiptInformation());

//        controller.start();
    }

    private void start() {
        boolean keepRunning = true;
        while(keepRunning) {
            int chosenOption = view.mainMenu();
            switch (chosenOption) {
                case 1:
                    if (basket.size() < basketSize) {
                        Bagel b = view.addBagel();
                        if (b != null) {
                            basket.addProduct(b);
                        }
                    } else {
                        view.basketFull();
                    }
                    break;
                case 2:
                    if(basket.size() > 0) {
                        basket.removeProduct(view.chooseBagel(basket.getProducts()));
                    } else {
                        view.emptyBasket();
                    }
                    break;
                case 3:
                    basket.setBasketSize(view.getNewBasketSize());
                    break;
                case 4:
                    view.printPrice(basket.calculateCost());
                    break;
                case 5:
                    if (basket.size() < basketSize) {
                        Coffee c = view.addCoffee();
                        if (c != null) {
                            basket.addProduct(c);
                        }
                    } else {
                        view.basketFull();
                    }
                    break;
                case 6:
//                    view.printReceipt(basket.receiptInformation());
                    basket.clear();
                case 12: // Testing case
                    basket.addProduct(new Coffee(Controller.prices.get("COFB")));
                    basket.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
                    for (int i = 0; i < 18; i++) {
                        basket.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
                    }
                    break;
                default:
                    keepRunning = false;
                    view.printExit();
                    break;
            }
        }
    }
}
