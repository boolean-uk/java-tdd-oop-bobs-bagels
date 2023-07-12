# Model for core part
## User Stories

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

## Model table

| Class  | Fields              | Methods                                          | Scenario                                                                | Output                                      |
|--------|---------------------|--------------------------------------------------|-------------------------------------------------------------------------|---------------------------------------------|
| Basket | List\<Bagel> bagels | boolean add(Bagel bagel)                         | If customer wants to add a specific type of bagel to his basket         |                                             |
|        |                     | boolean remove(int bagelId)                      | If customer wants to remove a bagel from his basket.                    |                                             |
|        | int capacity        | boolean isFull()                                 | Called when customer adds a bagel to his basket.                        |                                             |
|        |                     |                                                  | If number of bagels equals basket capacity                              | true                                        |
|        |                     |                                                  | If number of bagels is less than basket capacity                        | false                                       |
|        |                     | void setCapacity(int newCapacity)                | If manager would like to change the capacity of baskets.                |                                             |
|        |                     |                                                  | If new capacity is less than number of bagels in basket.                | Output error message                        |
|        |                     |                                                  | If new capacity is greater than or equal to number of bagels in basket. | Output nothing                              |
|        |                     | boolean doesBagelExist(String bagel)             | Called when customer tries to remove a bagel from his basket.           |                                             |
|        |                     |                                                  | If bagel exists in the basket.                                          | true                                        |
|        |                     |                                                  | If bagel does not exist in the basket.                                  | false                                       |
|        |                     | BigDecimal getTotalPrice()                       | If customer wants to know how much he'll pay.                           | The price of items in the basket            |
|        |                     | BigDecimal checkPrice(BagelType type)            | If customer wants to know the cost of a bagel.                          | The price of a bagel of the given type.     |
|        |                     | void addFilling(Bagel bagel)                     | If customer wants to add fillings for his bagel.                        |                                             |
|        |                     | List\<Filling> getAvailableFillings(Bagel bagel) | Called when customer wants to know the list of available fillings.      | The list of available fillings for a bagel. |
|        |                     | BigDecimal checkPrice(FillingType type)          | If customer wants to know the cost of a filling.                        | The price of a filling of the given type.   |

| Class     | Fields                       | Methods                    | Scenario                             | Output |
|-----------|------------------------------|----------------------------|--------------------------------------|--------|
| Inventory | Hashmap<Item, Integer> stock | boolean inStock(Item item) | Called to check if item is in stock. |        |
|           |                              |                            | If it is in stock                    | true   |
|           |                              |                            | If it is not in stock                | false  |


| Class | Fields           | Methods               | Scenario                                         | Output                |
|-------|------------------|-----------------------|--------------------------------------------------|-----------------------|
| Item  | BigDecimal price | BigDecimal getPrice() | If customer wants to know the price of the item. | The price of the item |
|       | int id           |                       |                                                  |                       |
|       | SKU type         |                       |                                                  |                       |


| Class   | Fields | Methods | Scenario | Output |
|---------|--------|---------|----------|--------|
| Bagel   |        |         |          |        |
| Coffee  |        |         |          |        |
| Filling |        |         |          |        |

| Class (enum) | Fields |   |   |   |
|--------------|--------|---|---|---|
| BagelType    | String |   |   |   |
| FillingType  | String |   |   |   |
