package asd.booking.utils;

import java.util.List;

import asd.framework.booking.dao.PromotionDAO;
import asd.framework.booking.domain.trip.Passenger;
import asd.framework.booking.domain.trip.Route;

public class Calculation {

    private static double getPromotionPrice(double regularPrice, String passengerType) {
    	if (passengerType == null) {
    		return regularPrice;
    	}
        switch (passengerType) {
            case PassengerType.ADULT:
                return regularPrice;
            case PassengerType.CHILD:
                return regularPrice / 2;
            case PassengerType.SENIOR:
                return regularPrice * 85 / 100;
            case PassengerType.MILITARY:
                return regularPrice * 65 / 100;
            case PassengerType.INFANT:
                return 0.0;
                
            default:
                return regularPrice;
        }
    }
    
    public static double getPromotionRatio(String promotionCode) {
    	 if (promotionCode != null) {
             return PromotionDAO.getPercent(promotionCode);
         }
    	 return 0.00;
    }

    //public double getFinalPrice(Trip trip, String promotionCode) {
    public static double getFinalPrice(Route route, List<Passenger> passengerList, String promotionCode, String tripWay) {
        double regularPrice;
        if (tripWay.equals("roundtrip")) {
        	regularPrice = route.getPriceOneWay();
        } else {
        	regularPrice = route.getPriceRoundWay();
        }
        
        double totalPrice = 0.0;
        for (Passenger passenger : passengerList) {
            totalPrice = totalPrice + getPromotionPrice(regularPrice, passenger.getPassengerType());
        }
        if (promotionCode != null) {
            double percent = PromotionDAO.getPercent(promotionCode);
            totalPrice = totalPrice - (totalPrice / 100 * percent);
        }
        return totalPrice;
    }
    
    public static double getPrice(Route route, String passengerType, String promotionCode, String tripWay) {
        double regularPrice;
        double finalPrice;
        if (tripWay.equals("roundtrip")) {
        	regularPrice = route.getPriceOneWay();
        } else {
        	regularPrice = route.getPriceRoundWay();
        }
        
        
        finalPrice = getPromotionPrice(regularPrice, passengerType);
        
        if (promotionCode != null) {
            double percent = PromotionDAO.getPercent(promotionCode);
            finalPrice = finalPrice - (finalPrice / 100 * percent);
        }
        return finalPrice;
    }
}
