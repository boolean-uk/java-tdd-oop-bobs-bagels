1. As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.

2. As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.

3. As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

4. As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.

5. As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.

6. As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.

7. As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.

8. As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.

9. As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.

10. As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.



| Class       | Attributes                      | Methods                         | Scenario                                                                                                                              | Result                                                                    |
|-------------|---------------------------------|---------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| `Bagel`     |                                 |                                 |                                                                                                                                       |                                                                           |
|             | `String variant`                |                                 |                                                                                                                                       |                                                                           |
|             | `int price`                     |                                 |                                                                                                                                       |                                                                           |
|             | `List<Filling> fillings`        |                                 |                                                                                                                                       |                                                                           |
|             | `Inventory inventory`           |                                 |                                                                                                                                       |                                                                           |
|             |                                 | `getVariant()`                  |                                                                                                                                       | return the type                                                           |
|             |                                 | `getPrice()`                    |                                                                                                                                       | return the price of the bagel plus the price of each filling              |
|             |                                 | `boolean addFilling(Filling f)` | if the Filling exists in the inventory                                                                                                | return true and add the filling to the List of fillings                   |
|             |                                 |                                 | otherwise                                                                                                                             | return false                                                              |
|             |                                 | `getFillings()`                 |                                                                                                                                       | return the list of fillings                                               |
| -           | -                               | -                               | -                                                                                                                                     |                                                                           |
| `Coffee`    |                                 |                                 |                                                                                                                                       |                                                                           |
|             | `String variant`                |                                 |                                                                                                                                       |                                                                           |
|             | `ìnt price`                     |                                 |                                                                                                                                       |                                                                           |
|             |                                 | `getVariant()`                  |                                                                                                                                       | return the type                                                           |
|             |                                 | `getPrice()`                    |                                                                                                                                       | return the price                                                          |
| -           | -                               | -                               | -                                                                                                                                     |                                                                           |
| `Filling`   | `String variant`                |                                 |                                                                                                                                       |                                                                           |
|             | `ìnt price`                     |                                 |                                                                                                                                       |                                                                           |
|             |                                 | `getVariant()`                  |                                                                                                                                       | return the type                                                           |
|             |                                 | `getPrice()`                    |                                                                                                                                       | return the price                                                          |
| -           | -                               | -                               | -                                                                                                                                     |                                                                           |
| `Basket`    |                                 |                                 |                                                                                                                                       |                                                                           |
|             | `List<Bagel> bagels`            |                                 |                                                                                                                                       |                                                                           |
|             | `List<Bagel> coffees`           |                                 |                                                                                                                                       |                                                                           |
|             | `int capacity`                  |                                 |                                                                                                                                       |                                                                           |
|             |                                 | `boolean add(Bagel bagel)`      | if the size of the bagel list plus the size of the coffee list is lower than the capacity and the asked Bagel exists in the inventory | return true and  add the bagel to the list and return the remaining space |
|             |                                 |                                 | otherwise                                                                                                                             | return false                                                              |
|             |                                 | `boolean remove(Bagel bagel)`   | checks if bagel exists in the list                                                                                                    | remove the bagel and return true                                          |
|             |                                 |                                 | otherwise                                                                                                                             | return false                                                              |
|             |                                 | `boolean add(Coffee coffee)`    | if the size of the bagel list plus the size of the coffee list is lower than the capacity and the asked Bagel exists in the inventory | return true and  add the bagel to the list and return the remaining space |
|             |                                 |                                 | otherwise                                                                                                                             | return false                                                              |
|             |                                 | `boolean remove(Coffee coffee)` | if bagel exists in the list                                                                                                           | remove the bagel and return true                                          |
|             |                                 |                                 | otherwise                                                                                                                             | return false                                                              |
|             |                                 | `updateCapacity(int capacity)`  | if capacity is less than the bagels list size                                                                                         | return false and a message                                                |
|             |                                 |                                 | otherwise                                                                                                                             | return true update the value of the capacity                              |
|             |                                 | `cost()`                        |                                                                                                                                       | return the total cost of bagels and coffees in the list                   |
| -           | -                               | -                               | -                                                                                                                                     |                                                                           |
| `Inventory` |                                 |                                 |                                                                                                                                       |                                                                           |
|             | `List<Bagel> existingBagels`    |                                 |                                                                                                                                       |                                                                           |
|             | `List<Filling> existingFilling` |                                 |                                                                                                                                       |                                                                           |
|             | `List<Coffee> existing Coffee`  |                                 |                                                                                                                                       |                                                                           |
|             |                                 | `contains(Bagel b)`             | if the bagel exists in the bagels list                                                                                                | return true                                                               |
|             |                                 |                                 | else                                                                                                                                  | return false                                                              |
|             |                                 | `contains(Filling f)`           | if the filling exists in the fillings list                                                                                            | return true                                                               |
|             |                                 |                                 | else                                                                                                                                  | return false                                                              |
|             |                                 | `contains(Coffee c)`            | if the coffee exists in the fillings list                                                                                             | return true                                                               |
|             |                                 |                                 | else                                                                                                                                  | return false                                                              |