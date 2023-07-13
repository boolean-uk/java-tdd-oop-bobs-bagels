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

| Class     | Fields                 | Methods                                  | Scenario                                                               | Output                 |
|-----------|------------------------|------------------------------------------|------------------------------------------------------------------------|------------------------|
| Basket    | List\<Bagel> bagels    | void add(Bagel bagel)                    | If customer wants to add a specific type of bagel to his basket        |                        |
|           | List\<Bagel> bagels    | void remove(Bagel bagel)                 | If customer wants to remove a bagel from his basket.                   |                        |
|           | int capacity           | boolean isFull()                         | Called when customer adds a bagel to his basket.                       |                        |
|           |                        |                                          | If number of bagels equals basket capacity                             | true                   |
|           |                        |                                          | If number of bagels is less than basket capacity                       | false                  |
|           | int capacity           | void setCapacity(int newCapacity)        | If manager would like to change the capacity of baskets.               |                        |
|           |                        |                                          | If new capacity is less than number of bagels in basket                | Output error message   |
|           |                        |                                          | If new capacity is greater than or equal to number of bagels in basket | Output nothing         |
|           | List\<String> bagels   | boolean doesBagelExist(Bagel bagel)      | Called when customer tries to remove a bagel from his basket           |                        |
|           |                        |                                          | If bagel exists in the basket                                          | true                   |
|           |                        |                                          | If bagel does not exist in the basket                                  | false                  |
|           |                        | BigDecimal totalCost()                   |                                                                        | total cost of products |
| Bagel     | BigDecimal price       | BigDecimal getPrice()                    |                                                                        | price of the bagel     |
|           | List<Filling> fillings | void setFillings(List<Filling> fillings) |                                                                        |                        |
| Filling   | BigDecimal price       | BigDecimal getPrice()                    |                                                                        | price of the filling   |
| Inventory | List<String> itemSkus  | boolean containsItem(String sku)         | If item exists in inventory                                            | true                   |
|           |                        |                                          | If item does not exist in inventory                                    | false                  |

## Extensions

### Extension 1.

```
1.
As a customer,
So I can have more for less
I'd like to get some discount for buying multiple products.
```

| Class                     | Fields                  | Methods                                       | Scenario                                                               | Output                              |
|---------------------------|-------------------------|-----------------------------------------------|------------------------------------------------------------------------|-------------------------------------|
| Basket                    | List\<Product> products | void add(Product product)                     | If customer wants to add a specific type of product to his basket      |                                     |
|                           | List\<Product> products | void remove(Product product)                  | If customer wants to remove a product from his basket.                 |                                     |
|                           | int capacity            | boolean isFull()                              | Called when customer adds a product to his basket.                     |                                     |
|                           |                         |                                               | If number of products equals basket capacity                           | true                                |
|                           |                         |                                               | If number of products is less than basket capacity                     | false                               |
|                           | int capacity            | void setCapacity(int newCapacity)             | If manager would like to change the capacity of baskets.               |                                     |
|                           |                         |                                               | If new capacity is less than number of bagels in basket                | Output error message                |
|                           |                         |                                               | If new capacity is greater than or equal to number of bagels in basket | Output nothing                      |
|                           | List\<String> products  | boolean doesProductExist(Product product)     | Called when customer tries to remove a product from his basket         |                                     |
|                           |                         |                                               | If product exists in the basket                                        | true                                |
|                           |                         |                                               | If product does not exist in the basket                                | false                               |
|                           |                         | Map<Product, BigDecimal> calculateDiscounts() |                                                                        | map of products and their discounts |
|                           |                         | BigDecimal totalCost()                        |                                                                        | total cost of products              |
| *Product*                 | BigDecimal price        | BigDecimal getPrice()                         |                                                                        | price of the product                |
| Bagel extends *Product*   | BigDecimal price        | BigDecimal getPrice()                         |                                                                        | price of the bagel                  |
|                           | List\<Filling> fillings | void setFillings(List\<Filling> fillings)     |                                                                        |                                     |
| Filling extends *Product* | BigDecimal price        | BigDecimal getPrice()                         |                                                                        | price of the filling                |
| Coffee extends *Product*  | BigDecimal price        | BigDecimal getPrice()                         |                                                                        | price of the coffee                 |
| Inventory                 | List\<String> itemSkus  | boolean containsItem(String sku)              | If item exists in inventory                                            | true                                |
|                           |                         |                                               | If item does not exist in inventory                                    | false                               |

### Extensions 2. and 3.

```
1.
As a customer,
So I can have order confirmation,
I'd like to get a detailed receipt.
```

```
2.
As a customer,
So I can know how much I saved,
I'd like to see all discounts on my receipt.
```

| Class   | Fields             | Methods               | Scenario | Output                  |
|---------|--------------------|-----------------------|----------|-------------------------|
| Receipt | LocalDateTime time | String printReceipt() |          | prints detailed receipt |       
|         | Basket basket      |                       |          |                         |                  
