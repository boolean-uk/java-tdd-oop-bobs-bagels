
```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

| Classes        | Methods                   | Scenario                                  | Output                      |
|----------------|---------------------------|-------------------------------------------|-----------------------------|
| Item           | addItem(String id)        | Item type is available, not in basket     | add item to basket          |
|                |                           | Item type is available, already in basket | increase amount in basket   |
|                |                           | Item type is not available                | throw exception NoSuchBagel |
|                | inBasket(String id)       | Item is in basket                         | true                        |
|                |                           | Item is not in basket                     | false                       |
| BagelInventory | availableBagel(String id) | Item is in inventory                      | true                        |
|                |                           | Item is not in inventory                  | false                       |
|                |                           |                                           |                             |


```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

| Classes | Methods               | Scenarios             | Outputs                     |
|---------|-----------------------|-----------------------|-----------------------------|
| Item    | removeItem(String id) | Item is in basket     | item removed                |
|         |                       | Item is not in basket | throw exception NotInBasket |
|         |                       |                       |                             |

```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

| Classes | Methods  | Scenarios          | Outputs |
|---------|----------|--------------------|---------|
| Basket  | isFull() | Basket is full     | true    |
|         |          | Basket is not full | false   |

```

4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```
| Classes | Methods   | Scenarios                                       | Outputs                     |
|---------|-----------|-------------------------------------------------|-----------------------------|
| Basket  | setSize() | Basket contains equal/fewer items than new size | change basket.size          |
|         |           | Basket contains more items than new size        | UnableToChangeSizeException |
|         |           |                                                 |                             |

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.



6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.

```
| Classes | Methods        | Scenarios                                | Outputs                      |
|---------|----------------|------------------------------------------|------------------------------|
| Basket  | getTotalCost() | Get the total cost of items in basket    | return total prize as double |
|         |                |                                          |                              |

```

7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.

```
| Classes | Methods    | Scenarios               | Outputs                      |
|---------|------------|-------------------------|------------------------------|
| Item    | getPrize() | Get the prize of item   | return total prize as double |
|         |            |                         |                              |

```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.

```
| Classes | Methods                    | Scenarios                   | Outputs                      |
|---------|----------------------------|-----------------------------|------------------------------|
| Bagel   | addFilling(String filling) | Filling is in inventory     | return total prize as double |
|         |                            | Filling is not in inventory | NotInInventoryException      |

```

9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.

```
| Classes | Methods        | Scenarios                      | Outputs                        |
|---------|----------------|--------------------------------|--------------------------------|
| Bagel   | showFillings() | Show all fillings in inventory | Fillings information as String |
|         |                |                                |                                |

```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.