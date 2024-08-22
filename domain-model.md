
| Class  | Members Variable        | Methods                                                                   | Scenario                                                                                                                      | Output                                                           |
|--------|-------------------------|---------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| Basket | Hashmap<Product> basket |                                                                           |                                                                                                                               |                                                                  |
|        | int capacity            |                                                                           |                                                                                                                               |                                                                  |
|        | int productCount        |                                                                           |                                                                                                                               |                                                                  |
|        |                         | (1, 3, 8, 10) add(String sku) Overload add(String sku, String fillingSku) | Should add Product or Coffee to the basket. If product already in basket, add one to it's quantity.                           | "Existing product added to basket / new product added to basket" |
|        |                         |                                                                           | If product or coffee not found.                                                                                               | "Failed to add order"                                            |
|        |                         |                                                                           | If basket is fulL                                                                                                             | "Basket is full"                                                 |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         | (2, 5) remove(String sku) Overload add(String sku, String fillingSku)     | Should get the product with matching sku and remove it from the basket. If quantity over 1 then subtract the quantity by one. | "This product is removed"                                        |
|        |                         |                                                                           | If the quantity is one then remove the object from the basket.                                                                | "One product removed"                                            |
|        |                         |                                                                           | If not found in basket:                                                                                                       | "Product not in basket"                                          |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         | (6) totalCost()                                                           | should get the total price of all the products in basket.                                                                     | int finalPrice                                                   |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         | (4) changeCapacity(int newSize)                                           | should change the member variable basketSize to newBasketSize                                                                 | "Size changed"                                                   |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         | (7) costOf(Product)                                                       | should return the int of specifically that product's cost.                                                                    | int price                                                        |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         | (9) getFillingCost(Filling)                                               | Should get the cost of a specific filling.                                                                                    | int price                                                        |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         |                                                                           |                                                                                                                               |                                                                  |
|        |                         |                                                                           |                                                                                                                               |                                                                  |


```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```
```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```
```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```
```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```
```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```
```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```
```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```
```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```
