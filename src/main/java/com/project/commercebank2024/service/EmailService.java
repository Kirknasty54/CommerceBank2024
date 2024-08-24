package com.project.commercebank2024.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  // @Bean
  // public JavaMailSender getJavaMailSender() {
  // JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
  // mailSender.setHost("smtp.gmail.com");
  // mailSender.setPort(587);
  //
  // mailSender.setUsername(System.getenv("COMMERCEBANK_TEST"));
  // mailSender.setPassword(System.getenv("COMMERCEBANK_APP_PASWORD"));
  //
  // Properties props = mailSender.getJavaMailProperties();
  // props.put("mail.transport.protocol", "smtp");
  // props.put("mail.smtp.auth", "true");
  // props.put("mail.smtp.starttls.enable", "true");
  // props.put("mail.debug", "true");
  //
  // return mailSender;
  // }
  @Autowired
  private JavaMailSender emailSender;

  public void sendEmail(String to, String subject, String body) {

    SimpleMailMessage msg = new SimpleMailMessage();
    try {
      msg.setFrom(System.getenv("COMMERCEBANK_TEST"));
      msg.setTo(to);
      msg.setSubject(subject);
      msg.setText(body);
      emailSender.send(msg);
    } catch (Exception e) {
      System.out.printf("Caught exception %s doing something. %n", e.toString());
      e.printStackTrace();
    }
  }
}
