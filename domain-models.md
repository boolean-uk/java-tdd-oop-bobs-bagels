
### Basket Class ###

| Method          | Description                             | Outcomes                  |
|-----------------|-----------------------------------------|---------------------------|
| addItem()       | Add item to basket.                     | True if item is added.    |
| removeItem()    | Remove item from basket.                | True if item is removed.  |
| getTotalCost()  | Calculate total cost of items.          | Return float.             |
| isFull()        | Check basket capacity.                  | True if basket is full.   |
| getItems()      | List of items in basket.                | Return list of items.     |
| discountPrice() | Calculate total cost with discounts.  	 | Return double.            |
| printReceipt()  | Print formatted receipt                 | Return receipt as string. |

### Basket attributes ###

| List<Item> | Int Capacity | menu Map<String, item> |
|------------|--------------|------------------------|

------------------------------------------------------------------------

### Item Class ###

| Method     | Description          | Outcomes       |
|------------|----------------------|----------------|
| getPrice() | Retrieve item price. | Return float.  |
| getName()  | Retrieve item name.  | Return string. |
| getSku()   | Retrieve item SKU. 	 | Return string  |

### Item attributes ###

| String name | Float price | String SKU (identifier) |
|-------------|-------------|-------------------------|

------------------------------------------------------------------------

### Bagel class ###

| Method        | description            | Outcomes                   |
|---------------|------------------------|----------------------------|
| addFilling()  | Add filling to bagel.  | Filling is added to bagel. |
| getFillings() | Retrieve filling list. | Returns list of fillings.  |


### Bagel attributes ###

| String variant | List<filling> |
|----------------|---------------|


------------------------------------------------------------------------
### Coffee class ###
| Method     | Description              | Outcomes       |
|------------|--------------------------|----------------|
| getPrice() | Retrieve coffee price.   | Return float.  |
| getName()  | Retrieve coffee name.    | Return string. |
| getSku()   | Retrieve coffee SKU.   	 | Return string  |


### Coffee attributes ###
| String name | Double price | String SKU (identifier) |
|-------------|--------------|-------------------------|


------------------------------------------------------------------------
### Filling class ###
| Method     | Description              | Outcomes       |
|------------|--------------------------|----------------|
| getPrice() | Retrieve filling price.  | Return float.  |
| getName()  | Retrieve filling name.   | Return string. |
| getSku()   | Retrieve filling SKU.  	 | Return string  |

### Filling attributes ###

| String name | Double price | String SKU (identifier) |
|-------------|--------------|-------------------------|
