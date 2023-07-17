# Extensions

## Added Classes


## BasketManager class

### With metods:
```
    public boolean add(BagelExt bagelExt)
    private boolean isNotProductInInventory(BagelExt bagelExt)
    public boolean add(CoffeeExt coffeeExt)
    private boolean isNotProductInInventory(CoffeeExt coffeeExt)
    private boolean isNotProductInInventory(FillingExt fillingExt)
    public boolean add(FillingExt fillingExt)
    public boolean remove(BagelExt bagelExt)
    public boolean remove(FillingExt fillingExt)
    public boolean remove(CoffeeExt coffeeExt)
    private boolean checkIsBasketFull()
    private boolean checkSanity(CoffeeExt coffeeExt)
    private boolean checkSanity(FillingExt fillingExt)
    private boolean checkSanity(BagelExt bagelExt)
    public double getTotalCost() 
    public void addFillingToBagel(BagelExt bagelExt, FillingExt fillingExt)
    public String getPriceListOfFillings()
    public String getPriceListOfBagels()
    public String createReceipt()
    public void countBagelsInBasket()
```

## PaymentFinalizer class
### With metods:
```
 private void dateForReceipt(BasketExt basketExt)
 public String printPriceForReceipt(BasketExt basketExt)
 private double getOnePositionCost(double price, int quantity)
```

##  ReceiptCreator
### With metods:
```
    public String CreateFirstPartOfReceipt(BasketExt basketExt)
```

## DiscountCreator
### With metods:
```
    public void bagelsCounter(BasketExt basketExt) {
    public void setPromosForBasket(BasketExt basketExt) {
    public void coffeeCounter(BasketExt basketExt)
    public void fillingCounter(BasketExt basketExt)
```
