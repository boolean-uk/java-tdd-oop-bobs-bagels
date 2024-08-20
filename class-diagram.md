| ItemHandler                                            |
|--------------------------------------------------------|
| -basket: ArrayList < Item >                            |
| -basketCapacity: int                                   |
| -allItems: HashMap < String, String >                  |
| -idTracker: int                                        |
| -discountCounterMap: HashMap < String, List < Item > > |
| -receipt: Receipt                                      |
|                                                        |
| +addItem(SKU: String): Item                            |
| +addItem(SKU: String, bagel: Bagel): Filling           |
| +removeItem(id: int): boolean                          |
| +setCapacity(newCapacity: int): boolean                |
| +searchItem(SKU: string): double                       |
| +getTotal(): double                                    |
| +setUpAllItems(): void                                 |
| +coffeeAndBagelDiscount(): void                        |
| +twelveBagelDiscount(): void                           |
| +sixBagelDiscount(): void                              |
| +calcDiscountCounterMap(): void                        |
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

| Bagel                               | Filling       | Coffee |
|-------------------------------------|---------------|--------|
| -fillings: ArrayList < Filling >    | -bagel: Bagel |        |
|                                     |               |        |
| +addFilling(filling: Filling): void |               |        |
| +removeFilling(id: int): boolean    |               |        |
| +getTotal(): double                 |               |        |


| Receipt                                                         |
|-----------------------------------------------------------------|
| -orderedItemsListsMap: HashMap < String, List < Item > >        |
| -orderStrings: ArrayList < String >                             |
| -totalDiscount: double                                          |
|                                                                 |
| +printReceipt(): void                                           |
| +resetReceipt(): void                                           |
| +createOrderStrings(): void                                     |
| +addToOrderedItemsListsMap(item: Item): void                    |
| +formatString(sum: double, itemList: List < Item >): String     |
| +formatDiscountString(originalSum: double, sum: double): String |

