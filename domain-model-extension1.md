# Domain model Extension 1

1. I want to have 13 plain bagels and 1 coffee. should cost 3.99 + 1.25 = 5.24; 

2. I want to have 24 bagels of same variant. should cost 3.99 * 2 

3. I want to have 18 bagels of same sort, should cost 3.99 + 2.49

4. i want to have 14 plain bagels sort and 1 coffee. should cost 3.99 + 1.25 + 0.39


Changed Classes

| Classes | Methods               | Member Variables                           | Scenario                                                   | Output/Result                                                          |
|---------|-----------------------|--------------------------------------------|------------------------------------------------------------|------------------------------------------------------------------------|
| Basket  |                       | products HashMap<Product, amount> products |                                                            |                                                                        |
|         |                       | int maxSize                                |                                                            |                                                                        |
|         |                       |                                            |                                                            |                                                                        |
|         | add(String id)        |                                            |                                                            |                                                                        |
|         |                       |                                            | 10. If product not in inventory                            | return false                                                           |
|         |                       |                                            | 3. if existing amount plus new product exceeds maxCapacity | return false                                                           |
|         |                       |                                            | else                                                       | add to basket                                                          |
|         | remove(String id)     |                                            | If product not in basket                                   | return false                                                           |
|         |                       |                                            | If product in basket                                       | remove from basket and return true                                     |
|         | setMaxSize(int size)  |                                            |                                                            | Changes maxSize                                                        |
|         |                       |                                            |                                                            |                                                                        |
|         | addFillings()         |                                            |                                                            | Adds fillings if they are in inventory                                 |
|         |                       |                                            |                                                            |                                                                        |
|         | getCostOfBagel()      |                                            |                                                            | Returns price of a bagel and its fillings                              |
|         | getCostOfBasket()     |                                            |                                                            | Returns entire cost of basket                                          |
|         | getCostOfFilling()    |                                            |                                                            | Returns Cost Of Filling                                                |
|         |                       |                                            |                                                            |                                                                        |
|         | getProducts()         |                                            |                                                            | returns all products                                                   |
|         | clearBasket()         |                                            |                                                            | empties basket                                                         |
|         |                       |                                            |                                                            |                                                                        |
|         | calculate discounts() |                                            |                                                            | calculate all discounts for the basket. is called from getCostOfBasket |

Coffee, Bagel and Filling will extend this class

| Classes | Methods          | Member Variables | Scenario | Output/Result         |
|---------|------------------|------------------|----------|-----------------------|
| Product |                  | String name      |          |                       |
|         |                  | String id        |          |                       |
|         |                  | double price     |          |                       |
|         |                  | String variant   |          |                       |
|         |                  |                  |          |                       |
|         | getPrice()       |                  |          | return price          |     
|         | getId()          |                  |          | return Id             |
|         | getName()        |                  |          | return name           |
|         | getVariant()     |                  |          | return Variant        |

| Classes              | Methods          | Member Variables | Scenario | Output/Result         |
|----------------------|------------------|------------------|----------|-----------------------|
| DiscountCalculator() |                  | String name      |          |                       |
|                      |                  | String id        |          |                       |
|                      |                  | double price     |          |                       |
|                      |                  | String variant   |          |                       |
|                      |                  |                  |          |                       |
|                      | getPrice()       |                  |          | return price          |     
|                      | getId()          |                  |          | return Id             |
|                      | getName()        |                  |          | return name           |
|                      | getVariant()     |                  |          | return Variant        |