
## Item Class

| Methods                | Variables         | Scenario                           | Output         |
|------------------------|-------------------|------------------------------------|----------------|
|                        | `String sku `     |                                    |                |
|                        | `String name `    |                                    |                |
|                        | `String variant ` |                                    |                |
|                        | `float price `    |                                    |                |
| `String getSku() `     |                   | Want to get the id of an item      | Return sku     |
| `String getName() `    |                   | Want to get the name of an item    | Return name    |
| `String getVariant() ` |                   | Want to get the variant of an item | Return variant |
| `float getPrice() `    |                   | Want to get the price of an item   | Return price   |
|                        |                   |                                    |                |
|                        |                   |                                    |                |
|                        |                   |                                    |                |


## Basket Class

| Methods                            | Variables                | Scenario                             | Output                         |
|------------------------------------|--------------------------|--------------------------------------|--------------------------------|
|                                    | `ArrayList<Item> items ` |                                      |                                |
|                                    | `boolean isFull `        |                                      |                                |
|                                    | `int capacity `          |                                      |                                |
|                                    |                          |                                      |                                |
| `void addItem(String itemSku) `    |                          | Want to add item to basket with room | Adds item to basket            |
|                                    |                          | Want to add item to full basket      | Informs about full basket      |
| `void removeItem(String itemSku) ` |                          | Want to remove existing item         | Removes item from basket       |
|                                    |                          | Want to remove non-existent item     | Inform about non-existing item |
| `void checkCapacity() `            |                          | Want to check if basket is full      | Updated isFull if needed       |
| `void changeCapacity(int newCap) ` |                          | Want to change basket capacity       | Change capacity to newCap      |
| `float totalCost() `               |                          | Want to know cost of basket          | Add together and return sum    |
| `boolean containsItem() `          |                          | Item is in basket                    | True                           |
|                                    |                          | Item is not in basket                | False                          |
| `boolean containsItem() `          |                          | Item is in basket                    | True                           |


## Inventory Class

| Methods                               | Variables                                    | Scenario                           | Output                          |
|---------------------------------------|----------------------------------------------|------------------------------------|---------------------------------|
|                                       | `HashMap<String item, int stock> inventory ` |                                    |                                 |
| `boolean checkStock(String itemSku) ` |                                              | Want to check if there is stock    | Returns if item in stock or not |
| `void addItem(String itemSku) `       |                                              | Want to add item to inventory      | Updates inventory               |
| `void removeItem(String itemSku) `    |                                              | Want to remove item from inventory | Updates inventory               |

