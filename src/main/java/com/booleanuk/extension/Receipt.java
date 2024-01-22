package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final int charactersOnOneRow = 34;

    public Receipt() {
    }

    // If there is no items in the basket, the customer should not be able to print a receipt.

    public void printReceipt(Basket basket, Inventory inventory) {
        String receiptOutput = "";
        receiptOutput += "       ~~~ Bob's Bagels ~~~       \n";
        receiptOutput += "\n";
        receiptOutput += getDateTimeForReceipt();
        receiptOutput += "\n";
        receiptOutput += "-----------------------------------\n";
        receiptOutput += "\n";
        receiptOutput += getBasketForReceipt(basket, inventory);
        receiptOutput += "\n";
        receiptOutput += "-----------------------------------\n";
        receiptOutput += getTotalAmountForReceipt(basket, inventory);
        receiptOutput += "\n";
        receiptOutput += getEndMessageForReceipt();

        System.out.print(receiptOutput);
    }

    private String getDateTimeForReceipt() {
        String returnString = "";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();

        String dateTimeString = dtf.format(dateTime);

        int spaces = (charactersOnOneRow - dateTimeString.length()) / 2;

        returnString += insertSpaces(spaces);
        returnString += dateTimeString;
        returnString += insertSpaces(spaces - 1) + "\n";

        return returnString;
    }

    private String getBasketForReceipt(Basket basket, Inventory inventory) {
        String returnString = "";
        int placeForItemAmount = 25;
        List<String> addedItems = new ArrayList<>();
        String bagelItem = " Bagel";
        String coffeeItem = " Coffee";
        String fillingItem = " filling";
        String with = "with ";

        for (Item item : basket.getBasket()) {
            returnString += item.getName();
            if (item.getClass() == Bagel.class) {
                returnString += bagelItem;
                returnString += insertSpaces(placeForItemAmount -
                        (bagelItem.length() + item.getName().length()));
                returnString += basket.getAmountOfItemInBasket(item);
                if (!((Bagel) item).getFillings().isEmpty()) {
                    for (String filling : ((Bagel) item).getFillings()) {
                        returnString += "\n" + with + filling + fillingItem;
                        returnString += insertSpaces(placeForItemAmount -
                                (with.length() + filling.length() + fillingItem.length()));
                        returnString += ((Bagel) item).getFillingAmount(filling);
                        returnString += "  £" +
                                (inventory.getPrice(filling) + inventory.getPrice(item.getName()));
                    }
                } else {
                    returnString += "  £" + inventory.getPrice(item.getName());
                }
            } else {
                returnString += coffeeItem;
                returnString += insertSpaces(placeForItemAmount -
                        (coffeeItem.length() + item.getName().length()));
                returnString += basket.getAmountOfItemInBasket(item);
                returnString += "  £" + inventory.getPrice(item.getName());
            }
            returnString += "\n";
        }
        return returnString;
    }

    private String getTotalAmountForReceipt(Basket basket, Inventory inventory) {
        double totalCost = 0;
        int placeForTotalCost = 29;

        String returnString = "";
        String total = "Total";
        returnString += total;
        returnString += insertSpaces(placeForTotalCost - total.length());

        for (Item item : basket.getBasket()) {
            totalCost += inventory.getPrice(item.getName());
            if (item instanceof Bagel && !(((Bagel) item).getFillings().isEmpty())) {
                for (String filling : ((Bagel) item).getFillings()) {
                    totalCost += inventory.getPrice(filling);
                }
            }
        }
        returnString += "£" + totalCost + "\n";
        return returnString;
    }

    private String getEndMessageForReceipt() {
        String returnString = "";
        String secondLastRow = "Thank you";
        String lastRow = "for your order!";

        String spacesPartOne = insertSpaces(((charactersOnOneRow - secondLastRow.length()) / 2) - 1);
        String spacesPartTwo = insertSpaces(charactersOnOneRow -
                (spacesPartOne.length() + secondLastRow.length() + 1));
        String spacesPartThree = insertSpaces(((charactersOnOneRow - lastRow.length()) / 2) - 1);
        String spacesPartFour = insertSpaces(charactersOnOneRow -
                (spacesPartThree.length() + lastRow.length() + 1));

        returnString += spacesPartOne + secondLastRow + spacesPartTwo + "\n";
        returnString += spacesPartThree + lastRow + spacesPartFour + "\n";

        return returnString;
    }

    private String insertSpaces(int end) {
        String returnString = "";
        for (int i = 0; i <= end; i++) {
            returnString += " ";
        }
        return returnString;
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Receipt receipt = new Receipt();

        String item1 = "Plain";
        Bagel bagel1 = new Bagel(item1, inventory.getSKU(item1));
        basket.addItem(bagel1);

        String item2 = "White";
        Item coffee1 = new Coffee(item2, inventory.getSKU(item2));
        basket.addItem(coffee1);

        String item3 = "Everything";
        Bagel bagel2 = new Bagel(item3, inventory.getSKU(item3));
        basket.addItem(bagel2);

        String item4 = "Black";
        Item coffee2 = new Coffee(item4, inventory.getSKU(item4));
        basket.addItem(coffee2);

        String item5 = "Bacon";
        basket.addBagelFilling(bagel1, new Filling(item5, inventory.getSKU(item5)));

        String item6 = "Cream Cheese";
        basket.addBagelFilling(bagel2, new Filling(item6, inventory.getSKU(item6)));

        receipt.printReceipt(basket, inventory);
    }
}
