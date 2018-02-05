package asd.framework.booking.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import asd.framework.booking.domain.trip.Trip;

public class Report  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2737276322199203030L;
	private Integer id;
	private String date;
    private String trainName;
    private int passenger;
    private String sourceName;
    private String destName;
    private double totalPrice;

    public Report() {
    }

    public Report(Integer id, String date, String trainName, int passenger, String sourceName, String destName, double totalPrice) {
        this.id = id;
    		this.date = date;
        this.trainName = trainName;
        this.passenger = passenger;
        this.sourceName = sourceName;
        this.destName = destName;
        this.totalPrice = totalPrice;
    }

    public Report(Trip trip) {
        this();
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
 //       this.date = trip.getRoute().getDepartureDate().format(formatter);
 //       this.trainName = trip.getRoute().getTrain().getName();
 //       this.sourceName = trip.getRoute().getSource().getName();
 //       this.destName = trip.getRoute().getDestination().getName();
        this.totalPrice = trip.getTotalPrice();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
    
}