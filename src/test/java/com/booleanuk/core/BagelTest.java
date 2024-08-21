package com.booleanuk.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagelTest {
  @Test
  public void testAddFilling() {
    List<Filling> fillings = new ArrayList<Filling>() {
      {
        add(new Filling(FillingType.EGG));
        add(new Filling(FillingType.BACON));
      }
    };
    Bagel myBagel = new Bagel(BagelType.ONION, Optional.of(fillings));
    Assertions.assertEquals(0.49 + 0.12 + 0.12, myBagel.basePrice() + myBagel.extraPrice());
  }

  @Test
  public void testSku() {
    Bagel onionBagel = new Bagel(BagelType.ONION, Optional.empty());
    Assertions.assertEquals(onionBagel.sku(), Sku.BGLO);

    Bagel everythingBagel = new Bagel(BagelType.EVERYTHING, Optional.empty());
    Assertions.assertEquals(everythingBagel.sku(), Sku.BGLE);
  }
}
