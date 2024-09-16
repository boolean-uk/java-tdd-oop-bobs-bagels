## class ShoppingManager

| Members                                    | Methods                                  | Scenario                                                                                                                             | Output  |
|--------------------------------------------|------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|---------|
| `Basket basket`                            | `changeBasketCapacity()`                 | Changes the basket's capacity. Anything below 1 becomes invalid and will warn the owner.                                             | void    |
| `final static ArrayList<Item> listedItems` | `changeBasketCapacityCallback()`         | Is a callback helper function to set the basket's capacity.                                                                          | void    |
|                                            | `printBasket()`                          | Prints all the items you have in your basket.                                                                                        | void    |
|                                            | `checkout()`                             | Prints out the checkout receipt. Also automatically clears the basket.                                                               | void    |
|                                            | `populateMenu()`                         | Is a helper function to manage the dynamic order menu. Showing all of your orders, and giving you the ability to alter the orders.   | void    |
|                                            | `printTotalPrice()`                      | Prints the total price in the console.                                                                                               | void    |
|                                            | `changeBasketCapacity(int newCapacity)`  | Changes the basket capacity from `ShoppingManager`.                                                                                  | void    |
|                                            | `getPriceCount(String uuid, int count)`  | Is a static function to get the total price of an item, multiplied with the count                                                    | double  |
|                                            | `getItem(String uuid)`                   | Is a static function. Returns an item through its uuid. It will return null if the item was not found.                               | Item    |
|                                            | `doubleToStringFormatter(double number)` | A static helper function to easily format doubles with two decimals.                                                                 | String  |
|                                            | `getDateTime()`                          | A static helper function to retrieve the current time by (yyyy-MM-dd HH:mm:ss)<br>Returns a string in this format.                   | String  |
|                                            | `centerText(String text, int length)`    | Centers text based on width. (This is supposed to only be meant for console applications)<br>Returns a padded version of the string. | String  |
|                                            | `isZeroApprox(double value)`             | Returns either true or false depending on if the value is near zero.                                                                 | boolean |

## class Basket

| Members                  | Methods                              | Scenario                                                                                                                                                                                                                 | Output  |
|--------------------------|--------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| `ArrayList<Order> items` | `add(String uuid, int amount)`       | Adds the amount given the type of item by its `uuid`. If the item already exists it just adds to the already existing value. Anything below 1 is invalid and throws a warning.<br>Returns an Error depending on success. | Error   |
| `int capacity`           | `remove(String uuid, int amount)`    | Removes the amount given the type of item by its `uuid`. If there are no items with the given id we throw an error. If the amount is -1 we remove all items of that id.<br>Returns an Error depending on success.        | Error   |
|                          | `calculateTotalPrice()`              | Calculates the total price of all items.                                                                                                                                                                                 | double  |
|                          | `calculateTotalPriceWithDiscounts()` | Does the equivalent to that of `calculateTotalPrice()` however also takes into account all the discounts.                                                                                                                | double  |
|                          | `setCapacity(int capacity)`          | Sets a new capacity for the basket. This method does not accept numbers lower than 1. In case the basket has orders, and the order count exceeds that of the new amount. We remove some orders.                          | Error   |
|                          | `isEmpty()`                          | Check to see if the basket is empty. Returns either true or false.                                                                                                                                                       | boolean |
|                          | `clearBasket()`                      | Clears the current basket of all the orders.                                                                                                                                                                             | void    |
|                          | `getCapacity()`                      | Retrieves the current basket capacity.                                                                                                                                                                                   | int     |
|                          | `getCurrentCapacityUsage()`          | Calculates and returns the amount of orders and amount of those orders.                                                                                                                                                  | int     |
|                          | `getLeftovers()`                     | Returns the amount of space left in the basket.                                                                                                                                                                          | int     |
|                          | `getOrders()`                        | Returns a copy of all of the orders in the basket.                                                                                                                                                                       | Order[] |

## abstract class Discount

| Methods                                            | Scenario                                                                                                                                                                                     | Output |
|----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| `applyDiscount(Order order, final Order[] orders)` | Depending on what implementation for the extended classes, the discount will be returned.<br>The class is abstract so that classes that extends Discount are forced to override this method. | double |

## class ConditionalDiscount extends Discount

| Members                             | Methods                                            | Scenario                                                                                                                                                                 | Output |
|-------------------------------------|----------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| `final Category[] conditionalItems` | `applyDiscount(Order order, final Order[] orders)` | Uses both arguments by checking if the other orders is categorised the same as declared in `conditionalItems`<br>Returns the discount value. 0 if no discount succeeded. | double |
| `final double newPrice`             |                                                    |                                                                                                                                                                          |        |

## class NumberOfItemsDiscount extends Discount

| Members                      | Methods                                            | Scenario                                                                                                                                                | Output |
|------------------------------|----------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| `final int itemCount`        | `applyDiscount(Order order, final Order[] orders)` | Checks to see if an `amount` on the current `order` is more or equal to that of `itemCount`.<br>Returns the discount value. 0 if no discount succeeded. | double |
| `final double discountPrice` |                                                    |                                                                                                                                                         |        |

## class Item

| Members             |
|---------------------|
| `double price`      |
| `String uuid`       |
| `Category category` |
| `String variant`    |
| `Discount discount` |

## class Order

| Members           | Methods               | Scenario                                                                                                                     | Output  |
|-------------------|-----------------------|------------------------------------------------------------------------------------------------------------------------------|---------|
| `int amount`      | `equals(Order other)` | Checks the itemUUIDs against each other to see if they are the same. Returns either true or false depending on similar uuid. | boolean |
| `String itemUUID` |                       |                                                                                                                              |         |

## class OrderButton extends Button

| Members                      | Methods                  | Scenario                                                                                                          | Output |
|------------------------------|--------------------------|-------------------------------------------------------------------------------------------------------------------|--------|
| `Callable targetBasketAdder` | `makeOrder(String uuid)` | Attempts to set an order amount on an item with a `uuid`. If not a valid integer, it will print an error message. | void   |
| `String itemFullName`        |                          |                                                                                                                   |        |

## class RemoveOrderButton extends Button

| Members                        | Methods                    | Scenario                                                                                                                  | Output |
|--------------------------------|----------------------------|---------------------------------------------------------------------------------------------------------------------------|--------|
| `Callable onRefreshButtonList` | `removeOrder(String uuid)` | Attempts to remove an amount on the specified item with a `uuid`. If not a valid integer, it will print an error message. | void   |
| `Callable targetBasketRemover` |                            |                                                                                                                           |        |
| `String itemFullName`          |                            |                                                                                                                           |        |

## enum Category

| Types     |
|-----------|
| `BAGEL`   |
| `COFFEE`  |
| `FILLING` |

## enum Error

| Types          |
|----------------|
| `OK`           |
| `ERROR`        |
| `FULL`         |
| `INVALID`      |
| `BUSY`         |
| `EMPTY`        |
| `VAL_TOO_HIGH` |
| `VAL_TOO_LOW`  |

Menu, Button and Callable are classes I have made myself that are outside the scope of this exercise.
<br>Think of them as external libraries I am using.
