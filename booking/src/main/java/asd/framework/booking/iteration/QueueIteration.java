package asd.framework.booking.iteration;

public class QueueIteration<T> implements Aggregate {

    private int size = 0;
    private Node<T> front = null;
    private Node<T> last = null;

    public void add(T t) {
        Node<T> node = new Node();
        node.element = t;
        if (last == null) {
            last = node;
        } else {
            last.nextNode = node;
            last = node;
        }
        if (front == null) {
            front = node;
        }
        size++;
    }

    public T remove() throws EmptyQueueException {
        if (front == null) {
            throw new EmptyQueueException();
        }
        Node<T> ret = front;
        front = front.nextNode;
        size--;
        if (front == null) {
            last = null;
        }
        return ret.element;
    }

    public T front() throws EmptyQueueException {
        if (front == null) {
            throw new EmptyQueueException();
        }
        return front.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private class Node<T> {

        private T element = null;
        private Node<T> nextNode = null;

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }

    @Override
    public Iterator getIterator() {
        return new QueueIterator(this.front);
    }

    private class QueueIterator implements Iterator<T> {

        private Node<T> frontNode;

        public QueueIterator(Node<T> frontNode) {
            this.frontNode = frontNode;
        }

        @Override
        public boolean hasNext() {
            return frontNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T ret = frontNode.element;
                frontNode = front.nextNode;
                return ret;
            } else {
                return null;
            }
        }
    }
}
