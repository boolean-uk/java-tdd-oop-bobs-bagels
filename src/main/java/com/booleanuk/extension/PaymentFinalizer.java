package com.booleanuk.extension;

import java.util.HashMap;
import java.util.Map;

public class PaymentFinalizer {


    private double totalDiscount;
    private double paymentBeforeDiscount;

    private double paymentAfterDiscount;
    private Map<BagelExt, Integer> receiptForBagels;
    private Map<CoffeeExt, Integer> receiptForCoffee;
    private Map<FillingExt, Integer> receiptForFillings;

    private

    DiscountCreator discountCreator;

    private double coffeeandBagel = 1.25;
    private double sixInPromo = 2.49;
    private double twelveInPromo = 3.99;


    PaymentFinalizer(DiscountCreator discountCreator) {
        receiptForBagels = new HashMap<>();
        receiptForCoffee = new HashMap<>();
        paymentBeforeDiscount = 0;
        totalDiscount = 0;
        this.discountCreator = discountCreator;
    }


    private void dateForReceipt(BasketExt basketExt) {
        discountCreator.setPromosForBasket(basketExt);
        if (discountCreator.getBglo() > 0) {
            receiptForBagels.put(new BagelExt(SkuExt.BGLO, "Bagel", 0.49), discountCreator.getBglo());
        }
        if (discountCreator.getBglp() > 0) {
            receiptForBagels.put(new BagelExt(SkuExt.BGLP, "Bagel", 0.39), discountCreator.getBglp());
        }
        if (discountCreator.getBgls() > 0) {
            receiptForBagels.put(new BagelExt(SkuExt.BGLE, "Bagel", 0.49), discountCreator.getBgle());
        }
        if (discountCreator.getBgls() > 0) {
            receiptForBagels.put(new BagelExt(SkuExt.BGLS, "Bagel", 0.49), discountCreator.getBgls());
        }
        if (discountCreator.getCofb() > 0) {
            receiptForCoffee.put(new CoffeeExt(SkuExt.COFB, "Coffee", 0.99), discountCreator.getCofb());
        }
        if (discountCreator.getCofw() > 0){
            receiptForCoffee.put(new CoffeeExt(SkuExt.COFC, "Coffee", 1.29), discountCreator.getCofw());
        }
        if (discountCreator.getCofc() > 0){
            receiptForCoffee.put(new CoffeeExt(SkuExt.COFL, "Coffee", 1.29), discountCreator.getCofl());
        }
        if (discountCreator.getFilb() > 0){
            receiptForFillings.put(new FillingExt(SkuExt.FILB, "Filling", 0.12), discountCreator.getFilb());
        }if (discountCreator.getFile() > 0){
            receiptForFillings.put(new FillingExt(SkuExt.FILE, "Filling", 0.12), discountCreator.getFile());
        }
        if(discountCreator.getFilc() > 0){
            receiptForFillings.put(new FillingExt(SkuExt.FILC, "Filling", 0.12), discountCreator.getFilc());
        }
        if(discountCreator.getFilx() > 0){
            receiptForFillings.put(new FillingExt(SkuExt.FILX, "Filling", 0.12), discountCreator.getFilx());
        }
        if(discountCreator.getFils() > 0){
            receiptForFillings.put(new FillingExt(SkuExt.FILS, "Filling", 0.12), discountCreator.getFils());
        }
        if(discountCreator.getFilh() > 0){
            receiptForFillings.put(new FillingExt(SkuExt.FILH, "Filling", 0.12), discountCreator.getFilh());
        }
    }

    public String printPriceForReceipt(BasketExt basketExt) {
        dateForReceipt(basketExt);
        StringBuilder sb = new StringBuilder();
        for (BagelExt bagelExt :
                receiptForBagels.keySet()) {
            if (bagelExt.getSku() == SkuExt.BGLP) {
                if (discountCreator.isBgle12Discount()) {
                    sb.append(bagelExt.getSku().getVariant())
                            .append(" ")
                            .append(bagelExt.getName())
                            .append("  ")
                            .append(receiptForBagels.get(bagelExt))
                            .append(" ")
                            .append(getOnePositionCost(bagelExt.getPrice(),receiptForBagels.get(bagelExt)))
                            .append("       \n");
                } else if (discountCreator.isBgle6Discount()) {

                }
            }
        }

        return "";


    }


    private double getOnePositionCost(double price, int quantity){
        return price*quantity;
    }

}

