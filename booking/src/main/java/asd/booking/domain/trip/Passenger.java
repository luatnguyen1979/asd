package asd.booking.domain.trip;

import java.io.Serializable;

public class Passenger  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3216847440630782984L;
	private Integer id;
	private String fullname;
	private String passengerType;
	private Integer tripId;
	private Double price;

	
	/**
	 * 
	 */
	public Passenger() {

	}

	public Passenger(Integer id, String fullname, String passengerType, Integer tripId, Double price) {
		this.id = id;
		this.fullname = fullname;
		this.passengerType = passengerType;
		this.tripId = tripId;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	/**
	 * @return the tripId
	 */
	public Integer getTripId() {
		return tripId;
	}

	/**
	 * @param tripId
	 *            the tripId to set
	 */
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}
