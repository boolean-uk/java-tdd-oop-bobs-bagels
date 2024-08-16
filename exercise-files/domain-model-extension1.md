# User Stories

```
As the owner of the store,
So that i can charge the customers the correct amount,
I'd like to calculate the discount of a given basket
```

# Domain Model

| Class           | Method                           | Return value | Class variable          | Description                                                 |
|-----------------|----------------------------------|--------------|-------------------------|-------------------------------------------------------------|
| Basket          | getTotalCost()                   | double       | ArrayList\<Item> basket | Gets the correct total of the basket with discounts applied |
| DiscountManager | getBasketDiscount(Basket basket) | double       |                         | Calculates the discount of the basket                       |
