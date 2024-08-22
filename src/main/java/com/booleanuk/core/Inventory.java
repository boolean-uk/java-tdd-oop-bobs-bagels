package com.booleanuk.core;

import java.util.List;

public class Inventory {
  private List<Product> stock;

  public Inventory(List<Product> stock) {
    this.stock = stock;
  }

  public Receipt purchase(Basket basket) throws NotInStockException {
    for (StandaloneProduct product : basket.products()) {
      // Remove any extras such as fillings
      for (Product component : product.extras())
        this.stock.remove(this.find(component.sku()));
      // Remove the product itself
      this.stock.remove(this.find(product.sku()));
    }

    return Receipt.makeReceipt(basket);
  }

  private Product find(Sku sku) throws NotInStockException {
    for (Product product : this.stock)
      if (product.sku() == sku)
        return product;

    throw new NotInStockException(sku);
  }
}
