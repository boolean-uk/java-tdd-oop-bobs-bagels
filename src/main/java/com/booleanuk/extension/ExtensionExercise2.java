package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;

import java.text.SimpleDateFormat;
import java.util.*;

public class ExtensionExercise2 {

    //quantity, price, total

    //format:
    /*
        ~~~ Bob's Bagels ~~~

        2021-03-16 21:38:44

    ----------------------------

    Onion Bage         2   £0.98
    Plain Bagel        12  £3.99
    Everything Bagel   6   £2.49
    Coffee             3   £2.97

    ----------------------------
    Total                 £10.43

             Thank you
          for your order!
    */
    private ArrayList<Inventory> inventoryList;

    private Map<Inventory, Integer> inventoryMap;

    public ExtensionExercise2() {
        inventoryList = new ArrayList<>();
        inventoryMap = new HashMap<>();
    }

    public String returnReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String receipt = "\n" + "    ~~~ Bob's Bagels ~~~    \n\n"
                + "    " + "2024-01-23 08:50:13" + "   \n\n"
                + "----------------------------\n\n";

        double total = 0.0;
        int quantity;

        //For each loop reference: https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        for (Map.Entry<Inventory, Integer> entry : inventoryMap.entrySet()) { //Loops through each entry in the hashmap
            Inventory item = entry.getKey(); //Gets the key from the entry

            quantity = entry.getValue(); //Gets the value from the entry

            double price = item.getPrice() * quantity; //Gets the price of the entry's item (item.getPrice()) and
                                                        // multiplies it by its quantity to get the total price for
                                                        // that items entry

            total += price; //Adds the total price for each items entry (price variable) to the total price for all items
            receipt += String.format("%-" + 30 + "s", String.format("%-19s", item.getVariant() + " " +item.getName()) + String.format("%3d £%.2f", quantity, price)) + "\n";
        }



        receipt += "                            \n"
                + "----------------------------\n"
                + "Total                  £" + String.format("%.2f", total) + "\n\n"
                + "         Thank you\n"
                + "      for your order!       \n\n";

        return receipt;
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    //Extension 2
    // The method below adds a new item to the hashmap, and after sets the default quantity to 0 if the item
    // doesn't already exist in the hashmap, if it does, it increments its quantity.
    public void addItem(Inventory item, int quantity) {
        inventoryMap.put(item, inventoryMap.getOrDefault(item, 0) + quantity);
    }

    public Map<Inventory, Integer> getInventoryMap() {
        return inventoryMap;
    }

    public static void main(String[] args) {
        ExtensionExercise2 extensionExercise2 = new ExtensionExercise2();
        extensionExercise2.returnReceipt();
    }
}
