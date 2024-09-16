package com.booleanuk.core;

import com.migzus.terminal.menus.Button;
import com.migzus.terminal.menus.Callable;
import com.migzus.terminal.menus.Menu;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingManager {
    // this could technically be stored in a file and parsed when read... however, the task require no such feature
    public final static ArrayList<Item> availableItems = new ArrayList<>(){{
        add(new Item(0.49, "Onion", "BGLO", Category.BAGEL, new NumberOfItemsDiscount(6, 2.49)));
        add(new Item(0.39, "Plain", "BGLP", Category.BAGEL, new NumberOfItemsDiscount(12, 3.99)));
        add(new Item(0.49, "Everything", "BGLE", Category.BAGEL, new NumberOfItemsDiscount(6, 2.49)));
        add(new Item(0.49, "Sesame", "BGLS", Category.BAGEL, new NumberOfItemsDiscount(6, 2.49)));
        // for some reason Extension 1 includes one more type of discount, but doesn't apply it. So I'll leave this commented out
        add(new Item(0.99, "Black", "COFB", Category.COFFEE)); // , new ConditionalDiscount(new Category[]{ Category.BAGEL }, 1.25)
        add(new Item(1.19, "White", "COFW", Category.COFFEE));
        add(new Item(1.29, "Capuccino", "COFC", Category.COFFEE));
        add(new Item(1.29, "Latte", "COFL", Category.COFFEE));
        add(new Item(0.12, "Bacon", "FILB", Category.FILLING));
        add(new Item(0.12, "Egg", "FILE", Category.FILLING));
        add(new Item(0.12, "Cheese", "FILC", Category.FILLING));
        add(new Item(0.12, "Cream Cheese", "FILX", Category.FILLING));
        add(new Item(0.12, "Smoked Salmon", "FILS", Category.FILLING));
        add(new Item(0.12, "Ham", "FILH", Category.FILLING));
    }};

    public Basket basket = new Basket();

    public void changeBasketCapacityCallback() {
        System.out.println("Specify the new capacity for baskets:");
        Scanner _scanner = new Scanner(System.in);
        int _capacity = 0;

        try {
            _capacity = Integer.parseInt(_scanner.next());
        }
        catch (Exception e) {
            System.out.println("'" + _scanner.next() + "' is not a valid number! Only accepted inputs are whole numbers above 0.");
        }

        final int _originalCapacity = basket.getCapacity();

        if (basket.setCapacity(_capacity) == Error.OK)
            System.out.println("Successfully changed the basket capacity from " + _originalCapacity + " to " + _capacity);
        else
            System.out.println("'" + _capacity + "' is not a valid number! Only accepted inputs are whole numbers above 0.");
    }

    public void printBasket() {
        StringBuilder _sb = new StringBuilder();

        for (Order order : basket.getOrders()) {
            Item _item = getItem(order.itemUUID);
            if (_item == null) continue;

            _sb.append("\t(x").append(order.amount).append(")\t").append(_item.variant).append(" ").append(_item.category).append("\n");
        }

        System.out.println("\n--- Basket ---\n" + _sb + "--------------");
    }

    public void checkout() {
        if (basket.isEmpty()) {
            System.out.println("Your basket is empty. There is no reason to checkout.");
            return;
        }

        Menu.clearScreen();

        final Order[] orders = basket.getOrders();
        int _longestName = 0;

        for (Order order : orders) {
            Item _item = getItem(order.itemUUID);
            if (_item == null) continue;
            _longestName = Math.max(_longestName, _item.getFullName().length());
        }

        final int _receiptWidth = _longestName + 12;
        StringBuilder _stringInOrder = new StringBuilder();
        double _totalSavings = 0.0;

        for (Order order : orders) {
            Item _item = getItem(order.itemUUID);
            if (_item == null) continue;
            String _name = _item.getFullName();
            _stringInOrder.append(_item.getFullName()).append(" ".repeat(_longestName - _name.length())).append("   ").append(order.amount).append("   £").append(doubleToStringFormatter(getPriceCount(order.itemUUID, order.amount))).append("\n");

            if (_item.discount != null) {
                double _discount = _item.discount.applyDiscount(order, orders);

                if (!isZeroApprox(_discount)) { // this just checks if we did get a discount or not
                    _stringInOrder.append(" ".repeat(_receiptWidth - 7)).append("(-£").append(doubleToStringFormatter(_discount)).append(")\n");
                    _totalSavings += _discount;
                }
            }
        }

        String _receipt = centerText("~~~ Bob's Bagels ~~~", _receiptWidth) + "\n\n";

        _receipt += centerText(getDateTime(), _receiptWidth) + "\n\n";
        _receipt += "-".repeat(_receiptWidth) + "\n\n" + _stringInOrder + "\n" + "-".repeat(_receiptWidth) + "\n";
        _receipt += "Total" + " ".repeat(_receiptWidth - 9) + "£" + doubleToStringFormatter(basket.calculateTotalPriceWithDiscounts()) + "\n\n";

        if (!isZeroApprox(_totalSavings)) {
            _receipt += centerText("You saved a total of £" + doubleToStringFormatter(_totalSavings), _receiptWidth) + "\n";
            _receipt += centerText("on this shop", _receiptWidth) + "\n\n";
        }

        _receipt += centerText("Thank you", _receiptWidth) + "\n" + centerText("for your order!", _receiptWidth) + "\n";

        System.out.println(_receipt);

        basket.clearBasket();
    }

    public void populateMenu(Menu targetMenu) {
        if (targetMenu == null) return;

        targetMenu.clearButtons();

        for (Order order : basket.getOrders()) {
            Item _item = ShoppingManager.getItem(order. itemUUID);

            if (_item == null) continue;

            RemoveOrderButton _btn = new RemoveOrderButton("£" + _item.price + "\t(x" + order.amount + ")\t" + _item.variant + " " + _item.category);
            _btn.itemFullName = _item.variant + " " + _item.category;
            _btn.callable = new Callable(_btn, "removeOrder", order.itemUUID);
            _btn.targetBasketRemover = new Callable(basket, "removeCallback");
            _btn.onRefreshButtonList = new Callable(this, "populateMenu", targetMenu);

            targetMenu.pushButton(_btn);
        }

        targetMenu.pushWhitespace();
        targetMenu.pushButton(new Button("Checkout", new Callable(this, "checkout")));
        targetMenu.pushButton(new Button("Return to Store", new Callable(targetMenu, "unfocus")));
    }

    public void printTotalPrice() {
        System.out.println(" - Total Price (Without Discounts) £" + String.format("%.2f", basket.calculateTotalPrice()) + " -");
    }

    public void changeBasketCapacity(int newCapacity) {
        basket.setCapacity(newCapacity);
    }

    public static double getPriceCount(String uuid, int count) {
        Item _item = getItem(uuid);
        if (_item == null) return 0.0;
        return _item.price * count;
    }

    public static Item getItem(String uuid) {
        for (Item item : availableItems)
            if (item.uuid.equals(uuid))
                return item;
        return null;
    }

    public static String doubleToStringFormatter(double number) {
        return new DecimalFormat("0.00").format(number);
    }

    public static String getDateTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

    public static String centerText(String text, int length) {
        return centerText(text, length, " ");
    }

    public static String centerText(String text, int length, String paddingString) {
        return paddingString.repeat((length - text.length()) / 2) + text;
    }

    public static boolean isZeroApprox(double value) {
        return value < 0.000001 && value > -0.000001;
    }
}
