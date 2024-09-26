# User story for EXTENSION1
' As a customer,
So that I can see the total cost of my order,
I want to be able o add multiple items to my basket and receive the discounted price when applicable.'

# User story fot EXTENSION2
As a customer,
So that I can have a record of my order,
I want to receive a printed receipt after making a purchase at Bob's Bagels.

# User sory for EXTENSION3 
As a customer,
So that I can see the amount I saved on my order,
I want the receipt to display the total savings from any applicable discounts or special offers.

| Class        | Attributes                                            | Methods                                                        | Scenario                                         | Output                              |  
|--------------|-------------------------------------------------------|----------------------------------------------------------------|--------------------------------------------------|-------------------------------------|
| `Basket`     | int capacity                                          | `addItem(String item)`                                         | If basket is not full && item exist              | true                                |
|              | int capacity                                          |                                                                | If basket is full                                | false                               |
|              |                                                       | `removeFilling(String nameOfBagle, String nameOfFilling)`      | If item is in basket && item exists in inventory | true                                |
|              |                                                       |                                                                | If item is not in basket                         | false                               |
|              |                                                       | removeCoffe(String item)                                       | If item is in basket && item exists in inventory | true                                |
|              |                                                       |                                                                | If item is not in basket                         | false                               |
|              |                                                       | removeBagle(String item)                                       | If item is in basket && item exists in inventory | true                                |
|              |                                                       |                                                                | If item is not in basket                         | false                               |
|              |                                                       | getItemName()                                                  | If item exist                                    | String                              |
|              |                                                       |                                                                | If item does not exist                           |                                     |
|              |                                                       | `changeCapacity(int newCapacity)`                              | If newCapacity > 0                               |                                     |
|              |                                                       |                                                                | If newCapacity < numberOfItemsInBasket           | newCapacity = numberOfItemsInBasket |
|              |                                                       | calculateTotalPrice()                                          |                                                  | double                              |
| Bagel        | SKU: String, Price: double, Variant: String           | addFilling(String filling)                                     |                                                  |                                     |
|              |                                                       | removeFiliing(String filling)                                  |                                                  |                                     |
| Coffee       | SKU: String, Price: double, Variant: String           |                                                                |                                                  |                                     |
| Filling      | SKU: String, Price: double, Variant: String           |                                                                |                                                  |                                     |
| Inventory    |                                                       | getProductBySKU(String SKU)                                    | If SKU exists in inventory                       | Product                             |
|              |                                                       | getProductVariant(Srtring SKU)                                 | If SKU exists in inventory                       | String                              |
|              |                                                       | initializeInventory()                                          |                                                  |                                     |
|              |                                                       | checkAvailability(String item): boolean                        | if item is avaible in inventory                  | true                                |
|              |                                                       |                                                                | if item is no avaible in inventory               | false                               |
|              |                                                       | getItemPrice(String item) : double                             | if item exists in inventory                      | Price of the item                   |
|              | specialOffers( Map of SKU to SpecialOffer)            | getSpecialOffer(Sring SKU)                                     |                                                  |                                     |
| SpecialOffer | quantity (int), price (double)                        | getQuantity()                                                  |                                                  | int                                 |
|              |                                                       | getPrice()                                                     |                                                  | double                              |
| Receipt      |                                                       | addItem(String name, int quantity, double price,double saving) |                                                  |                                     |
|              |                                                       | prinReceipt()                                                  |                                                  |                                     |
| ReceiptIem   | String name, int quanity, double price, double saving | getName()                                                      |                                                  | String                              |
|              |                                                       | getQuantity()                                                  |                                                  | int                                 |
|              |                                                       | getPrice()                                                     |                                                  | double                              |
|              |                                                       | getSaving()                                                    |                                                  | double                              |
| Product      | String SKU, double price, String variant              | getSKU()                                                       |                                                  | String                              |
|              |                                                       | getPrice()                                                     |                                                  | double                              |
|              |                                                       | getVariant()                                                   |                                                  | String                              |
