package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class sendMessage {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name, String email, String text, String phone) {
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("buyyourcarofficial@gmail.com");
        message.setSubject("New Form Submission from your Website");
        message.setText("Name: \n" + name + "\n\nPhone: \n" + phone + "\n\nE-mail: \n" + email +"\n\nMessage: \n" + text);
        message.setFrom(email);

        mailSender.send(message);
    }
    
    public void sendEmail(String name, String email, String text) {
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("buyyourcarofficial@gmail.com");
        message.setSubject("New Form Submission from your Website");
        message.setText("Name: \n" + name + "\n\nE-mail: \n" + email +"\n\nMessage: \n" + text);
        message.setFrom(email);

        mailSender.send(message);
    }
}

