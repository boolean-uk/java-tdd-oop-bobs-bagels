package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {
        public ArrayList<Product> bagelBasket;

        public Basket() {
            this.bagelBasket = new ArrayList<>();
        }

        public void addItem(Product product) {
            bagelBasket.add(product);
             }

        public void removeItem(Product product) {
            bagelBasket.remove(product);

        }

        public double calculateTotalCost(Inventory inventory) {

            return 0;
        }

}
