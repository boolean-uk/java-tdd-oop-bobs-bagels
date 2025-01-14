(Get/set methods don't have a scenario because they return null/do nothing if the input for the setter is invalid or the getter tries to get something it can't.)

# Item class

| Members            | Methods                 | Output                 |
|--------------------|-------------------------|------------------------|
| String id          | String getId()          | SKU of the item        |
| double price       | double getPrice()       | Price of the item      |
| String description | String getDescription() | Description of the item |

# Bagel class

| Inheritance         | Members                      | Methods                                | Scenario                            | Result/Output                                  |
|---------------------|------------------------------|----------------------------------------|-------------------------------------|------------------------------------------------|
| Child of Item class | String id                    | String getId()                         |                                     | SKU of the bagel                               |
|                     | double price                 | double getPrice()                      |                                     | Price of the bagel                             |
|                     | String description           | String getDescription()                |                                     | Description of the bagel                       |
|                     | ArrayList\<Filling> fillings | boolean attachFilling(Filling filling) | 3 or more fillings already attached | Return false, don't add the filling            |
|                     |                              |                                        | Less than 3 fillings attached       | Return true, add filling to fillings ArrayList |
|                     |                              | ArrayList\<Filling> getAllFillings()   |                                     | All fillings attached to the bagel             |

# Filling class

| Inheritance         | Members            | Methods                 | Output                      |
|---------------------|--------------------|-------------------------|-----------------------------|
| Child of Item class | String id          | String getId()          | SKU of the filling          |
|                     | double price       | double getPrice()       | Price of the filling        |
|                     | String description | String getDescription() | Description of the filling  |

# Coffee class


| Inheritance         | Members            | Methods                 | Output                    |
|---------------------|--------------------|-------------------------|---------------------------|
| Child of Item class | String id          | String getId()          | SKU of the coffee         |
|                     | double price       | double getPrice()       | Price of the coffee       |
|                     | String description | String getDescription() | Description of the coffee |

# ItemFactory class


| Members                                         | Methods                    | Scenario             | Output/Result                                                         |
|-------------------------------------------------|----------------------------|----------------------|-----------------------------------------------------------------------|
| HashMap\<String>, ArrayList\<Object>> inventory | void setPrice()            |                      | Sets the price of the item internally based on the provided SKU       |
| String id                                       | void setDescription        |                      | Sets the description of the item internally based on the provided SKU |
|                                                 | Item createItem(String id) | Invalid id           | return null                                                           |
|                                                 |                            | id starts with 'B'   | create and return Bagel object based on id                            |
|                                                 |                            | id starts with 'C'   | create and return Coffee object based on id                           |
|                                                 |                            | id starts with 'F'   | create and return Filling object based on id                          |


# Basket class


| Members                 | Methods                                 | Scenario                              | Output/Result                                                            |
|-------------------------|-----------------------------------------|---------------------------------------|--------------------------------------------------------------------------|
| ArrayList\<Item> basket | boolean addToBasket(Item item)          | Basket at max capacity                | Don't add, return false                                                  |
| int maxCapacity;        |                                         | Basket not at max capacity            | Add item to basket, increase totalPrice by price of item, return true    |
| double totalPrice;      | boolean removeFromBasket(Item item)     | Item does not exist in basket         | Don't remove, return false                                               |
|                         |                                         | Item in basket                        | Remove the item, decrease total totalPrice by price of item, return true |
|                         | boolean changeCapacity(int newCapacity) | newCapacity is less than 1            | Don't change capacity, return false                                      |
|                         |                                         | newCapacity is larger or equal to 1   | Update to new capacity, return true                                      |
|                         | ArrayList\<Item> getBasket()            |                                       | Returns contents of basket                                               |
|                         | double checkDiscounts()                 | No discount items in basket           | No discount given                                                        |
|                         |                                         | 6 or more onion bagels in basket      | Apply discount per 6 onion bagels (total: 2.49)                          |
|                         |                                         | 12 or more plain bagels in basket     | Apply discount per 12 plain bagels (total: 3.99)                         |
|                         |                                         | 6 or more everything bagels in basket | Apply discount per 6 everything bagels (total: 2.49)                     |
|                         |                                         | 1 black coffee + any bagel            | Apply discount per set of coffee and bagel (total: 1.25)                 |
