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
    * [Abstract Item Class](#abstract-item-class)
    * [Class Bagel - Implements Item](#class-bagel---implements-item)
    * [Class Filling - Implements Item](#class-filling---implements-item)
    * [Class Coffee - Implements Item](#class-coffee---implements-item)
    * [Class Order](#class-order-)
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
| Variables                                       | Description                                                          |
|-------------------------------------------------|----------------------------------------------------------------------|
| ``HashMap<Item item, Integer quantity> basket`` | Contains all the items in the user's basket.                         | 
| ``Integer basketSize``                          | Contains the size of the basket.                                     |

| Methods                                    | Scenario                                                   | Outputs                                                          |
|--------------------------------------------|------------------------------------------------------------|------------------------------------------------------------------|
| `String addItemToBasket(Item item)`        | Customer adds item to basket with available space          | Return ``Item <insert item> added to basket.``                   |
|                                            | Customer attempts to add item to full basket               | Return ``Basket is full, <insert item> is not added to basket.`` |
| `String removeItemFromBasket(Item item)`   | Customer removes item in basket from basket                | Return ``<Insert item> removed from basket.``                    |
|                                            | Customer attempts to remove item not in basket from basket | Return ``<Insert item> does not exist in basket.``               |
| `Double calculateBasketCost()`             | If basket is empty                                         | Return 0                                                         | 
|                                            | If basket is not empty                                     | Return sum                                                       |
| `Boolean basketIsFull()`                   | Basket is full                                             | Return true                                                      |
|                                            | Basket is not full                                         | Return false                                                     |
| `Boolean itemInBasket()`                   | Item is in basket                                          | Return true                                                      |
|                                            | Item is not in basket                                      | Return false                                                     |
| `String changeBasketSize(Integer newSize)` | Manager changes to a new size, where newSize > -1          | Returns ``Basket size successfully changed.``                    |
|                                            | Manager attempts to change size to a negative number       | Returns ``Basket size cannot be negative.``                      |

### Abstract Item Class
| Variables                | Description                          |
|--------------------------|--------------------------------------|
| ``List<Item item> menu`` | Contains all available items on menu | 
| ``String sku``           | Contains item ID                     |
| ``Double price``         | Contains item price                  |
| ``String name``          | Contains item name                   |
| ``String variant``       | Contains item variant                |



| Methods               | Scenario                                         | Outputs             |
|-----------------------|--------------------------------------------------|---------------------|
| `Double getPrice()`   | Customer wants to find price of item             | Return item.price   |
| `String getVariant()` | Customer wants to see list of available variants | Return item.variant |

### Class Bagel - Implements Item
| Variables                              | Description                                              |
|----------------------------------------|----------------------------------------------------------|
| ``List<Filling filling> fillings``     | Contains all the fillings for the bagel                  | 
| ``Double totalPriceIncludingFillings`` | Contains the total price of the bagel including fillings |


| Methods                               | Scenario                                           | Outputs                                  |
|---------------------------------------|----------------------------------------------------|------------------------------------------|
| `String addFilling(filling: Filling)` | Customer adds filling to bagel                     | Return "<Insert filling> added to bagel" |
| `List<Filling> getFillings()`         | Customer wants to see the list of current fillings | Return list of fillings                  |

### Class Filling - Implements Item

### Class Coffee - Implements Item

### Class Order 
| Variables                              | Description                                              |
|----------------------------------------|----------------------------------------------------------|
| ``Basket basket``                      | Contains the basket for the current order                | 


| Methods                          | Scenario                                           | Outputs                                             |
|----------------------------------|----------------------------------------------------|-----------------------------------------------------|
| `String order()`                 | User wants to place an order.                      | Returns "Order placed", when order has been placed. |
