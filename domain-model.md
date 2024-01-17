# Domain Model

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

| Class                | Method                             | Member                                            | Scenario                     | Return                |
|----------------------|------------------------------------|---------------------------------------------------|------------------------------|-----------------------|
| Cashier              | menu()                             | userInput                                         |                              | requests              |
|                      | doChoice(choice)                   | userInput                                         |                              | request               |
| Receipt              | calculateTotalCost(itemsMap)       | itemsMap<String item, int quantity>               | Get cost                     | Double                |
|                      | getProducts(itemsMap)              | itemsMap<String item, int quantity>               | show products                | String[] All products |
|                      | getReceipt(itemsMap, productPrice) | itemsMap<String item, int quantity>, productPrice | Show receipt                 | String                |
| Basket               | addItem(item, quantity)            | String item, Integer quantity                     | full basket                  | false                 |
|                      |                                    |                                                   | add item                     | true                  |
|                      |                                    |                                                   | Item not found               | false                 |
|                      | removeItem(item, quantity)         | String item, Integer quantity                     | remove item                  | true                  |
|                      |                                    |                                                   | Item not found               | false                 |
|                      | basketCapacity()                   | Integer capacity                                  | Show capacity                | Int                   |    
|                      | basketSize()                       |                                                   | Show current size            | Int                   |
|                      | changeCapacity(newCapacity)        | Integer capacity                                  | set capacity                 | String                |
| Inventory            | getProductType()                   |                                                   | Get all types                | String[]              |
|                      | getProductsOfType(type)            | String type                                       | Get all products of one type | String[]              |
|                      |                                    |                                                   | Invalid type                 | String                |
|                      | getAllProducts()                   |                                                   | Show all products            | String[]              |
| Product              | getType()                          |                                                   | invalid type                 | false                 |
|                      |                                    |                                                   | Valid type                   | true                  |
|                      | getCost()                          |                                                   | invalid type                 | false                 |
|                      |                                    |                                                   | Valid type                   | Int                   | 
|                      | getSKU()                           |                                                   | invalid type                 | false                 |
|                      |                                    |                                                   | Valid type                   | true                  |                                    |                                                   |                              |                       |
| Coffee/Bagel/Filling | getCoffee/Bagel/Filling(type)      | Coffee/Bagel/Filling-Type                         | invalid type                 | false                 |
|                      |                                    |                                                   | valid type                   | true                  |
