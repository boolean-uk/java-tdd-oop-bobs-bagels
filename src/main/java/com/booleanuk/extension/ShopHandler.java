package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShopHandler {
    private static final List<Item> stock = new ArrayList<>(Arrays.asList(
            new Bagel("BGLO", 0.49, "Bagel", "Onion"),
            new Bagel("BGLP", 0.39, "Bagel", "Plain"),
            new Bagel("BGLE", 0.49, "Bagel", "Everything"),
            new Bagel("BGLS", 0.49, "Bagel", "Sesame"),
            new Coffee("COFB", 0.99, "Coffee", "Black"),
            new Coffee("COFW", 1.19, "Coffee", "White"),
            new Coffee("COFC", 1.29, "Coffee", "Cappuccino"),
            new Coffee("COFL", 1.29, "Coffee", "Latte"),
            new Item("FILB", 0.12, "Filling", "Bacon"),
            new Item("FILE", 0.12, "Filling", "Egg"),
            new Item("FILC", 0.12, "Filling", "Cheese"),
            new Item("FILX", 0.12, "Filling", "Cream Cheese"),
            new Item("FILS", 0.12, "Filling", "Smoked Salmon"),
            new Item("FILH", 0.12, "Filling", "Ham")
    ));

    private static final double SIX_BAGEL_DISCOUNT = 2.49;
    private static final double DOZEN_BAGEL_DISCOUNT = 3.99;
    private static final double COFFEE_DISCOUNT = 1.25;
    private Scanner scanner;
    private Basket basket;

    public ShopHandler(Scanner in) {
        this.scanner = in;
        this.basket = new Basket();
    }

    public ShopHandler() {
        this(new Scanner(System.in));
    }

    public void placeOrder() {
        while (true) {
            String in;
            do {
                System.out.println("bagel/coffee/remove/pay");
                in = scanner.next();
            } while (!"bagel coffee remove pay".contains(in));
            switch (in) {
                case "bagel":
                    orderBagel();
                    break;
                case "coffee":
                    orderCoffee();
                    break;
                case "remove":
                    removeItem();
                    break;
                case "pay":
                    System.out.println("Print receipt tbd. total cost " + basket.getTotalCost() + " - " + calculateDiscounts() + " = " + (basket.getTotalCost() - calculateDiscounts()));
                    return;
            }
        }
    }

    public double calculateDiscounts() {
        double totalDiscount = 0;
        for (Item item : basket.getItems()) {
            if (item.getName().equals("Coffee")) {
                Coffee coffee = (Coffee) item;  // not nice!
                if (coffee.getDiscountBagel() != null)
                    totalDiscount += coffee.getPrice() - COFFEE_DISCOUNT;
            }
        }
        for (Item item : stock) {
            if (item.getName().equals("Bagel")) {
                String sku = item.getSku();
                int n = basket.getItems().stream().filter(i -> i.getSku().equals(sku)).toList().size();
                double discount = ((int) (n/12)) * item.getPrice() * 12  - ((int) n/12) * DOZEN_BAGEL_DISCOUNT;
                int bagelsLeft = n % 12;
                discount += ((int) (bagelsLeft/6)) * item.getPrice() * 6  - ((int) bagelsLeft/6) * SIX_BAGEL_DISCOUNT;
                totalDiscount += discount;
            }
        }
        return totalDiscount;
    }

    public String showReceiptWithDiscounts() {
        double totalDiscount = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("Bob's Bagels\n--------\n");

        // Recursively collect all fillings
        List<Item> fillings = new ArrayList<>();
        for (Item item : basket.getItems()) {
            if (item.getName().equals("Coffee")) {
                Bagel b = ((Coffee) item).getDiscountBagel();
                if (b != null) {
                    Item f = b.getFilling();
                    if (f != null) {
                        fillings.add(f);
                    }
                }
            } else if (item.getName().equals("Bagel")) {
                Item f = ((Bagel) item).getFilling();
                if (f != null) {
                    fillings.add(f);
                }
            }
        }

        for (Item item : stock) {
            String sku = item.getSku();

            if (item.getName().equals("Filling")) {
                int n = fillings.stream().filter(i -> i.getSku().equals(sku)).toList().size();
                if (n > 0) {
                    sb.append(n).append(" ").append(item.getName()).append(" ").append(item.getVariant()).append(" ").append(String.format("%.2f", item.getPrice() * n)).append("\n");
                }
            }

            if (item.getName().equals("Coffee")) {
                double discount = 0;
                double price = 0;
                List<Item> coffees = basket.getItems().stream().filter(i -> i.getSku().equals(sku)).toList();
                for (Item coffee : coffees) {  // not nice!
                    if (((Coffee) coffee).getDiscountBagel() != null) {
                        discount += coffee.getPrice() - COFFEE_DISCOUNT;
                        price += COFFEE_DISCOUNT;
                        totalDiscount += discount;
                    } else {
                        price += coffee.getPrice();
                    }
                }
                if (!coffees.isEmpty()) {
                    sb.append(coffees.size()).append(" ").append(item.getName()).append(" ").append(item.getVariant()).append(" ").append(String.format("%.2f", price)).append("\n");
                    if (discount > 0) {
                        sb.append("(-").append(String.format("%.2f", discount)).append(")").append("\n");
                    }
                }
            } else if (item.getName().equals("Bagel")) {
                int n = basket.getItems().stream().filter(i -> i.getSku().equals(sku)).toList().size();
                double discount = ((int) (n/12)) * item.getPrice() * 12  - ((int) n/12) * DOZEN_BAGEL_DISCOUNT;
                int bagelsLeft = n % 12;
                discount += ((int) (bagelsLeft/6)) * item.getPrice() * 6  - ((int) bagelsLeft/6) * SIX_BAGEL_DISCOUNT;
                totalDiscount += discount;
                if (n > 0) {
                    sb.append(n).append(" ").append(item.getName()).append(" ").append(item.getVariant()).append(" ").append(String.format("%.2f", item.getPrice() * n - discount)).append("\n");
                    if (discount > 0) {
                        sb.append("(-").append(String.format("%.2f", discount)).append(")").append("\n");
                    }
                }
            }
        }
        sb.append("--------\n")
                .append("Total: ").append(String.format("%.2f", getCostAfterDiscounts()))
                .append("\nSavings: ").append(String.format("%.2f", getCostBeforeDiscounts() - getCostAfterDiscounts()));

        return sb.toString();
    }

    public void removeItem() {
        if (basket.getItems().isEmpty()) {
            System.out.println("No items in basket.");
            return;
        }
        System.out.println("Enter number of item to remove (0 to cancel):");
        System.out.println(showBasket());
        int in;
        do {
            in = scanner.nextInt();
        } while (in < 0 || in > basket.getItems().size());
        if (in == 0) return;
        basket.removeItem(basket.getItems().get(in-1).getSku());
    }

    public String showBasket() {
        StringBuilder sb = new StringBuilder();
        for (Item item : basket.getItems()) {
            sb.append(item.getName()).append(", ").append(item.getVariant()).append(", ").append(item.getPrice()).append("\n");
        }
        return sb.toString();
    }

    public String showItems() {
        // Maybe this method isn't useful, may remove
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (!item.getName().equals("Filling")) {
                sb.append(item.getName()).append("\t").append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public String showFillings() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (item.getName().equals("Filling")) {
                sb.append(item.getVariant()).append(" (").append(item.getPrice()).append(")").append("\n");
            }
        }
        return sb.toString();
    }

    public String showBagels() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (item.getName().equals("Bagel")) {
                sb.append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public String showCoffees() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (item.getName().equals("Coffee")) {
                sb.append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public void orderBagel() {
        Bagel b = selectBagel();
        if (basket.addItem(b)) {
            System.out.println("Bagel added to basket.");
        } else {
            System.out.println("Not able to add bagel to basket.");
        }
    }

    public boolean orderBagel(String variant, String filling) {
        if (!isValidFilling(filling) || !isValidBagel(variant)) {
            return false;
        }
        Bagel bagel = bagelFromVariant(variant);
        bagel.setFilling(fillingFromVariant(filling));
        return basket.addItem(bagel);
    }

    public boolean orderBagel(String variant) {
        if (!isValidBagel(variant)) {
            return false;
        }
        return basket.addItem(bagelFromVariant(variant));
    }

    public Bagel selectBagel() {
        System.out.println("Select bagel variant:");
        System.out.println(showBagels());
        String in;
        do {
            in = this.scanner.next();
        } while (!isValidBagel(in));
        Bagel bagel = bagelFromVariant(in);
        System.out.println("Add filling ([filling], no)? Available fillings:");
        System.out.println(showFillings());
        do {
            in = this.scanner.next();
        } while(!isValidFilling(in) && !in.equals("no"));
        if (!in.equals("no")) {
            bagel.setFilling(fillingFromVariant(in));
        }
        return bagel;
    }

    public void orderCoffee() {
        System.out.println("Select coffee variant:");
        System.out.println(showCoffees());
        String in;
        do {
            in = this.scanner.next();
        } while (!isValidCoffee(in));
        Coffee coffee = coffeeFromVariant(in);
        System.out.println("Add bagel for a discount?");
        do {
            in = this.scanner.next();
        } while (!"yes no".contains(in));

        if (in.equals("yes")) {
            Bagel b = selectBagel();
            coffee.setDiscountBagel(b);
        }

        boolean success = basket.addItem(coffee);
        if (success) {
            System.out.println("Coffee added to basket.");
        } else {
            System.out.println("Not able to add coffee to basket.");
        }
    }

    public boolean orderCoffee(String variant) {
        if (!isValidCoffee(variant)) {
            return false;
        }
        return basket.addItem(coffeeFromVariant(variant));
    }

    public boolean orderCoffee(String coffeeVariant, String bagelVariant, String fillingVariant) {
        if (!isValidCoffee(coffeeVariant) || !isValidBagel(bagelVariant) || !isValidFilling(fillingVariant)) {
            return false;
        }
        Coffee coffee = coffeeFromVariant(coffeeVariant);
        Bagel bagel = bagelFromVariant(bagelVariant);
        bagel.setFilling(fillingFromVariant(fillingVariant));
        coffee.setDiscountBagel(bagel);
        return basket.addItem(coffee);
    }

    public boolean orderCoffee(String coffeeVariant, String bagelVariant) {
        if (!isValidCoffee(coffeeVariant) || !isValidBagel(bagelVariant)) {
            return false;
        }
        Coffee coffee = coffeeFromVariant(coffeeVariant);
        Bagel bagel = bagelFromVariant(bagelVariant);
        coffee.setDiscountBagel(bagel);
        return basket.addItem(coffee);
    }

    private Bagel bagelFromVariant(String variant) {
        for (Item item : stock) {
            if (item.getVariant().equals(variant)) {
                return new Bagel(item.getSku(), item.getPrice(), item.getName(), item.getVariant());
            }
        }
        return null;
    }

    private Coffee coffeeFromVariant(String variant) {
        for (Item item : stock) {
            if (item.getVariant().equals(variant)) {
                return new Coffee(item.getSku(), item.getPrice(), item.getName(), item.getVariant());
            }
        }
        return null;
    }

    private Item fillingFromVariant(String variant) {
        for (Item item : stock) {
            if (item.getVariant().equals(variant)) {
                return new Item(item.getSku(), item.getPrice(), item.getName(), item.getVariant());
            }
        }
        return null;
    }

    private static boolean isValidBagel(String variant) {
        for (Item item: stock) {
            if (item.getName().equals("Bagel") && item.getVariant().equals(variant)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidCoffee(String variant) {
        for (Item item: stock) {
            if (item.getName().equals("Coffee") && item.getVariant().equals(variant)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidFilling(String variant) {
        for (Item item: stock) {
            if (item.getName().equals("Filling") && item.getVariant().equals(variant)) {
                return true;
            }
        }
        return false;
    }

    public static List<Item> getStock() {
        return stock;
    }

    public double getCostBeforeDiscounts() {
        return basket.getTotalCost();
    }

    public double getCostAfterDiscounts() {
        return basket.getTotalCost() - calculateDiscounts();
    }
}
