package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    ArrayList<Item> items;
    protected int capacity = 30;
    HashMap<SKU, Integer> quantityMap;

    public Basket() {
        items = new ArrayList<>();
    }

    public boolean addItem(SKU sku) {

        // if no capacity, return false
        if(items.size() >= capacity) {
            basketIsFullMessage();
            return false;
        }

        // add Bagel
        if(sku == SKU.BGLE || sku == SKU.BGLO || sku == SKU.BGLP || sku == SKU.BGLS) {
            items.add(new Bagel(sku));
        }
        // add Coffee
        else if (sku == SKU.COFB || sku == SKU.COFW || sku == SKU.COFC || sku == SKU.COFL) {
            items.add(new Coffee(sku));
        }
        // add Filling
        else if(sku == SKU.FILB || sku == SKU.FILC || sku == SKU.FILE ||
                sku == SKU.FILH || sku == SKU.FILS || sku == SKU.FILX) {
            items.add(new Filling(sku));
        }
        // SKU not recognized, return false
        else {
            System.out.println("SKU doesn't exist in catalog.");
            return false;
        }
        return true;
    }

    boolean removeItem(SKU SKU) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).SKU == SKU) {
                items.remove(i);
                return true;
            }
        }
        itemNotInBasket();
        return false;
    }

    public void basketIsFullMessage() {
        System.out.println("Basket is full.");
    }

    public void itemNotInBasket() {
        System.out.println("Couldn't find that item in your basket.");
    }

    public float calculateCost() {
        float totalCost = 0F;
        for(Item item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public boolean setCapacity(int capacity) {
        if(capacity > 0) {
            this.capacity = capacity;
            return true;
        }
        System.out.println("Invalid capacity entered.");
        return false;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public StringBuilder getReceipt() {
        this.quantityMap = new HashMap<>();
        for(Item i : items) {
            Integer counter = quantityMap.get(i.getSKU());
            if(counter == null) {
                counter = 0;
            }
            quantityMap.put(i.getSKU(), counter+1 );
        }
        System.out.println(quantityMap);

        StringBuilder receipt = new StringBuilder();
        float totalCost = 0F;

        receipt.append("\t~~~ Bob's Bagels ~~~\n");
        receipt.append(" --------------------------\n\n");

        // calculate discount for bagels
        for(SKU k : quantityMap.keySet()) {
            if(k == SKU.BGLE || k == SKU.BGLP || k == SKU.BGLS || k == SKU.BGLO) {
                // Calculate 12x discount for a bagel
                while(quantityMap.get(k) >= 12) {
                    Bagel refBagel = new Bagel(k);
                    totalCost += 3.99F;
                    receipt.append(refBagel.getVariant() + " " + refBagel.getName() + "\t\t\t" + 12 + "\t£3.99\n");
                    quantityMap.put(k, quantityMap.get(k) - 12);
                }

                // calculate 6x discount for a bagel
                while(quantityMap.get(k) >= 6) {
                    Bagel refBagel = new Bagel(k);
                    totalCost += 2.49F;
                    receipt.append(refBagel.getVariant() + " " + refBagel.getName() + "\t\t\t" + 6 + "\t£2.49\n");
                    quantityMap.put(k, quantityMap.get(k) - 6);
                }
            }
        }

        // calculate discount for "Bagel and Coffee"
        for(SKU k : quantityMap.keySet()) {
            if(k == SKU.COFB || k == SKU.COFC || k == SKU.COFL || k == SKU.COFW) {
                Coffee refCoffee = new Coffee(k);

                while(quantityMap.get(k) > 0) {
                    if (quantityMap.containsKey(SKU.BGLE) && quantityMap.get(SKU.BGLE) > 0) {
                        totalCost += 1.25F;
                        receipt.append("Coffee + Bagel\t\t" + 1 + "\t£1.25\n");
                        quantityMap.put(k, quantityMap.get(k) - 1);
                        quantityMap.put(SKU.BGLE, quantityMap.get(SKU.BGLE) - 1);
                    }
                    else if (quantityMap.containsKey(SKU.BGLO) && quantityMap.get(SKU.BGLO) > 0) {
                        totalCost += 1.25F;
                        receipt.append("Coffee + Bagel\t\t" + 1 + "\t£1.25\n");
                        quantityMap.put(k, quantityMap.get(k) - 1);
                        quantityMap.put(SKU.BGLO, quantityMap.get(SKU.BGLO) - 1);
                    }
                    else if (quantityMap.containsKey(SKU.BGLS) && quantityMap.get(SKU.BGLS) > 0) {
                        totalCost += 1.25F;
                        receipt.append("Coffee + Bagel\t\t" + 1 + "\t£1.25\n");
                        quantityMap.put(k, quantityMap.get(k) - 1);
                        quantityMap.put(SKU.BGLS, quantityMap.get(SKU.BGLS) - 1);
                    }
                    else if (quantityMap.containsKey(SKU.BGLP) && quantityMap.get(SKU.BGLP) > 0) {
                        totalCost += 1.25F;
                        receipt.append("Coffee + Bagel\t\t" + 1 + "\t£1.25\n");
                        quantityMap.put(k, quantityMap.get(k) - 1);
                        quantityMap.put(SKU.BGLP, quantityMap.get(SKU.BGLP) - 1);
                    }
                    else {
                        totalCost += refCoffee.getPrice() * quantityMap.get(k);
                        receipt.append(refCoffee.getVariant() + " " + refCoffee.getName() + "\t\t"
                                + quantityMap.get(k) + "\t£" + (refCoffee.getPrice() * quantityMap.get(k)) + "\n");
                        quantityMap.put(k, 0);
                    }
                }
            }
        }

        for(SKU k : quantityMap.keySet()) {
            Item refItem;
            if(k == SKU.BGLE || k == SKU.BGLO || k == SKU.BGLP || k == SKU.BGLS) {
                refItem = new Bagel(k);
            }
            else if(k == SKU.COFB || k == SKU.COFC || k == SKU.COFL || k == SKU.COFW) {
                refItem = new Coffee(k);
            }
            else {
                refItem = new Filling(k);
            }

            if(quantityMap.get(k) > 0) {
                float cost = refItem.getPrice() * quantityMap.get(k);
                totalCost += cost;
                receipt.append(refItem.getVariant() + " " + refItem.getName() + "\t\t" + quantityMap.get(k) + "\t£" + cost + "\n");
                quantityMap.put(k, 0);
            }
        }
        receipt.append("\n --------------------------");
        receipt.append("\nTotal cost:\t\t\t\t£" + totalCost);

        return receipt;

    }
}
