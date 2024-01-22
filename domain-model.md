Basket

| Methods                                  | Members                    | Scenario                                                                                                | Output                                                             |
|------------------------------------------|----------------------------|---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| add(Item item)                           | ArrayList\<Item> items     | Customer wants to add an existing item to the basket when it's not full                                 | void                                                               |
| remove(Item item)                        |                            | Customer wants to remove a bagel with specified fillings that there exists one or more of in the basket | true                                                               |
|                                          |                            | Customer wants to remove a bagel with specified fillings that doesn't exist in the basket               | false                                                              |


Bagel

| Members                      |
|------------------------------|
| ArrayList\<Filling> fillings |
| String name,<br/>String sku  |

Coffee

| Members                      |
|------------------------------|
| String name,<br/>String sku  |

Filling

| Members                      |
|------------------------------|
| String name,<br/>String sku  |


Item

| Methods              | Members     | Scenario | Output  |
|----------------------|-------------|----------|---------|
| containsOtherItems() | String name |          | boolean |
| getContainedItems()  |             |          | null    |

Store

| Methods                                       | Members                           | Scenario                                                                                        | Output                                         |
|-----------------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|------------------------------------------------|
| createBasket()                                | HashMap\<Integer, Basket> baskets | Customer wants to shop                                                                          | A basket id as an int                          |
| getCostOfBasket(int basketId)                 | Inventory inventory               | Customer wants to know the cost of their basket                                                 | cost as a double                               |
| getCostOfItem(Item item)                      |                                   | Customer wants to know the cost of an existing item                                             | cost as a double                               |
|                                               |                                   | Customer wants to know the cost of a non-existing item                                          | -1                                             |
| addItemToBasket(Item item, int basketId)      | int basketCapacity                | Customer wants to add an existing item to the basket when it's not full                         | item.toString() + " added."                    |
|                                               |                                   | Customer wants to add an existing item to the basket when it's full                             | "You're basket is full!"                       |
|                                               |                                   | Customer wants to add a item that doesn't exist                                                 | this.name +" doesn't carry " + item.toString() |
| updateBasketCapacity(int newCapacity)         |                                   | Updating the capacity to a number higher or equal to the current items in all basket            | true                                           |
|                                               |                                   | Updating the capacity to a number lower than the current number of items in at least one basket | false                                          |
| removeItemFromBasket(Item item, int basketId) |                                   | Customer wants to remove an existing item from their basket                                     | true                                           |
|                                               |                                   | Customer wants to remove a non-existent item from their basket                                  | false                                          |
| createReceipt(int basketId)                   | String name                       | Customer wants to have a receipt of their purchase                                              | Receipt object of the purchase                 |

Inventory

| Methods                                   | Members                                                                                                                                                | Scenario                                                  | Output                          |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------|---------------------------------|
| getCostOfBasket(Basket basket)            | HashMap\<String, Double> prices<br/> double TWELWE_BAGELS_DISCOUNT_PRICE,<br/>double SIX_BAGELS_DISCOUNT_PRICE, <br/> double COFFEE_AND_BAGEL_DISCOUNT | Customer wants to know the cost of their basket           | cost as a double                |
| getCostOfItem(Item item)                  | HashMap\<Item, String> itemCodes                                                                                                                       | Customer wants to know the cost of an existing item       | cost as a double                |
|                                           |                                                                                                                                                        | Customer wants to know the cost of a non-existing item    | -1                              |
| hasItem(Item item)                        |                                                                                                                                                        | Customer wants to add an existing item to their basket    | true                            |
|                                           |                                                                                                                                                        | Customer wants to add a non-existing item to their basket | false                           |
| getCostForBundle(Item item, int quantity) |                                                                                                                                                        | Customer wants to know about possible discounts           | cost for the bundle as a double |

Receipt

| Members                                   |
|-------------------------------------------|
| Date date                                 |
| HashMap<String, Double> prices            |
| LinkedHashMap<String, Integer> quantities |
| double totalCost                          |
| String storeName                          |
| int width                                 |


Discount

| Members      |
|--------------|
| Double cost  |
| int quantity |


