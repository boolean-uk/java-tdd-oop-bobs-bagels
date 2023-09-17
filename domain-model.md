
| Classes     | Members                                     | Methods                                                                  |
|-------------|---------------------------------------------|--------------------------------------------------------------------------|
| `Basket`    | `ArrayList<Bagel> basket`                   | `addBagel(Bagel bagel)`                                                  |
|             | `int capacity`                              | `removeBagel(Bagel bagel)`                                               |
|             |                                             | `isBasketFull()`                                                         |
|             |                                             | `setCapacity(int newCapacity)`                                           |
|             |                                             | `getTotalCost(HashMap<String, Filling> fillingInventory)<br/>`           |
|             |                                             |                                                                          |
| `Bagel`     | `String type`                               | `getPrice()`                                                             |
|             | `double price`                              | `getFillings`                                                            |
|             | `List<String> selectedFillings`             | `getType()`                                                              |
|             |                                             | `addFillings(String filling, HashMap<String, Filling> fillingsInventory` |
|             |                                             | `calculateBagelsCost<HashMap<String, FIlling> fillingInventory`          |
|             |                                             |                                                                          |
| `Filling`   | `String name`                               | `getName()`                                                              |
|             | `double cost`                               | `getCost()`                                                              |
|             |                                             |                                                                          |
| `Inventory` | `HashMap<String, Bagel> bagelInventory`     | `getBagelInventory()`                                                    |
|             | `HashMap<String, Filling> fillingInventory` | `getFillingInventory()`                                                  |
|             |                                             | `addBagelType(String bagelType, double cost)`                            |
|             |                                             | `addFilling(String filling, double price)`                               |
|             |                                             | `isBagelAvailable(String type)`                                          |
|             |                                             | `getBagelsPrice(String type)`                                            |
|             |                                             | `getFillingPrice(String name)`                                           |

