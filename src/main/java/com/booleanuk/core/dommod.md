


| Class      | Class members               | Methods                  | Scenario                        | Output     |
|------------|-----------------------------|--------------------------|---------------------------------|------------|
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
| Basket     | HashMap<String, BasketItem> | addItem(String item,     | Adds item by quantity to basket | true       |
|            | basket                      | int quantity)            | Adds item price to total.       |            |
|            | SKU                         |                          | It item is already in           | true       |
|            | BasketItem instance         |                          | basket one more will be added   |            |
|            |                             |                          |                                 |            |
|            |                             |                          | Basket capacity reached,        | false      |
|            | Instance of Inventory       |                          | item not added                  |            |
|            |                             |                          |                                 |            |
|            |                             |                          | Item not found in Inventory     | false      |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            | Integer capacity            | removeItem(String item,  | Remove item from list           | true       |
|            |                             | int quantity)            |                                 |            |
|            | Double  total               |                          | Item was not in the list        | false      |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            | HashMap<String, Discounts>  | changeCapacity           | Updates the basket capacity     | capacity   |
|            | discounts                   | (int newCapacity)        | class member                    |            |
|            | Key: sku                    |                          |                                 |            |
|            | Value: Instance of          |                          |                                 |            |
|            | Discounts                   | getTotal()               | checks class member total       | total      |
|            |                             |                          |                                 |            |
|            | int bglbIncrementor         |                          |                                 |            |
|            |                             | getPrice(String item)    | looks up price in inventory     | price      |
|            | HashMap<String, String>     |                          |                                 |            |
|            | bglbMap (tracks build       |                          |                                 |            |
|            | a bagel sku codes)          | buildBagel(int quantity, | Adds plain bagel to basket      | true       |
|            |                             | String[] fillings)       | along with the fillings in      |            |
|            |                             |                          | the array.                      |            |
|            |                             |                          | Invalid input -> nothing        | false      |
|            |                             |                          | added to basket                 |            |
|            |                             |                          |                                 |            |
|            |                             | getBasketItem            | Gets an item for sku            | BasketItem |
|            |                             | (String sku)             |                                 |            |
|            |                             |                          |                                 |            |
|            |                             | getBasketSize()          | Looks up basket size            | size       |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             | updateTotal()            | recalculated total from basket  |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
| BasketItem | int quantity                | getX()                   |                                 | x          |
|            | double price                | setX(x)                  |                                 |            |
|            | String item                 |                          |                                 |            |
|            | String[] fillings           |                          |                                 |            |
|            | int numFillings             |                          |                                 |            |
|            |                             |                          |                                 |            |
| Inventory  | String[] inventoryArray     |                          |                                 |            |
|            |                             |                          |                                 |            |
|            | HashMap<String, Item>       |                          |                                 |            |
|            | items                       |                          |                                 |            |
|            | key: SKU                    |                          |                                 |            |
|            | value: Instance of Item     |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            | HashMap<String, String>     |                          |                                 |            |
|            | mapTypeVariantToSKU         |                          |                                 |            |
|            | (key: SKU,                  |                          |                                 |            |
|            | value: type+variant         |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
| Item       | double price                | getX()                   |                                 | x          |
|            | Sting name                  | where X is either of the |                                 |            |
|            | String type                 | class members            |                                 |            |
|            | String nametype             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
| Extension  | Extension                   | Extension                | Extension                       | Extension  |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
| Discount   | double orgPrice             |                          |                                 |            |
|            | double discountPrice        |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |
|            |                             |                          |                                 |            |


TODO: Implement receipt and discounts



