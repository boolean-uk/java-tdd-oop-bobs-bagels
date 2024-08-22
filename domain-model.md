# Domain Model - Bob's Bagels - OOP

---------------------------------------------------------------------------------

## Overview of the classes

| Class     | Members       | Types                |
|-----------|---------------|----------------------|
| `Order`   | `basket`      | `Basket`             |
|           | `total`       | `Integer`            |
| `Basket`  | `bagels`      | `ArrayList<Product>` |
|           | `capacity`    | `Integer`            |
| `Product` | `sku`         | `SKU`                |
|           | `name`        | `String`             |
|           | `price`       | `Double`             |
|           | `variant`     | `MenuCategory`       |
|           | `hasDiscount` | `Boolean`            |

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

| User Story                                                                            | Class     | Method                                                               | Note                                                 |
|---------------------------------------------------------------------------------------|-----------|----------------------------------------------------------------------|------------------------------------------------------|
| I'd like to add a specific<br/> type of bagel to my basket                            | `Basket`  | `addProduct(Product product)`                                        |                                                      |
| I'd like to remove a bagel<br/> from my basket                                        | `Basket`  | `removeProduct(BagelType variant)`                                   | Covers user story 2 and 5.                           |
| I'd like to know when my<br/> basket is full                                          | `Basket`  | `isFull()`                                                           | Returns true if full, else false.                    |
| I'd like to change the <br/>capacity of baskets                                       | `Basket`  | `changeCapacity()`                                                   |                                                      |
| I'd like to know the total<br/> cost of items in my basket.                           | `Order`   | `getTotalCost()`                                                     | Returns a double value.                              |
| I'd like to know the cost of <br/>a bagel before I add it to my basket.               | `Product` | `getPrice()`                                                         | Returns a double value.                              |
| I'd like to be able to choose <br/>fillings for my bagel                              | `Bagel`   | `createBagelWithFilling(BagelType variant, FillingType... fillings)` | Returns a Bagel object.                              |
| I'd like to know the cost of each<br/> filling before I add it to my bagel order      | `Bagel`   | `getFillingPrice(FillingType variant)`                               | Returns the price (double) for the specific variant. |

**Note** The last user story '*I want customers to only be able to order things that we stock in our inventory*' is already covered<br/>
since the use of enums and 'ProductFactory' makes sure it is not possible to add items that does not exist in
the inventory.

### Additional information
The 'Bagel' class has an inner 'BagelBuilder' class that it uses to create
specific bagels with fillings in the `createBagelWithFilling` method.

--------------------------------------------------------------------------------------

# Extension 1: Discounts

## User Stories

```
1. As a member of the public,
So I can recieve the special offer,
I like to order 6 bagels for 2.49.
```

```
2. As a member of the public,
So I can recieve the special offer,
I like to order 12 bagels for 3.99.
```

```
3. As a member of the public,
So I can recieve the special coffee and bagel offer,
I like to order a coffee and a bagel for 1.25.
```

### Domain Model - Extension 1

All the 3 user stories will be implemented in the following class:

| Class   |
|---------|
| `Order` |

And here are the methods that will be used:

| Method                                                   | Return    | Note                                                                                  |
|----------------------------------------------------------|-----------|---------------------------------------------------------------------------------------|
| `getNumberOfItems(Basket basket)`                        | `Integer` | Returns the number of bagels and sets the 'hasDiscount' state on the correct items.   |
| `getTotalCost()`                                         | `Double`  | Done lots of refactoring in this method.                                              |
| `addFillingPriceToTotalCost(Bagel bagel)`                | `void`    | Iterate over a bagels fillings list and adds it to the total cost.                    |
| `getCorrectDiscount(int num)`                            | `Double`  | Finds and returns the correct discount as a double.                                   |
| `checkCoffeeAndBagelPair(Product product, Product next)` | `void`    | Checks prev and next product and adds a discount if there is a coffee and bagel pair. |
| `markAsDiscounted(int limit)`                            | `void`    | Changes the 'hasDiscount' state on bagels that will have a discount.                  |
| `isBagel(Product product)`                               | `Boolean` | Checks if a product is an instance of Bagel.                                          |
| `deliverAndResetTotalCost(Double total)`                 | `Double`  | Deliver and resets the total cost value.                                              |

To make things simple, I just add the values of the discounts as final members in the 'Order' class.
These will be named 'discount1', 'discount2' and  have the Double discount values hardcoded in them.













