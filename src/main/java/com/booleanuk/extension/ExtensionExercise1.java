package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtensionExercise1 {

    private ArrayList<Inventory> basketList;
    private ArrayList<Inventory> inventoryList;

    public ExtensionExercise1() {
        basketList = new ArrayList<>();
        inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        inventoryList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        inventoryList.add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        inventoryList.add(new Inventory("COFB", 0.99, "Coffee", "Black"));
    }

    public double returnItemsWithDiscount() {

        int countBGLO = 0;
        int countBGLP = 0;
        int countBGLE = 0;
        int countCOFB = 0;

        for (Inventory items : basketList) {
            if (items.getSku().equals("BGLO")) {
                countBGLO++;
            }
            else if (items.getSku().equals("BGLP")) {
                countBGLP++;
            }
            else if (items.getSku().equals("BGLE")) {
                countBGLE++;
            }
            else if (items.getSku().equals("COFB")) {
                countCOFB++;
            }
        }


        double price = 0.0;

        //Onion bagels pricing
        if (countBGLO >= 6) {
            price += ( (countBGLO / 6) * 2.49);
            //Divide by the bulk amount (6) to account for more than 1 discount
            // offer (in the case where there is multiples of 6 onion bagels being
            // bought, e.g. 12 onion bagels should make the discount price be
            // applied twice)


        }
        else if(countBGLO % 6 != 0) {
            price += countBGLO * 0.49;
        }

        //Plain bagels pricing
        if (countBGLP >= 12) {
            price += ( (countBGLP / 12) * 3.99);

        }
        else if(countBGLP % 12 != 0) {
            price += countBGLP * 0.39;
        }

        // Everything bagels pricing
        if(countBGLE >= 6) {
            price += ( (countBGLE / 6) * 2.49);

        }
        else if(countBGLE % 6 != 0) {
            price += countBGLE * 0.49;
        }

        //Black coffees pricing
        if (countCOFB > 0) {
            int countCombos = Math.min(countCOFB, countBGLE + countBGLO + countBGLP);
            price += countCombos * 1.25;
            int remainingCoffees = countCOFB - countCombos;
            price += remainingCoffees * 0.99;
        }

        return price;
    }

    public ArrayList<Inventory> getBasketList() {
        return basketList;
    }

    public void setBasketList(ArrayList<Inventory> basketList) {
        this.basketList = basketList;
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public static void main(String[] args) {
        ExtensionExercise1 extensionExercise1 = new ExtensionExercise1();
        extensionExercise1.returnItemsWithDiscount();
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.basketList.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        System.out.println(List.of(extensionExercise1.basketList));
        System.out.println(extensionExercise1.returnItemsWithDiscount());

    }
}
