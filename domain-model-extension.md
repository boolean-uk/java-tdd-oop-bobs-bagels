# Domain Model Extension

| Class                | Method                                   | Member                                                | Scenario                      | Return                        |
|----------------------|------------------------------------------|-------------------------------------------------------|-------------------------------|-------------------------------|
| Cashier              | menu()                                   | userInput                                             |                               | response                      |
|                      | doChoice(choice)                         | userInput                                             |                               | response                      |
|                      | main()                                   |                                                       |                               |                               |
| Basket               | addItem(Inventory, item, quantity)       | Class Inventory, String item, Integer quantity        | full basket                   | false                         |
|                      |                                          |                                                       | add item                      | true                          |
|                      |                                          |                                                       | Item not found                | false                         |
|                      | removeItem(Inventory, sku, quantity)     | Class Inventory, String item, Integer quantity        | remove item                   | true                          |
|                      |                                          |                                                       | Item not found                | false                         |
|                      | changeCapacity(capacity)                 | Integer capacity                                      | Changed capacity              | true                          |
|                      |                                          |                                                       | Unable to change capacity     | false                         |
|                      | getTotalCost()                           | ArrayList<Item>                                       | Get total cost                | Return cost                   |
|                      | showBasket()                             | StringBuilder result                                  | Build String for receipt      | Receipt                       |
|                      | getProductPrice(result)                  | StringBuilder result                                  | Add to result                 | StringBuilder to showBasket() |
|                      | calculateBagelOffer(item, quantity)      | Class item, Integer quantity                          | Returns sum for Bagel type    | Integer discountedPrice       |
|                      | calculateItemPrice(item, quantity)       | Class item, Integer quantity                          | Returns sum for item type     | Integer discountedPrice       |
| Inventory            | printInventory(inventory, inventoryName) | HashMap<String, Item> inventory, String inventoryName | Show all added products       | String[]                      |
|                      | getProductsBySku(sku)                    | String sku                                            | Get all products of one type  | String[]                      |
| Item                 | getType()                                |                                                       | get type                      | String type                   |
|                      | getVariant()                             |                                                       | get variant                   | String variant                |
|                      | getSku()                                 |                                                       | get sku                       | String sku                    |
|                      | getPrice()                               |                                                       | get price                     | double price                  |
|                      | getQuantity()                            |                                                       | get quantity                  | int quantity                  |  
|                      | toString()                               |                                                       | get item properties in String | String Item properties        |
