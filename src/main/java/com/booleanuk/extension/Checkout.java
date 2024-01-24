package com.booleanuk.extension;

public class Checkout {
    Stock stock;
    ReciptPrinter rp = new ReciptPrinter();

    public Checkout(Stock stock) {
        this.stock = stock;
    }

    public double sumPrice(Basket basket) {
        double totalCost = 0;
        for(Product product : basket.getInventory()) {
            totalCost += product.getPrice();
        }
        return RoundDouble.round(totalCost, 2);
    }

    /* I have the impression that downcasting like im doing here is bad practice and a sign of a poorly planned
    program. I think making my Bagel class have fillings might have been a mistake, and it would have been better to
    have an ArrayList<Product> subitems in the Product class. I think this could have been useful in multiple cases as
    it is fairly likely other products could have subitems and i wouldn't need downcasting to make sure my program works.
    I guess forethought is a skill developed through experience. At least i learned that downcasting is a thing.
    * */
    public boolean order(Basket basket) {
        for(Product product : basket.getInventory()) {

            if (product instanceof Bagel) { // Messy
                Bagel bagel = (Bagel) product;
                for(Filling filling : bagel.getFillings()) {
                    if(!this.stock.inInventory(filling)) {
                        return false;
                    }
                }
                if(!this.stock.inInventory(new Bagel(bagel.getVariant(), bagel.getBasePrice()))) {
                    return false;
                }
            } else if(!stock.inInventory(product)) {
                System.out.println(product.getName());

                return false;

            }
        }
        this.rp.printRecipt(basket, sumPrice(basket));
        return true;
    }
}
