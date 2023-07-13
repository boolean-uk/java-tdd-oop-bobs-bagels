# Domain Model

```java

@RequiredArgsConstructor
@Getter
public enum BagelType {
    BGLO("Onion", BigDecimal.valueOf(.49)),
    BGLP("Plain", BigDecimal.valueOf(.39)),
    BGLE("Everything", BigDecimal.valueOf(.49)),
    BGLS("Sesame", BigDecimal.valueOf(.49));

    private final String variant;
    private final BigDecimal price;
}
```

```java

@RequiredArgsConstructor
@Getter
public enum Filling {
    FILB("Bacon"),
    FILE("Egg"),
    FILC("Cheese"),
    FILX("Cream Cheese"),
    FILS("Smoked Salmon"),
    FILH("Ham");

    private final String variant;
    private final BigDecimal price = BigDecimal.valueOf(.12);
}
```

```java
public interface Product {
    BigDecimal getPrice();
}
```

```java

@RequiredArgsConstructor
@Getter
public enum Coffee implements Product {
    COFB("Black", BigDecimal.valueOf(.99)),
    COFW("White", BigDecimal.valueOf(1.19)),
    COFC("Cappuccino", BigDecimal.valueOf(1.29)),
    COFL("Latte", BigDecimal.valueOf(1.29));

    private final String variant;
    private final BigDecimal price;
}
```

```java

@Builder
@Getter
public record Bagel(BagelType type, Filling... fillings) implements Product {
    @Override
    public BigDecimal getPrice() {
        // TODO
        return null;
    }
}
```

```java
public interface SpecialOffer extends Product {
}
```

```java

@Getter
public class BagelOffer implements SpecialOffer {
    private final Type offerType;
    private final List<Bagel> bagels;

    private BagelOffer(Bagel... bagels) {
        // TODO validation of amount and type of bagels (check if they conform to existing promotions)
        this.bagels = List.of(bagels);
        this.offerType = switch (bagels[0].type()) {
            case BGLO -> Type.SixOnion;
            case BGLP -> Type.TwelvePlain;
            case BGLE -> Type.SixEverything;
            default -> throw new IllegalStateException("Unexpected value: " + bagels[0].type());
        };
    }

    public static BagelOffer of(Bagel... bagels) {
        return new BagelOffer(bagels);
    }

    @Override
    public BigDecimal getPrice() {
        // TODO
        return null;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Type {
        SixOnion(BigDecimal.valueOf(2.49)),
        TwelvePlain(BigDecimal.valueOf(3.99)),
        SixEverything(BigDecimal.valueOf(2.49));

        private final BigDecimal price;
    }
}
```

```java

@Getter
public class BreakfastOffer implements SpecialOffer {
    private final Bagel bagel;
    private final Coffee coffee;

    private BreakfastOffer(Bagel bagel, Coffee coffee) {
        this.bagel = bagel;
        this.coffee = coffee;
    }

    public static BreakfastOffer of(Bagel bagel, Coffee coffee) {
        return new BreakfastOffer(bagel, coffee);
    }

    @Override
    public BigDecimal getPrice() {
        // TODO
        return null;
    }
}
```

```java

@Getter
public class Basket {
    private final List<Product> products = new ArrayList<>();
    private int capacity;
    private final Map<BagelType, Integer> bagelTypeCounter = new HashMap<>();

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        // TODO
    }

    public void removeBagel(Bagel bagel) {
        // TODO
    }

    public void addCoffee(Coffee coffee) {
        // TODO
    }

    public void removeCoffee(Coffee coffee) {
        // TODO
    }

    public BigDecimal totalPrice() {
        // TODO
        return null;
    }

    public void resize(int capacity) {
        // TODO
    }

    private int itemAmount() {
        // TODO
        return -1;
    }

    private boolean isFull() {
        // TODO
        return false;
    }

    private List<Product> groupProductsIntoOffers(List<Product> products) {
        // TODO
        return null;
    }

    private List<Product> groupBagelOffers(List<Product> products) {
        // TODO
        return null;
    }

    private List<Product> groupBreakfastOffers(List<Product> products) {
        // TODO
        return null;
    }

    private List<Coffee> extractCoffees(List<Product> products) {
        // TODO
        return null;
    }

    private List<Bagel> extractBagels(List<Product> products) {
        // TODO
        return null;
    }
}
```
