


| Class      | Class members               | Methods                  | Scenario                      | Output    |
|------------|-----------------------------|--------------------------|-------------------------------|-----------|
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
| Basket     | HashMap<String, BasketItem> | addItem(String item)     | Adds item to basket.          | true      |
|            | basket                      |                          | Adds item price to total.     |           |
|            | SKU                         |                          | It item is already in         | true      |
|            | BasketItem instance         |                          | basket one more will be added |           |
|            |                             |                          |                               |           |
|            |                             |                          | Basket capacity reached,      | false     |
|            | Instance of Inventory       |                          | item not added                |           |
|            |                             |                          |                               |           |
|            |                             |                          | Item not found in Inventory   | false     |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            | Integer capacity            | removeItem(String item)  | Remove item from list         | true      |
|            |                             |                          |                               |           |
|            | Double  total               |                          | Item was not in the list      | false     |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            | HashMap<String, Discounts>  | changeCapacity           | Updates the basket capacity   | capacity  |
|            | discounts                   | (int newCapacity)        | class member                  |           |
|            | Key: sku                    |                          |                               |           |
|            | Value: Instance of          |                          |                               |           |
|            | Discounts                   | getTotal()               | checks class member total     | total     |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             | getPrice(String item)    | looks up price in inventory   | price     |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             | buildBagel               | Adds plain bagel to basket    | true      |
|            |                             | (String[] fillings)      | along with the fillings in    |           |
|            |                             |                          | the array.                    |           |
|            |                             |                          | Invalid input -> nothing      | false     |
|            |                             |                          | added to basket               |           |
|            |                             |                          |                               |           |
|            |                             | getBasketItemAtIndex     | Gets an item at a             | itemID    |
|            |                             | (int index)              | index in the basket           |           |
|            |                             |                          |                               |           |
|            |                             | getBasketSize()          | Looks up basket size          | size      |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
| BasketItem | int quantity                | getX()                   |                               | x         |
|            | double price                | setX(x)                  |                               |           |
|            | String item                 |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
| Inventory  | String[] inventoryArray     |                          |                               |           |
|            |                             |                          |                               |           |
|            | HashMap<String, Item>       |                          |                               |           |
|            | items                       |                          |                               |           |
|            | key: SKU                    |                          |                               |           |
|            | value: Instance of Item     |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            | HashMap<String, String>     |                          |                               |           |
|            | mapTypeVariantToSKU         |                          |                               |           |
|            | (key: SKU,                  |                          |                               |           |
|            | value: type+variant         |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
| Item       | double price                | getX()                   |                               | x         |
|            | Sting name                  | where X is either of the |                               |           |
|            | String type                 | class members            |                               |           |
|            | String nametype             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
| Extension  | Extension                   | Extension                | Extension                     | Extension |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
| Discount   | double orgPrice             |                          |                               |           |
|            | double discountPrice        |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |
|            |                             |                          |                               |           |




