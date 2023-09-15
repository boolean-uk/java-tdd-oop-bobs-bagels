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

| Class     | Method                                        | Attributes                                    | Scenario                                           | Outcome                          |
|-----------|-----------------------------------------------|-----------------------------------------------|----------------------------------------------------|----------------------------------|
| Product   | getType()                                     | String type                                   | Get the product type                               | String                           |
|           | getCost()                                     | int cost                                      | Get the product cost                               | int                              |   
|           | getSku()                                      | String sku                                    | Get the product sku                                | String                           |
|           | toString()                                    |                                               | Get string representation of product               | String                           |
| Bagel     | getType()                                     | String type                                   | 7. Get the bagel type                              | String                           |
|           | getCost()                                     | int cost                                      | Get the bagel cost                                 | int                              |
|           | getSku()                                      | String sku                                    | Get the bagel sku                                  | String                           |
|           | addFilling(Filling filling)                   | Filling filling                               | 8. Choose filling for my bagel:                    |                                  |
|           |                                               |                                               | - If filling does not exist                        | True                             |
|           |                                               |                                               | - If filling exists                                | False                            |
| Filling   | getType()                                     | String type                                   | Get the filling type                               | String                           |
|           | getCost()                                     | int cost                                      | 9. Get the filling cost                            | int                              |
|           | getSku()                                      | String sku                                    | Get the filling sku                                | String                           |
| Coffee    | getType()                                     | String type                                   | Get the coffee type                                | String                           |
|           | getCost()                                     | int cost                                      | Get the coffee cost                                | int                              |
|           | getSku()                                      | String sku                                    | Get the coffee sku                                 | String                           |
| Basket    | addProduct(String type)                       | ArrayList<Product> products, int capacity     | 1,3. Add product to basket:                        |                                  |
|           |                                               |                                               | - If capacity not max                              | True, Add product to basket      |
|           |                                               |                                               | - If capacity is max                               | False, Print Message             |
|           | removeProduct(String type)                    |                                               | 2,5. Remove product from basket:                   |                                  |
|           |                                               |                                               | - If product exists                                | True, Product removed            |
|           |                                               |                                               | - If product doesn't exist                         | False, Print Message             |
|           | setCapacity(int newCapacity)                  |                                               | 4. Expand business -> bigger capacity:             |                                  |
|           |                                               |                                               | - If newCapacity > oldCapacity                     | True, Capacity changes           |
|           |                                               |                                               | - Otherwise                                        | False, Print Message             |
|           | getTotalCost()                                |                                               | 6. Find the cost of products in basket:            |                                  |
|           |                                               |                                               | - If basket is empty:                              | 0, Print Message                 |
|           |                                               |                                               | - If basket is not empty                           | int                              |
| Inventory | searchProduct(String productName)             | HashMap<String, String> namesToSkus           | Look for product in the shop inventory:            |                                  |
|           |                                               |                                               | - If product in inventory                          | String (which is the SKU)        |
|           |                                               |                                               | - If product not in inventory                      | null                             |
|           | getProductByName(String productName)          | LinkedHashMap<String, Product> SkusToProducts | Get product from the shop inventory: (uses search) |                                  |
|           |                                               |                                               | - If SKU exists                                    | Product                          |
|           |                                               |                                               | - If SKU does not exist                            | null                             |
|           | addNewProduct(Product product)                |                                               | Add product to inventory:                          |                                  |
|           |                                               |                                               | - If product already exists / sku format error     | False,                           |
|           |                                               |                                               | - Otherwise                                        | True, Product added to inventory |
|           | getProductList()                              |                                               | Get a list of all the products                     | String                           |
|           | populateBaseData(File file)                   | HashMap<String, String> baseProducts          | Load base skus of products from a file             | No Return Value                  |
|           | loadProducts(File file)                       |                                               | Read products from file and add them to inventory  | No Return Value                  |
|           | constructProductName(String sku, String type) |                                               | Create a product name based on base skus + type:   |                                  |
|           |                                               |                                               | - If sku format has error                          | null                             |
|           |                                               |                                               | - Otherwise                                        | String                           |
