package asd.booking.discount;

import asd.booking.dao.PromotionDAO;
import asd.booking.discount.calculation.CalculationByAmount;
import asd.booking.discount.calculation.CalculationByPercentage;
import asd.booking.discount.calculation.ICalculation;
import asd.booking.discount.passenger.*;
import asd.booking.domain.trip.Passenger;
import asd.booking.domain.trip.Route;
import asd.booking.domain.trip.Trip;
import asd.booking.utils.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DiscountFacadeImpl implements IDiscountFacade{

	@Override
    public Double getPrice(Trip trip, Route route, String promotionCode) {
        Double ret;
        Double totalDiscount = 0.0;
        Double regularPrice = trip.getTripWay().equals(TripType.ROUND.getName()) ? route.getPriceRoundWay() : route.getPriceOneWay();
        Double totalRegularPrice = trip.getPassengerList().size() * regularPrice;
        int groupMinMember = Config.getInt("group_min_member");
        Double groupDiscountAmount = Config.getDouble("group_discount_amount");
        LocalDate startDate = DateUtils.adaptFromDate(Config.getString("startdate"));
        LocalDate endDate = DateUtils.adaptFromDate(Config.getString("startdate"));
        Double adultPercent = Config.getDouble("adult_percent");
        Double childPercent = Config.getDouble("child_percent");
        Double infantPercent = Config.getDouble("infant_percent");
        Double seniorPercent = Config.getDouble("senior_percent");
        Double militaryPercent = Config.getDouble("military_percent");
        ICalculation adultICalculation = new CalculationByPercentage(startDate, endDate, adultPercent);
        ICalculation childICalculation = new CalculationByPercentage(startDate, endDate, childPercent);
        ICalculation infantICalculation = new CalculationByPercentage(startDate, endDate, infantPercent);
        ICalculation seniorICalculation = new CalculationByPercentage(startDate, endDate, seniorPercent);
        ICalculation militaryCalculation = new CalculationByPercentage(startDate, endDate, militaryPercent);
        ICalculation groupCalculation = new CalculationByAmount(startDate, endDate, seniorPercent);
        List<IDiscountElement> elementList = new LinkedList<>();
        for (Passenger passenger : trip.getPassengerList()) {
            switch (passenger.getPassengerType()) {
                case PassengerType.ADULT:
                    elementList.add(new ElementAdult());
                    break;
                case PassengerType.CHILD:
                    elementList.add(new ElementChild());
                    break;
                case PassengerType.INFANT:
                    elementList.add(new ElementInfant());
                    break;
                case PassengerType.SENIOR:
                    elementList.add(new ElementSenior());
                    break;
                case PassengerType.MILITARY:
                    elementList.add(new ElementMilitary());
                    break;
            }
        }
        GroupDiscount groupDiscount = new GroupDiscount(elementList);
        totalDiscount += groupDiscount.getDiscount(groupMinMember, groupCalculation, regularPrice);
        PassengerDiscount passengerDiscount = new PassengerDiscount(elementList);
        totalDiscount += passengerDiscount.getDiscount(regularPrice, adultICalculation, childICalculation,
                seniorICalculation, infantICalculation, militaryCalculation);
        ret = totalRegularPrice - totalDiscount;
        if (promotionCode != null && !promotionCode.isEmpty()) {
            ret = ret - (ret / 100 * PromotionDAO.getPercent(promotionCode));
        }
        if (ret < 0) ret = 0.0;
        trip.setTotalPrice(ret);
        return ret;
    }

	@Override
    public Double getPrice(Route route, String passengerType, String tripway) {
        Double regularPrice = tripway.equals(TripType.ROUND.getName()) ? route.getPriceRoundWay() : route.getPriceOneWay();
        Double adultPercent = Config.getDouble("adult_percent");
        Double childPercent = Config.getDouble("child_percent");
        Double infantPercent = Config.getDouble("infant_percent");
        Double seniorPercent = Config.getDouble("senior_percent");
        Double militaryPercent = Config.getDouble("military_percent");
        LocalDate startDate = DateUtils.adaptFromDate(Config.getString("startdate"));
        LocalDate endDate = DateUtils.adaptFromDate(Config.getString("startdate"));
        ICalculation adultICalculation = new CalculationByPercentage(startDate, endDate, adultPercent);
        ICalculation childICalculation = new CalculationByPercentage(startDate, endDate, childPercent);
        ICalculation infantICalculation = new CalculationByPercentage(startDate, endDate, infantPercent);
        ICalculation seniorICalculation = new CalculationByPercentage(startDate, endDate, seniorPercent);
        ICalculation militaryCalculation = new CalculationByPercentage(startDate, endDate, militaryPercent);
        Double discount = 0.0;
        switch (passengerType) {
            case PassengerType.ADULT:
                discount = adultICalculation.getDiscount(regularPrice);
                break;
            case PassengerType.CHILD:
                discount = childICalculation.getDiscount(regularPrice);
                break;
            case PassengerType.INFANT:
                discount = infantICalculation.getDiscount(regularPrice);
                break;
            case PassengerType.SENIOR:
                discount = seniorICalculation.getDiscount(regularPrice);
                break;
            case PassengerType.MILITARY:
                discount = militaryCalculation.getDiscount(regularPrice);
                break;
        }
        return regularPrice - discount;
    }
}
