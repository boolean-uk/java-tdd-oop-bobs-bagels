# Bob's Bagels -- Domain model

## Class: Item

### Member variables

- sku: String
- price: double
- name: String
- variant: String
- size: int (e.g., fillings maybe don't take up capacity)

### Methods

Accessors for all fields.

## Class: Basket

### Member variables

- capacity: static int
- items: List<Item>

### Methods

| Method                                             | Scenario                                            | Result                                                      |
|----------------------------------------------------|-----------------------------------------------------|-------------------------------------------------------------|
| addItem(name: String, variant: String): boolean    | Basket is full                                      | Return false. Print error message, don't add item to basket |
| addItem(item: Item): boolean                       | Basket is not full                                  | Return true. Add item to basket.                            |
|                                                    | One or more fields are invalid (shop doesn't stock) | Return false. Print error message.                          |
| removeItem(name: String, variant: String): boolean | Item is not found in basket                         | Return false. Print error message.                          |
|                                                    | Item is found in basket                             | Return true. Remove item from basket.                       |
| setCapacity(newCapacity: int): static void         | newCapacity is valid (> 0)                          | Update the basket capacity.                                 |
|                                                    | newCapacity is not valid (<= 0)                     | Don't change the basket capacity.                           |
| getCapacity(): int                                 |                                                     |                                                             |
| getTotalCost(): double                             |                                                     | Calculate and return the cost of items in basket.           |

## Class: ShopHandler

This is the public interface that a customer or manager interacts with the Bob's Bagels system through.

### Member variables

- basket: Basket
- ~~stockedItems: `List<Map<attribute (String), value (String)>>()`~~
- - stockedItems: `List<Item>` (copy existing items when adding new items)

### Methods

| Method                                                                   | Scenario | Result                                                            |
|--------------------------------------------------------------------------|----------|-------------------------------------------------------------------|
| placeOrder(): void                                                       |          | Guide the customer through selecting items to order (interactive) |
| showItems(): String                                                      |          | Return String of bagels and coffee w/ prices                      |
| showFillings(): String                                                   |          | Return String of fillings w/ prices                               |
| orderBagel(): boolean                                                    |          | Add a bagel with optional filling to basket if it's not full.     |
| orderCoffee(): boolean                                                   |          | Add coffee with optional bagel for a discount if it's not full.   |
| setBasketCapacity(): void                                                |          | Update the basket capacity for all baskets.                       |
| calculateDiscounts(): double                                             |          | Apply the discounts and return savings.                           |
| showReceiptWithDiscounts(): String                                       |          | Return String with receipt, including discounts.                  |
| show/Fillings/Bagels/Coffees(): String                                   |          | Return String showing possible orders and prices                  |
| Some helper functions that I don't think are important enough to mention |          |                                                                   |

## Class: Coffee

Inherits from: Item.

### Member variables:
- discountBagel: Bagel

### Methods

| Method                    | Scenario                           | Result                                        |
|---------------------------|------------------------------------|-----------------------------------------------|
| getSize(): int            |                                    | Returns size, includes optional discountBagel |   |                                               |
| getPrice(): double        |                                    | includes optional discountBagel               |
| getDiscountBagel(): Bagel | There is a bagel/there is no bagel | Returns the bagel/returns null                |

## Class: Bagel

Inherits from: Item

### Member variables:

- filling: Item

### Methods

| Method             | Scenario                             | Result                           |
|--------------------|--------------------------------------|----------------------------------|
| getSize(): int     |                                      | Returns size                     |
| getPrice(): double |                                      | includes optional filling        |
| getFilling(): Item | There is filling/there is no filling | Returns the filling/returns null |

# Class: Main

Run interactive interface to interactively place an order. (Not up to date with extensions.)

# User stories (extension)

- As a customer, I want to be able to have a bagel with my coffee for a discount.
- As a customer, I want multi-priced discounts to apply at checkout.
- As a customer, I want to get a receipt when paying.
- As a concerned customer, I want to know how much I saved using discounts.