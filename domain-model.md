
| Classes     | Variables                                 | Methods                                                             | Scenario                                             | Outcomes                                                                                            |
|-------------|-------------------------------------------|---------------------------------------------------------------------|------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `Store`     | `private Inventory inventory`             | `addOrder(Order order)`                                             | Argument is valid type                               | Add order to order history and return true                                                          |
|             | `private Map<String, Order> orderHistory` |                                                                     | Argument is not of type Order                        | Return false                                                                                        |
|             | `private String name`                     |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getInventory()`                                                    |                                                      | Return inventory                                                                                    |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getName()`                                                         |                                                      | Return name                                                                                         |
|             |                                           |                                                                     |                                                      |                                                                                                     |
| `Inventory` | `private Map<String, Product> inventory;` | `getProduct(String SKU)`                                            | SKU is in the map                                    | Return product                                                                                      |
|             |                                           |                                                                     | Sku is not in the map                                | Return null                                                                                         |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `setInventory()`                                                    |                                                      | Sets inventory                                                                                      |
|             |                                           |                                                                     |                                                      |                                                                                                     |
| `Order`     | `private List<Product> basket`            | `addProduct(Product product)`                                       | Argument is valid type                               | Add Product to basket, increment the currentBasketCapacity and return true                          |
|             | `private totalSum`                        |                                                                     | Basket is ful                                        | Return false                                                                                        |
|             | `private int currentBasketCapacity`       |                                                                     |                                                      |                                                                                                     |
|             | `private int maxBasketCapacity`           | `removeProduct(Product product)`                                    | Argument is valid type                               | Remove Product from basket, decrement currentBasketCapacity and return true                         |
|             |                                           |                                                                     | Argument is valid type, product is not in the basket | Return false and write message                                                                      |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getTotalSum()`                                                     |                                                      | Return total sum                                                                                    |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `isBasketFull()`                                                    | Basket is ful                                        | Write message to console and return true                                                            |
|             |                                           |                                                                     | Basket is not ful                                    | Return false                                                                                        |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getProductPrice(String SKU)`                                       | Valid SKU                                            | Return product price                                                                                |
|             |                                           |                                                                     | Invalid SKU                                          | Return -1 and write message                                                                         |
|             |                                           |                                                                     | SKU is null                                          | Throw Exception                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `ìncrementBasketCapacity()`                                         |                                                      | Capacity is incremented                                                                             |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getProductsInBasket()`                                             | There are products in basket                         | Return products as a list                                                                           |
|             |                                           |                                                                     | There are not any products in basket                 | Return empty list                                                                                   |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `calculateTotalSum()`                                               | There are products in the basket                     | Return total sum                                                                                    |
|             |                                           |                                                                     | There are no products in the basket                  | Return 0                                                                                            |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getSumToAdd(int amountOfBagels, ArrayList<Integer> ProductPrices)` | If amount of products > 0                            | Return a sum of the remaining products prices after discounts are calculated (highest prices first) |
|             |                                           |                                                                     | If amount of products not > 0                        | Return 0                                                                                            |
|             |                                           |                                                                     |                                                      |                                                                                                     |
| `Product`   | `private String SKU`                      | `getSKU()`                                                          |                                                      | Return the SKU                                                                                      |
|             | `private int price`                       | `getPrice()`                                                        |                                                      | Return the price                                                                                    |
|             | `private String variant`                  | `getVariant()`                                                      |                                                      | Return the variant                                                                                  |
|             |                                           |                                                                     |                                                      |                                                                                                     |
| `Bagel`     | `private Filling[] fillings`              | `addFilling(Filling filling)`                                       | Argument is valid type                               | Add filling to array and return true                                                                |
|             | Inherit from product                      |                                                                     | Argument is not of type Filling                      | Return false                                                                                        |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           | `getFillings()`                                                     | There are fillings in the list                       | Return list of fillings                                                                             |
|             |                                           |                                                                     | There are not fillings in the list                   | Return empty list                                                                                   |
| `Filling`   | Inherit from product                      |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
| `Coffee`    | Inherit from product                      |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
| `Receipt`   | `private Order order`                     | `printReceipt()`                                                    |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |
|             |                                           |                                                                     |                                                      |                                                                                                     |


User Stories for extension 1:
As a Bob's Bagels manager,
So that I can offer better deals to customers, 
I’d like to apply a discount when a customer buys 6 bagels of any variant. 

As a Bob's Bagels manager,
So that I can attract more customers,
I’d like to apply a discount when a customer buys 12 bagels of any variant.  

As a Bob's Bagels manager,
So that I can increase sales of coffee and bagels,
I’d like to offer a discount when a customer buys a coffee and a bagel together.

As a Bob's Bagels manager,
So that I can maximize revenue,
I’d like the system to automatically apply the least possible discount to customer orders.

As a Bob's Bagels manager,
So that I can maximize revenue,
I do not want to apply a coffee and bagels discounts if the bagels already is in a discount.

User Stories for extension 2:
As a customer,
So that I have a record of my purchase,
I’d like to receive a printed receipt for my order.

As a customer,
So that I can see the details of my purchase,
I’d like the receipt to include a list of items purchased with their quantities and prices.

As a customer,
So that I can see the total amount I need to pay,
I’d like the receipt to display the total sum of the order.
