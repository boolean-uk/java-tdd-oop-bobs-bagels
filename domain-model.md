# Domain Model

## User Stories
```
1.
As a member of the public,
So I can order a item before work,
I'd like to add a specific type of item to my basket.

2.
As a member of the public,
So I can change my order,
I'd like to remove a item from my basket.

3.
As a member of the public,
So that I can not overfill my small item basket
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
I'd like to know the total cost of item in my basket.

7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a item before I add it to my basket.

8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my item.

9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my item order.

10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```

| Class                | Method                                   | Member                                                | Scenario                     | Return         |
|----------------------|------------------------------------------|-------------------------------------------------------|------------------------------|----------------|
| Cashier              | menu()                                   | userInput                                             |                              | response       |
|                      | doChoice(choice)                         | userInput                                             |                              | response       |
|                      | main()                                   |                                                       |                              |                |
| Basket               | addItem(Inventory, item, quantity)       | Class Inventory, String item, Integer quantity        | full basket                  | false          |
|                      |                                          |                                                       | add item                     | true           |
|                      |                                          |                                                       | Item not found               | false          |
|                      | removeItem(Inventory, sku, quantity)     | Class Inventory, String item, Integer quantity        | remove item                  | true           |
|                      |                                          |                                                       | Item not found               | false          |
|                      | changeCapacity(capacity)                 | Integer capacity                                      | Changed capacity             | true           |
|                      |                                          |                                                       | Unable to change capacity    | false          |
|                      | getTotalCost()                           | ArrayList<Item>                                       | Get total cost               | Return cost    |
| Inventory            | printInventory(inventory, inventoryName) | HashMap<String, Item> inventory, String inventoryName | Show all added products      | String[]       |
|                      | getProductsBySku(sku)                    | String sku                                            | Get all products of one type | String[]       |
|                      | getAllProducts()                         |                                                       | Show all products            | String[]       |
| Item                 | getType()                                |                                                       | get type                     | String type    |
|                      | getVariant()                             |                                                       | get variant                  | String variant |
|                      | getSku()                                 |                                                       | get sku                      | String sku     |
|                      | getPrice()                               |                                                       | get price                    | double price   |
|                      | getQuantity()                            |                                                       | get quantity                 | int quantity   |  
