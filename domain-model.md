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

| Classes            | Members            | Methods                 | Scenario                      | Result/output            |
|--------------------|--------------------|-------------------------|-------------------------------|--------------------------|
| Product            | String sku         | getSku()                | When sku is needed.           | Each method return the   |
| Bagel implements   | String type        | getVariant()            | When variant is needed.       | value of the connected   |
| Coffee implements  | String variant     | getPrice()              | When price is needed.         | attribute.               |
| Filling implements | double price       | getType()               | When type is needed.          |                          |
|                    |                    |                         |                               |                          |
|                    |                    |                         |                               |                          |
|                    |                    |                         |                               |                          |
| Inventory          | List<Product> menu | getInventory(String)    | Manager wants to see the      | Returns current stock    |
|                    |                    |                         | the current stock of an item. | value of item.           |
|                    | HashMap<String,    | addToMenu(Product, int) | Manager can add items to      | Returns nothing, adds    |
|                    | Integer> inventory |                         | the menu.                     | items to inventory.      |
|                    |                    | getMenu()               | User wants to see the         | Returns the menu as a    |
|                    |                    |                         | menu before adding items.     | string.                  |
|                    |                    | isInStock(String)       | Checks if the wanted          | Returns true if in stock |
|                    |                    |                         | item is in stock.             | else returns false.      |
|                    |                    | decreaseStock(String)   | When item is added the        | Returns nothing, just    |
|                    |                    |                         | stock decreases by 1.         | updates inventory value. |
|                    |                    |                         |                               |                          |
|                    |                    |                         |                               |                          |
|                    |                    |                         |                               |                          |
| Basket             | ArrayList<>        | addItem(Product)        | User want to add item         | Returns String telling   |
|                    | basket             |                         | into basket.                  | what has been added.     |
|                    |                    | addBagelWithFilling(    | User wants to add             | Adds both bagel and      |
|                    |                    | Bagel, Filling)         | filling to the bagel.         | filling to the basket.   |
|                    |                    |                         |                               |                          |
|                    |                    | removeItem(Product)     | User wants to remove          | Returns String telling   |
|                    |                    |                         | item from basket.             | what has been removed.   |
|                    |                    | calculateTotalCost()    | Calculates the total          | Returns total basket     |
|                    |                    |                         | cost of the basket.           | value after change.      |
|                    |                    | changeCapacity(int)     | Manager wants to update       | Returns int with         |
|                    |                    |                         | basket capacity.              | the new capacity.        |
|                    |                    | basketIsFull()          | Checks if the basket has      | Returns true if it's     |
|                    |                    |                         | reached capacity.             | full, else return false. |
|                    |                    | currentBasketToString() | User wants to see whats       | Returns a string of      |
|                    |                    |                         | currently inside the          | every item with every    |
|                    |                    |                         | basket.                       | attribute.               |
|                    |                    | getItemBasket()         | When access to the arraylist  | Returns basket as array  |
|                    |                    |                         | is required.                  | list.                    |
|                    |                    |                         |                               |                          |
| Receipt            | Basket basket      | void                    | User wants a receipt of the   | Prints the receipt using |
|                    |                    | generateReceipt(Basket) | purchase                      | system.out.println       |
|                    |                    |                         |                               |                          |
