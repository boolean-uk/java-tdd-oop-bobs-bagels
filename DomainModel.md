# Domain Model

| Classes   | Attributes                 | Methods                 | Scenario                 | Output |
|-----------|----------------------------|-------------------------|--------------------------|--------|
| Basket    | int capacity               | addItem(Item item)      | basket is not full       |        |
|           |                            |                         | - item not yet in basket |        |
|           |                            |                         | - item already in basket |        |
|           |                            |                         | basket is full           |        |
|           | Map<Item,Integer> itemsMap | removeItem(Item item)   | item exists              |        |
|           |                            |                         | item does not exist      |        |
|           |                            | isFull()                |                          | true   |
|           |                            |                         |                          | false  |
|           |                            | getBill()               | items in the basket      | String |
|           |                            |                         | no items in the basket   |        |
|           |                            | getTotal()              | items in the basket      |        |
|           |                            |                         | no items in the basket   |        |
|           |                            | placeOrder()            | items in the basket      |        |
|           |                            |                         | no items in the basket   |        |
|           |                            | getCapacity()           |                          | int    |
|           |                            | setCapacity(int amount) |                          | void   |
| .......   | .......................... | ....................... | ........................ | ...... |
| Inventory | ArrayList<Item> items      | itemExists()            |                          | true   |
|           |                            |                         |                          | false  |
| .......   | .......................... | ....................... | ........................ | ...... |
| Item      | String SKU                 | getters                 |                          |        |
|           | double price               | setters?                |                          |        |
|           | String name                |                         |                          |        |
|           | String variant             |                         |                          |        |
|           |                            |                         |                          |        |
|           |                            |                         |                          |        |
|           |                            |                         |                          |        |
|           |                            |                         |                          |        |
|           |                            |                         |                          |        |
