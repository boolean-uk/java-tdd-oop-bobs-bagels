

Note: the domain model is subject to change before the assignment is complete

| Comment | Class     | Fields                         | Methods                                    | Test | Done | Situation                                  | Output / Response                           |
|---------|-----------|--------------------------------|--------------------------------------------|------|------|--------------------------------------------|---------------------------------------------|
|         | Product   | String sku                     |                                            |      |      |                                            |                                             |
|         |           | String name                    |                                            |      |      |                                            |                                             |
|         |           | String variant                 |                                            |      |      |                                            |                                             |
|         |           | double price                   |                                            |      |      |                                            |                                             |
|         |           |                                | double getPrice()                          | x    | x    | Get product price outside of class         | returns a double representing product price |
|         |           |                                | String getVariant()                        | x    | x    | get product variant outside of class       | returns a String containing product variant |
|         |           |                                | String getName()                           | x    | x    | get product name outside of class          | returns a String containing product name    |
|         |           |                                | String getSku()                            | x    | x    |                                            |                                             |
|         |           |                                | void setPrice(double price)                | x    | x    | Change product price from outside of class | the product                                 |
|         |           |                                | void setVariant(String variant)            | x    | x    |                                            |                                             |
|         |           |                                | void setName(String name)                  | x    | x    |                                            |                                             |
|         |           |                                | void setSku(String sku)                    | x    | x    |                                            |                                             |
|         | Bagel     | ArrayList<Filling> fillings    |                                            |      |      |                                            |                                             |
|         |           | double basePrice               |                                            |      |      |                                            |                                             |
|         |           |                                | void addFilling(Filling filling)           | x    |      |                                            |                                             |
|         |           |                                | void removeFilling(Filling filling)        |      |      |                                            |                                             |
|         |           |                                | void getFillings()                         | x    |      |                                            |                                             |
|         |           |                                | double getPrice()                          | x    |      |                                            |                                             |
|         |           |                                | void setPrice()                            | x    |      |                                            |                                             |
|         |           |                                | void getBasePrice()                        | x    |      |                                            |                                             |
|         |           |                                | double setBasePrice()                      | x    |      |                                            |                                             |
|         | Coffee    |                                |                                            |      |      |                                            |                                             |
|         |           |                                |                                            |      |      |                                            |                                             |
|         | Filling   |                                |                                            |      |      |                                            |                                             |
|         |           |                                |                                            |      |      |                                            |                                             |
|         | Inventory | ArrayList<Product> stock       |                                            |      |      |                                            |                                             |
|         |           |                                | ArrayList<Product> getStock()              |      |      |                                            |                                             |
|         |           |                                | boolean addStock()                         |      |      |                                            |                                             |
|         |           |                                | boolean removeStock()                      |      |      |                                            |                                             |
|         |           |                                | boolean inStock()                          |      |      |                                            |                                             |
|         | Basket    | ArrayList<Product> basketItems |                                            |      |      |                                            |                                             |
|         |           | int basketLimit                |                                            |      |      |                                            |                                             |
|         |           |                                | void addProduct(Product product)           |      |      |                                            |                                             |
|         |           |                                | void removeProduct(Product product)        |      |      |                                            |                                             |
|         |           |                                | HashMap<Product, Integer> getBasketItems() | x    |      |                                            |                                             |
|         |           |                                | boolean isBasketFull()                     | x    |      |                                            |                                             |
|         |           |                                | void setCapacity(int basketLimit)          | x    |      |                                            |                                             |
|         |           |                                | boolean inBasket()                         | x    |      |                                            |                                             |
|         |           |                                |                                            |      |      |                                            |                                             |
|         | Checkout  |                                | double sumPrice(ArrayList<Product>)        |      |      |                                            |                                             |

### User Stories
```
1. d
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

```
2. d
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

```
3. d
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
5. d
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

```
6. d
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

```
7. d
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

```
8. d
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

```
9. d
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