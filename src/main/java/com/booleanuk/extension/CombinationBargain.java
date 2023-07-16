package com.booleanuk.extension;

import java.util.List;

public record CombinationBargain(String name, List<String> productsSKUs, int price) {

    public static List<CombinationBargain> coffeePlusBagel() {
        return List.of(new CombinationBargain("CoffeePlusOBagel", List.of("COFB", "BGLO"), 125),
                new CombinationBargain("CoffeePlusPBagel", List.of("COFB", "BGLP"), 125),
                new CombinationBargain("CoffeePlusEBagel", List.of("COFB", "BGLE"), 125),
                new CombinationBargain("CoffeePlusSBagel", List.of("COFB", "BGLS"), 125));
    }
}
