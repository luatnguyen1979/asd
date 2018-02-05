/**
 *
 */
package asd.framework.booking.domain;

import java.io.Serializable;

/**
 * @author luatnguyen
 */
public class Address implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8268650781163822819L;
	private String street1;
    private String street2;
    private String city;
    private String zipCode;
    private String state;

    public Address() {
    }

    /**
     * @param address1
     * @param address2
     * @param city
     * @param zipCode
     * @param state
     */
    public Address(String address1, String address2, String city, String zipCode, String state) {
        super();
        street1 = address1;
        street2 = address2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }

    /**
     * @return the address1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setStreet1(String address1) {
        street1 = address1;
    }

    /**
     * @return the address2
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setStreet2(String address2) {
        street2 = address2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
