# Domain model

Assuming that

- A bagel can only have 0 or 1 filling
- Maximum of one discount type per basket/order. E.g. if basket has 2 bagel and 2 coffees, then there 
will only be one "Coffee & Bagel for 1.25" discount.

## User Stories for extension

```
11.
As the store owner,
So I can attract more customers,
I'd like to add discounts.
```

```
12.
As a member of the public,
So I can know how much money to spend,
I'd like to know the price of my basket, including potential discounts.
```

```
13.
As a member of the public,
So I can bookkeep my purchases,
I'd like to be able to get receipts for my purchases from Bob's Bagels.
```

Receipt class:

| Member variables                           | Methods                                            | Scenario                                          | Outputs                         |
|--------------------------------------------|----------------------------------------------------|---------------------------------------------------|---------------------------------|
| `ArrayList<Discount>`, `ArrayList<Prodct>` | `Receipt(ArrayList<Discount>, ArrayList<Product>)` | `When checout is successful a receipt is created` | `a new receipt`                 |
| `-`                                        | `getReceipt()`                                     | `wants to print out receipt in console`           | `this receipt object as string` |

Checkout class:

| Member variables | Methods                              | Scenario                                                        | Outputs                                        |
|------------------|--------------------------------------|-----------------------------------------------------------------|------------------------------------------------|
| `currentBasket`  | `checkIfApplies(ArrayList<Product>)` | `After a product has been added to basket, check for discounts` | `A new receipt object for this purchase/order` |

Discount class:

| Member variables | Methods                              | Scenario                                                        | Outputs                            |
|------------------|--------------------------------------|-----------------------------------------------------------------|------------------------------------|
| `-`              | `checkIfApplies(ArrayList<Product>)` | `After a product has been added to basket, check for discounts` | `true, a discount applies`         |
|                  |                                      |                                                                 | `false, a discount does not apply` |

Inventory class:

| Member variables            | Methods                             | Scenario                            | Outputs |
|-----------------------------|-------------------------------------|-------------------------------------|---------|
| `HashMap<Product, Integer>` | `productIsInStock(Product product)` | `The given product is in stock`     | `true`  |
|                             |                                     | `The given product is not in stock` | `false` |

Basket class:

| Member variables                            | Methods                                              | Scenario                                                                           | Outputs |
|---------------------------------------------|------------------------------------------------------|------------------------------------------------------------------------------------|---------|
| `ArrayList<Product>`                        | `add(Product product)`                               | Successfully product added to basket                                               | true    |
| `ArrayList<Product>`                        | `remove(Product product)`                            | Successfully removed from basket                                                   | true    |
|                                             |                                                      | Failed to remove from basket                                                       | false   |
|                                             | `isFull()`                                           | Basket is full                                                                     | true    |
|                                             |                                                      | Basket is not full                                                                 | false   |
| `maxCapacity`                               | `changeCapacity(int newCapacity, boolean isManager)` | Successfully changed capacity of baskets                                           | true    |
|                                             |                                                      | Failed to change capacity of baskets (e.g., is not manager)                        | false   |
| `ArrayList<Product>`                        | `getTotalCost()`                                     | there is atleast one product in the basket                                         | double  |
|                                             |                                                      | there are no products in the basket                                                | 0       |
| `ArrayList<Product>`, `ArrayList<Discount>` | `checkDiscounts(Product p)`                          | a product was added to the basket and it should be checked for potential discounts | -       |

Product class:

| Member variables | Methods      | Scenario                                        | Outputs  |
|------------------|--------------|-------------------------------------------------|----------|
| `price`          | `getPrice()` | `A customer wants to know this product's price` | `double` |

Bagel class:

| Member variables | Methods                          | Scenario                                    | Outputs        |
|------------------|----------------------------------|---------------------------------------------|----------------|
| `currentFilling` | `setFilling(Filling newFilling)` | `A customer chooses a filling successfully` | `true/success` |
|                  |                                  | `Filling already exists on the bagel`       | `false/fail`   |
