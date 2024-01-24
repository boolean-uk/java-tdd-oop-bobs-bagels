# Bob's Bagels Core


## User Stories
```
1.
As a member of the public,
So I can order a bagel before work,
I'd like to add a specific type of bagel to my basket.
```

```
2.
As a member of the public,
So I can change my order,
I'd like to remove a bagel from my basket.
```

```
3.
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
```

```
4.
As a Bob's Bagels manager,
So that I can expand my business,
I’d like to change the capacity of baskets.
```

```
5.
As a member of the public
So that I can maintain my sanity
I'd like to know if I try to remove an item that doesn't exist in my basket.
```

```
6.
As a customer,
So I know how much money I need,
I'd like to know the total cost of items in my basket.
```

```
7.
As a customer,
So I know what the damage will be,
I'd like to know the cost of a bagel before I add it to my basket.
```

```
8.
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
```

```
9.
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
```

```
10.
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
```

## Domain Model

### Class Basket

| Methods                              | Member variables                                       | Scenario                     | Output/return                                  |
|--------------------------------------|--------------------------------------------------------|------------------------------|------------------------------------------------|
| {1,3,8, 10}`add(Item item)`          | HashMap<Item item, int amount> basketContent           | item *in* inventory and      | String "Item *item* added to basket."          |
|                                      | HashMap<Item item, int amount> BobsBagelShop.inventory | basket *is not* full.        |                                                |
|                                      | int basketCapacity                                     | item *not in* inventory.     | String "Chosen item not in stock."             |
|                                      |                                                        | basket *is* full.            | String "Basket is full."                       |
| {2,5}`remove(Item item)`             | HashMap<Item item, int amount> basketContent           | item *not in* basket.        | String "Item *item* not in basket."            |
|                                      |                                                        | item *in* basket.            | String "Item *item* removed from basket."      |
| {6}`totalCost()`                     | HashMap<Item item, int amount> basketContent           | Not empty basket.            | double price                                   |
|                                      | double item.price                                      | Empty basket.                | double price = 0.0.                            |
| {4}`changeCapacity(int newCapacity)` | int basketCapacity                                     | newCapacity < 0              | String "New capacity must be non negative."    |
|                                      |                                                        | newCapacity >= 0             |                                                |
|                                      |                                                        | && no baskets have more      | String "New basket capacity is *newCapacity*." |
|                                      |                                                        | items than newCapacity.      |                                                |
|                                      |                                                        | Baskets have more items than | String "New capacity must be larger than       |
|                                      |                                                        | newCapacity.                 | number of items currently in basket."          |
| {3,4}`checkSize()`                   | HashMap<Item item, int amount> basketContent           | Not empty basket.            | int numberOfItems                              |
|                                      |                                                        | Empty basket.                | int 0                                          |

### Class BobsBagelsShop

| Methods                                    | Member variables                          | Scenario                  | Output/Return                                         |
|--------------------------------------------|-------------------------------------------|---------------------------|-------------------------------------------------------|
| {7,9}`showInventory()`                     | HashMap<Item item, int amount>            | Inventory not empty.      | String "Bob's Bagels\nSKU\tPrice\tName\tVariant\n..." |
|                                            | inventory                                 | Inventory empty.          | String "No items in stock."                           |
| {1,2,8,10}`addToInventory(Item item)`      | HashMap<Item item, int amount> inventory  | Item removed from basket. |                                                       |
| {1,2,8,10}`removeFromInventory(Item item)` | HashMap<Item item, int amount> inventory  | Item added to basket.     |                                                       |


### Class Item

| Methods                                                       | Member variables | Scenario | Output/Return |
|---------------------------------------------------------------|------------------|----------|---------------|
| {7,9}`getPrice()`                                             | double price     |          | double price  |
| `Item(String sku, String name, String variant, double price)` | double price     |          |               |
|                                                               | String name      |          |               |
|                                                               | String variant   |          |               |
|                                                               | String sku       |          |               |

### Class Filling
Extends Item.

### Class Coffee
Extends Item.

### Class Bagel
Extends Item.

| Methods                           | Member variables                    | Scenario                 | Output/Return    |
|-----------------------------------|-------------------------------------|--------------------------|------------------|
| {8}`addFilling(Filling filling)`  | ArrayList<Filling filling> fillings | Filling not in fillings. | Add to fillings. |
|                                   |                                     | Filling in fillings.     |                  |
| `removeFilling(Filling filling)`  | ArrayList<Filling filling> fillings | Filling in fillings.     | Remove filling.  |
|                                   |                                     | Filling not in fillings. |                  |


# Bob's Bagels Extension
I have worked with extension 1, 2 and 3. 
In extension 1 the Bagel and Coffee discount do not work as intended. 
The customer gets discounts on more bagels than black coffees bought.

It is possible to print receipts with and without discounts.

## User Stories
```
11.
As a customer,
So I can double check that I paid for the right amount of items,
I'd like to get a receipt of my purchase.
```

```
12.
As a customer,
So I can see the price of every item and the total price,
I'd like to get a receipt of my purchase.
```

```
13.
As a Bob's Bagels manager,
So I can improve upselling,
I'd like to offer discounts to customers bying multiple items from the shop.
```

```
14.
As a customer,
So I can see which items I got a discount on,
I'd like to get a receipt that includes the savings.
```

## Domain model

### Class Receipt

| Methods                       | Member variables                                             | Scenario            | Output/Return                  |
|-------------------------------|--------------------------------------------------------------|---------------------|--------------------------------|
| generateReceipt()             | String receipt                                               | Empty basket.       | String "Basket is empty."      |
|                               | Basket basket                                                | Not empty basket.   | String receipt.                |
| createHeader()                | DateTime dateAndTime                                         |                     | String header.                 |
| createFooter()                |                                                              |                     | String footer.                 |
| printReceipt()                | String receipt                                               | Receipt (non)empty. | boolean printed.               |
|                               |                                                              |                     | system.out.println of receipt. |
| generateReceiptWithDiscount() | String receipt                                               | Empty basket.       | String "Basket is empty."      |
|                               | Basket basket                                                | Not empty basket.   | String receipt.                |
|                               | Hashmap<Item item, int[] priceAndSavings> mapPriceAndSavings |                     |                                |


### Class Basket

| Methods                     | Member variables                                             | Scenario          | Output/Return                               |
|-----------------------------|--------------------------------------------------------------|-------------------|---------------------------------------------|
| {13}discountPerItem()       | HashMap<Item item, int amount> basketContent                 | Not empty basket. | Hashmap<Item item, int[] priceAndSavings>   |
|                             | double item.getPrice()                                       |                   | Sum of price and savings is original price. |
|                             |                                                              |                   |                                             |
| {13}totalCostWithDiscount() | Hashmap<Item item, int[] priceAndSavings> mapPriceAndSavings | Not empty basket. | double price                                |
|                             |                                                              | Empty basket.     | double price = 0.0.                         |
|                             |                                                              | No discounts.     | Returns same double price as totalCost().   |