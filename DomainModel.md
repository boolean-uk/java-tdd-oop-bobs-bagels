# Domain Model

| Classes                       | Attributes                      | Methods                                                     | Scenario                          | Output             |
|-------------------------------|---------------------------------|-------------------------------------------------------------|-----------------------------------|--------------------|
| Basket                        | - int capacity                  | + addToBasket(Item item, int amount)                        | basket is not full                |                    |
|                               |                                 |                                                             | - item not yet in basket          | true               |
|                               |                                 |                                                             | - item already in basket          | true               |
|                               |                                 |                                                             | basket is full                    | false              |
|                               |                                 |                                                             | invalid amount                    | false              |
|                               | - Map<Item,Integer> itemsMap    | + removeFromBasket(Item item, int amount)                   | item exists                       | true               |
|                               |                                 |                                                             | item does not exist               | false              |
|                               |                                 |                                                             | invalid amount                    | false              |
|                               | - Inventory inventory           | + isFull()                                                  |                                   | true               |
|                               |                                 |                                                             |                                   | false              |
|                               |                                 | + getItemCost()                                             | item in the basket                | String             |
|                               |                                 |                                                             | item not in the basket            |                    |
|                               |                                 | + addFilling()                                              | filling option exists             | true               |
|                               |                                 |                                                             | filling option does not exist     | false              |
|                               |                                 | + getCapacity()                                             |                                   | int                |
|                               |                                 | + getFillingCost()                                          |                                   | BigDecimal         |
|                               |                                 | + setCapacity(int amount)                                   |                                   | void               |
|                               |                                 | + getBasketSize()                                           | current number of items in basket | int                |
|                               |                                 | + getItemsMap()                                             |                                   | Map<Item, Integer> |
|                               |                                 | + getRemainingCapacity()                                    |                                   | int                |
|                               |                                 | + calculateTotalCost()                                      |                                   | BigDecimal         |
|                               |                                 | + printReceipt()                                            |                                   | String             |
|                               |                                 | + toString()                                                |                                   | String             |
|                               |                                 | + itemIsAvailable(Item item)                                |                                   | boolean            |
|                               |                                 | + calculateItemTotalCost(Item item, int quantity)           |                                   | BigDecimal         |
|                               |                                 | + calculateBagelsDiscountedPrice(Bagel bagel, int quantity) |                                   | BigDecimal[]       |
|                               |                                 |                                                             |                                   |                    |
| .......                       | ..........................      | .......................                                     | ........................          | ......             |
| Inventory                     | - ArrayList<Item> inventoryList | + itemExists()                                              |                                   | true               |
|                               |                                 |                                                             |                                   | false              |
|                               |                                 | + itemIsAvailable()                                         |                                   | boolean            |
|                               |                                 | + getInventoryList()                                        |                                   | ArrayList<Item>    |
|                               |                                 | + addProductToInventory()                                   |                                   |                    |
|                               |                                 | + loadProducts()                                            |                                   |                    |
| .......                       | ..........................      | .......................                                     | ........................          | ......             |
| Item                          | - String SKU                    | + getters                                                   |                                   |                    |
| /abstract/                    | - BigDecimal price              | + setters                                                   |                                   |                    |
|                               | - String name                   | + abstract Enum<?> getVariant()                             |                                   |                    |
| .......                       | ..........................      | .......................                                     | ........................          | ......             |
| Fillable                      | - int MAX_FILLINGS              | + getFillings()                                             |                                   | ArrayList<Filling> |
| <<interface>>                 |                                 | + addFilling(Filling filling)                               |                                   | boolean            |
| .......                       | ..........................      | .......................                                     | ........................          | ......             |
| Sellable                      |                                 | + calculateTotalPriceItem()                                 |                                   | BigDecimal         |
| <<interface>>                 |                                 |                                                             |                                   |                    |
|                               |                                 |                                                             |                                   |                    |
| .........                     | .........................       | ......................                                      | .............................     | ......             |
| Bagel                         | - ArrayList<Filling> fillings   | + addFilling(Filling filling)                               |                                   | true               |
| extends Item                  | - BagelType variant             | + setVariant(BagelType newVariant)                          |                                   | false              |
| implements Sellable, Fillable |                                 | + calculateTotalPriceItem()                                 |                                   | true               |
|                               |                                 |                                                             |                                   | false              |
|                               |                                 | + getTotalCost                                              |                                   | double             |
| .........                     | .........................       | ......................                                      | .............................     | ......             ||                               |                               |                                                           |                                   |                    |
|                               |                                 |                                                             |                                   |                    |
|                               |                                 |                                                             |                                   |                    |
| Coffee                        | - CoffeeType variant            | + calculateTotalPriceItem()                                 |                                   | BigDecimal         |
| extends Item                  | - boolean bagelAdded            |                                                             |                                   |                    |
| implements Sellable           |                                 |                                                             |                                   |                    |
| .........                     | .........................       | ......................                                      | .............................     | ......             ||                               |                               |                                                           |                                   |                    |
|                               |                                 |                                                             |                                   |                    |
| Filling                       | - FillingType variant           | + getters                                                   |                                   |                    |
|                               |                                 | + setters                                                   |                                   |                    |
| .........                     | .........................       | ......................                                      | .............................     | ......             ||                               |                               |                                                           |                                   |                    |
| Shop                          | - BASKET_CAPACITY               | + main()                                                    |                                   |                    |
|                               | - scanner                       | + printActions()                                            |                                   |                    |
|                               | - basket                        | + showInventory()                                           |                                   |                    |
|                               |                                 | + addItemToBasket()                                         |                                   |                    |
|                               |                                 | + addFillingsToBagel()                                      |                                   |                    |
|                               |                                 | + offerCoffeeDiscount()                                     |                                   |                    |
|                               |                                 | + handleAmountSelection()                                   |                                   |                    |
|                               |                                 | + removeFromBasket()                                        |                                   |                    |
|                               |                                 | + getIntInput()                                             |                                   |                    |
|                               |                                 | + listMenuOptions()                                         |                                   |                    |
| .........                     | .........................       | ......................                                      | .............................     | ......             ||                               |                               |                                                           |                                   |                    |
| BagelType /enum/              |                                 |                                                             |                                   |                    |
| CoffeeType /enum/             |                                 |                                                             |                                   |                    |
| FillingType /enum/            |                                 |                                                             |                                   |                    |
|                               |                                 |                                                             |                                   |                    |

