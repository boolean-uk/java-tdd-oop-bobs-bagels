# Domain model bobs bagels

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

| Classes | Methods             | Member Variables             | Scenario | Output/Result                           |
|---------|---------------------|------------------------------|----------|-----------------------------------------|
| Bagel   |                     | ArrayList<Fillings> fillings |          |                                         |
|         |                     | String id                    |          |                                         |
|         |                     | String name                  |          |                                         |
|         |                     | double price                 |          |                                         |
|         |                     | String variant               |          |                                         |
|         |                     |                              |          |                                         |
|         | addFilling(Filling) |                              |          | Adds fillings if they are in inventory  |
|         | getPrice()          |                              |          | return price                            |
|         | getId()             |                              |          | return Id                               |
|         | getFillings()       |                              |          | return fillings                         |
|         | getName()           |                              |          | return name                             |
|         | getVariant()        |                              |          | return Variant                          |
|         |                     |                              |          |                                         |
|         |                     |                              |          |                                         |



| Classes | Methods          | Member Variables | Scenario | Output/Result         |
|---------|------------------|------------------|----------|-----------------------|
| Coffee  |                  | String name      |          |                       |
|         |                  | String id        |          |                       |
|         |                  | double price     |          |                       |
|         |                  | String variant   |          |                       |
|         |                  |                  |          |                       |
|         | getPrice()       |                  |          | return price          |     
|         | getId()          |                  |          | return Id             |
|         | getName()        |                  |          | return name           |
|         | getVariant()     |                  |          | return Variant        |

| Classes | Methods      | Member Variables | Scenario | Output/Result  |
|---------|--------------|------------------|----------|----------------|
| Filling |              | String name      |          |                |
|         |              | String id        |          |                |
|         |              | double price     |          |                |
|         |              | String variant   |          |                |
|         |              |                  |          |                |
|         | getPrice()   |                  |          | return price   |     
|         | getId()      |                  |          | return Id      |
|         | getName()    |                  |          | return name    |
|         | getVariant() |                  |          | return Variant | 

| Classes   | Methods     | Member Variables                             | Scenario                                                   | Output/Result |
|-----------|-------------|----------------------------------------------|------------------------------------------------------------|---------------|
| Inventory |             | bagels hashMap<String id, Bagel bagel>       |                                                            |               |
|           |             | coffees hashMap<String id, Coffee coffee>    |                                                            |               |
|           |             | fillings hashMap<String id, Filling filling> |                                                            |               |
|           |             |                                              |                                                            |               |
|           |             | isValidBagel(String id)                      | Check if the bagel/coffee/filling is part of the inventory |               |
|           |             | isValidCoffee(String id)                     |                                                            |               |
|           |             | isValidFilling(String id)                    |                                                            |               |

| Classes | Methods            | Member Variables              | Scenario                                             | Output/Result                 |
|---------|--------------------|-------------------------------|------------------------------------------------------|-------------------------------|
| Manager |                    | basket Basket                 |                                                      |                               |
|         |                    | ArrayList<Basketr> customer   |                                                      |                               |
|         |                    |                               |                                                      |                               |
|         | 4. setBasketSize() |                               |                                                      | change maxSize of basket      |
|         |                    |                               | if a customer has more products than the new maxSize | clear that customers basket   |
|         | addBasket(Basket)  |                               |                                                      | add basket to list of baskets |
|         |                    |                               |                                                      |                               |
|         |                    |                               |                                                      |                               |
|         |                    |                               |                                                      |                               |

| Classes | Methods              | Member Variables                   | Scenario                                                   | Output/Result                             |
|---------|----------------------|------------------------------------|------------------------------------------------------------|-------------------------------------------|
| Basket  |                      | products ArrayList<Bagel> products |                                                            |                                           |
|         |                      | int maxSize                        |                                                            |                                           |
|         |                      |                                    |                                                            |                                           |
|         | add(String id)       |                                    |                                                            |                                           |
|         |                      |                                    | 10. If product not in inventory                            | return false                              |
|         |                      |                                    | 3. if existing amount plus new product exceeds maxCapacity | return false                              |
|         |                      |                                    | else                                                       | add to basket                             |
|         | remove(String id)    |                                    | If product not in basket                                   | return false                              |
|         |                      |                                    | If product in basket                                       | remove from basket and return true        |
|         | setMaxSize(int size) |                                    |                                                            | Changes maxSize                           |
|         |                      |                                    |                                                            |                                           |
|         | addFillings()        |                                    |                                                            | Adds fillings if they are in inventory    |
|         |                      |                                    |                                                            |                                           |
|         | getCostOfBagel()     |                                    |                                                            | Returns price of a bagel and its fillings |
|         | getCostOfBasket()    |                                    |                                                            | Returns entire cost of basket             |
|         | getCostOfFilling()   |                                    |                                                            | Returns Cost Of Filling                   |
|         |                      |                                    |                                                            |                                           |
|         | getProducts()        |                                    |                                                            | returns all products                      |
|         | clearBasket()        |                                    |                                                            | empties basket                            |
|         |                      |                                    |                                                            |                                           |
|         |                      |                                    |                                                            |                                           |
