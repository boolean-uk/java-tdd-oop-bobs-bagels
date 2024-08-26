# Bob's Bagels OOP
 
## Core requirements
- [x] #1 I'd like to add a specific type of bagel to my basket.
- [x] #2 I'd like to remove a bagel from my basket.
- [x] #3 I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
- [x] #4 I’d like to change the capacity of baskets.
- [x] #5 I'd like to know if I try to remove an item that doesn't exist in my basket.
- [x] #6 I'd like to know the total cost of items in my basket.
- [x] #7 I'd like to know the cost of a bagel before I add it to my basket.*
- [x] #8 I'd like to be able to choose fillings for my bagel.
- [x] #9 I'd like to know the cost of each filling before I add it to my bagel order.*
- [x] #10 I want customers to only be able to order things that we stock in our inventory.**

\* The inventory have functionality to print out the menu, but there are no functions that follows abstraction like 
'getAllBagels()' etc. There is only functionality to get the inventory Map/List that contains objects with getPrice() functions.

** The inventory doesn't count how many of each item in stock, but customers can only choose things that are in the inventory.

## Extension 1

### User Stories

```
1.
As a manager,
So the customers can benefit from our discounts,
I want the discounts for all items in basket to be calculated autoamtically.
```

### Comments
- Added the classes SpecailOffer, SpecialOfferCombination, SpecialOfferMultiPrice to 'package: inventory'
- Added the classes DiscountObjectCombination and DiscountObjectMultiPrice to 'package: calculators'. Because the discount is calculated in the PriceCalculator class.

### Method/Calculation notes
```
# Discounts

if discount 6 for 2.55  
   get normalPrice  
   normalPrice - discountPrice = discount

   get all items with SKU X  
   6 // numOfItems = number of discounts  
   number of discounts * discount.

   result for this SKU = totalCost - totalDiscount

if discount is Coffe + Bagel = 1.33
  get normalPrice
  normalPrice - discountPrice = discount

  get all occurencies of product A
  get all occurencies of product B

  if one or both is 0 -> no discount
  if A = B -> discounts on all pairs
  if A < B -> discount * the same number as A
    and vice versa
```

## Extension 2