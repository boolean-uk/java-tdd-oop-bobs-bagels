
```
As the owner of the store,
So that i can charge the customers the correct amount,
I'd like to calculate the discount of a given basket
```

| Classes         | member variables                             | Methods                                                       | Scenario                                    | Output        |
|-----------------|----------------------------------------------|---------------------------------------------------------------|---------------------------------------------|---------------|
| DiscountManager | List<Product> basket                         | applyDiscount(Basket basket)                                  | Applies discount if applicable to the total | return double |
|                 | int amount<br/> string sku<br/> double price | CalculateFinalDiscount(String sku, int amount, double price)  | Helper method for applyDiscount             | return double |