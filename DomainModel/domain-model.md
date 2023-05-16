## Domain Model

| Classes   | Attributes                                | Methods                                | Scenarios                                      | Outcomes                                                     |
|-----------|-------------------------------------------|----------------------------------------|------------------------------------------------|--------------------------------------------------------------|
| Basket    | `ArrayList<Product> products`             |                                        |                                                |                                                              |
|           | `HashMap<String, Integer> productCounter` |                                        |                                                |                                                              |
|           | `int capacity`                            |                                        |                                                |                                                              |
|           |                                           | `add(String SKU):boolean`              | 1. adds product to the basket                  | returns true                                                 |
|           |                                           |                                        | 3. basket is full                              | returns false                                                |
|           |                                           |                                        | 10. product does not exist in inventory        |                                                              |
|           |                                           | `remove(String SKU):boolean`           | 2. basket contains product                     | removes product from basket, returns true                    |
|           |                                           |                                        | 5. basket does not contain product or is empty | returns false                                                |
|           |                                           | `getCapacity():int`                    |                                                | returns basket's capacity                                    |
|           |                                           | `setCapacity(int capacity):void`       | 4. Capacity larger than current capacity       | capacity changes                                             |
|           |                                           |                                        | 4. Capacity smaller than current capacity      | capacity doesn't change                                      |
|           |                                           | `getTotalCost():double`                | 6.                                             | returns total cost                                           |
|           |                                           | `getAllFillings:Arraylist<Filling>`    |                                                | returns an arraylist of all the fillings added to the basket |
|           |                                           | `getReceipt():void`                    |                                                | prints receipt                                               |
| Bagel     | `ArrayList<Filling> fillings`             |                                        |                                                |                                                              |
|           |                                           | `addFilling(String SKU):boolean`       | 8. Filling is already added to bagel           | does not add filling, returns false                          |
|           |                                           |                                        | 8. Filling is not already added to bagel       | adds the filling, returns true                               |
| Filling   |                                           |                                        |                                                |                                                              |
| Coffee    |                                           |                                        |                                                |                                                              |
| Inventory | `ArrayList<Product> products`             |                                        |                                                |                                                              |
|           |                                           | `productIsInStock(String SKU):boolean` | 10. Product exists in inventory                | returns true                                                 |
|           |                                           |                                        | 10. Product does not exist in inventory        | returns false                                                |
| Product   | `String SKU`                              |                                        |                                                |                                                              |
|           | `String name`                             |                                        |                                                |                                                              |
|           | `double price`                            |                                        |                                                |                                                              |
|           | `String variant`                          |                                        |                                                |                                                              |
|           |                                           | `getProductCost(String SKU):double`    | 7,9.                                           | returns cost of the product                                  |
| Discount  |                                           |                                        |                                                |                                                              |
| Receipt   | `String dateTime`                         |                                        |                                                |                                                              |
|           | `ArrayList<String> productsBought`        |                                        |                                                |                                                              |
|           |                                           | `calculateDiscount():double`           |                                                | returns double                                               |

### Bagel and Filling classes inherit from Product class


EX3: