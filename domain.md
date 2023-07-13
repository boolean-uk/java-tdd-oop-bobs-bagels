# Domain Model

| Classes | Members     | Methods           | Scenario | Outputs                     |
|---------|-------------|-------------------|----------|-----------------------------|
| Filling | String type | getType(): String |          | return the type of product  |
|         | double cost | getCost(): double |          | return the cost of products |
|         |             |                   |          |                             |

| Classes | Members              | Methods                               | Scenario                                          | Outputs |
|---------|----------------------|---------------------------------------|---------------------------------------------------|---------|
| Bagel   | String type          | addFilling(filling: Filling): void    | if name of product equals "Filling" add to basket | String  |
|         | double cost          | removeFilling(filling: Filling): void | if name of variant does not exist print message   | String  |
|         | fillings: Filling[]  | getType(): String                     |                                                   |         |
|         |                      | getCost(): double                     |                                                   |         |
|         |                      | getFillings(): Filling[]              |                                                   |         |
|         |                      |                                       |                                                   |         |
|         |                      |                                       |                                                   |         |

| Classes   | Members                | Methods                                   | Scenario | Outputs                             |
|-----------|------------------------|-------------------------------------------|----------|-------------------------------------|
| Inventory | inventoryList: Bagel[] | addBagel(bagel: Bagel): void              |          | add the Bagel in the Inventory      |
|           |                        |                                           |          |                                     |
|           |                        | removeBagel(bagel: Bagel): void           |          | remove the Bagel from the Inventory |
|           |                        |                                           |          |                                     |
|           |                        | checkInventoryList(bagel: Bagel): boolean |          | True/ False                         |




| Classes | Members              | Methods                           | Scenario                                                  | Outputs                                                                                          |
|---------|----------------------|-----------------------------------|-----------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| Basket  | int capacity         | getCapacity(): int                | get the capacity                                          | Returns the maximum number of items that the basket can hold                                     |
|         | int productsQuantity | getProductsQuantity(): int        | get the products quantity                                 | Returns the number of products currently in the basket                                           |
|         | products: Bagel[]    | addProduct(bagel: Bagel): void    | add the bagel in the basket                               | Adds a bagel item to the basket. Raises an exception if the basket is already full               |
|         |                      | getTotalCost(): double            | Get the total cost of the basket                          | Returns the total cost of the basket                                                             |
|         |                      | removeProduct(bagel: Bagel): void | if product is in basket remove product from basket        | Removes a bagel item from the basket. Raises an exception if the item is not found in the basket |
|         |                      | isFull(): boolean                 | Returns True if the basket is full, False otherwise       | Returns True if the basket is full, False otherwise                                              |
|         |                      | changeCapacity(int newCapacity)   | Changes the capacity of the basket to the specified value | Changed capacity of the basket                                                                   |