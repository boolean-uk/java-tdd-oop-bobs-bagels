package com.booleanuk.core;

public class ItemFactory {

    public static Coffee coffeeFactory(String sku) {
        ItemList itemlist = new ItemList();
        String itemType = itemlist.getTypeFromList(sku);
        if(itemType.equals("Coffee")) {
            return new Coffee(sku);
        }else if(!itemType.contains(sku))
            return null;
        return null;
    }

    public static Filling fillingFactory(String sku) {
        ItemList itemlist = new ItemList();
        String itemType = itemlist.getTypeFromList(sku);
        if(itemType.equals("Filling")) {
            return new Filling(sku);
        }else if(!itemType.contains(sku))
            return null;
        return null;
    }

    public static Bagel bagelFactory(String sku) {
        ItemList itemlist = new ItemList();
        String itemType = itemlist.getTypeFromList(sku);
        if(itemType == null) {
            return null;
        }
        if(itemType.equals("Bagel")) {
            return new Bagel(sku);
        }
        return null;
    }

    public static Bagel bagelWithFillingFactory(String sku, String fillingSKU){
        ItemList itemList = new ItemList();
        String bagelType = itemList.getTypeFromList(sku);
        String fillingType = itemList.getTypeFromList(fillingSKU);

        if(bagelType == null ||fillingType == null) {
            return null;
        }

        if(bagelType.equals("Bagel") && fillingType.equals("Filling")) {
            Filling filling = fillingFactory(fillingSKU);
            return new Bagel(sku, filling);
        }else if(!bagelType.contains(sku) || fillingType.contains(sku))
            return null;
        return null;
    }
}
