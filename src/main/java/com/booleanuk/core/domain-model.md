| class     | method                                       | output             |   |
|-----------|----------------------------------------------|--------------------|---|
| Basket    | addBagel( String bagelName, int quantity)    |                    |   |
| Basket    | remove bagel(String bagelName, int quantity) |                    |   |
| Basket    | setBasketLimit(int  basketLimit)             |                    |   |
| Basket    | sumBasketTotal() : float                     | float basketTotal  |   |
| Basket    | getBagelCost(String bagelName) : float       | float bagelCost    |   |
| Basket    | getFillingCost(String filling) : float       | float fillingCost  |   |
| Bagel     | addFilling(String filling)                   |                    |   |
| Bagel     | removeFilling(String filling)                |                    |   |
| Inventory | getItemDetails(String itemName) : Object     | Object itemDetails |   |
|           |                                              |                    |   |

| Variables                             | Class     |
|---------------------------------------|-----------|
| Map<String, Integer> basketItems;     | Basket    |
| int basketLimit                       | Basket    |
| float basketTotal                     | Basket    |
| float bagelCost                       | Bagel     |
| ArrayList<String> fillings            | Bagel     |
| String bagelType                      | Bagel     |
| HashMap<String, Object> bobsInventory | Inventory |
|                                       |           |

