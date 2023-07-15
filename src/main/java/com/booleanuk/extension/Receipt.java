package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Receipt {
    private List<ReceiptLine> products;
    private Basket basket;
    private BigDecimal savedMoney;


    public Receipt(Basket basket){
        this.products = new ArrayList<>();
        this.basket = basket;
        this.savedMoney = new BigDecimal("0.00");

    }

    public List<ReceiptLine> getProducts(){
        return products;
    }

    public void addProduct(ReceiptLine receiptLine){
        products.add(receiptLine);
    }


    public BigDecimal getSavedMoney() {
        return savedMoney;
    }

    @Override
    public String toString() {
        this.products = this.products.stream().filter(x->x.getPrice().compareTo(new BigDecimal("0.00"))!=0).collect(Collectors.toList());
        BigDecimal discountedAmount;
        StringBuilder sb = new StringBuilder();
        String name,variant;

        sb.append("\t\t~~~ Bob's Bagels ~~~\n");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        sb.append("\t\t").append(formattedDateTime);
        sb.append("\n----------------------------------\n");


        for(ReceiptLine rl: this.getProducts()){
            System.out.println(rl.getPrice() + " " + rl.getItem().getName() + " " + rl.getItem().getVariant());

                if(rl.isBagelCoffeeSpecial()){
                    discountedAmount = rl.getPrice().
                            subtract((rl.getItem().getPrice().
                                    add(Inventory.getItemPrice("Bagel", "Plain").get())).
                                    multiply(rl.getQuantity()));
                    name = "Coffee/Bagel";
                    variant= "Combo";
                }
                else {
                    discountedAmount = rl.getPrice().subtract(rl.getItem().getPrice().multiply(rl.getQuantity()));
                    name = rl.getItem().getName();
                    variant= rl.getItem().getVariant();
                }

                savedMoney = savedMoney.subtract(discountedAmount);
                sb.append(formatter(name,13)).
                        append(formatter(variant,12)).
                        append(formatter(rl.getQuantity().toString(),3)).
                        append(" $").append(rl.getPrice()).append("\n");
                if (discountedAmount.compareTo(new BigDecimal("0.00")) != 0) {
                    sb.append(formatter("", 27)).append("(-$").append(discountedAmount.negate()).append(")\n");
                }

        }
        sb.append("----------------------------------\n");
        sb.append("Total: $").append(basket.totalPrice()).append("\n");
        sb.append("\tYou saved a total of $").append(savedMoney).append("\n").append("\t\ton this shop.\n\n");
        sb.append("\t\t\tThank you\n" +
                "\t\tfor your order!");
        return sb.toString();
    }

    private String formatter(String x, int width){
        StringBuilder pom = new StringBuilder(x);
        pom.append(" ".repeat(Math.max(1, width - x.length())));
        return pom.toString();
    }
}
