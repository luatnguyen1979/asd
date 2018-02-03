package asd.booking.discount;

import asd.booking.discount.passenger.*;

public interface IDiscountVisitor {

    public void visit(ElementAdult elementAdult);

    public void visit(ElementChild elementChild);

    public void visit(ElementSenior elementSenior);

    public void visit(ElementInfant elementInfant);

    public void visit(ElementMilitary elementMilitary);

    public void calculateDiscount();

    public Double getDiscount();

}
