# Model for core part
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

## Model information

Basket class represents a basket for holding items, including functionality for adding, removing and calculating the total price of items.


| Class  | Fields                   | Role                                    | Methods                               | Scenario                                                                | Output                                      |
|--------|--------------------------|-----------------------------------------|---------------------------------------|-------------------------------------------------------------------------|---------------------------------------------|
| Basket | Map<Item, Integer> items | A map that stores items and theirs id's | boolean addItem(Item item)            | If customer wants to add a specific type of bagel to his basket.        |                                             |
|        | int capacity             | The maximum capacity of the basket      |                                       | If it is possible to add an item to the basket.                         | true                                        |
|        | int DEFAULT_CAPACITY     | The default capacity of the basket      |                                       | If it is not possible to add an item to the basket.                     | false                                       |
|        |                          |                                         | boolean removeItem(Item item)         | If customer wants to remove a bagel from his basket.                    |                                             |
|        |                          |                                         |                                       | If it is possible to remove an item from the basket.                    | true                                        |
|        |                          |                                         |                                       | If it is not possible to remove an item from the basket.                | false                                       |
|        |                          |                                         | boolean isFull()                      | Called when customer adds a bagel to his basket.                        |                                             |
|        |                          |                                         |                                       | If number of bagels equals basket capacity                              | true                                        |
|        |                          |                                         |                                       | If number of bagels is less than basket capacity                        | false                                       |
|        |                          |                                         | void setCapacity(int newCapacity)     | If manager would like to change the capacity of baskets.                |                                             |
|        |                          |                                         |                                       | If new capacity is less than number of bagels in basket.                | Output error message                        |
|        |                          |                                         |                                       | If new capacity is greater than or equal to number of bagels in basket. | Output nothing                              |
|        |                          |                                         | int getCapacity()                     | Returns the current capacity of the basket.                             |                                             |
|        |                          |                                         | boolean IsInBasket(Item item)         | Called when customer tries to remove a bagel from his basket.           |                                             |
|        |                          |                                         |                                       | If item is in the basket.                                               | true                                        |
|        |                          |                                         |                                       | If item is not in the basket.                                           | false                                       |
|        |                          |                                         | BigDecimal getTotalPrice()            | If customer wants to know how much he'll pay.                           | The price of items in the basket            |
|        |                          |                                         | BigDecimal checkPrice(Item item)      | If customer wants to know the cost of a specific item.                  | The price of a bagel of the given type.     |
|        |                          |                                         | List\<Filling> getAvailableFillings() | Called when customer wants to know the list of available fillings.      | The list of available fillings for a bagel. |

Item represents a general item based on SKU (Stock keeping unit).

| Class | Fields  | Role               | Methods               | Scenario                                         | Output                    |
|-------|---------|--------------------|-----------------------|--------------------------------------------------|---------------------------|
| Item  | SKU sku | Stock keeping unit | BigDecimal getPrice() | If customer wants to know the price of the item. | The price of the item     |
|       |         |                    | String getName()      | Returns the name of the item.                    | The name of the item.     |
|       |         |                    | String getVariant()   | Returns the variant of the item.                 | The variant of the item.  |

Bagel class extends Item and enables inputting a chosen filling into Bagel.

| Class | Fields       | Role                                      | Methods                             | Scenario                                                                           | Output                  |
|-------|--------------|-------------------------------------------|-------------------------------------|------------------------------------------------------------------------------------|-------------------------|
| Bagel | Item filling | The filling added to the bagel (optional) | BigDecimal getPrice()               | Returns the price of the bagel (with additional filling if present)                | The price od the bagel. |
|       |              |                                           | boolean addFilling(Filling filling) | If customer wants to add a filling to his bagel (if he does not already have one). |                         |
|       |              |                                           |                                     | If customer adds a filling to his bagel.                                           | true                    |
|       |              |                                           |                                     | If customer does not add a filling to his bagel.                                   | false                   |

Filling class extends Item and it represents a filling item.

| Class   | Fields | Role | Methods | Scenario | Output |
|---------|--------|------|---------|----------|--------|
| Filling |        |      |         |          |        |

SKU is a data type (enum), that represents various items (their price, name and variant) based on SKU constant.

| Class | Fields            | Role | Methods                                      | Scenario                                               | Output                                       |
|-------|-------------------|------|----------------------------------------------|--------------------------------------------------------|----------------------------------------------|
| SKU   | BigDecimal price; |      | BigDecimal getPrice()                        | Returns the price of the specific SKU.                 | The price of the specific SKU.               |
|       | String name;      |      | String getName()                             | Returns the name connected with the specific SKU.      | The name connected with the specific SKU.    |
|       | String variant;   |      | String getVariant()                          | Returns the variant connected with the specific SKU.   | The variant connected with the specific SKU. |
|       |                   |      | SKU getConstant(Item item)                   | If I want to get SKU based on Item object.             | The constant SKU.                            |
|       |                   |      | SKU getConstant(String name, String variant) | If I want to get SKU based on Item's name and variant. | The constant SKU.                            |

### EXTENSION1
User stories:
```
1. As a customer, 
I want to be able to order items from Bob's Bagels using SKUs.

2. As a customer, 
I want to be able to view the total price of my order.

3. As a manager, 
I want to announce special offers for my customers, such as:
- for Onion/Everything variant: "6 for 2.49" 
- for Plain variant: "12 for 3.99"

4. As a manager, 
I want to announce a special offer for my customers: "Coffee & Bagel for 1.25".

5. As a customer, 
I want to see on my receipt which special offers were included and how they were calculated.
```

| Class | Fields | Role | Methods | Scenario | Output |
|-------|--------|------|---------|----------|--------|
|       |        |      |         |          |        |
|       |        |      |         |          |        |
|       |        |      |         |          |        |
|       |        |      |         |          |        |
|       |        |      |         |          |        |
|       |        |      |         |          |        |



As a customer, I want to be able to generate a receipt for my order.
As a customer, I want the receipt to display the date and time of the order.
As a customer, I want the receipt to list the ordered items, including their names, quantities, and prices.
As a customer, I want the receipt to display the total price of the order.
As a customer, I want the receipt to include a thank you message.

As a customer, I want to see the savings on my receipt, indicating the amount saved for each item and the total savings.
As a customer, I want the savings to be displayed in parentheses() next to the item price.
As a customer, I want to see the total savings for the entire order.