| Class  | Attributes                                        | Methods                      | Scenarios                                                               | Output  |
|--------|---------------------------------------------------|------------------------------|-------------------------------------------------------------------------|---------|
| Basket | int capacity                                      | addItem(Item item)           | user can add item to basket                                             | void    |
|        | HashMap<Item item, Integer quantity> shoppingList | removeItem(Item item)        | user can remove item from basket                                        | boolean |
|        |                                                   | isBasketFull()               | user wants to know if the basket is full while adding new item          | boolean |
|        |                                                   | changeCapacity(int capacity) | user can change the capacity of basket                                  | boolean |
|        |                                                   | isInBasket()                 | user wants to know when he tries to remove nonexistent item from basket | boolean |
|        |                                                   | totalCost()                  | user wants no know the total cost of basket                             | double  |

| Class | Attributes     | Methods    | Scenarios                             | Output |
|-------|----------------|------------|---------------------------------------|--------|
| Item  | String SKU     | checkPrice | user wants to check the price of item | double |
|       | String name    |            |                                       |        |
|       | double price   |            |                                       |        |
|       | String variant |            |                                       |        |
|       |                |            |                                       |        |

| Class | Attributes     | Methods | Scenarios | Output |
|-------|----------------|---------|-----------|--------|
| Bagel | String SKU     |         |           |        |
|       | String name    |         |           |        |
|       | double price   |         |           |        |
|       | String variant |         |           |        |


| Class  | Attributes     | Methods | Scenarios | Output |
|--------|----------------|---------|-----------|--------|
| Coffee | String SKU     |         |           |        |
|        | String name    |         |           |        |
|        | double price   |         |           |        |
|        | String variant |         |           |        |


| Class   | Attributes     | Methods | Scenarios | Output |
|---------|----------------|---------|-----------|--------|
| Filling | String SKU     |         |           |        |
|         | String name    |         |           |        |
|         | double price   |         |           |        |
|         | String variant |         |           |        |


| Class     | Attributes                | Methods | Scenarios | Output |
|-----------|---------------------------|---------|-----------|--------|
| Inventory | ArrayList<Item> itemsList |         |           |        |
