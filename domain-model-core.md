# Bob's bagels
### Dorota Wlazło, Jan Rusak

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

| Class  | Field                                  | Method                                            | Condition                                                                                     | Output                           |
|--------|----------------------------------------|---------------------------------------------------|-----------------------------------------------------------------------------------------------|----------------------------------|
| Basket | Hashmap<String, Integer> productsCount | boolean add(String productVariant, int amount)    | if there are less products in total than capacity                                             | true                             |
|        |                                        |                                                   | if there are more products in total than capacity or the productVariant is N/A or amount <= 0 | false                            |
|        | int capacity                           |                                                   |                                                                                               |                                  |
|        | int currentAmountOfProducts            | boolean remove(String productVariant, int amount) | if the amount of products of sku in basket is >= amount                                       | true                             |
|        |                                        |                                                   | if the amount of products of sku in basket is < amount or amount <= 0                         | false                            |
|        |                                        | boolean changeCapacity(int newCapacity)           | if newCapacity >= currentAmount                                                               | true                             |
|        |                                        |                                                   | if newCapacity < currentAmount                                                                | false                            |
|        |                                        | double totalCost()                                | always                                                                                        | total cost of products in basket |
|        |                                        | double checkCostOfProduct(String productVariant)  | always                                                                                        | cost of product by sku           |

| Class   | Field          | Method | Condition | Output |
|---------|----------------|--------|-----------|--------|
| Product | String sku     |        |           |        |
|         | double price   |        |           |        |
|         | String name    |        |           |        |
|         | String variant |        |           |        |


| Class     | Field                             | Method                                    | Condition                         | Output          |
|-----------|-----------------------------------|-------------------------------------------|-----------------------------------|-----------------|
| Inventory | Hashmap<String, Product> products | Product getProduct(String productVariant) | if product exist in the inventory | Product product |
|           |                                   |                                           | if product doesn't exists         | null            |


