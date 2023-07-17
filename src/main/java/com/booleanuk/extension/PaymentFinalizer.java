package com.booleanuk.extension;

import java.math.BigDecimal;
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
        receiptForFillings = new HashMap<>();
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
        StringBuilder sb = new StringBuilder("\n");
        for (BagelExt bagelExt :
                receiptForBagels.keySet()) {
            if (bagelExt.getSku() == SkuExt.BGLP) {
                sb.append(bagelExt.getSku().getVariant())
                        .append(" ")
                        .append(bagelExt.getName())
                        .append("  ")
                        .append(receiptForBagels.get(bagelExt))
                        .append("  ");

                if (discountCreator.isBglp12Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(twelveInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();

                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff).append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );

                } else if (discountCreator.isBglp6Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(sixInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();


                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff).append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );


                }else{
                    BigDecimal bagelCost = BigDecimal.valueOf(bagelExt.getPrice());
                    BigDecimal totalCost = bagelCost.multiply(BigDecimal.valueOf(receiptForBagels.get(bagelExt)));
                    paymentBeforeDiscount+=totalCost.doubleValue();
                    sb.append("$")
                            .append( totalCost).append("\n");
                }


            }if(bagelExt.getSku() == SkuExt.BGLO){

                sb.append(bagelExt.getSku().getVariant())
                        .append(" ")
                        .append(bagelExt.getName())
                        .append("  ")
                        .append(receiptForBagels.get(bagelExt))
                        .append("  ");

                if (discountCreator.isBglo12Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(twelveInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();

                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff).append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );

                } else if (discountCreator.isBglo6Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(sixInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();


                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff)
                            .append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );


                }else{
                    BigDecimal bagelCost = BigDecimal.valueOf(bagelExt.getPrice());
                    BigDecimal totalCost = bagelCost.multiply(BigDecimal.valueOf(receiptForBagels.get(bagelExt)));
                    paymentBeforeDiscount+=totalCost.doubleValue();
                    sb.append("$")
                            .append( totalCost)
                            .append("\n");
                }
            }
            if(bagelExt.getSku() == SkuExt.BGLE){

                sb.append(bagelExt.getSku().getVariant())
                        .append(" ")
                        .append(bagelExt.getName())
                        .append("  ")
                        .append(receiptForBagels.get(bagelExt))
                        .append("  ");

                if (discountCreator.isBgle12Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(twelveInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();

                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff)
                            .append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );

                } else if (discountCreator.isBgle6Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(sixInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();


                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff)
                            .append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );


                }else{
                    BigDecimal bagelCost = BigDecimal.valueOf(bagelExt.getPrice());
                    BigDecimal totalCost = bagelCost.multiply(BigDecimal.valueOf(receiptForBagels.get(bagelExt)));
                    paymentBeforeDiscount+=totalCost.doubleValue();
                    sb.append("$")
                            .append( totalCost);
                }

            }

            if(bagelExt.getSku() == SkuExt.BGLS){

                sb.append(bagelExt.getSku().getVariant())
                        .append(" ")
                        .append(bagelExt.getName())
                        .append("  ")
                        .append(receiptForBagels.get(bagelExt))
                        .append("  ");

                if (discountCreator.isBgls12Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(twelveInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();

                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff)
                            .append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );

                } else if (discountCreator.isBgls6Discount()) {
                    BigDecimal totalCost = BigDecimal.valueOf(getOnePositionCost(bagelExt.getPrice(), receiptForBagels.get(bagelExt)));
                    BigDecimal promo  = BigDecimal.valueOf(sixInPromo);
                    BigDecimal diff = promo.subtract(totalCost);
                    paymentBeforeDiscount+=totalCost.doubleValue();


                    sb.append(promo)
                            .append("       \n");
                    sb.append("               ")
                            .append("$")
                            .append(diff)
                            .append("\n");
                    totalDiscount = totalDiscount + (diff.doubleValue() * (-1) );


                }else{
                    BigDecimal bagelCost = BigDecimal.valueOf(bagelExt.getPrice());
                    BigDecimal totalCost = bagelCost.multiply(BigDecimal.valueOf(receiptForBagels.get(bagelExt)));
                    paymentBeforeDiscount+=totalCost.doubleValue();
                    sb.append("$")
                            .append( totalCost)
                            .append("\n");
                }

            }



        }
        for (FillingExt filling :
                receiptForFillings.keySet()) {
            if (filling.getSku() == SkuExt.FILB) {


            BigDecimal fillingPrice = BigDecimal.valueOf(filling.getPrice());
            BigDecimal quantity = BigDecimal.valueOf(receiptForFillings.get(filling));
            BigDecimal total = fillingPrice.multiply(quantity);
            paymentBeforeDiscount+= total.doubleValue();
                sb.append(filling.getSku().getVariant())
                        .append(" ")
                        .append(filling.getName())
                        .append("  ")
                        .append(receiptForFillings.get(filling))
                        .append(" ")
                        .append(getOnePositionCost(filling.getPrice(),receiptForFillings.get(filling)))
                        .append("\n");


            }
            if (filling.getSku() == SkuExt.FILX) {


                BigDecimal fillingPrice = BigDecimal.valueOf(filling.getPrice());
                BigDecimal quantity = BigDecimal.valueOf(receiptForFillings.get(filling));
                BigDecimal total = fillingPrice.multiply(quantity);
                paymentBeforeDiscount+= total.doubleValue();
                sb.append(filling.getSku().getVariant())
                        .append(" ")
                        .append(filling.getName())
                        .append("  ")
                        .append(receiptForFillings.get(filling))
                        .append(" ")
                        .append(getOnePositionCost(filling.getPrice(),receiptForFillings.get(filling)))
                        .append("\n");


            }
            if (filling.getSku() == SkuExt.FILH){


                BigDecimal fillingPrice = BigDecimal.valueOf(filling.getPrice());
                BigDecimal quantity = BigDecimal.valueOf(receiptForFillings.get(filling));
                BigDecimal total = fillingPrice.multiply(quantity);
                paymentBeforeDiscount+= total.doubleValue();
                sb.append(filling.getSku().getVariant())
                        .append(" ")
                        .append(filling.getName())
                        .append("  ")
                        .append(receiptForFillings.get(filling))
                        .append(" ")
                        .append(getOnePositionCost(filling.getPrice(),receiptForFillings.get(filling)))
                        .append("\n");


            }
            if (filling.getSku() == SkuExt.FILS) {


                BigDecimal fillingPrice = BigDecimal.valueOf(filling.getPrice());
                BigDecimal quantity = BigDecimal.valueOf(receiptForFillings.get(filling));
                BigDecimal total = fillingPrice.multiply(quantity);
                paymentBeforeDiscount+= total.doubleValue();
                sb.append(filling.getSku().getVariant())
                        .append(" ")
                        .append(filling.getName())
                        .append("  ")
                        .append(receiptForFillings.get(filling))
                        .append(" ")
                        .append(getOnePositionCost(filling.getPrice(),receiptForFillings.get(filling)))
                        .append("\n");


            }
            if (filling.getSku() == SkuExt.FILE) {


                BigDecimal fillingPrice = BigDecimal.valueOf(filling.getPrice());
                BigDecimal quantity = BigDecimal.valueOf(receiptForFillings.get(filling));
                BigDecimal total = fillingPrice.multiply(quantity);
                paymentBeforeDiscount+= total.doubleValue();
                sb.append(filling.getSku().getVariant())
                        .append(" ")
                        .append(filling.getName())
                        .append("  ")
                        .append(receiptForFillings.get(filling))
                        .append(" ")
                        .append(getOnePositionCost(filling.getPrice(),receiptForFillings.get(filling)))
                        .append("\n");


            }
            if (filling.getSku() == SkuExt.FILC) {


                BigDecimal fillingPrice = BigDecimal.valueOf(filling.getPrice());
                BigDecimal quantity = BigDecimal.valueOf(receiptForFillings.get(filling));
                BigDecimal total = fillingPrice.multiply(quantity);
                paymentBeforeDiscount+= total.doubleValue();
                sb.append(filling.getSku().getVariant())
                        .append(" ")
                        .append(filling.getName())
                        .append("  ")
                        .append(receiptForFillings.get(filling))
                        .append(" ")
                        .append(getOnePositionCost(filling.getPrice(),receiptForFillings.get(filling)))
                        .append("\n");


            }


}
        for (CoffeeExt coffeeExt :
                receiptForCoffee.keySet()) {

            BigDecimal fillingPrice = BigDecimal.valueOf(coffeeExt.getPrice());
            BigDecimal quantity = BigDecimal.valueOf(receiptForCoffee.get(coffeeExt));
            BigDecimal total = fillingPrice.multiply(quantity);
            paymentBeforeDiscount+= total.doubleValue();


                sb.append(coffeeExt.getSku().getVariant())
                        .append(" ")
                        .append(coffeeExt.getName())
                        .append("  ")
                        .append(receiptForCoffee.get(coffeeExt))
                        .append(" ")
                        .append(getOnePositionCost(coffeeExt.getPrice(), receiptForCoffee.get(coffeeExt)))
                        .append("\n");

        }


        sb.append("---------------------------\n")
                .append("      TOTAL: ")
                .append(paymentBeforeDiscount - totalDiscount).append("\n");
        sb.append("You saved a total of: $")
                .append(totalDiscount)
                .append("\n")
                .append("Thank you for your order!\n");
        return sb.toString();


    }


    private double getOnePositionCost(double price, int quantity){
        return price*quantity;
    }

}

