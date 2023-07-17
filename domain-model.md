## Basket
| Class  | Attributes                                        | Methods                             | Scenarios                                                      | Output                       |
|--------|---------------------------------------------------|-------------------------------------|----------------------------------------------------------------|------------------------------|
| Basket | int capacity                                      | add(String name, String variant)    | user can add item to basket                                    | void : item added to map     |
|        |                                                   |                                     | item does not exist in inventory                               | print message                |
|        |                                                   |                                     | item exceeds capacity                                          | print message                |
|        | HashMap<Item item, Integer quantity> shoppingList | remove(String name, String variant) | user can remove item from basket                               | void : item removed from map |
|        |                                                   |                                     | item does not exist in basket                                  | print message                |
|        |                                                   |                                     | item does not exist in inventory                               | print message                |
|        |                                                   | isBasketFull()                      | user wants to know if the basket is full while adding new item | boolean                      |
|        |                                                   | changeCapacity(int capacity)        | user can change the capacity of basket                         | boolean                      |
|        |                                                   |                                     | capacity less than zero                                        | print message                |
|        |                                                   |                                     | capacity less than number of items in a basket                 | print message                |
|        |                                                   | isInBasket()                        | user wants to check if item is in  basket                      | boolean                      |
|        |                                                   | totalPrice()                        | user wants to know the total cost of basket                    | BigDecimal                   |
|        |                                                   | totalCostWithoutDiscounts()         | calculate cost without discounts                               | double                       |
|        |                                                   | countProductType(String SKU)        | method counts product in basket by its SKU                     | int                          |
|        |                                                   | mapShoppingListToReceipt()          | convert shopping list to Receipt object                        | Receipt                      |

## Item
| Class | Attributes       | Methods | Scenarios | Output |
|-------|------------------|---------|-----------|--------|
| Item  | String SKU       |         |           |        |
|       | String name      |         |           |        |
|       | BigDecimal price |         |           |        |
|       | String variant   |         |           |        |
|       |                  |         |           |        |

## Bagel
| Class              | Attributes       | Methods | Scenarios | Output |
|--------------------|------------------|---------|-----------|--------|
| Bagel extends Item | String SKU       |         |           |        |
|                    | String name      |         |           |        |
|                    | BigDecimal price |         |           |        |
|                    | String variant   |         |           |        |


## Coffee
| Class               | Attributes       | Methods | Scenarios | Output |
|---------------------|------------------|---------|-----------|--------|
| Coffee extends Item | String SKU       |         |           |        |
|                     | String name      |         |           |        |
|                     | BigDecimal price |         |           |        |
|                     | String variant   |         |           |        |

## Filling
| Class                | Attributes       | Methods | Scenarios | Output |
|----------------------|------------------|---------|-----------|--------|
| Filling extends Item | String SKU       |         |           |        |
|                      | String name      |         |           |        |
|                      | BigDecimal price |         |           |        |
|                      | String variant   |         |           |        |

## Inventory
| Class     | Attributes                | Methods                                      | Scenarios                                                    | Output               |
|-----------|---------------------------|----------------------------------------------|--------------------------------------------------------------|----------------------|
| Inventory | ArrayList<Item> inventory | createInventory()                            | inventory with all products available in shop is initialized | void                 |
|           |                           | searchInventory(String name, String variant) | search if an item exists in repository                       | Optional<Item>       |
|           |                           | getItemPrice(String name, String variant)    | user wants to check the price of item                        | Optional<BigDecimal> |

## Discount

| Class    | Attributes       | Methods | Scenarios | Output |
|----------|------------------|---------|-----------|--------|
| Discount | String SKU       |         |           |        |
|          | BigDecimal price |         |           |        |
|          | int quantity     |         |           |        |

## DiscountInventory

| Class             | Attributes                  | Methods                    | Scenarios                                            | Output   |
|-------------------|-----------------------------|----------------------------|------------------------------------------------------|----------|
| DiscountInventory | HashSet<Discount> discounts | createDiscountsInventory() | inventory with discounts corresponding with products |          |
|                   |                             | searchDiscount(String SKU) | search for discount by product SKU                   | Discount |
|                   |                             |                            |                                                      |          |

## Receipt

| Class   | Attributes                 | Methods                             | Scenarios                        | Output     |
|---------|----------------------------|-------------------------------------|----------------------------------|------------|
| Receipt | List<ReceiptLine> products | addProduct(ReceiptLine receiptLine) |                                  | void       |
|         | Basket basket              | getSavedMoney()                     |                                  | BigDecimal |
|         | BigDecimal savedMoney      | toString()                          | prints receipt with discounts    | String     |
|         |                            | formatter(String line, int width)   | calculates whitespace on receipt | String     |

## ReceiptLine

| Class       | Attributes                 | Methods              | Scenarios                               | Output  |
|-------------|----------------------------|----------------------|-----------------------------------------|---------|
| ReceiptLine | Item item                  | isBagelCoffeeSpecial | checks if the discount is special combo | boolean |
|             | BigDecimal quantity        |                      |                                         |         |
|             | BigDecimal price           |                      |                                         |         |
|             | boolean bagelCoffeeSpecial |                      |                                         |         |

## SmsSender

| Class     | Attributes                              | Methods                 | Scenarios                        | Output |
|-----------|-----------------------------------------|-------------------------|----------------------------------|--------|
| SmsSender | Map<String, StringBuilder> orderHistory | sendOrder(String order) | sends order details              | void   |
|           | Basket basket                           | sendSMS(String body)    | create message                   | void   |
|           |                                         | checkHistory()          | check message author and content | void   |
