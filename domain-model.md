# Bagels domain model 


## OrderManager class ?
| Methods                            | Member variables | Scenario                      | Result                    |
|------------------------------------|------------------|-------------------------------|---------------------------|
|                                    | String name?     |                               |                           |
|                                    | Basket basket    |                               |                           |
| addItemToBasket(Item item)         |                  | basket is not full            | string itemAddedMessage   |
|                                    |                  | basket is full                | string fullBasketMessage  |
|                                    |                  | item is in menu/inventory     | void                      |
|                                    |                  | item is not in menu/inventory | string notInStockMessage  |
| removeItemFromBasket(Item item)    |                  | item is in basket             | string itemRemovedMessage |
|                                    |                  | item is not in basket         | string errorMessage       |
| changeBasketCapacity(int capacity) |                  | capacity was updated          | true  /   string?         |
|                                    |                  | capacity was not updated      | false  /     string?      |
|                                    |                  |                               | double totalPrice         |
|                                    |                  |                               |                           |
|                                    |                  |                               | String itemsInInventory   |
|                                    |                  |                               |                           |
|                                    |                  |                               |                           |

## Basket class

| Methods                            | Member variables           | Scenario         | Results |
|------------------------------------|----------------------------|------------------|---------|
|                                    | ArrayList<Item item> items |                  |         |
|                                    | int capacity               |                  |         |
| addItem(Item item)                 |                            | item added       | true    |
|                                    |                            | item not added   | false   |
| getTotalCost(ArrayList<Item item>) |                            | gets total cost  | int     |
| deleteItem(Item item)              |                            | item deleted     | true    |
|                                    |                            | item not deleted | false   |
| setCapacity(int)                   |                            |                  |         |
|                                    |                            |                  |         |


## Item class

| Methods    | member variables | scenario     | result |
|------------|------------------|--------------|--------|
| getSKU     | String SKU       | gets SKU     | string |
| getPrice   | double price     | gets price   | double |
| getName    | String name      | gets name    | string |
| getVariant | String variant   | gets variant | string |

## Inventory class

| Methods               | member variables                 | scenario                      | result                 |
|-----------------------|----------------------------------|-------------------------------|------------------------|
|                       | Map<String SKU, Item item> items |                               |                        |
| getItem(String SKU)   |                                  | item exists                   | Item object or null    |
|                       |                                  | item does not exist           | null                   |
| printItem(String SKU) |                                  | inventory has items           | string of items        |
|                       |                                  | inventory does not have items | string inventory empty |


## Bagel class inherits from item


| Methods                                                      | member variables    | scenario | result           |
|--------------------------------------------------------------|---------------------|----------|------------------|
|                                                              | String SKU          |          | string           |
|                                                              | double price        |          | double           |
|                                                              | String name="Bagel" |          | string           |
|                                                              | String variant      |          | string           |
| Constructor(Bagel(String SKU, String variant, double price)) |                     |          | new bagel object |


## Filling class inherits from item

| Methods                                                        | member variables      | scenario | result             |
|----------------------------------------------------------------|-----------------------|----------|--------------------|
|                                                                | String SKU            |          | string             |
|                                                                | double price          |          | double             |
|                                                                | String name="Filling" |          | string             |
|                                                                | String variant        |          | string             |
| Constructor(Filling(String SKU, String variant, double price)) |                       |          | new filling object |

## Coffee class inherits from item

| Methods                                                       | member variables     | scenario | result            |
|---------------------------------------------------------------|----------------------|----------|-------------------|
|                                                               | String SKU           |          | string            |
|                                                               | double price         |          | double            |
|                                                               | String name="Coffee" |          | string            |
|                                                               | String variant       |          | string            |
| Constructor(Coffee(String SKU, String variant, double price)) |                      |          | new coffee object |