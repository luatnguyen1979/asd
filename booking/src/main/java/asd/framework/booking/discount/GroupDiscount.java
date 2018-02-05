package asd.framework.booking.discount;

import asd.framework.booking.discount.calculation.ICalculation;
import asd.framework.booking.iteration.Iterator;
import asd.framework.booking.iteration.QueueIteration;

public class GroupDiscount {

    private QueueIteration<IDiscountElement> passengerList;

    public GroupDiscount(QueueIteration<IDiscountElement> passengerList) {
        this.passengerList = passengerList;
    }

    public double getDiscount(int minMember, ICalculation calculation, double regularPrice) {
        GroupVisitor visitor = new GroupVisitor(minMember, calculation, regularPrice);
        Iterator<IDiscountElement> iterator = passengerList.getIterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
        return visitor.getDiscount();
    }
}
