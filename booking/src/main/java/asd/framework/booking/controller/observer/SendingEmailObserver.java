/*
 * Created on Feb 2, 2018
 */
package asd.framework.booking.controller.observer;

import asd.framework.booking.domain.Customer;

public class SendingEmailObserver extends EmailObserver {

    @Override
    public void sendEmail(Customer customer) {
        emailContext.sendOutEmial(customer);
    }

}
