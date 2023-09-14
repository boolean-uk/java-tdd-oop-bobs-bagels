# Domain Model

| Classes   | Attributes                 | Methods                        | Scenario                      | Output |
|-----------|----------------------------|--------------------------------|-------------------------------|--------|
| Basket    | int capacity               | addItem(Item item)             | basket is not full            |        |
|           |                            |                                | - item not yet in basket      |        |
|           |                            |                                | - item already in basket      |        |
|           |                            |                                | basket is full                |        |
|           | Map<Item,Integer> itemsMap | removeItem(Item item)          | item exists                   |        |
|           |                            |                                | item does not exist           |        |
|           |                            | isFull()                       |                               | true   |
|           |                            |                                |                               | false  |
|           |                            | getItemCost()                  | item in the basket            | String |
|           |                            |                                | item not in the basket        |        |
|           |                            | getTotal()                     | items in the basket           |        |
|           |                            |                                | no items in the basket        |        |
|           |                            | addFilling()                   | filling option exists         |        |
|           |                            |                                | filling option does not exist |        |
|           |                            | getCapacity()                  |                               | int    |
|           |                            | getFillingCost()               |                               | int    |
|           |                            | setCapacity(int amount)        |                               | void   |
| .......   | .......................... | .......................        | ........................      | ...... |
| Inventory | ArrayList<Item> items      | itemExists()                   |                               | true   |
|           |                            |                                |                               | false  |
| .......   | .......................... | .......................        | ........................      | ...... |
| Item      | String SKU                 | getters                        |                               |        |
|           | double price               | setters?                       |                               |        |
|           | String name                |                                |                               |        |
|           | String variant             |                                |                               |        |
| ......... | .........................  | ......................         | ............................. | ...... |
| Bagel     |                            | addFilling(Filling filling)    |                               | true   |
|           |                            |                                |                               | false  |
|           |                            | removeFilling(Filling filling) |                               | true   |
|           |                            |                                |                               | false  |
|           |                            | getTotalCost                   |                               | double |
|           |                            |                                |                               |        |
|           |                            |                                |                               |        |
|           |                            |                                |                               |        |
| Coffee    |                            |                                |                               |        |
|           |                            |                                |                               |        |
|           |                            |                                |                               |        |
|           |                            |                                |                               |        |
| Filling   | String name                | getters                        |                               |        |
|           | double price               | setters                        |                               |        |
