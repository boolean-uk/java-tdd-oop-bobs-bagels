package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Receipt {
    private String receipt;
    private LocalDateTime dateAndTime;
    private Basket basket;

    public Receipt(Basket basket) {
        this.basket = basket;
        this.dateAndTime = LocalDateTime.now();
        this.dateAndTime = this.dateAndTime.minusNanos(this.dateAndTime.getNano());
        this.receipt = "";
    }

    public String generateReceipt() {
        if (basket.getBasketContent().isEmpty()) {
            return "Basket is empty.";
        }
        StringBuilder receipt = new StringBuilder();
        receipt.append(createHeader());
        for (Item item : basket.getBasketContent().keySet()) {
            int amount = basket.getBasketContent().get(item);
            String itemRow = item.getVariant() + " " + item.getName() + "\t\t" +  amount + "\t\u00A3" + item.getPrice() * amount + "\n";
            receipt.append(itemRow);
        }
        receipt.append("\n----------------------------\nTotal                  \u00A3") ;
        receipt.append(basket.totalCost());
        receipt.append(createFooter());
        this.receipt = receipt.toString();
        return receipt.toString();
    }

    public String createHeader() {
        String header = "";
        header += "    ~~~ Bob's Bagels ~~~\n\n    ";
        header += this.dateAndTime.toString().replace("T", " ");
        header += "\n\n----------------------------\n\n";
        return header;
    }

    public String createFooter() {
        return "\n\n        Thank you\n      for your order!";
    }

    public boolean printReceipt() {
        if (this.receipt.isEmpty()) {
            return false;
        }
        System.out.println(this.receipt);
        return true;
    }

    public LocalDateTime getDateAndTime() {
        return this.dateAndTime;
    }

    public String generateReceiptWithDiscount() {
        if (basket.getBasketContent().isEmpty()) {
            return "Basket is empty.";
        }
        StringBuilder receipt = new StringBuilder();
        receipt.append(createHeader());

        HashMap<Item, double[]> mapPriceAndSavings = this.basket.discountPerItem();
        double totalSavings = 0.0;
        for (Item item : basket.getBasketContent().keySet()) {
            int amount = basket.getBasketContent().get(item);
            String itemRow = item.getVariant() + " " + item.getName() + "\t\t" +  amount + "\t\u00A3" + mapPriceAndSavings.get(item)[0] + "\n";
            double saving = mapPriceAndSavings.get(item)[1];
            if (saving != 0.0){
                itemRow += "                  (-\u00A3" + saving + ")\n";
                totalSavings += saving;
            }
            receipt.append(itemRow);
        }
        receipt.append("\n----------------------------\nTotal               \u00A3") ;
        receipt.append(basket.totalCostWithDiscount(mapPriceAndSavings));
        receipt.append("\n\nYou saved a total of £");
        receipt.append(totalSavings);
        receipt.append("\n      on this purchase.");
        receipt.append(createFooter());
        this.receipt = receipt.toString();
        return receipt.toString();
    }
}
