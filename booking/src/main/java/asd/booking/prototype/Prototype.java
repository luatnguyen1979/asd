package asd.booking.prototype;

public interface Prototype<T> {

    public T shallowClone();

    public T deepClone();
}
