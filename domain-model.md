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

@RequiredArgsConstructor
@Getter
public enum Coffee {
    COFB("Black", BigDecimal.valueOf(.99)),
    COFW("White", BigDecimal.valueOf(1.19)),
    COFC("Cappuccino", BigDecimal.valueOf(1.29)),
    COFL("Latte", BigDecimal.valueOf(1.29));

    private final String variant;
    private final BigDecimal price;
}
```

```java
public class Bagel implements Product {
    private final BagelType type;
    private final Filling[] fillings;

    public Bagel(BagelType type, Filling... fillings) {
        this.type = type;
        this.fillings = fillings;
    }

    public BigDecimal price() {
        // TODO
        return null;
    }
}
```

```java
public record BreakfastSet(
        Bagel bagel,
        Coffee coffee
) implements Product {
}
```

```java
public record Discount(
        Type type,
        BigDecimal price
) {
    public enum Type {
        SixOnion,
        TwelvePlain,
        SixEverything,
        BreakfastSet,
    }
}
```

```java

import java.util.List;

@Getter
public class Basket {
    private final Map<Bagel, Integer> bagels = new HashMap<>();
    private final Map<Coffee, Integer> coffees = new HashMap<>();
    private int capacity;

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
        var amount = bagels.values().stream()
                .reduce(0, Integer::sum);
        return coffees.values().stream()
                .reduce(amount, Integer::sum);
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }

    private List<Discount> getDiscounts() {
        // TODO
        return null;
    }
}
```
