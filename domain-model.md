# Domain model

<!-- TOC -->
* [Domain model](#domain-model)
  * [User stories](#user-stories)
    * [1](#1)
    * [2](#2)
    * [3](#3)
    * [4](#4)
    * [5](#5)
    * [6](#6)
    * [7](#7)
    * [8](#8)
    * [9](#9)
    * [10](#10)
  * [Classes](#classes)
    * [Basket Class](#basket-class)
    * [Menu Class](#menu-class)
    * [Item interface](#item-interface)
    * [Bagel Class - Implements Item](#bagel-class---implements-item)
    * [Filling Class - Implements Item](#filling-class---implements-item)
    * [Coffee class - Implements Item](#coffee-class---implements-item)
    * [Order Class](#order-class)
    * [Receipt Class](#receipt-class)
<!-- TOC -->

## User stories
### 1
``
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
``

### 2
``
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
``

### 3
``
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
``

### 4
``
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
``

### 5
``
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
``

### 6
``
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
``

### 7
``
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
``

### 8
``
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
``

### 9
``
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
``

### 10
``
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
``

## Classes

### Basket Class
| Variables                         | Description                                                           |
|-----------------------------------|-----------------------------------------------------------------------|
| ``HashMap<Item, Integer> basket`` | Contains all the items in the user's basket, as well as the quantity. | 
| ``int maxBasketSize``             | Contains the max size of the basket.                                  |
| ``int discount``                  | The calculated discount based on the content of the basket.           |

| Methods                                                               | Scenario                                                                                                  | Outputs                                               |
|-----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|-------------------------------------------------------|
| `int numberOfItemsInBasket()`                                         | User wants to add an item to a finite basket. Compare size with max.                                      | Returns items in basket                               |
| `String addItemToBasket(Item item)`                                   | Customer adds item to basket with available space                                                         | Return ``<insert item> added to basket.``             |
|                                                                       | Customer attempts to add item to full basket                                                              | Return ``Basket is full.``                            |
|                                                                       | Customer attempts to add item not on the menu to the basket                                               | Return ``This item is not on the menu.``              |
| `String removeItemFromBasket()`                                       | Customer removes item in basket from basket                                                               | Return ``<Insert item> removed from basket.``         |
|                                                                       | Customer attempts to remove item not in basket from basket                                                | Return ``Invalid option.``                            |
| `float calculateBasketCost()`                                         | When the customer wants to pay, calculates the price of the basket                                        | Return sum of items in basket.                        |
| `boolean basketIsFull()`                                              | Basket is full                                                                                            | Return true                                           |
|                                                                       | Basket is not full                                                                                        | Return false                                          |
| `boolean itemInBasket(Item item)`                                     | Item is in basket                                                                                         | Return true                                           |
|                                                                       | Item is not in basket                                                                                     | Return false                                          |
| `void changeBasketSize(int newSize)`                                  | Manager changes to a new size, where newSize > -1                                                         | -                                                     |
| `int numberOfItemsInBasket()`                                         | Customer wants to know the number of items in the basket.                                                 | Return number of items in basket.                     |
| `void formatFillingPrint()`                                           | Fillings are added to the receipt.                                                                        | -                                                     |
| `HashMap<String, Integer> getQuantityOfFillings(Bagel bagel)`         | Each filling is counted for easy representation on receipt.                                               | Returns the hashmap with number of different fillings |
| `void printItemsInBasketWithIndex(Map<Integer, Item> indexedBasket) ` | Indexes the items in the basket to facilitate removal.                                                    | -                                                     |
| `void calculateDiscount()`                                            | Calculates the discount and adds it to the discount variable.                                             | -                                                     |
| `void quantifyItemsInBasket(Map<String, Integer> basketOverview)`     | Quantifies the items in the basket for receipt representation.                                            | -                                                     |
| `void addBagelDiscount(Map<String, Integer> basketOverview)`          | Uses the quantified list from the previous function to add bagel discounts to discount variable.          | -                                                     |
| `void addCoffeeDiscount(Map<String, Integer> basketOverview)`         | Uses the quantified list from the previous function to add bagel + coffee discounts to discount variable. | -                                                     |
| `void printItemsInBasket()`                                           | Prints the items in the basket with associated prices.                                                    | -                                                     |
| `void printFilling(Bagel bagel)`                                      | Prints formatted strings for all the fillings of a bagel.                                                 | -                                                     |


### Menu Class
| Variables                                | Description                           |
|------------------------------------------|---------------------------------------|
| ``ArrayList<Item item> menu``            | Contains available bagels and coffees |
| `ArrayList<Filling filling> fillingMenu` | Contains available fillings           |

| Methods                                             | Scenario                                                 | Outputs               |
|-----------------------------------------------------|----------------------------------------------------------|-----------------------|
| `Void initializeMenu()`                             | Menu is initialized with predefined items.               | -                     |
| `Item getItemFromMenu(String name, String variant)` | Customer gets an item from the menu to put in the basket | Return item           |
| `boolean itemIsOnTheMenu(Item item)`                | The item is on the menu                                  | Return true           |
|                                                     | The item is not on the menu                              | Return false          |
| `boolean itemsAreEqual(Item item1, Item item2)`     | The items are equal                                      | Return true           |
|                                                     | The items are not equal                                  | Return false          |
| `Filling getFillingFromMenu(String name)`           | The filling is on the menu                               | Return Filling        |
|                                                     | The filling is not on the menu                           | Return null           |
| `Item selectItemFromMenu()`                         | Allows the user to select an item from a text UI         | Returns selected item |
| `void printMenu()`                                  | Prints the menu for the user                             | -                     |
| `void printFillingMenu()`                           | Prints the available fillings for the user               | -                     |


### Item interface
| Methods            | Scenario                             | Outputs      |
|--------------------|--------------------------------------|--------------|
| `String getSKU()`  | Returns the SKU of the item          | Return SKU   |
| `String getName()` | Returns the name of the item         | Return name  |
| `float getPrice()` | Customer wants to find price of item | Return price |


### Bagel Class - Implements Item
| Variables                          | Description                             |
|------------------------------------|-----------------------------------------|
| ``List<Filling filling> fillings`` | Contains all the fillings for the bagel | 
| ``String sku``                     | Contains item ID                        |
| ``String name``                    | Contains item name                      |
| ``Double price``                   | Contains item price                     |

| Methods                                  | Scenario                                            | Outputs                                  |
|------------------------------------------|-----------------------------------------------------|------------------------------------------|
| `String getSKU()`                        | Returns the SKU of the item                         | Return SKU                               |
| `String getName()`                       | Returns the name of the item                        | Return name                              |
| `float getPrice()`                       | Customer wants to find price of item                | Return price                             |
| `String addFilling(Filling filling)`     | Customer adds filling to bagel                      | Return "<Insert filling> added to bagel" |
| `void addFillingsToBagel(Scanner input)` | Allows the customer to add fillings using a text UI | -                                        |
| `ArrayList<Filling> getFillings()`       | Customer wants to see the list of current fillings  | Return list of fillings                  |


### Filling Class - Implements Item
| Variables                          | Description                             |
|------------------------------------|-----------------------------------------|
| ``String sku``                     | Contains item ID                        |
| ``String name``                    | Contains item name                      |
| ``Double price``                   | Contains item price                     |

| Methods                                  | Scenario                                            | Outputs                                  |
|------------------------------------------|-----------------------------------------------------|------------------------------------------|
| `String getSKU()`                        | Returns the SKU of the item                         | Return SKU                               |
| `String getName()`                       | Returns the name of the item                        | Return name                              |
| `float getPrice()`                       | Customer wants to find price of item                | Return price                             |


### Coffee class - Implements Item
| Variables                          | Description                             |
|------------------------------------|-----------------------------------------|
| ``String sku``                     | Contains item ID                        |
| ``String name``                    | Contains item name                      |
| ``Double price``                   | Contains item price                     |

| Methods                                  | Scenario                                            | Outputs                                  |
|------------------------------------------|-----------------------------------------------------|------------------------------------------|
| `String getSKU()`                        | Returns the SKU of the item                         | Return SKU                               |
| `String getName()`                       | Returns the name of the item                        | Return name                              |
| `float getPrice()`                       | Customer wants to find price of item                | Return price                             |


### Order Class
| Variables                              | Description                                              |
|----------------------------------------|----------------------------------------------------------|
| ``Basket basket``                      | Contains the basket for the current order                |


| Methods                                | Scenario                                                                       | Outputs                               |
|----------------------------------------|--------------------------------------------------------------------------------|---------------------------------------|
| `void order()`                         | Driver function for the order process.                                         | -                                     |
| `int customerOrManager(Scanner input)` | Allows the user to choose between user role and manager role through a text UI | Returns an int based on the selection |
| `void customerMenu(Scanner input)`     | Driver function for the order placing of the user.                             | -                                     |
| `void managerMenu(Scanner input)`      | Driver function for manager options.                                           | -                                     |


### Receipt Class
| Variables                        | Description                                        |
|----------------------------------|----------------------------------------------------|
| ``Basket basket``                | Contains the basket related to the current receipt |
| `ArrayList<String> receiptLines` | Contains the lines of the receipt                  |


| Methods                            | Scenario                                                                               | Outputs |
|------------------------------------|----------------------------------------------------------------------------------------|---------|
| `void printReceipt()`              | Prints the receipt.                                                                    | -       |
| `void createReceipt()`             | Adds lines to receiptLines based on the contents of the basket.                        | -       |
| `addFillingToReceipt(Bagel bagel)` | Adds formatted lines for fillings to receiptLines based on the contents of the basket. | -       |

Thank you.