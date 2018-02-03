package asd.booking.Prototype;

public interface Prototype<T> {

    public T shallowClone();

    public T deepClone();
}
