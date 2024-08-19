| ItemHandler                                       |
|---------------------------------------------------|
| -basket: HashMap<String, Item>                    |
| -basketCapacity: int                              |
| -allItems: HashMap<String, String>                |
| -idTracker: int                                   |
|                                                   |
| +addBaseItem(SKU: String): Item                   |
| +addFilling(SKU: String, bagel: Bagel): Filling   |
| +removeItem(id: int): boolean                     |
| +setCapacity(newCapacity: int): boolean           |
| +searchItem(SKU: string): Item                    |
            /\ 1
            |
            | 0...n
| Item             |
|------------------|
| -SKU: String     |
| -price: double   |
| -variant: String |
| -name: String    |
| -id: int         |

| Bagel                         | Filling       | Coffee |
|-------------------------------|---------------|--------|
| -fillings: ArrayList<Filling> | -bagel: Bagel |        |
