package com.booleanuk.core;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> itemsOnMenu;

    public Menu(){
        this.itemsOnMenu = new ArrayList<Item>();
    }

    public String seePrice(Item itemToCheck){
        return "Item dont exist on the menu!";
    }
}
