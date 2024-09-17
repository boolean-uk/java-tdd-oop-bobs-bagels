package com.booleanuk.extension;

public record Bargain(int packSize, int packCost) {

    public static Bargain bargain6Bagels() {
        return new Bargain(6, 249);
    }

    public static Bargain bargain12Bagels() {
        return new Bargain(12, 399);
    }
}
