# Domain model

Assuming that

- A bagel can only have 0 or 1 filling

BobsBagel class:

| Member variables | Methods                             | Scenario                            | Outputs |
|------------------|-------------------------------------|-------------------------------------|---------|
| `inventory`      | `productIsInStock(Product product)` | `The given product is in stock`     | `true`  |
|                  |                                     | `The given product is not in stock` | `false` |

Basket class:

| Member variables            | Methods                                              | Scenario                                                    | Outputs |
|-----------------------------|------------------------------------------------------|-------------------------------------------------------------|---------|
| `HashMap<Product, Integer>` | `add(Product product)`                               | Successfully product added to basket                        | true    |
| `HashMap<Product, Integer>` | `remove(Product product)`                            | Successfully removed from basket                            | true    |
|                             |                                                      | Failed to remove from basket                                | false   |
|                             | `isFull()`                                           | Basket is full                                              | true    |
|                             |                                                      | Basket is not full                                          | false   |
| `maxCapacity`               | `changeCapacity(int newCapacity, boolean isManager)` | Successfully changed capacity of baskets                    | true    |
|                             |                                                      | Failed to change capacity of baskets (e.g., is not manager) | false   |
| `HashMap<Product, Integer>` | `getTotalCost()`                                     | there is atleast one product in the basket                  | double  |
|                             |                                                      | there are no products in the basket                         | 0       |

Product class:

| Member variables | Methods      | Scenario                                        | Outputs  |
|------------------|--------------|-------------------------------------------------|----------|
| `price`          | `getPrice()` | `A customer wants to know this product's price` | `double` |

Bagel class:

| Member variables | Methods                          | Scenario                                    | Outputs        |
|------------------|----------------------------------|---------------------------------------------|----------------|
| `currentFilling` | `setFilling(Filling newFilling)` | `A customer chooses a filling successfully` | `true/success` |
|                  |                                  | `Filling already exists on the bagel`       | `false/fail`   |
