package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.exceptions.FullBasketException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt {
    private final Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("\t~~~~ Bobs Bagel ~~~~\n");
        System.out.println("\t" + getFormattedDate() + "\n");
        System.out.println("----------------------------");
        getItemsInBasket(this.order.getBasket());
    }

    public void getItemsInBasket(Basket basket) {

        ArrayList<String> resultList = new ArrayList<>();

        for (int i = 0; i < basket.getProducts().size(); i++) {
            Product product = basket.getProducts().get(i);
            for (int j = i+1; j < basket.getProducts().size(); j++) {
                Product compare = basket.getProducts().get(j);

                if (product.getVariant().equals(compare.getVariant())) {
                    product.setQuantity(product.getQuantity() + 1);
                }
            }
            resultList.add(product.getVariant() + " " + product.getName() + " " + product.getQuantity());
        }

    }

    public String getFormattedDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(df);
    }

    public static void main(String[] args) throws FullBasketException {
        Order order1 = new Order();
        order1.getBasket().addProduct(BagelType.ONION);
        order1.getBasket().addProduct(BagelType.ONION);
        order1.getBasket().addProduct(BagelType.ONION);
        order1.getBasket().addProduct(BagelType.ONION);
        order1.getBasket().addProduct(BagelType.PLAIN);

        Receipt receipt = new Receipt(order1);
        receipt.printReceipt();

    }
}
