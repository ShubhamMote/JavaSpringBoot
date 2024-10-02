package com.test.generator.controller;

import com.test.generator.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/getmail")
    public ResponseEntity<?> getMail() {
        String s = mailService.generateMail();
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        return  ResponseEntity.ok(map);
    }
}
