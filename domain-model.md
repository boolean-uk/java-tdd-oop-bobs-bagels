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

## DOMAIN MODEL

| Class            | Attributes        | Methods | Scenario | Outputs |
|------------------|-------------------|---------|----------|---------|
| Abstract Product | SKU: String       |         |          |         |
|                  | price: BigDecimal |         |          |         |

| Class                 | Attributes              | Methods                             | Scenario                                             | Outputs |
|-----------------------|-------------------------|-------------------------------------|------------------------------------------------------|---------|
| Bagel extends Product | variant: BagelVariant   | getPriceWithFillings(): BigDecimal  | calculates totals price including all added fillings | double  |
|                       | fillings: List<Filling> | addFilling(Filling filling):boolean | If filling added correctly                           | true    |
|                       |                         |                                     | If filling added incorrectly                         | false   |


| Class                   | Attributes              | Methods | Scenario | Outputs |
|-------------------------|-------------------------|---------|----------|---------|
| Filling extends Product | variant: FillingVariant |         |          |         |

| Class                  | Attributes             | Methods | Scenario | Outputs |
|------------------------|------------------------|---------|----------|---------|
| Coffee extends Product | variant: CoffeeVariant |         |          |         |

| Class  | Attributes              | Methods                                                                                                                  | Scenario                                                                  | Outputs    |
|--------|-------------------------|--------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|------------|
| Basket | products: List<Product> | addProduct(Product product): boolean                                                                                     | product added successfully                                                | true       |
|        | capacity: int           |                                                                                                                          | adding product failed                                                     | false      |
|        |                         | isFull(): boolean                                                                                                        | if products.size == capacity                                              | true       |
|        |                         |                                                                                                                          | if products.size < capacity                                               | false      |
|        |                         | isProductInBasket(Product product): boolean                                                                              | if basket contains product                                                | true       |
|        |                         |                                                                                                                          | if basket doesn't contains product                                        | false      |
|        |                         | summarizeBasket(): BigDecimal                                                                                            | summarize all products with optional fillings in basket                   | BigDecimal |
|        |                         | summarizeBasketWithoutDiscounts(): BigDecimal                                                                            | summarize all products with optional fillings in basket without discounts | BigDecimal |
|        |                         | isProductAvailable(Product product): boolean                                                                             | if product is in Bob's inventory                                          | true       |
|        |                         |                                                                                                                          | if product isn't in Bob's inventory                                       | false      |
|        |                         | getAmountOfDiscountOccurrences(Discount discount):BigDecimal                                                             | gets amount of discounts occurrences                                      | BigDecimal |
|        |                         | isSingleProductDiscount(Discount discount):boolean                                                                       | if single product discounts                                               | true       |
|        |                         |                                                                                                                          | if single product doesn't discount                                        | false      |
|        |                         | isDiscountRequirementMet(Discount discount) :boolean                                                                     | if discount requirement are met                                           | true       |
|        |                         |                                                                                                                          | if discount requirement are not met                                       | false      |
|        |                         | addSavedMoney(HashMap<Product,BigDecimal> discounts,Discount discount):void                                              | adds saved money                                                          | void       |
|        |                         | applyDiscounts(HashMap<Product, BigDecimal> savings, BigDecimal total):BidDecimal                                        | applies  discounts                                                        | BigDecimal |
|        |                         | applySingleDiscount(HashMap<Product, BigDecimal> savings, BigDecimal total, SingleProductDiscount discount)              | applies single discount                                                   | BigDecimal |
|        |                         | applyMultipleProductsDiscount(HashMap<Product, BigDecimal> savings, BigDecimal total, MultipleProductsDiscount discount) | applies multiple products discount                                        | BigDecimal |
|        |                         | hasRequiredAmountOfThisProduct(Discount discount):boolean                                                                | has required amount of discounted product                                 | true       |
|        |                         |                                                                                                                          | has not required amount of discounted product                             | false      |
|        |                         | isProductAlreadyDiscounted(HashMap<Product, BigDecimal> savings, Discount discount)                                      | product already discounted                                                | true       |
|        |                         |                                                                                                                          | product not already discounted                                            | false      |

| Class         | Attributes       | Methods | Scenario | Outputs |
|---------------|------------------|---------|----------|---------|
| Abstract User | fullName: String |         |          |         |

| Class                 | Attributes     | Methods | Scenario | Outputs |
|-----------------------|----------------|---------|----------|---------|
| Customer extends User | basket: Basket |         |          |         |

| Class   | Attributes | Methods                            | Scenario | Outputs |
|---------|------------|------------------------------------|----------|---------|
| Manager |            | checkProductPrice(Product product) |          |         |

| Class     | Attributes                        | Methods                                     | Scenario                            | Outputs |
|-----------|-----------------------------------|---------------------------------------------|-------------------------------------|---------|
| Inventory | availableProducts:List<Products>  | isProductAvailable(Product product):boolean | if product is available             | true    |
|           | availableDiscounts:List<Discount> | isProductAvailable(Product product):boolean | if product is not available         | false   |
|           |                                   | loadAvailableBagels():void                  | loads  Bagels to availableProducts  | void    |
|           |                                   | loadAvailableCoffees():void                 | loads  Coffees to availableProducts | void    |
|           |                                   | loadAvailableFillings():void                | loads Fillings to availableProducts | void    |

| Class   | Attributes                        | Methods                                                   | Scenario                                       | Outputs                      |
|---------|-----------------------------------|-----------------------------------------------------------|------------------------------------------------|------------------------------|
| Receipt | products:HashMap<Product,Integer> | createReceipt(Basket basket):void                         | Creates receipt of given basket                | void                         |
|         |                                   | printReceipt(Basket basket):StringBuilder                 | prints receipt                                 | StringBuilder recepit        |
|         |                                   | showBagelOnReceipt(Bagel bagel, int amount):StringBuilder | prints bagel on the receipt  with his fillings | StringBuilder bagelOnReceipt |

| Class    | Attributes                     | Methods                     | Scenario                                     | Outputs |
|----------|--------------------------------|-----------------------------|----------------------------------------------|---------|
| Shopping |                                | addItemToBasket():void      | Adds item to basket with user interface      | void    |
|          | customer:Customer              | removeItemFromBasket():void | Removes item from basket with user interface | void    |
|          | inventory:Inventory            |                             |                                              |         |
|          | customer:Customer              |                             |                                              |         |
|          | customerName:String            |                             |                                              |         |
|          | showInventory:String           |                             |                                              |         |
|          | addToBasket:String             |                             |                                              |         |
|          | removeFromBasket:String        |                             |                                              |         |
|          | showBasket:String              |                             |                                              |         |
|          | combinedMenuText:StringBuilder |                             |                                              |         |

| Class    | Attributes                      | Methods | Scenario | Outputs |
|----------|---------------------------------|---------|----------|---------|
| Discount | product:Product                 |         |          |         |
|          | requiredAmount:int              |         |          |         |
|          | discountedPrice:BigDecimal      |         |          |         |
|          | optionalRequiredProduct:Product |         |          |         |

| Class                                     | Attributes                       | Methods | Scenario | Outputs |
|-------------------------------------------|----------------------------------|---------|----------|---------|
| MultipleProductsDiscount extends Discount | optionalRequiredProduct: Product |         |          |         |

| Class                                  | Attributes | Methods | Scenario | Outputs |
|----------------------------------------|------------|---------|----------|---------|
| SingleProductDiscount extends Discount |            |         |          |         |
