
| Class  | Variables              | Method                       | Scenario                     | Return value             |
|--------|------------------------|------------------------------|------------------------------|--------------------------|
| Basket | ArrayList<Bagel> items | addItem(Bagel bagel)         | Empty or not valid input     | Return false             |
|        | int capacity           |                              | Valid input add bagel        | Return true              |
|        |                        | remove(Bagel bagel)          | Empty or not valid input     | Return false             |
|        |                        |                              | Valid input remove           | Return true              |
|        |                        |                              | Valid input add bagel to map | Return true              |
|        |                        | getTotalCost()               | Added items                  | Return double cost       |
|        |                        | getTotalCostWithoutDisc()    | Added items without discount | Return double cost       |
|        |                        | changeCapacity(int capacity) | Can change capacity          | Changed                  |
|        |                        |                              | Can't change                 | IllegalArgumentException |
|        |                        |                              |                              |                          |


| Class | Variables      | Method | Scenario | Return value |
|-------|----------------|--------|----------|--------------|
| Bagel | String sku     |        |          |              |
|       | double price   |        |          |              |
|       | String variant |        |          |              |
|       | String name    |        |          |              |


| Class   | Variables      | Method | Scenario | Return value |
|---------|----------------|--------|----------|--------------|
| Filling | String sku     |        |          |              |
|         | double price   |        |          |              |
|         | String name    |        |          |              |

| Class     | Variables              | Method            | Scenario          | Return value           |
|-----------|------------------------|-------------------|-------------------|------------------------|
| Inventory | List<Filling> fillings | isItemExisting()  | Item exists       | Return true            |
|           | List<Bagel> bagels     |                   | Item don't exists | Return false           |
|           |                        | addFilling()      | Added filling     | Return added filling   |
|           |                        | removeFilling()   | Remove filling    | Return removed filling |
|           |                        | getBagelBySku()   | Get a bagel       | Return bagel           |
|           |                        | getFillingBySku() | Get filling       | Return filling         |

| Class | Variables                             | Method       | Scenario             | Return value  |
|-------|---------------------------------------|--------------|----------------------|---------------|
| Bagel | String RECEIPT_TOP                    | getReceipt() | Customer at checkout | Print receipt |
|       | String RECEIPT_BOTTOM                 |              |                      |               |
|       | DateTimeFormatter DATE_TIME_FORMATTER |              |                      |               |
|       | String SEPARATOR                      |              |                      |               |
|       | String SAVED                          |              |                      |               |
|       | List<RecieptItem> items               |              |                      |               |
|       | LocalDateTime localDateTime           |              |                      |               |
|       | Basket basket                         |              |                      |               |


| Class       | Variables    | Method          | Scenario            | Return value                              |
|-------------|--------------|-----------------|---------------------|-------------------------------------------|
| RecieptItem | int quantity | getTotalPrice() | All items in basket | Return total price of all items in basket |
|             |              |                 |                     |                                           |
|             |              |                 |                     |                                           |


Class diagram:
![img.png](img.png)
