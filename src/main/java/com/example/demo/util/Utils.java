package com.example.demo.util;

import java.util.Base64;
import java.util.List;

public class Utils {

    // Extract numbers from the input data
    public static List<String> extractNumbers(List<String> data) {
        return data.stream()
                .filter(str -> str.matches("\\d+"))
                .toList();
    }

    // Extract alphabets from the input data
    public static List<String> extractAlphabets(List<String> data) {
        return data.stream()
                .filter(str -> str.matches("[a-zA-Z]"))
                .toList();
    }

    // Find the highest lowercase alphabet
    public static String findHighestLowercase(List<String> alphabets) {
        return alphabets.stream()
                .filter(str -> str.matches("[a-z]"))
                .max(String::compareTo)
                .orElse("");
    }

    // Check if a number is prime
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Validate and decode Base64 file
    public static boolean isFileValid(String base64) {
        try {
            Base64.getDecoder().decode(base64);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Get MIME type of the file (for demonstration purposes)
    public static String getMimeType(String base64) {
        // Dummy value: In production, use libraries to detect MIME type
        return "application/octet-stream";
    }
}
