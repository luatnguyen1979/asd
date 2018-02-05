/*
 * Created on Feb 1, 2018
 */
package asd.framework.booking.mail.pattern;

import asd.framework.booking.domain.Customer;

public class WelcomeEmail extends SendingEmailTemplateMethod implements EmailStrategy {

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
        subjectBuilder.append("Welcome - ");
        subjectBuilder.append(customer.getFirstName());
        subjectBuilder.append(" ");
        subjectBuilder.append(customer.getLastName());
        return subjectBuilder.toString();
    }

    @Override
    public String buildBody(Customer customer) {
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Hello " + customer.getFirstName()).append("\n");
        bodyBuilder.append("Welcome to to our booking website. The best booking site ever.").append("\n");
        bodyBuilder.append("Thanks our value customer");
        return bodyBuilder.toString();
    }

}
