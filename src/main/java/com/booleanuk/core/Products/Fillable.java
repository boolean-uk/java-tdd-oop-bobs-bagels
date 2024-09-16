package com.booleanuk.core.Products;

import com.booleanuk.core.Products.Filling;

import java.util.ArrayList;

public interface Fillable {
   int MAX_FILLINGS = 5; // Constant for maximum number of fillings

   ArrayList<Filling> getFillings();

   boolean addFilling(Filling filling);

}

