package asd.framework.booking.prototype;

public interface Prototype<T> {

    public T shallowClone();

    public T deepClone();
}
