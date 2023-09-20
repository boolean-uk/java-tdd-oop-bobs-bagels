# Goal
Design a domain model from the following user stories before developing the application.

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

### Domain Model

| Class              | Method                                        | Attributes                                    | Scenario                                                | Outcome                                    |
|--------------------|-----------------------------------------------|-----------------------------------------------|---------------------------------------------------------|--------------------------------------------|
| Product (Abstract) | getType()                                     | String type                                   | Get the product type                                    | String                                     |
|                    | getCost()                                     | double cost                                   | Get the product cost                                    | double                                     |   
|                    | getSku()                                      | String sku                                    | Get the product sku                                     | String                                     |
|                    | toString()                                    |                                               | Get string representation of product                    | String                                     |
|                    | equals(Object obj), hashCode                  |                                               | Methods used to compare objects of this class           |                                            |
| Bagel              | Inherited from Product                        | Inherited from Product                        |                                                         |                                            |
|                    | getCost()                                     | double cost                                   | 7. Get the bagel cost                                   | double                                     |
| Filling            | Inherited from Product                        | Inherited from Product                        |                                                         |                                            |
|                    | getCost()                                     | double cost                                   | 9. Get the filling cost                                 | double                                     |
| Coffee             | Inherited from Product                        | Inherited from Product                        |                                                         |                                            |
| Basket             | addProduct(Product product)                   | HashMap<Product, Integer> items, int capacity | 1,3,8. Add product to basket:                           |                                            |
|                    |                                               |                                               | - If capacity not max                                   | True, Add product to basket                |
|                    |                                               |                                               | - If capacity is max                                    | False, Print Message                       |
|                    | removeProduct(Product product)                |                                               | 2,5. Remove product from basket:                        |                                            |
|                    |                                               |                                               | - If product exists                                     | True, Product removed / quantity decreased |
|                    |                                               |                                               | - If product doesn't exist                              | False                                      |
|                    | setCapacity(int newCapacity)                  |                                               | 4. Expand business -> bigger capacity:                  |                                            |
|                    |                                               |                                               | - If newCapacity > oldCapacity                          | True, Capacity changes                     |
|                    |                                               |                                               | - Otherwise                                             | False, Print Message                       |
|                    | getTotalCost()                                |                                               | 6. Find the cost of products in basket:                 |                                            |
|                    |                                               |                                               | - If basket is empty:                                   | 0                                          |
|                    |                                               |                                               | - If basket is not empty                                | double                                     |
|                    | getCapacity()                                 |                                               | Get basket's capacity                                   | int                                        |
|                    | getSize()                                     |                                               | Get basket's current items' quantity                    | int                                        |
|                    | showProducts()                                |                                               | Get all basket's products + prices per product variant: |                                            |
|                    |                                               |                                               | - If basket is empty:                                   | String ("Basket is empty.")                |
|                    |                                               |                                               | - Otherwise:                                            | String with products + prices              |
| Inventory          | searchProduct(String productName)             | HashMap<String, String> namesToSkus           | Look for product in the shop inventory:                 |                                            |
|                    |                                               |                                               | - If product in inventory                               | String (which is the SKU)                  |
|                    |                                               |                                               | - If product not in inventory                           | null                                       |
|                    | getProductByName(String productName)          | LinkedHashMap<String, Product> SkusToProducts | 10. Get product from the shop inventory: (uses search)  |                                            |
|                    |                                               |                                               | - If SKU exists                                         | Product                                    |
|                    |                                               |                                               | - If SKU does not exist                                 | null                                       |
|                    | addNewProduct(Product product)                |                                               | Add product to inventory:                               |                                            |
|                    |                                               |                                               | - If product already exists / sku format error          | False,                                     |
|                    |                                               |                                               | - Otherwise                                             | True, Product added to inventory           |
|                    | getProductList()                              |                                               | Get a list of all the products                          | String                                     |
|                    | populateBaseData(File file)                   | HashMap<String, String> baseProducts          | Load base skus of products from a file                  | No Return Value                            |
|                    | loadProducts(File file)                       |                                               | Read products from file and add them to inventory       | No Return Value                            |
|                    | constructProductName(String sku, String type) |                                               | Create a product name based on base skus + type:        |                                            |
|                    |                                               |                                               | - If sku format has error                               | null                                       |
|                    |                                               |                                               | - Otherwise                                             | String                                     |
