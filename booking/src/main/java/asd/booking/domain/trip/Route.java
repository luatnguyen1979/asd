package asd.booking.domain.trip;

import java.time.LocalDateTime;

import asd.booking.domain.Train;

public class Route {

    private Integer id;
    private Integer sourceId;
    private Integer destinationId;
    private double duration;
    private double distance;
    private double priceOneWay;
    private double priceRoundWay;
    private Train train;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public Route() {
    }

    public Route(Integer id, Integer sourceId, Integer destinationId, double duration, double distance, double priceOneWay,
                 double priceRoundWay, LocalDateTime departureDate,  LocalDateTime arrivalDate) {
        this.id = id;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
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
	 * @return the sourceId
	 */
	public Integer getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the destinationId
	 */
	public Integer getDestinationId() {
		return destinationId;
	}

	/**
	 * @param destinationId the destinationId to set
	 */
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
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
