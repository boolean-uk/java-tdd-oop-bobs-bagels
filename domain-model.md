Basket

| Methods                                               | Members                  | Scenario                                                                                                | Output                                                             |
|-------------------------------------------------------|--------------------------|---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| addBagel(String bagel)                                | ArrayList\<Bagel> bagels | Customer wants to add an existing bagel to the basket when it's not full                                | "Bagel added."                                                     |
|                                                       | int noOfBagels           | Customer wants to add an existing bagel to the basket when it's full                                    | "You're basket is full!"                                           |
| removeBagel(String bagel, ArrayList\<String> fillings) |                          | Customer wants to remove a bagel with specified fillings that there exists one or more of in the basket | true                                                               |
|                                                       |                          | Customer wants to remove a bagel with specified fillings that doesn't exist in the basket               | false                                                              |
| addFilling(String filling, String bagel)              |                          | Customer wants to add a filling to an existing bagel in their basket                                    | "Filling added."                                                   |
|                                                       |                          | Customer wants to add a filling to a bagel that doesn't exist in the basket                             | "Your basket doesn't contain that bagel."                          |
|                                                       |                          | Customer wants to add a filling to a bagel in their basket that already has that filling                | "All bagels of that kind in your basket already has that filling." |

Bagel

| Methods                     | Members                    | Scenario                                                                | Output                                                             |
|-----------------------------|----------------------------|-------------------------------------------------------------------------|--------------------------------------------------------------------|
| addFilling(String filling)  | ArrayList\<String> fillings | Customer wants to add a filling that doesn't already exist on the bagel | true                                                               |
|                             |                            | Customer wants to add a filling that already exist on the bagel         | false                                                              |


Store 

| Methods                                                   | Members                             | Scenario                                                                                        | Output                                    |
|-----------------------------------------------------------|-------------------------------------|-------------------------------------------------------------------------------------------------|-------------------------------------------|
| createBasket()                                            | ArrayList\<Integer, Basket> baskets  | Customer wants to shop                                                                          | A basket index                            |
| getCost(int basketIndex)                                  | Inventory inventory                 | Customer wants to know the cost of their basket                                                 | cost as a double                          |
| getCostOfBagel(String bagel)                              |                                     | Customer wants to know the cost of a bagel                                                      | cost as a double                          |
| getCostOfFilling(String bagel)                            |                                     | Customer wants to know the cost of a filling                                                    | cost as a double                          |
| addBagelToBasket(String bagel, int basketIndex)           | int basketCapacity                  | Customer wants to add an existing bagel to the basket when it's not full                        | "Bagel added."                            |
|                                                           |                                     | Customer wants to add an existing bagel to the basket when it's full                            | "You're basket is full!"                  |
|                                                           |                                     | Customer wants to add a bagel that doesn't exist                                                | "Bob's bagels doesn't have that bagel."   |
| addFilling(String filling, String bagel, int basketIndex) |                                     | Customer wants to add a filling that doesn't exist in the inventory                             | "Bob's bagels doesn't have that filling." |
|                                                           |                                     | Customer wants to add an existing filling to a bagel that doesn't exist in the basket           | "Your basket doesn't contain that bagel." |
|                                                           |                                     | Customer wants to add an existing filling to an existing bagel in their basket                  | "Filling added."                          |
| updateCapacity(int newCapacity)                           |                                     | Updating the capacity to a number higher or equal to the current items in all basket            | true                                      |
|                                                           |                                     | Updating the capacity to a number lower than the current number of items in at least one basket | false                                     |

Inventory 

| Methods                | Members                         | Scenario                                        | Output           |
|------------------------|---------------------------------|-------------------------------------------------|------------------|
| getPricing(String sku) | HashMap\<String, Integer> prices | Customer wants to know the cost of their basket | cost as a double |

