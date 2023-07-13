package com.booleanuk.core;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.BagelVariant;
import com.booleanuk.core.products.Filling;
import com.booleanuk.core.products.FillingVariant;
import com.booleanuk.core.receipt.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ReceiptTest {


    @Test
    public void shouldCreateReceiptWithOneEntry() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.51));
        basket.addProduct(bagel);
        Receipt receipt = new Receipt();
        receipt.createReceipt(basket);
        Assertions.assertEquals(1, receipt.getListOfProducts().size());
    }

    @Test
    public void shouldPrintReceiptWithOneEntry() {

        Basket basket = new Basket();
        Bagel onionBagel = new Bagel("BGLO",BigDecimal.valueOf(0.49));
        Bagel plainBagel = new Bagel("BGLP",BigDecimal.valueOf(0.39));
        Bagel everythingBagel = new Bagel("BGLE",BigDecimal.valueOf(0.49));
        Bagel sesameBagel = new Bagel("BGLS",BigDecimal.valueOf(0.49));
        onionBagel.setVariant(BagelVariant.Onion);
        plainBagel.setVariant(BagelVariant.Plain);
        everythingBagel.setVariant(BagelVariant.Everything);
        sesameBagel.setVariant(BagelVariant.Sesame);
        basket.addProduct(onionBagel);
        basket.addProduct(onionBagel);
        basket.addProduct(onionBagel);
        basket.addProduct(onionBagel);
        basket.addProduct(plainBagel);
        basket.addProduct(everythingBagel);
        basket.addProduct(sesameBagel);

        Receipt receipt = new Receipt();

        Assertions.assertNotNull(receipt.printReceipt(basket));
    }

   @Test
   public void shouldPrintBagelOnReceiptProperly()
   {
       Bagel onionBagel = new Bagel("BGLO",BigDecimal.valueOf(0.49));
       onionBagel.setVariant(BagelVariant.Onion);
       Filling filling = new Filling("FILB",BigDecimal.valueOf(0.12));
       filling.setVariant(FillingVariant.Bacon);
       onionBagel.addFilling(filling);
       Receipt receipt = new Receipt();
       receipt.showBagelOnReceipt(onionBagel,1);
       Assertions.assertNotNull(receipt.showBagelOnReceipt(onionBagel,1));
   }


   @Test
    public  void shouldPrintReceiptWithFillings()
   {
       Basket basket = new Basket();
       Bagel onionBagel = new Bagel("BGLO",BigDecimal.valueOf(0.49));
       Bagel plainBagel = new Bagel("BGLP",BigDecimal.valueOf(0.39));
       Bagel everythingBagel = new Bagel("BGLE",BigDecimal.valueOf(0.49));
       Bagel sesameBagel = new Bagel("BGLS",BigDecimal.valueOf(0.49));
       onionBagel.setVariant(BagelVariant.Onion);
       plainBagel.setVariant(BagelVariant.Plain);
       everythingBagel.setVariant(BagelVariant.Everything);
       sesameBagel.setVariant(BagelVariant.Sesame);
       Filling filling = new Filling("FILB",BigDecimal.valueOf(0.12));
       filling.setVariant(FillingVariant.Bacon);
       onionBagel.addFilling(filling);
       basket.addProduct(onionBagel);
       basket.addProduct(plainBagel);
       basket.addProduct(everythingBagel);
       basket.addProduct(sesameBagel);

       Receipt receipt = new Receipt();
       System.out.println(receipt.printReceipt(basket));
       Assertions.assertNotNull(receipt.showBagelOnReceipt(onionBagel,1));
   }
}
