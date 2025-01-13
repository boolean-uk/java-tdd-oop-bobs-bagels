package com.booleanuk.core;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> itemsOnMenu;

    public Menu(ArrayList<Item> itemsOnMenu){
        this.itemsOnMenu = itemsOnMenu;
    }

    public String seePrice(Item itemToCheck){
        for(Item anItem : itemsOnMenu){
            if(anItem.getName().equals(itemToCheck.getName())){
                return "The item costs: " + itemToCheck.getPrice();
            }
        }

        return "Item dont exist on the menu!";
    }
}
