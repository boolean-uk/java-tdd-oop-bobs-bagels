package com.booleanuk.core.inherited;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.factory.ProductFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bagel extends Product {
    private ArrayList<Filling> fillings;
    private Map<FillingType, Double> fillingsPrices;

    public Bagel(String name, Double price, SKU sku, BagelType variant, ArrayList<Filling> fillings) {
        super(name, price, sku, variant);
        this.fillings = fillings != null ? fillings : new ArrayList<>();
    }

    // Only used to get an overview of the filling prices.
    public Bagel() {
        super();
        this.fillingsPrices = new HashMap<>();
        addFillingPrices();
    }

    public Bagel createBagelWithFilling(BagelType variant, FillingType... fillings) {
        Bagel.BagelBuilder builder = new Bagel.BagelBuilder(variant);
        for (FillingType filling : fillings) {
            builder.addFilling(filling);
        }
        return builder.build();
    }

    public Double getFillingPrice(FillingType variant) {
        return this.fillingsPrices.get(variant);
    }

    public static class BagelBuilder {
        private BagelType variant;
        private ArrayList<Filling> fillings = new ArrayList<>();
        private ProductFactory factory = new ProductFactory();

        public BagelBuilder(BagelType variant) {
            this.variant = variant;
        }

        public BagelBuilder addFilling(FillingType type) {
            Filling filling = (Filling) factory.getProduct(type);
            this.fillings.add(filling);

            return this;
        }

        public Bagel build() {
            Product bagel = factory.getProduct(this.variant);
            return new Bagel(
                    bagel.getName(),
                    bagel.getPrice(),
                    bagel.getSku(),
                    this.variant,
                    this.fillings
            );
        }
    }

    private void addFillingPrices() {
        double price = 0.12;
        this.fillingsPrices.put(FillingType.BACON, price);
        this.fillingsPrices.put(FillingType.EGG, price);
        this.fillingsPrices.put(FillingType.HAM, price);
        this.fillingsPrices.put(FillingType.CHEESE, price);
        this.fillingsPrices.put(FillingType.CREAM_CHEESE, price);
        this.fillingsPrices.put(FillingType.SMOKED_SALMON, price);
    }

    public ArrayList<Filling> getFillings() {
        return fillings;
    }
}
