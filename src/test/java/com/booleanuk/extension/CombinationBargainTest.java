package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationBargainTest {

    @Test
    public void getCoffeePlusBagelCombinationBargainsTest() {
        List<CombinationBargain> combinationBargains =
                CombinationBargain.coffeePlusBagel();

        assertEquals(4, combinationBargains.size());
    }
}
