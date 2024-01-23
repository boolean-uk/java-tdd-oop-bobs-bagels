# Domain model for Bob's bagels

```
User story 1
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

Class Basket

| Class vars                                | Methods               | Scenario                        | Return/Result |
|-------------------------------------------|-----------------------|---------------------------------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | addBagel(Bagel bagel) | if bagel is added to basket     | true          |
| int maxCapacity                           |                       | if bagel is not added to basket | false         |
| int currentIndex                          |                       |                                 |               |

Class Bagel

| Class vars       | Methods                                            | Scenario | Return/Result |
|------------------|----------------------------------------------------|----------|---------------|
| String name      | Bagel(String name, String productID, double price) |          |               |
| String productID |                                                    |          |               |
| String uniqueID  |                                                    |          |               |
| double price     |                                                    |          |               |

Class Filling

| Class vars       | Methods                                              | Scenario | Return/Result |
|------------------|------------------------------------------------------|----------|---------------|
| String name      | Filling(String name, String productID, double price) |          |               |
| String productID |                                                      |          |               |
| double price     |                                                      |          |               |


```
User story 2
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

Class Basket

| Class vars                                | Methods                  | Scenario                        | Return/Result |
|-------------------------------------------|--------------------------|---------------------------------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | removeBagel(Bagel bagel) | if bagel is removed from basket | true          |
| int maxCapacity                           |                          | if bagel is not in basket       | false         |
| int currentIndex                          |                          |                                 |               |


```
User story 3
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

When calling the Basket class's addBagel method and the basket is already full, it will return false.

```
User story 4
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

Class Basket

| Class vars                                | Methods                                       | Scenario                     | Return/Result |
|-------------------------------------------|-----------------------------------------------|------------------------------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | extendCapacityOfBasket(int additionalIndices) | what is the new basket size? | int           |
| int maxCapacity                           |                                               |                              |               |
| int currentIndex                          |                                               |                              |               |


```
User story 5
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

Class Basket

| Class vars                                | Methods                                       | Scenario                  | Return/Result |
|-------------------------------------------|-----------------------------------------------|---------------------------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | removeNonExistentBagelFromBasket(Bagel bagel) | if bagel is not in basket | true          |
| int maxCapacity                           |                                               | if bagel is in basket     | false         |
| int currentIndex                          |                                               |                           |               |

```
User story 6
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

Class Basket

| Class vars                                | Methods        | Scenario                       | Return/Result |
|-------------------------------------------|----------------|--------------------------------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | getTotalCost() | if basket has bagels           | true          |
| int maxCapacity                           |                | if basket does not have bagels | false         |
| int currentIndex                          |                |                                |               |


```
User story 7
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

Class Bagel

| Class vars       | Methods    | Scenario | Return/Result |
|------------------|------------|----------|---------------|
| String name      | getPrice() |          | double        |
| String productID |            |          |               |
| String uniqueID  |            |          |               |
| double price     |            |          |               |


```
User story 8
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

Class Basket

| Class vars                                | Methods                                                     | Scenario                   | Return/Result |
|-------------------------------------------|-------------------------------------------------------------|----------------------------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | addFillingToBagel(Bagel bagel, ArrayList<Filling> fillings) | if filling/s was added     | true          |
| int maxCapacity                           |                                                             | if filling/s was not added | false         |
| int currentIndex                          |                                                             |                            |               |

```
User story 9
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```
Class Inventory

| Class vars                            | Methods                    | Scenario | Return/Result |
|---------------------------------------|----------------------------|----------|---------------|
| HashMap<Bagel, Integer> allBagels     | getAvailableFillingsInfo() |          |               |
| HashMap<Filling, Integer> allFillings |                            |          |               |
| HashMap<Coffee, Integer> allCoffees   |                            |          |               |


Class Filling

| Class vars       | Methods    | Scenario | Return/Result |
|------------------|------------|----------|---------------|
| String name      | getPrice() |          | double        |
| String productID |            |          |               |
| double price     |            |          |               |

Class Basket

| Class vars                                | Methods                     | Scenario | Return/Result |
|-------------------------------------------|-----------------------------|----------|---------------|
| HashMap<Bagel, ArrayList<Filling>> basket | Basket(Inventory inventory) |          |               |
| int maxCapacity                           |                             |          |               |
| int currentIndex                          |                             |          |               |
| Inventory inventory                       |                             |          |               |


```
User story 10
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```
Class Inventory

| Class vars                            | Methods             | Scenario | Return/Result |
|---------------------------------------|---------------------|----------|---------------|
| HashMap<Bagel, Integer> allBagels     | getAvailableItems() |          |               |
| HashMap<Filling, Integer> allFillings |                     |          |               |
| HashMap<Coffee, Integer> allCoffees   |                     |          |               |
