package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private ArrayList<Integer> quantitysAfterDiscount;
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
        quantitysAfterDiscount = new ArrayList<>();
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


    public void getReceipt() {
//        ArrayList<Double> prices = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        double total = getTotalWithDiscount(); // discount Quantities exist now!


        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println();
        System.out.println(dateTime.format(formatter));
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();

        printSingleLadies();


        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("Total                 £" + total);
        System.out.println();
        System.out.println("Thank you");
        System.out.println("for your order!");

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

    //    private void printSinglePrices() {
//        for (int i = 0; i < items.size(); i++) {
//            Item item = items.get(i);
//            int quantity = quantitys.get(i);
////            basket.getTotalWithDiscountBasket();
//            int quantityAfterDiscount = quantitysAfterDiscount.get(i);
//
//
//            System.out.print(item instanceof Bagel ? ((Bagel) item).getType() + " " + "bagel" : "Coffee");
//            System.out.print("        " + quantity + "  " + "£");
//            if (item instanceof Bagel) { // Bagel discount 12/6
//                if (quantityAfterDiscount == quantity) {
//                    System.out.print((double) Math.round(item.getPrice() * quantity * 100) / 100);
//                } else {
//                    double price = 0.0;
//                    while (quantity >= 6) {
//                        if (quantity >= 12) {
//                            price += 3.99 * quantity / 12;
//                            quantity -= (int) (quantity / 12) * 12;
//                        } else {
//                            price += 2.49 * (int) (quantity / 6);
//                            quantity -= (quantity / 6) * 6;
//                        }
//                    }
//                    price += quantity * item.getPrice();
//                    System.out.print((double) Math.round(price * 100) / 100);
//                }
//
//            } else {
//                System.out.print("hello there");
//            }
//            System.out.println();
//        }
//    }
    private void printSingleLadies() {
        ArrayList<Item> receiptItems = new ArrayList<>();
        ArrayList<Integer> receiptQuantitys = new ArrayList<>();
        ArrayList<Double> receiptPrices = new ArrayList<>();
        ArrayList<Integer> helpQuantitys = new ArrayList<>();
        helpQuantitys.addAll(quantitys);

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            int quantity = helpQuantitys.get(i);
            //todo discount12/6 OK! add()
            double price = 0;
            if (item instanceof Bagel) {
                while (quantity >= 6) {
                    if (quantity >= 12) {
                        price += 3.99 * quantity / 12;
                        quantity -= (int) (quantity / 12) * 12;
                    } else {
                        price += 2.49 * (int) (quantity / 6);
                        quantity -= (quantity / 6) * 6;
                    }
                }
                if (price != 0) {
                    receiptItems.add(item);
                    receiptQuantitys.add(helpQuantitys.get(i) - quantity);
                    receiptPrices.add(price);
                    helpQuantitys.set(i, quantity);
                }
            }
        }
//        for (int i = 0; i < items.size(); i++) {
//            Item coffee = items.get(i);
//            int quantityOfCoffee = quantitys.get(i);
//            //todo COffee+Bagel!
//            if (coffee instanceof Coffee) {
//                for (int j = 0; j < items.size(); j++) {
//                    Item bagel = items.get(j);
//                    double price = 0;
//                    if (bagel instanceof Bagel) {
//                        int quantityOfBagel = helpQuantitys.get(j);
//                        if (quantityOfCoffee > quantityOfBagel) {
//                            price += 1.25 * quantityOfBagel;
//                            helpQuantitys.set(j, 0);//bagels quantity
//                            helpQuantitys.set(i, quantityOfCoffee - quantityOfBagel);//coffee quantity
//
//                            receiptItems.add(coffee);
//                            receiptQuantitys.add(quantityOfCoffee - quantityOfBagel);
//                            receiptPrices.add(price);
//                        } else if (quantityOfCoffee < quantityOfBagel) {
//                            price += 1.25 * quantityOfCoffee;
//                            helpQuantitys.set(j, quantityOfBagel - quantityOfCoffee);//bagels quantity
//                            helpQuantitys.set(i, 0);//coffee quantity
//
//                            receiptItems.add(coffee);
//                            receiptQuantitys.add(quantityOfBagel - quantityOfCoffee);
//                            receiptPrices.add(price);
//                        } else {
//                            price += 1.25 * quantityOfBagel;
//                            helpQuantitys.set(j, 0);//bagels quantity
//                            helpQuantitys.set(i, 0);//coffee quantity
//
//                            receiptItems.add(coffee);
//                            receiptQuantitys.add(quantityOfBagel);
//                            receiptPrices.add(price);
//                        }
//
//
//
//                    }
//                }
//            }
//
//
//        }
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            int quantity = helpQuantitys.get(i);
            //todo
            if (receiptItems.contains(item)) {//hasCode
                int position = receiptItems.indexOf(item);
                int previousQuantity = receiptQuantitys.get(position);
                double previousPrice = receiptPrices.get(position);
                receiptQuantitys.set(position, previousQuantity + quantity);
                receiptPrices.set(position, previousPrice + item.getPrice() * quantity);
            } else {
                receiptItems.add(item);
                receiptQuantitys.add(helpQuantitys.get(i));
                receiptPrices.add(item.getPrice() * helpQuantitys.get(i));
            }


        }
        for (int i = 0; i < receiptItems.size(); i++) {
            Item item =receiptItems.get(i);
            int quantity =receiptQuantitys.get(i);
            double price =receiptPrices.get(i);
            System.out.print(item instanceof Bagel ? ((Bagel) item).getType() + " " + "bagel" : ((Coffee) item).getType()+" Coffee");
            System.out.print("        " + quantity + "  " + "£");
            System.out.print(price);
            System.out.println();

        }
    }


    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.setCapacity(100);
        Bagel bagel = new Bagel(BAGELTYPE.PLAIN); //0.39
        Bagel bagelOther = new Bagel(BAGELTYPE.EVERYTHING);
        Coffee coffee = new Coffee(COFFEETYPE.BLACK); //0.99
        BobsInvetory.add(bagel);
        BobsInvetory.add(coffee);
        BobsInvetory.add(bagelOther);

        basket.add(bagel, 6);
        basket.add(coffee, 1);
        basket.add(bagelOther,4);


        basket.getReceipt();

        System.out.println("after = " + basket.getCode());


    }
}
