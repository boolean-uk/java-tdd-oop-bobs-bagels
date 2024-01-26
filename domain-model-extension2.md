# Domain model Extension 2

1. Each time a customer orders something (eg) a receipt is created and printed. 




Changed Classes

| Classes | Methods               | Member Variables                           | Scenario                                                   | Output/Result                                                                                |
|---------|-----------------------|--------------------------------------------|------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| Basket  |                       | products HashMap<Product, amount> products |                                                            |                                                                                              |
|         |                       | int maxSize                                |                                                            |                                                                                              |
|         |                       |                                            |                                                            |                                                                                              |
|         | add(String id)        |                                            |                                                            |                                                                                              |
|         |                       |                                            | 10. If product not in inventory                            | return false                                                                                 |
|         |                       |                                            | 3. if existing amount plus new product exceeds maxCapacity | return false                                                                                 |
|         |                       |                                            | else                                                       | add to basket                                                                                |
|         | remove(String id)     |                                            | If product not in basket                                   | return false                                                                                 |
|         |                       |                                            | If product in basket                                       | remove from basket and return true                                                           |
|         | setMaxSize(int size)  |                                            |                                                            | Changes maxSize                                                                              |
|         |                       |                                            |                                                            |                                                                                              |
|         | addFillings()         |                                            |                                                            | Adds fillings if they are in inventory                                                       |
|         |                       |                                            |                                                            |                                                                                              |
|         | getCostOfBagel()      |                                            |                                                            | Returns price of a bagel and its fillings                                                    |
|         | getCostOfBasket()     |                                            |                                                            | Returns entire cost of basket                                                                |
|         | getCostOfFilling()    |                                            |                                                            | Returns Cost Of Filling                                                                      |
|         |                       |                                            |                                                            |                                                                                              |
|         | getProducts()         |                                            |                                                            | returns all products                                                                         |
|         | clearBasket()         |                                            |                                                            | empties basket                                                                               |
|         |                       |                                            |                                                            |                                                                                              |
|         | calculate discounts() |                                            |                                                            | calculate all discounts for the basket. is called from getCostOfBasket                       |
|         |                       |                                            |                                                            |                                                                                              |
|         | purchase()            |                                            | the customer chooses to purchase products in basket        | calculates the cost of the basket (would also change the                                     |
|         |                       |                                            |                                                            | custmers balance and remove products from inventory but that logic wont be implemented)<br/> |
|         |                       |                                            |                                                            | and creates a new receipt and then prints the receipt                                        |


| Classes | Methods    | Member Variables                  | Scenario | Output/Result                                    |
|---------|------------|-----------------------------------|----------|--------------------------------------------------|
| Receipt |            | String timeCreated                |          |                                                  |
|         |            | DateTimeFormatter formatter       |          |                                                  |
|         |            | Map<Product, Integer> quantityMap |          |                                                  |
|         |            |                                   |          |                                                  |
|         |            |                                   |          |                                                  |
|         |            |                                   |          |                                                  |
|         |            |                                   |          |                                                  |
|         | toString() |                                   |          | structures the receipt so its easy to understand |

