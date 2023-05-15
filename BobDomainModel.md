## Basket

| Members                 | Methods                                         | Scenario                                                                           | Outcome/Output                                                                      | User story |
|-------------------------|-------------------------------------------------|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|------------|
| `ArrayList<Item> items` |                                                 |                                                                                    |                                                                                     |            |
| `Inventory inventory`   |                                                 |                                                                                    |                                                                                     |            |
| `int basketCapacity`    |                                                 |                                                                                    |                                                                                     |            |
| `double sumCosts`       |                                                 |                                                                                    |                                                                                     |            |
|                         | `Basket(Inventory inventory)`                   |                                                                                    |                                                                                     |            |
|                         | `boolean addItem(String sku)`                   | Items are successfully added to the basket.                                        | Return true.                                                                        | 1 + 8      |
|                         |                                                 | Items not added because basketCapacity has been reached.                           | Print message stating basket is full and return false.                              | 1 + 3      |
|                         |                                                 | Items not added because does not exist in inventory.                               | Print message item does not exist return false.                                     | 10         |
|                         |                                                 |                                                                                    |                                                                                     |            |
|                         | `boolean removeItem(String sku)`                | Item removed successfully from the basket.                                         | Return true.                                                                        | 2          |
|                         |                                                 | Item not removed because it does not exist in the basket.                          | Print message stating that the bagel does not exist in the basket and return false. | 2 + 5      |
|                         | `boolean updateBasketCapacity(int newCapacity)` | Basket capacity successfully updated.                                              | Return true.                                                                        | 4          |
|                         |                                                 | Basket capacity cannot be updated to 0 or negative number.                         | Print error message + return false.                                                 | 4          |
|                         |                                                 | Basket capacity cannot be made smaller than current basket size.                   | Print error message + return false.                                                 | 4          |
|                         | `double totalCost()`                            | The basket is empty.                                                               | Return 0.00.                                                                        | 6          |
|                         |                                                 | The basket contains items.                                                         | Return total costs.                                                                 | 6          |
|                         |                                                 | The basket contains items with discount                                            | Return total costs includes discount.                                               |            |
|                         |                                                 | (6/12 combo discount applies first then the coffee (black) & bagel (plain) combo). |                                                                                     |            |(
|                         | `double itemPrice(String sku)`                  | If item exists in inventory.                                                       | Return price.                                                                       | 7 + 9      |
|                         |                                                 | If item does not exist in inventory.                                               | Print item does not exist Return 0.00.                                              | 7 + 9      |
|                         |                                                 |                                                                                    |                                                                                     |            |
|                         |                                                 |                                                                                    |                                                                                     |            |


# Item

| Members          | Method                                                         | Scenario | Outcome/Output                                                                                       | UserStory |
|------------------|----------------------------------------------------------------|----------|------------------------------------------------------------------------------------------------------|-----------|
| `String type`    |                                                                |          |                                                                                                      |           |
| `double price`   |                                                                |          |                                                                                                      |           |
| `String sku`     |                                                                |          |                                                                                                      |           |
| `String variant` |                                                                |          |                                                                                                      |           |
|                  | `Item(String type, double price, String sku, String variant)`  |          |                                                                                                      |           |
|                  | `String toString()`                                            |          | Returns a String with details of the above four variables laid out in a manner that is easy to read. |           |


# Inventory

| Members                          | Method                                      | Scenario             | Outcome/Output                                                           | UserStory |
|----------------------------------|---------------------------------------------|----------------------|--------------------------------------------------------------------------|-----------|
| `ArrayList<Item> itemArrayList`  |                                             |                      |                                                                          |           |
| `HashMap<String, Item> allItems` |                                             |                      |                                                                          |           |
|                                  | `Inventory(ArrayList<Item> itemArrayList)`  |                      |                                                                          |           |
|                                  | `Item searchItem(String sku)`               | Item exists.         | Returns true.                                                            |           |
|                                  |                                             | Item does not exist. | Prints a message stating that the item does not exist and returns false. |           |

# Main

| Members                         | Method | Scenario | Outcome/output | UserStory |
|---------------------------------|--------|----------|----------------|-----------|
| `ArrayList<Item> itemArrayList` |        |          |                |           |
| `Inventory inventory`           |        |          |                |           |
| `Basket basket`                 |        |          |                |           |
