### User Stories

## User Story 1
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.

# Domain Model For User Story 1

``` Notes 
Class | Member variables | Methods | Scenario | Output/Result
Basket  String type        addBagelType()   Add a specific type of bagel to basket Return true
```

Version 1

| Class  | Member variables        | Methods                                | Scenario                          | Output/Result |
|--------|-------------------------|----------------------------------------|-----------------------------------|---------------|
| Basket | ArrayList<Bagel> bagels | addBagelTypeToBasket(String bagelType) | If bagel type added to basket     | Return true   |
| Bagel  |                         |                                        | If bagel type not added to basket | Return false  |

Version 2

| Class  | Member variables                | Methods                                   | Scenario                             | Output/Result |
|--------|---------------------------------|-------------------------------------------|--------------------------------------|---------------|
| Basket | ArrayList<Inventory> basketList | addBagelTypeToBasket(String bagelVariant) | If bagel type is added to basket     | Return true   |
| Bagel  |                                 |                                           | If bagel type is not added to basket | Return false  |


## User Story 2
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.

# Domain Model For User Story 2

``` Notes 
Class | Member variables | Methods | Scenario | Output/Result
Basket  String type        removeBagelType()   Remove a specific type of bagel to basket Return true
```

Version 1

| Class  | Member variables        | Methods                                     | Scenario                          | Output/Result |
|--------|-------------------------|---------------------------------------------|-----------------------------------|---------------|
| Basket | ArrayList<Bagel> bagels | removeBagelTypeFromBasket(String bagelType) | If bagel type removed from basket | Return true   |
| Bagel  |                         |                                             | If bagel type not removed basket  | Return false  |

Version 3

| Class  | Member variables                | Methods                                       | Scenario                                 | Output/Result |
|--------|---------------------------------|-----------------------------------------------|------------------------------------------|---------------|
| Basket | ArrayList<Inventory> basketList | removeBagelTypeFromBasket(Bagel bagelVariant) | If bagel type is removed from basket     | Return true   |
| Bagel  |                                 |                                               | If bagel type is not removed from basket | Return false  |


## User Story 3
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

# Domain Model For User Story 3

``` Notes
Class | Member variables | Methods | Scenario | Output/Result
Basket  ArrayList<String> bagels, int basketSize        basketIsFull()   If basket is full return true
```

Version 1

| Class  | Member variables        | Methods                    | Scenario              | Output/Result                |
|--------|-------------------------|----------------------------|-----------------------|------------------------------|
| Basket | ArrayList<Bagel> bagels | basketIsFull(int quantity) | If basket is full     | Return "Basket is full!"     |
|        |                         |                            | If basket is not full | Return "Basket is not full." |

Version 2

| Class  | Member variables        | Methods        | Scenario              | Output/Result                |
|--------|-------------------------|----------------|-----------------------|------------------------------|
| Basket | ArrayList<Bagel> bagels | basketIsFull() | If basket is full     | Return "Basket is full!"     |
| Bagel  | int basketSize          |                | If basket is not full | Return "Basket is not full." |

Version 3

| Class  | Member variables                | Methods             | Scenario              | Output/Result                |
|--------|---------------------------------|---------------------|-----------------------|------------------------------|
| Basket | ArrayList<Inventory> basketList | bagelBasketIsFull() | If basket is full     | Return "Basket is full!"     |
|        | int basketSize                  |                     | If basket is not full | Return "Basket is not full." |


## User Story 4
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.

# Domain Model For User Story 4

Version 1

| Class  | Member variables | Methods                               | Scenario                          | Output/Result                            |
|--------|------------------|---------------------------------------|-----------------------------------|------------------------------------------|
| Basket | int basketSize   | changeBasketCapacity(int newCapacity) | If basket capacity is changed     | Return "Basket capacity is changed."     |
|        |                  |                                       | if basket capacity is not changed | Return "Basket capacity is not changed." |


## User Story 5
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.

``` Notes 
Class | Member variables | Methods | Scenario | Output/Result
Basket  ArrayList<String> bagels        canRemoveItemInBasket()   Remove a specific type of bagel to basket Return true
```
# Domain Model For User Story 5
Version 1

