/*
 * Created on Jan 29, 2018
 */
package asd.booking.mail;

import asd.booking.domain.Customer;
import asd.booking.mail.pattern.AlertEmail;
import asd.booking.mail.pattern.ConfirmationEmail;
import asd.booking.mail.pattern.SendEmailContext;
import asd.booking.mail.pattern.WelcomeEmail;

public class Main {

    public static void main(String[] args) {
//        SendEmailUtils.getInstance().sendEmail(null);
//        User user = new User();
//        user.setUserName("kimtey");
//        user.setPassword("123");
//        UserDAO.login(user);
        //TrainDAO.findByFromAndTo("Chicago", "Gary");
        Customer cus = new Customer();
        cus.setEmail("kimtey.chav@gmail.com");
        cus.setFirstName("Luat");
        cus.setLastName("Nguyen");
        AlertEmail alert = new AlertEmail();
        ConfirmationEmail confirm = new ConfirmationEmail();
        WelcomeEmail welcome = new WelcomeEmail();
        SendEmailContext emailSend = SendEmailContext.getInstance(confirm);
        emailSend.sendOutEmial(cus);
        SendEmailContext emailSendAlert = SendEmailContext.getInstance(alert);
        emailSendAlert.sendOutEmial(cus);
        SendEmailContext emailSendWelcome = SendEmailContext.getInstance(welcome);
        emailSendWelcome.sendOutEmial(cus);
        System.out.println("done");
        
    }

}
