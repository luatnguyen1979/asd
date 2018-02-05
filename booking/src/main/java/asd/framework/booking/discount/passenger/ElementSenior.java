package asd.framework.booking.discount.passenger;

import asd.framework.booking.discount.IDiscountElement;
import asd.framework.booking.discount.IDiscountVisitor;

public class ElementSenior implements IDiscountElement {

    @Override
    public void accept(IDiscountVisitor iDiscountVisitor) {
        iDiscountVisitor.visit(this);
    }
}