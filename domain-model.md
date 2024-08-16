```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

| Class  | Method           | Member Variables         | Scenario              | Outputs/Results                 |
|--------|------------------|--------------------------|-----------------------|---------------------------------|
| Basket | add(String item) | String item              | adds Item to the list | Return the list with added Item |
|        |                  | ArrayList<String> basket |                       |                                 |


```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```
| Class  | Method              | Member Variables         | Scenario              | Outputs/Results             |
|--------|---------------------|--------------------------|-----------------------|-----------------------------|
| Basket | remove(String item) | String item              | if item is in basket  | Remove item from the basket |
|        |                     | ArrayList<String> basket | if item not in basket | return null                 |


```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```
| Class  | Method           | Member Variables         | Scenario                      | Outputs/Results                  |
|--------|------------------|--------------------------|-------------------------------|----------------------------------|
| Basket | add(String item) | String item              | if the capacity is full       | Return false                     |
|        |                  | Arraylist<String> basket | if capacity is not full       | Return the list with added bagel |

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```
| Class  | Method                       | Member Variables         | Scenario            | Outputs/Results               |
|--------|------------------------------|--------------------------|---------------------|-------------------------------|
| Basket | changeCapacity(int capacity) | int capacity             | Change value of the | Return "Capacity has changed" |
|        |                              | Arraylist<String> basket | capacity            |                               |

``` 
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```
| Class  | Method              | Member Variables         | Scenario              | Outputs/Results                        |
|--------|---------------------|--------------------------|-----------------------|----------------------------------------|
| Basket | remove(String item) | String item              | if item is in basket  | Remove item from basket                |
|        |                     | ArrayList<String> basket | if item not in basket | Return "item does not exist in basket" |

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

| Class  | Method                  | Member Variables         | Scenario                         | Outputs/Results    |
|--------|-------------------------|--------------------------|----------------------------------|--------------------|
| Basket | totalCost()             | double cost              | Loop through, if items in basket | Add price to total |
|        |                         | ArrayList<String> basket | Loop ends                        | Return total       |

```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

| Class  | Method                  | Member Variables          | Scenario                  | Outputs/Results          |
|--------|-------------------------|---------------------------|---------------------------|--------------------------|
| Basket | checkPrice(String item) | Item item                 | If bagel in inventory     | return price of bagel    |
|        |                         | ArrayList<String> basket  | If bagel not in inventory | return no bagel/no price |
|        |                         | ArrayList<Item> inventory |                           |                          |
|        |                         |                           |                           |                          |
| Item   | getPrice()              | double price              | get price of item         |                          |


```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

| Class  | Method                                  | Member Variables          | Scenario             | Outputs/Results           |
|--------|-----------------------------------------|---------------------------|----------------------|---------------------------|
| Basket | addFilling(String item, String filling) | String item               | if item in inventory | return bagel with filling |
|        |                                         | String filling            |                      |                           |
|        |                                         | ArrayList<String> basket  |                      |                           |
|        |                                         | ArrayList<Item> inventory |                      |                           |
| Item   | getName()                               | String name               |                      |                           |

```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

| Class  | Method                  | Member Variables          | Scenario                 | Outputs/Results          |
|--------|-------------------------|---------------------------|--------------------------|--------------------------|
| Basket | checkPrice(String item) | String item               | If item in inventory     | return price of bagel    |
|        |                         | ArrayList<String> basket  | If item not in inventory | return no bagel/no price |
|        |                         | ArrayList<Item> inventory |                          |                          |
| Item   | getPrice()              | double price              |                          |                          |



```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```


| Class  | Method           | Member Variables          | Scenario                   | Outputs/Results |
|--------|------------------|---------------------------|----------------------------|-----------------|
| Basket | add(String item) | String item               | If item exist in inventory | add item        |
|        |                  | ArrayList<String> basket  | If item not in inventory   | return null     |
|        |                  | ArrayList<Item> inventory |                            |                 |
|        |                  |                           |                            |                 |


```
Domain model for EXTENSION 1
```

| Class  | Method            | Member Variables           | Scenario                                                           | Result              |
|--------|-------------------|----------------------------|--------------------------------------------------------------------|---------------------|
| Basket | double discount() | ArrayList<Item> inventory  | Create 3 new items in inventory with SKU: DIS6, DIS12, DISCB.      | return double price |
|        |                   | ArrayList<String> basket   | Iterate through the basket to count the amount of bagels and add   |                     |
|        |                   | ArrayList<String> discount | the discount SKU to the discount-list and calculate the totalprice |                     |
|        |                   |                            |                                                                    |                     |

