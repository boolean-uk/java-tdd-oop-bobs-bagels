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


## User Story 4
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.

# Domain Model For User Story 4

Version 1

| Class  | Member variables        | Methods                                                | Scenario                          | Output/Result                            |
|--------|-------------------------|--------------------------------------------------------|-----------------------------------|------------------------------------------|
| Basket | ArrayList<Bagel> bagels | changeBasketCapacity(int oldDapacity, int newCapacity) | If basket capacity is changed     | Return "Basket capacity change!"         |
|        |                         |                                                        | if basket capacity is not changed | Return "Basket is capacity is the same." |


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

| Class  | Member variables        | Methods                            | Scenario                      | Output/Result                                       |
|--------|-------------------------|------------------------------------|-------------------------------|-----------------------------------------------------|
| Basket | ArrayList<Bagel> bagels | canRemoveItemInBasket(String item) | Item exist in basket          | Return "Item is in basket and can be removed"       |
|        |                         |                                    | Item does not exist in basket | Return "Item is not in basket and can't be removed" |

## User Story 6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.

# Domain Model For User Story 6


| Class  | Member variables                              | Methods                                                     | Scenario           | Output/Result    |
|--------|-----------------------------------------------|-------------------------------------------------------------|--------------------|------------------|
| Basket | HashMap<String, Integer[]> itemsWithQuantity; | int totalCost(HashMap<String, Integer> item, int totalCost) | if all items added | Return totalCost |
|        |                                               |                                                             | if no items added  | Return 0         |



## User Story 7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.

# Domain Model For User Story 7

| Class     | Member Variables                        | Methods                               | Scenario             | Output/Result        |
|-----------|-----------------------------------------|---------------------------------------|----------------------|----------------------|
| Basket    | HashMap<Bagel, Integer> bagelsWithCost; | double returnCostOfBagel(Bagel bagel) | I want cost of bagel | Return cost of bagel |
| Inventory |                                         |                                       |                      |                      |
| Bagel     |                                         |                                       |                      |                      |


## User Story 8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.

# Domain Model For User Story 8

## User Story 9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.

# Domain Model For User Story 9

## User Story 10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.

# Domain Model For User Story 10