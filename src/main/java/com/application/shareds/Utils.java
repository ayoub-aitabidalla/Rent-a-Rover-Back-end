package com.application.shareds;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String AlphaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYYZabcdefijklmnopqrstuvwxyz";
    public String generateStringId(int length)
    {
        StringBuilder returnValue = new StringBuilder(length);
        for(int i = 0; i<length; i++)
        {

            returnValue.append(AlphaNum.charAt(RANDOM.nextInt(AlphaNum.length())));
        }
        return new String (returnValue);
    }
}
