# Domain model

## User stories

1. As a member of the public, So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.

2. As a member of the public, So I can change my order,
I'd like to remove a bagel from my basket.

3. As a member of the public, So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

4. As a Bob's Bagels manager, So that I can expand my business,
I’d like to change the capacity of baskets.

5. As a member of the public, So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.

6. As a customer, So I know how much money I need,
I'd like to know the total cost of items in my basket.

7. As a customer, So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.

8. As a customer, So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.

9. As a customer, So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.

10. As the manager, So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.

 
## Basket Class

| Members               | Methods                                 | Scenario                                                        | Outcome/Output                                                | User story |
|-----------------------|-----------------------------------------|-----------------------------------------------------------------|---------------------------------------------------------------|------------|
| ArrayList<Item> items |                                         |                                                                 |                                                               |            |
| int capacity          |                                         |                                                                 |                                                               |            |
|                       |                                         |                                                                 |                                                               |            |
|                       |                                         |                                                                 |                                                               |            |
|                       | boolean add(Item item)                  | Add item to the basket                                          | Return true + print item is added to basket                   | 1          |
|                       |                                         | Item is not added because capacity has been reached             | Print message stating basket is full and return false         | 1 + 3      |
|                       |                                         | Item is not added because is not available in inventory         | Return false + print message not available                    |            |
|                       | boolean remove(Item item)               | Remove item from the basket                                     | Return true                                                   | 2          |
|                       |                                         | Item not removed because it does not exist in the basket        | Return false + print message does not exist                   | 2 + 5      |
|                       | boolean changeCapacity(int newCapacity) | Update the basket capacity to newCapacity                       | Return true                                                   | 4          |
|                       |                                         | Basket capacity cannot be updated to 0 or negative number       | Print error message + return false                            | 4          |
|                       |                                         | Basket capacity cannot be made smaller than current basket size | Print error message + return false                            | 4          |
|                       | boolean getTotal()                      | Get the total cost of all the items in the basket               | Return total cost of items in basket with discount subtracted | 6          |
|                       | boolean getPrice(Item item)             | Get the price of an item                                        | Return int price + print item & price to screen               | 7 + 9      |
|                       | boolean calculateDiscount()             | Get discount prices of items in basket                          | Return discount cost of discounted item                       | 7          |


## Item

| Members        | Methods | Scenario | Outcome / Output |
|----------------|---------|----------|------------------|
| String id      |         |          |                  |
| String product |         |          |                  |
| double price   |         |          |                  |
| String type    |         |          |                  |
|                |         |          |                  |

## Inventory

| Members                       | Methods | Scenario | Outcome / Output |
|-------------------------------|---------|----------|------------------|
| ArrayList<Item> inventoryList |         |          |                  |
|                               |         |          |                  |
|                               |         |          |                  |
|                               |         |          |                  |

