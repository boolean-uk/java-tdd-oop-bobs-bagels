| Classes         | Members                           | Methods                                    | Scenario                         | Results                      |
|-----------------|-----------------------------------|--------------------------------------------|----------------------------------|------------------------------|
| `Basket`        | `Arraylist<InventoryItem> list`   | `addBagel(String variant, int price)`      | 1. + 10.                         |                              |
|                 |                                   |                                            | bagel added successfully         | Output success message       |
|                 | `int capacity`                    |                                            |                                  | Update the basket list       |
|                 |                                   |                                            |                                  | Return true                  |
|                 | `Arraylist<InventoryItem> basket` |                                            | 3.                               |                              |
|                 |                                   |                                            | fail to add bagel                | Output failure message       |
|                 |                                   |                                            | basket is full                   | Don't update the basket list |
|                 |                                   |                                            |                                  | Return false                 |
|                 |                                   | `remove(String variant)`                   | 2.                               |                              |
|                 |                                   |                                            | bagel removed successfully       | Output success message       |
|                 |                                   |                                            |                                  | Update the basket list       |
|                 |                                   |                                            |                                  | Return true                  |
|                 |                                   |                                            | 5.                               |                              |
|                 |                                   |                                            | fail because bagel doesn't exist | Output failure message       |
|                 |                                   |                                            |                                  | Don't update the basket list |
|                 |                                   |                                            |                                  | Return false                 |
|                 |                                   | `setCapacity(int newCapacity)`             | 4.                               |                              |
|                 |                                   |                                            | change basket capacity           | Output success message       |
|                 |                                   |                                            |                                  | Update the basket list       |
|                 |                                   |                                            |                                  | Return true                  |
|                 |                                   |                                            | 4.                               |                              |
|                 |                                   | `getCapacity()`                            | Get the capacity of the basket   | Return int                   |
|                 |                                   |                                            |                                  |                              |
|                 |                                   |                                            | 4.                               |                              |
|                 |                                   |                                            | fail to change basket capacity   | Output failure message       |
|                 |                                   |                                            | there are items in basket        | Don't update basket list     |
|                 |                                   |                                            |                                  | Return false                 |
|                 |                                   | `totalCost()`                              | 6.                               |                              |
|                 |                                   |                                            | there are items in basket        | Return the total cost        |
|                 |                                   |                                            |                                  | Return double                |
|                 |                                   |                                            | 6.                               |                              |
|                 |                                   |                                            | empty basket                     | Return 0                     |
|                 |                                   |                                            |                                  | Return empty double          |
|                 |                                   | `showBagelCost(String variant)`            | 7.                               |                              |
|                 |                                   |                                            | get the cost of a bagel          | Return the cost of a bagel   |
|                 |                                   |                                            |                                  | Return double                |
|                 |                                   | `addFilling(String variant, double price)` | 8. + 10.                         |                              |
|                 |                                   |                                            | add filling successfully         | Output success message       |
|                 |                                   |                                            |                                  | Update the basket list       |
|                 |                                   |                                            |                                  | Return true                  |
|                 |                                   |                                            | 8.                               |                              |
|                 |                                   |                                            | fail to add filling              | Output failure message       |
|                 |                                   |                                            | filling doesn't exist            | Don't update basket list     |
|                 |                                   |                                            |                                  | Return false                 |
|                 |                                   | `showFillingCost(String variant)`          | 9.                               |                              |
|                 |                                   |                                            | get the cost of a filling        | Return the cost of a filling |
|                 |                                   |                                            |                                  | Return double                |
|                 |                                   |                                            |                                  |                              |
|                 |                                   |                                            |                                  |                              |
| `InventoryItem` | `String sku`                      | `setSku()`                                 | Return sku                       | void                         |
|                 | `double price`                    | `getSku(String sku)`                       | Get the sku                      | Return String                |
|                 | `String name`                     | `setPrice()`                               | Return price                     | void                         |
|                 | `String variant`                  | `getPrice(double price)`                   | Get the price                    | Return double                |
|                 |                                   | `setName()`                                | Return name                      | void                         |
|                 |                                   | `getName(String name)`                     | Get the name                     | Return String                |
|                 |                                   | `setVariant()`                             | Return variant                   | void                         |
|                 |                                   | `getVariant(String variant)`               | Get the variant                  | Return String                |
|                 |                                   |                                            |                                  |                              |
|                 |                                   |                                            |                                  |                              |
