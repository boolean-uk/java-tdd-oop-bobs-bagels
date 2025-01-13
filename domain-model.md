# Bagels domain model 

- order/basket class --> Arraylist<Item item>, double totalPrice, int capacity 
- Item class --> String SKU, double price, String name/type, String variant
- 
- bagel --> object has: string type, string filling
- coffee --> object has:
- menu/inventory --> 
## OrderManager class
| Methods                            | Member variables          | Scenario                      | Result                    |
|------------------------------------|---------------------------|-------------------------------|---------------------------|
|                                    | Arraylist<Item> inventory |                               |                           |
| addItemToBasket(Item item)         |                           | basket is not full            | string itemAddedMessage   |
|                                    |                           | basket is full                | string fullBasketMessage  |
|                                    |                           | item is in menu/inventory     | void                      |
|                                    |                           | item is not in menu/inventory | string notInStockMessage  |
| removeItemFromBasket(Item item)    |                           | item is in basket             | string itemRemovedMessage |
|                                    |                           | item is not in basket         | string errorMessage       |
| changeBasketCapacity(int capacity) |                           | capacity was updated          | true                      |
|                                    |                           | capacity was not updated      | false                     |
| getTotalCost(Basket.items)         |                           |                               | double totalPrice         |
|                                    |                           |                               |                           |
| showMenu(Arraylist<Item>)          |                           |                               | String itemsInInventory   |
|                                    |                           |                               |                           |
| addFillingToBasket() ?             |                           |                               |                           |
| addBagelToBasket()   ?             |                           |                               |                           |
|                                    |                           |                               |                           |
|                                    |                           |                               |                           |

## Basket class

| Methods | Member variables                      | Scenario | Results |
|---------|---------------------------------------|----------|---------|
|         | HashMap<String name, int price> items |          |         |
|         | int capacity                          |          |         |
|         |                                       |          |         |


## Item class

| Methods | member variables  | scenario | result |
|---------|-------------------|----------|--------|
|         | String SKU        |          |        |
|         | double price      |          |        |
|         | String name/type  |          |        |
|         | String variant    |          |        |


