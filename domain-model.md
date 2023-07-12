```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```



// Capacity, List Contents



| Class  | Methods                               | Scenario                            | Outcome                              |
| ------ | ------------------------------------- | ----------------------------------- | ------------------------------------ |
| Basket | addToBasket(BagelType type)           | Bagel type exists                   | bagel is added to basket             |
|        |                                       | Bagel type does not exist           | exception is thrown                  |
|        | removeFromBasket(BagelType type)      | Bagel type is in the basket         | bagel is removed from the basket     |
|        |                                       | Bagel type is not in the basket     | Print info that bagel is not present |
|        | isBasketFull()                        | Basket is full                      | return true                          |
|        |                                       | Basket is not full yet              | return false                         |
|        | changeBasketCapacity(int newCapacity) | new capacity is < current capacity  | exception is thrown                  |
|        |                                       | new capacity is >= current capacity | capacity is set to newCapacity       |
|        |                                       |                                     |                                      |

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