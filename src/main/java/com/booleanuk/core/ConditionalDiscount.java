package com.booleanuk.core;

public class ConditionalDiscount extends Discount {
    public final Category[] conditionalItems;
    public final double newPrice;

    public ConditionalDiscount(Category[] conditionalItems, double newPrice) {
        this.conditionalItems = conditionalItems;
        this.newPrice = newPrice;
    }

    @Override
    public double applyDiscount(Order order, final Order[] orders) {
        final Item _tmpItem = ShoppingManager.getItem(order.itemUUID);
        if (_tmpItem == null) return 0.0; // this means that, somehow... the item we added and that had a discount... is null

        double _totalItemPrice = _tmpItem.price;

        for (Category category : conditionalItems) {
            boolean _wasFound = false;

            for (Order orderInBasket : orders) {
                final Item _item = ShoppingManager.getItem(orderInBasket.itemUUID);
                if (_item == null) continue;

                if (_item.category == category) {
                    _totalItemPrice += _item.price;
                    _wasFound = true;
                    break;
                }
            }

            if (!_wasFound) // the discount cannot be applied because we do not have all the categories required for this discount
                return 0.0;
        }

        return _totalItemPrice - newPrice; // since the new price is a new price... and not actually the discount amount itself, we need the total price of the categorised items
        // i'm also aware of the tiny flaw with this system/discount, it grabs the first item of each required category
        // some prices may vary in each category. this means in certain cases, the discount might be higher or lower depending on the item
    }
}
