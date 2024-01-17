1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.



| Classes   | Methods                     | Members              | Scenario                  | Output |
|-----------|-----------------------------|----------------------|---------------------------|--------|
| Order     | add(String name, int price) | HashMap<Name, Price> | Item is not already added | true   |
| Inventory |                             |                      | Item is already added     | false  |
|           |                             |                      |                           |        |


2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.



| Classes   | Methods             | Members               | Scenario                             | Output |
|-----------|---------------------|-----------------------|--------------------------------------|--------|
| Order     | remove(String name) | HashMap<Name, Price>  | Item is in list, and can get removed | true   |
| Inventory |                     |                       | Item is not existing in list         | false  |
|           |                     |                       |                                      |        |


3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.


| Classes   | Methods        | Members               | Scenario         | Output |
|-----------|----------------|-----------------------|------------------|--------|
| Order     | isBasketFull() | HashMap<Name, Price>  | List is not full | true   |
| Inventory |                |                       | List is full     | false  |
|           |                |                       |                  |        |


4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.



| Classes   | Methods                  | Members               | Scenario                                   | Output          |
|-----------|--------------------------|-----------------------|--------------------------------------------|-----------------|
| Order     | updateBasket(int amount) | HashMap<Name, Price>  | If correct value is given (above previous) | New Amount      |
| Inventory |                          |                       | If wrong value is given                    | Previous Amount |
|           |                          |                       |                                            |                 |


5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.


| Classes   | Methods                       | Members               | Scenario                                   | Output                         |
|-----------|-------------------------------|-----------------------|--------------------------------------------|--------------------------------|
| Order     | canItemBeRemoved(String name) | HashMap<Name, Price>  | If item is in list, it can be removed      | "The item can be removed."     |
| Inventory |                               |                       | If item is not in list, it cant be removed | "The item is not in the list!" |
|           |                               |                       |                                            |                                |


6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.


| Classes   | Methods      | Members               | Scenario                               | Output    |
|-----------|--------------|-----------------------|----------------------------------------|-----------|
| Order     | totalCost()  | HashMap<Name, Price>  | If item is in list, it adds to the sum | sum       |
| Inventory |              | HashMap<Name, Price>  | If item is not in list                 | return 0; |
|           |              |                       |                                        |           |



7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.


| Classes   | Methods                   | Members        | Scenario               | Output     |
|-----------|---------------------------|----------------|------------------------|------------|
| Order     | getCost(String bagelName) | int bagelPrice | If item is in list     | bagelPrice |
| Inventory |                           |                | If item is not in list | 0          |
|           |                           |                |                        |            |


8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.


| Classes   | Methods                           | Members               | Scenario                | Output        |
|-----------|-----------------------------------|-----------------------|-------------------------|---------------|
| Order     | chooseFilling(String fillingName) | HashMap<Name, Price>  | If item is in list      | return true;  |
| Inventory |                                   |                       | If item is not in list  | return false; |
|           |                                   |                       |                         |               |


9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.


| Classes   | Methods                            | Members               | Scenario                | Output              |
|-----------|------------------------------------|-----------------------|-------------------------|---------------------|
| Order     | getFillingCost(String fillingName) | HashMap<Name, Price>  | If item is in list      | return fillingPrice |
| Inventory |                                    |                       | If item is not in list  | return 0            |
|           |                                    |                       |                         |                     |


10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
 
Do checks and set up an inventory!


