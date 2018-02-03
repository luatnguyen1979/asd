package asd.booking.prototype;

import java.io.*;

public class PrototypeElement<T extends Cloneable, Serializable> implements Prototype<T> {

    private T element;

    public PrototypeElement(T element) {
        this.element = element;
    }

    @Override
    public T shallowClone() {
        return (T) element.getClass().getSuperclass().getInterfaces().clone();
    }

    @Override
    public T deepClone() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // serialize and pass the object
            oos.writeObject(element);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            // return the new object
            return (T) ois.readObject();
        } catch (Exception e) {
            return null;
        } finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException ioe) {
            }
        }
    }
}
