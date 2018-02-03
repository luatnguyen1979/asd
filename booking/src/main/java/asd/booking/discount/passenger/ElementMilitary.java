package asd.booking.discount.passenger;

import asd.booking.discount.IDiscountElement;
import asd.booking.discount.IDiscountVisitor;

public class ElementMilitary implements IDiscountElement {

    @Override
    public void accept(IDiscountVisitor iDiscountVisitor) {
        iDiscountVisitor.visit(this);
    }
}
