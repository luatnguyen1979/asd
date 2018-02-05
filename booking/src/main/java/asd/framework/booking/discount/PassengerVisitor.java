package asd.framework.booking.discount;

import asd.framework.booking.discount.calculation.ICalculation;

public class PassengerVisitor implements IDiscountVisitor {

    private Double regularPrice;
    private Double totalDiscount;
    private ICalculation adultCalculation;
    private ICalculation childCalculation;
    private ICalculation seniorCalculation;
    private ICalculation infantCalculation;
    private ICalculation militaryCalculation;

    public PassengerVisitor(Double regularPrice, ICalculation adultCalculation, ICalculation childCalculation,
                            ICalculation seniorCalculation, ICalculation infantCalculation,
                            ICalculation militaryCalculation) {
        this.regularPrice = regularPrice;
        this.adultCalculation = adultCalculation;
        this.childCalculation = childCalculation;
        this.seniorCalculation = seniorCalculation;
        this.infantCalculation = infantCalculation;
        this.militaryCalculation = militaryCalculation;
        this.totalDiscount = 0.0;
    }

    @Override
    public void visit(ElementAdult elementAdult) {
        totalDiscount = totalDiscount + adultCalculation.getDiscount(regularPrice);
    }

    @Override
    public void visit(ElementChild elementChild) {
        totalDiscount = totalDiscount + childCalculation.getDiscount(regularPrice);
    }

    @Override
    public void visit(ElementSenior elementSenior) {
        totalDiscount = totalDiscount + seniorCalculation.getDiscount(regularPrice);
    }

    @Override
    public void visit(ElementInfant elementInfant) {
        totalDiscount = totalDiscount + infantCalculation.getDiscount(regularPrice);
    }

    @Override
    public void visit(ElementMilitary elementMilitary) {
        totalDiscount = totalDiscount + militaryCalculation.getDiscount(regularPrice);
    }

    @Override
    public Double getDiscount() {
        return totalDiscount;
    }

    @Override
    public void calculateDiscount() {
    }
}
