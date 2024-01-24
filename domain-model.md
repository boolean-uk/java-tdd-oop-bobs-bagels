## Domain model

```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

| Classes | Methods                      | Scenario             | Returns                 |
|---------|------------------------------|----------------------|-------------------------|
| Basket  | String addBagel(String name) | Add a new bagel      | "bagel name added"      |
| Bagel   |                              | Add a existing bagel | "bagel already exists"  |


```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

| Classes | Methods                         | Scenario                             | Returns               |
|---------|---------------------------------|--------------------------------------|-----------------------|
| Basket  | String removeBagel(String name) | Remove a bagel in basket             | "bagel removed"       |
| Bagel   |                                 | Remove a bagel that is not in basket | "Bagel not in basket" |


```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

| Classes | Methods                      | Scenario                       | Returns       |
|---------|------------------------------|--------------------------------|---------------|
| Basket  | String addBagel(String name) | Add bagel when basket not full | "bagel added" |
|         |                              | Add bagel when basket full     | "basket full" |
|         |                              |                                |               |


```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

| Classes | Methods                              | Scenario             | Returns |
|---------|--------------------------------------|----------------------|---------|
| Basket  | boolean changeCapacity(int capacity) | Add a valid capacity | true    |
|         |                                      | Add invalid capacity | false   |


```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

| Classes | Methods                         | Scenario                    | Returns                 |
|---------|---------------------------------|-----------------------------|-------------------------|
| Basket  | String removeBagel(String name) | Remove a non-existing bagel | "Bagel not in basket"   |
| Bagel   |                                 |                             |                         |

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

| Classes | Methods         | Scenario | Output                  |
|---------|-----------------|----------|-------------------------|
| Basket  | int totalCost() |          | cost of items in basket |
| Bagel   | int price()     |          |                         |

```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

| Classes | Methods    | Scenario                     | Output        |
|---------|------------|------------------------------|---------------|
| Bagel   | getPrice() | get cost before buying bagel | cost of bagel |
|         |            |                              |               |


```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

| Classes  | Methods | Scenario               | Output                |
|----------|---------|------------------------|-----------------------|
| Fillings |         | want filling for bagel | add filling to basket |
|          |         |                        |                       |
```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

| Classes | Methods    | Scenario                       | Output          |
|---------|------------|--------------------------------|-----------------|
| Filling | getPrice() | get cost before buying filling | cost of filling |
|         |            |                                |                 |
```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```

| Classes   | Methods       | Scenario                     | Output                           |
|-----------|---------------|------------------------------|----------------------------------|
| Inventory | getProducts() | want to see what you can buy | list of things to buy and prices |
|           |               |                              |                                  |






