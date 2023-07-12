| Classes | Attributes             | Methods                    | Scenarios                                                                    | Output     |
|---------|------------------------|----------------------------|------------------------------------------------------------------------------|------------|
| Basket  | int capacity           | addBagel(String bagel)     | user wants to add bagel to basket                                            | void       |
|         | List<Bagel> bagels     | removeBagel(String bagel)  | user wants to remove bagel from basket                                       | void       |
|         | Manager manager        | basketIsFull()             | user wants to know if basket is full when adding item beyond basket capacity | System out |
|         |                        | isBagelInBasket()          | user wants to check if bagel is in basket                                    | boolean    |
|         |                        | removeBagel(String bagel)  | user wants to know if trying to remove an item that is not in the basket     | System out |
|         |                        | totalBasketCost()          | user wants to know total cost of a basket                                    | double     |
| Bagel   | List<Filling> fillings | bagelCost()                | user wants to know the bagel cost                                            | double     |
|         |                        | addFilling()               | user want to add filling to the bagel                                        | void       |
| Filling | double price           | getPrice()                 | user wants to know the price of a filling                                    | double     |
| Manager | int basketCapacity;    | setCapacity(int capacity)  | manager wants to change basket capacity                                      | void       |
|         |                        |                            |                                                                              |            |
