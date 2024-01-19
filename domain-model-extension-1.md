## Domain Model Extension 1

```
1.  As a customer, 
    so I can save money, 
    I want to make use of current discounts if my basket is valid for it


2.  As the shop owner,
    so that I can make money,
    I want to make sure that a customer can only use one discount per purchase
```

| Classes | Methods            | Scenario               | Returns                     |
|---------|--------------------|------------------------|-----------------------------|
| Basket  | double totalCost() | Discount is active     | double adjusted to discount |
|         |                    | Discount is not active | double no adjustments       |


```
3.  As a customer,
    so that I can get my items and leave, 
    I want to be able to checkout my basket 
```

| Classes | Methods                           | Scenario               | Returns |
|---------|-----------------------------------|------------------------|---------|
| Shop    | boolean checkoutBasket(int index) | If valid index         | true    |
|         |                                   | If index out of bounds | false   |
