# Domain Model

Accessor methods are not included in the domain model (eg. setCapacity(int), getBasket(), etc)

| Class                    | Method                            | Return value     | Class variable                           | Description                                           |
|--------------------------|-----------------------------------|------------------|------------------------------------------|-------------------------------------------------------|
| Store                    | getItemsByItemType(ItemType type) | ArrayList\<Item> | ArrayList\<Item> inventory               | Gets all items of a certain type (eg Coffee or Bagel) |
|                          | getItemBySKU(String sku)          | Item             | ArrayList\<Item> inventory               | Gets a single item from inventory based on the SKU    |
| Basket                   | addItem(Item item)                | Item             | ArrayList\<Item> basket                  | Adds a specific type of Item to the Basket            |
|                          | removeItem(Item item)             | boolean          | ArrayList\<Item> basket                  | Removes a specific type of Item from the Basket       |
|                          | isFull()                          | boolean          | ArrayList\<Item> basket<br/>int capacity | Checks if Basket is full based on capacity variable   |
|                          | getTotalCost()                    | double           | ArrayList\<Item> basket                  | Returns the total cost of all items in basket         |
| Item                     | *Only accessor methods*           |                  |                                          |                                                       |
| Bagel *(extends Item)*   | addFilling(Filling filling)       | boolean          | ArrayList\<Filling> filling              | Adds a Filling to a specific Bagel                    |
|                          | removeFilling(Filling filling)    | boolean          | ArrayList\<Filling> filling              | Removes a Filling from a specific Bagel               |

# User Stories

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