| Class  | Member variables                 | Methods                               | Scenario                      | Output/Result                                       |
|--------|----------------------------------|---------------------------------------|-------------------------------|-----------------------------------------------------|
| Basket | ArrayList<Inventory> basketList; | canRemoveItemInBasket(String variant) | Item exist in basket          | Return "Item is in basket and can be removed"       |
|        |                                  |                                       | Item does not exist in basket | Return "Item is not in basket and can't be removed" |

Version 2

| Class     | Member variables                 | Methods                                   | Scenario                         | Output/Result                                       |
|-----------|----------------------------------|-------------------------------------------|----------------------------------|-----------------------------------------------------|
| Basket    | ArrayList<Inventory> basketList; | canRemoveItemInBasket(String itemVariant) | If item exist in basket          | Return "Item is in basket and can be removed"       |
| Inventory |                                  |                                           | If item does not exist in basket | Return "Item is not in basket and can't be removed" |

## User Story 6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.

# Domain Model For User Story 6


| Class  | Member variables                 | Methods                                                        | Scenario           | Output/Result                |
|--------|----------------------------------|----------------------------------------------------------------|--------------------|------------------------------|
| Basket | ArrayList<Inventory> basketList; | double totalCostOfItems()                                      | if all items added | Return totalCost as a double |
|        |                                  |                                                                | if no items added  | Return 0.0                   |

## User Story 7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.

# Domain Model For User Story 7

| Class     | Member Variables                   | Methods                                      | Scenario             | Output/Result                    |
|-----------|------------------------------------|----------------------------------------------|----------------------|----------------------------------|
| Basket    | ArrayList<Inventory> inventoryList | double returnCostOfBagel(Bagel bagelVariant) | I want cost of bagel | Return cost of bagel as a double |
| Inventory |                                    |                                              |                      |                                  |
| Bagel     |                                    |                                              |                      |                                  |


## User Story 8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.

# Domain Model For User Story 8


| Class     | Member Variables                   | Methods                                         | Scenario                                 | Output/Result                          |
|-----------|------------------------------------|-------------------------------------------------|------------------------------------------|----------------------------------------|
| Basket    | ArrayList<Inventory> inventoryList | String chooseBagelFilling(Filling bagelFilling) | I want to choose the filling of my bagel | Return affirming statement as a String |
| Inventory |                                    |                                                 |                                          |                                        |
| Filling   |                                    |                                                 |                                          |                                        |


## User Story 9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.

# Domain Model For User Story 9


| Class     | Member Variables                   | Methods                                        | Scenario                               | Output/Result                      |
|-----------|------------------------------------|------------------------------------------------|----------------------------------------|------------------------------------|
| Basket    | ArrayList<Inventory> inventoryList | double costOfEachFilling(Filling bagelFilling) | I want to see the cost of each filling | Return cost of filling as a double |
| Inventory |                                    |                                                |                                        |                                    |
| Filling   |                                    |                                                |                                        |                                    |


## User Story 10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.

# Domain Model For User Story 10


| Class     | Member Variables                   | Methods                               | Scenario            | Output/Result |
|-----------|------------------------------------|---------------------------------------|---------------------|---------------|
| Basket    | ArrayList<Inventory> inventoryList | boolean mustBeInInventory(String sku) | If in inventory     | Return true   |
| Inventory |                                    |                                       | If not in inventory | Return false  |


## Extensions

# Extension 1

# User Stories

As a customer,
So I can make a huge order,
I want to see the total price for discounted bagels and coffee.

# Domain Model

| Class              | Member Variables | Methods                          | Scenario | Output/Result |
|--------------------|------------------|----------------------------------|----------|---------------|
| ExtensionExercise1 | int countBGLO    | double returnItemsWithDiscount() |          |               |
|                    | int countBGLP    |                                  |          |               |
|                    | int countBGLE    |                                  |          |               |
|                    | int countCOFB    |                                  |          |               |

# Extension 2

# User Story 

As a customer,
So I can see what I bought,
I want to get a receipt with all items and their name, quantity and price

# Domain Model

| Class              | Member Variables                           | Methods                | Scenario                                                                  | Output/Result              |
|--------------------|--------------------------------------------|------------------------|---------------------------------------------------------------------------|----------------------------|
| ExtensionExercise2 | Map<Inventory, Integer> inventoryMap       | String returnReceipt() | I want to get a receipt with all items and their name, quantity and price | Return receipt as a String |
|                    | void addItem(Inventory item, int quantity) |                        |                                                                           |                            |
|                    |                                            |                        |                                                                           |                            |


