# OrderManager
Handles the users cart and store system. Holds the cart.
## Variables

| Name                                         | Usage                                                      |
|----------------------------------------------|------------------------------------------------------------|
| static HashMap<Item, String[]> storeItemInfo | used to simulate database containing item pricing and info |
| static HashMap<Item, Integer> storeItemStock | used to keep track of itemstock                            |
| HashMap<Item, Integer> cart                  | A hashmap with all items added to kart and quantity        |
| int maxCartSize                              | Used by manager to regulate basket size                    |

## Methods

| Signature                                  | Scenario                                                                 | Outcome                                                                  |
|--------------------------------------------|--------------------------------------------------------------------------|--------------------------------------------------------------------------|
| static openUpShopAndSetInventory(): void   | Used when OrderManager is instantiated                                   | storeItemInfo is set                                                     |
| addItem(Item item): String                 | When customer wants to add to cart                                       | item is added to cart                                                    |
| removeItem(Item item): String              | when customer wants to remove an item from cart                          | cart is removed from string if it is in cart. Return error string if not |
| setMaxCartSize(int i): void                | when manager wants to set cart size                                      | cart size is set                                                         |
| getTotalCartPriceWithoutDiscount(): double | when user wants to know current sum of cart without discounts            | double is returned                                                       |
| getPriceOfItem(Item item): double          | when user wants to know the price of a single item                       | price is returned                                                        |
| getStockOfItem(Item item): int             | when user wants to know the stock if a given item                        | amount of stock is returned                                              |
| getTotalDiscountReceiptString(): double    | when user wants to see the complete receipt                              | receipt in string format is returned                                     |
| getTotalDiscountReceipt(): Receipt         | when user wants to use or inspect the receipt created <br/> a given cart | receipt object is created and returned                                   |                                       |                                                                          |                                                                          |


 # Receipt
Small container of information for creating a nice receipt

## Variables

| Name                            | Usage                                             |   
|---------------------------------|---------------------------------------------------|
| receiptOrder: ArrayList<String> | list with all ordered items in .csv format        |
| discountedPrice: double         | price after calculating discount                  |
| nonDiscountedPrice: double      | price without calculating discount                |
| date: LocalDateTime             | object containing the date the receipt is created |


## Methods

| Signature                               | Scenario                                                 | Outcome                                                |
|-----------------------------------------|----------------------------------------------------------|--------------------------------------------------------|
| getYYYYMMDD: String                     | When we want to converet the date to a nicer date format | returns date at yyyy-mm-dd format                      |
| getISOTime: String                      | when we want the time of the receipt                     | returns hh-mm-ss of date in str                        |
| getTotalDiscountReceiptString(): String | When the user wants to view the receipt                  | return a pretty and formatted receipt with linebreaks. |
|                                         |                                                          |                                                       
