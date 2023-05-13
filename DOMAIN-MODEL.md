# User stories
1. I'd like to add a specific type of bagel to my basket.(Done)
2. I'd like to remove a bagel from my basket.(Done)
3. I'd like to know when my basket is full when I try adding an item beyond my basket capacity.(Done)
4. I’d like to change the capacity of baskets. (Done)
5. I'd like to know if I try to remove an item that doesn't exist in my basket.(Done)
6. I'd like to know the total cost of items in my basket.
7. I'd like to know the cost of a bagel before I add it to my basket.
8. I'd like to be able to choose fillings for my bagel.
9. I'd like to know the cost of each filling before I add it to my bagel order.
10. I want customers to only be able to order things that we stock in our inventory.(Done)

# Domain model
| Class     | Attributes               | Methods               | Scenarios | Outcome           |
|-----------|--------------------------|-----------------------|-----------|-------------------|
| Item      | String sku               |                       |           |                   |
|           | double price             |                       |           |                   |
|           | String name              |                       |           |                   |
|           | String variant           |                       |           |                   |
|           | ArrayList<Item> fillings |                       |           |                   |
|           |                          | addFilling(Item item) | 8.,10     | returns a message |
| Basket    | ArrayList<Item> items    |                       |           |                   |
|           |                          | addItem(Item item)    | 1.,3.,10  | returns a message |
|           |                          | removeItem(Item item) | 2.,5.     | returns a message |
|           | int capacity             |                       | 4.        | returns an int    |
|           |                          | getTotal()            | 6.,9.     | returns an int    |
| Inventory | ArrayList<Items>         |                       |           |                   |
|           |                          | showPrice(Item item)  | 7.        | makes a print     |
|           |                          |                       |           |                   |
| Store     | Inventory inventory      |                       |           |                   |
|           | Basket basket            |                       |           |                   |
|           |                          |                       |           |                   |




