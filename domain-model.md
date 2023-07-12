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

## DOMAIN MODEL

| Class            | Attributes    | Methods | Scenario | Outputs |
|------------------|---------------|---------|----------|---------|
| Abstract Product | SKU: String   |         |          |         |
|                  | price: double |         |          |         |

| Class                 | Attributes              | Methods                             | Scenario                                             | Outputs |
|-----------------------|-------------------------|-------------------------------------|------------------------------------------------------|---------|
| Bagel extends Product | variant: BagelVariant   | getPriceWithFillings(): double      | calculates totals price including all added fillings | double  |
|                       | fillings: List<Filling> | addFilling(Filling filling):boolean | If filling added correctly                           | true    |
|                       |                         |                                     | If filling added incorrectly                         | false   |

| Class                   | Attributes              | Methods | Scenario | Outputs |
|-------------------------|-------------------------|---------|----------|---------|
| Filling extends Product | variant: FillingVariant |         |          |         |

| Class                  | Attributes             | Methods | Scenario | Outputs |
|------------------------|------------------------|---------|----------|---------|
| Coffee extends Product | variant: CoffeeVariant |         |          |         |

| Class  | Attributes              | Methods                                      | Scenario                                                | Outputs |
|--------|-------------------------|----------------------------------------------|---------------------------------------------------------|---------|
| Basket | products: List<Product> | addProduct(Product product): boolean         | product added successfully                              | true    |
|        | capacity: int           |                                              | adding product failed                                   | false   |
|        |                         | isFull(): boolean                            | if products.size == capacity                            | true    |
|        |                         |                                              | if products.size < capacity                             | false   |
|        |                         | isProductInBasket(Product product): boolean  | if basket contains product                              | true    |
|        |                         |                                              | if basket doesn't contains product                      | false   |
|        |                         | summarizeBasket(): double                    | summarize all products with optional fillings in basket | double  |
|        |                         | isProductAvailable(Product product): boolean | if product is in Bob's inventory                        | true    |
|        |                         |                                              | if product isn't in Bob's inventory                     | false   |

| Class         | Attributes       | Methods | Scenario | Outputs |
|---------------|------------------|---------|----------|---------|
| Abstract User | fullName: String |         |          |         |

| Class                 | Attributes     | Methods | Scenario | Outputs |
|-----------------------|----------------|---------|----------|---------|
| Customer extends User | basket: Basket |         |          |         |

| Class   | Attributes | Methods                            | Scenario | Outputs |
|---------|------------|------------------------------------|----------|---------|
| Manager |            | checkProductPrice(Product product) |          |         |

| Class | Attributes                       | Methods                                     | Scenario                    | Outputs |
|-------|----------------------------------|---------------------------------------------|-----------------------------|---------|
| Store | availableProducts:List<Products> | isProductAvailable(Product product):boolean | if product is available     | true    |
|       |                                  | isProductAvailable(Product product):boolean | if product is not available | false   |