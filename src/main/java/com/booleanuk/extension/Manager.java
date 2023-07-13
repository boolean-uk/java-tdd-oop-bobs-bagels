package com.booleanuk.extension;

import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Manager {
    private int basketCapacity = 0;

    private static final List<Product> inventory = List.of(
            new Bagel("BGLO", 0.49, "Onion", Collections.emptyList()),
            new Bagel("BGLP", 0.39, "Plain", Collections.emptyList()),
            new Bagel("BGLE", 0.49, "Everything", Collections.emptyList()),
            new Bagel("BGLS", 0.49, "Sesame", Collections.emptyList()),
            new Coffee("COFB", 0.99, "Black"),
            new Coffee("COFW", 1.19, "White"),
            new Coffee("COFC", 1.29, "Cappuccino"),
            new Coffee("COFL", 1.29, "Latte"),
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILE", 0.12, "Egg"),
            new Filling("FILC", 0.12, "Cheese"),
            new Filling("FILX", 0.12, "Cream Cheese"),
            new Filling("FILS", 0.12, "Smoked Salmon"),
            new Filling("FILH", 0.12, "Ham")
    );

    public String applyDiscountsAndGenerateReceipt(Client client) {
        Basket basket = client.getBasket();
        int onionBagelsCount = basket.getBagelSKUCount("BGLO");
        int plainBagelsCount = basket.getBagelSKUCount("BGLP");
        int everythingBagelsCount = basket.getBagelSKUCount("BGLE");
        int blackCoffeeCount = basket.getCoffeesSKUCount("COFB");
        int fillingsCount = basket.getFillingCount();
        double onionBagelsPrice = (onionBagelsCount / 6) * 2.49 + (onionBagelsCount % 6) * 0.49;
        double plainBagelsPrice = (plainBagelsCount / 12) * 3.99 + (plainBagelsCount % 12) * 0.39;
        double everythingBagelsPrice = (everythingBagelsCount / 6) * 2.49 + (everythingBagelsCount % 6) * 0.49;
        double onionBagelsDiscount = onionBagelsCount * 0.49 - onionBagelsPrice;
        double plainBagelsDiscount = plainBagelsCount * 0.39 - plainBagelsPrice;
        double everythingBagelsDiscount = everythingBagelsCount * 0.49 - everythingBagelsPrice;
        int BagelsCount = onionBagelsCount + plainBagelsCount + everythingBagelsCount;
        int notDiscountedBagelsCount = BagelsCount - (onionBagelsCount / 6) * 6 -
                (plainBagelsCount / 12) * 12 - (everythingBagelsCount / 6) * 6;
        int coffeeBagelSets = Math.min(blackCoffeeCount, notDiscountedBagelsCount);
        double coffeeBagelSetsPrice = coffeeBagelSets * 0.8;
        double coffeeBagelSetsDiscount = coffeeBagelSets - coffeeBagelSetsPrice;
        double totalCost = onionBagelsPrice + plainBagelsPrice + everythingBagelsPrice +
                coffeeBagelSetsPrice + fillingsCount * 0.12;
        double sumDiscounts = onionBagelsDiscount + plainBagelsDiscount + everythingBagelsDiscount +
                coffeeBagelSetsDiscount;

        StringBuilder receipt = new StringBuilder();
        receipt.append("    ~~~ Bob's Bagels ~~~")
                .append(System.lineSeparator().repeat(2));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        receipt.append("    ")
                .append(dtf.format(now))
                .append(System.lineSeparator().repeat(2))
                .append("-".repeat(28))
                .append(System.lineSeparator());

        if (plainBagelsCount > 0) {
            receipt.append("Plain Bagel")
                    .append(" ".repeat(8))
                    .append(plainBagelsCount)
                    .append("\t£")
                    .append(String.format("%.2f", plainBagelsPrice))
                    .append(System.lineSeparator());
            if (plainBagelsDiscount > 0) {
                receipt.append("\t".repeat(5))
                        .append(" (-£")
                        .append(String.format("%.2f", plainBagelsDiscount))
                        .append(")").append(System.lineSeparator());
            }
        }

        if (onionBagelsCount > 0) {
            receipt.append("Onion Bagel")
                    .append(" ".repeat(8))
                    .append(onionBagelsCount)
                    .append("\t£")
                    .append(String.format("%.2f", onionBagelsPrice))
                    .append(System.lineSeparator());
            if (onionBagelsDiscount > 0) {
                receipt.append("\t".repeat(5)).append(" (-£")
                        .append(String.format("%.2f", onionBagelsDiscount))
                        .append(")")
                        .append(System.lineSeparator());
            }
        }

        if (everythingBagelsCount > 0) {
            receipt.append("Everything Bagel")
                    .append(" ".repeat(8))
                    .append(everythingBagelsCount)
                    .append("\t£")
                    .append(String.format("%.2f", everythingBagelsPrice))
                    .append(System.lineSeparator());
            if (everythingBagelsDiscount > 0) {
                receipt.append("\t".repeat(5)).append(" (-£")
                        .append(String.format("%.2f", everythingBagelsDiscount))
                        .append(")")
                        .append(System.lineSeparator());
            }
        }

        if (coffeeBagelSets > 0) {
            receipt.append("Coffee Bagel Set")
                    .append(" ".repeat(8))
                    .append(coffeeBagelSets)
                    .append("\t£")
                    .append(String.format("%.2f", coffeeBagelSetsPrice))
                    .append(System.lineSeparator());
            if (coffeeBagelSetsDiscount > 0) {
                receipt.append("\t".repeat(5))
                        .append(" (-£")
                        .append(String.format("%.2f", coffeeBagelSetsDiscount))
                        .append(")")
                        .append(System.lineSeparator());
            }
        }

        if (fillingsCount > 0) {
            receipt.append("Filling")
                    .append(" ".repeat(12))
                    .append(fillingsCount)
                    .append("\t£")
                    .append(String.format("%.2f", 0.12 * fillingsCount))
                    .append(System.lineSeparator());
        }

        receipt.append(System.lineSeparator())
                .append("-".repeat(28))
                .append(System.lineSeparator().repeat(2))
                .append("Total: ")
                .append("\t\t\t\t\t£")
                .append(String.format("%.2f", totalCost))
                .append(System.lineSeparator().repeat(2))
                .append("You saved a total of ")
                .append("£").append(String.format("%.2f", sumDiscounts))
                .append("\n")
                .append("    on this shop")
                .append(System.lineSeparator().repeat(2))
                .append("        Thank you\n")
                .append("      for your order!");

        return receipt.toString();
    }

    public Manager(int basketCapacity) {
        changeBasketsCapacity(basketCapacity);
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public static List<Product> getInventory(){
        return new ArrayList<>(inventory);
    }

    public void changeBasketsCapacity(int newCapacity) {
        if (newCapacity < basketCapacity) {
            throw new IllegalArgumentException("New capacity can't be less than current capacity!");
        }
        setBasketCapacity(newCapacity);
    }

    private void setBasketCapacity(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        Basket.setCapacity(basketCapacity);
    }

    public static Coffee getCoffeeByVariant(String variant) {
        for (Product product : inventory) {
            if(product instanceof Coffee && product.getVariant().equals(variant)){
                return ((Coffee) product).clone();
            }
        }
        throw new IllegalArgumentException("Coffee with variant " + variant + " is not in the inventory!");
    }

    public static Bagel getBagelByVariant(String variant) {
        variant = variant.toLowerCase();
        for (Product product : inventory) {
            if(product instanceof Bagel && product.getVariant().toLowerCase().equals(variant)){
                return ((Bagel) product).clone();
            }
        }
        throw new IllegalArgumentException("Bagel with variant " + variant + " is not in the inventory!");
    }

    public static Filling getFillingByVariant(String variant) {
        variant = variant.toLowerCase();
        for (Product product : inventory) {
            if(product instanceof Filling && product.getVariant().toLowerCase().equals(variant)){
                return ((Filling) product).clone();
            }
        }
        throw new IllegalArgumentException("Filling with variant " + variant + " is not in the inventory!");
    }

    public static List<Filling> getFillingsByVariants(List<String> variants) {
        List<Filling> fillings = new ArrayList<>();
        for (String variant : variants) {
            fillings.add(getFillingByVariant(variant));
        }
        return fillings;
    }

    public static void prettyPrintAllBagels() {
        System.out.println("All bagels in my inventory: ");

        List<Bagel> bagels = getInventory().stream()
                .filter(product -> product instanceof Bagel)
                .map(product -> (Bagel) product)
                .sorted(Comparator.comparing(Bagel::getPrice))
                .toList();

        bagels.forEach(bagel -> System.out.println(
                bagel.getVariant() + " - " + bagel.getPrice()));
    }

    public static void prettyPrintAllFillings() {
        List<Filling> fillings = getInventory().stream()
                .filter(product -> product instanceof Filling)
                .map(product -> (Filling) product)
                .sorted(Comparator.comparing(Filling::getPrice))
                .toList();

        fillings.forEach(filling -> System.out.println(
                filling.getVariant() + " - " + filling.getPrice()));
    }

}
