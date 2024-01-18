package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.models.Store;
import com.booleanuk.core.models.item.Bagel;
import com.booleanuk.core.models.item.Filling;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Data
public class ReceiptPrinter {
    private static final String HEADER = "~~~ Bob's Bagels ~~~";
    private static final String SEPARATOR = "---------------------";
    private static final String FOOTER = "\t Thank you !";

    private final Store store;
    private final Basket basket;
    private StringBuilder sb;
    private LocalDateTime dateTime;

    public ReceiptPrinter(Store store, Basket basket) {
        this.store = store;
        this.basket = basket;
        this.sb = new StringBuilder();
        this.dateTime = LocalDateTime.now();
    }

    public String print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        sb.append(HEADER).append("\n\n")
                .append(" ").append(formattedDateTime).append("\n\n")
                .append(SEPARATOR).append("\n\n");

        for (HashMap.Entry<Item, Integer> entry : basket.getItemCount().entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            String type = item.getVariant();
            // String name = item.getName();
            double price = item.getPrice();

            if (item instanceof Bagel && !((Bagel) item).getFilling().isEmpty()) {
                double fillingTotal = 0;
                for (Filling filling : ((Bagel) item).getFilling()) {
                    fillingTotal += filling.getPrice();
                }

                sb.append(type).append("\t\t")
                        .append(quantity).append("\t£")
                        .append(String.format("%.2f", (price+fillingTotal)*quantity)).append("\n");

                for (Filling filling : ((Bagel) item).getFilling()) {
                    sb.append("- ").append(filling.getVariant()).append("\n");
                }
            } else {
                sb.append(type).append("\t\t")
                        .append(quantity).append("\t£")
                        .append(String.format("%.2f", price*quantity)).append("\n");
            }
        }

        sb.append("\n").append(SEPARATOR).append("\n\n")
                .append("Total").append("\t\t\t£")
                .append(String.format("%.2f", basket.getTotalCost())).append("\n\n")
                .append(FOOTER);

        return sb.toString();
    }
}
