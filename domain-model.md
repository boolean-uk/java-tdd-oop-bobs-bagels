
| Classes           | Members                                  | Methods                                         |
|-------------------|------------------------------------------|-------------------------------------------------|
| `Basket`          | `List<Bagel> list`                       | `addBagel(String type)`                         |
|                   | `capacity int`                           | `removeBagel(String type)`                      |
|                   |                                          | `isBasketFull()`                                |
|                   |                                          | `increaseCapacity(int newCapacity)`             |
|                   |                                          |                                                 |
| `Bagel`           | `String type`                            | `getType()`                                     |
|                   | `double cost`                            | `getTotalCost()`                                |
|                   | `List<String> selectedFillings`          | `addFilling(String filling)`                    |
|                   |                                          | `getSelectedFillings()`                         |
|                   |                                          |                                                 |
| `fillingsTable`   | `HashMap<String, Double> fillingsPrices` | `addFillingPrice(String filling, double price)` |
|                   |                                          | `getFillingCost(String filling)`                |
|                   |                                          |                                                 |
| `BagelsInventory` | `HashMap<String, Double> bagelsPrices`   | `addBagelType(String type, double cost)`        |
|                   |                                          | `removeBagelType(String type)`                  |
|                   |                                          | `isBagelTypeAvailable(String type)`             |
|                   |                                          |                                                 |
| `Manager`         |                                          | `changeBasketCapacity(int capacity)`            |
|                   |                                          | `getBagelsInventory()`                          |
|                   |                                          | `getFillingsInventory`                          |
|                   |                                          |                                                 |



