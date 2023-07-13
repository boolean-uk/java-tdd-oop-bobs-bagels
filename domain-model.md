| Class    | Members                                    | Methods                                              | Scenario                                                   | Outputs |
|----------|--------------------------------------------|------------------------------------------------------|------------------------------------------------------------|---------|
| `Basket` | `LinkedHashMap<Product, Integer> products` | `addProduct(Product product, int quantity)`          | Product is not in the basket and quantity is valid         | true    |
|          | `basketCapacity`                           |                                                      | Product is in the basket and quantity is valid             | true    |
|          | `basketQuantity`                           |                                                      | quantity is not valid                                      | false   |
|          |                                            |                                                      | if basket is full                                          | false   |
|          |                                            | `removeProduct(Product product, int quantity)`       | Product is in the basket and quantity is valid             | true    |
|          |                                            |                                                      | Product is in not the basket and quantity is valid         | false   |
|          |                                            |                                                      | quantity is not valid                                      | false   |
|          |                                            | `changeBasketCapacity(int newCapacity)`              | new capacity is valid                                      | true    |
|          |                                            |                                                      | new capacity is not valid                                  | false   |
|          |                                            | `getTotalCost()`                                     | returns total cost                                         | float   |
|          |                                            | `getPartialCost(Product product, int quantity)`      | returns cost of product and quantity                       | float   |
|          |                                            | `getReceipt()`                                       | returns receipt                                            | String  |
|          |                                            | `getProductDiscount(Product product, int quantity)`  | returns product discount amount including quantity         | float   |
|          |                                            | `leftpad(String text, int length)`                   | returns String with given width(filled with left padding)  | String  |
|          |                                            | `rightpad(String text, int length)`                  | returns String with given width(filled with left padding)  | String  |

| Class     | Members                | Methods       | Scenario                | Outputs |
|-----------|------------------------|---------------|-------------------------|---------|
| `Product` | `sku`                  | `getPrice()`  | returns product's price | float   |
|           | `price`                |               |                         |         |
|           | `name`                 |               |                         |         |
|           | `variant`              |               |                         |         |
|           | `specialOfferQuantity` |               |                         |         |
|           | `specialOfferPrice`    |               |                         |         |

| Class       | Members                             | Methods                   | Scenario                                   | Outputs  |
|-------------|-------------------------------------|---------------------------|--------------------------------------------|----------|
| `Inventory` | `HashMap<String, Product> products` | `getProduct(String sku)`  | returns specific product from inventory    | Product  |

