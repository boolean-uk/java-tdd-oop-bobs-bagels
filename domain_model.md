## class ShoppingManager

| Members                       | Methods                  | Scenario                                                                                 | Output |
|-------------------------------|--------------------------|------------------------------------------------------------------------------------------|--------|
| `Basket basket`               | `changeBasketCapacity()` | Changes the basket's capacity. Anything below 1 becomes invalid and will warn the owner. | void   |
| `ArrayList<Item> listedItems` |                          |                                                                                          |        |


## class Basket

| Members                  | Methods                              | Scenario                                                                                                                                                                                                                 | Output |
|--------------------------|--------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| `ArrayList<Order> items` | `add(String uuid, int amount)`       | Adds the amount given the type of item by its `uuid`. If the item already exists it just adds to the already existing value. Anything below 1 is invalid and throws a warning.<br>Returns an Error depending on success. | Error  |
|                          | `remove(String uuid, int amount)`    | Removes the amount given the type of item by its `uuid`. If there are no items with the given id we throw an error. If the amount is -1 we remove all items of that id.<br>Returns an Error depending on success.        | Error  |
|                          | `calculateTotalPrice()`              | Calculates the total price of all items.                                                                                                                                                                                 | double |
|                          | `calculateTotalPriceWithDiscounts()` | Does the equivalent to that of `calculateTotalPrice()` however also takes into account all the discounts.                                                                                                                | double |

## abstract class Discount

| Methods                      | Scenario                                                                                                                                                                                     | Output |
|------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| `applyDiscount(Order order)` | Depending on what implementation for the extended classes, the discount will be returned.<br>The class is abstract so that classes that extends Discount are forced to override this method. | double |


## class Item

| Members             |
|---------------------|
| `double price`      |
| `String uuid`       |
| `Category category` |
| `String variant`    |

## class Order

| Members           |
|-------------------|
| `int amount`      |
| `String itemuuid` |


## enum Category

| Types         |
|---------------|
| `BAGEL = 0`   |
| `COFFEE = 1`  |
| `FILLING = 2` |

