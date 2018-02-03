/*
 * Created on Feb 2, 2018
 */
package asd.booking.controller.observer;

import asd.booking.domain.Customer;

public class SendingEmailObserver extends EmailObserver {

    @Override
    public void sendEmail(Customer customer) {
        emailContext.sendOutEmial(customer);
    }

}
