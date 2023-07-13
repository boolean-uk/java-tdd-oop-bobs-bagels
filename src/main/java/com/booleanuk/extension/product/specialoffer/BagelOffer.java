package com.booleanuk.extension.product.specialoffer;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BagelOffer implements SpecialOffer {
    private final Product.Type productType;
    private final SpecialOffer.Type offerType;
    private final BagelOffer.Type bagelOfferType;
    private final List<BagelSandwich> sandwiches;

    private BagelOffer(BagelSandwich... sandwiches) {
        validateSandwiches(sandwiches);
        this.productType = Product.Type.SpecialOffer;
        this.offerType = SpecialOffer.Type.BagelOffer;
        this.sandwiches = List.of(sandwiches);
        this.bagelOfferType = switch (sandwiches[0].getBagel()) {
            case BGLO -> BagelOffer.Type.SixOnion;
            case BGLP -> BagelOffer.Type.TwelvePlain;
            case BGLE -> BagelOffer.Type.SixEverything;
            default -> throw new IllegalStateException("Unexpected value: " + sandwiches[0].getBagel());
        };
    }

    public static BagelOffer of(BagelSandwich... bagels) {
        return new BagelOffer(bagels);
    }

    @Override
    public BigDecimal getPrice() {
        var price = bagelOfferType.getPrice();

        return sandwiches.stream()
                .map(BagelSandwich::getFillings)
                .flatMap(Arrays::stream)
                .map(BagelSandwich.Filling::getPrice)
                .reduce(price, BigDecimal::add);
    }

    private void validateSandwiches(BagelSandwich... bagels) {
        // check for correct amount of bagels
        if (bagels.length != 6 && bagels.length != 12) {
            throw new IllegalArgumentException(String.format("There is no special offer for this bagel combination: %s", Arrays.toString(bagels)));
        }
        // check if all bagels are the same type
        var bagelTypes = Arrays.stream(bagels)
                .map(BagelSandwich::getBagel)
                .collect(Collectors.toSet());
        if (bagelTypes.size() > 1) {
            throw new IllegalArgumentException("All sandwiches in a special offer must have the same bagel");
        }
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
