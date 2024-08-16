## Domain model AddToFullBasketException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model NotInStockException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model NonExistentBagelException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model Product interface
| Variables | Methods       | Scenario                                                | Output                   |
|-----------|---------------|---------------------------------------------------------|--------------------------|
|           | `int price()` | User wants to know the price of a product before buying | The price of the product |

## Domain model FillingType enum
| Variants      |
|---------------|
| Bacon         |
| Egg           |
| Cheese        |
| Cream cheese  |
| Smoked salmon |
| Ham           |

## Domain model Filling class
- Could maybe extend product?

| Variables     | Methods       | Scenario                                                       | Output                   |
|---------------|---------------|----------------------------------------------------------------|--------------------------|
| `String name` |               |                                                                |                          |
|               | `int price()` | User wants to know the price of a filling before purchasing it | The price of the filling |

## Domain model BagelType enum
| Variants   |
|------------|
| Onion      |
| Plain      |
| Everything |
| Sesame     |

## Domain model Bagel class
| Implements | Variables                | Methods                     | Scenario                                                | Output                      |
|------------|--------------------------|-----------------------------|---------------------------------------------------------|-----------------------------|
| `Product`  |                          |                             |                                                         |                             |
|            | `List<Filling> fillings` |                             |                                                         |                             |
|            |                          | `void add(Filling filling)` | User wants to add a filling to their bagel              | Filling gets added to bagel |

## Domain model Coffee class
| Parent class | Variables                | Methods                     | Scenario                                                | Output                      |
|--------------|--------------------------|-----------------------------|---------------------------------------------------------|-----------------------------|
| `Product`    |                          |                             |                                                         |                             |
|              | `List<Filling> fillings` |                             |                                                         |                             |
|              |                          | `int price()`               | User wants to know the price of a product before buying | The price of the product    |

## Domain model Basket class
| Variables                | Methods                                                           | Scenario                                                     | Output                     |
|--------------------------|-------------------------------------------------------------------|--------------------------------------------------------------|----------------------------|
| `List<Product> products` |                                                                   |                                                              |                            |
|                          | `void add(Product product) throws AddToFullBasketException`       | Basket is full                                               | Exception                  |
|                          |                                                                   | Basket is not full                                           |                            |
|                          | `void remove(Product product) throws NonExistentProductException` | Product is in basket                                         |                            |
|                          |                                                                   | Product is not in basket                                     | Exception                  |
|                          | `void setCapacity(int newCapacity)`                               | Manager wants to change the capacity of basket               | Basket capacity is changed |
|                          | `int price()`                                                     | User wants to know the price of all products in their basket | Sum of product prices      |

## Domain model Inventory class
| Variables                | Methods                                                 | Scenario                                | Output    |
|--------------------------|---------------------------------------------------------|-----------------------------------------|-----------|
| `List<Product> products` |                                                         |                                         |           |
|                          | `void remove(Basket basket) throws NotInStockException` | All products in basket are in stock     |           |
|                          |                                                         | Not all products in basket are in stock | Exception |