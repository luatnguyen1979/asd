package asd.framework.booking.discount;

import asd.framework.booking.domain.trip.Route;
import asd.framework.booking.domain.trip.Trip;

public interface IDiscountFacade {

    public Double getPrice(Trip trip, Route route, String promotionCode);

    public Double getPrice(Route route, String passengerType, String tripway);
}
