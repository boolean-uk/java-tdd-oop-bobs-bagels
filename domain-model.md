
| Classes        | Members                                       | Methods                                                                        |
|----------------|-----------------------------------------------|--------------------------------------------------------------------------------|
| `Basket`       | `ArrayList<Product> basket`                   | `addBagel(Product product)`                                                    |
|                | `int capacity`                                | `removeBagel(Product product)`                                                 |
|                |                                               | `isBasketFull()`                                                               |
|                |                                               | `setCapacity(int newCapacity)`                                                 |
|                |                                               | `getTotalCost(Inventory inventory)`                                            |
|                |                                               | `generateReceipt(String storeName, Inventory inventory)`                       |
|                |                                               |                                                                                |
| `Product`      | `String name`                                 | `getName()`                                                                    |
|                | `double price`                                | `getPrice()`                                                                   |
|                | `String SKU`                                  | `getSKU()`                                                                     |
|                |                                               |                                                                                |
| `Bagel`        | `Inherits from Product`                       | `getType()`                                                                    |
|                | `List<String> selectedFillings`               | `addFillings(String filling, HashMap<String, Filling> fillingsInventory`       |
|                |                                               | `calculateBagelsCost<HashMap<String, FIlling> fillingInventory`                |
|                |                                               |                                                                                |
| `Coffee`       | `inherits from Product`                       |                                                                                |
|                |                                               |                                                                                |
| `Filling`      | `inherits from Product`                       |                                                                                |
|                |                                               |                                                                                |
| `SpecialOffer` | `String SKU`                                  | `getSKU()`                                                                     |
|                | `int quantity`                                | `getQuantity`                                                                  |
|                | `double offerPrice`                           | `getOfferPrice()`                                                              |
|                |                                               |                                                                                |
| `Inventory`    | `HashMap<String, Product> productInventory`   | `getProductInventory()`                                                        |
|                | `HashMap<String, SpecialOffer> specialOffers` | `getSpecialOffer()`                                                            |
|                |                                               | `addProduct(Product product)`                                                  |
|                |                                               | `addSpecialOffer(SpecialOffer specialOffer)`                                   |
|                |                                               | `isProductAvailable(String SKU)`                                               |
|                |                                               | `getProductPrice(String SKU)`                                                  |
|                |                                               |                                                                                |
| `ReceiptItem`  | `Product product`                             | `getProductName()`                                                             |
|                | `int quantity`                                | `getQuantity`                                                                  |
|                | `double cost`                                 | `getCost`                                                                      |
|                | `double specialOfferCost`                     | `getSpecialOffersCost`                                                         |
|                |                                               |                                                                                |
| `Receipt`      | `ArrayList<ReceiptItem> items`                | `addItem(Product product, int quantity, double cost, double specialOfferCost)` |
|                | `String storeName`                            | `printReceipt()`                                                               |
|                | `Date timestamp`                              | `getItems()`                                                                   |
|                | `double totalCost`                            |                                                                                |

