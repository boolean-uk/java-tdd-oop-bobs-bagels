
```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.

2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.

3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.

5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.

6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.


7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.


8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.


9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.


10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.

11,
As the manager,
To increase bagles sales,
I want to give some bagels bulk discount. 

12,
As the manager,
To increase coffee sales,
I want to give some items discounts when bought together. 
```

| Classes       | Methods                              | Scenario                                          | Output                         | Story |
|---------------|--------------------------------------|---------------------------------------------------|--------------------------------|-------|
| Inventory     | inInventory(String id)               | Item is in inventory                              | true                           | 10    |
|               |                                      | Item is not in inventory                          | false                          |       |
|               | getFillings()                        | Return all Fillings in Inventory                  | String                         | 9     |
|               |                                      |                                                   |                                |       |
|               | getDiscounts()                       | Returns available discounts                       | discount                       | 11    |
|               |                                      |                                                   |                                |       |
|               | hasDiscount(String id)               | Item has discount                                 | true                           | 11    |
|               |                                      | Item does not have discount                       | false                          |       |   
|               |                                      |                                                   |                                |       |
| Basket        | addItem(String id)                   | Item type is available, not in basket             | add item to basket             | 1     |
|               |                                      | Item type is available, already in basket         | increase amount in basket      |       |
|               |                                      | Item type is not available                        | throw exception NoSuchBagel    |       |
|               |                                      |                                                   |                                |       |
|               | inBasket(String id)                  | Item is in basket                                 | true                           | 5     |
|               |                                      | Item is not in basket                             | false                          |       |
|               |                                      |                                                   |                                |       |
|               | removeItem(int index)                | Item is in basket                                 | item removed                   | 2     |
|               |                                      | Item is not in basket                             | throw exception NotInBasket    |       |
|               |                                      |                                                   |                                |       |
|               | getPrize()                           | Get the prize of item                             | return total prize as double   | 7     |
|               |                                      |                                                   |                                |       |
|               | addExtra(int index, String extra)    | Filling is in inventory                           | return total prize as double   | 8     |
|               |                                      | Filling is not in inventory                       | NotInInventoryException        |       |
|               |                                      |                                                   |                                |       |
|               | removeExtra(int index, String extra) | Item at index does not have extra                 | return                         | 8     |
|               |                                      | Item at index does have extra                     | remove Filling                 |       |
|               |                                      | No item at index                                  | return                         |       |
|               |                                      |                                                   |                                |       |
|               |                                      |                                                   |                                |       |
|               | showFillings()                       | Show all fillings in inventory                    | Fillings information as String | 9     |
|               |                                      |                                                   |                                |       |
|               | isFull()                             | Basket is full                                    | true                           | 3     |
|               |                                      | Basket is not full                                | false                          |       |   
|               |                                      |                                                   |                                |       |
|               | setSize()                            | Basket contains equal/fewer items than new size   | change basket.size             | 4     |
|               |                                      | Basket contains more items than new size          | UnableToChangeSizeException    |       |  
|               |                                      |                                                   |                                |       |
|               | getTotalCost()                       | Get the total cost of items in basket             | return total prize as double   | 6     |
|               |                                      |                                                   |                                |       |
|               |                                      |                                                   |                                |       |
| Discount      | getAmount()                          | Get the price reduction                           | double                         | 11    |
|               |                                      |                                                   |                                |       |
| DiscountBulk  | getBulk()                            | Get the amount of items required for discount     | int                            | 11    |
|               |                                      |                                                   |                                |       |
|               | getItemId()                          | get id for item                                   |                                | 11    |
|               |                                      |                                                   |                                |       |
| DiscountCombo | getComboItems()                      | get the items that are needed to fulfill discount | return item ids as array       | 12    |
|               |                                      |                                                   |                                |       |

```

