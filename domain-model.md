(Get/set methods don't have a scenario because they return null/do nothing if the input for the setter is invalid or the getter tries to get something it can't.)

# Item class

| Inheritance | Members            | Methods                 | Output                  |
|-------------|--------------------|-------------------------|-------------------------|
|             | String id          | String getId()          | SKU of the item         |
|             | double price       | double getPrice()       | Price of the item       |
|             | String description | String getDescription() | Description of the item |

# Bagel class

| Inheritance         | Members                      | Methods                              | Result                                       |
|---------------------|------------------------------|--------------------------------------|----------------------------------------------|
| Child of Item class | String id                    | String getId()                       | SKU of the bagel                             |
|                     | double price                 | double getPrice()                    | Price of the bagel                           |
|                     | String description           | String getDescription()              | Description of the bagel                     |
|                     | ArrayList\<Filling> fillings | void attachFilling(Filling filling)  | Filling gets added to the fillings ArrayList |
|                     |                              | ArrayList\<Filling> getAllFillings() | All fillings attached to the bagel           |

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


| Inheritance | Members                                         | Methods                    | Scenario             | Output                                                                |
|-------------|-------------------------------------------------|----------------------------|----------------------|-----------------------------------------------------------------------|
|             | HashMap\<String>, ArrayList\<Object>> inventory | void setPrice()            |                      | Sets the price of the item internally based on the provided SKU       |
|             | String id                                       | void setDescription        |                      | Sets the description of the item internally based on the provided SKU |
|             |                                                 | Item createItem(String id) | Invalid id           | return null                                                           |
|             |                                                 |                            | id starts with 'B'   | create and return Bagel object based on id                            |
|             |                                                 |                            | id starts with 'C'   | create and return Coffee object based on id                           |
|             |                                                 |                            | id starts with 'F'   | create and return Filling object based on id                          |


# Basket class


