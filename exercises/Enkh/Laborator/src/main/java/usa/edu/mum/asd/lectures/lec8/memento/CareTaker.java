package usa.edu.mum.asd.lectures.lec8.memento;

import java.util.ArrayList;
import java.util.List;

class CareTaker {

    private List<Memento> mementoList = new ArrayList<Memento>();

    void add(Memento state) {
        mementoList.add(state);
    }

    Memento get(int index) {
        return mementoList.get(index);
    }
}