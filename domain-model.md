#Domain model Bob's Bagels

## User Stories

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
```

| Classes          | Members                   | Methods          | Scenario                | Result/output          |
|------------------|---------------------------|------------------|-------------------------|------------------------|
| Product          | String sku                |                  |                         |                        |
| Bagel extends    | String type               |                  |                         |                        |
| Coffee extends   | String variant            |                  |                         |                        |
| Filling extends  | double price              |                  |                         |                        |
|                  |                           |                  |                         |                        |
|                  |                           |                  |                         |                        |
|                  |                           |                  |                         |                        |
| Inventory        | HashMap<String,           | isInStock()      | Checks if the wanted    | returns boolean        |
|                  | Integer> bagelInventory   |                  | item is in stock        |                        |
|                  | HashMap<String,           |                  |                         |                        |
|                  | Integer> coffeeInventory  | updateStock()    | Updates the current     | returns String         |
|                  | HashMap<String,           |                  | stock of specific       | telling if the stock   |
|                  | Integer> fillingInventory |                  | items                   | has been updated       |
|                  |                           |                  |                         |                        |
|                  |                           |                  |                         |                        |
|                  |                           |                  |                         |                        |
| Basket           | ArrayList<>               | addItem()        | User want to add item   | returns String telling |
|                  | basket                    |                  | into basket             | what has been added    |
|                  |                           | removeItem()     | User wants to remove    | returns String telling |
|                  |                           |                  | item from basket        | what has been removed  |
|                  |                           | totalCost()      | After change in basket  | returns total basket   |
|                  |                           |                  |                         | value after change     |
|                  |                           |                  |                         |                        |
| User             | String role;              |                  |                         |                        |
| Manager extends  |                           | changeCapacity() | Manager wants to update | returns String telling |
| Customer extends |                           |                  | basket capacity         | what has been changed  |
|                  |                           |                  |                         |                        |
