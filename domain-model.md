| class    | member                       | methods                 | scenario                                          | output |
|----------|------------------------------|-------------------------|---------------------------------------------------|--------|
| Basket   | `List<Bagel> shoppingBasket` |                         |                                                   |        |
|          | int capacity                 |                         |                                                   |        |
|          |                              | add(Bagel bagel)        | add bagel to basket                               | true   |
|          |                              |                         | fail to add the bagel                             | false  |
|          |                              | remove(Bagel bagel)     | remove bagel from basket                          | true   |
|          |                              |                         | fail to remove the bagel                          | false  |
|          |                              | setCapacity(int newCap) | set the new Capacity                              | true   |
|          |                              |                         | fail to set the new cap                           | false  |
| User     | Basket basket                |                         |                                                   |        |
|          | double total                 |                         |                                                   |        |
|          |                              |                         |                                                   |        |
| Bagel    | String variant               |                         | (Onion,Plain,Everything,Sesame)                   |        |
|          | double price                 |                         | (0.49,0.39,0.49,0.49)                             |        |
|          | String SKU                   |                         | (BGLO,BGLP,BGLE,BGLS)                             |        |
|          | Filling filling              |                         |                                                   |        |
|          |                              |                         |                                                   |        |
| Filling  | String variant               |                         | (Bacon,Egg,Cheese,Cream Cheese,Smoked Salmon,Ham) |        |
|          | double price                 |                         | (0.12 all)                                        |        |
|          | String SKU                   |                         | (FILB,FILE,FILC,FILX,FILS,FILH)                   |        |
|          |                              |                         |                                                   |        |
| Coffee   | String variant               |                         | (Black,White,Capuccino,Latte)                     |        |
|          | double price                 |                         | (0.99,1.19,1.29,1.29)                             |        |
|          | String SKU                   |                         | (COFB,COFW,COFC,COFL)                             |        |
|          |                              |                         |                                                   |        |
| Invetory | `List<String> bagels`        |                         |                                                   |        |
|          | `List<String> coffees`       |                         |                                                   |        |
|          | `List<String> fillings`      |                         |                                                   |        |
|          |                              |                         |                                                   |        |
|          |                              |                         |                                                   |        |
|          |                              |                         |                                                   |        |
|          |                              |                         |                                                   |        |
