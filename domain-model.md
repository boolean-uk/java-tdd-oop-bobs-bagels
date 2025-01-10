# Domain model

## Item

| Method       | Variable       | Scenario | Output       |
| ------------ | -------------- | -------- | ------------ |
|              | SKU sku        |          |              |
|              | float price    |          |              |
|              | String type    |          |              |
|              | String variant |          |              |
| getSku()     |                |          | return sku   |
| getPrice()   |                |          | return price |
| getType()    |                |          | return type  |
| getVariant() |                |          | return price |

## Basket

| Method               | Variable               | Scenario                                    | Output                              |
| -------------------- | ---------------------- | ------------------------------------------- | ----------------------------------- |
|                      | Inventory inventory    |                                             |                                     |
|                      | int capacity           |                                             |                                     |
|                      | ArrayList\<Item> items |                                             |                                     |
| addItem(Item item)   |                        | basket is not full and item is in inventory | add item to items, return true      |
| addItem(Item item)   |                        | item is not in inventory                    | return false                        |
| addItem(Item item)   |                        | basket is full                              | return false                        |
| removeItem(SKU sku)  |                        | item exists in basket                       | remove item from items, return true |
| removeItem(SKU sku)  |                        | item doesn't exist in basket                | return false                        |
| setCapacity(int cap) |                        |                                             | set capacity to cap                 |
| getTotalCost()       |                        |                                             | return total cost of items          |
| getItems()           |                        |                                             | return items                        |

## Inventory

| Method                           | Variable                     | Scenario          | Output                              |
| -------------------------------- | ---------------------------- | ----------------- | ----------------------------------- |
|                                  | HashMap<SKU, Integer> invMap |                   |                                     |
| checkStock(SKU sku)              |                              | in stock          | return true                         |
| checkStock(SKU sku)              |                              | not in stock      | return false                        |
| addStock(SKU sku, int amount)    |                              | amount > 0        | add item to invMap, return true     |
| addStock(SKU sku, int amount)    |                              | amount <= 0       | return false                        |
| removeStock(SKU sku, int amount) |                              | item in stock     | remove item from stock, return true |
| removeStock(SKU sku, int amount) |                              | item not in stock | return false                        |