package asd.framework.booking.discount;

import java.util.List;

import asd.framework.booking.discount.calculation.ICalculation;

public class PassengerDiscount {

    private List<IDiscountElement> passengerList;

    public PassengerDiscount(List<IDiscountElement> passengerList) {
        this.passengerList = passengerList;
    }

    public double getDiscount(Double regularPrice, ICalculation adultCalculation, ICalculation childCalculation,
                              ICalculation seniorCalculation, ICalculation infantCalculation,
                              ICalculation militaryCalculation) {
        PassengerVisitor visitor = new PassengerVisitor(regularPrice, adultCalculation,
                childCalculation, seniorCalculation, infantCalculation, militaryCalculation);
        for (IDiscountElement passenger : passengerList) {
            passenger.accept(visitor);
        }
        return visitor.getDiscount();
    }
}