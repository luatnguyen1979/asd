/*
 * Created on Feb 1, 2018
 */
package asd.booking.mail.pattern;

import asd.booking.domain.Customer;

public class AlertEmail extends SendingEmailTemplateMethod implements EmailStrategy {

    @Override
    public void sendEmail(Customer customer) {
        super.sendEmailToClient(customer);
    }

    @Override
    public String getRecipients(Customer customer) {
        return customer.getEmail();
    }

    @Override
    public String buildSubject(Customer customer) {
        StringBuilder subjectBuilder = new StringBuilder();
        subjectBuilder.append("ALERT TRAVELING TO - ");
        subjectBuilder.append(customer.getFirstName());
        subjectBuilder.append(" ");
        subjectBuilder.append(customer.getLastName());
        return subjectBuilder.toString();
    }

    @Override
    public String buildBody(Customer customer) {
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Hello " + customer.getFirstName()).append("\n");
        bodyBuilder.append("This is to alert you that in the next 1h your train will depart.").append("\n");
        bodyBuilder.append("Thanks our value customer");
        return bodyBuilder.toString();
    }

}
