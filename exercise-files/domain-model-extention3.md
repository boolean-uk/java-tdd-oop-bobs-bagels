# User Stories

```
As a member of the public,
So I can see my savings,
I'd like to see the total discount on the receipt
```

# Domain Model

| Class          | Method         | Return value           | Class variable                | Description                                                     |
|----------------|----------------|------------------------|-------------------------------|-----------------------------------------------------------------|
| ReceiptPrinter | print()        | String                 | Store store<br/>Basket basket | Returns the receipt (with the discount) in the form of a string |

