| Class  | Attributes                                        | Methods                      | Scenarios                                                               | Output  |
|--------|---------------------------------------------------|------------------------------|-------------------------------------------------------------------------|---------|
| Basket | int capacity                                      | addBagel(Bagel bagel)        | user can add specific type of bagel to basket                           | void    |
|        | HashMap<Item item, Integer quantity> shoppingList | removeBagel(Bagel bagel)     | user can remove bagel from basket                                       | boolean |
|        |                                                   | isBasketFull()               | user wants to know if the basket is full while adding new item          | boolean |
|        |                                                   | changeCapacity(int capacity) | user can change the capacity of basket                                  | boolean |
|        |                                                   | isInBasket()                 | user wants to know when he tries to remove nonexistent item from basket | boolean |
|        |                                                   | totalCost()                  | user wants no know the total cost of basket                             | double  |
|        |                                                   | checkPrice(String variant)   | user wants to check the item price                                      | double  |
|        |                                                   | addFilling(Bagel bagel)      | user wants to add fillings to the bagel                                 |         |

| Class | Attributes     | Methods | Scenarios | Output |
|-------|----------------|---------|-----------|--------|
| Item  | String SKU     |         |           |        |
|       | String name    |         |           |        |
|       | double price   |         |           |        |
|       | String variant |         |           |        |

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
