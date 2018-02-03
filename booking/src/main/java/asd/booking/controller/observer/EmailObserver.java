/*
 * Created on Feb 2, 2018
 */
package asd.booking.controller.observer;

import asd.booking.domain.Customer;
import asd.booking.mail.pattern.SendEmailContext;

public abstract class EmailObserver {
    
    SendEmailContext emailContext;
    
    public EmailObserver() {
        
    }
    
    public EmailObserver(SendEmailContext context) {
        this.emailContext = context;
    }
    
    public SendEmailContext getEmailContext() {
        return emailContext;
    }

    
    public void setEmailContext(SendEmailContext emailContext) {
        this.emailContext = emailContext;
    }

    public abstract void sendEmail(Customer customer);
}
