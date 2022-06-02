package com.stackroute.service;

import com.stackroute.model.Email;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class EmailService {
    public boolean sendEmail(Email email){
        boolean f=false;
        String from="rajudadi125@gmail.com";
        //Variable for gmail
        String host="smtp.gmail.com";
        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);
        //setting important information to properties object
        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rajudadi125@gmail.com", "bopgqouaixkvnxxf");
            }
        });

        session.setDebug(true);
        MimeMessage m = new MimeMessage(session);

        try {
            //from email
            m.setFrom(from);
           m.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getIntervierEmailId()));
           m.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getTagEmailId()));
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getCandidateEmailId()));
            m.setSubject("Appointment confirmation");

            m.setText("Hi "+ ",\n\n" + "Greeting from slotify, \nYour slot is canceled.\nPlease ensure your availability for the following Schedule-:" +

                    "\nIntervier Name\t:\t" + email.getInterviername()+ "\nIntervier Email\t:\t" + email.getIntervierEmailId()+"\nTagMember Name\t:\t" +email.getTagmembername()+
                    "\nTagMember Email\t:\t" +email.getTagEmailId()+ "\nCanadidate Name\t:\t" + email.getCandidatename()+
                    "\nCanadidate Email\t:\t" + email.getCandidateEmailId()+ "\nIntervier Date\t:\t" + email.getDate() +
                    "\nStart Time\t:\t" + email.getStartTime() +
                    "\nEnd Time\t:\t" + email.getEndTime() + "\n\nThanks & Regards\nslotify");

            Transport.send(m);
            System.out.println("Sent success...................");
            f=true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
