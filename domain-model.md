| Class   | Methods                                                      | Scenario                                                     | Outcome                                                      |
| ------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Client  | orderBagel(BagelType type, List\<FillingType\> fillingTypes) | Client orders a bagel and bagel type is in manager's inventory and client's basket is not full and all filling types are in manager's inventory | Bagel is added to his basket                                 |
|         |                                                              | Client orders a bagel and bagel type or filling type is not present in manager's inventory | Exception is thrown                                          |
|         |                                                              | Client orders a bagel but his basket is full                 | Appropriate message is printed, bagel is not added to basket |
|         | cancelBagelOrder(Bagel bagel)                                | Client wants to remove bagel from his order and it is present in the order | Bagel is removed from the basket                             |
|         |                                                              | Client wants to remove bagel from his order and it is not present in the order | Print information that this bagel is not present in the basket |
|         | getBasketTotalCost(): int                                    | Client wants to see the total cost of items in his basket    | Total cost of items in basket is returned                    |
|         | checkBagelPrice(Bagel bagel): int                            | Clients wants to check price of specific bagel               | Bagel price is returned                                      |
|         | checkFillingPrice(FillingType type) : int                    |                                                              | Return filling price                                         |
|         |                                                              |                                                              |                                                              |
| Basket  | addToBasket(BagelType type)                                  |                                                              |                                                              |
|         | removeFromBasket(Bagel bagel)                                |                                                              |                                                              |
|         | isBasketFull(): boolean                                      |                                                              |                                                              |
|         | getTotalCost(): int                                          |                                                              |                                                              |
|         |                                                              |                                                              |                                                              |
| Product | getPrice()                                                   |                                                              |                                                              |
|         |                                                              |                                                              |                                                              |
|         |                                                              |                                                              |                                                              |
|         |                                                              |                                                              |                                                              |
| Manager | changeBasketsCapacity(int newCapacity)                       | newCapacity >= Basket.getCapacity()                          | New capacity is set for all baskets                          |
|         |                                                              | newCapacity < Basket.getCapacity()                           | Exception is thrown                                          |

Enum BagelType

Client fields: Basket basket

Basket fields: static int capacity

Product: String SKU, double price, List\<FeelingType\> feelings

Manager: static final List\<Product\> inventory