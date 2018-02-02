/*
 * Created on Feb 1, 2018
 */
package asd.booking.mail.pattern;

import asd.booking.domain.Customer;

public class SendEmailContext {

    private EmailStrategy model;
    private static SendEmailContext INSTANCE;
    
    public static SendEmailContext getInstance(EmailStrategy model) {
        if(INSTANCE == null) 
            return new SendEmailContext(model);
        return INSTANCE;
    }
    
    private SendEmailContext(EmailStrategy model) {
        this.model = model;
    }
    
    public EmailStrategy getModel() {
        return model;
    }

    public void setModel(EmailStrategy model) {
        this.model = model;
    }
    
    public void sendOutEmial(Customer customer) {
        model.sendEmail(customer);
    }
}
