User Stories

1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.

2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.

3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.

5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.

6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.

7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.

8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.

9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.

10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.

11.
As a customer,
So i know how much i'm saving
I want to see my total cost bfore and after applying discounts

12.
As a customer,
So I know what i'm paying for
I want to see each individual idem on the receipt accompanied with the cost.

Basket Class

| Method Variables                 | Methods                                                                                            | Scenario                                                 | Output                                                           | User Story  |
|----------------------------------|----------------------------------------------------------------------------------------------------|----------------------------------------------------------|------------------------------------------------------------------|-------------|
| ArrayList<Product> basketContent | addItem(String SKU)                                                                                | Basket full                                              | Print error, return false                                        | 1, 3, 8, 10 |
| ArrayList<Product> inventory     |                                                                                                    | Basket not full                                          | print cost of item, return true                                  |             |
| int totalPrice                   |                                                                                                    |                                                          |                                                                  |             |
| int basketSize                   | removeItem(String SKU)                                                                             | Basket contains item                                     | remove item from basketContent, return true                      | 2, 5        |
|                                  |                                                                                                    | Basket doesnt' contain item                              | print error, return false                                        |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | changeBasketSize(int newSize)                                                                      | newSize is negative number                               | print error, return false                                        | 4           |
|                                  |                                                                                                    | newSize is a positive number                             | print success, return true                                       |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | checkPrice()                                                                                       |                                                          | Prints totalPrice                                                | 6           |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | addFilling(String SKU)                                                                             | SKU corresponds to a bagel in basket                     | print price of filling<br/> add to basketContent<br/>return true | 7, 9        |
|                                  |                                                                                                    | SKU doesn't exist in basket                              | print error, return false                                        |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | addDiscount()                                                                                      | No discounted items                                      | Return the totalPrice (Unchanged)                                | 11          |
|                                  |                                                                                                    | Discounted items                                         | return the new totalPrice                                        |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | printReciet()                                                                                      | Basket is empty                                          | print error                                                      | 12          |
|                                  |                                                                                                    | Basket is not empty                                      | print the receipt including discounts                            |             | 
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | addFilling(String bagelSKU, String FillingSKU)                                                     | Bagel doesn't have a filling,<br/>And filling SKU exists | Add filling to bagel object, return true                         |             |
|                                  |                                                                                                    | Bagel doesn't have filling, but SKU doesn't exists       | print error, return false                                        |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | addToMaps(Product p, Map<String, Int> countMap, Map<String, Double> priceMap)                      |                                                          | Adds the product p to the price and countmap                     |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | printReceiptLines(String productType, Map<String, Integer> countMap, Map<String, Double> priceMap) |                                                          | Prints receit based on content of countMap and priceMap          |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
|                                  | calculateTotal()                                                                                   | basketContent is empty                                   | return 0                                                         |             |
|                                  |                                                                                                    | basketContent is not empty                               | return total price of basket items (WIthout discounts)           |             |
|                                  |                                                                                                    |                                                          |                                                                  |             |
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
