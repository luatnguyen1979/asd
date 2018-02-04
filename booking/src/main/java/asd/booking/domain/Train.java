/*
 * Created on Jan 30, 2018
 */
package asd.booking.domain;

import java.io.Serializable;

public class Train  implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6066395442162732450L;
	private String name;
    private String type;
    private String model;
    private String madeBy;
    private boolean isActive;
    private int capacity;

    public Train() {
    }

    public Train(String name, String type, String model, String madeBy, boolean isActive, int capacity) {
        this.name = name;
        this.type = type;
        this.model = model;
        this.madeBy = madeBy;
        this.isActive = isActive;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
