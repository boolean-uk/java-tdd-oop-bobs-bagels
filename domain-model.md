## Class diagram
![](./class_diagram.jpg)



### Item class
| Method   | Scenario          | Output |
|----------|-------------------|--------|
| `Item()` | Class constructor | -      |

### Menu class
| Method                        | Scenario                                            | Output         |
|-------------------------------|-----------------------------------------------------|----------------|
| `getMenu()`                   | -                                                   | List of menu   |
| `itemExists(itemId: String)`  | Item exists in menu<br/>Item does not exist in menu | true<br/>false |
| `getItemMenu(itemId: String)` | Item exists in menu<br/>Item does not exist in menu | Item<br/>null  |


### Basket class

| Method                                                  | Scenario                                                                                                                                         | Outcome                                                                                                                    | Output                                                                                                                                                                      |
|---------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `addItem(itemId: String, quantity: int)`                | Item exists in menu but not in basketItems<br/>Item exists in menu and in basketItems<br/>Item does not exist in menu<br/>Basket is full         | Item is added to basketItems with the correct quantity<br/>The quantity of the item in basketItems is changed<br/>- <br/>- | "'quantity' 'itemVariant' 'itemName' added to basket."<br/>"'quantity' 'itemVariant' 'itemName' added to basket."<br/>"This item is not on the menu."<br/>"Basket is full." |
| `removeItem(itemId: String, removeDuplicates: Boolean)` | Item exists in basketItems and removeDuplicates=true<br/>Item exists in basketItems and removeDuplicates=false<br/>Item does not exist in basket | Entry is removed from basketItems<br/>The quantity of the item in basketItems is subtracted 1.<br/>-                       | "'quantity' 'itemVariant' 'itemName's removed from basket."<br/>"'itemVariant' 'itemName' removed from basket."<br/>"This item does not exist in your basket."              |
| `sumOrder()`                                            | basketItems is not empty<br/>basketItems is empty                                                                                                |                                                                                                                            | "The sum of your order is: 'sum'"<br/>"Your basket is empty."                                                                                                               |
| `sumOrderDiscount()`                                    | 6 bagels of any kind<br/>12 bagels of any kind<br/>1 bagel and 1 coffee                                                                          | Sum = 2.49<br/>Sum = 3.99<br/>Sum = 1.25                                                                                   |  "The sum of your order is: 'sum'"                                                                                                                                                                           |
| `setBasketSize(int)`                                    | Basket capacity is changed to a positive integer by a "manager"<br/>Basket capacity value is not positive                                        |                                                                                                                            | Return true<br/>Return false                                                                                                                                                |


### Assumptions:

- Fillings can be added regardless of the presence of a bagel in the basket.
- Fillings, coffee, and bagels count toward the maximum basket size.
- The "manager" role is purely fictional and not actually implemented