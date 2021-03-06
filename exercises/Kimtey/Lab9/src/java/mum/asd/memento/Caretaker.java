/*
 * Created on Jan 23, 2018
 */
package mum.asd.memento;

import java.util.Stack;

public class Caretaker {

    Stack<Memento> mementos = new Stack<Memento>();
    
    public Memento get() { 
        return mementos.pop();
    }
    
    public void add(Memento memento) {
        mementos.push(memento);
    }
}
