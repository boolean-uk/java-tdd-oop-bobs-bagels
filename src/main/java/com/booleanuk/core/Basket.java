package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class Basket {
        private int capacity;
        private Map<InventoryItem, Integer> bagels;

        public Basket(int capacity) {
            this.capacity = capacity;
            this.bagels = new HashMap<>();
            fillList();
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            if (capacity > 0) {
                this.capacity = capacity;
            }
        }

        public Map<InventoryItem, Integer> getBagels() {
            return bagels;
        }

        public void removeBagel(InventoryItem bagel) {
            int currentQuantity = bagels.getOrDefault(bagel, 0);
            if (currentQuantity > 0) {
                bagels.put(bagel, currentQuantity - 1);
            } else {
                System.out.println("Bagel " + bagel.getSku() + " not found in the basket.");
            }
        }

        public boolean basketFull() {
            int totalQuantity = bagels.values().stream().mapToInt(Integer::intValue).sum();
            return totalQuantity >= capacity;
        }

        public double calculateTotalCost() {
            double totalCost = 0;

            for (Map.Entry<InventoryItem, Integer> entry : bagels.entrySet()) {
                InventoryItem item = entry.getKey();
                int quantity = entry.getValue();
                totalCost += item.getPrice() * quantity;
            }

            return totalCost;
        }

        public double calculateBagelCost(InventoryItem bagel) {
            return bagel.getPrice();
        }
        public boolean addBagelWithFillings(InventoryItem bagel, List<InventoryItem> fillings) {
            if (!basketFull() && isBagelAvailableInInventory(bagel)) {
                double bagelCost = bagel.getPrice();

                System.out.println("Bagel " + bagel.getSku() + " - " + bagel.getName() + " - $" + bagelCost);

                for (InventoryItem filling : fillings) {
                    double fillingCost = filling.getPrice();
                    System.out.println("  Filling " + filling.getSku() + " - " + filling.getName() + " - $" + fillingCost);
                    bagelCost += fillingCost;
                }

                System.out.println("Total Cost: $" + bagelCost);
                bagels.put(bagel, bagels.getOrDefault(bagel, 0) + 1);
                return true;
            } else if (basketFull()) {
                System.out.println("Basket full");
            } else {
                System.out.println("Bagel " + bagel.getSku() + " not available in inventory");
            }

            return false;
        }



         boolean isBagelAvailableInInventory(InventoryItem bagel) {
            return bagel.getStock() > 0;
        }
        private void fillList() {
            InventoryItem[] items = {
                    new InventoryItem("BGLO", 0.49, "Bagel", "Onion", 10),
                    new InventoryItem("BGLP", 0.39, "Bagel", "Plain", 20),
                    new InventoryItem("BGLE", 0.49, "Bagel", "Everything", 15),
                    new InventoryItem("BGLS", 0.49, "Bagel", "Sesame", 25),
                    new InventoryItem("COFB", 0.99, "Coffee", "Black", 30),
                    new InventoryItem("COFW", 1.19, "Coffee", "White", 40),
                    new InventoryItem("COFC", 1.29, "Coffee", "Cappuccino", 35),
                    new InventoryItem("COFL", 1.29, "Coffee", "Latte", 20),
                    new InventoryItem("FILB", 0.12, "Filling", "Bacon", 50),
                    new InventoryItem("FILE", 0.12, "Filling", "Egg", 60),
                    new InventoryItem("FILC", 0.12, "Filling", "Cheese", 40),
                    new InventoryItem("FILX", 0.12, "Filling", "Cream Cheese", 30),
                    new InventoryItem("FILS", 0.12, "Filling", "Smoked Salmon", 25),
                    new InventoryItem("FILH", 0.12, "Filling", "Ham", 35)
            };

            for (InventoryItem item : items) {
                bagels.put(item, 0);
            }
        }


    }
