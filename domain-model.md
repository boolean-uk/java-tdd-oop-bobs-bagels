## Class diagram
![](./class_diagram.jpg)



### Item class
| Method   | Scenario          | Output |
|----------|-------------------|--------|
| `Item()` | Class constructor | -      |

### Menu class
| Method                         | Scenario                                            | Output                        |
|--------------------------------|-----------------------------------------------------|-------------------------------|
| `getMenu()`                    | -                                                   | List of menu                  |
| `getItemPrice(itemId: String)` | Item exists in menu<br/>Item does not exist in menu | Item price<br/>-1 (try catch) |


### Basket class

| Method                                                  | Scenario                                                                                                                                         | Outcome                                                                                                             | Output                                                                                                                                                                    |
|---------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `addItem(itemId: String, quantity: int)`                | Item exists in menu but not in basketItems<br/>Item exists in menu and in basketItems<br/>Item does not exist in menu                            | Item is added to basketItems with the correct quantity<br/>The quantity of the item in basketItems is changed<br/>- | "'quantity' 'itemVariant' 'itemName' added to basket."<br/>"'quantity' 'itemVariant' 'itemName' added to basket."<br/>"This item is not on the menu."                     |
| `removeItem(itemId: String, removeDuplicates: Boolean)` | Item exists in basketItems and removeDuplicates=true<br/>Item exists in basketItems and removeDuplicates=false<br/>Item does not exist in basket | Entry is removed from basketItems<br/>The quantity of the item in basketItems is subtracted 1.<br/>-                | "'quantity' 'itemVariant' 'itemName's removed from basket."<br/>"'itemVariant' 'itemName' removed from basket."<br/>"This item does not exist in your basket." |
| `sumOrder()`                                            | basketItems is not empty<br/>basketItems is empty                                                                                                |                                                                                                                     | "The sum of your order is: 'sum'"<br/>"Your basket is empty."                                                                                                             |
| `setBasketSize(int)`                                    | Basket capacity is changed to a positive integer by a "manager"<br/>Basket capacity value is not positive |                                                                                                                     | Return true<br/>Return false                                                                                                                                              |


### Assumptions:

- Fillings can be added regardless of the presence of a bagel in the basket.
- Fillings, coffee, and bagels count toward the maximum basket size.
- The "manager" role is purely fictional and not actually implemented