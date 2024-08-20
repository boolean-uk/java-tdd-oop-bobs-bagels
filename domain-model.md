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


These are the classes that will inherit from the **Product** class.

| Inherits from Product | Members   | Types         |
|-----------------------|-----------|---------------|
| `Bagel`               | `variant` | `BagelType`   |
| `Coffee`              | `type`    | `CoffeeType`  |
| `Filling`             | `type`    | `FillingType` |

**Note:** 'BagelType', 'CoffeeType' and 'FillingType' is their own enum classes. 
Look at the class diagram to see their fields.

-------------------------------------------------------------------------------

## Solution to the user stories

| User Story                                                                         | Class     | Method                                                              | Return     | Note                              |
|------------------------------------------------------------------------------------|-----------|---------------------------------------------------------------------|------------|-----------------------------------|
| I'd like to add a specific type of bagel to my basket                              | `Basket`  | `addProduct(Product product) throws FullBasketException`            | `void`     |                                   |
| I'd like to remove a bagel from my basket                                          | `Basket`  | `removeProduct(BagelType variant)`                                  | `void`     |                                   |
| I'd like to know when my basket is full                                            | `Basket`  | `isFull()`                                                          | `Boolean`  | Returns true if full, else false. |
| I'd like to change the capacity of baskets                                         | `Basket`  | `changeCapacity()`                                                  | `void`     |                                   |
| I'd like to know if I try to remove an <br/>item that doesn`t exists in my basket. | `Basket`  | `removeProduct(Product product) throws NonExistingProductException` | `void`     |                                   |
| I'd like to know the total cost of items in my basket.                             | `Order`   | `getTotalCost()`                                                    | `Integer`  | Converts the value to an integer. |
| I'd like to know the cost of a bagel before I add it to my basket.                 | `Product` | `getPrice()`                                                        | `Double`   |                                   |







