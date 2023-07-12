| Class  | Attributes                                        | Methods                                 | Scenarios                                                               | Output  |
|--------|---------------------------------------------------|-----------------------------------------|-------------------------------------------------------------------------|---------|
| Basket | int capacity                                      | addItem(String name, String variant)    | user can add item to basket                                             | void    |
|        | HashMap<Item item, Integer quantity> shoppingList | removeItem(String name, String variant) | user can remove item from basket                                        | boolean |
|        |                                                   | isBasketFull()                          | user wants to know if the basket is full while adding new item          | boolean |
|        |                                                   | changeCapacity(int capacity)            | user can change the capacity of basket                                  | boolean |
|        |                                                   | totalCost()                             | user wants no know the total cost of basket                             | double  |

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


| Class     | Attributes                | Methods                                               | Scenarios                                   | Output   |
|-----------|---------------------------|-------------------------------------------------------|---------------------------------------------|----------|
| Inventory | ArrayList<Item> itemsList |                                                       |                                             |          |
|           |                           | searchInventory(String name, String variant):Optional | system searches if item exists in inventory | Optional |
