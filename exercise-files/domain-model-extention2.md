# User Stories

```
As a member of the public,
So I can keep track of my purchases,
I'd like to receive a printed receipt
```

# Domain Model

| Class          | Method         | Return value           | Class variable                | Description                                     |
|----------------|----------------|------------------------|-------------------------------|-------------------------------------------------|
| Basket         | getItemCount() | HashMap<Item, Integer> | ArrayList<Item> basket        | Gets the count of different items in the basket |
| ReceiptPrinter | print()        | String                 | Store store<br/>Basket basket | Returns the receipt in the form of a string     |

