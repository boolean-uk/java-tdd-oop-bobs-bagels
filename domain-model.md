
| Class          | Methods                         | Scenario                                                   | Output                                                               |
|----------------|---------------------------------|------------------------------------------------------------|----------------------------------------------------------------------|
| `Basket   `    | `add(item, quantity)          ` | if there is capacity, add number of items to basket        | "Added item to basket" "Your basket is full"                         |
|                | `remove(item, quantity)       ` | remove number of items from basket only if item in basket, | "Removed item"                                                       |
|                | `setCap(capacity)             ` | set max capacity of basket                                 | "Changed capacity"                                                   | 
|                | `getCap(capacity)             ` | get max capacity of basket                                 | "Return maximum capacity"                                            |
|                | `existsInBasket(item)         ` | check if item exists in basket                             | "Return true if exists, false if not"                                |
|                | `getTotalPrice(basket)        ` | get total price of all items in basket                     | "Total price is for sum of all (item in items) * price * quantity) " |
|                | `getPrice(item)               ` | get price of a single item in basket                       | "Return price of item in inventory"                                  | 
|                |                                 |                                                            |                                                                      |
| `Inventory`    | `add(item, quantity)          ` | add a number of items to inventory                         | "Added number of items to inventory"                                 |
|                | `existsInStock(item)`           | check if number of item exists in stock                    | "Return true if exists, false if not"                                |
| `Item     `    | `getAttributes()              ` | get attributes of item, such as inventory, price etc.      | "Return attributes"                                                   |


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

