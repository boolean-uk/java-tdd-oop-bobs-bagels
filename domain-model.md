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

| Classes | Methods    | Member Variables           | Scenario | Output/Result |
|---------|------------|----------------------------|----------|---------------|
| Bagel   |            | HashMap<Fillings> fillings |          |               |
|         |            | String name                |          |               |
|         |            | double price               |          |               |
|         |            | String variant             |          |               |
|         |            |                            |          |               |
|         | getPrice() |                            |          | return price  |
|         |            |                            |          |               |


| Classes | Methods     | Member Variables | Scenario | Output/Result  |
|---------|-------------|------------------|----------|----------------|
| Coffee  |             | String name      |          |                |
|         |             | double price     |          |                |
|         |             | String variant   |          |                |
|         |             |                  |          |                |
|         | getPrice()  |                  |          | return price   |     
|         |             |                  |          |                |

| Classes | Methods     | Member Variables | Scenario | Output/Result  |
|---------|-------------|------------------|----------|----------------|
| Filling |             | String name      |          |                |
|         |             | double price     |          |                |
|         |             | String variant   |          |                |
|         |             |                  |          |                |
|         | getPrice()  |                  |          | return price   |     
|         |             |                  |          |                |


| Classes   | Methods     | Member Variables                             | Scenario | Output/Result           |
|-----------|-------------|----------------------------------------------|----------|-------------------------|
| Inventory |             | bagels hashMap<String id, Bagel bagel>       |          |                         |
|           |             | coffees hashMap<String id, Coffee coffee>    |          |                         |
|           |             | fillings hashMap<String id, Filling filling> |          |                         |
|           |             |                                              |          |                         |
|           |             | isBagel(String id)                           |          | true if is a bagel      |
|           |             | isCoffee(String id)                          |          | true if is a coffee     |
|           |             | isFilling(String id)                         |          | true id is a filling    |
|           |             | isInInventory(String id)                     |          | true if is in inventory |


| Classes  | Methods                               | Member Variables    | Scenario                    | Output/Result                              |
|----------|---------------------------------------|---------------------|-----------------------------|--------------------------------------------|
| Customer |                                       | Basket basket       |                             |                                            |
|          |                                       | inventory Inventory |                             |                                            |
|          |                                       |                     |                             |                                            |
|          | addToBasket(String id, String[])      |                     | if product in inventory     | add product to basket and return true      |
|          |                                       |                     | if product not in inventory | return false                               |
|          | removeFromBasket(String id, String[]) |                     | if product in basket        | remove product from basket and return true |
|          |                                       |                     | if product not in in basket | return false                               |
|          |                                       |                     |                             |                                            |
|          | getCostOfProduct(id String)           |                     | if product in inventory     | return price                               |
|          |                                       |                     | if product not in inventory | return false                               |
|          |                                       |                     |                             |                                            |
|          | getCostOfBasket()                     |                     |                             | return total cost of items in basket       |
|          |                                       |                     |                             |                                            |
|          |                                       |                     |                             |                                            |
|          |                                       |                     |                             |                                            |

| Classes | Methods     | Member Variables    | Scenario | Output/Result            |
|---------|-------------|---------------------|----------|--------------------------|
| Manager |             | basket Basket       |          |                          |
|         |             | inventory Inventory |          |                          |
|         |             |                     |          |                          |
|         | setBasket() |                     |          | change maxSize of basket |
|         |             |                     |          |                          |
|         |             |                     |          |                          |
|         |             |                     |          |                          |
|         |             |                     |          |                          |
|         |             |                     |          |                          |

| Classes | Methods | Member Variables      | Scenario | Output/Result |
|---------|---------|-----------------------|----------|---------------|
| Basket  |         | ArrayList<String ids> |          |               |
|         |         | Inventory             |          |               |
|         |         |                       |          |               |
|         |         |                       |          |               |
|         |         |                       |          |               |
|         |         |                       |          |               |
|         |         |                       |          |               |
|         |         |                       |          |               |
|         |         |                       |          |               |


