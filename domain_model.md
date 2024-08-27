| Classes   | Attributes                   | Methods                     | Scenarios                       | Outputs                     |
|-----------|------------------------------|-----------------------------|---------------------------------|-----------------------------|
| Basket    | ArrayList<Item> listOfBasket | addItem(Item item)          | If basket is not full           | Added item to the basket    |
|           | Int capacity                 |                             | If basket is full               | Error: Basket is full       |
|           | Inventory inventory          |                             |                                 |                             |
|           |                              | removeBagel(Item item)      | If Item exist                   | Removes item from basket    |
|           |                              |                             | If item not exist               | Error: Item does not exist  |
|           |                              |                             |                                 |                             |
|           |                              | getTotalCost()              | Calculating the cost            | double price                |
|           |                              |                             |                                 |                             |
|           |                              | getListOfBasket()           | Always                          | List of items in the basket |
|           |                              |                             |                                 |                             |
|           |                              | setCapacity()               | Always                          | void                        |
|           |                              |                             |                                 |                             |
|           |                              | getCapacity()               | Always                          | returns basketcapacity      |
|           |                              |                             |                                 |                             |
|           |                              |                             |                                 |                             |
| Item      | String sku                   | getSku()                    | Always                          | String sku                  |
|           | double price                 |                             |                                 |                             |
|           | String name                  | getPrice()                  | If item exist                   | double price                |
|           |                              |                             |                                 |                             |
|           |                              | getName()                   | If item exist                   | String name                 |
|           |                              |                             |                                 |                             |
| Bagel     | Bagelvariant variant         | getVariant()                | If variant exist                | enum variant                |
|           | Filling filling              |                             |                                 |                             |
|           |                              | getFilling()                | If filling exist                | Getting filling from Bagel  |
|           |                              |                             |                                 |                             |
|           |                              | setFilling()                | If filling exist                | Setting new filling         |
|           |                              |                             |                                 |                             |
| Inventory | Map<String, Item> items      | getItem(String sku)         | If item is available            | Getting String sku          |
|           |                              |                             |                                 |                             |
|           |                              | isItemAvailable(String sku) | If item available               | true                        |
|           |                              |                             | If item not available           | false                       |
|           |                              |                             |                                 |                             |
|           |                              | addItem(Item item)          | Adding an item to the inventory | Added to the hashmap        |
|           |                              |                             |                                 |                             |
| Coffee    | String coffeeType            | getCoffeeType()             | Always                          | Return coffeetype as string |
|           |                              |                             |                                 |                             |
| Filling   | String fillingType           | getFillingType()            | Retrieving the fillingType      | String fillingType          |
