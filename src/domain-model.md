# Bob's bagels

## Menu
| Method            | Member variable             | Scenario                               | Result                      |
|-------------------|-----------------------------|----------------------------------------|-----------------------------|
|                   | ArrayList<item> itemsOnMenu |                                        |                             |
| seePrice()        |                             | There are items in the inventory       | String show price           |
|                   |                             | There are no items in the inventory    | String error message        |
|                   |                             |                                        |                             |
| showAllFillings() |                             | There are fillings in the inventory    | String list of all fillings |
|                   |                             | There are no fillings in the inventory | String error message        |
|                   |                             |                                        |                             |
| getter and setter |                             |                                        |                             |


## Inventory
| Method                            | Member variable           | Scenario                               | Result |
|-----------------------------------|---------------------------|----------------------------------------|--------|
|                                   | Arraylist<Item> inventory |                                        |        |
| getter and setter                 |                           |                                        |        |
|                                   |                           |                                        |        |
| isContainedInInventory(Item item) |                           | item is contained in the inventory     | true   |
|                                   |                           | item ia not contained in the inventory | false  |


## Basket
| Method                 | Member variable               | Scenario                            | Result                      |
|------------------------|-------------------------------|-------------------------------------|-----------------------------|
| addItem()              | ArrayList<Item> itemsInBasket | basket is full                      | String Error message        |
|                        | int size                      | basket is not full                  | String success message      |
|                        |                               |                                     |                             |
| removeItem(Item aItem) |                               | item is not contained in basket     | String Error message        |
|                        |                               | item is contained in basket         | String success message      |
|                        |                               |                                     |                             |
| changeSizeOfBasket()   |                               | entering acceptable size            | True                        |
|                        |                               | entering non-acceptable size        | False                       |
|                        |                               |                                     |                             |
| totalCost()            |                               | basket consists of more than 1 item | double total cost of basket |
|                        |                               | basket dont consist any items       | 0                           |
|                        |                               |                                     |                             |


## Items
| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Float price         |          |        |
|                     | String abbreviation |          |        |
|                     | String name         |          |        |
| getters and setters |                     |          |        |


## Coffee
| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Float price         |          |        |
|                     | String abbreviation |          |        |
|                     | String name         |          |        |
| getters and setters |                     |          |        |


## Bagel
| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Float price         |          |        |
|                     | String abbreviation |          |        |
|                     | String name         |          |        |
| getters and setters |                     |          |        |


## Filling
| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Float price         |          |        |
|                     | String abbreviation |          |        |
|                     | String name         |          |        |
| getters and setters |                     |          |        |