package com.booleanuk.core;

    public class InventoryItem {
            private String sku;
            private double price;
            private String name;
            private String variant;
            private int stock;  // Adding stock to track inventory

            public InventoryItem(String sku, double price, String name, String variant, int stock) {
                this.sku = sku;
                this.price = price;
                this.name = name;
                this.variant = variant;
                this.stock = stock;
            }

            public String getSku() {
                return sku;
            }

            public double getPrice() {
                return price;
            }

            public String getName() {
                return name;
            }

            public String getVariant() {
                return variant;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }
        }


