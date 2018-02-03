package asd.booking.discount.passenger;

import asd.booking.discount.IDiscountVisitor;
import asd.booking.discount.IDiscountElement;

public class ElementAdult implements IDiscountElement {

    @Override
    public void accept(IDiscountVisitor iDiscountVisitor) {
        iDiscountVisitor.visit(this);
    }
}
