1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.



| Classes | Methods                                                               | Members | Scenario                  | Output |
|---------|-----------------------------------------------------------------------|---------|---------------------------|--------|
| Order   | add(String SKU, String itemType, String bagelName, double bagelPrice) |         | Item is not already added | true   |
|         |                                                                       |         | Item is already added     | false  |
|         |                                                                       |         |                           |        |


2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.



| Classes | Methods                                                                   | Members | Scenario                             | Output |
|---------|---------------------------------------------------------------------------|---------|--------------------------------------|--------|
| Order   | remove(String SKU, String itemType, String bagelName, double bagelPrice ) |         | Item is in list, and can get removed | true   |
|         |                                                                           |         | Item is not existing in list         | false  |
|         |                                                                           |         |                                      |        |


3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.


| Classes | Methods        | Members      | Scenario         | Output |
|---------|----------------|--------------|------------------|--------|
| Order   | isBasketFull() | int capacity | List is not full | true   |
|         |                |              | List is full     | false  |
|         |                |              |                  |        |


4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.



| Classes | Methods                  | Members      | Scenario                                   | Output          |
|---------|--------------------------|--------------|--------------------------------------------|-----------------|
| Order   | updateBasket(int amount) | int capacity | If correct value is given (above previous) | New Amount      |
|         |                          |              | If wrong value is given                    | Previous Amount |
|         |                          |              |                                            |                 |


5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.


| Classes | Methods                       | Members           | Scenario                                   | Output                         |
|---------|-------------------------------|-------------------|--------------------------------------------|--------------------------------|
| Order   | canItemBeRemoved(String name) | String bagelSku   | If item is in list, it can be removed      | "The item can be removed."     |
|         |                               | String fillingSku | If item is not in list, it cant be removed | "The item is not in the list!" |
|         |                               | String coffeeName |                                            |                                |


6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.


| Classes | Methods      | Members             | Scenario                               | Output    |
|---------|--------------|---------------------|----------------------------------------|-----------|
| Order   | totalCost()  | double bagelPrice   | If item is in list, it adds to the sum | sum       |
|         |              | double coffeePrice  | If item is not in list                 | return 0; |
|         |              | double fillingPrice |                                        |           |



7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.


| Classes | Methods                   | Members           | Scenario               | Output     |
|---------|---------------------------|-------------------|------------------------|------------|
| Order   | getCost(String bagelName) | double bagelPrice | If item is in list     | bagelPrice |
|         |                           |                   | If item is not in list | 0          |
|         |                           |                   |                        |            |


8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.


| Classes | Methods                                                                              | Members            | Scenario                | Output        |
|---------|--------------------------------------------------------------------------------------|--------------------|-------------------------|---------------|
| Order   | chooseFilling(String SKU, String itemType, String fillingName, double fillingPrice ) | String fillingName | If item is in list      | return true;  |
|         |                                                                                      |                    | If item is not in list  | return false; |
|         |                                                                                      |                    |                         |               |


9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.


| Classes | Methods                         | Members             | Scenario                | Output              |
|---------|---------------------------------|---------------------|-------------------------|---------------------|
| Order   | getFillingCost(String fillName) | double fillingPrice | If item is in list      | return fillingPrice |
|         |                                 |                     | If item is not in list  | return 0            |
|         |                                 |                     |                         |                     |


10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
 
Do checks and set up an inventory!

#EXTENSION 2

11. To keep a record of what I have bought, 
Receipts would be efficient. I would like to see a total cost, the amount of each individual item, their names and cost price.
I would also like the time of the purchase, so that I can trace the transaction, if needed.

| Classes | Methods   | Members     | Scenario                      | Output               |
|---------|-----------|-------------|-------------------------------|----------------------|
| Order   | receipt() | String time | If items are added beforehand | return receipt       |
|         |           | int amount  | If no items are added         | return empty receipt |
|         |           |             |                               |                      |

#EXTENSION 1

12. As a customer, i would like some sort of discount when buying multiple items from Bob's Bagels. This could mean meal deals.. or any kind of
discount where i would get rewarded for adding multiple things in my basket.
#### Example orders
```
2x BGLO  = 0.98
12x BGLP = 3.99
6x BGLE  = 2.49
3x COF   = 2.97
           ----
          10.43
```

```
16x BGLP = 5.55
           ----
           5.55
```
| SKU  | Name   | Variant    | Price | Special offers          |
|------|--------|------------|-------|-------------------------|
| BGLO | Bagel  | Onion      | .49   | 6 for 2.49              |
| BGLP | Bagel  | Plain      | .39   | 12 for 3.99             |
| BGLE | Bagel  | Everything | .49   | 6 for 2.49              |
| COFB | Coffee | Black      | .99   | Coffee & Bagel for 1.25 |

Every Bagel is available for the `6 for 2.49` and `12 for 3.99` offer, but fillings still cost the extra amount per bagel.

| Classes | Methods     | Members    | Scenario                            | Output                       |
|---------|-------------|------------|-------------------------------------|------------------------------|
| Order   | discount()  |            | If items meet discount requirements | return receipt with discount |
|         | totalCost() | int amount | If items do not meet discount req.  | return regular receipt       |
|         |             |            |                                     |                              |

