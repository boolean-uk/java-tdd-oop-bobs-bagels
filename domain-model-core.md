

Note: the domain model is subject to change before the assignment is complete

| Comment | Class                 | Fields                         | Methods                                    | Test | Done | Situation                                  | Output / Response                           |
|---------|-----------------------|--------------------------------|--------------------------------------------|------|------|--------------------------------------------|---------------------------------------------|
|         | Product               | String sku                     |                                            |      |      |                                            |                                             |
|         |                       | String name                    |                                            |      |      |                                            |                                             |
|         |                       | String variant                 |                                            |      |      |                                            |                                             |
|         |                       | double price                   |                                            |      |      |                                            |                                             |
|         |                       |                                | double getPrice()                          | x    | x    | Get product price outside of class         | returns a double representing product price |
|         |                       |                                | String getVariant()                        | x    | x    | get product variant outside of class       | returns a String containing product variant |
|         |                       |                                | String getName()                           | x    | x    | get product name outside of class          | returns a String containing product name    |
|         |                       |                                | String getSku()                            | x    | x    |                                            |                                             |
|         |                       |                                | void setPrice(double price)                | x    | x    | Change product price from outside of class | the product                                 |
|         |                       |                                | void setVariant(String variant)            | x    | x    |                                            |                                             |
|         |                       |                                | void setName(String name)                  | x    | x    |                                            |                                             |
|         |                       |                                | void setSku(String sku)                    | x    | x    |                                            |                                             |
|         | Bagel                 | ArrayList<Filling> fillings    |                                            |      |      |                                            |                                             |
|         |                       | double basePrice               |                                            |      |      |                                            |                                             |
|         |                       |                                | void addFilling(Filling filling)           | x    | x    |                                            |                                             |
|         |                       |                                | void removeFilling(Filling filling)        |      |      |                                            |                                             |
|         |                       |                                | void getFillings()                         | x    | x    |                                            |                                             |
|         |                       |                                | double getPrice()                          | x    | x    |                                            |                                             |
|         |                       |                                | void setPrice()                            | x    | x    |                                            |                                             |
|         |                       |                                | void getBasePrice()                        | x    | x    |                                            |                                             |
|         |                       |                                | double setBasePrice()                      | x    | x    |                                            |                                             |
|         | Coffee                |                                |                                            |      |      |                                            |                                             |
|         |                       |                                |                                            |      |      |                                            |                                             |
|         | Filling               |                                |                                            |      |      |                                            |                                             |
|         |                       |                                |                                            |      |      |                                            |                                             |
|         | Stock                 | ArrayList<Product> stock       |                                            |      |      |                                            |                                             |
|         |                       |                                | ArrayList<Product> getStock()              | x    | x    |                                            |                                             |
|         |                       |                                | boolean addStock(Product product)          | x    | x    |                                            |                                             |
|         |                       |                                | boolean removeStock()                      | x    | x    |                                            |                                             |
|         |                       |                                | boolean inStock(Product product)           | x    | x    |                                            |                                             |
|         | Basket                | ArrayList<Product> basketItems |                                            |      |      |                                            |                                             |
|         |                       | int basketLimit                |                                            |      |      |                                            |                                             |
|         |                       |                                | void addProduct(Product product)           |      |      |                                            |                                             |
|         |                       |                                | void removeProduct(Product product)        |      |      |                                            |                                             |
|         |                       |                                | boolean inBasket()                         | x    |      |                                            |                                             |
|         |                       |                                | HashMap<Product, Integer> getBasketItems() | x    |      |                                            |                                             |
|         |                       |                                | boolean isBasketFull()                     | x    |      |                                            |                                             |
|         |                       |                                | void setCapacity(int basketLimit)          | x    |      |                                            |                                             |
|         |                       |                                |                                            |      |      |                                            |                                             |
|         | Checkout              | ArrayList<Predicate> discounts |                                            |      |      |                                            |                                             |
|         |                       | Inventory inventory            |                                            |      |      |                                            |                                             |
|         |                       |                                | double sumPrice(ArrayList<Product>)        |      |      |                                            |                                             |
|         |                       |                                | void order(Basket basket)                  |      |      |                                            |                                             |
|         |                       |                                |                                            |      |      |                                            |                                             |
|         | (Interface) Inventory |                                | addProduct(Product product)                |      |      |                                            |                                             |
|         |                       |                                | removeProduct(Product product)             |      |      |                                            |                                             |
|         |                       |                                | boolean inInventory                        |      |      |                                            |                                             |

### User Stories
```
1. x
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

```
2. x
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

```
3. x
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

```
4. x 
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

```
5. x
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
As a customer, x
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