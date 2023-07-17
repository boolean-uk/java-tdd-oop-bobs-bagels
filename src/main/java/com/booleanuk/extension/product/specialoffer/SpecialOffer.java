package com.booleanuk.extension.product.specialoffer;

import com.booleanuk.extension.product.Product;

public interface SpecialOffer extends Product {
    SpecialOffer.Type getOfferType();

    public enum Type {
        BagelOffer,
        BreakfastOffer
    }
}
