package com.booleanuk.core;

import javax.swing.plaf.ProgressBarUI;

public class Product {
    String SKU;
    String type;
    double price;
    String name;

    public Product(String SKU) throws IllegalStateException{

        switch (SKU) {

            case "BGLO":
                type = "Bagel";
                price = 0.49;
                name = "Onion";
                break;
            case "BGLP":
                type = "Bagel";
                price = 0.39;
                name = "Plain";
                break;
            case "BGLE":
                type = "Bagel";
                price = 0.49;
                name = "Everything";
                break;
            case "BGLS":
                type = "Bagel";
                price = 0.49;
                name = "Sesame";
                break;

            case "COFB":
                type = "Coffee";
                price = 0.99;
                name = "Black";
                break;
            case "COFW":
                type = "Coffee";
                price = 1.19;
                name = "White";
                break;
            case "COFC":
                type = "Coffee";
                price = 1.29;
                name = "Cappuccino";
                break;
            case "COFL":
                type = "Coffee";
                price = 1.29;
                name = "Latte";
                break;

            case "FILB":
                type = "Filling";
                price = 0.12;
                name = "Bacon";
                break;
            case "FILE":
                type = "Filling";
                price = 0.12;
                name = "Egg";
                break;
            case "FILC":
                type = "Filling";
                price = 0.12;
                name = "Cheese";
                break;
            case "FILX":
                type = "Filling";
                price = 0.12;
                name = "Cream Cheese";
                break;
            case "FILS":
                type = "Filling";
                price = 0.12;
                name = "Smoked Salmon";
                break;
            case "FILH":
                type = "Filling";
                price = 0.12;
                name = "Ham";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + SKU);
        }
        this.SKU = SKU;
    }
}
