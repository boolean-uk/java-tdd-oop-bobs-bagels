# Domain Model

## Enums
| Classes   | Variables | Methods | Scenario | Output |
|-----------|-----------|---------|----------|--------|
| `SKU`     |           |         |          |        |
| `COFFEE`  |           |         |          |        |
| `BAGEL`   |           |         |          |        |
| `FILLING` |           |         |          |        |

## Inventory
| Classes     | Variables                     | Methods                                             | Scenario                                   | Output     |
|-------------|-------------------------------|-----------------------------------------------------|--------------------------------------------|------------|
| `Inventory` | `ArrayList<Product> products` |                                                     |                                            |            |
|             |                               | `-addProduct(float price, enum name, enum variant)` | Add product to inventory.                  | -          |
|             |                               | ?? or ??                                            |                                            |            |
|             |                               | `-addCoffee(float price, enum variant)`             | -^                                         |            |
|             |                               | `-addBagel(float price, enum varint)`               | -^                                         |            |
|             |                               | `-addFilling(float price enum variant)`             | -^                                         |            |
|             |                               | ???                                                 |                                            |            |
|             |                               | `-fillInventory()`                                  | Initialize inventory with specified items. |            |
|             |                               | `-getAllCoffee()`                                   | Get a list of all coffee products.         | List       |
|             |                               | `-getAllBagels()`                                   | Get a list of all bagel products.          | List       |
|             |                               | `-getAllFillings()`                                 | Get a list of all filling products.        | List       |
|             |                               | `+printMeny()`                                      | Print meny of all items in inventory.      | Print text |

## Basket
| Classes  | Variables                    | Methods                                | Scenario                                                                                                      | Output          |
|----------|------------------------------|----------------------------------------|---------------------------------------------------------------------------------------------------------------|-----------------|
| `Basket` | `static int idCount`         |                                        | "Fake autoincrement id". Counter which will be increased everytime a new product is added to the basket.      |                 |
|          | `HashMap<Products> products` | `addCoffee(enum variant)`              | Add coffee with specified variant. Then run printBasket().                                                    |                 |
|          |                              |                                        | Can't add coffee.                                                                                             | throw exception |
|          |                              | `addBagel(enum variant, enum filling)` | Add bagel with specified variant and filling. At the moment just one filling can be added. run printBasket(). |                 |
|          |                              |                                        | Can't add bagel.                                                                                              | throw exception |
|          |                              | `remove(int ProduktId)`                | Product is in basket and can be removed.                                                                      | Show message    |
|          |                              |                                        | Product is not in basket and can not be removed.                                                              | throw exception |
|          | `int maxCapacity`            | `changeCapacity(int newCapacity)`      | If newCapacity is more than 0.                                                                                | true            |
|          |                              |                                        | If newCapacity is less than 1.                                                                                | false           |
|          | `float totalCost`            |                                        |                                                                                                               |                 |
|          |                              | `getTotalCost()`                       | Get total cost of all products.                                                                               | float           |
|          |                              | `printBasket()`                        | Prints the content of the basket.                                                                             | Print text      |

## Product
| Classes   | Variables      | Methods      | Scenario                           | Output |
|-----------|----------------|--------------|------------------------------------|--------|
| `Product` | `int id`       |              |                                    |        |
|           | `enum SKU`     |              |                                    |        |  
|           | `float price`  |              |                                    |        |
|           | `enum name`    |              |                                    |        |
|           | `enum variant` |              |                                    |        |
|           |                | `setSKU()`   | Set SKU based on name and variant. | -      |
|           |                | `getPrice()` | Get price for this product.        | float  |

## Coffee extends Product (Inherit)
| Classes | Variables | Methods              | Scenario                            | Output |
|---------|-----------|----------------------|-------------------------------------|--------|
| `Coffe` |           | `@override setSKU()` |                                     |        |  

## Bagel extends Product (Inherit)
| Classes | Variables | Methods               | Scenario                            | Output |
|---------|-----------|-----------------------|-------------------------------------|--------|
| `Bagel` |           | `@override setSKU()`  |                                     |        |  

## Filling extends Product (Inherit)
| Classes   | Variables | Methods               | Scenario                            | Output |
|-----------|-----------|-----------------------|-------------------------------------|--------|
| `Filling` |           | `@override setSKU()`  |                                     |        |  


