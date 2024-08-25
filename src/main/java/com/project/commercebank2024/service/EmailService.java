package com.project.commercebank2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.project.commercebank2024.domain.EmailInfo;
import com.project.commercebank2024.repository.EmailInfoRepository;

import lombok.AllArgsConstructor;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmailService {

  @Autowired
  private final EmailInfoRepository emailInfoRepository;

  public Optional<EmailInfo> findByuserNameRequestedToRegister(String userNameRequestedToRegister) {
    return emailInfoRepository.findByuserNameRequestedToRegister(userNameRequestedToRegister);

    // return
    // emailInfoRepository.findByuserNameRequestedToRegister(userNameRequestedToRegister);
  }

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
