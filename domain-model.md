| Classes     | Members                    | Methods/Scenario                                       | Outputs                                                  |
|-------------|----------------------------|--------------------------------------------------------|----------------------------------------------------------|
| BagelBasket | - items: List<BasketItem>  | + addBasketItem(item: BasketItem): boolean             | Item added successfully (true)                           |
|             | - capacity: int            | + removeBasketItem(item: BasketItem): boolean          | Item removed successfully (true)                         |
|             |                            | + isBasketFull(): boolean                              | Basket is full (true/false)                              |
|             |                            | + getTotalCost(): int                                  | Total cost of items in the basket                        |
|             |                            | + changeBasketCapacity(newCapacity: int): boolean<br/> | Basket capacity changed successfully (true)              |
| Bagel       | - type: String             | + getCost(): int                                       | Cannot reduce capacity below current basket size (false) |
|             | - fillings: List<Fillings> | + isInStock(): boolean                                 | Cost of the bagel                                        |
|             |                            |                                                        | List of fillings for the bagel                           |
|             |                            |                                                        | Bagel is in stock (true/false)                           |


| Classes        | Members                            | Methods/Scenario                      | Output                           |
|----------------|------------------------------------|---------------------------------------|----------------------------------|
| Fillings       | - type: String                     | + getCost(): int                      | Cost of the filling              |
|                |                                    | + isInStock(): boolean                | Filling is in stock (true/false) |
|                |                                    |                                       |                                  |
| Product        | - sku: String                      | + getCost(): int                      | Cost of the product              |
|                | - price: double                    | + isInStock(): boolean                | Product is in stock (true/false) |
|                | - name: String                     |                                       |                                  |
|                | - variant: String                  |                                       |                                  |
| BagelInventory | - availableProducts: List<Product> | + isInStock(item: StockItem): boolean | Item is in stock (true/false)    |
| BagelOrder     | - items: List<BasketItem>          | + getTotalCost(): int                 | Total cost of items in the order |
