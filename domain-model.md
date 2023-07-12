## Basket
| Class  | Attributes                                        | Methods                                 | Scenarios                                                      | Output                       |
|--------|---------------------------------------------------|-----------------------------------------|----------------------------------------------------------------|------------------------------|
| Basket | int capacity                                      | addItem(String name, String variant)    | user can add item to basket                                    | void : item added to map     |
|        |                                                   |                                         | item does not exist in inventory                               | print message                |
|        |                                                   |                                         | item exceeds capacity                                          | print message                |
|        | HashMap<Item item, Integer quantity> shoppingList | removeItem(String name, String variant) | user can remove item from basket                               | void : item removed from map |
|        |                                                   |                                         | item does not exist in basket                                  | print message                |
|        |                                                   |                                         | item does not exist in inventory                               | print message                |
|        |                                                   | isBasketFull()                          | user wants to know if the basket is full while adding new item | boolean                      |
|        |                                                   | changeCapacity(int capacity)            | user can change the capacity of basket                         | boolean                      |
|        |                                                   |                                         | capacity less than zero                                        | print message                |
|        |                                                   |                                         | capacity less than number of items in a basket                 | print message                |
|        |                                                   | totalCost()                             | user wants no know the total cost of basket                    | double                       |
|        |                                                   | isInBasket()                            | user wants to check if item is in  basket                      | boolean                      |

## Item
| Class | Attributes     | Methods    | Scenarios                             | Output |
|-------|----------------|------------|---------------------------------------|--------|
| Item  | String SKU     | checkPrice | user wants to check the price of item | double |
|       | String name    |            |                                       |        |
|       | double price   |            |                                       |        |
|       | String variant |            |                                       |        |
|       |                |            |                                       |        |

## Bagel
| Class              | Attributes     | Methods | Scenarios | Output |
|--------------------|----------------|---------|-----------|--------|
| Bagel extends Item | String SKU     |         |           |        |
|                    | String name    |         |           |        |
|                    | double price   |         |           |        |
|                    | String variant |         |           |        |


## Coffee
| Class               | Attributes     | Methods | Scenarios | Output |
|---------------------|----------------|---------|-----------|--------|
| Coffee extends Item | String SKU     |         |           |        |
|                     | String name    |         |           |        |
|                     | double price   |         |           |        |
|                     | String variant |         |           |        |

## Filling
| Class                | Attributes     | Methods | Scenarios | Output |
|----------------------|----------------|---------|-----------|--------|
| Filling extends Item | String SKU     |         |           |        |
|                      | String name    |         |           |        |
|                      | double price   |         |           |        |
|                      | String variant |         |           |        |

#Inventory
| Class     | Attributes                | Methods                                               | Scenarios                                   | Output   |
|-----------|---------------------------|-------------------------------------------------------|---------------------------------------------|----------|
| Inventory | ArrayList<Item> itemsList |                                                       |                                             |          |
|           |                           | searchInventory(String name, String variant):Optional | system searches if item exists in inventory | Optional |
|           |                           | getItemPrice(String name, String variant): Optional   | system searches for a price of an item      | Optional |
