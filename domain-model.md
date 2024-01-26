| Class  | Variables                            | Method                 | Scenario                     | Return value |
|--------|--------------------------------------|------------------------|------------------------------|--------------|
| Basket | HashMap<String, Integer> bagelBasket | addBagel(String bagel) | Empty or not valid input     | Return false |
|        |                                      |                        | Valid input add bagel to map | Return true  |

| Class  | Variables                            | Method                    | Scenario                          | Return value |
|--------|--------------------------------------|---------------------------|-----------------------------------|--------------|
| Basket | HashMap<String, Integer> bagelBasket | removeBagel(String bagel) | Empty or not valid input          | Return false |
|        |                                      |                           | Valid input remove bagel from map | Return true  |

| Class  | Variables                            | Method                 | Scenario                        | Return value             |
|--------|--------------------------------------|------------------------|---------------------------------|--------------------------|
| Basket | HashMap<String, Integer> bagelBasket | addBagel(String bagel) | Empty or not valid input        | Return "no such product" |
|        | int limit                            |                        | Basket full can't add to basket | Return "basket is full   |

| Class   | Variables | Method                          | Scenario                         | Return value             |
|---------|-----------|---------------------------------|----------------------------------|--------------------------|
| Manager |           | basketCapacitySetter(int limit) | Capacity set to allowed size     | Capacity set to size     |
|         |           |                                 | Capacity set to non allowed size | Cant set the chosen size |

| Class  | Variables                            | Method               | Scenario                   | Return value                  |
|--------|--------------------------------------|----------------------|----------------------------|-------------------------------|
| Basket | HashMap<String, Integer> bagelBasket | remove(String bagel) | Empty input                | Invalid input                 |
|        |                                      |                      | Remove item dosen't exists | Cant remove non existing item |


| Class    | Variables                            | Method           | Scenario               | Return value     |
|----------|--------------------------------------|------------------|------------------------|------------------|
| Customer | HashMap<String, Integer> bagelBasket | costCalculator() | Has products           | Cost of products |
|          |                                      |                  | Basket has no products | Return 0         |


| Class  | Variables          | Method             | Scenario    | Return value            |
|--------|--------------------|--------------------|-------------|-------------------------|
| Basket | ArrayList<> bagels | getCostOfProduct() | Has product | Return cost for product |
|        |                    |                    | No product  | Return 0                |


| Class  | Variables                            | Method                         | Scenario               | Return value    |
|--------|--------------------------------------|--------------------------------|------------------------|-----------------|
| Basket | HashMap<String, Integer> bagelBasket | fillingToBagel(String filling) | Filling added to bagel | Filling added   |
|        |                                      |                                | Basket has no bagel    | No bagel in map |

| Class    | Variables          | Method                  | Scenario               | Return value            |
|----------|--------------------|-------------------------|------------------------|-------------------------|
| Customer | ArrayList<> bagels | costCalculatorFilling() | Fillings price listed  | All the fillings prices |
|          |                    |                         | Basket has no products | Return no fillings      |

| Class    | Variables          | Method          | Scenario                          | Return value            |
|----------|--------------------|-----------------|-----------------------------------|-------------------------|
| Customer | ArrayList<> bagels | orderFromList() | Has chosen product in list        | Add order               |
|          |                    |                 | Don't have chosen product in list | No such product in list |
