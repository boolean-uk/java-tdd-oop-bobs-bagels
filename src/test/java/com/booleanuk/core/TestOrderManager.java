
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
        String result = om.addItem(Bagel.Onion);
        Assertions.assertEquals("Onion: 1", result);


        result = om.addItem(Coffee.Cappuccino);
        Assertions.assertEquals("Cappuccino: 1", result);


        result = om.addItem(Coffee.Cappuccino);
        Assertions.assertEquals("Cappuccino: 2", result);

        for (int i = 0; i < OrderManager.getMaxFillings(); i++) {
            result = om.addItem(Filling.Bacon);
            Assertions.assertEquals("Bacon: " + (i+1), result);
        }

        result = om.addItem(Filling.Bacon);
        Assertions.assertEquals("Item not in stock.", result);
    }

    @Test
    public void testGetPrice(){ // core
        OrderManager om = new OrderManager();
        om.addItem(Bagel.Onion);
        om.addItem(Bagel.Onion);
        om.addItem(Bagel.Onion);

        double pricePerOnion = 0.49;
        double expectedPrice = 3* pricePerOnion;
        Assertions.assertEquals(expectedPrice, om.getTotalCartPrice());

        om.addItem(Coffee.Cappuccino);
        double pricePerCappuccino = 1.29;
        expectedPrice += pricePerCappuccino;
        Assertions.assertEquals(expectedPrice, om.getTotalCartPrice());

        om.addItem(Coffee.Cappuccino);
        om.addItem(Coffee.Cappuccino);
        expectedPrice += pricePerCappuccino*2;
        Assertions.assertEquals(expectedPrice, om.getTotalCartPrice());
    }

    @Test
    public void testRemoveItem(){
        OrderManager om = new OrderManager();
        String result;
        result = om.removeItem(Bagel.Onion);
        Assertions.assertEquals("Onion is not in cart.", result);

        Assertions.assertEquals(20, om.getStockOfItem(Bagel.Onion));
        om.addItem(Bagel.Onion);
        Assertions.assertEquals(19, om.getStockOfItem(Bagel.Onion));


        result = om.removeItem(Bagel.Onion);
        Assertions.assertEquals("Removed Onion from cart.", result);
        Assertions.assertEquals(20, om.getStockOfItem(Bagel.Onion));


        result = om.removeItem(Bagel.Onion);
        Assertions.assertEquals("Onion is not in cart.", result);
        Assertions.assertEquals(20, om.getStockOfItem(Bagel.Onion));
    }


    @Test
    public void testGetPriceOfItem(){
        OrderManager om = new OrderManager();

        // Bagel tests
        Assertions.assertEquals(0.49, om.getPriceOfItem(Bagel.Onion));
        Assertions.assertEquals(0.39, om.getPriceOfItem(Bagel.Plain));
        Assertions.assertEquals(0.49, om.getPriceOfItem(Bagel.Everything));
        Assertions.assertEquals(0.49, om.getPriceOfItem(Bagel.Sesame));

        // Coffee tests
        Assertions.assertEquals(0.99, om.getPriceOfItem(Coffee.Black));
        Assertions.assertEquals(1.19, om.getPriceOfItem(Coffee.White));
        Assertions.assertEquals(1.29, om.getPriceOfItem(Coffee.Cappuccino));
        Assertions.assertEquals(1.29, om.getPriceOfItem(Coffee.Latte));

        // Filling tests
        Assertions.assertEquals(0.12, om.getPriceOfItem(Filling.Bacon));
        Assertions.assertEquals(0.12, om.getPriceOfItem(Filling.Egg));
        Assertions.assertEquals(0.12, om.getPriceOfItem(Filling.Cheese));
        Assertions.assertEquals(0.12, om.getPriceOfItem(Filling.Cream_Cheese));
        Assertions.assertEquals(0.12, om.getPriceOfItem(Filling.Smoked_Salmon));
        Assertions.assertEquals(0.12, om.getPriceOfItem(Filling.Ham));
    }

    @Test
     public void testDiscountPrice(){
        OrderManager om = new OrderManager();
        for (int i = 0; i < 16 ; i++) {
            om.addItem(Bagel.Plain);
        }
        Assertions.assertEquals(5.55, om.getTotalDiscountedPrice());
        System.out.println(om.getTotalDiscountRecieptString());

        om = new OrderManager();
        for (int i = 0; i < 2; i++) {
            om.addItem(Bagel.Onion); // 0.49*3
        }
        for (int i = 0; i < 12; i++) {
            om.addItem(Bagel.Plain); // 3.99
        }
        for (int i = 0; i < 6; i++) {
            om.addItem(Bagel.Everything); // 2.49
        }
        for (int i = 0; i < 3; i++) {
            om.addItem(Coffee.Black); // 0.99*3
        }


        Assertions.assertEquals(10.43, om.getTotalDiscountedPrice());

        String res = om.getTotalDiscountRecieptString();
        System.out.println("res\n" + res);

    }

    @Test
    public void testDiscountCoffee(){
        OrderManager om = new OrderManager();
        om.addItem(Coffee.Black);
        om.addItem(Bagel.Plain);
        Assertions.assertEquals(1.25, om.getTotalDiscountedPrice());

        String res = om.getTotalDiscountRecieptString();
        System.out.println("res\n" + res);
    }


    /** My sample receipt:
     *
     *        ~~~Bob's Bagels~~~
     *            2024-08-22
     *             14:54:47
     * =================================
     *
     * Bagel: Onion           2   £ 0.98
     * Coffee: Black          3   £ 2.97
     * Everything Bagel x 12  1   £ 2.49
     *                           (-0.45)
     * Plain Bagel x 12       1   £ 3.99
     *                           (-0.69)
     * ――――――――――――――――――――
     * Saved                      £ 1.14
     * Total                     £ 10.43
     * =================================
     */
    @Test
    public void testReceipt(){
        OrderManager om = new OrderManager();
        om.setMaxCartSize(100);



        // 2 of each bagel type
        om.addItem(Bagel.Plain);
        om.addItem(Bagel.Plain);
        om.addItem(Bagel.Onion);
        om.addItem(Bagel.Onion);
        om.addItem(Bagel.Everything);
        om.addItem(Bagel.Everything);
        om.addItem(Bagel.Sesame);
        om.addItem(Bagel.Sesame);

        // 2 of each coffee type
        om.addItem(Coffee.Black);
        om.addItem(Coffee.Black);
        om.addItem(Coffee.White);
        om.addItem(Coffee.White);
        om.addItem(Coffee.Cappuccino);
        om.addItem(Coffee.Cappuccino);
        om.addItem(Coffee.Latte);
        om.addItem(Coffee.Latte);

        // 2 of each filling type
        om.addItem(Filling.Bacon);
        om.addItem(Filling.Bacon);
        om.addItem(Filling.Egg);
        om.addItem(Filling.Egg);
        om.addItem(Filling.Cheese);
        om.addItem(Filling.Cheese);
        om.addItem(Filling.Cream_Cheese);
        om.addItem(Filling.Cream_Cheese);
        om.addItem(Filling.Smoked_Salmon);
        om.addItem(Filling.Smoked_Salmon);
        om.addItem(Filling.Ham);
        om.addItem(Filling.Ham);

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
            om.addItem(Coffee.Black);
            om.addItem(Bagel.Plain);
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
        System.out.println(resultString);
        Assertions.assertTrue(resultString.contains(expectedSubString));
    }

    @Test
    public void testTestDiscountValues(){
        OrderManager om = new OrderManager();
        for (int i = 0; i < 12; i++)
            om.addItem(Bagel.Plain);

        double priceOfTwelvePlain = 0.39*12;
        Assertions.assertEquals(3.99, om.getTotalDiscountReciept().price);
        Assertions.assertEquals(priceOfTwelvePlain, om.getTotalCartPrice());


        om = new OrderManager();
        for (int i = 0; i < 12; i++)
            om.addItem(Bagel.Onion);

        double priceOfTwelveOnion = 0.49*12;
        Assertions.assertEquals(3.99, om.getTotalDiscountReciept().price);
        Assertions.assertEquals(priceOfTwelveOnion, om.getTotalCartPrice());

        om = new OrderManager();
        for (int i = 0; i < 12; i++)
            om.addItem(Bagel.Everything);

        double priceOfTwelveEverything = 0.49*12;
        Assertions.assertEquals(3.99, om.getTotalDiscountReciept().price);
        Assertions.assertEquals(priceOfTwelveEverything, om.getTotalCartPrice());

        om = new OrderManager();
        for (int i = 0; i < 12; i++)
            om.addItem(Bagel.Sesame);


        double priceOfTwelveSesame = 0.49*12;
        Assertions.assertEquals(3.99, om.getTotalDiscountReciept().price);
        Assertions.assertEquals(priceOfTwelveSesame, om.getTotalCartPrice());


        Receipt r = om.getTotalDiscountReciept();
        String res = r.getTotalDiscountRecieptString();
        System.out.println(res);


        for (int i = 0; i < 200; i++) {
            r = om.getTotalDiscountReciept();
        }


    }
}
