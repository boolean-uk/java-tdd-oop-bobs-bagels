# Bob's Bagels

## User Stories
```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```
```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```
```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```
```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```
```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```
```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```
```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```
```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```
```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```
```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```

### Item Class

| Methods   | Member Variables |
|-----------|------------------|
| getName() | String name      |
| getSKU()  | String sKU       |

### Bagel Class (subclass to Item)

| Methods | Member Variables  |
|---------|-------------------|
|         | String filling    |

### Filling Class (subclass to Item)

| Methods | Member Variables |
|---------|------------------|
|         |                  |

### Coffee Class (subclass to Item)

| Methods | Member Variables |
|---------|------------------|
|         |                  |


### Inventory Class
(everything that can be ordered)

| Methods                         | Member Variables                 |
|---------------------------------|----------------------------------|
| isInInventory(String name)      | HashMap<String, double> bagels   |
| changeCapacity(int newCapacity) | HashMap<String, double> coffees  |
|                                 | HashMap<String, double> fillings |
|                                 | int capacity;                    |   

### SKUConverter Class

| Methods             | Member Variables                  |
|---------------------|-----------------------------------|
| getSKU(String name) | HashMap<String, String> nameToSKU |

### Basket Class

| Methods                                       | Member Variables        |
|-----------------------------------------------|-------------------------|
| addItem(Item item)                            | ArrayList\<Item> basket |
| removeItem(Item item)                         | int bagelsInBasket      |
| showTotalCostInBasket()                       | int coffeesInBasket     |
| addBagelFilling(Bagel bagel, Filling filling) | int fillingsInBasket    |
| showCostOfBagel(String name)                  |                         |
| showCostOfFillings()                          |                         |

| Scenario                                                          | Return Value/Output/Result                                                 |
|-------------------------------------------------------------------|----------------------------------------------------------------------------|
| Customer adds new bagel to empty basket                           | Returns true and adds bagel to the basket list.                            |
| Customer adds new bagel. Basket contains 5 bagels. Capacity is 5. | Returns false and outputs "Basket is full".                                |
| Customer removes bagel from basket. Bagel exists in the basket.   | Returns true and bagel is removed from the basket list.                    |
| Customer removes bagel from basket. Basket contains 0 bagels.     | Returns false.                                                             |
| Customer tries to remove a bagel that is not in the basket.       | Returns false and outputs "That bagel is not in the basket".               |
| Manager wants to change capacity to 10 from 5.                    | Returns basket size as int (10). Size of the basket list is changed to 10. |
| Manager wants to change capacity to 4 from 5.                     | Returns basket size as int (4). Size of the basket list is changed to 4.   |
| Customer wants to see the cost of items in basket.                | Returns the price of all the items in the basket.                          |
| Customer wants to see the price of a specific bagel (exists)      | Returns the price of the specified bagel.                                  |
| ------------------------II------------------(does not exist)      | Returns -1 and "This item does not exist at our store!".                   |
| Customer wants to choose filling for a bagel (bagel exists)       | Adds filling to the specified bagel.                                       |
| ------------------------II------------------(does not exist)      | Creates a new bagel with the requested bagel and adds it to basket.        |
| Customer wants to know the price for each filling.                | Returns the price for each filling.                                        |
| Customer tries to order an item that is not in inventory.         | Returns "This item does not exist at our store!".                          |



