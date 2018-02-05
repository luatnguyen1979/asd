package asd.framework.booking.discount;

public interface IDiscountElement {

    public void accept(IDiscountVisitor iDiscountVisitor);
}
