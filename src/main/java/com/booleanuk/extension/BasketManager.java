package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

public class BasketManager {


    private BasketExt basketExt;
    private InventoryExt inventoryExt;


    public BasketManager(BasketExt basketExt,InventoryExt inventoryExt) {
        this.basketExt = basketExt;
        this.inventoryExt = inventoryExt;

    }


    public BasketExt getBasketExt() {
        return basketExt;
    }


    public boolean add(BagelExt bagelExt) {

        if (checkIsBasketFull()) {
            basketExt.add(bagelExt);
            return true;
        } else {
            System.out.println("Basket is full!");
            return false;
        }


    }
    public boolean add(CoffeeExt coffeeExt) {
        if (checkIsBasketFull()) {
            basketExt.add(coffeeExt);
            return true;
        } else {
            System.out.println("Basket is full!");
            return false;
        }
    }
    public boolean add(FillingExt fillingExt) {
        if (checkIsBasketFull()) {
            basketExt.add(fillingExt);
            return true;

        } else {
            System.out.println("Basket is full!");
            return false;
        }
    }

    public boolean remove(BagelExt bagelExt) {
        if(checkSanity(bagelExt)) {
            basketExt.remove(bagelExt);
            return true;
            }
        return false;
    }
    public boolean remove(FillingExt fillingExt) {
        if(checkSanity(fillingExt)) {

            basketExt.remove(fillingExt);
            return true;
            }
        return false;
    }
    public boolean remove(CoffeeExt coffeeExt) {
        if(checkSanity(coffeeExt)) {
            basketExt.remove(coffeeExt);
            return true;
        }
        return false;
    }

    private boolean checkIsBasketFull(){
        int occupiedCapacity = basketExt.getBagelsInBasket().size() + basketExt.getCoffeesInBasket().size() + basketExt.getFillingInBasket().size();
        return occupiedCapacity < basketExt.getCapacity();

    }

    private boolean checkSanity(CoffeeExt coffeeExt){
        return basketExt.getCoffeesInBasket().contains(coffeeExt);
    }
    private boolean checkSanity(FillingExt fillingExt){
        return basketExt.getFillingInBasket().contains(fillingExt);
    }
    private boolean checkSanity(BagelExt bagelExt){
        return basketExt.getBagelsInBasket().contains(bagelExt);
    }


    public double getTotalCost() {
        System.out.println(basketExt.getTotalCostBagel() );
        System.out.println(basketExt.getTotalCostFillings());
        System.out.println(basketExt.getTotalCostCoffee());
        return  basketExt.getTotalCostBagel() + basketExt.getTotalCostFillings() + basketExt.getTotalCostCoffee();
    }

    public void addFillingToBagel(BagelExt bagelExt, FillingExt fillingExt){
        bagelExt.setFillingExt(fillingExt);
    }

    public String getPriceListOfFillings(){
        StringBuilder sb = new StringBuilder("Fillings Pricelist:\n");
        for (FillingExt fillingExt :
                inventoryExt.getAllFilingsInInventory()) {
            sb.append("Name:").append(fillingExt.getSku().name()).append(" ").append(fillingExt.getSku().getVariant()).append(" Price: ").append(fillingExt.getPrice()).append("\n");
        }

        return sb.toString();
    }

    public String getPriceListOfBagels(){
        StringBuilder sb = new StringBuilder("Bagels Pricelist:\n");
        for (BagelExt bagelExt :
                inventoryExt.getAllBagelsInInventory()) {
            sb.append("Name:").append(bagelExt.getSku().name()).append(" ").append(bagelExt.getSku().getVariant()).append(" Price: ").append(bagelExt.getPrice()).append("\n");
        }

        return sb.toString();
    }


}
