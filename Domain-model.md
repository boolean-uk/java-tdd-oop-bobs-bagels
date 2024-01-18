# Bob's Bagels


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

## Domain Model

### Class Basket

| Methods                              | Member variables                                       | Scenario                     | Output/return                                  |
|--------------------------------------|--------------------------------------------------------|------------------------------|------------------------------------------------|
| {1,3,8, 10}`add(Item item)`          | HashMap<Item item, int amount> basketContent           | item *in* inventory and      | String "Item *item* added to basket."          |
|                                      | HashMap<Item item, int amount> BobsBagelShop.inventory | basket *is not* full.        |                                                |
|                                      | int basketCapacity                                     | item *not in* inventory.     | String "Chosen item not in stock."             |
|                                      |                                                        | basket *is* full.            | String "Basket is full."                       |
| {2,5}`remove(Item item)`             | HashMap<Item item, int amount> basketContent           | item *not in* basket.        | String "Item *item* not in basket."            |
|                                      |                                                        | item *in* basket.            | String "Item *item* removed from basket."      |
| {6}`totalCost()`                     | HashMap<Item item, int amount> basketContent           | Not empty basket.            | double price                                   |
|                                      | double item.price                                      | Empty basket.                | double price = 0.0.                            |
| {4}`changeCapacity(int newCapacity)` | int basketCapacity                                     | newCapacity < 0              | String "New capacity must be non negative."    |
|                                      |                                                        | newCapacity >= 0             |                                                |
|                                      |                                                        | && no baskets have more      | String "New basket capacity is *newCapacity*." |
|                                      |                                                        | items than newCapacity.      |                                                |
|                                      |                                                        | Baskets have more items than | String "New capacity must be larger than       |
|                                      |                                                        | newCapacity.                 | number of items currently in basket."          |
|                                      |                                                        |                              |                                                |

### Class BobsBagelsShop

| Methods                              | Member variables               | Scenario                     | Output/Return                                         |
|--------------------------------------|--------------------------------|------------------------------|-------------------------------------------------------|
| {7,9}`showInventory()`               | HashMap<Item item, int amount> | Inventory not empty.         | String "Bob's Bagels\nSKU\tPrice\tName\tVariant\n..." |
|                                      | inventory                      | Inventory empty.             | String "No items in stock."                           |


### Class Item

| Methods                                                       | Member variables | Scenario | Output/Return |
|---------------------------------------------------------------|------------------|----------|---------------|
| {7,9}`getPrice()`                                             | double price     |          | double price  |
|                                                               |                  |          |               |
| `Item(String sku, String name, String variant, double price)` | double price     |          |               |
|                                                               | String name      |          |               |
|                                                               | String variant   |          |               |
|                                                               | String sku       |          |               |

