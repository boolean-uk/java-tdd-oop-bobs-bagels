# Basket

| Member                          | Method                        | Scenario             | Output        |
|---------------------------------|-------------------------------|----------------------|---------------|
| Hashmap<String, Item> stockList | addItem(Item item)            | Item does not exist  | False         |
|                                 |                               | Item exist           | True          |
|                                 | removeItem(Item item)         | Item does not exist  | False         |
|                                 |                               | Item exist           | True          |
|                                 | listOfItems()                 |                      | List of items |
|                                 | getTotalCost()                |                      | double        |
|                                 |                               | Basket is not full   | False         |
|                                 | changeCapasity(int capasity)  |                      | int           |
|                                 | discountPrice()               |                      | Double        |


# Item

| Member | Method           | Scenario | Output |
|--------|------------------|----------|--------|
|        | GetPrice()       |          | double |
|        | GetId()          |          | String |
|        | GetType()        |          | String |
|        | GetDescription() |          | String |


# Receipt

| Member        | Method                        | Scenario | Output                   |
|---------------|-------------------------------|----------|--------------------------|
| Basket basket | receiptBuilder(Basket basket) |          | Hashmap<String, Integer> |
|               | printReceipt(Basket basket)   |          | Stringbuilder            |

