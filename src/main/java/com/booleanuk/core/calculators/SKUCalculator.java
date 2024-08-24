package com.booleanuk.core.calculators;

public class SKUCalculator {

    /**
     * Get SKU value based on name and variant of an item.
     * @param name - E.g. ProductName.COFFEE
     * @param variant - E.g. BagelVariant.PLAIN
     * @return . String with SKU value.
     */
    public String getSKU(Enum name, Enum variant) {
        String productCode = name.toString().substring(0,3);
        String variantCode = variant.toString().substring(0,1);
        String skuCode = productCode + variantCode;
        return skuCode.toUpperCase();
    }
}
