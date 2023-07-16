package com.booleanuk.extension;

public class DiscountCreator {

    private double totalDiscount;

    private int bglo;
    private int bglp;
    private int bgle;
    private int bgls;
    private boolean bglo6Discount;
    private boolean bglo12Discount;
    private  boolean isBglp12Discount;
    private boolean  isBglp6Discount;

    private boolean  isCoffeeAndBagelPromo;



    public DiscountCreator() {
        bglo = 0;
        bgls = 0;
        bgle = 0;
        bglp = 0;
    }

    public boolean isSpecialBGLOTwelveOffer(BasketExt basketExt) {
        return bglo >=12;
    }
    public boolean isSpecialBGLPTwelveOffer(BasketExt basketExt) {
        return bglp >=12;
    }
    public boolean isSpecialBGLETwelveOffer(BasketExt basketExt) {

        return bgle >=12;
    }
    public boolean isSpecialBGLSTwelveOffer(BasketExt basketExt) {

        return bgls >=12;
    }


    public boolean isSpecialBGLSSixOffer(BasketExt basketExt) {
        return bgls >= 6 && bgls < 12;
    }

    public boolean isSpecialCoffeeAndBagelPromo(BasketExt basketExt){
        bagelsCounter(basketExt);
        if((bgls < 6 && bgls >= 1) || (bglp < 6 && bglp >= 1)  || (bgle < 6 && bgle >= 1) || (bglo < 6 && bglo >= 1)  ){
            return true;
        }
        return false;
    }



    public void bagelsCounter(BasketExt basketExt) {
        basketExt.getBagelsInBasket().forEach(bagel -> {
            if (bagel.getSku() == SKU.BGLP) {
                bglp++;
            } else if (bagel.getSku() == SKU.BGLO) {
                bglo++;
            } else if (bagel.getSku() == SKU.BGLE) {
                bgle++;
            } else if (bagel.getSku() == SKU.BGLS) {
                bgls++;
            }
        });
    }

}
