package asd.framework.booking.discount;

import asd.framework.booking.discount.IDiscountElement;
import asd.framework.booking.discount.IDiscountVisitor;

public class ElementChild implements IDiscountElement {

    @Override
    public void accept(IDiscountVisitor iDiscountVisitor) {
        iDiscountVisitor.visit(this);
    }
}
