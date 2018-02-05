package asd.framework.booking.discount;

import asd.framework.booking.discount.calculation.ICalculation;
import asd.framework.booking.iteration.Iterator;
import asd.framework.booking.iteration.QueueIteration;

public class PassengerDiscount {

    private QueueIteration<IDiscountElement> passengerList;

    public PassengerDiscount(QueueIteration<IDiscountElement> passengerList) {
        this.passengerList = passengerList;
    }

    public double getDiscount(Double regularPrice, ICalculation adultCalculation, ICalculation childCalculation,
                              ICalculation seniorCalculation, ICalculation infantCalculation,
                              ICalculation militaryCalculation) {
        PassengerVisitor visitor = new PassengerVisitor(regularPrice, adultCalculation,
                childCalculation, seniorCalculation, infantCalculation, militaryCalculation);
        Iterator<IDiscountElement> iterator = passengerList.getIterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
        return visitor.getDiscount();
    }
}
