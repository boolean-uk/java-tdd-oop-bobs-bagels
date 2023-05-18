# User stories
1. I'd like to add a specific type of bagel to my basket.(Done)
2. I'd like to remove a bagel from my basket.(Done)
3. I'd like to know when my basket is full when I try adding an item beyond my basket capacity.(Done)
4. I’d like to change the capacity of baskets. (Done)
5. I'd like to know if I try to remove an item that doesn't exist in my basket.(Done)
6. I'd like to know the total cost of items in my basket. (Done)
7. I'd like to know the cost of a bagel before I add it to my basket. (Can use getPrice before using addItem in the basket)
8. I'd like to be able to choose fillings for my bagel.(Done)
9. I'd like to know the cost of each filling before I add it to my bagel order.(Done)
10. I want customers to only be able to order things that we stock in our inventory.(Done)

# Domain model
| Class        | Attributes                              | Methods                    | Scenarios | Outcome                                         |
|--------------|-----------------------------------------|----------------------------|-----------|-------------------------------------------------|
| AbstractItem | String sku                              |                            |           |                                                 |
|              | double price                            |                            |           |                                                 |
|              | String name                             |                            |           |                                                 |
|              | double saving                           |                            |           |                                                 |
|              | int quantity                            |                            |           |                                                 |
|              | String variant                          |                            |           |                                                 |
| Bagel        | ArrayList<Filling> fillings             |                            |           |                                                 |
|              |                                         |                            |           |                                                 |
|              |                                         | calculateDiscount() ???    |           |                                                 |
|              |                                         | getFillingsTotalPrice()    |           | returns total fillings price added to the bagel |
|              |                                         |                            |           |                                                 |
| Coffee       |                                         | calculateDiscount() ???    |           |                                                 |
| Filling      |                                         | calculateDiscount() ???    |           |                                                 |
|              |                                         |                            |           |                                                 |
|              |                                         |                            |           |                                                 |
|              |                                         |                            |           |                                                 |
|              |                                         | addFilling(Item item)      | 8.,10     | returns a message                               |
| Basket       | ArrayList<AbstractItem> items           |                            |           |                                                 |
|              |                                         | addItem(Item item)         | 1.,3.,10  | returns a message                               |
|              | Inventory inventory                     | removeItem(Item item)      | 2.,5.     | returns a message                               |
|              | String receipt                          |                            |           |                                                 |
|              | int capacity                            |                            |           |                                                 |
|              |                                         | getTotalCost()             | 6.,9.     | returns an double                               |
|              |                                         | printReceipt()             |           | displays a receipt to the console               |
|              |                                         | getCostBeforeDiscount()    |           | returns double                                  |
|              |                                         |                            |           |                                                 |
| Inventory    | ArrayList<AbstractItems> inventoryItems |                            |           |                                                 |
|              |                                         |                            |           |                                                 |
|              |                                         | showPrice(Item item)       | 7.        | makes a print                                   |
|              |                                         | showFillings()             | 8.        | Show a list of all available fillings           |
|              |                                         | isValid(AbstractItem item) |           | returns true if item found else false           |
| Sku          |                                         |                            |           | enum class containing Sku code                  |




