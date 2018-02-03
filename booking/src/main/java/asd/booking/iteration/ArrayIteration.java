package asd.booking.iteration;

import java.lang.reflect.Array;

public class ArrayIteration<T> implements Aggregate {

    private static final int defaultLen = 30;
    private int idx;
    private int size;
    private int len;
    private T[] data;
    private Class<T> type;


    public ArrayIteration(Class<T> type, int len) {
        this.size = 0;
        this.idx = 0;
        this.len = len;
        this.type = type;
        this.data = (T[]) Array.newInstance(this.type, this.len);
    }

    public boolean add(T t) {
        if (isFull()) resize();
        size++;
        data[idx++] = t;
        return true;
    }

    public boolean remove(T t, int target) {
        if (target < 0 || target >= len) return false;
        int i;
        for (i = target; i < len - 1; i++) {
            data[i] = data[i + 1];
        }
        idx--;
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == len;
    }

    public int getSize() {
        return size;
    }

    public void resize() {
        int i;
        T[] tmp = (T[]) Array.newInstance(this.type, this.len * 2);
        for (i = 0; i < len; i++) {
            tmp[i] = data[i];
        }
        len = len * 2;
        data = tmp;
        idx = i;
    }

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int i;
        private int iLen;
        private T[] iData;

        public ArrayIterator() {
            this.i = 0;
            this.iLen = len;
            this.iData = data;
        }

        @Override
        public boolean hasNext() {
            return i == iLen;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return iData[i++];
            } else {
                return null;
            }
        }
    }
}
