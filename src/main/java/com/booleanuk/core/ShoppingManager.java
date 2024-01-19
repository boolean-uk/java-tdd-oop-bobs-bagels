package com.booleanuk.core;

import com.migzus.terminal.menus.Button;
import com.migzus.terminal.menus.Callable;
import com.migzus.terminal.menus.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingManager {
    // this could technically be stored in a file and parsed when read... however, the task require no such feature
    public final static ArrayList<Item> availableItems = new ArrayList<>(){{
        add(new Item(0.49, "Onion", "BGLO", Category.BAGEL));
        add(new Item(0.39, "Plain", "BGLP", Category.BAGEL));
        add(new Item(0.49, "Everything", "BGLE", Category.BAGEL));
        add(new Item(0.49, "Sesame", "BGLS", Category.BAGEL));
        add(new Item(0.99, "Black", "COFB", Category.COFFEE));
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

    public final static ArrayList<Discount> discounts = new ArrayList<>(){{
        add(new NumberOfItemsDiscount(Category.BAGEL, 6, 2.44));
        add(new NumberOfItemsDiscount(Category.BAGEL, 12, 3.99));
        add(new ConditionalDiscount(new Category[]{ Category.COFFEE, Category.BAGEL }, 1.25));
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

    public void printReceipt() {
        System.out.println("Currently, in this version of Bobs Bagels. Checkout has yet to be implemented.");
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
        targetMenu.pushButton(new Button("Checkout", new Callable(this, "printReceipt")));
        targetMenu.pushButton(new Button("Return to Store", new Callable(targetMenu, "unfocus")));
    }

    public void printTotalPrice() {
        System.out.println(" - Total Price £" + String.format("%.2f", basket.calculateTotalPrice()) + " -");
    }

    public void changeBasketCapacity(int newCapacity) {
        basket.setCapacity(newCapacity);
    }

    public static Item getItem(String uuid) {
        for (Item item : availableItems)
            if (item.uuid.equals(uuid))
                return item;
        return null;
    }
}
