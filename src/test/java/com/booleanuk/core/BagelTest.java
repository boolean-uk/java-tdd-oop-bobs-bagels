package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagelTest {
  @Test
  public void testAddFilling() {
    Bagel myBagel = new Bagel(BagelType.ONION);
    myBagel.add(new Filling(FillingType.EGG));
    myBagel.add(new Filling(FillingType.BACON));
    Assertions.assertEquals(myBagel.price(), 0.49 + 0.12 + 0.12);
  }

  @Test
  public void testSku() {
    Bagel onionBagel = new Bagel(BagelType.ONION);
    Assertions.assertEquals(onionBagel.sku(), Sku.BGLO);

    Bagel everythingBagel = new Bagel(BagelType.EVERYTHING);
    Assertions.assertEquals(everythingBagel.sku(), Sku.BGLE);
  }
}
