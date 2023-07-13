User story for EXTENSION1
' As a customer,
So that I can see the total cost of my order,
I want to be able o add multiple items to my basket and receive the discounted price when applicable.'
| Class        | Attributes                                  | Methods                                 | Scenario                              | Output                                           |  
|--------------|---------------------------------------------|-----------------------------------------|---------------------------------------|--------------------------------------------------|
| `Basket`     | `HashMap<String, Integer> items`            | `addItem(String item, int quantity)`    | If basket is not full                 | `Added item to basket, you can add 2 items more` |
|              | `int capacity`                              |                                         | If basket is full                     | `Basket is full`                                 |
|              |                                             | `removeItem(String item, int quantity)` | If item is in basket                  | true                                             |
|              |                                             |                                         | If item is not in basket              | false                                            |
|              |                                             | `isFull()`                              | If basket is full                     | true                                             |
|              |                                             |                                         | If basket is not full                 | false                                            |
|              |                                             | `changeCapacity(int newCapacity)`       | Bob's manager want to change capacity |                                                  |
|              |                                             | calculateTotalPrice(): double<br/>           |                                       |                                                  |
| Bagel        | SKU: String, Price: double, Variant: String |                                         |                                       |                                                  |
| Coffee       | SKU: String, Price: double, Variant: String |                                         |                                       |                                                  |
| Filling      | SKU: String, Price: double, Variant: String |                                         |                                       |                                                  |
| Inventory    | bagels: List<Bagel>                         | getBagelBySKU(String SKU): Bagel        | If SKU exists in inventory            | Bagel object                                     |
|              | coffees: List<Coffee>                       | getCoffeeBySKU(Srtring SKU): Coffee     | If SKU exists in inventory            | Coffee object                                    |
|              | fillings: List<Filling>                     | getFillingBySKU(String SKU): Filling    | If SKU exists in inventory            | Filling object                                   |
|              |                                             | checkAvailability(String item): boolean | if item is avaible in inventory       | true                                             |
|              |                                             |                                         | if item is no avaible in inventory    | false                                            |
|              |                                             | getItemPrice(String item) : double      | if item exists in inventory           | Price of the item                                |
|              | specialOffers( Map of SKU to SpecialOffer)  | getSpecialOffer(Sring SKU)              |                                       |                                                  |
| SpecialOffer | quantity (int), price (double)              |                                         |                                       |                                                  |
