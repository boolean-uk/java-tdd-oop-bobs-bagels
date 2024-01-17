## Domain model

```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

| Classes | Methods                                               | Scenario                    | Returns |
|---------|-------------------------------------------------------|-----------------------------|---------|
| Basket  | boolean addItem(String name, String type, int amount) | if item is in inventory     | true    |
|         |                                                       | if item is not in inventory | false   |

```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

| Classes | Methods                                      | Scenario               | Returns |
|---------|----------------------------------------------|------------------------|---------|
| Basket  | boolean removeItem(String name, String type) | if item exists         | true    |
|         |                                              | it item does not exist | false   |

```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

| Classes | Methods                 | Scenario              | Returns |
|---------|-------------------------|-----------------------|---------|
| Basket  | boolean addItem(T item) | if basket is full     | false   |
|         |                         | if basket is not full | true    |

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

| Classes | Methods                              | Scenario                         | Returns |
|---------|--------------------------------------|----------------------------------|---------|
| Shop    | boolean changeCapacity(int capacity) | if capacity is an invalid number | false   |
|         |                                      | if capacity is a valid number    | true    |
|         |                                      | if there are active baskets      | false   |

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

| Classes | Methods                                   | Scenario            | Returns |
|---------|-------------------------------------------|---------------------|---------|
| Shop    | boolean removeItem(Basket basket, T item) | item exists         | true    |
|         |                                           | item does not exist | false   |

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

| Classes | Methods               | Scenario                 | Returns                              |
|---------|-----------------------|--------------------------|--------------------------------------|
| Basket  | double getTotalCost() | If a basket has items    | double with value of items in basket |
|         |                       | If a basket has no items | 0                                    |
```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

| Classes   | Methods                          | Scenario      | Returns |
|-----------|----------------------------------|---------------|---------|
| Inventory | String getPriceInfo(String name) | Method called | String  |
|           |                                  |               |         |

```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

| Classes | Methods                                           | Scenario                       | Returns             |
|---------|---------------------------------------------------|--------------------------------|---------------------|
| Bagel   | boolean addFillings(ArrayList<Fillings> fillings) | If all fillings are viable     | true                |
|         |                                                   | if all fillings are not viable | false               |
|         | ArrayList<Fillings> getFillings()                 | If bagel has fillings          | ArrayList<Fillings> |
|         |                                                   | If bagel has no fillings       | null                |
```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

| Classes   | Methods               | Scenario      | Returns                                      |
|-----------|-----------------------|---------------|----------------------------------------------|
| Inventory | String listFillings() | Method called | String containing information about fillings |
|           |                       |               |                                              |

```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```
| Classes   | Methods                                                | Scenario                            | Returns            |
|-----------|--------------------------------------------------------|-------------------------------------|--------------------|
| Inventory | ArrayList<Bagel> getBagel(String name, int amount)     | If bagel is in inventory            | ArrayList<Bagel>   |
|           |                                                        | If enough bagel is not in inventory | null               |
|           | ArrayList<Filling> getFilling(String name, int amount) | If enough filling is in inventory   | ArrayList<Filling> |
|           |                                                        | If filling is not in inventory      | null               |
|           | ArrayList<Coffee> getCoffee(int amount)                | Method called                       | ArrayList<Coffee>  |
|           |                                                        |                                     |                    |