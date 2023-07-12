# Domain Model

| Classes | Members        | Methods | Scenario | Outputs |
|---------|----------------|---------|----------|---------|
| Product | String sku     |         |          |         |
|         | double price   |         |          |         |
|         | String name    |         |          |         |
|         | String variant |         |          |         |
|         |                |         |          |         |

| Classes | Members         | Methods                        | Scenario                                          | Outputs |
|---------|-----------------|--------------------------------|---------------------------------------------------|---------|
| Bagel   | String sku      | chooseFilling(Product product) | if name of product equals "Filling" add to basket | String  |
|         | double price    | chooseFilling(String variant)  | if name of variant does not exist print message   | String  |
|         | String name     |                                |                                                   |         |
|         | String variant  |                                |                                                   |         |
|         | Product filling |                                |                                                   |         |

| Classes   | Members                     | Methods                                                 | Scenario                         | Outputs |
|-----------|-----------------------------|---------------------------------------------------------|----------------------------------|---------|
| Inventory | List<Product> inventoryList | getProductBySKU(String sku)                             | if sku exists                    | Product |
|           |                             |                                                         | if sku does not exist            | null    |
|           |                             | getProductByNameAndVariant(String name, String variant) | if name and variant exists       | Product |
|           |                             |                                                         | if name and variant do not exist | null    |
|           |                             | getPriceBySKU(String sku)                               | if sku exists                    | double  |
|           |                             |                                                         | if sku does not exist            | 0.00    |
|           |                             | getPriceByNameAndVariant(String name, String variant)   | if name and variant exists       | double  |
|           |                             |                                                         | if name and variant do not exist | 0.00    |

| Classes | Members                              | Methods                                         | Scenario                                                                                               | Outputs |
|---------|--------------------------------------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------|---------|
| Basket  | int capacity                         | addProduct(Product product)                     | if capacity is not full add product                                                                    | String  |
|         | HashMap<Product, Integer> basketList |                                                 | if capacity is full                                                                                    | String  |
|         | int productsQuantity                 | addProduct(Product product, int quantity)       | if capacity is less than quantity of this product return message                                       | String  |
|         |                                      | addProduct(String sku)                          |                                                                                                        |         |
|         |                                      | addProduct(String sku, int quantity)            |                                                                                                        |         |
|         |                                      | addBagelByVariant(String variant)               | if variant exists and name equals "Bagel" add bagel                                                    | String  |
|         |                                      |                                                 | if variant doesn't exist or name is not equal to "Bagel"                                               | String  |
|         |                                      | addBagelByVariant(String variant, int quantity) |                                                                                                        |         |
|         |                                      | removeProduct(Product product)                  | if product is in basket remove product from basket                                                     | String  |
|         |                                      |                                                 | if product is not in basket                                                                            | String  |
|         |                                      | removeProduct(Product product, int quantity)    |                                                                                                        |         |
|         |                                      | removeProduct(String sku)                       |                                                                                                        |         |
|         |                                      | removeProduct(String sku, int quantity)         |                                                                                                        |         |
|         |                                      | isOverfilled()                                  | if basket is full                                                                                      | true    |
|         |                                      |                                                 | if basket is not full                                                                                  | false   |
|         |                                      | changeCapacity(int newSize)                     | change size if new capacity is bigger than previous one                                                | String  |
|         |                                      |                                                 | if new capacity is smaller than previous check if quantity of products <= new capacity                 | String  |
|         |                                      |                                                 | if new capacity is smaller than previous check if quantity of products > new capacity and don't change | String  |
|         |                                      | totalCost()                                     | count cost of whole basket                                                                             | double  |
|         |                                      | checkPrice(Product product)                     | check price of given product                                                                           | double  |
|         |                                      | checkPrice(String sku)                          |                                                                                                        |         |
|         |                                      | checkIfProductInInventory(Product product)      | if product in inventory                                                                                | true    |
|         |                                      | checkIfProductInInventory(String sku)           | if product not in inventory                                                                            | false   |
