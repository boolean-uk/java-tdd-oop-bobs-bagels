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
    private final List<Bagel> bagels;

    private BagelOffer(Bagel... bagels) {
        this.bagels = List.of(bagels);
    }

    public static BagelOffer of(Bagel... bagels) {
        return new BagelOffer(bagels);
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

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new bagel - basket is full");
        }
        // TODO
    }

    public void removeBagel(Bagel bagel) {
        // TODO
    }

    public void addCoffee(Coffee coffee) {
        if (isFull()) {
            throw new IllegalStateException();
        }
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
}
```
