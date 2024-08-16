Objects
Found in oop-model.pg

Product class so far

| Class   | Members Variable                     | Methods                   | Scenario                                                                     | output                                                       |   |
|---------|--------------------------------------|---------------------------|------------------------------------------------------------------------------|--------------------------------------------------------------|---|
| Product | double productPrice                  | productAdd(String sku)    | Should add the related sku bagel or filling to the product                   | "Added to product"                                           |   |
|         | ArrayList<String> productDescription |                           | If sku object not found                                                      | "Failed to add product, sku not found"                       |   |
|         |                                      |                           |                                                                              |                                                              |   |
|         |                                      | productRemove(String sku) | If found in Product it should remove the related sku object from the product | "Removed from product"                                       |   |
|         |                                      |                           | not found in product                                                         | "Failed to remove product, not in product or sku not found." |   |
|         |                                      |                           |                                                                              |                                                              |   |
|         |                                      |                           |                                                                              |                                                              |   |

Basket class so far

| Class  | Members Variable        | Methods                             | Scenario                                                                                                          | Output                  |
|--------|-------------------------|-------------------------------------|-------------------------------------------------------------------------------------------------------------------|-------------------------|
| Basket | Hashmap<Product> basket |                                     |                                                                                                                   |                         |
|        | int basketSize          |                                     |                                                                                                                   |                         |
|        |                         |                                     |                                                                                                                   |                         |
|        |                         | addToBasket(Product)                | Should add Product or Coffee to the basket. If product already in basket, add one to it's quantity.               | "Added"                 |
|        |                         |                                     | If product or coffee not found.                                                                                   | "Failed to add order"   |
|        |                         |                                     |                                                                                                                   |                         |
|        |                         | removeFromBasket(Product)           | Should get(i) of the product and remove it from the basket. If quantity over 1 then subtract the quantity by one. | "Product removed"       |
|        |                         |                                     | If the quantity is one then remove the object from the basket.                                                    |                         |
|        |                         |                                     | If not found in basket:                                                                                           | "Product not in basket" |
|        |                         |                                     |                                                                                                                   |                         |
|        |                         | getFinalPrice()                     | should get the total price of all the products in basket.                                                         | int finalPrice          |
|        |                         |                                     |                                                                                                                   |                         |
|        |                         | changeBasketSize(int newBasketSize) | should change the member variable basketSize to newBasketSize                                                     | "Size changed"          |
|        |                         |                                     |                                                                                                                   |                         |
|        |                         | checkCost(Product)                  | should return the int of specifically that product's cost.                                                        | int productCost         |



