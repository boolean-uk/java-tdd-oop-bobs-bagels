# Domain Model

| Classes          | Methods                         | Fields                                  | Scenario                                    | Output    |
|------------------|---------------------------------|-----------------------------------------|---------------------------------------------|-----------|
| Basket           |                                 | int capacity, List<Item> items          |                                             |           |
|                  | add(Item item)                  |                                         | adding item to basket if basket is not full | void      |
|                  |                                 |                                         | if basket is full                           | Exception |
|                  | remove(Item item)               |                                         | remove provided item if is in the basket    | void      |
|                  |                                 |                                         | if provided item is not in the basket       | Exception |
|                  | isFull()                        |                                         | if basket is full                           | true      |
|                  |                                 |                                         | if basket is not full                       | false     |
|                  | changeCapacity(int newCapacity) |                                         | set new capacity                            |           |
|                  | checkIfExists(Item item)        |                                         | if provided bagel is in a basket            | true      |
|                  |                                 |                                         | if provided bagel is not in a basket        | false     |
|                  | getTotalCost()                  |                                         | return total cost of items in the basket    | double    |
|                  |                                 |                                         |                                             |           |
|                  |                                 |                                         |                                             |           |
| Item             |                                 | long price                              |                                             |           |
|                  |                                 |                                         |                                             |           |
|                  |                                 |                                         |                                             |           |
| Bagel : Item     |                                 | BagelType type, FillingType fillingType |                                             |           |
|                  |                                 |                                         |                                             |           |
| Coffee : Item    |                                 | CoffeeType type                         |                                             |           |
|                  |                                 |                                         |                                             |           |
| Enum BagelType   |                                 | long price, String name                 |                                             |           |
|                  |                                 |                                         |                                             |           |
| Enum CoffeeType  |                                 | long price, String name                 |                                             |           |
|                  |                                 |                                         |                                             |           |
| Enum FillingType |                                 | long price, String name                 |                                             |           |
|                  |                                 |                                         |                                             |           |

