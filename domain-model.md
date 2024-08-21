
Basket Class

| Method Variables                 | Methods                                        | Scenario                                                 | Output                                                           | User Story |
|----------------------------------|------------------------------------------------|----------------------------------------------------------|------------------------------------------------------------------|------------|
| ArrayList<Product> basketContent | addItem(String SKU)                            | Basket full                                              | Print error, return false                                        | 1, 3       |
| ArrayList<Product> inventory     |                                                | Basket not full                                          | print cost of item, return true                                  |            |
| int totalPrice                   |                                                |                                                          |                                                                  |            |
| int basketSize                   | removeItem(String SKU)                         | Basket contains item                                     | remove item from basketContent, return true                      | 2, 5       |
|                                  |                                                | Basket doesnt' contain item                              | print error, return false                                        |            |
|                                  |                                                |                                                          |                                                                  |            |
|                                  | changeBasketSize(int newSize)                  | newSize is negative number                               | print error, return false                                        | 4          |
|                                  |                                                | newSize is a positive number                             | print success, return true                                       |            |
|                                  |                                                |                                                          |                                                                  |            |
|                                  | checkPrice()                                   |                                                          | Prints totalPrice                                                | 6          |
|                                  |                                                |                                                          |                                                                  |            |
|                                  | addFilling(String SKU)                         | SKU corresponds to a bagel in basket                     | print price of filling<br/> add to basketContent<br/>return true |            |
|                                  |                                                | SKU doesn't exist in basket                              | print error, return false                                        |            |
|                                  |                                                |                                                          |                                                                  |            |
|                                  | addDiscount()                                  | No discounted items                                      | Return the totalPrice (Unchanged)                                |            |
|                                  |                                                | Discounted items                                         | return the new totalPrice                                        |            |
|                                  |                                                |                                                          |                                                                  |            |
|                                  | printReciet()                                  | Basket is empty                                          | print error                                                      |            |
|                                  |                                                | Basket is not empty                                      | print the receipt including discounts                            |            | addFilling(String SKU) | Bagel already has filling                                | Print error, return false                |            |
|                                  |                                                |                                                          |                                                                  |            |
|                                  | addFilling(String bagelSKU, String FillingSKU) | Bagel doesn't have a filling,<br/>And filling SKU exists | Add filling to bagel object, return true                         |            |
|                                  |                                                | Bagel doesn't have filling, but SKU doesn't exists       | print error, return false                                        |            |
|                                  |

Product class

| Method Variables | Methods      | Scenario | Output        | User stories |
|------------------|--------------|----------|---------------|--------------|
| int SKU          | getSKU()     |          | print SKU     |              |
| int price        | getPrice()   |          | print price   |              |
| String name      | getName()    |          | print name    |              |
| String variant   | getVariant() |          | print variant |              |
|                  |              |          |               |              |
|                  |              |          |               |              |

The classes Coffee and Filling inherit from the product class, and have no unique variables or methods

Bagel class

| Method variables | Methods                | Scenario                                                 | Output                                   | user story |
|------------------|------------------------|----------------------------------------------------------|------------------------------------------|------------|
| Filling filling  | getFilling()           | Filling exists                                           | return Filling object                    | 8          |
|                  |                        | Filling doesn't exist                                    | print error, return null                 |            |
|                  |                        |                                                          |                                          |            |
|                  |                        |                                                          |                                          |            |
