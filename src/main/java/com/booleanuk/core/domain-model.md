# Domain Model

## Package: enums
| Classes          | Variables | Methods | Scenario | Output |
|------------------|-----------|---------|----------|--------|
| `BagelVariant`   |           |         |          |        |
| `CoffeeVariant`  |           |         |          |        |
| `FillingVariant` |           |         |          |        |
| `ProductName`    |           |         |          |        |

## Package: calculators
| Classes           | Variables | Methods | Scenario | Output |
|-------------------|-----------|---------|----------|--------|
| `PriceCalculator` |           |         |          |        |
| `SKUCalculator`   |           |         |          |        |

## Package: inventory
| Classes     | Variables                                     | Methods                                                         | Scenario                                      | Output                       |
|-------------|-----------------------------------------------|-----------------------------------------------------------------|-----------------------------------------------|------------------------------|
| `Inventory` | `-Map<String, InventoryItem> inventoryItems ` |                                                                 |                                               |                              |
|             | `-PrintGenerator menu`                        |                                                                 |                                               |                              |
|             |                                               | `-fillInventory()`                                              | Initialize inventory with specified items.    |                              |
|             |                                               | `+getAllItems()`                                                | Get all inventory items.                      | Map<String, InventoryItem>   |
|             |                                               | `+getItem(String SKU)`                                          | If item is in inventory (valid SKU).          | InventoryItem                |
|             |                                               |                                                                 | If item does not exist.                       | throw InventoryItemException |
|             |                                               | `+printMenu()`                                                  | Print menu with all items from the inventory. | Print to console/terminal    |

## Basket
| Classes  | Variables                       | Methods                                | Scenario                                                                                                      | Output          |
|----------|---------------------------------|----------------------------------------|---------------------------------------------------------------------------------------------------------------|-----------------|
| `Basket` | `- static int idCount`          |                                        | "Fake autoincrement id". Counter which will be increased everytime a new product is added to the basket.      |                 |
|          | `- ArrayList<Product> products` | `addCoffee(enum variant)`              | Add coffee with specified variant. Then run printBasket().                                                    |                 |
|          |                                 |                                        | Can't add coffee.                                                                                             | throw exception |
|          |                                 | `addBagel(enum variant, enum filling)` | Add bagel with specified variant and filling. At the moment just one filling can be added. run printBasket(). |                 |
|          |                                 |                                        | Can't add bagel.                                                                                              | throw exception |
|          |                                 | `remove(int ProduktId)`                | Product is in basket and can be removed.                                                                      | Show message    |
|          |                                 |                                        | Product is not in basket and can not be removed.                                                              | throw exception |
|          | `int maxCapacity`               | `changeCapacity(int newCapacity)`      | If newCapacity is more than 0.                                                                                | true            |
|          |                                 |                                        | If newCapacity is less than 1.                                                                                | false           |
|          | `float totalCost`               | `setTotalCost(float newTotalCost)`     |                                                                                                               |                 |
|          |                                 | `getTotalCost()`                       | Get total cost of all products.                                                                               | float           |
|          |                                 | `printBasket()`                        | Prints the content of the basket.                                                                             | Print text      |
|          |                                 | `getAll()`                             | Get all products in basket.                                                                                   | List            |       

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

# Class Diagram
## Diagram
TODO: UPDATE....
![Class Diagram](/assets/images/gleek_class-diagram.png)

## Code
TODO: .....

