/*
 * Created on Feb 1, 2018
 */
package asd.booking.mail.pattern;

import asd.booking.domain.Customer;

public interface EmailStrategy {

    public void sendEmail(Customer customer);

}
