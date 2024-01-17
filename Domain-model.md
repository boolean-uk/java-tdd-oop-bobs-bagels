## Domain model for Bobs Bagels

```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```
Basket class

| Methods                     | Member variables    | Scenario                          | Output/result       |
|-----------------------------|---------------------|-----------------------------------|---------------------|
| addToBasket(String product) | String[] basketArr  | User adds product into the basket | return confirmation |
|                             |                     |                                   |                     |
|                             |                     |                                   |                     |
|                             |                     |                                   |                     |

```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```
Basket class

| Methods                          | Member variables   | Scenario                               | Output/result       |
|----------------------------------|--------------------|----------------------------------------|---------------------|
| removeFromBasket(String product) | String[] basketArr | User removes a product from the basket | return confirmation |
|                                  |                    |                                        |                     |
|                                  |                    |                                        |                     |
|                                  |                    |                                        |                     |

```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an
item beyond my basket capacity.
```
Basket class

| Methods                     | Member variables    | Scenario                         | Output/result |
|-----------------------------|---------------------|----------------------------------|---------------|
| addToBasket(String product) | String[] basketArr  | User adds bagels into the basket |               |
|                             |                     | if the basket is not full:       | return true   |
|                             |                     | if the basket is full            | return false  |
|                             |                     |                                  |               |

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```
Basket class

| Methods                           | Member variables              | Scenario                                | Output/result       |
|-----------------------------------|-------------------------------|-----------------------------------------|---------------------|
| changeBasketCapacity(int newSize) | String bagelName              | Make a new basket with the              |                     |
|                                   | double price                  | new size, copy from the old basket into |                     |
|                                   | HashMap<String,double> bagels | the new in a for loop                   | return confirmation |
|                                   | String[] basketArr            |                                         |                     |

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```
Basket class

| Methods                        | Member variables    | Scenario                                     | Output/result |
|--------------------------------|---------------------|----------------------------------------------|---------------|
| removeFromBasket(String bagel) | String[] basketArr  | User tries to remove a bagel from the basket |               |
|                                |                     | if the basket does not contain it:           | return false  |
|                                |                     | if the basket does contain the product:      | return basket |
|                                |                     |                                              |               |

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```
Inventory class

| Method     | Member variables | Scenario                        | Output/retun |
|------------|------------------|---------------------------------|--------------|
| getPrice() | String SKU       | use the get method to retrieve  | return price |
|            | double price     | the price for the given product |              |
|            | String name      |                                 |              |
|            | String variant   |                                 |              |
Basket class

| Methods          | Member variables    | Scenario                              | Output/result    |
|------------------|---------------------|---------------------------------------|------------------|
| checkTotalCost() | String[] basketArr  | check the price for each item         | return totalCost |
|                  |                     | in the basket and add it to totalCost |                  |

```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```
Basket class

| Methods      | Member variables    | Scenario                                        | Output/result |
|--------------|---------------------|-------------------------------------------------|---------------|
| createMenu() | String[] basketArr  | The user gets information about prices          | return menu   |
|              |                     | before they choose the product. Using a menu-   |               |
|              |                     | string that shows every product and their price |               |

```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```
Basket class

| Methods                     | Member variables    | Scenario                         | Output/result       |
|-----------------------------|---------------------|----------------------------------|---------------------|
| addToBasket(String product) | String[] basketArr  | If the product added is a bagel: | return confirmation |
|                             |                     | ask the user if they want to add |                     |
|                             |                     | filling to it                    |                     |

```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```
Basket class

| Methods      | Member variables    | Scenario                                        | Output/result |
|--------------|---------------------|-------------------------------------------------|---------------|
| createMenu() | String[] basketArr  | The user gets information about prices          | return menu   |
|              |                     | before they choose the product. Using a menu-   |               |
|              |                     | string that shows every product and their price |               |

```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```
Basket class

| Methods                     | Member variables    | Scenario                          | Output/result       |
|-----------------------------|---------------------|-----------------------------------|---------------------|
| addToBasket(String product) | String[] basketArr  | Before the method runs, it checks | return confirmation |
|                             |                     | if the input is valid             |                     |
|                             |                     |                                   |                     |
