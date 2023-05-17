package com.booleanuk.core;

import java.util.ArrayList;

enum CODE {
    NOCODE,
    NOTFOUND,
    NOTAVAILABLE,
    MAXCAPACITY,
    NOQUANTITY

}

public class Basket {
    final private ArrayList<Item> items;
    final private ArrayList<Integer> quantitys;
    private int capacity = 3;
    private CODE code;

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Integer> getQuantity() {
        return quantitys;
    }

    public int getCapacity() {
        return capacity;
    }

    public CODE getCode() {
        return code;
    }

    public Basket() {
        this.items = new ArrayList<>(capacity);
        this.quantitys = new ArrayList<>(capacity);
        this.code = CODE.NOCODE;
    }

    public boolean setCapacity(int capacity) {
        int size = quantitys.stream().reduce(0, Integer::sum);
        if (size > capacity || capacity == 0) {
            code = CODE.MAXCAPACITY;
            return false;
        }
        code = CODE.NOCODE;
        this.capacity = capacity;
        return true;
    }

    public boolean add(Item item, int quantity) {
        if (quantity < 0) {
            code = CODE.NOQUANTITY;
            return false;
        }
        int size = quantitys.stream().reduce(0, Integer::sum);
        //Check if it can go into the basket
        if (size + quantity > capacity) {
            code = CODE.MAXCAPACITY;
            return false;
        }
        //Check if the item is in the invetory
        if (!item.getAvailable()) {
            code = CODE.NOTAVAILABLE;
            return false;
        }
        //Check if the item already in the basket
        if (items.contains(item)) {
            int position = items.indexOf(item);
            int previousQuantity = quantitys.get(position);
            code = CODE.NOCODE;
            quantitys.set(position, previousQuantity + quantity);
            return true;
        }
        // if the item is new
        code = CODE.NOCODE;
        items.add(item);
        quantitys.add(quantity);
        return true;
    }

    public boolean remove(Item item, int quantity) {
        if (quantity < 0) {
            return false;
        }
        int position = items.indexOf(item);
        if (position == -1) {
            code = CODE.NOTFOUND;
            return false;
        }

        int previousQuantity = quantitys.get(position);
        if (previousQuantity < quantity) {
            code = CODE.NOTAVAILABLE;
            return false;
        } else if (previousQuantity == quantity) {
            items.remove(position);
            quantitys.remove(position);
        } else {
            quantitys.set(position, previousQuantity - quantity);
        }
        code = CODE.NOCODE;
        return true;


    }

    public double getTotalWithoutDiscount() {
        double total = 0;
        total = getLeftOverPrice(quantitys, total);
        return total;
    }

    public double getTotalWithDiscount() {
        ArrayList<Integer> quantitysAfterDiscount = new ArrayList<>();
        double total = 0;
        // this get the bagel discount 6-12 and the fillings
        total = getBagelDiscount(quantitysAfterDiscount, total);
        //this is for the coffee+bagel
        total = getCoffeePlusBagelDiscount(quantitysAfterDiscount, total);
        // this is for the leftovers
        total = getLeftOverPrice(quantitysAfterDiscount, total);
        // Roundings error to 2 decimal
        total = (double) Math.round(total * 100) / 100;
        return total;
    }

    private double getLeftOverPrice(ArrayList<Integer> quantitysAfterDiscount, double total) {
        for (int i = 0; i < items.size(); i++) {
            double price = items.get(i).getPrice();
            int quantity = quantitysAfterDiscount.get(i);
            total += price * quantity;
        }
        return total;
    }

    private double getCoffeePlusBagelDiscount(ArrayList<Integer> quantitysAfterDiscount, double total) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            int quantityOfCoffee = quantitysAfterDiscount.get(i);
            if (item instanceof Coffee) {
                for (int j = 0; j < items.size(); j++) {
                    Item bagel = items.get(j);
                    if (bagel instanceof Bagel) {
                        int quantityOfBagel = quantitysAfterDiscount.get(j);

                        if (quantityOfCoffee > quantityOfBagel) {
                            total += 1.25 * quantityOfBagel;
                            quantitysAfterDiscount.set(j, 0);//bagels quantity
                            quantitysAfterDiscount.set(i, quantityOfCoffee - quantityOfBagel);//coffee quantity
                        } else if (quantityOfCoffee < quantityOfBagel) {
                            total += 1.25 * quantityOfCoffee;
                            quantitysAfterDiscount.set(j, quantityOfBagel - quantityOfCoffee);//bagels quantity
                            quantitysAfterDiscount.set(i, 0);//coffee quantity
                        } else {
                            total += 1.25 * quantityOfBagel;
                            quantitysAfterDiscount.set(j, 0);//bagels quantity
                            quantitysAfterDiscount.set(i, 0);//coffee quantity
                        }

                    }

                }
            }

        }
        return total;
    }

    private double getBagelDiscount(ArrayList<Integer> quantitysAfterDiscount, double total) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            int quantity = quantitys.get(i);
            if (item instanceof Bagel) { //Bagel discount 6/12
                //this is the fillings
                total += ((Bagel) item).getFillingsPrice() * quantity;
                while (quantity >= 6) {
                    if (quantity >= 12) {
                        total += 3.99 * quantity / 12;
                        quantity -= (int) (quantity / 12) * 12;
                    } else {
                        total += 2.49 * (int) (quantity / 6);
                        quantity -= (quantity / 6) * 6;
                    }
                }
            }
            quantitysAfterDiscount.add(quantity);
        }
        return total;
    }


    public static void main(String[] args) {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BAGELTYPE.PLAIN);
        Coffee coffee = new Coffee(COFFEETYPE.BLACK);
        BobsInvetory.add(bagel);
        BobsInvetory.add(coffee);
        basket.setCapacity(100);
        basket.add(bagel, 6);
        basket.add(bagel, 2);
        basket.add(coffee, 3);
        double total = basket.getTotalWithDiscount();
        System.out.println("total = " + total);
        System.out.println("Manual = " + (2.49 + 2.50 + 0.99));


        System.out.println("basket = " + basket.getCode());


    }
}
