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
        inventoryList.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        inventoryList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        inventoryList.add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        inventoryList.add(new Inventory("BGLS", 0.49, "Bagel", "Sesame"));
        inventoryList.add(new Inventory("COFB", 0.99, "Coffee", "Black"));
        inventoryList.add(new Inventory("COFW", 1.19, "Coffee", "White"));
        inventoryList.add(new Inventory("COFC", 1.29, "Coffee", "Cappuccino"));
        inventoryList.add(new Inventory("COFL", 1.29, "Coffee", "Latte"));
        inventoryList.add(new Inventory("FILB", 0.12, "Filling", "Bacon"));
        inventoryList.add(new Inventory("FILE", 0.12, "Filling", "Egg"));
        inventoryList.add(new Inventory("FILC", 0.12, "Filling", "Cheese"));
        inventoryList.add(new Inventory("FILX", 0.12, "Filling", "Cream Cheese"));
        inventoryList.add(new Inventory("FILS", 0.12, "Filling", "Smoked Salmon"));
        inventoryList.add(new Inventory("FILH", 0.12, "Filling", "Ham"));
    }

    public String returnReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String receipt = "    ~~~ Bob's Bagels ~~~    \n"
                + "   " + dateFormat.format(new Date()) + "   \n"
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
            receipt += item.getVariant() + " " + item.getName() + "     " + quantity + " £" + price + "     \n";
        }

        receipt += "                            \n"
                + "----------------------------\n"
                + "Total                 £" + total + "\n"
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
}
