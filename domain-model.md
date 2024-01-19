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

| Classes         | Members            | Methods                 | Scenario                     | Result/output           |
|-----------------|--------------------|-------------------------|------------------------------|-------------------------|
| Product         | String sku         | getSku()                |                              | each method return the  |
| Bagel extends   | String type        | getVariant()            |                              | value of the connected  |
| Coffee extends  | String variant     | getPrice()              |                              | attribute               |
| Filling extends | double price       | getType()               |                              |                         |
|                 |                    |                         |                              |                         |
|                 |                    |                         |                              |                         |
|                 |                    |                         |                              |                         |
| Inventory       | List<Product> menu | getInventory()          | Manager wants to see the     | returns current stock   |
|                 |                    |                         | the current stock of an item | value of item           |
|                 | HashMap<String,    | addToMenu()             | Manager can add items to     | returns nothing, adds   |
|                 | Integer> inventory |                         | the menu                     | items to inventory      |
|                 |                    | getMenu()               | User wants to see the        | returns the menu as a   |
|                 |                    |                         | menu before adding items     | string                  |
|                 |                    | isInStock()             | Checks if the wanted         | returns true if in stock |
|                 |                    |                         | item is in stock             | else returns false      |
|                 |                    | decreaseStock()         | When item is added the       | returns nothing, just   |
|                 |                    |                         | stock decreases by 1         | updates inventory value |
|                 |                    |                         |                              |                         |
|                 |                    |                         |                              |                         |
|                 |                    |                         |                              |                         |
| Basket          | ArrayList<>        | addItem()               | User want to add item        | returns String telling  |
|                 | basket             |                         | into basket                  | what has been added     |
|                 |                    | addBagelWithFilling()   | User wants to add            | Adds both bagel and     |
|                 |                    |                         | filling to the bagel         | filling to the basket   |
|                 |                    |                         |                              |                         |
|                 |                    | removeItem()            | User wants to remove         | returns String telling  |
|                 |                    |                         | item from basket             | what has been removed   |
|                 |                    | calculateTotalCost()    | Calculates the total         | returns total basket    |
|                 |                    |                         | cost of the basket           | value after change      |
|                 |                    | changeCapacity()        | Manager wants to update      | returns int with        |
|                 |                    |                         | basket capacity              | the new capacity        |
|                 |                    | basketIsFull()          | Checks if the basket has     | returns true if it's    |
|                 |                    |                         | reached capacity             | full, else return false |
|                 |                    | currentBasketToString() | User wants to see whats      | returns a string of     |
|                 |                    |                         | currently inside the         | every item with every   |
|                 |                    |                         | basket                       | attribute               |
|                 |                    | getItemBasket()         |                              | returns basket as array |
|                 |                    |                         |                              | list                    |
