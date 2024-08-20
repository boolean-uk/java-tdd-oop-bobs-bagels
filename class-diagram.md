| ItemHandler                                      |
|--------------------------------------------------|
| -basket: HashMap<String, Item>                   |
| -basketCapacity: int                             |
| -allItems: HashMap<String, String>               |
| -idTracker: int                                  |
| -discountCounterMap: HashMap<String, List<Item>> |
|                                                  |
| +addItem(SKU: String): Item                      |
| +addItem(SKU: String, bagel: Bagel): Filling     |
| +removeItem(id: int): boolean                    |
| +setCapacity(newCapacity: int): boolean          |
| +searchItem(SKU: string): Item                   |
| +getTotal(): double                              |
| +setUpAllItems(): void                           |
| +coffeeAndBagelDiscount(): void                  |
| +twelveBagelDiscount(): void                     |
| +sixBagelDiscount(): void                        |
| +calcDiscountCounterMap(): void                  |
            /\ 1
            |
            | 0...n
| Item                   |
|------------------------|
| -SKU: String           |
| -price: double         |
| -variant: String       |
| -name: String          |
| -id: int               |
| -discountPrice: double |
|                        |
| +getTotal(): double    |

| Bagel                            | Filling       | Coffee |
|----------------------------------|---------------|--------|
| -fillings: ArrayList<Filling>    | -bagel: Bagel |        |
|                                  |               |        |
| +removeFilling(id: int): boolean |               |        |
| +getTotal(): double              |               |        |
