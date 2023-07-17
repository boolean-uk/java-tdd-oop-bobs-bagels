package com.booleanuk.extension;

public class DiscountCreator {

    private double totalDiscount;

    private int bglo;
    private int bglp;
    private int bgle;
    private int bgls;
    private int cofw;
    private int cofb;
    private int cofc;
    private int cofl;
    private boolean isBglo6Discount;
    private boolean isBglo12Discount;
    private boolean isBglp12Discount;
    private boolean isBglp6Discount;
    private boolean isBgle12Discount;
    private boolean isBgle6Discount;
    private boolean isBgls12Discount;
    private boolean isBgls6Discount;


    private boolean isCoffeeAndBagelPromo;
    private int filb = 0;
    private int filc = 0;
    private int file = 0;
    private int filh = 0;
    private int fils = 0;
    private int filx = 0;


    public DiscountCreator() {
        bglo = 0;
        bgls = 0;
        bgle = 0;
        bglp = 0;
        cofb = 0;
        cofc = 0;
        cofl = 0;
        cofw = 0;
        isCoffeeAndBagelPromo = false;
    }

    public boolean isSpecialBGLOTwelveOffer() {
        return bglo >=12;
    }
    public boolean isSpecialBGLPTwelveOffer() {
        return bglp >=12;
    }
    public boolean isSpecialBGLETwelveOffer() {
        return bgle >=12;
    }

    public boolean isSpecialBGLSTwelveOffer() {
        return bgls >= 12;
    }


    private boolean isSpecialBGLSSixOffer() {
        return bgls >= 6 && bgls < 12;
    }

    private boolean isSpecialBGLOSixOffer() {
        return bglo >= 6 && bglo < 12;
    }

    private boolean isSpecialBGLESixOffer() {
        return bgle >= 6 && bgle < 12;
    }

    private boolean isSpecialBGLPSixOffer() {
        return bglp >= 6 && bglp < 12;
    }

    public boolean isSpecialCoffeeAndBagelPromo(BasketExt basketExt) {
        if (((bgls < 6 && bgls >= 1) || (bglp < 6 && bglp >= 1) || (bgle < 6 && bgle >= 1) || (bglo < 6 && bglo >= 1)) && !basketExt.getCoffeesInBasket().isEmpty()) {
            return true;
        }
        return false;
    }


    public void bagelsCounter(BasketExt basketExt) {
        basketExt.getBagelsInBasket().forEach(bagel -> {
            if (bagel.getSku() == SkuExt.BGLP) {
                bglp++;
            } else if (bagel.getSku() == SkuExt.BGLO) {
                bglo++;
            } else if (bagel.getSku() == SkuExt.BGLE) {
                bgle++;
            } else if (bagel.getSku() == SkuExt.BGLS) {
                bgls++;
            }
        });
    }

    public void setPromosForBasket(BasketExt basketExt) {
        bagelsCounter(basketExt);
        fillingCounter(basketExt);
        coffeeCounter(basketExt);
        isBgle6Discount = isSpecialBGLESixOffer();
        isBgle12Discount = isSpecialBGLESixOffer();

        isBgls6Discount = isSpecialBGLSSixOffer();
        isBgls12Discount = isSpecialBGLSSixOffer();

        isBglo6Discount = isSpecialBGLOSixOffer();
        isBglo12Discount = isSpecialBGLOTwelveOffer();

        isBglp6Discount = isSpecialBGLPSixOffer();
        isBglp12Discount = isSpecialBGLPTwelveOffer();

        isSpecialCoffeeAndBagelPromo(basketExt);


    }

    public void coffeeCounter(BasketExt basketExt) {
        basketExt.getCoffeesInBasket().forEach(coffeeExt -> {
            if (coffeeExt.getSku() == SkuExt.COFB) {
                cofb++;
            } else if (coffeeExt.getSku() == SkuExt.COFC) {
                cofc++;
            } else if (coffeeExt.getSku() == SkuExt.COFW) {
                cofw++;
            } else if (coffeeExt.getSku() == SkuExt.COFL) {
                cofl++;
            }
        });
    }

