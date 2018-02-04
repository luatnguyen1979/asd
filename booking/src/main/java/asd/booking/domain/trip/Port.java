package asd.booking.domain.trip;

import java.io.Serializable;

public class Port  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5542261791752180542L;
	private Integer id;
    private String name;
    private Integer addressId;

    
    
    /**
	 * 
	 */
	public Port() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Port(Integer id, String name, Integer addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

    
}
