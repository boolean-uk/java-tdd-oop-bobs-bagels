## Core Requirements

```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

```
6. 
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

```
7. 
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

```
8. 
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

```
9. 
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

```
10. 
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```

| Classes   | Fields                 | Methods                                      | Scenario                                                                                         | Outputs                                                                                                                               |
|-----------|------------------------|----------------------------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| Basket    | List<Bagel> bagels     |                                              |                                                                                                  |                                                                                                                                       |
|           | int capacity           |                                              |                                                                                                  |                                                                                                                                       |
|           |                        | addBagel(Bagel bagel)                        | Adds a bagel item to the basket. Raises an exception if the basket is already full               | Adds a bagel item                                                                                                                     |
|           |                        | removeBagel(Bagel bagel)                     | Removes a bagel item from the basket. Raises an exception if the item is not found in the basket | Removes a bagel item                                                                                                                  |
|           |                        | getBagelsCount()                             | Returns the number of items currently in the basket                                              | The number of items currently in the basket                                                                                           |
|           |                        | isFull()                                     | Returns True if the basket is full, False otherwise                                              | True / False                                                                                                                          |
|           |                        | changeCapacity(int newCapacity)              | Changes the capacity of the basket to the specified value                                        | Changed capacity of the basket                                                                                                        |
|           |                        | totalCost()                                  | Get total cost of  items in basket                                                               |                                                                                                                                       |
|           |                        | checkIfBagelIsInInventory(Bagel bagel)       | Checks if bagel is in our inventory                                                              | True/ false                                                                                                                           |
|           |                        | checkIfCoffeeIsInInventory(Coffee coffee)    | Checks if coffee is in our inventory                                                             | True/ false                                                                                                                           |
|           |                        | checkIfFillingIsInInventory(Filling filling) | Checks if filling is in our inventory                                                            | True/ false                                                                                                                           |
|           |                        | order(Bagel bagel)                           | Make an order                                                                                    | Ruturns string if bagel is in inventory with a success message and order can be made, otherwise returns string with a error message   |
|           |                        | order(Coffee coffee)                         | Make an order                                                                                    | Ruturns string if coffee is in inventory with a success message and order can be made, otherwise returns string with a error message  |
|           |                        | order(Filling filling)                       | Make an order                                                                                    | Ruturns string if filling is in inventory with a success message and order can be made, otherwise returns string with a error message |
|           |                        |                                              |                                                                                                  |                                                                                                                                       |
| Bagel     | double price           | getPrice()                                   | Get price of a particular bagel                                                                  | Price of a bagel (double)                                                                                                             |
|           | Filling filling        | chooseFilling(Filling filling)               | Choose filling for your bagel                                                                    |                                                                                                                                       |
|           |                        | getAllBagels()                               | Get all fillings and their prices                                                                | Returns HashMap<String, Double>                                                                                                       |
|           |                        |                                              | Get all bagels which are in our inventory                                                        | Returns list of bagels                                                                                                                |
|           |                        |                                              |                                                                                                  |                                                                                                                                       |
| Filling   | String type            | getType()                                    |                                                                                                  |                                                                                                                                       |
|           | double price           | getPrice()                                   |                                                                                                  |                                                                                                                                       |
|           |                        | setType(String type)                         |                                                                                                  |                                                                                                                                       |
|           |                        | setPrice(double price)                       |                                                                                                  |                                                                                                                                       |
|           |                        |                                              |                                                                                                  |                                                                                                                                       |
| Inventory | List<Bagel> bagels     | getAllBagels()                               |                                                                                                  |                                                                                                                                       |
|           | List<Coffee> coffees   | getAllCoffees()                              |                                                                                                  |                                                                                                                                       |
|           | List<Filling> fillings | getAllFillings()                             |                                                                                                  |                                                                                                                                       |
|           |                        |                                              |                                                                                                  |                                                                                                                                       |
| Coffee    | String type            | getType()                                    |                                                                                                  |                                                                                                                                       |
|           | double price           | getPrice()                                   |                                                                                                  |                                                                                                                                       |
|           |                        | setType(String type)                         |                                                                                                  |                                                                                                                                       |
|           |                        | setPrice(double price)                       |                                                                                                  |                                                                                                                                       |

```

