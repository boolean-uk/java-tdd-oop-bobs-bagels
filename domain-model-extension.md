| Class   | Field        | Method            | Condition | Output  |
|---------|--------------|-------------------|-----------|---------|
| Bargain | int packSize | bargain6Bagels()  |           | Bargain |
|         | int packCost | bargain12Bagels() |           | Bargain |


| Class  | Field                                  | Method                                        | Condition                                                                                 | Output |
|--------|----------------------------------------|-----------------------------------------------|-------------------------------------------------------------------------------------------|--------|
| Basket | Hashmap<String, Integer> productsCount | boolean add(String productSKU, int amount)    | if there are less products in total than capacity                                         | true   |
|        | int capacity                           |                                               | if there are more products in total than capacity or the productSKU is N/A or amount <= 0 | false  |
|        | int currentAmountOfProducts            | boolean remove(String productSKU, int amount) | if the amount of products of sku in basket is >= amount                                   | true   |
|        |                                        |                                               | if the amount of products of sku in basket is < amount or amount <= 0                     | false  |
|        |                                        | boolean changeCapacity(int newCapacity)       | if newCapacity >= currentAmount                                                           | true   |
|        |                                        |                                               | if newCapacity < currentAmount                                                            | false  |
|        |                                        | void clearBasket()                            |                                                                                           | void   |


| Class    | Field                              | Method                                                       | Condition | Output                              |
|----------|------------------------------------|--------------------------------------------------------------|-----------|-------------------------------------|
| Checkout | HashMap<String, Integer> costs     | static int getProductsCost(String productSKU, int quantity)  |           | products cost without discounts     |
|          | HashMap<String, Integer> amounts   | static double countBasketCostWithoutDiscounts(Basket basket) |           | basket total cost without discounts |
|          | HashMap<String, Integer> discounts | static double countBasketCostWithDiscounts(Basket basket)    |           | basket total cost with discounts    |
|          | double totalCost                   | Receipt getReceipt()                                         |           | receipt object                      |
|          | double totalDiscount               |                                                              |           |                                     |
|          | Basket basket                      |                                                              |           |                                     |


| Class              | Field                     | Method                                            | Condition | Output                   |
|--------------------|---------------------------|---------------------------------------------------|-----------|--------------------------|
| CombinationBargain | String name               | static List<CombinationBargain> coffeePlusBagel() |           | List<CombinationBargain> |
|                    | List<String> productsSKUs |                                                   |           |                          |
|                    | int price                 |                                                   |           |                          |


| Class     | Field                                               | Method                                                  | Condition                   | Output                            |
|-----------|-----------------------------------------------------|---------------------------------------------------------|-----------------------------|-----------------------------------|
| Inventory | static Hashmap<String, Product> products            | static List<Bargain> getBargains(String productSKU)     | if product not on any sale  | empty List<Bargain>               |
|           | static List<CombinationBargain> combinationBargains |                                                         | if product on sale          | List<Bargain>                     |
|           | static HashMap<String, List<Bargain>> bargains      | static boolean productNotInInventory(String productSKU) | if product not in inventory | true                              |
|           |                                                     |                                                         | if product in inventory     | false                             |
|           |                                                     | static int checkCostOfTheProduct(String productSKU)     | if product in inventory     | product price                     |
|           |                                                     |                                                         | if product not in inventory | 0                                 |
|           |                                                     | static Product getProduct(String productSKU)            | if product in inventory     | Product                           |
|           |                                                     |                                                         | if product not in inventory | null                              |
|           |                                                     | static String getProductDescription(String productSKU)  | if product in inventory     | variant + name, np. "Onion Bagel" |
|           |                                                     |                                                         | if product not in inventory | productSKU                        |


| Class   | Field          | Method | Condition | Output |
|---------|----------------|--------|-----------|--------|
| Product | String sku     |        |           |        |
|         | double price   |        |           |        |
|         | String name    |        |           |        |
|         | String variant |        |           |        |


| Class   | Field                              | Method                                | Condition                        | Output   |
|---------|------------------------------------|---------------------------------------|----------------------------------|----------|
| Receipt | HashMap<String, Integer> costs     | double getDiscount(String productSKU) | if product discount in discounts | discount |
|         | HashMap<String, Integer> amounts   |                                       | if no discount for product       | 0        |
|         | HashMap<String, Integer> discounts | double getCost(String productSKU)     | if product cost in costs         | cost     |
|         | double totalCost                   |                                       | if product cost not in costs     | 0        |
|         | double totalDiscount               | int getQuantity(String productSKU)    | if product amount in amounts     | quantity |
|         | LocalDateTime creationDate         |                                       | if product amount not in amounts | 0        |


| Class            | Field | Method                                  | Condition | Output            |
|------------------|-------|-----------------------------------------|-----------|-------------------|
| ReceiptGenerator |       | String generateReceipt(Receipt receipt) |           | formatted receipt |
|                  |       |                                         |           |                   |
