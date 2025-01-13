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

| Method                        | Scenario | Result                                                                |
|-------------------------------|----------|-----------------------------------------------------------------------|
| placeOrder(): void (boolean?) |          | Guide the customer through selecting items to order.                  |
| showItems(): String           |          | Return String of bagels and coffee w/ prices                          |
| showFillings(): String        |          | Return String of fillings w/ prices                                   |
| orderBagel(): void            |          | Let customer choose a bagel. Then, let customer add optional filling. |
| orderCoffee(): void           |          | Let customer choose a variant.                                        |
| setBasketCapacity(): void     |          | Update the basket capacity for all baskets.                           |
| Some private helper functions |          |                                                                       |

# Class: Main

Run interactive interface.