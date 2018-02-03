package asd.booking.utils;

public enum TripType {

    SINGLE("singleway"), ROUND("roundtrip");

    TripType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
