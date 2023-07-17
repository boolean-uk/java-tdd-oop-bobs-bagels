| Class         | Methods                        | Scenario                | Outcome                                            |
|---------------|--------------------------------|-------------------------|----------------------------------------------------|
| Basket        | addToBasket(InventoryItem)     | !basket is full         | bagel is added to basket                           |
|               |                                | basket is full          | bagel is not added                                 |
|               | countBagelDiscount(int double) |                         | returns price with discounts applied               |
|               | countProduct(String)           |                         | returns amount of given product                    |
|               | countCoffeeDiscount            |                         | returns discounted price for cofee+bagel           |
|               | removeFromBasket(int)          |                         | item is removed from the basket                    |
|               |                                |                         |                                                    |
| Customer      | checkBasketWithQuantity        |                         | returns String of all items and quantity           |
|               | addToBasket(InventoryItem)     |                         | item is added to basket                            |
|               | removeFromBasket(int)          |                         | item is removed from the basket                    |
|               | checkBasket()                  |                         | returns String of all items in basket              |
|               | calculateQuantity()            |                         | returns HashMap that stores all items and quantity |
|               |                                |                         |                                                    |
| Manager       | changeBasketCapacity(int)      | newCapacity>oldCapacity | changes capacity and returns true                  |
|               |                                | newCapacity<oldCapacity | returns false                                      |
|               |                                |                         |                                                    |
| Inventory     | getItemByIndex()               |                         | returns item by index                              |
|               |                                |                         |                                                    |
| InventoryItem | toString()                     |                         | returns variant name and price of an item          |
|               |                                |                         |                                                    |
| UI            | displayBasketMenu()            |                         | displays basket menu                               |
|               | displayLoginMenu()             |                         | displays login menu                                |
|               | displayBagelMenu()             |                         | displays bagel menu                                |
|               | displayRecipe()                |                         | displays receipt                                   |
|               | displayManagerMenu()           |                         | displays manager menu                              |
|               | displayCustomerMenu()          |                         | displays customer menu                             |

