| Class  | Field                                  | Method                                        | Condition                                                                                 | Output                           |
|--------|----------------------------------------|-----------------------------------------------|-------------------------------------------------------------------------------------------|----------------------------------|
| Basket | Hashmap<String, Integer> productsCount | boolean add(String productSku, int amount)    | if there are less products in total than capacity                                         | true                             |
|        |                                        |                                               | if there are more products in total than capacity or the productSKu is N/A or amount <= 0 | false                            |
|        | int capacity                           |                                               |                                                                                           |                                  |
|        | int currentAmountOfProducts            | boolean remove(String productSku, int amount) | if the amount of products of sku in basket is >= amount                                   | true                             |
|        |                                        |                                               | if the amount of products of sku in basket is < amount or amount <= 0                     | false                            |
|        |                                        | boolean changeCapacity(int newCapacity)       | if newCapacity >= currentAmount                                                           | true                             |
|        |                                        |                                               | if newCapacity < currentAmount                                                            | false                            |
|        |                                        | double totalCost()                            | always                                                                                    | total cost of products in basket |
|        |                                        | double checkCostOfProduct(String productSku)  | always                                                                                    | cost of product by sku           |


| Class   | Field          | Method | Condition | Output |
|---------|----------------|--------|-----------|--------|
| Product | String sku     |        |           |        |
|         | double price   |        |           |        |
|         | String name    |        |           |        |
|         | String variant |        |           |        |


| Class     | Field                                | Method                                                                        | Condition | Output |
|-----------|--------------------------------------|-------------------------------------------------------------------------------|-----------|--------|
| Inventory | Hashmap<String, Product> products    | getDiscount(String productSku, HashMap<String, Integer> basketProducts)       |           | int    |
|           | Hashmap<String, Discount> discounts  | getCoffeeDiscount(String coffeeSKU,  HashMap<String, Integer> basketProducts) |           | int    |


| Class    | Field                      | Method | Condition | Output |
|----------|----------------------------|--------|-----------|--------|
| Discount | int discountPackSize       |        |           |        |
|          | int packPriceAfterDiscount |        |           |        |
