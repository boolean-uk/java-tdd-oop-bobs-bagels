package com.booleanuk.core;

import com.migzus.terminal.menus.Callable;
import com.migzus.terminal.menus.Menu;
import com.migzus.terminal.menus.Button;

public class Main {
    public static void main(String[] args) {
        Menu _buyItems = new Menu("Order Menu");

        ShoppingManager _sm = new ShoppingManager();

        for (Item item : ShoppingManager.availableItems) {
            OrderButton _orderButton = new OrderButton(item.variant + " " + item.category);
            _orderButton.callable = new Callable(_orderButton, "makeOrder", item.uuid);
            _orderButton.targetBasketAdder = new Callable(_sm.basket, "addCallback");
            _buyItems.pushButton(_orderButton);
        }

        //_buyItems.pushButton(new Button("See Basket", new Callable(null, "focus")));
        _buyItems.pushButton(new Button("Cancel Order", new Callable(_buyItems, "unfocus")));

        Menu _owner = new Menu("Welcome Bob");

        _owner.pushButton(new Button("Adjust basket capacity", new Callable(_sm, "changeBasketCapacityCallback")));

        Menu _mainMenu = new Menu("Login Menu");

        _mainMenu.pushButton(new Button("As a Customer", new Callable(_buyItems, "focus")));
        _mainMenu.pushButton(new Button("As the Owner", new Callable(_owner, "focus")));
        _mainMenu.pushButton(new Button("Quit", new Callable(_mainMenu, "unfocus")));

        _mainMenu.focus();
    }
}
