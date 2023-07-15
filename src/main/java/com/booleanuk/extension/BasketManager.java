package com.booleanuk.extension;

public class BasketManager {


    private BasketExt basketExt;
    private InventoryExt inventoryExt;
    private  DiscountCreator discountCreator;


    public BasketManager(BasketExt basketExt, InventoryExt inventoryExt, DiscountCreator discountCreator) {
        this.basketExt = basketExt;
        this.inventoryExt = inventoryExt;
        this.discountCreator = discountCreator;

    }


    public BasketExt getBasketExt() {
        return basketExt;
    }


    public boolean add(BagelExt bagelExt) {
        if (isNotProductInInventory(bagelExt)) {
            if (checkIsBasketFull()) {
                basketExt.add(bagelExt);
                return true;
            } else {
                System.out.println("Basket is full!");
                return false;
            }
        }
        System.out.println("Product does not exist in the inventory!");
        return false;


    }

    private boolean isNotProductInInventory(BagelExt bagelExt) {
        for (BagelExt bagelExt1 :
                inventoryExt.getAllBagelsInInventory()) {
            if (bagelExt1.getSku() == bagelExt.getSku())
                return true;
        }
        return false;
    }

    public boolean add(CoffeeExt coffeeExt) {
        if (isNotProductInInventory(coffeeExt)) {
            if (checkIsBasketFull()) {
                basketExt.add(coffeeExt);
                return true;
            } else {
                System.out.println("Basket is full!");
                return false;
            }
        }
        System.out.println("Product does not exist in the inventory!");
        return false;
    }

    private boolean isNotProductInInventory(CoffeeExt coffeeExt) {
        for (CoffeeExt coffeeExt1 :
                inventoryExt.getAllCoffeesInInventory()) {
            if (coffeeExt1.getSku() == coffeeExt.getSku())
                return true;
        }
        return false;

    }
    private boolean isNotProductInInventory(FillingExt fillingExt) {
        for (FillingExt fillingExt1 :
                inventoryExt.getAllFilingsInInventory()) {
            if (fillingExt1.getSku() == fillingExt.getSku())
                return true;
        }
        return false;
    }

    public boolean add(FillingExt fillingExt) {
        if (isNotProductInInventory(fillingExt)) {
            if (checkIsBasketFull()) {
                basketExt.add(fillingExt);
                return true;

            } else {
                System.out.println("Basket is full!");
                return false;
            }
        }
        System.out.println("Product does not exist in the inventory!");
        return false;

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
