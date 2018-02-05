package asd.framework.booking.discount;


import asd.framework.booking.discount.calculation.ICalculation;

public class GroupVisitor implements IDiscountVisitor {

    private int currentMember;
    private int minMember;
    private ICalculation calculation;
    private Double totalDiscount;
    private double regularPrice;

    public GroupVisitor(int minMember, ICalculation calculation, double regularPrice) {
        this.minMember = minMember;
        this.calculation = calculation;
        this.totalDiscount = 0.0;
        this.regularPrice = regularPrice;
    }

    @Override
    public void visit(ElementAdult elementAdult) {
        currentMember++;
    }

    @Override
    public void visit(ElementChild elementChild) {
        currentMember++;
    }

    @Override
    public void visit(ElementSenior elementSenior) {
        currentMember++;
    }

    @Override
    public void visit(ElementInfant elementInfant) {
    }

    @Override
    public void visit(ElementMilitary elementMilitary) {
        currentMember++;
    }

    @Override
    public void calculateDiscount() {
        if (minMember > currentMember) return;
        totalDiscount = calculation.getDiscount(regularPrice);
    }

    @Override
    public Double getDiscount() {
        calculateDiscount();
        return totalDiscount;
    }
}
