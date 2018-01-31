package asd.booking.domain.discount.passenger;

import asd.booking.controller.discount.IDiscount;
import asd.booking.controller.discount.IPrice;
import asd.booking.controller.discount.DiscountVisitor;
import asd.booking.domain.discount.calculation.Calculation;
import asd.booking.utils.PassengerType;

public class Infant extends Passenger implements IDiscount, IPrice {


    public Infant(Integer id, Calculation calculation, String name, String description, PassengerType passengerType) {
        super(id, calculation, name, description, passengerType);
    }

    @Override
    public void accept(DiscountVisitor discountVisitor) {
        discountVisitor.visit(this);
    }

	/* (non-Javadoc)
	 * @see asd.booking.controller.discount.Price#getPrice(double)
	 */
	@Override
	public double getPrice(double regularPrice) {
		// 30% of regular price
		return regularPrice * 30 / 100;
	}
    
    
}
