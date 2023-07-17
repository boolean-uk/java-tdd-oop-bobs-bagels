package com.booleanuk.extension;

import java.util.HashMap;
import java.util.Map;

public class PaymentFinalizer {


    private double totalDiscount;
    private double paymentBeforeDiscount;
    private Map<BagelExt, Integer> receiptForBagels;
    private Map<CoffeeExt, Integer> receiptForCoffee;
    private Map<FillingExt, Integer> ReceiptForFillings;

    private  double coffeeandBagel = 1.25;
    private double sixInPromo = 2.49;
    private double twelveInPromo  = 3.99;


    PaymentFinalizer(InventoryExt inventoryExt) {
        receiptForBagels = new HashMap<>();
        receiptForCoffee = new HashMap<>();
        paymentBeforeDiscount = 0;
        totalDiscount = 0;

    }


    private void dateForReceipt(BasketExt basketExt, DiscountCreator discountCreator) {
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
            ReceiptForFillings.put(new FillingExt(SkuExt.FILB, "Filling", 0.12),discountCreator.getFilb());
        }if (discountCreator.getFile() > 0){
            ReceiptForFillings.put(new FillingExt(SkuExt.FILE, "Filling", 0.12),discountCreator.getFile());
        }
        if(discountCreator.getFilc() > 0){
            ReceiptForFillings.put(new FillingExt(SkuExt.FILC, "Filling", 0.12),discountCreator.getFilc());
        }
        if(discountCreator.getFilx() > 0){
            ReceiptForFillings.put(new FillingExt(SkuExt.FILX, "Filling", 0.12),discountCreator.getFilx());
        }
        if(discountCreator.getFils() > 0){
            ReceiptForFillings.put(new FillingExt(SkuExt.FILS, "Filling", 0.12),discountCreator.getFils());
        }
        if(discountCreator.getFilh() > 0){
            ReceiptForFillings.put(new FillingExt(SkuExt.FILH, "Filling", 0.12),discountCreator.getFilh());
        }
    }

    public String printPriceForReceipt() {
        for (BagelExt bagelExt :
                receiptForBagels.keySet()) {
            if()
        }

        return "";


    }

}

