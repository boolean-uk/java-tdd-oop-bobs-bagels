## Domain model AddToFullBasketException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model NotInStockException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model NotPresentInBasketException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model Product interface
| Methods          | Scenario                                                | Output                   |
|------------------|---------------------------------------------------------|--------------------------|
| `double price()` | User wants to know the price of a product before buying | The price of the product |
| `String sku()`   | User or admin wants to identify a product               | SKU of product           |

## Domain model StandaloneProduct interface
- This interface is separate from the `Product` interface because not all products can be purchased directly

| Extends   |
|-----------|
| `Product` |

## Domain model FillingType enum
| Variants      |
|---------------|
| Bacon         |
| Egg           |
| Cheese        |
| Cream cheese  |
| Smoked salmon |
| Ham           |

## Domain model Filling record
| Implements | Variables           |
|------------|---------------------|
| `Product`  |                     |
|            | `FillingType type`  |

## Domain model CoffeeType enum
| Variants      |
|---------------|
| Black         |
| White         |
| Capuccino     |
| Latte         |

## Domain model Coffee record
| Implements          | Variables         |
|---------------------|-------------------|
| `StandaloneProduct` |                   |
|                     | `CoffeeType type` |

## Domain model BagelType enum
| Variants   |
|------------|
| Onion      |
| Plain      |
| Everything |
| Sesame     |

## Domain model Bagel class
| Implements          | Variables                | Methods                     | Scenario                                   | Output                      |
|---------------------|--------------------------|-----------------------------|--------------------------------------------|-----------------------------|
| `StandaloneProduct` |                          |                             |                                            |                             |
|                     | `BagelType type`         |                             |                                            |                             |
|                     | `List<Filling> fillings` |                             |                                            |                             |
|                     |                          | `void add(Filling filling)` | User wants to add a filling to their bagel | Filling gets added to bagel |

## Domain model Basket class
| Variables                          | Methods                                                                          | Scenario                                                     | Output                     |
|------------------------------------|----------------------------------------------------------------------------------|--------------------------------------------------------------|----------------------------|
| `List<StandaloneProduct> products` |                                                                                  |                                                              |                            |
|                                    | `void add(StandaloneProduct product) throws AddToFullBasketException`            | Basket is full                                               | Exception                  |
|                                    |                                                                                  | Basket is not full                                           |                            |
|                                    | `void add(StandaloneProduct product, int count) throws AddToFullBasketException` | Basket is full after adding `count` products                 | Exception                  |
|                                    |                                                                                  | Basket is not full                                           |                            |
|                                    | `void remove(String sku) throws NotPresentInBasketException`                     | Product with given sku is in basket                          |                            |
|                                    |                                                                                  | Product with given sku is not in basket                      | Exception                  |
|                                    | `void remove(String sku, int count) throws NotPresentInBasketException`          | `count` many products with given sku is in basket            |                            |
|                                    |                                                                                  | `count` many product with given sku are not in basket        | Exception                  |
|                                    | `void setCapacity(int newCapacity)`                                              | Manager wants to change the capacity of basket               | Basket capacity is changed |
|                                    | `double price()`                                                                 | User wants to know the price of all products in their basket | Sum of product prices      |

## Domain model Inventory class
| Variables                | Methods                                                      | Scenario                                | Output    |
|--------------------------|--------------------------------------------------------------|-----------------------------------------|-----------|
| `List<Product> products` |                                                              |                                         |           |
|                          | `Receipt purchase(Basket basket) throws NotInStockException` | All products in basket are in stock     |           |
|                          |                                                              | Not all products in basket are in stock | Exception |

## Domain model Receipt class
| Variables                | Methods             | Scenario                                                         | Output                                                |
|--------------------------|---------------------|------------------------------------------------------------------|-------------------------------------------------------|
| `List<Product> products` |                     |                                                                  |                                                       |
|                          | `String toString()` | User want's to see a nicely formatted receipt for their purchase | A formatted string for the products in their purchase |