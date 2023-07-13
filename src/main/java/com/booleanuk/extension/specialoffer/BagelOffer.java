package com.booleanuk.extension.specialoffer;

import com.booleanuk.extension.bagel.Bagel;
import com.booleanuk.extension.bagel.Filling;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Getter
public class BagelOffer implements SpecialOffer {
    private final Type offerType;
    private final List<Bagel> bagels;

    private BagelOffer(Bagel... bagels) {
        // TODO validation of amount and type of bagels (check if they conform to existing promotions)
        this.bagels = List.of(bagels);
        this.offerType = switch (bagels[0].type()) {
            case BGLO -> Type.SixOnion;
            case BGLP -> Type.TwelvePlain;
            case BGLE -> Type.SixEverything;
            default -> throw new IllegalStateException("Unexpected value: " + bagels[0].type());
        };
    }

    public static BagelOffer of(Bagel... bagels) {
        return new BagelOffer(bagels);
    }

    @Override
    public BigDecimal getPrice() {
        var price = offerType.getPrice();

        return bagels.stream()
                .map(Bagel::fillings)
                .flatMap(Arrays::stream)
                .map(Filling::getPrice)
                .reduce(price, BigDecimal::add);
    }

    @RequiredArgsConstructor
    @Getter
    public enum Type {
        SixOnion(BigDecimal.valueOf(2.49)),
        TwelvePlain(BigDecimal.valueOf(3.99)),
        SixEverything(BigDecimal.valueOf(2.49));

        private final BigDecimal price;
    }
}
