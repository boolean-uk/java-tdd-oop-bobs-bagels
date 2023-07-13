package com.booleanuk.core;

import com.booleanuk.extension.Discount;
import com.booleanuk.extension.DiscountInventory;
import com.booleanuk.extension.Receipt;
import com.booleanuk.extension.ReceiptLine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Basket {
    private int capacity;
    private Map<Item, Integer> shoppingList;

    public Basket(int capacity) {
        shoppingList = new HashMap<>();
        this.capacity = capacity;
    }

    public void add(String name, String variant) {
        if (!isBasketFull()) {
            Optional<Item> optional = Inventory.searchInventory(name, variant);
            optional.ifPresentOrElse(item -> this.shoppingList.put(item, this.shoppingList.getOrDefault(item, 0) + 1),
                    () -> System.out.println("Item not found in inventory"));
        } else {
            System.out.println("Basket is full.");
        }
    }

    public void remove(String name, String variant) {
        Optional<Item> optional = Inventory.searchInventory(name,variant);
        optional.ifPresentOrElse(item -> {
            if(isInBasket(name, variant)) {
                int quantity = this.shoppingList.get(item);

                if (quantity > 1) this.shoppingList.put(item, quantity - 1);
                else this.shoppingList.remove(item);

            }else{
                System.out.println("Item not found in basket");
            }
        },() -> System.out.println("Item not found in inventory"));
    }

    public boolean isInBasket(String name, String variant){
        return this.shoppingList.
                entrySet().
                stream().
                filter(entry -> entry.getKey().getName().equals(name) && entry.getKey().getVariant().equals(variant)).
                anyMatch(item ->true);
    }
    public void changeCapacity(int capacity){
        if (capacity<= 0) System.out.println("Capacity cannot be less than 1.");
        else if (capacity < shoppingList.size()) {
            System.out.println("Capacity cannot be smaller than no. of items in basket.");
        } else {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBasketFull() {
        return shoppingList.size() == capacity;
    }

    public BigDecimal totalPrice(){
        Receipt receipt = mapShoppingListToReceipt();

        return receipt
                .getProducts()
                .stream()
                .map(ReceiptLine::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Item getShoppingListItem(String SKU) {
        return shoppingList.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getSKU().equals(SKU))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Receipt mapShoppingListToReceipt(){
        Receipt receipt = new Receipt();
        //calculate bagel coffee sets
        int plainBagelAmount = countProductType("BGLP");
        int blackCoffee = countProductType("COFB");
        if (blackCoffee > 0 && plainBagelAmount > 0) {
            int bagelCoffeeSet = Math.min(plainBagelAmount, blackCoffee);

            //update the amounts in shoppingList
            shoppingList.put(getShoppingListItem("BGLP"), plainBagelAmount - bagelCoffeeSet);
            shoppingList.put(getShoppingListItem("COFB"), blackCoffee - bagelCoffeeSet);
            //add special coffee offer to the receipt
            receipt.addProduct(new ReceiptLine(getShoppingListItem("COFB"), BigDecimal.valueOf(bagelCoffeeSet), BigDecimal.valueOf(bagelCoffeeSet).multiply(BigDecimal.valueOf(1.25))));
        }

        for (Map.Entry<Item, Integer> entry : shoppingList.entrySet()) {
            Item item  = entry.getKey();
            BigDecimal quantity = new BigDecimal(entry.getValue());
            if (item.getSKU().contains("BGL")) {
                Discount discount = DiscountInventory.searchDiscount(item.getSKU());
                if (discount != null) {
                    BigDecimal discountedSetsAmount = quantity.divide(BigDecimal.valueOf(discount.quantity()), RoundingMode.DOWN);
                    BigDecimal remainingAmountRegularPriceAmount = quantity.remainder(BigDecimal.valueOf(discount.quantity()));

                    BigDecimal price = (discount.price().multiply(discountedSetsAmount).add(remainingAmountRegularPriceAmount.multiply(item.getPrice())));
                    receipt.addProduct(new ReceiptLine(item, quantity, price));
                } else {
                    receipt.addProduct(new ReceiptLine(item, quantity, item.getPrice().multiply(quantity)));
                }
            } else receipt.addProduct(new ReceiptLine(item, quantity, item.getPrice().multiply(quantity)));
        }
        return receipt;
    }

    private int countProductType(String SKU){
        return shoppingList.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getSKU().equals(SKU))
                .map(Map.Entry::getValue)
                .mapToInt(Integer::intValue).sum();
    }

    public Map<Item, Integer> getShoppingList() {
        return this.shoppingList;
    }
}