    public void fillingCounter(BasketExt basketExt) {
        basketExt.getFillingInBasket().forEach(fillingExt -> {
            if (fillingExt.getSku() == SkuExt.FILB) {
                filb++;
            } else if (fillingExt.getSku() == SkuExt.FILC) {
                filc++;
            } else if (fillingExt.getSku() == SkuExt.FILE) {
                file++;
            } else if (fillingExt.getSku() == SkuExt.FILH) {
                filh++;
            } else if (fillingExt.getSku() == SkuExt.FILS) {
                fils++;
            } else if (fillingExt.getSku() == SkuExt.FILX) {
                filx++;
            }
        });
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public int getBglo() {
        return bglo;
    }

    public void setBglo(int bglo) {
        this.bglo = bglo;
    }

    public int getBglp() {
        return bglp;
    }

    public void setBglp(int bglp) {
        this.bglp = bglp;
    }

    public int getBgle() {
        return bgle;
    }

    public void setBgle(int bgle) {
        this.bgle = bgle;
    }

    public int getBgls() {
        return bgls;
    }

    public void setBgls(int bgls) {
        this.bgls = bgls;
    }

    public boolean isBglo6Discount() {
        return isBglo6Discount;
    }

    public void setBglo6Discount(boolean bglo6Discount) {
        isBglo6Discount = bglo6Discount;
    }

    public boolean isBglo12Discount() {
        return isBglo12Discount;
    }

    public void setBglo12Discount(boolean bglo12Discount) {
        isBglo12Discount = bglo12Discount;
    }

    public boolean isBglp12Discount() {
        return isBglp12Discount;
    }

    public void setBglp12Discount(boolean bglp12Discount) {
        isBglp12Discount = bglp12Discount;
    }

    public boolean isBglp6Discount() {
        return isBglp6Discount;
    }

    public void setBglp6Discount(boolean bglp6Discount) {
        isBglp6Discount = bglp6Discount;
    }

    public boolean isBgle12Discount() {
        return isBgle12Discount;
    }

    public void setBgle12Discount(boolean bgle12Discount) {
        isBgle12Discount = bgle12Discount;
    }

    public boolean isBgle6Discount() {
        return isBgle6Discount;
    }

    public void setBgle6Discount(boolean bgle6Discount) {
        isBgle6Discount = bgle6Discount;
    }

    public boolean isBgls12Discount() {
        return isBgls12Discount;
    }

    public void setBgls12Discount(boolean bgls12Discount) {
        isBgls12Discount = bgls12Discount;
    }

    public boolean isBgls6Discount() {
        return isBgls6Discount;
    }

    public void setBgls6Discount(boolean bgls6Discount) {
        isBgls6Discount = bgls6Discount;
    }

    public boolean isCoffeeAndBagelPromo() {
        return isCoffeeAndBagelPromo;
    }

    public void setCoffeeAndBagelPromo(boolean coffeeAndBagelPromo) {
        isCoffeeAndBagelPromo = coffeeAndBagelPromo;
    }


    public int getCofw() {
        return cofw;
    }

    public void setCofw(int cofw) {
        this.cofw = cofw;
    }

    public int getCofb() {
        return cofb;
    }

    public void setCofb(int cofb) {
        this.cofb = cofb;
    }

    public int getCofc() {
        return cofc;
    }

    public void setCofc(int cofc) {
        this.cofc = cofc;
    }

    public int getCofl() {
        return cofl;
    }

    public void setCofl(int cofl) {
        this.cofl = cofl;
    }

    public int getFilb() {
        return filb;
    }

    public void setFilb(int filb) {
        this.filb = filb;
    }

    public int getFilc() {
        return filc;
    }

    public void setFilc(int filc) {
        this.filc = filc;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getFilh() {
        return filh;
    }

    public void setFilh(int filh) {
        this.filh = filh;
    }

    public int getFils() {
        return fils;
    }

    public void setFils(int fils) {
        this.fils = fils;
    }

    public int getFilx() {
        return filx;
    }

    public void setFilx(int filx) {
        this.filx = filx;
    }
}
