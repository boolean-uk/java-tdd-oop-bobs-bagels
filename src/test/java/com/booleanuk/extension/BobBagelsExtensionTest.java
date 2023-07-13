package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BobBagelsExtensionTest {



    BobBagelsExtension bobBagelsExtension;
    DiscountManager  discountManager;
    ReciptCreator reciptCreator;
     @BeforeEach
     public  void prepareForTests(){
         reciptCreator = new ReciptCreator();
         discountManager = new DiscountManager();
         bobBagelsExtension = new BobBagelsExtension();
     }



    @Test
    public void shouldAddDiscountForCoffeeAndBagel(){
         //given
         Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        Coffee coffee = new Coffee("Black",0.99,"COFB", CoffeeVariant.BLACK);
        basket.add(bagel, 1);
        basket.add(coffee,1);
        //when
        int totalCost =  discountManager.addDiscount(basket);

        //then
        Assertions.assertEquals(1.25,basket.getTotalCost());



    }
}
