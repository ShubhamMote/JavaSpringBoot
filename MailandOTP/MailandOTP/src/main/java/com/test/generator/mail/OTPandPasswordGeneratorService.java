package com.test.generator.mail;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class OTPandPasswordGeneratorService {


    public char[] generatePassword() {
        int length = 10;
        System.out.println("Generating password using random() : ");
        System.out.print("Your new password is : ");

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars +
                numbers + symbols;

        Random rndm_method = new Random();

        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            password[i] =
                    values.charAt(rndm_method.nextInt(values.length()));

        }
        return password;
    }

    public char[] generateOTP() {
        int length = 4;
        System.out.println("Generating OTP using random() : ");
        System.out.print("You OTP is : ");

        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] otp = new char[length];

        for (int i = 0; i < length; i++) {
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }
}
