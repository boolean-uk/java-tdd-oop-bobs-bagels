# Bob's Bagels - Object-oriented Programming

## Core exercise

```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```
| Class  | Methods                        | Member variables     | Scenario | Outputs/Results     |
|--------|--------------------------------|----------------------|----------|---------------------|
| Basket | boolean addBagel(String bagel) | ArrayList bagelsList |          | Add bagel to basket |
|        |                                | String bagel         |          |                     |


```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```
| Class   | Methods                           | Member variables     | Scenario           | Outputs/Results        |
|---------|-----------------------------------|----------------------|--------------------|------------------------|
| Basket  | boolean removeBagel(String bagel) | ArrayList bagelsList | Bagel is in basket | Remove bagel to basket |
|         |                                   | String bagel         |                    |                        |
|         |                                   |                      |                    |                        |

```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```
| Class   | Methods                        | Member variables   | Scenario           | Outputs/Results    |
|---------|--------------------------------|--------------------|--------------------|--------------------|
| Basket  | boolean addBagel(String bagel) | int basketCapacity | If basket is full  | Print message      |
|         |                                | String bagel       | If basket not full | Continue as normal |
|         |                                |                    |                    |                    |

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```
| Class   | Methods                              | Member variables   | Scenario                        | Outputs/Results                      |
|---------|--------------------------------------|--------------------|---------------------------------|--------------------------------------|
| Basket  | int changeBasketCapacity(int change) | int basketCapacity | Increase basket capacity by two | basketCapacity += 2                  |
|         |                                      |                    | Decrease basket capacity by one | basketCapacity--                     |
|         |                                      |                    | Try to change capacity to <0    | return basketCapacity, Print message |

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```
| Class   | Methods                      | Member variables   | Scenario             | Outputs/Results                  |
|---------|------------------------------|--------------------|----------------------|----------------------------------|
| Basket  | void removeItem(String item) | ArrayList itemList | If item exist        | Remove item to from, return true |
|         |                              |                    | If item do not exist | Print message, return false      |
|         |                              |                    |                      |                                  |

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```
| Class     | Methods            | Member variables           | Scenario              | Outputs/Results    |
|-----------|--------------------|----------------------------|-----------------------|--------------------|
| Basket    | double totalCost() | ArrayList<String> itemList | totalCost() with      | return item1+item2 |
| Inventory | boolean addItem()  |                            | two items in itemList |                    |
|           |                    |                            | totalCost() with      | return item1+item2 |
|           |                    |                            | five of the same item | return item*5      |


```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```
| Class     | Methods          | Member variables                             | Scenario         | Outputs/Results |
|-----------|------------------|----------------------------------------------|------------------|-----------------|
| Inventory | void printMenu() | inventoryPriceList: HashMap<String, Integer> | Start of program | Print the menu  |
|           |                  |                                              | or a new order   | for the user    |
|           |                  |                                              |                  |                 |


```
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```
| Class     | Methods                             | Member variables    | Scenario | Outputs/Results       |
|-----------|-------------------------------------|---------------------|----------|-----------------------|
| Inventory | boolean addFillings(String filling) | Arraylist fillings  |          | Add filling to basket |
|           |                                     |                     |          |                       |
|           |                                     |                     |          |                       |


```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```
| Class     | Methods          | Member variables | Scenario         | Outputs/Results |
|-----------|------------------|------------------|------------------|-----------------|
| Inventory | void printMenu() |                  | Start of program | Print the menu  |
|           |                  |                  | or a new order   | for the user    |
|           |                  |                  |                  |                 |


```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```
| Class     | Methods                      | Member variables            | Scenario             | Outputs/Results    |
|-----------|------------------------------|-----------------------------|----------------------|--------------------|
| Basket    | boolean addItem(String item) | ArrayList<String> itemsList | if item is in stock  | Add item and       |
| Inventory |                              | ArrayList<String> stockList |                      | return true        |
| Order     |                              |                             | if item not in stock | Don't add item and |
|           |                              |                             |                      | return false       |



## Extension 1

```
As a customer,
So I can get a good deal,
I want discounts when I choose certain item combinations.
```
| Class | Methods               | Member variables | Scenario            | Outputs/Results   |
|-------|-----------------------|------------------|---------------------|-------------------|
| Order | double getDiscount()  | double discount  | 6 of the same bagel | subtract discount |
|       | double getTotalCost() | double totalCost |                     | from totalCost    |
|       |                       |                  |                     |                   |



## Extension 2

```
As a customer,
So I can see if my order is correct,
I want a receipt with all my items and prices.
```
| Class  | Methods                  | Member variables            | Scenario    | Outputs/Results |
|--------|--------------------------|-----------------------------|-------------|-----------------|
| Order  | String generateReceipt() | ArrayList<String> itemList  | If no items | Print receipt   |
|        |                          |                             | is added    | without items   |
|        |                          |                             | If items    | Print receipt   |
|        |                          |                             | is added    | with all items  |
