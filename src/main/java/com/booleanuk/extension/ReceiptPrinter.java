package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.models.Store;
import com.booleanuk.core.models.item.Bagel;
import com.booleanuk.core.models.item.Filling;
import lombok.Data;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Data
public class ReceiptPrinter {
    private static final String HEADER = "\n\t * Bob's Bagels *";
    private static final String SEPARATOR = "-------------------------";
    private static final String FOOTER = "\t\tThank you!";

    private final Store store;
    private final Basket basket;
    private final StringBuilder sb;
    private final LocalDateTime dateTime;

    public ReceiptPrinter(Store store, Basket basket) {
        this.store = store;
        this.basket = basket;
        this.sb = new StringBuilder();
        this.dateTime = LocalDateTime.now();
    }

    public String print() throws FileNotFoundException, URISyntaxException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        sb.append(HEADER).append("\n\n")
                .append("   ").append(formattedDateTime).append("\n\n")
                .append(SEPARATOR).append("\n");

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

                sb.append(type).append("\t\t\t")
                        .append(quantity).append("\t£")
                        .append(String.format("%.2f", (price+fillingTotal)*quantity)).append("\n");

                for (Filling filling : ((Bagel) item).getFilling()) {
                    sb.append("⋅ ").append(filling.getVariant()).append("\n");
                }
            } else {
                sb.append(type).append("\t\t\t")
                        .append(quantity).append("\t£")
                        .append(String.format("%.2f", price*quantity)).append("\n");
            }
        }

        double discount = DiscountManager.getBasketDiscount(basket);

        if (discount > 0) {
            sb.append("\nDiscount\t\t   -£").append(String.format("%.2f", discount)).append("\n");
        }

        sb.append(SEPARATOR).append("\n")
                .append("Total").append("\t\t\t\t£")
                .append(String.format("%.2f", basket.getTotalCost())).append("\n\n");

        if (discount > 0) {
            sb.append("\t You saved £").append(String.format("%.2f", discount)).append("\n\t   on this shop\n\n");
        }

        sb.append(FOOTER).append("\n");
        return sb.toString();
    }
}
