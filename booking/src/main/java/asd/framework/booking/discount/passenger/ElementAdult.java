package asd.framework.booking.discount.passenger;

import asd.framework.booking.discount.IDiscountElement;
import asd.framework.booking.discount.IDiscountVisitor;

public class ElementAdult implements IDiscountElement {

    @Override
    public void accept(IDiscountVisitor iDiscountVisitor) {
        iDiscountVisitor.visit(this);
    }
}
