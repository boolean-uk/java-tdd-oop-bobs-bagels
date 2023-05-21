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
        items.forEach(i -> receipt.append(i.asString() + "\n"));

        return receipt.toString();
    }
}
