/*
 * Created on Feb 4, 2018
 */
package asd.booking.controller.observer;

import java.util.ArrayList;
import java.util.List;

import asd.booking.domain.Customer;

public class SubjectOberserver {

    private static SubjectOberserver INSTANCE;

    private SubjectOberserver() {

    }

    public static SubjectOberserver getInstance() {
        if(INSTANCE == null) 
            return new SubjectOberserver();
        return INSTANCE;
    }

    private List<EmailObserver> observers = new ArrayList<EmailObserver>();

    public void attacheObserver(EmailObserver observer) {
        observers.add(observer);
    }

    public void dettacheObserver(EmailObserver observer) {
        observers.remove(observer);
    }

    public void notifiedObserver(Customer customer) {
        for (EmailObserver observer : observers) {
            observer.sendEmail(customer);
        }
    }

}
