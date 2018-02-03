package asd.booking.domain.trip;

import java.util.List;

public class Trip {

    private int id;
    private String tripWay;
    private List<Passenger> passengerList;
    private String bookedDate;
    private int customerId;
    private int routeId;
    private String confirmationNumber;
    private Double totalPrice;

    public Trip() {
    }

    public Trip(int id, String tripWay, List<Passenger> passengerList, String bookedDate, int customerId,
                int routeId, String confirmationNumber) {
        this.id = id;
        this.tripWay = tripWay;
        this.passengerList = passengerList;
        this.bookedDate = bookedDate;
        this.customerId = customerId;
        this.routeId = routeId;
        this.confirmationNumber = confirmationNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tripWay
     */
    public String getTripWay() {
        return tripWay;
    }

    /**
     * @param tripWay the tripWay to set
     */
    public void setTripWay(String tripWay) {
        this.tripWay = tripWay;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }



    /**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the routeId
	 */
	public int getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	/**
     * @return the confirmationNumber
     */
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    /**
     * @param confirmationNumber the confirmationNumber to set
     */
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
