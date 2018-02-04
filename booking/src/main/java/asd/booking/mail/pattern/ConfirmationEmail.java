/*
 * Created on Feb 1, 2018
 */
package asd.booking.mail.pattern;

import asd.booking.domain.Customer;

public class ConfirmationEmail extends SendingEmailTemplateMethod implements EmailStrategy {

    private String confirmationNumber;
    
    
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
    
    public ConfirmationEmail() {
        super();
    }
    
    public ConfirmationEmail(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public void sendEmail(Customer customer) {
        sendEmailToClient(customer);
    }

    @Override
    public String getRecipients(Customer customer) {
        return customer.getEmail();
    }

    @Override
    public String buildSubject(Customer customer) {
        StringBuilder subjectBuilder = new StringBuilder();
        subjectBuilder.append("CONFIRMATION BOOKING - ");
        subjectBuilder.append(customer.getFirstName());
        subjectBuilder.append(" ");
        subjectBuilder.append(customer.getLastName());
        return subjectBuilder.toString();
    }

    @Override
    public String buildBody(Customer customer) {
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Hello " + customer.getFirstName()).append("\n");
        bodyBuilder.append("This is to confirm you that you have booked the ticket").append("\n");
        bodyBuilder.append("Your reservation number is : " + getConfirmationNumber() + "\n");
        bodyBuilder.append("Thanks our value customer");
        return bodyBuilder.toString();
    }

}
