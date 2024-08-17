Objects
Found in oop-model.png

Basket class so far

| Class  | Members Variable        | Methods                         | Scenario                                                                                                          | Output                                                           |
|--------|-------------------------|---------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| Basket | Hashmap<Product> basket |                                 |                                                                                                                   |                                                                  |
|        | int basketSize          |                                 |                                                                                                                   |                                                                  |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | add(Product)                    | Should add Product or Coffee to the basket. If product already in basket, add one to it's quantity.               | "Existing product added to basket / new product added to basket" |
|        |                         |                                 | If product or coffee not found.                                                                                   | "Failed to add order"                                            |
|        |                         |                                 | If basket is fulL                                                                                                 | "Basket is full"                                                 |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | remove(Product)                 | Should get(i) of the product and remove it from the basket. If quantity over 1 then subtract the quantity by one. | "Product removed"                                                |
|        |                         |                                 | If the quantity is one then remove the object from the basket.                                                    | "Product removed"                                                |
|        |                         |                                 | If not found in basket:                                                                                           | "Product not in basket"                                          |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | getTotalCost()                  | should get the total price of all the products in basket.                                                         | int finalPrice                                                   |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | changeCapacity(int newSize)     | should change the member variable basketSize to newBasketSize                                                     | "Size changed"                                                   |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | checkCurrentBasketCost(Product) | should return the int of specifically that product's cost.                                                        | int price                                                        |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | getBagelCost(Product)           | Should get the cost of bagel only.                                                                                | int price                                                        |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         | getFillingCost(Filling)         | Should get the cost of a specific filling.                                                                        | int price                                                        |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         |                                 |                                                                                                                   |                                                                  |
|        |                         |                                 |                                                                                                                   |                                                                  |
















    


| Class   | Members Variable    | Methods                   | Scenario                                                                     | output                                                       |   |
|---------|---------------------|---------------------------|------------------------------------------------------------------------------|--------------------------------------------------------------|---|
| Product | double productPrice | productAdd(String sku)    | Should add the related sku bagel or filling to the product                   | "Added to product"                                           |   |
|         |                     |                           | If sku object not found                                                      | "Failed to add product, sku not found"                       |   |
|         |                     |                           |                                                                              |                                                              |   |
|         |                     | productRemove(String sku) | If found in Product it should remove the related sku object from the product | "Removed from product"                                       |   |
|         |                     |                           | not found in product                                                         | "Failed to remove product, not in product or sku not found." |   |
|         |                     |                           |                                                                              |                                                              |   |
|         |                     |                           |                                                                              |                                                              |   |
'
