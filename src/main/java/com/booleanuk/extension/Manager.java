package com.booleanuk.extension;

import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Manager {
    private int basketCapacity = 0;
    private final int lineLength = 28;
    private final int countIndex = 19;
    private final int priceIndex = 23;

    private final double ONION_BAGEL_PRICE = 0.49;
    private final double PLAIN_BAGEL_PRICE = 0.39;
    private final double EVERYTHING_BAGEL_PRICE = 0.49;
    private final double FILLING_PRICE = 0.12;
    private final int ONION_BAGEL_DISCOUNT = 6;
    private final int PLAIN_BAGEL_DISCOUNT = 12;
    private final int EVERYTHING_BAGEL_DISCOUNT = 6;
    private final double ONION_BAGEL_DISCOUNT_PRICE = 2.49;
    private final double PLAIN_BAGEL_DISCOUNT_PRICE = 3.99;
    private final double EVERYTHING_BAGEL_DISCOUNT_PRICE = 2.49;

    private final double COFFEE_BAGEL_PRICE_WITHOUT_BAGEL = 0.8;


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

    private void beginTheReceipt(StringBuilder receipt){
        receipt.append("    ~~~ Bob's Bagels ~~~")
                .append(System.lineSeparator().repeat(2));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        receipt.append("    ")
                .append(dtf.format(now))
                .append(System.lineSeparator().repeat(2))
                .append("-".repeat(lineLength))
                .append(System.lineSeparator().repeat(2));
    }

    private void endTheReceipt(StringBuilder receipt, double totalCost, double sumDiscounts){
        receipt.append(System.lineSeparator())
                .append("-".repeat(lineLength))
                .append(System.lineSeparator().repeat(2))
                .append("Total:")
                .append("\t\t\t\t   £")
                .append(String.format("%.2f", totalCost))
                .append(System.lineSeparator().repeat(2))
                .append(" You saved a total of ")
                .append("£").append(String.format("%.2f", sumDiscounts))
                .append("\n")
                .append("      on this shop")
                .append(System.lineSeparator().repeat(2))
                .append("        Thank you\n")
                .append("      for your order!");
    }

    private void appendProductToReceipt(StringBuilder receipt, String name,
                                        int count, double price, double discount){
        receipt.append(name)
                .append(" ".repeat(countIndex - name.length()))
                .append(count)
                .append(" ".repeat(4 - String.valueOf(count).length()))
                .append("£")
                .append(String.format("%.2f", price))
                .append(System.lineSeparator());
        if (discount > 0) {
            receipt.append(" ".repeat(21)).append("(-£")
                    .append(String.format("%.2f", discount))
                    .append(")")
                    .append(System.lineSeparator());
        }
    }

    private void appendFillingsToReceipt(StringBuilder receipt, int fillingsCount){
        receipt.append("Filling")
                .append(" ".repeat(countIndex - "Filling".length()))
                .append(fillingsCount)
                .append(" ".repeat(4 - String.valueOf(fillingsCount).length()))
                .append("£")
                .append(String.format("%.2f", fillingsCount * FILLING_PRICE))
                .append(System.lineSeparator());
    }

    private double calculateOnionBagelsPrice(int onionBagelsCount) {
        return (onionBagelsCount / ONION_BAGEL_DISCOUNT) * ONION_BAGEL_DISCOUNT_PRICE +
                (onionBagelsCount % ONION_BAGEL_DISCOUNT) * ONION_BAGEL_PRICE;
    }

    private double calculateOnionBagelsDiscount(int onionBagelsCount,
                                                double onionBagelsPrice) {
        return onionBagelsCount * ONION_BAGEL_PRICE - onionBagelsPrice;
    }


    private double calculatePlainBagelsPrice(int plainBagelsCount) {
        return (plainBagelsCount / PLAIN_BAGEL_DISCOUNT) * PLAIN_BAGEL_DISCOUNT_PRICE +
                (plainBagelsCount % PLAIN_BAGEL_DISCOUNT) * PLAIN_BAGEL_PRICE;
    }

    private double calculatePlainBagelsDiscount(int plainBagelsCount,
                                                double plainBagelsPrice) {
        return plainBagelsCount * PLAIN_BAGEL_PRICE - plainBagelsPrice;
    }

    private double calculateEverythingBagelsPrice(int everythingBagelsCount) {
        return (everythingBagelsCount / EVERYTHING_BAGEL_DISCOUNT) * EVERYTHING_BAGEL_DISCOUNT_PRICE +
                (everythingBagelsCount % EVERYTHING_BAGEL_DISCOUNT) * EVERYTHING_BAGEL_PRICE;
    }

    private double calculateEverythingBagelsDiscount(int everythingBagelsCount,
                                                     double everythingBagelsPrice) {
        return everythingBagelsCount * EVERYTHING_BAGEL_PRICE - everythingBagelsPrice;
    }

    private int calculateCoffeeBagelSets(int blackCoffeeCount,
                                         int notDiscountedBagelsCount) {
        return Math.min(blackCoffeeCount, notDiscountedBagelsCount);
    }

    private double calculateCoffeeBagelSetsPrice(double coffeeBagelSets) {
        return coffeeBagelSets * COFFEE_BAGEL_PRICE_WITHOUT_BAGEL;
    }

    private double calculateCoffeeBagelSetsDiscount(double coffeeBagelSets,
                                                    double coffeeBagelSetsPrice){
        return coffeeBagelSets - coffeeBagelSetsPrice;
    }

    private double calculateTotalCost(double onionBagelsPrice,
                                      double plainBagelsPrice,
                                      double everythingBagelsPrice,
                                      double coffeeBagelSetsPrice,
                                      double fillingsCount) {
        return onionBagelsPrice + plainBagelsPrice + everythingBagelsPrice +
                coffeeBagelSetsPrice + fillingsCount * FILLING_PRICE;
    }

    private double sumDiscounts(double onionBagelsDiscount,
                                double plainBagelsDiscount,
                                double everythingBagelsDiscount,
                                double coffeeBagelSetsDiscount) {
        return onionBagelsDiscount +  plainBagelsDiscount +
                everythingBagelsDiscount + coffeeBagelSetsDiscount;
    }

    private int calculateNotDiscountedBagels(int BagelsCount,
                                             int onionBagelsCount,
                                             int plainBagelsCount,
                                             int everythingBagelsCount) {
        return BagelsCount - (onionBagelsCount / 6) * 6 -
                (plainBagelsCount / 12) * 12 - (everythingBagelsCount / 6) * 6;
    }

    public String applyDiscountsAndGenerateReceipt(Client client) {
        Basket basket = client.getBasket();
        int onionBagelsCount = basket.getBagelSKUCount("BGLO");
        int plainBagelsCount = basket.getBagelSKUCount("BGLP");
        int everythingBagelsCount = basket.getBagelSKUCount("BGLE");
        int blackCoffeeCount = basket.getCoffeesSKUCount("COFB");
        int fillingsCount = basket.getFillingCount();
        double onionBagelsPrice = calculateOnionBagelsPrice(onionBagelsCount);
        double plainBagelsPrice = calculatePlainBagelsPrice(plainBagelsCount);
        double everythingBagelsPrice = calculateEverythingBagelsPrice(everythingBagelsCount);
        double onionBagelsDiscount = calculateOnionBagelsDiscount(onionBagelsCount, onionBagelsPrice);
        double plainBagelsDiscount = calculatePlainBagelsDiscount(plainBagelsCount, plainBagelsPrice);
        double everythingBagelsDiscount = calculateEverythingBagelsDiscount
                (everythingBagelsCount, everythingBagelsPrice);
        int BagelsCount = onionBagelsCount + plainBagelsCount + everythingBagelsCount;
        int notDiscountedBagelsCount = calculateNotDiscountedBagels
                (BagelsCount, onionBagelsCount, plainBagelsCount, everythingBagelsCount);
        int coffeeBagelSets = calculateCoffeeBagelSets(blackCoffeeCount, notDiscountedBagelsCount);
        double coffeeBagelSetsPrice = calculateCoffeeBagelSetsPrice(coffeeBagelSets);
        double coffeeBagelSetsDiscount = calculateCoffeeBagelSetsDiscount(coffeeBagelSets, coffeeBagelSetsPrice);
        double totalCost = calculateTotalCost(onionBagelsPrice, plainBagelsPrice, everythingBagelsPrice,
                coffeeBagelSetsPrice, fillingsCount);
        double discountsSummed = sumDiscounts
                (onionBagelsDiscount, plainBagelsDiscount,
                        everythingBagelsDiscount, coffeeBagelSetsDiscount);


        StringBuilder receipt = new StringBuilder();

        beginTheReceipt(receipt);

        if (onionBagelsCount > 0) {
            appendProductToReceipt(receipt, "Onion Bagel", onionBagelsCount,
                    onionBagelsPrice, onionBagelsDiscount);
        }

        if (plainBagelsCount > 0) {
            appendProductToReceipt(receipt, "Plain Bagel", plainBagelsCount,
                    plainBagelsPrice, plainBagelsDiscount);
        }


        if (everythingBagelsCount > 0) {
            appendProductToReceipt(receipt, "Everything Bagel", everythingBagelsCount,
                    everythingBagelsPrice, everythingBagelsDiscount);
        }

        if (coffeeBagelSets > 0) {
            appendProductToReceipt(receipt, "Coffee & Bagel Set", coffeeBagelSets,
                    coffeeBagelSetsPrice, coffeeBagelSetsDiscount);
        }

        if (fillingsCount > 0) {
            appendFillingsToReceipt(receipt, fillingsCount);
        }

        endTheReceipt(receipt, totalCost, discountsSummed);

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
