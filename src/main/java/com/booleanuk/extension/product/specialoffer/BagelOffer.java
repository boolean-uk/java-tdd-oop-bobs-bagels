package com.booleanuk.extension.product.specialoffer;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Getter
public class BagelOffer implements SpecialOffer {
    private final Product.Type productType;
    private final SpecialOffer.Type offerType;
    private final BagelOffer.Type bagelOfferType;
    private final List<BagelSandwich> bagels;

    private BagelOffer(BagelSandwich... bagels) {
        // TODO validation of amount and type of bagels (check if they conform to existing promotions)
        this.productType = Product.Type.SpecialOffer;
        this.offerType = SpecialOffer.Type.BagelOffer;
        this.bagels = List.of(bagels);
        this.bagelOfferType = switch (bagels[0].getBagel()) {
            case BGLO -> BagelOffer.Type.SixOnion;
            case BGLP -> BagelOffer.Type.TwelvePlain;
            case BGLE -> BagelOffer.Type.SixEverything;
            default -> throw new IllegalStateException("Unexpected value: " + bagels[0].getBagel());
        };
    }

    public static BagelOffer of(BagelSandwich... bagels) {
        return new BagelOffer(bagels);
    }

    @Override
    public BigDecimal getPrice() {
        var price = bagelOfferType.getPrice();

        return bagels.stream()
                .map(BagelSandwich::getFillings)
                .flatMap(Arrays::stream)
                .map(BagelSandwich.Filling::getPrice)
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
