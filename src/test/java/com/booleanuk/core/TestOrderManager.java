
package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOrderManager {
    @Test
    public void testOrderManagerConstr(){
        OrderManager om = new OrderManager();
    }

    @Test
    public void testaddItem(){
        OrderManager om = new OrderManager();
        om.setMaxCartSize(100);
        String result = om.addItem(BagelType.Onion);
        Assertions.assertEquals("Onion: 1", result);


        result = om.addItem(CoffeeType.Cappuccino);
        Assertions.assertEquals("Cappuccino: 1", result);


        result = om.addItem(CoffeeType.Cappuccino);
        Assertions.assertEquals("Cappuccino: 2", result);

        for (int i = 0; i < OrderManager.getMaxFillings(); i++) {
            result = om.addItem(FillingType.Bacon);
            Assertions.assertEquals("Bacon: " + (i+1), result);
        }

        result = om.addItem(FillingType.Bacon);
        Assertions.assertEquals("Item not in stock.", result);
    }

    @Test
    public void testGetPrice(){ // core
        OrderManager om = new OrderManager();
        om.addItem(BagelType.Onion);
        om.addItem(BagelType.Onion);
        om.addItem(BagelType.Onion);

        double pricePerOnion = 0.49;
        double expectedPrice = 3* pricePerOnion;
        Assertions.assertEquals(expectedPrice, om.getTotalCartPrice());

        om.addItem(CoffeeType.Cappuccino);
        double pricePerCappuccino = 1.29;
        expectedPrice += pricePerCappuccino;
        Assertions.assertEquals(expectedPrice, om.getTotalCartPrice());

        om.addItem(CoffeeType.Cappuccino);
        om.addItem(CoffeeType.Cappuccino);
        expectedPrice += pricePerCappuccino*2;
        Assertions.assertEquals(expectedPrice, om.getTotalCartPrice());
    }

    @Test
    public void testRemoveItem(){
        OrderManager om = new OrderManager();
        String result;
        result = om.removeItem(BagelType.Onion);
        Assertions.assertEquals("Onion is not in cart.", result);

        Assertions.assertEquals(20, om.getStockOfItem(BagelType.Onion));
        om.addItem(BagelType.Onion);
        Assertions.assertEquals(19, om.getStockOfItem(BagelType.Onion));


        result = om.removeItem(BagelType.Onion);
        Assertions.assertEquals("Removed Onion from cart.", result);
        Assertions.assertEquals(20, om.getStockOfItem(BagelType.Onion));


        result = om.removeItem(BagelType.Onion);
        Assertions.assertEquals("Onion is not in cart.", result);
        Assertions.assertEquals(20, om.getStockOfItem(BagelType.Onion));
    }


    @Test
    public void testGetPriceOfItem(){
        OrderManager om = new OrderManager();

        // Bagel tests
        Assertions.assertEquals(0.49, om.getPriceOfItem(BagelType.Onion));
        Assertions.assertEquals(0.39, om.getPriceOfItem(BagelType.Plain));
        Assertions.assertEquals(0.49, om.getPriceOfItem(BagelType.Everything));
        Assertions.assertEquals(0.49, om.getPriceOfItem(BagelType.Sesame));

        // Coffee tests
        Assertions.assertEquals(0.99, om.getPriceOfItem(CoffeeType.Black));
        Assertions.assertEquals(1.19, om.getPriceOfItem(CoffeeType.White));
        Assertions.assertEquals(1.29, om.getPriceOfItem(CoffeeType.Cappuccino));
        Assertions.assertEquals(1.29, om.getPriceOfItem(CoffeeType.Latte));

        // Filling tests
        Assertions.assertEquals(0.12, om.getPriceOfItem(FillingType.Bacon));
        Assertions.assertEquals(0.12, om.getPriceOfItem(FillingType.Egg));
        Assertions.assertEquals(0.12, om.getPriceOfItem(FillingType.Cheese));
        Assertions.assertEquals(0.12, om.getPriceOfItem(FillingType.Cream_Cheese));
        Assertions.assertEquals(0.12, om.getPriceOfItem(FillingType.Smoked_Salmon));
        Assertions.assertEquals(0.12, om.getPriceOfItem(FillingType.Ham));
    }

    @Test
     public void testDiscountPrice(){
        OrderManager om = new OrderManager();
        for (int i = 0; i < 16 ; i++) {
            om.addItem(BagelType.Plain);
        }
        Assertions.assertEquals(5.55, om.getTotalDiscountedPrice());
        System.out.println(om.getTotalDiscountRecieptString());

        om = new OrderManager();
        for (int i = 0; i < 2; i++) {
            om.addItem(BagelType.Onion); // 0.49*3
        }
        for (int i = 0; i < 12; i++) {
            om.addItem(BagelType.Plain); // 3.99
        }
        for (int i = 0; i < 6; i++) {
            om.addItem(BagelType.Everything); // 2.49
        }
        for (int i = 0; i < 3; i++) {
            om.addItem(CoffeeType.Black); // 0.99*3
        }


        Assertions.assertEquals(10.43, om.getTotalDiscountedPrice());

        String res = om.getTotalDiscountRecieptString();
        System.out.println("res\n" + res);

    }

    @Test
    public void testDiscountCoffee(){
        OrderManager om = new OrderManager();
        om.addItem(CoffeeType.Black);
        om.addItem(BagelType.Plain);
        Assertions.assertEquals(1.25, om.getTotalDiscountedPrice());

        String res = om.getTotalDiscountRecieptString();
        System.out.println("res\n" + res);
    }

    @Test
    public void testReceipt(){
        OrderManager om = new OrderManager();
        om.setMaxCartSize(100);



        // 2 of each bagel type
        om.addItem(BagelType.Plain);
        om.addItem(BagelType.Plain);
        om.addItem(BagelType.Onion);
        om.addItem(BagelType.Onion);
        om.addItem(BagelType.Everything);
        om.addItem(BagelType.Everything);
        om.addItem(BagelType.Sesame);
        om.addItem(BagelType.Sesame);

        // 2 of each coffee type
        om.addItem(CoffeeType.Black);
        om.addItem(CoffeeType.Black);
        om.addItem(CoffeeType.White);
        om.addItem(CoffeeType.White);
        om.addItem(CoffeeType.Cappuccino);
        om.addItem(CoffeeType.Cappuccino);
        om.addItem(CoffeeType.Latte);
        om.addItem(CoffeeType.Latte);

        // 2 of each filling type
        om.addItem(FillingType.Bacon);
        om.addItem(FillingType.Bacon);
        om.addItem(FillingType.Egg);
        om.addItem(FillingType.Egg);
        om.addItem(FillingType.Cheese);
        om.addItem(FillingType.Cheese);
        om.addItem(FillingType.Cream_Cheese);
        om.addItem(FillingType.Cream_Cheese);
        om.addItem(FillingType.Smoked_Salmon);
        om.addItem(FillingType.Smoked_Salmon);
        om.addItem(FillingType.Ham);
        om.addItem(FillingType.Ham);

        Double expectedPrice = 14.81-0.39;
        String receipt = om.getTotalDiscountRecieptString();
        System.out.println("Receipt:\n" + receipt);
        Assertions.assertEquals(expectedPrice, om.getTotalDiscountReciept().price);

        Double expectedPriceWithoutDiscount = 14.68;
        Assertions.assertEquals(expectedPriceWithoutDiscount, om.getTotalCartPrice());
    }

    @Test
    public void testCoffeeAndBagel(){
        OrderManager om = new OrderManager();
        for (int i = 0; i < 2; i++) {
            om.addItem(CoffeeType.Black);
            om.addItem(BagelType.Plain);
        }

        String expectedSubString =
                "=================================\n" +
                "\n" +
                "Coffee and Bagel       2   £ 2.50\n" +
                "                          (-0.26)\n" +
                "――――――――――――――――――――\n" +
                "Saved                      £ 0.26\n" +
                "Total                      £ 2.50\n" +
                "=================================";

        String resultString = om.getTotalDiscountRecieptString();
        Assertions.assertTrue(resultString.contains(expectedSubString));
    }
}
