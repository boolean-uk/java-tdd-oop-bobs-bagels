package com.booleanuk.core.inherited;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.factory.ProductFactory;

import java.util.ArrayList;

public class Bagel extends Product {
    private ArrayList<Filling> fillings;

    public Bagel(String name, Double price, SKU sku, BagelType variant, ArrayList<Filling> fillings) {
        super(name, price, sku, variant);
        this.fillings = fillings != null ? fillings : new ArrayList<>();
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

    public ArrayList<Filling> getFillings() {
        return fillings;
    }
}
