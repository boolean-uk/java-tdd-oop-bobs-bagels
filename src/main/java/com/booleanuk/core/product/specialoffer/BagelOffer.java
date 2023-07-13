package com.booleanuk.core.product.specialoffer;

import com.booleanuk.core.product.bagel.Bagel;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class BagelOffer implements SpecialOffer {
    private final List<Bagel> bagels;

    private BagelOffer(Bagel... bagels) {
        this.bagels = List.of(bagels);
    }

    public static BagelOffer of(Bagel... bagels) {
        return new BagelOffer(bagels);
    }

    @Override
    public BigDecimal getPrice() {
        // TODO
        return null;
    }
}
