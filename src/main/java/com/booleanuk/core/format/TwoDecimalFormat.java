package com.booleanuk.core.format;

public class TwoDecimalFormat implements Format<Double> {
    @Override
    public Double result(Double s) {
        return (int) (s * 100) / 100.00;
    }
}
