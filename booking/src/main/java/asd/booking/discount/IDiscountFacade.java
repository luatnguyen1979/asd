package asd.booking.discount;

import asd.booking.domain.trip.Route;
import asd.booking.domain.trip.Trip;

public interface IDiscountFacade {

    public Double getPrice(Trip trip, Route route, String promotionCode);
}
