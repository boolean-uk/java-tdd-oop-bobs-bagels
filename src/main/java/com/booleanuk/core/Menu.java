package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Menu {

    private ArrayList<Item> currentMenu;

    public Menu(){
        currentMenu = new ArrayList<>();
        fillMenu();
    }

    public Boolean isInMenu(Item item){
        for(Item i : currentMenu){
            if(Objects.equals(i.name, item.name)){
                return true;
            }
        }
        return false;
    }

    public Boolean isInMenu(String name){
        for(Item i : currentMenu){
            if(Objects.equals(i.name, name)){
                return true;
            }
        }
        return false;
    }

    private void fillMenu(){

        Item onionBagel = new OnionBagel();
        currentMenu.add(onionBagel);
        Item plainBagel = new PlainBagel();
        currentMenu.add(plainBagel);
        Item everythingBagel = new EverythingBagel();
        currentMenu.add(everythingBagel);
        Item sesameBagel = new SesameBagel();
        currentMenu.add(sesameBagel);
        Item blackCoffee = new BlackCoffee();
        currentMenu.add(blackCoffee);
        Item whiteCoffee = new WhiteCoffee();
        currentMenu.add(whiteCoffee);
        Item cappuccino = new CappuccinoCoffee();
        currentMenu.add(cappuccino);
        Item latte = new LatteCoffee();
        currentMenu.add(latte);
        Item bacon = new BaconFilling();
        currentMenu.add(bacon);
        Item egg = new EggFilling();
        currentMenu.add(egg);
        Item cheese = new CheeseFilling();
        currentMenu.add(cheese);
        Item creamCheese = new CreamCheeseFilling();
        currentMenu.add(creamCheese);
        Item smokedSalmon = new SmokedSalmonFilling();
        currentMenu.add(smokedSalmon);
        Item ham = new HamFilling();
        currentMenu.add(ham);


    }
}
