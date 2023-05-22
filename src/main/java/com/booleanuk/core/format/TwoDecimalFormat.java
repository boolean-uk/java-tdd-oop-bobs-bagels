package com.booleanuk.core.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TwoDecimalFormat implements Format<Double> {
    @Override
    public Double result(Double s) {
//        return (int) (s * 100) / 100.00;
        return BigDecimal.valueOf(s)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
