

| Class | Attributes                               | Methods                     | Scenario                                                 | 
|--|------------------------------------------|-----------------------------|----------------------------------------------------------|----------------------------|
| Basket |                                          | getCapacity()               | capacity of the basket                                   | 
| Basket | int capacity                             | setCapacity()               | set the value for capacity                               | 
| Basket | Map<InventoryItem, Integer>              | getBagels()                 | Retrieves the bagels and their quantities in the basket. | 
| Basket | InventoryItem Bagel                      | removeBagel()               | remove a bageel from the basket                          | 
| Basket |                                          | basketfull()                | checks if the Basket is full                             | 
| Basket |                                          | calculateTotalCost()        | calculates the cost of all Bagels in the Basket          | |
| Basket | InventoryItem Bagel                      | calculateBagelCost()        | calculate the cost of an individual Bagel                | 
| Basket | InventoryItem bagel, List<InventoryItem> fillings | addBagelWithFillings()      | adds a bagel with fillings                               | 
| Basket | InventoryItem bagel                      | isBagelAvailableInInventory | checks if a bagel is available                           | 
| InventoryItem | String sku                               | getSku()                    | Retrieves the SKU of the inventory item.                 | 
|  InventoryItem | double price                             | getPrice()                  | Retrieves the price of the inventory item.               | 
|  InventoryItem | String name                              | getName()                   | Retrieves the name of the inventory item.                | 
|  InventoryItem | String variant                           | getVariant()                | Retrieves the variant of the inventory item.             | 
|  InventoryItem |                                          | getStock()                  | Retrieves the stock of the inventory item.               | 
|  InventoryItem | int stock                                | setStock()                  | Sets a new stock for the inventory item.                 | 
