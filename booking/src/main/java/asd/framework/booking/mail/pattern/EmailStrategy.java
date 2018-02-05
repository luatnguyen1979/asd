/*
 * Created on Feb 1, 2018
 */
package asd.framework.booking.mail.pattern;

import asd.framework.booking.domain.Customer;

public interface EmailStrategy {

    public void sendEmail(Customer customer);

}
