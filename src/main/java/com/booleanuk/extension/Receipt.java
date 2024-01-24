package com.booleanuk.extension;

import com.booleanuk.core.BasketManager;
import com.booleanuk.core.InventoryManager;
import com.booleanuk.core.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

/**
 * -------------------------------
 * EXTENSION 1 & 2 & 3
 *--------------------------------
 */

public class Receipt {
    List<Item> basket;
    InventoryManager inv;

    public Receipt(BasketManager basket, InventoryManager inv) {
        this.setBasket(basket);
        this.setInv(inv);
    }

    public List<Item> getBasket() {
        return basket;
    }

    public InventoryManager getInv() {
        return inv;
    }

    public void setBasket(BasketManager basket) {
        this.basket = basket.getBasket();
    }

    public void setInv(InventoryManager inv) {
        this.inv = inv;
    }

    public void printReceipt() {
        InventoryManager inv = this.getInv();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // Iterate through the basket to collect items
        HashMap<String, Integer> frequencyCounter = new HashMap<>();
        for(Item item : this.getBasket()) {
            if (frequencyCounter.containsKey(item.getSKU())) {
                frequencyCounter.put(item.getSKU(), frequencyCounter.get(item.getSKU()) + 1);
            } else {
                frequencyCounter.put(item.getSKU(), 1);
            }
        }

        // Header of the receipt
        System.out.println("                ~~~ !Bob's Bagels ~~~\n");
        System.out.println("                 " + formattedDateTime + "\n");
        System.out.println("             ____________SIDES___________\n");

        // Print the quantity of each item based on the frequencyCounter above

        for (String key : frequencyCounter.keySet()) {
            System.out.printf("%-15s %-25s %-8d %-15s%n",
                    inv.getInventory().get(key).getVariant(),
                    inv.getInventory().get(key).getName(),
                    frequencyCounter.get(key),
                    String.format("%.2f%s", inv.getInventory().get(key).getPrice() * frequencyCounter.get(key), "DKK,-"));
        }
        double discount = discountPrice(frequencyCounter);
        System.out.printf("%-15s %-25s %-8s (-%.2f)DKK,-%n", "[Discount]", "", "", discount);


        System.out.println();
        System.out.println("             __________FILLINGS__________\n");

        frequencyCounter.clear();

        for(Item item : this.getBasket()) {
            if ((item.getFilling() != null)) {
                if ((frequencyCounter.containsKey(item.getFilling().getSKU()))) {
                    frequencyCounter.put(item.getFilling().getSKU(), frequencyCounter.get(item.getFilling().getSKU()) + 1);
                } else {
                    frequencyCounter.put(item.getFilling().getSKU(), 1);
                }
            } else {
                continue;
            }
        }

        for (String key : frequencyCounter.keySet()) {
            System.out.printf("%-15s %-25s %-8d %-15s%n",
                    inv.getInventory().get(key).getVariant(),
                    inv.getInventory().get(key).getName(),
                    frequencyCounter.get(key),
                    String.format("%.2f%s", inv.getInventory().get(key).getPrice() * frequencyCounter.get(key), "DKK,-"));
        }

        // stolen logic from totalCost()
        double total = 0.0;
        for(Item i : this.getBasket()) {
            total += i.getPrice();
            if (i.getFilling() != null) {
                total += i.getFilling().getPrice();
            }
        }



        System.out.println("             ____________________________\n");
        System.out.printf("%-15s %-25s %-8s %-15s%n", "Total", "", "", String.format("%.2f%s", (total - discount), "DKK,-"));
        System.out.println("___________________________________________________________\n");

        System.out.println("Contact Information:");
        System.out.println("Telephone: +45 ....");
        System.out.println("Opening hours: 08:30 - 16:30");
        System.out.println("___________________________________________________________\n");

    }

    public double discountPrice(HashMap<String, Integer> frequencyCounter) {
        double discount = 0.0;

        for(String key : frequencyCounter.keySet()) {
            if(key == "BGLO" || key == "BGLE" || key == "BGLS") {
                while(frequencyCounter.get(key) > 12) {
                    discount += 1.89;
                    frequencyCounter.put(key, frequencyCounter.get(key) - 12);
                }
                while(frequencyCounter.get(key) > 6) {
                    discount += 0.45;
                    frequencyCounter.put(key,frequencyCounter.get(key) - 6);
                }
            }
            if(key == "BGLP") {
                while(frequencyCounter.get(key) > 12) {
                    discount += 1.89;
                    frequencyCounter.put(key, frequencyCounter.get(key) - 12);
                }
                while(frequencyCounter.get(key) > 6) {
                    discount += 0.45;
                    frequencyCounter.put(key,frequencyCounter.get(key) - 6);
                }
            }
        }
        return discount;
    }
}
