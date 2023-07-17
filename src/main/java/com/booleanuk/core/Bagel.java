package com.booleanuk.core;

public class Bagel extends Product{
    
    private Filling filling = null;

    public Bagel(String sku, double price, String name, String variant){
        super(sku, price, name, variant);
    }
    
    
    public Bagel(String sku, double price, String name, String variant, Filling filling){
        super(sku, price, name, variant);
        this.filling = filling;
    }

    public Bagel(Product product){
        super(product.sku, product.price, product.name, product.variant);
    }

    public Product getFilling() {
        return filling;
    }

    public String chooseFilling(Filling filling) {
        if(filling.name.equals("Filling")){
            this.price = this.price + filling.price;
            this.filling = filling;
            return "Filling added to bagel";
        }
        else{ return "Category of product is not \"Filling\""; }
    }

    public String chooseFilling(String variant) {
        Inventory inventory = new Inventory();
        Filling filling = (Filling) inventory.getProductByNameAndVariant("Filling", variant);
        if(filling != null){
            this.price = this.price + filling.price;
            this.filling = filling;
            return "Filling added to bagel";
        }
        else{ return "Variant does not exist"; }
    }

    @Override
    public String toString() {
        return "Bagel{" +
                "filling=" + filling +
                '}';
    }
}
