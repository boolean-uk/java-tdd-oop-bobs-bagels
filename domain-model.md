### CORE 
| Class    | Members                                    | Methods                                                 | Scenario                                                                    | Outputs |
|----------|--------------------------------------------|---------------------------------------------------------|-----------------------------------------------------------------------------|---------|
| `Basket` | `LinkedHashMap<Product, Integer> products` | `addProduct(Product product, int quantity)`             | Product is not in the basket and quantity is valid                          | true    |
|          | `basketCapacity`                           |                                                         | Product is in the basket and quantity is valid                              | true    |
|          | `basketQuantity`                           |                                                         | quantity is not valid                                                       | false   |
|          |                                            |                                                         | if basket is full                                                           | false   |
|          |                                            | `removeProduct(Product product, int quantity)`          | Product is in the basket and quantity is valid                              | true    |
|          |                                            |                                                         | Product is in not the basket and quantity is valid                          | false   |
|          |                                            |                                                         | quantity is not valid                                                       | false   |
|          |                                            | `changeBasketCapacity(int newCapacity)`                 | new capacity is valid                                                       | true    |
|          |                                            |                                                         | new capacity is not valid                                                   | false   |
|          |                                            | `getTotalCost()`                                        | returns total cost                                                          | float   |
|          |                                            | `getPartialCost(Product product, int quantity)`         | returns cost of product and quantity                                        | float   |
|          |                                            | `addFillingToBagel(String bagelSku, String fillingSku)` | bagel and filling exists and bagel is in basket and bagel has no filling    | true    |
|          |                                            |                                                         | bagel and filling exists and bagel is in basket and bagel has filling       | true    |
|          |                                            |                                                         | bagel and filling exists and bagel is in basket and bagel has same filling  | false   |
|          |                                            |                                                         | bagel and filling exists and bagel is not in basket                         | false   |
|          |                                            |                                                         | bagel do not exist                                                          | false   |
|          |                                            |                                                         | filling do not exist                                                        | false   |
|          |                                            |                                                         | received bagel name is not a bagel                                          | false   |
|          |                                            |                                                         | received filling is not a filling                                           | false   |
|          |                                            | `removeFillingFromBagel(String bagelSku)`               | bagel exists and is in the basket and has filling                           | true    |
|          |                                            |                                                         | bagel exists and is in the basket and has no filling                        | false   |
|          |                                            |                                                         | bagel exists and is not in the basket                                       | false   |
|          |                                            |                                                         | bagel not exists                                                            | false   |

| Class     | Members                | Methods       | Scenario                | Outputs |
|-----------|------------------------|---------------|-------------------------|---------|
| `Product` | `sku`                  | `getPrice()`  | returns product's price | float   |
|           | `price`                |               |                         |         |
|           | `name`                 |               |                         |         |
|           | `variant`              |               |                         |         |

| Class                   | Members   | Methods        | Scenario                              | Outputs |
|-------------------------|-----------|----------------|---------------------------------------|---------|
| `Bagel extends Product` | `filling` | `addFilling()` | adding filling to the bagel           | void    |
|                         |           | `getFilling()` | if bagel has filling                  | Filling |
|                         |           |                | if bagel has not filling              | null    |

| Class                    | Members   | Methods        | Scenario                             | Outputs |
|--------------------------|-----------|----------------|--------------------------------------|---------|
| `Coffee extends Product` |           |                |                                      |         |

| Class                     | Members   | Methods        | Scenario                             | Outputs |
|---------------------------|-----------|----------------|--------------------------------------|---------|
| `Filling extends Product` |           |                |                                      |         |

| Class       | Members                             | Methods                   | Scenario                                   | Outputs  |
|-------------|-------------------------------------|---------------------------|--------------------------------------------|----------|
| `Inventory` | `HashMap<String, Product> products` | `getProduct(String sku)`  | returns specific product from inventory    | Product  |

### Extension
| Class    | Members                                    | Methods                                              | Scenario                                                   | Outputs |
|----------|--------------------------------------------|------------------------------------------------------|------------------------------------------------------------|---------|
| `Basket` | `LinkedHashMap<Product, Integer> products` | `addProduct(Product product, int quantity)`          | Product is not in the basket and quantity is valid         | true    |
|          | `basketCapacity`                           |                                                      | Product is in the basket and quantity is valid             | true    |
|          | `basketQuantity`                           |                                                      | quantity is not valid                                      | false   |
|          |                                            |                                                      | if basket is full                                          | false   |
|          |                                            | `getTotalCost()`                                     | returns total cost                                         | float   |
|          |                                            | `getPartialCost(Product product, int quantity)`      | returns cost of product and quantity                       | float   |
|          |                                            | `getReceipt()`                                       | returns receipt                                            | String  |
|          |                                            | `getProductDiscount(Product product, int quantity)`  | returns product discount amount including quantity         | float   |
|          |                                            | `leftpad(String text, int length)`                   | returns String with given width(filled with left padding)  | String  |
|          |                                            | `rightpad(String text, int length)`                  | returns String with given width(filled with right padding) | String  |

| Class     | Members                | Methods       | Scenario                | Outputs |
|-----------|------------------------|---------------|-------------------------|---------|
| `Product` | `sku`                  | `getPrice()`  | returns product's price | float   |
|           | `price`                |               |                         |         |
|           | `name`                 |               |                         |         |
|           | `variant`              |               |                         |         |
|           | `specialOfferQuantity` |               |                         |         |
|           | `specialOfferPrice`    |               |                         |         |

| Class                   | Members   | Methods        | Scenario                              | Outputs |
|-------------------------|-----------|----------------|---------------------------------------|---------|
| `Bagel extends Product` | `filling` | `addFilling()` | adding filling to the bagel           | void    |
|                         |           | `getFilling()` | if bagel has filling                  | Filling |
|                         |           |                | if bagel has not filling              | null    |

| Class                    | Members   | Methods        | Scenario                             | Outputs |
|--------------------------|-----------|----------------|--------------------------------------|---------|
| `Coffee extends Product` |           |                |                                      |         |

| Class                     | Members   | Methods        | Scenario                             | Outputs |
|---------------------------|-----------|----------------|--------------------------------------|---------|
| `Filling extends Product` |           |                |                                      |         |

| Class       | Members                             | Methods                   | Scenario                                   | Outputs  |
|-------------|-------------------------------------|---------------------------|--------------------------------------------|----------|
| `Inventory` | `HashMap<String, Product> products` | `getProduct(String sku)`  | returns specific product from inventory    | Product  |