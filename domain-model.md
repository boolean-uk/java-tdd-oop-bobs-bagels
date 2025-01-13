# Bobs bagels

## Item

| Method              | Member Variable     | Scenario | Result |
|---------------------|---------------------|----------|--------|
|                     | Double price        |          |        |
|                     | String name         |          |        |
|                     | String abbreviation |          |        |
| Getters and setters |                     |          |        |

### Bagel
#### SesameBagel
#### OnionBagel
#### EverythingBagel
#### PlainBagel

### Filling
#### HamFilling
#### SmokedSalmonFilling
#### CreamCheeseFilling
#### CheeseFilling
#### EggFilling
#### BaconFilling

### Coffee
#### BlackCoffee
#### WhiteCoffee
#### CappuccinoCoffee
#### LatteCoffee

## Basket
| Method                       | Member Variable       | Scenario                                           | Result                         |
|------------------------------|-----------------------|----------------------------------------------------|--------------------------------|
|                              | Double price          |                                                    |                                |
|                              | String name           |                                                    |                                |
|                              | String abbreviation   |                                                    |                                |
|                              | ArrayList<Item> items |                                                    |                                |
|                              | Int basketSize        |                                                    |                                |
| add(Item item)               |                       | Adding an item to a basket which is not full       | String "successfully added"    |
|                              |                       | Adding an item to a basket which is full           | String "Basket is full"        |
|                              |                       | Adding an item not in inventory to a basket        | String "Item not in inventory" |
|                              |                       |                                                    |                                |
| remove(String item)          |                       | Removing an existing item                          | String "Successfully removed"  |
|                              |                       | Removing an item that does not exist               | String "No item found"         |
|                              |                       |                                                    |                                |
| resizeBasket(int newSize)    |                       | Resizing the basket to an accepted size            | true                           |
|                              |                       | Resizing the basket to an unaccepted size          | false                          |
|                              |                       |                                                    |                                |
| calculateTotalCostOfBasket() |                       | Trying to calculate cost of a basket with items    | Int totalCost                  |
|                              |                       | Trying to calculate cost of a basket with no items | Int 0                          |

## Menu

| Method                           | Member Variable                | Scenario                                                     | Result                   |
|----------------------------------|--------------------------------|--------------------------------------------------------------|--------------------------|
|                                  | ArrayList<Item> allUniqueItems |                                                              |                          |
| listAllFillingPrices()           |                                | List all the filling prices in the Menu and are in inventory | String prices            |
|                                  |                                |                                                              |                          |
| checkCostOfItem(String itemName) |                                | Check cost of an item that exists                            | String "Price: " + price |
|                                  |                                | Check cost of an item that does not exist                    | String "No item found"   |
|                                  |                                |                                                              |                          |
| isInInventory(String itemName)   |                                | Search for an item currently in inventory                    | true                     |
| isInInventory(String itemName)   |                                | Search for an item currently not in inventory                | false                    |



