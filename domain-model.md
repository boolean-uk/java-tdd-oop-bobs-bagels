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
| `addDiscount(int numBagels, int limit, double discount)` | `Integer` | Adds discount and decrement number of bagels counter.                                 |
| `checkCoffeeAndBagelPair(Product product, Product next)` | `void`    | Checks prev and next product and adds a discount if there is a coffee and bagel pair. |
| `markAsDiscounted(Basket basket, int bagelsToMark)`      | `void`    | Changes the 'hasDiscount' state on bagels that will have a discount.                  |
| `isBagel(Product product)`                               | `Boolean` | Checks if a product is an instance of Bagel.                                          |
| `deliverAndResetTotalCost(Double total)`                 | `Double`  | Deliver and resets the total cost value.                                              |
| `applyDiscount(Basket basket, Integer bagelCounter)`     | `void`    | Find the number of the different discount sets and marks the bagels as discounted.    |

------------------------------------------------------------------------------------------------------

# Extension 2: Receipts

## User Story

```
As a member of the public,
so I can get an overview of my order,
Id like to recieve an receipt for my order.
```

### Domain Model - Extension 2

The following classes will be used for the user story:

| Classes       | Members        | Type                     |
|---------------|----------------|--------------------------|
| `Receipt`     | `order`        | `Order`                  |
|               | `receiptItems` | `ArrayList<ReceiptItem>` |
| `ReceiptItem` | `variant`      | `MenuCategory`           |
|               | `name`         | `String`                 |
|               | `quantity`     | `Integer`                |
|               | `priceSum`     | `Double`                 |

These are the methods in the Receipt class:

| Method                             | Returns                                | Note                                                                                      |
|------------------------------------|----------------------------------------|-------------------------------------------------------------------------------------------|
| `printReceipt`                     | `void`                                 | Prints out the receipt in the same structure as the assignment description.               |
| `fillReceiptItems`                 | `void`                                 | Fills the receiptItems list with items from the basket.                                   |
| `groupByProductAndCount`           | `Map<MenuCategory, Map<String, Long>>` | Count and group variants together.                                                        |
| `groupByProductAndPrice`           | `Map<MenuCategory, Double>`            | Sums the price for the different product groups.                                          |
| `iterateMapsAndCreateReceiptItems` | `void`                                 | Iterate over the maps and create ReceiptItems.                                            |
| `createReceiptItemAndAddToList`    | `void`                                 | Create the items and add them to the receiptItems arraylist.                              |
| `getFormattedDate`                 | `String`                               | Helper method used to get the current date in a nice format (should be in a utils class). |


The 'ReceiptItem' class includes getters for all the members. 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------





















