package com.booleanuk.core;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Locale;


public class Reciept {

    private Basket basket;
    private ArrayList<String> recieptRows;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public Reciept(Basket basket) {
        this.basket = basket;
        this.recieptRows = new ArrayList<>();
        this.createReciept();

    }

    public void printReciept() {
        for (String row : recieptRows) {
            System.out.println(row);
        }
    }

    public void createReciept() {
        recieptRows.add("    ~~~ Bob's Bagels ~~~    ");
        recieptRows.add("");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:SS");
        recieptRows.add("    " + date.format(formatter));
        recieptRows.add("");
        recieptRows.add("----------------------------");

        for (Product product : basket.currentBasket.keySet()) {

            int quantity = basket.currentBasket.get(product);
            double sum = Double.parseDouble(decfor.format(basket.costOf(product) * Double.valueOf(quantity)));

            if (product instanceof Bagel) {
                Bagel bagel = (Bagel) product;

                if (bagel.getFilling() != null) {
                    String row = String.format("%-20s %3d £%-6.2f",
                            product.retrieveVariant() + " " + product.retrieveName() + " " + bagel.getFilling().retrieveVariant(),
                            quantity,
                            sum);
                    recieptRows.add(row);
                    continue;
                }

            }

            String row = String.format("%-20s %3d £%-6.2f",
                    product.retrieveVariant() + " " + product.retrieveName(),
                    quantity,
                    sum);
                recieptRows.add(row);
                }


            recieptRows.add("");
            recieptRows.add("----------------------------");
            String totalCostRow = String.format("%-23s £%-6.2f", "Total", basket.totalCost());
            recieptRows.add(totalCostRow);
            recieptRows.add("");
            recieptRows.add("        Thank you");
            recieptRows.add("      for your order!");

        }
    }
