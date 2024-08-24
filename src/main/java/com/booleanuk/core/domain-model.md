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
| Classes                                             | Variables                                     | Methods                                 | Scenario                                              | Output                       |
|-----------------------------------------------------|-----------------------------------------------|-----------------------------------------|-------------------------------------------------------|------------------------------|
| `Inventory`                                         | `-Map<String, InventoryItem> inventoryItems ` |                                         |                                                       |                              |
|                                                     | `-PrintGenerator menu`                        |                                         |                                                       |                              |
|                                                     |                                               | `-fillInventory()`                      | Initialize inventory with specified items.            |                              |
|                                                     |                                               | `+getAllItems()`                        | Get all inventory items.                              | Map<String, InventoryItem>   |
|                                                     |                                               | `+getItem(String SKU)`                  | If item is in inventory (valid SKU).                  | InventoryItem                |
|                                                     |                                               |                                         | If item does not exist.                               | throw InventoryItemException |
|                                                     |                                               | `+printMenu()`                          | Print menu with all items from the inventory.         | Print to console/terminal    |
|                                                     |                                               |                                         |                                                       |                              |
| `InventoryItem`                                     | `-String SKU`                                 | `+getSKU()`                             |                                                       | String                       |
|                                                     |                                               | `#setSKU()`                             | Set SKU based on name and variant.                    | String                       |
|                                                     | `-float price`                                | `+getPrice()`                           | Get price calculated with PriceCalculator.round().    | double                       |
|                                                     |                                               | `#setPrice(float price)`                | Set price.                                            | -                            |
|                                                     | `-ProductName name`                           | `+getName()`                            | Get product name.                                     | ProductName                  |
|                                                     |                                               | `#setName()`                            | Set product name.                                     | ProductName                  |
|                                                     | `-Enum variant`                               | `+getVariant(Enum variant)`             | Get product variant (DEFAULT, COFFE, BAGEL, FILLING). | Enum                         |
|                                                     |                                               | `#setVariant()`                         | Set product variant.                                  | -                            |
|                                                     | `-SKUCalculator skuCalculator`                |                                         |                                                       |                              |
|                                                     | `-PriceCalculator priceCalculator`            |                                         |                                                       |                              |
|                                                     |                                               |                                         |                                                       |                              |
| `CoffeeItem` extends `InventoryItem`                | @Ovverride `+setName()`                       |                                         |                                                       | ProductName                  |
| `BagelItem` extends `InventoryItem`                 | @Ovverride `+setName()`                       |                                         |                                                       | ProductName                  |
| `FillingItem` extends `InventoryItem`               | @Ovverride `+setName()`                       |                                         |                                                       | ProductName                  |
|                                                     |                                               |                                         |                                                       |                              |
| `InventoryItemException` extends `RuntimeException` |                                               |                                         |                                                       |                              |

## Package: basket
| Classes                        | Variables                               | Methods                                     | Scenario                                                                                                           | Output                                           |
|--------------------------------|-----------------------------------------|---------------------------------------------|--------------------------------------------------------------------------------------------------------------------|--------------------------------------------------|
| `Basket(Inventory inventory)`  | `-Inventory inventory`                  |                                             |                                                                                                                    |                                                  |
|                                | `-Map<Integer, BasketItem> basketItems` | `+getAll()`                                 | Get all basket items.                                                                                              | Map<Integer, BasketItem>                         |
|                                |                                         | `#getBasketItem(int itemId)`                | If item exist.                                                                                                     | BasketItem                                       |
|                                |                                         |                                             | If items doesn't exist.                                                                                            | throw InvalidBasketItemException                 |
|                                |                                         | `#addToBasket(int itemId, BasketItem item)` | Inner function for add(), validates input. Add item to basket if possible.                                         |                                                  |
|                                |                                         |                                             | If item can't be added, notify with error.                                                                         | MaxCapacityException, InvalidBasketItemException |
|                                |                                         | `+add(BasketItem item)`                     | Make a request to `#addToBasket(int itemId, BasketItem item)`.                                                     | -                                                |
|                                |                                         |                                             | If exception is thrown, handle exception.                                                                          | Print exception to console/terminal              |
|                                |                                         | `#removeFromBasket(int itemId)`             | Inner function for remove(). If valid item id, remove item from basket.                                            |                                                  |
|                                |                                         |                                             | if not valid item id, notify with error.                                                                           | InvalidBasketItemException                       |
|                                |                                         | `+remove(int itemId)`                       | Make a request to  `#removeFromBasket(int itemId)`. Remove item if possible.                                       |                                                  |
|                                |                                         |                                             | If exception is thrown, handle exception.                                                                          | Print exception to console/terminal              |
|                                |                                         | `+getTotalCost()`                           | Get total cost of all items in basket.                                                                             | double                                           |
|                                |                                         | `+printBasket()`                            | Print content of basket and total price.                                                                           | Print to console/terminal                        |
|                                | `-int idCount`                          | `-createId()`                               | "Auto" creates Id for basket items except filling Ids. E.g. returns id 1.                                          | int                                              |
|                                |                                         | `-createFillingId(String idExtension)`      | "Auto" creates id for filling based on the bagels id. E.g. Bagel id: 1, filling id: 101.                           | int                                              |
|                                | `-int size`                             | `+getSize()`                                | Get the counted size of basket<br>(fillings doesn't count as an item and can only be added together with a Bagel). | int                                              |
|                                | `-int maxCapacity`                      | `+getMaxCapacity()`                         | Get max capacity of basket.                                                                                        | int                                              |
|                                |                                         | `+changeMaxCapacity(int newMaxCapacity)`    | Change max capacity.                                                                                               | -                                                |
|                                | `-PriceCalculator priceCalculator`      |                                             |                                                                                                                    |                                                  |
|                                | `-PrintGenerator basket`                |                                             |                                                                                                                    |                                                  |
|                                |                                         |                                             |                                                                                                                    |                                                  |
| `BasketItem(String SKU)`       | `-int Id`                               | `+setId(int itemId)`                        |                                                                                                                    |                                                  |
|                                |                                         | `+getId(int itemId)`                        |                                                                                                                    | int                                              |
|                                | `-String SKU`                           | `+getSKU()`                                 |                                                                                                                    | String                                           |
|                                |                                         |                                             |                                                                                                                    |                                                  |
| `Coffee` extends `BasketItem`  |                                         |                                             |                                                                                                                    |                                                  |
| `Bagel` extends `BasketItem`   | `-List<String> linkedFillingSKUs`       | `+getLinkedFillingSKUs`                     | Get a list of inventory item SKU's that was added together with this bagel.                                        | List<String>                                     |
|                                | `-List<Integer> linkedFillingIds`       | `getLinkedFillingIds`                       | Get a list of basket item ids' (the ids' of the fillings that belongs to this bagel).                              | List<Integer>                                                 |
| `Filling` extends `BasketItem` |                                         |                                             |                                                                                                                    |                                                  |
|                                |                                         |                                             |                                                                                                                    |                                                  |
| `InvalidBasketItemException`   |                                         |                                             |                                                                                                                    |                                                  |
| `MaxCapacityException`         |                                         |                                             |                                                                                                                    |                                                  |


# Class Diagram
## Diagram
TODO: UPDATE....
![Class Diagram](/assets/images/gleek_class-diagram.png)

## Code
TODO: .....

