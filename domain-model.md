# Bobs bagels

## Item

| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Double price        |          |        |
|                     | String name         |          |        |
|                     | String abbreviation |          |        |
| Getters and setters |                     |          |        |

### Bagel
#### Sesame
#### Onion
#### Everything
#### Plain

### Filling
#### Ham
#### Smoked Salmon
#### Cream Cheese
#### Cheese
#### Egg
#### Bacon

### Coffee
#### Black
#### White
#### Cappuccino
#### Latte

## Basket
| Method                       | Member Variable       | Scenario                                           | Result                          |
|------------------------------|-----------------------|----------------------------------------------------|---------------------------------|
|                              | Double price          |                                                    |                                 |
|                              | String name           |                                                    |                                 |
|                              | String abbreviation   |                                                    |                                 |
|                              | ArrayList<Item> items |                                                    |                                 |
|                              | Int basketSize        |                                                    |                                 |
| add(Item item)               |                       | Adding an item to a basket which is not full       | String "successfully added"     |
|                              |                       | Adding an item to a basket which is full           | String "Basket is full"         |
|                              |                       | Adding an item not in inventory to a basket        | String "Item not in inventory"  |
|                              |                       |                                                    |                                 |
| remove(Item item)            |                       | Removing an existing item                          | String "successfully removed"   |
|                              |                       | Removing an item that does not exist               | String "could not find item"    |
|                              |                       |                                                    |                                 |
| resizeBasket(int newSize)    |                       | Resizing the basket to an accepted size            | true                            |
|                              |                       | Resizing the basket to an unaccepted size          | false                           |
|                              |                       |                                                    |                                 |
| calculateTotalCostOfBasket() |                       | Trying to calculate cost of a basket with items    | Int totalCost                   |
|                              |                       | Trying to calculate cost of a basket with no items | Int 0                           |

## Menu

| Method                     | Member Variable                | Scenario                                                     | Result                   |
|----------------------------|--------------------------------|--------------------------------------------------------------|--------------------------|
|                            | ArrayList<Item> allUniqueItems |                                                              |                          |
| listAllFillingPrices()     |                                | List all the filling prices in the Menu and are in inventory | ArrayList<String> prices |
|                            |                                |                                                              |                          |
| checkCostOfItem(Item item) |                                | Check cost of an item that exists                            | String "Price: " + price |
|                            |                                | Check cost of an item that does not exist                    | String "No item found"   |
|                            |                                |                                                              |                          |

## Inventory

| Method                             | Member Variable                  | Scenario                                      | Result                        |
|------------------------------------|----------------------------------|-----------------------------------------------|-------------------------------|
|                                    | ArrayList<Item> currentInventory |                                               |                               |
| isInInventory(Item item)           |                                  | Search for an item currently in inventory     | true                          |
|                                    |                                  | Search for an item currently not in inventory | false                         |
|                                    |                                  |                                               |                               |
| addItem(Item item)                 |                                  |                                               | String "successfully added"   |
| addItems(ArrayList<Item> items)    |                                  |                                               | String "successfully added"   |
| removeItem(Item item)              |                                  |                                               | String "successfully removed" |
| removeItems(ArrayList<Item> items) |                                  |                                               | String "successfully removed" |