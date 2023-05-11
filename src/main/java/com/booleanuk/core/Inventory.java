package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Bagel> bagels;
    ArrayList<Filling> fillings;

    public boolean bagelAvailable(BAGELTYPE type) { return true; }

    public boolean fillingAvailable(FILLINGTYPE type) { return true; }
}
