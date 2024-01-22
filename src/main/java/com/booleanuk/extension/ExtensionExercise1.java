package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.ArrayList;

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
            else if ((items.getSku().equals("COFB") && items.getSku().equals("BGLO")) ||
                    ((items.getSku().equals("COFB") && items.getSku().equals("BGLP")) ||
                    ((items.getSku().equals("COFB") && items.getSku().equals("BGLE"))))) {
                countCOFB++;
            }
        }


        double price = 0.0;

        if (countBGLO >= 6) {
            price += ( (countBGLO / 6) * 2.49);
        }
        if (countBGLP >= 12) {
            price += ( (countBGLP / 12) * 3.99);
        }
        if(countBGLE >= 6) {
            price += ( (countBGLE / 6) * 2.49);
        }
        if (countCOFB > 0 && (countBGLP > 0 || countBGLP > 0 || countBGLE > 0)) {
            price += ( (countCOFB / 1) + (countBGLO / 1) + (countBGLP / 1) + (countBGLE / 1) * 1.25);
        }
        System.out.println(price);
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
    }
}
