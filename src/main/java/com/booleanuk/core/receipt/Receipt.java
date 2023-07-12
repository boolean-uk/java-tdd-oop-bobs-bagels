package com.booleanuk.core.receipt;

import java.util.*;

public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();

    public void add(ReceiptItem item) {
        Optional<ReceiptItem> receiptItem = items.stream().filter(ri -> ri.equals(item))
                .findFirst();

        if (receiptItem.isPresent()) {
            items.set(items.indexOf(receiptItem.get()), receiptItem.get().updated(item));
        }
        else
            this.items.add(item);;
    }

    public String receipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("%" + 30 + "s", "Bob's Bagels\n"));
        receipt.append("------------------------------------------------\n");

        items.forEach(i -> receipt.append(i.asString() + "\n"));

        double discountedCost = items.stream().reduce(0.0, (sum, i) -> sum + i.cost(), Double::sum);

        receipt.append("------------------------------------------------\n");
        receipt.append(new ReceiptItem("total", 0, discountedCost).asString());

        return receipt.toString();
    }

    public String detailedReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("%" + 30 + "s", "Bob's Bagels\n"));
        receipt.append("------------------------------------------------\n");

        items.forEach(i -> receipt.append(i.asDetailedString() + "\n"));

        double discountedCost = items.stream().reduce(0.0, (sum, i) -> sum + i.cost(), Double::sum);
        double originalCost = items.stream().reduce(0.0, (sum, i) -> sum + i.originalCost(), Double::sum);

        receipt.append("------------------------------------------------\n");
        receipt.append(new ReceiptItem("total", 0, discountedCost, originalCost).asDetailedString());

        return receipt.toString();
    }
}
