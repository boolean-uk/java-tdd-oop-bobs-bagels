# OOP BOB BAGELS

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

## Model

| Class          | Methods                                            | Fields                                | Outcome                                                         |
|----------------|----------------------------------------------------|---------------------------------------|-----------------------------------------------------------------|
| Basket         | addProduct(Product product, int quantity)          | `HashMap<Bagel,Integer> basket `        | Product is added to the basket                                  |
|                | removeProduct(Product product, Quantity)           | `HashMap<Bagel,Integer> basket  `       | Product is removed from the basket                              |
|                | public void changeCapacity(int capacity)           | int capacity                          | It will change capacity of the Basket                           |
|                | public double getTotalCost()                       |` HashMap<Bagel,Integer> basket    `     | Method will provide total cost of the basket                    |
|                | private boolean checkSanity(Product product)       |                                       | True if basket contains product                                 |
|                |                                                    |                                       | False if basket does not contains product                       |
|                | private int productsInBasket()                     | `HashMap<Bagel,Integer> basket  `       | It will return number of products in the basket                 |
|                |                                                    |                                       |                                                                 |
| Bagel          | public double getTotalCostOfProduct()              | `ArrayList<Filling> fillings     `      | It will return bagel with filling total cost                    |
|                | public void addFilling(Filling filling)            |` ArrayList<Filling> fillings   `        | it will add filling to the bagel                                |
|                |                                                    |                                       |                                                                 |
| Inventory      | public  boolean isInTheInventory(Product product1) |                                       | return true if inventory contains product.                      |
|                |                                                    |                                       | return false if inventory does not contains product.            |
|                | public String returnAllFilling()                   | static `ArrayList<Filling>` allFillings | It will return String with all fillings with price in inventory |
|                | public String returnAllBagels()                    | static `ArrayList<Bagle>` allBagels     | It will return String with all bagels with price in inventory   |
|                | public String returnAllCoffees()                   | `static ArrayList<Coffee> allCoffees`   | It will return String with all coffees with price in inventory  |
| Product        |                                                    |                                       |                                                                 |
| Coffees        |                                                    |                                       |                                                                 |
| Filling        |                                                    |                                       |                                                                 |
| BagelVariant   |                                                    |                                       |                                                                 |
| CoffeeVariant  |                                                    |                                       |                                                                 |
| FillingVariant |                                                    |                                       |                                                                 |
|                |                                                    |                                       |                                                                 |
|                |                                                    |                                       |                                                                 |
|                |                                                    |                                       |                                                                 |
