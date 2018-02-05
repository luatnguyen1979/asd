package asd.framework.booking.discount;

import java.util.List;

import asd.framework.booking.discount.calculation.ICalculation;

public class GroupDiscount {

    private List<IDiscountElement> passengerList;

    public GroupDiscount(List<IDiscountElement> passengerList) {
        this.passengerList = passengerList;
    }

    public double getDiscount(int minMember, ICalculation calculation, double regularPrice) {
        GroupVisitor visitor = new GroupVisitor(minMember, calculation, regularPrice);
        for (IDiscountElement passenger : passengerList) {
            passenger.accept(visitor);
        }
        return visitor.getDiscount();
    }
}
