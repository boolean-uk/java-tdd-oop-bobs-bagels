# Bob's Bagel Shop OOP

## Bob's Inventory

| SKU  | Price | Name    | Variant       |
|------|-------|---------|---------------|
| BGLO | 0.49  | Bagel   | Onion         |
| BGLP | 0.39  | Bagel   | Plain         |
| BGLE | 0.49  | Bagel   | Everything    |
| BGLS | 0.49  | Bagel   | Sesame        |
| COFB | 0.99  | Coffee  | Black         |
| COFW | 1.19  | Coffee  | White         |
| COFC | 1.29  | Coffee  | Capuccino     |
| COFL | 1.29  | Coffee  | Latte         |
| FILB | 0.12  | Filling | Bacon         |
| FILE | 0.12  | Filling | Egg           |
| FILC | 0.12  | Filling | Cheese        |
| FILX | 0.12  | Filling | Cream Cheese  |
| FILS | 0.12  | Filling | Smoked Salmon |
| FILH | 0.12  | Filling | Ham           |

# Class BasketManager

| Member Variables   | Methods              | Scenario                                 | Return                 | Output  |
|--------------------|----------------------|------------------------------------------|------------------------|---------|
| basket: List<Item> |                      |                                          |                        |         |
| capacity: int      |                      |                                          |                        |         |
|                    | add()                | If I want to add Item                    | The added Item         | void    |
|                    | remove()             | If I want to remove Item                 | The removed Item       | void    |
|                    | checkCapacity()      | If I want to make sure not overfill      | The capacity remaining | Sys.out |
|                    | changeCapacity()     | If I want to limit the baskets sizes     | void                   | void    |
|                    | checkItemInBasket()  | If I want to check if item is in basket, | boolean                | Sys.out |
|                    |                      | before I try to remove it                |                        |         |
|                    | totalCost()          | If I want to know the value of Items,    | double                 | Sys.out |
|                    |                      | currently in the basket                  |                        |         |
|                    | checkItemInventory() | If I want to make sure we stock          | boolean                | void    |

# Class InventoryManager

| Member Variables                 | Methods               | Scenario                      | Return                | Output  |
|----------------------------------|-----------------------|-------------------------------|-----------------------|---------|
| inventory: HashMap<String, Item> |                       |                               |                       |         |
|                                  | initializeInventory() | When I want to open the shop  | HashMap<String, Item> | void    |
|                                  | costEachFilling()     | When I want to know the cost  | String                | Sys.out |
|                                  |                       | of each filling before adding |                       |         |


# Class Item

| Member Variables | Methods      | Scenario                                            | Return | Output  |
|------------------|--------------|-----------------------------------------------------|--------|---------|
| SKU: String      |              |                                                     |        |         |
| price: double    |              |                                                     |        |         |
| name: enum       |              |                                                     |        |         |
| variant: enum    |              |                                                     |        |         |
| filling: Item    |              |                                                     |        |         |
|                  | addFilling() | If I want to associate a filling with an Item       | void   | void    |
|                  | getPrice()   | If I want to know the price before adding to basket | int    | Sys.out |



## Class Diagram

![](./src/main/java/com/booleanuk/core/class-diagram.jpg)




## User Stories

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