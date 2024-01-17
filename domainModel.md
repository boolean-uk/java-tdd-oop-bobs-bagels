# Domain model 
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


| Class   | Variables       | Methods              |
|---------|-----------------|----------------------|
| Product | String: sku     | getSKU(): String     |
| Bagel   | double: price   | setSKU(): void       |
| Coffee  | String: name    | getPrice(): double   |
| Filling | String: variant | setPrice(): void     |
|         |                 | getName(): String    |
|         |                 | setName(): void      |
|         |                 | getVariant(): String |
|         |                 | setVariant(): void   |


| Class     | Variables                         | Method             |
|-----------|-----------------------------------|--------------------|
| Inventory | ArrayList <Product> inventoryItem | getInventoryItem() |


| Class  | Variables                             | Methods                        | Scenarios                                  | Outputs            |
|--------|---------------------------------------|--------------------------------|--------------------------------------------|--------------------|
| Basket | ArrayList<Inventory> ? HashMap basket | add(Product item)              | If item is in the basket                   | false              |
|        |                                       |                                | If item is not in the basket               | true               |
|        |                                       | remove(Product item)           | If item exits                              | true               |
|        |                                       |                                | If item doesn't exit                       | false/message      |
|        |                                       | isFull()                       | If basket is full                          | true               |
|        |                                       |                                | If basket is not full                      | false              |
|        |                                       | changeCapacity(int newCapacity) | If basket capacity successfully changed    | true               |
|        |                                       |                                | If basket capacity is not changed          | false              |
|        |                                       | getTotalCost()                 | User wants to know the total cost          | sum of item prices |
|        |                                       | getItemCost()                  | User wants to know the cost of item        | price of item      |
|        |                                       | addFilling()                   | User wants to add filling to their bagel   | true               |
|        |                                       | getFillingCost()               | User wants to know the cost of the filling | price              |
|        |                                       | isItemInInventory()            | If item is in inventory                    | true               |
|        |                                       |                                | If item is not in inventory                | false              |


