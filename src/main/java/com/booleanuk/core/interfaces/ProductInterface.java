package com.booleanuk.core.interfaces;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.CoffeeType;
import com.booleanuk.core.enums.FillingType;

public interface ProductInterface {

    Product getProduct(MenuCategory variant);

}
