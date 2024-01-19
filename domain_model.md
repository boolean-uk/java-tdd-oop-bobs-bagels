## class ShoppingManager

| Members                       | Methods                  | Scenario                                                                                 | Output |
|-------------------------------|--------------------------|------------------------------------------------------------------------------------------|--------|
| `Basket basket`               | `changeBasketCapacity()` | Changes the basket's capacity. Anything below 1 becomes invalid and will warn the owner. | void   |
| `ArrayList<Item> listedItems` |                          |                                                                                          |        |


## class Basket

| Members                   | Methods                           | Scenario                                                                                                                                                                                                                                                 | Output  |
|---------------------------|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| `ArrayList<String> items` | `add(String uuid, int amount)`    | Adds the amount given the type of item by its `uuid`. If the item already exists it just adds to the already existing value. Anything below 1 is invalid and throws a warning.                                                                           | boolean |
|                           | `remove(String uuid, int amount)` | Removes the amount given the type of item by its `uuid`. If there are no items with the given id we throw an error. If the amount is -1 we remove all items of that id.<br>Returns true or false depending on if it could remove an amount successfully. | boolean |
|                           | `calculateTotalPrice()`           | Calculates the total price of all items.                                                                                                                                                                                                                 | Price   |


## class Item

| Members             |
|---------------------|
| `Price price`       |
| `String uuid`       |
| `Category category` |
| `String variant`    |

## class Order

| Members           |
|-------------------|
| `int amount`      |
| `String itemuuid` |


## class Price

| Members            | Methods                 | Scenario                                                               | Output |
|--------------------|-------------------------|------------------------------------------------------------------------|--------|
| `int real`         | `toString()`            | Converts the price to a string.                                        | String |
| `int decimal`      | `add(Price a, Price b)` | Adds the two prices together, with respect to decimals and everything. | Price  |
| `int decimalCount` |                         |                                                                        |        |


## enum Category

| Types         |
|---------------|
| `BAGEL = 0`   |
| `COFFEE = 1`  |
| `FILLING = 2` |

