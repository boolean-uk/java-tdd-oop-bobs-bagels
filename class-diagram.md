````mermaid
classDiagram
    class Basket{    
        - product : ArrayList < Product >
        - size : int
        - total : double
        - discount : double
        + addToBasket(Product) boolean
        + addToBasket(Product, int) boolean
        + removeFromBasket(Product) boolean
        + removeFromBasket(Product, int) boolean
        + changeSize(int) boolean
        + getTotal() Double
        + showPrices(Inventory) void
        + showPrices(String, Inventory) void
        + showPrices(String[], Inventory) void
        }
    class Product{    
        - name : String
        - variant : String
        - sku : String
        - price : double
        - inventory : Inventory
        + getPrice() Double
        + getName() String
        + getSku() String
        + getVariant() String
        + showPrice() void
        }
    class Inventory{    
        - prices : Map
        - stock : Map
        - names : Map
        - variants : Map
        + restockAll() boolean
        + restock(String sku) boolean
        + changePrice(String sku, double price) boolean
        + getPrice(String sku) Double
        + getName(String sku) String
        + getVariant(String sku) String
        + getStock(String sku) int
        }
    class BobsBagels{
        - mainMenu : String
        - managerMenu : String
        - shopMenu : String
        - sc : Scanner
        - inventory : Inventory
        - basket : Basket
    }
    class Receipt{
        - receipt : String
        + generateReceipt() : String
    }
    Basket ..> Product
    Product ..> Inventory
    BobsBagels ..> Basket
    BobsBagels ..> Inventory
    Receipt ..> Basket
````