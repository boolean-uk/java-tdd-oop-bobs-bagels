## Basket Class

| Members                      | Methods                                        | Scenario                                                        | Outcome/Output                                                                     | User story |
|------------------------------|------------------------------------------------|-----------------------------------------------------------------|------------------------------------------------------------------------------------|------------|
| `ArrayList<Bagel> bagels`    |                                                |                                                                 |                                                                                    |            |
| `ArrayList<Filling> filling` |                                                |                                                                 |                                                                                    |            |
| `ArrayList<Coffee> coffee`   |                                                |                                                                 |                                                                                    |            |
| int basketCapacity           |                                                |                                                                 |                                                                                    |            |
|                              | boolean addItem(String sku)                    | Items are successfully added to the basket                      | Return true                                                                        | 1 + 8      |
|                              |                                                | Items not added because basketCapacity has been reached         | Print message stating basket is full and return false                              | 1 + 3      |
|                              |                                                | Items not added because does not exist in inventory             | Print message item does not exist Return false                                     |            |
|                              |                                                |                                                                 |                                                                                    |            |
|                              | boolean removeItem(String sku)                 | Item removed successfully from the basket                       | Return true                                                                        | 2          |
|                              |                                                | Item not removed because it does not exist in the basket        | Print message stating that the bagel does not exist in the basket and return false | 2 + 5      |
|                              | boolean updateBasketCapacity(int newCapacity)  | Basket capacity successfully updated                            | Return true                                                                        | 4          |
|                              |                                                | Basket capacity cannot be updated to 0 or negative number       | Print error message + return false                                                 | 4          |
|                              |                                                | Basket capacity cannot be made smaller than current basket size | Print error message + return false                                                 | 4          |
|                              | double totalCosts()                            | The basket is empty                                             | Return 0.00                                                                        | 6          |
|                              |                                                | The basket contains items                                       | Return total costs                                                                 | 6          |
|                              | double getPrice(String sku)                    | If item exists in inventory                                     | Return price                                                                       | 7 + 9      |
|                              |                                                | If item does not exist in inventory                             | Print item does not exist Return 0.00                                              | 7  + 9     |


# Bagel

| Members      | Method                                             | Scenario | Outcome/Output | UserStory |
|--------------|----------------------------------------------------|----------|----------------|-----------|
| String type  |                                                    |          |                |           |
| double price |                                                    |          |                |           |
| String sku   |                                                    |          |                |           |
|              | constructor(String type, double price, String sku) |          |                |           |


# Coffee

| Members      | Method                                               | Scenario | Outcome/Output | UserStory |
|--------------|------------------------------------------------------|----------|----------------|-----------|
| String type  |                                                      |          |                |           |
| double price |                                                      |          |                |           |
| String sku   |                                                      |          |                |           |
|              | constructor(String type, double price, String sku)   |          |                |           |


# Filling

| Members      | Method                                             | Scenario | Outcome/Output | UserStory |
|--------------|----------------------------------------------------|----------|----------------|-----------|
| String type  |                                                    |          |                | 8         |
| double price |                                                    |          |                | 9         |
| String sku   |                                                    |          |                |           |
|              | constructor(String type, double price, String sku) |          |                |           |



# Inventory

| Members                                 | Method                                             | Scenario | Outcome/Output | UserStory |
|-----------------------------------------|----------------------------------------------------|----------|----------------|-----------|
| Bagel onionBagel(repeat for each bagel) |                                                    |          |                |           |
|                                         |                                                    |          |                |           |
|                                         |                                                    |          |                |           |
|                                         |                                                    |          |                |           |
|                                         | constructor(String type, double price, String sku) |          |                |           |

# Receipts