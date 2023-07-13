| Class Name | `Basket`                                                                                               | `Product`                                                                  | `Bagle`                                                                     | `Coffee`                |
|------------|:-------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------|:----------------------------------------------------------------------------|:------------------------|
| Variables  | int `DEFAULT_CAPACITY`<br/>int `basketCapacity`<br/>                                                   | BigDecimal `price`<br/>                                                    | BagleType `bagleType`<br/> ArrayList<FillingType> bagleFillingList          | CoffeeType `coffeeType` |
| Methods    | `addProduct(Product product)`<br/>`removeProduct(Product product)`<br/>`changeBasketSize(int newSize)` | `addToPrice(BigDecimal addToPrice)`<br/>`addToPrice(BigDecimal addToPrice` | addFilling(FillingType fillingType)<br/>countTotalPrice()<br/>updatePrice() | updatePrice()           |


---java
```
    private ArrayList<Product> products = new ArrayList<>();

    public Basket() {
        this.basketCapacity = capacity;
    }

    public void addProduct(Product product){
        // TODO
    }

    public void removeProduct(Product product){
        // TODO
    }

    public void changeBasketSize(int newSize){
        // TODO
    }

    public ArrayList<Product> getBagelsInBasket() {
        return products;
    }

    public BigDecimal getBasketPrice(){
        // TODO
        return null;
    }

    public void changeBasketCapacity(int newCapacity){
        // TODO
    }

    public int getCapacity(){
        return capacity;
    }

    public int getUserCapacity(){
        return basketCapacity;
    }
}
```
