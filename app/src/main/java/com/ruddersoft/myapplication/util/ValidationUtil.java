package com.ruddersoft.myapplication.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {


    public static boolean nameValidation(String name) {
        final String nameRegx = "^[\\p{L} .'-]+$";

        Pattern pattern = Pattern.compile(nameRegx);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }


    public static boolean mobileNumberValidation(String mobileNumber) {
        final String mobileNumberRegex = "^[789]\\d{9}$";
        Pattern pattern = Pattern.compile(mobileNumberRegex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();

    }

    public static boolean adharNumberValidation(String adhar) {
        final String adharNumberRegex = "^[2-9]{1}[0-9]{11}$";
        Pattern pattern = Pattern.compile(adharNumberRegex);
        Matcher matcher = pattern.matcher(adhar);
        return matcher.matches();

    }

    public static boolean addressValidation(String address) {
        final String addressRegex = "^[\\p{L} .'-]+$";

        Pattern pattern = Pattern.compile(addressRegex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }


    public static boolean isValidRoomNo(String roomNo) {
        String alphanumeric = "^[a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(alphanumeric);
        Matcher matcher = pattern.matcher(roomNo);
        return matcher.matches();
    }
}
