package com.test.generator.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailServiceImpl implements EmailService {
    @Autowired private OTPandPasswordGeneratorService otpandPasswordservice;
    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override public String sendSimpleMail() {

        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo("bhoiteprashant538@gmail.com");
            mailMessage.setText("Generated Otp: " + String.valueOf(otpandPasswordservice.generateOTP()));
            mailMessage.setSubject("OTP");

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment() {
        return null;
    }
}
