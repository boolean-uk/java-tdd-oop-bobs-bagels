# Domain Model - Bob's Bagels - OOP

---------------------------------------------------------------------------------

## Overview of the classes

| Class     | Members    | Types                |
|-----------|------------|----------------------|
| `Order`   | `basket`   | `Basket`             |
|           | `total`    | `Integer`            |
| `Basket`  | `bagels`   | `ArrayList<Product>` |
|           | `capacity` | `Integer`            |
| `Product` | `sku`      | `SKU`                |
|           | `name`     | `String`             |
|           | `price`    | `Double`             |
|           | `variant`  | `MenuCategory`       |

These are the classes that will inherit from the **Product** class.

| Extends Product |
|-----------------|
| `Bagel`         |
| `Coffee`        |
| `Filling`       |

**Note:** 'BagelType', 'CoffeeType' and 'FillingType' is their own enum classes that
implements the 'MenuCategory' interface. See the class diagram for more details.

### Factory class
There is also a **ProductFactory** class that is responsible for instantiation of the extended products.

| Class            | Method                             | Returns   |
|------------------|------------------------------------|-----------|
| `ProductFactory` | `getProduct(MenuCategory variant)` | `Product` |


-------------------------------------------------------------------------------

## Solution to the user stories

| User Story                                                              | Class     | Method                                                                | Note                              |
|-------------------------------------------------------------------------|-----------|-----------------------------------------------------------------------|-----------------------------------|
| I'd like to add a specific<br/> type of bagel to my basket              | `Basket`  | `addProduct(Product product)`                                         |                                   |
| I'd like to remove a bagel<br/> from my basket                          | `Basket`  | `removeProduct(BagelType variant)`                                    | Covers user story 2 and 5.        |
| I'd like to know when my<br/> basket is full                            | `Basket`  | `isFull()`                                                            | Returns true if full, else false. |
| I'd like to change the <br/>capacity of baskets                         | `Basket`  | `changeCapacity()`                                                    |                                   |
| I'd like to know the total<br/> cost of items in my basket.             | `Order`   | `getTotalCost()`                                                      | Returns a double value.           |
| I'd like to know the cost of <br/>a bagel before I add it to my basket. | `Product` | `getPrice()`                                                          | Returns a double value.           |
| I'd like to be able to choose <br/>fillings for my bagel                | `Bagel`   | `createBagelWithFilling(BagelType variant, FillingType... fillings)`  | Returns a Bagel object.           |








