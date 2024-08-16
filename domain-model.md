# Domain model

<!-- TOC -->
* [Domain model](#domain-model)
    * [User stories](#user-stories)
        * [User story 1](#user-story-1)
        * [User story 2](#user-story-2)
    * [Classes](#classes)
        * [Product Class](#product-class)
        * [Shopping Basket Class](#shopping-basket-class)
<!-- TOC -->

## User stories
### User story 1
```
As a supermarket shopper,
So that I can pay for products at checkout,
I'd like to be able to know the total cost of items in my basket.
```

### User story 2
```
As an organised individual,
So that I can evaluate my shopping habits,
I'd like to see an itemised receipt that includes the name and price of the products
I bought as well as the quantity, and a total cost of my basket.
```

## Classes

### Basket Class
| Variables                                 | Description                                                          |
|-------------------------------------------|----------------------------------------------------------------------|
| ``List<Item item, Integer quantity> basket`` | Contains all the items in the user's basket.                         | 
| ``Integer basketSize``                        | Contains the size of the basket.                                     |

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
