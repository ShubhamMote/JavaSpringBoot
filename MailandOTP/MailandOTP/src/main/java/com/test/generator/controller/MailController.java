package com.test.generator.controller;

import com.test.generator.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MailController {

    @Autowired
    private EmailService mailService;

    @RequestMapping("/sendmail")
    public String getMail() {
        String s = mailService.sendSimpleMail();
        return  s;
    }
}
