package asd.framework.booking.domain.trip;

import java.io.Serializable;
import java.util.List;

public class Trip  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8719408106341000425L;
	private Integer id;
    private String tripWay;
    private List<Passenger> passengerList;
    private String bookedDate;
    private Integer customerId;
    private Integer routeId;
    private String confirmationNumber;
    private Double totalPrice;

    public Trip() {
    }

    public Trip(Integer id, String tripWay, List<Passenger> passengerList, String bookedDate, Integer customerId,
                Integer routeId, String confirmationNumber) {
        this.id = id;
        this.tripWay = tripWay;
        this.passengerList = passengerList;
        this.bookedDate = bookedDate;
        this.customerId = customerId;
        this.routeId = routeId;
        this.confirmationNumber = confirmationNumber;
    }

    public Integer getId() {
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
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the routeId
	 */
	public Integer getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(Integer routeId) {
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
