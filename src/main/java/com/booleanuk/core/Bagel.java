package com.booleanuk.core;

public class Bagel extends Product{
    
    private Product filling = null;

    public Bagel(String sku, double price, String name, String variant){
        super(sku, price, name, variant);
    }
    
    
    public Bagel(String sku, double price, String name, String variant, Product filling){
        super(sku, price, name, variant);
        this.filling = filling;
    }

    public Product getFilling() {
        return filling;
    }

    public String chooseFilling(Product filling) {
        if(filling.getName().equals("Filling")){
            this.setPrice(this.getPrice() + filling.getPrice());
            this.filling = filling;
            return "Filling added to bagel";
        }
        else{ return "Category of product is not \"Filling\""; }
    }

    public String chooseFilling(String variant) {
        Inventory inventory = new Inventory();
        Product filling = inventory.getProductByNameAndVariant("Filling", variant);
        if(filling != null){
            this.setPrice(this.getPrice() + filling.getPrice());
            this.filling = filling;
            return "Filling added to bagel";
        }
        else{ return "Variant does not exist"; }
    }

}
