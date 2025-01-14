# Bob's bagels

## Menu
| Method                            | Member variable             | Scenario                                  | Result                   |
|-----------------------------------|-----------------------------|-------------------------------------------|--------------------------|
|                                   | ArrayList<item> itemsOnMenu |                                           |                          |
| seePrice(Item anItem)             |                             | The item exist in the inventory           | String show price        |
|                                   |                             | The item dont exist in the inventory      | String error message     |
|                                   |                             |                                           |                          |
| showAllFillingsWithCosts()        |                             | List all fillings in that are on the menu | String with all fillings |
|                                   |                             |                                           |                          |
|                                   |                             |                                           |                          |
| isContainedInInventory(Item item) |                             | item is contained in the inventory        | True                     |
|                                   |                             | item is not contained in the inventory    | False                    |


## Basket
| Method                          | Member variable               | Scenario                          | Result                                      |
|---------------------------------|-------------------------------|-----------------------------------|---------------------------------------------|
| addItem(Item anItem)            | ArrayList<Item> itemsInBasket | basket is full                    | String Error message                        |
|                                 | int size                      | basket is not full                | String success message                      |
|                                 |                               |                                   |                                             |
| removeItem(Item anItem)         |                               | item is not contained in basket   | String Error message                        |
|                                 |                               | item is contained in basket       | String success message                      |
|                                 |                               |                                   |                                             |
| changeSizeOfBasket(int newSize) |                               | entering acceptable size          | True                                        |
|                                 |                               | entering non-acceptable size      | False                                       |
|                                 |                               |                                   |                                             |
| totalCost()                     |                               | basket consists of atleast 1 item | Double total cost of basket                 |
|                                 |                               | basket dont consist any items     | 0                                           |
|                                 |                               |                                   |                                             |
| //EXTENSION                     |                               |                                   |                                             |
| totalCostWithDiscounts()        |                               | discounts are received            | Double total cost of basket minus discounts |
|                                 |                               | discounts are not received        | Double total cost of basket                 |


## Items
| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Double price        |          |        |
|                     | String abbreviation |          |        |
|                     | String name         |          |        |
|                     | String typeOfItem   |          |        |
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



// EXTENSION
## Receipt

| Method         | Member Variable                               | Scenario                          | Result                                      |
|----------------|-----------------------------------------------|-----------------------------------|---------------------------------------------|
|                | HashMap<Item, Quantity> itemsThatArePurchased |                                   |                                             |
|                | DateTime dateOfPurchase                       |                                   |                                             |
| printReceipt() |                                               | basket consists of atleast 1 item | String receipt returned and is also printed |
|                |                                               | basket dont contain any items     | String Error message                        |
|                |                                               |                                   |                                             |
|                |                                               |                                   |                                             |
