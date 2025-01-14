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

| Method              | Variable               | Scenario                                    | Output                              |
| ------------------- | ---------------------- | ------------------------------------------- | ----------------------------------- |
|                     | Inventory inventory    |                                             |                                     |
|                     | int capacity           |                                             |                                     |
|                     | ArrayList\<Item> items |                                             |                                     |
| addItem(Item item)  |                        | basket is not full and item is in inventory | add item to items, return true      |
| addItem(Item item)  |                        | item is not in inventory                    | return false                        |
| addItem(Item item)  |                        | basket is full                              | return false                        |
| removeItem(SKU sku) |                        | item exists in basket                       | remove item from items, return true |
| removeItem(SKU sku) |                        | item doesn't exist in basket                | return false                        |
| getTotalCost()      |                        |                                             | return total cost of items          |
| getItems()          |                        |                                             | return items                        |

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

## Receipt

### User stories

As a member of the public,
So I can assess the damage after paying,
I'd like to see the total cost of my order on the receipt.

As a member of the public,
So I can check if my order was handled correctly,
I'd like to see all items in my order listed on the receipt.

As a member of the public,
So I can double check the total cost,
I'd like to see the individual price of every item listed on the receipt.

As a member of the public,
So I can keep my finances in order,
I'd like to see the time of my purchase listed on the receipt.

| Method         | Variable         | Scenario | Output                    |
| -------------- | ---------------- | -------- | ------------------------- |
|                | Basket basket    |          |                           |
|                | String time      |          |                           |
| printReceipt() |                  |          | print receipt to terminal |
| getReceipt()   |                  |          | return receipt String     |
