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

## Domain model Sku enum
| Variants | Variables      |
|----------|----------------|
| BGLO     |                |
| BGLP     |                |
| BGLE     |                |
| BGLS     |                |
| COFB     |                |
| COFW     |                |
| COFC     |                |
| COFL     |                |
| FILB     |                |
| FILE     |                |
| FILC     |                |
| FILX     |                |
| FILS     |                |
| FILH     |                |
|          | `String name`  |
|          | `double price` |

## Domain model Product interface
| Methods               | Scenario                                                                                        | Output                                            |
|-----------------------|-------------------------------------------------------------------------------------------------|---------------------------------------------------|
| `double basePrice()`  | User wants to know the price of a product without any related products before buying            | The base price of the product                     |
| `double extraPrice()` | User wants to know the price of all products attached to the product (e.g. fillings on a bagel) | The price of all products attached to the product |
| `Sku sku()`           | User or admin wants to identify a product                                                       | SKU of product                                    |

## Domain model StandaloneProduct interface
- This interface is separate from the `Product` interface because not all products can be purchased directly

| Extends   | Methods                      | Scenario                                                                                                | Output                              |
|-----------|------------------------------|---------------------------------------------------------------------------------------------------------|-------------------------------------|
| `Product` |                              |                                                                                                         |                                     |
|           | `List<Product> components()` | Admin wants to see any additional products related to some StandAloneproduct (e.g. fillings on a bagel) | All products related to the product |

## Domain model FillingType enum
| Variants      | Variables |
|---------------|-----------|
| Bacon         |           |
| Egg           |           |
| Cheese        |           |
| Cream cheese  |           |
| Smoked salmon |           |
| Ham           |           |
|               | `Sku sku` |

## Domain model Filling record
| Implements | Variables           |
|------------|---------------------|
| `Product`  |                     |
|            | `FillingType type`  |

## Domain model CoffeeType enum
| Variants  | Variables |
|-----------|-----------|
| Black     |           |
| White     |           |
| Capuccino |           |
| Latte     |           |
|           | `Sku sku` |


## Domain model Coffee record
| Implements          | Variables         |
|---------------------|-------------------|
| `StandaloneProduct` |                   |
|                     | `CoffeeType type` |

## Domain model BagelType enum
| Variants   | Variables |
|------------|-----------|
| Onion      |           |
| Plain      |           |
| Everything |           |
| Sesame     |           |
|            | `Sku sku` |

## Domain model Bagel class
| Implements          | Variables                          | Methods                     | Scenario                                        | Output                      |
|---------------------|------------------------------------|-----------------------------|-------------------------------------------------|-----------------------------|
| `StandaloneProduct` |                                    |                             |                                                 |                             |
|                     | `BagelType type`                   |                             |                                                 |                             |
|                     | `Optional<List<Filling>> fillings` |                             |                                                 |                             |
|                     |                                    | `Sku sku()`                 | User wants to know what type of bagel they have | The type of their bagel     |

## Domain model Basket class
| Variables                          | Methods                                                                          | Scenario                                                     | Output                     |
|------------------------------------|----------------------------------------------------------------------------------|--------------------------------------------------------------|----------------------------|
| `List<StandaloneProduct> products` |                                                                                  |                                                              |                            |
|                                    | `void add(StandaloneProduct product) throws AddToFullBasketException`            | Basket is full                                               | Exception                  |
|                                    |                                                                                  | Basket is not full                                           |                            |
|                                    | `void add(StandaloneProduct product, int count) throws AddToFullBasketException` | Basket is full after adding `count` products                 | Exception                  |
|                                    |                                                                                  | Basket is not full                                           |                            |
|                                    | `void remove(Sku sku) throws NotPresentInBasketException`                        | Product with given sku is in basket                          |                            |
|                                    |                                                                                  | Product with given sku is not in basket                      | Exception                  |
|                                    | `void remove(Sku sku, int count) throws NotPresentInBasketException`             | `count` many products with given sku is in basket            |                            |
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
| Variables                | Methods                 | Scenario                                                         | Output                                                |
|--------------------------|-------------------------|------------------------------------------------------------------|-------------------------------------------------------|
| `List<Product> products` |                         |                                                                  |                                                       |
|                          | `Receipt makeReceipt()` | User wants to get a receipt of all the items they have purchased | A receipt                                             |
|                          | `String toString()`     | User wants to see a nicely formatted receipt for their purchase  | A formatted string for the products in their purchase |

## Domain model MessageController class
| Variables                    | Methods                                                   | Scenario                                          | Output                            |
|------------------------------|-----------------------------------------------------------|---------------------------------------------------|-----------------------------------|
| `String TWILIO_ACCOUNT_SID`  |                                                           |                                                   |                                   |
| `String TWILIO_AUTH_TOKEN`   |                                                           |                                                   |                                   |
| `String TWILIO_PHONE_NUMBER` |                                                           |                                                   |                                   |
| `String TWILIO_PHONE_NUMBER` |                                                           |                                                   |                                   |
|                              | `void notifyUser(String messageContent, String toNumber)` | User wants to get a text message of their receipt | A text message with their receipt |
