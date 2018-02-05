package asd.framework.booking.domain.trip;

import java.time.LocalDateTime;

import asd.framework.booking.domain.Train;

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
                 double priceRoundWay, LocalDateTime departureDate,  LocalDateTime arrivalDate) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.distance = distance;
        this.priceOneWay = priceOneWay;
        this.priceRoundWay = priceRoundWay;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	

	/**
	 * @return the source
	 */
	public Port getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Port source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public Port getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Port destination) {
		this.destination = destination;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the priceOneWay
	 */
	public double getPriceOneWay() {
		return priceOneWay;
	}

	/**
	 * @param priceOneWay the priceOneWay to set
	 */
	public void setPriceOneWay(double priceOneWay) {
		this.priceOneWay = priceOneWay;
	}

	/**
	 * @return the priceRoundWay
	 */
	public double getPriceRoundWay() {
		return priceRoundWay;
	}

	/**
	 * @param priceRoundWay the priceRoundWay to set
	 */
	public void setPriceRoundWay(double priceRoundWay) {
		this.priceRoundWay = priceRoundWay;
	}

	/**
	 * @return the departureDate
	 */
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the arrivalDate
	 */
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the trainId
	 */
	public Train getTrain() {
		return train;
	}

	/**
	 * @param trainId the trainId to set
	 */
	public void setTrain(Train train) {
		this.train = train;
	}

	
    
}
