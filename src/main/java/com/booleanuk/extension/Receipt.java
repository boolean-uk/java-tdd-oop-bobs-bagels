package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptLine> products;

    public Receipt(){
        this.products = new ArrayList<>();
    }

    public List<ReceiptLine> getProducts(){
        return products;
    }

    public void addProduct(ReceiptLine receiptLine){
        products.add(receiptLine);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "products=" + products +
                '}';
    }
}
