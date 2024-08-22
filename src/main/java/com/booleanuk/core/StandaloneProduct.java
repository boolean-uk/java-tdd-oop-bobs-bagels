package com.booleanuk.core;

import java.util.List;

public interface StandaloneProduct extends Product {
  public List<Product> extras();
}
