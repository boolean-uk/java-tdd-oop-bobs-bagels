| Class     | Methods                            | Scenario                            | Outcome                              |
|-----------|------------------------------------| ----------------------------------- |--------------------------------------|
| Basket    | addToBasket(Bagel bagelType)       | Bagel type exists                   | bagel is added to basket             |
|           |                                    | Bagel type does not exist           | exception is thrown                  |
|           | removeFromBasket(Bagel  bagelType) | Bagel type is in the basket         | bagel is removed from the basket     |
|           |                                    | Bagel type is not in the basket     | Print info that bagel is not present |
|           | isBasketFull()                     | Basket is full                      | return true                          |
|           |                                    | Basket is not full yet              | return false                         |
|           | setBasketCapacity(int newCapacity) | new capacity is < current capacity  | exception is thrown                  |
|           |                                    | new capacity is >= current capacity | capacity is set to newCapacity       |
|           | getTotalCost()                     |                                     | int                                  |
| Inventory | getInventoryItems()                |                                     | List<Bagel>,List<Cofee>              |
| Bagel     | getCost()                          |                                     | int                                  |
|           | addFilling()                       |                                     |                                      |
| Customer  | addBagelToBasket()                 |                                     |                                      |
|           | addCofeeToBasket()                 |                                     |                                      |
|           | checkBasket()                      |                                     | List<Bagel>,List<Cofee>              |
| Manager   | setBasketCapacity(int newCapacity) |                                     |                                      |
