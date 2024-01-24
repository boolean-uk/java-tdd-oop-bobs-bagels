# User Stories

1.
| Methods                | Member variables | Scenario         | Outputs/Results/Return values |
|------------------------|------------------|------------------|-------------------------------|
| addBagel(String bagel) | String bagel     | if bagel add     | True                          |
|                        |                  | if bagel not add | false                         |
|                        |                  |                  |

2.
| Methods                   | Member variables | Scenario            | Outputs/Results/Return values |
|---------------------------|------------------|---------------------|-------------------------------|
| removeBagel(String bagel) | String bagel     | if bagel remove     | True                          |
|                           |                  | if bagel not remove | false                         |
|                           |                  |                     |

3.
| Methods     | Member variables | Scenario           | Outputs/Results/Return values |
|-------------|------------------|--------------------|-------------------------------|
| baskeFull() |                  | if basket full     | True                          |
|             |                  | if basket not full | false                         |
|             |                  |                    |

4.
| Methods            | Member variables | Scenario        | Outputs/Results/Return values |
|--------------------|------------------|-----------------|-------------------------------|
| changeCap(int cap) | capacity int     | if cap add      | True                          |
|                    |                  | if cap not  add | false                         |
|                    |                  |                 |

5.
| Methods              | Member variables | Scenario          | Outputs/Results/Return values |
|----------------------|------------------|-------------------|-------------------------------|
| removeBagel(int cap) | capacity int     | if item exist     | True                          |
|                      | item String      | if item not exist | false                         |
|                      |                  |                   |

6.
| Methods     | Member variables               | Scenario          | Outputs/Results/Return values |
|-------------|--------------------------------|-------------------|-------------------------------|
| totalcost() | HashMap<Integer, Bagel> basket | if items in list  | return totalcost              |
|             | int totalcost                  | if item not exist | return null                   |
|             |                                |                   |

8.
| Methods         | Member variables                   | Scenario              | Outputs/Results/Return values |
|-----------------|------------------------------------|-----------------------|-------------------------------|
| chooseFilling() | HashMap<Integer, Inventory> basket | if choose filling     | return filling                |
|                 | String filling                     | if not choose filling | return null                   |
|                 |                                    |                       |

9.
| Methods        | Member variables               | Scenario         | Outputs/Results/Return values |
|----------------|--------------------------------|------------------|-------------------------------|
| seeBagelCost() | HashMap<Integer, Bagel> basket | if show cost     | return list                   |
|                | int cost                       | if not show cost | return null                   |
|                |                                |                  |
10.
| Methods         | Member variables               | Scenario         | Outputs/Results/Return values |
|-----------------|--------------------------------|------------------|-------------------------------|
| showInventory() | HashMap<Integer, Bagel> basket | if show list     | true                          |
|                 | Inventory[] invList            | if not show list | false                         |
|                 |                                |                  |

