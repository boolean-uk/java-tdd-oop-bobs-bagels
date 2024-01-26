package com.booleanuk.extension;

import java.util.ArrayList;

public interface Product {
    public String getId();
    public double getPrice();
    public String getName();
    public String getVariant();

    //Only in bagel

    public boolean addFillings(ArrayList<Filling> fillings);
    public ArrayList<Filling> getFillings();
}
