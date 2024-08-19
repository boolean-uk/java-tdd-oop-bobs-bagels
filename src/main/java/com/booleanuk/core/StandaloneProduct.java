package com.booleanuk.core;

import java.util.List;

public interface StandaloneProduct extends Product {
  public double price();

  public List<Product> components();
}
