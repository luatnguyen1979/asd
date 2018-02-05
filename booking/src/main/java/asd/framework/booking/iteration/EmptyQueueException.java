package asd.framework.booking.iteration;

public class EmptyQueueException extends Exception {

    public EmptyQueueException() {
        super("Queue is empty.");
    }
}
