


| Class     | Class members             | Methods                       | Scenario                    | Output   |
|-----------|---------------------------|-------------------------------|-----------------------------|----------|
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
| Basket    | ArrayList<String> basket  | addItem(String item)          | Adds item to basket.        | true     |
|           |                           |                               | Adds item price to total.   |          |
|           |                           |                               |                             |          |
|           |                           |                               | Item already in basket      | true     |
|           |                           |                               |                             |          |
|           |                           |                               | Basket capacity reached,    | false    |
|           | Instance of Inventory     |                               | item not added              |          |
|           |                           |                               |                             |          |
|           |                           |                               | Item not found in Inventory | false    |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           | Integer capacity          | removeItem(String item)       | Remove item from list       | true     |
|           |                           |                               |                             |          |
|           | Double  total             |                               | Item was not in the list    | false    |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           | changeCapacity                | Updates the basket capacity | capacity |
|           |                           | (int newCapacity)             | class member                |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           | getTotal()                    | checks class member total   | total    |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           | checkPrice(String item)       | looks up price in inventory | price    |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           | buildBagel(String[] fillings) | Adds plain bagel to basket  | true     |
|           |                           |                               | along with the fillings in  |          |
|           |                           |                               | the array.                  |          |
|           |                           |                               | Invalid input -> nothing    | false    |
|           |                           |                               | added to basket             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
| Inventory | String[] inventory        |                               |                             |          |
|           |                           |                               |                             |          |
|           | HashMap<String, String[]> |                               |                             |          |
|           | bagelInventory            |                               |                             |          |
|           | key: SKU                  |                               |                             |          |
|           | value: array element from |                               |                             |          |
|           | inventory                 |                               |                             |          |
|           |                           |                               |                             |          |
|           | HashMap<String, String[]> |                               |                             |          |
|           | coffeeInventory           |                               |                             |          |
|           |                           |                               |                             |          |
|           | HashMap<String, String[]> |                               |                             |          |
|           | fillingInventory          |                               |                             |          |
|           |                           |                               |                             |          |
|           | HashMap<String, String>   |                               |                             |          |
|           | mapSKUtoTypeVariant       |                               |                             |          |
|           | (key: SKU,                |                               |                             |          |
|           | value: type+variant       |                               |                             |          |
|           |                           |                               |                             |          |
|           | HashMap<String, String>   |                               |                             |          |
|           | mapTypeVariantToSKU       |                               |                             |          |
|           | (key: SKU,                |                               |                             |          |
|           | value: type+variant       |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |
|           |                           |                               |                             |          |




