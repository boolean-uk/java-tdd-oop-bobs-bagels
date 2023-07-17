package com.booleanuk.core;

import com.booleanuk.core.types.BagelType;
import com.booleanuk.core.types.FillingType;

public class Bagel extends Item {
    private BagelType bagelType;
    private FillingType fillingType;

    public Bagel(BagelType bagelType, FillingType fillingType) {
        this.bagelType = bagelType;
        this.fillingType = fillingType;
        this.price = bagelType.getPrice() + fillingType.getPrice();
    }

    public BagelType getBagelType() {
        return bagelType;
    }


    public FillingType getFillingType() {
        return fillingType;
    }
}
