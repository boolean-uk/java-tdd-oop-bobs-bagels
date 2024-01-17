```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

| Classes | Methods           | Scenario                  | Output       |
|---------|-------------------|---------------------------|--------------|
| Basket  | add(String bagel) | User adds bagel to basket | return true  |
|         |                   | User adds empty name      | return false |
|         |                   | User adds invalid bagel   | return false |


```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```
| Classes | Methods              | Scenario             | Output       |
|---------|----------------------|----------------------|--------------|
| Basket  | remove(String bagel) | if bagel in basket   | return true  |
|         |                      | if bagel is null     | return false |
|         |                      | if bagel not in list | return false |


```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

| Classes | Methods          | Scenario             | Output       |
|---------|------------------|----------------------|--------------|
| Basket  | checkIfFull()    | if list not full     | return true  |
|         |                  | if list is full      | return false |
|         |                  | if bagel is null     | return false |

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

| Classes | Methods                      | Scenario         | Output       |
|---------|------------------------------|------------------|--------------|
| Basket  | changeCapacity(int capacity) | if capacity > 0  | return true  |
|         |                              | if capacity < -1 | return false |

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

| Classes | Methods                            | Scenario             | Output                              |
|---------|------------------------------------|----------------------|-------------------------------------|
| Basket  | tryRemoveBagelInList(String bagel) | if bagel not in list | return "Bagel not in list"          |
|         |                                    | if bagel in list     | return "Bagel is removed from list" |

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```
| Classes | Methods     | Scenario          | Output       |
|---------|-------------|-------------------|--------------|
| Basket  | totalCost() | if list is empty  | return 0     |
|         |             | if list not empty | return total |

```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

| Classes | Methods   | Scenario                                  | Output             |
|---------|-----------|-------------------------------------------|--------------------|
| Bagel   | getCost() | if bagel not null and basketList not null | return costOfBagel |
|         |           | else                                      | return null        |
|         |           |                                           |                    |

```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```
| Classes | Methods      | Scenario                                     | Output       |
|---------|--------------|----------------------------------------------|--------------|
| Bagel   | addFilling() | if filling in fillingList and bagel not null | return true  |
|         |              | else                                         | return false |
|         |              |                                              |              |

```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```