# Basket

| Member | Method                       | Scenario            | Output        |
|--------|------------------------------|---------------------|---------------|
|        | addItem(Item item)           | Item does not exist | False         |
|        |                              | Item exist          | True          |
|        | removeItem(Item item)        | Item does not exist | False         |
|        |                              | Item exist          | True          |
|        | listOfItems()                |                     | List of items |
|        | getTotalCost()               |                     | double        |
|        | isFull()                     | Basket is full      | True          |
|        |                              | Basket is not full  | False         |
|        | changeCapasity(int capasity) |                     | int           |


# Item

| Member | Method              | Scenario | Output |
|--------|---------------------|----------|--------|
|        | GetPrice(Item item) |          | double |

# Inventory

| Member | Method       | Scenario             | Output |
|--------|--------------|----------------------|--------|
|        | checkStock() | Item is in stock     | True   |
|        |              | Item is not in stock | False  |


