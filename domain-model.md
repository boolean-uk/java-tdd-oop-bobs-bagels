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

| User Story                                                                         | Class     | Method                                                                 | Return     | Note                              |
|------------------------------------------------------------------------------------|-----------|------------------------------------------------------------------------|------------|-----------------------------------|
| I'd like to add a specific type of bagel to my basket                              | `Basket`  | `addProduct(Product product) throws FullBasketException`               | `void`     |                                   |
| I'd like to remove a bagel from my basket                                          | `Basket`  | `removeProduct(BagelType variant) throws NonExistingProductException`  | `void`     | Covers both user story 2 and 5.   |
| I'd like to know when my basket is full                                            | `Basket`  | `isFull()`                                                             | `Boolean`  | Returns true if full, else false. |
| I'd like to change the capacity of baskets                                         | `Basket`  | `changeCapacity()`                                                     | `void`     |                                   |
| I'd like to know the total cost of items in my basket.                             | `Order`   | `getTotalCost()`                                                       | `Integer`  | Converts the value to an integer. |
| I'd like to know the cost of a bagel before I add it to my basket.                 | `Product` | `getPrice()`                                                           | `Double`   |                                   |







