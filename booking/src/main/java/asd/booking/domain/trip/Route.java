package asd.booking.domain.trip;

import asd.booking.domain.Train;

import java.time.LocalDateTime;

public class Route {

    private Integer id;
    private Port source;
    private Port destination;
    private double duration;
    private double distance;
    private double priceOneWay;
    private double priceRoundWay;
    private Train train;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public Route() {
    }

    public Route(Integer id, Port source, Port destination, double duration, double distance, double priceOneWay,
                 double priceRoundWay, Train train, LocalDateTime departureDate,  LocalDateTime arrivalDate) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.distance = distance;
        this.priceOneWay = priceOneWay;
        this.priceRoundWay = priceRoundWay;
        this.train = train;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Port getSource() {
        return source;
    }

    public void setSource(Port source) {
        this.source = source;
    }

    public Port getDestination() {
        return destination;
    }

    public void setDestination(Port destination) {
        this.destination = destination;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPriceOneWay() {
        return priceOneWay;
    }

    public void setPriceOneWay(double priceOneWay) {
        this.priceOneWay = priceOneWay;
    }

    public double getPriceRoundWay() {
        return priceRoundWay;
    }

    public void setPriceRoundWay(double priceRoundWay) {
        this.priceRoundWay = priceRoundWay;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
