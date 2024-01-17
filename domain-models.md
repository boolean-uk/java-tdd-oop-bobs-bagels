
## User Stories

```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```


A little bit unsure how to domain model extended classes:
Also unsure if i should add getters and setters to domain model.
I have done it until now, but i think i will stop going forward. (Just tell me if i should have it)

Class Item Extended by Bagel, Filling, Coffee


| Class Variables              | Methods           | Scenario | Output/Return |
|------------------------------|-------------------|----------|---------------|
| String name                  | get/setName()     |          |               |
| Map<String, double> variants | get/setSkuCodes() |          |               |
| ArrayList<String skuCodes    | get/setVariant()  |          |               |
| double price                 | get/setPrice()    |          |               |


Class Person extended by Manager, Customer


| Class Variables     | Methods            | Scenario | Output/Return |
|---------------------|--------------------|----------|---------------|
| String name         | get/setName()      |          |               |
| String accessRights | get/AccessRights() |          |               |
|                     |                    |          |               |
|                     |                    |          |               |


## 1

Class Basket

| Class Variables           | Methods                           | Scenario             | Output/Return                              |
|---------------------------|-----------------------------------|----------------------|--------------------------------------------|
| ArrayList<Item> itemList  | String addItemToBasket(Item item) | Adds item to basket  | Comment on what went wrong or if it worked |
|                           | ArrayList<Item> getItemList()     | Gets a list of Items | ArrayList<Item> basketOfItems              |
|                           |                                   |                      |                                            |
|                           |                                   |                      |                                            |




```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

| Class Variables          | Methods                                | Scenario                 | Output/Return                               |
|--------------------------|----------------------------------------|--------------------------|---------------------------------------------|
| ArrayList<Item> itemList | String removeItemFromBasket(Item item) | Removes item from basket | Comment on what went wrong or if it worked  |
|                          |                                        |                          |                                             |
|                          |                                        |                          |                                             |
|                          |                                        |                          |                                             |




```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

```


Class Basket

| Class Variables          | Methods                           | Scenario                                              | Output/Return                                 |
|--------------------------|-----------------------------------|-------------------------------------------------------|-----------------------------------------------|
| ArrayList<Item> itemList | String addItemToBasket(Item item) | Comments on what went wrong whn adding above capacity | Comment on what went wrong or if it worked    |
| int capacity             |                                   |                                                       |                                               |
|                          |                                   |                                                       |                                               |
|                          |                                   |                                                       |                                               |



```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

Class Basket

| Class Variables          | Methods                           | Scenario                                              | Output/Return                              |
|--------------------------|-----------------------------------|-------------------------------------------------------|--------------------------------------------|
| ArrayList<Item> itemList | String addItemToBasket(Item item) | Comments on what went wrong whn adding above capacity | Comment on what went wrong or if it worked |
| int capacity             | int getBasketCapacity()           | Gets basket capacity                                  | int                                        |
|                          | setBasketCapacity(int capacity)   | Sets basket capacity                                  | boolean                                    |
|                          |                                   |                                                       |                                            |



```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

Class basket

| Class Variables          | Methods                                | Scenario                 | Output/Return                               |
|--------------------------|----------------------------------------|--------------------------|---------------------------------------------|
| ArrayList<Item> itemList | String removeItemFromBasket(Item item) | Removes item from basket | Comment on what went wrong or if it worked  |
|                          |                                        |                          |                                             |
|                          |                                        |                          |                                             |
|                          |                                        |                          |                                             |



```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

Class Customer


| Class Variables | Methods                                | Scenario                            | Output/Return |
|-----------------|----------------------------------------|-------------------------------------|---------------|
|                 | getTotalCost(ArrayList<Item> itemList) | Calculates total price of item list | double        |
|                 | getCostOfItem(Item item)               | Gets price of single item           | double        |
|                 |                                        |                                     |               |
|                 |                                        |                                     |               |


Class Item

| Class Variables | Methods                | Scenario                  | Output/Return |
|-----------------|------------------------|---------------------------|---------------|
| double price    |                        |                           |               |
|                 | double getPrice()      | Gets price of single item | int           |
|                 | setPrice(double price) | Sets price of item        | void          |
|                 |                        |                           |               |





```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```


| Class Variables | Methods                             | Scenario                 | Output/Return |
|-----------------|-------------------------------------|--------------------------|---------------|
|                 | getTotalCost(ArrayList<Item> items) | Gets total cost of Items | double        |
|                 | getCostOfItem(Item item)            | Gets cost of single item | double        |
|                 |                                     |                          |               |
|                 |                                     |                          |               |




```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

Class Bagel extends Item

| Class Variables             | Methods           | Scenario               | Output/Return                |
|-----------------------------|-------------------|------------------------|------------------------------|
| ArrayList<Filling> fillings | get/setFillings() | Sets and gets fillings | ArrayList<Filling> fillings  |
|                             |                   |                        |                              |
|                             |                   |                        |                              |
|                             |                   |                        |                              |


Class Filling extends item



```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

| Class Variables | Methods | Scenario | Output/Return |
|-----------------|---------|----------|---------------|
|                 |         |          |               |
|                 |         |          |               |
|                 |         |          |               |
|                 |         |          |               |




```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```


| Class Variables | Methods | Scenario | Output/Return |
|-----------------|---------|----------|---------------|
|                 |         |          |               |
|                 |         |          |               |
|                 |         |          |               |
|                 |         |          |               |


