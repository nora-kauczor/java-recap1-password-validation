package org.example;

import java.util.Scanner;
import java.util.Arrays;


public class PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine(); // TODO richtiger Ort, wo das PW herkommt
        if (matchesAllCriteria(password)) {
            System.out.println("Password received.");
        } else {
            System.out.println("Entered password does not match criteria.");
        }
        }

        public static boolean lengthIs8OrLonger (String password){
            return password.length() > 7;
        }

        public static boolean containsDigit (String password){
            boolean containsDigit = false;
            char[] passwordCharacters = password.toCharArray();
            for (char character : passwordCharacters) {
                if (Character.isDigit(character)) {
                    return containsDigit = true;
                }
            }
            return containsDigit;
        }

        public static boolean containsUpperAndLowerCase (String password){
            boolean containsUpperAndLowerCase = false;
            boolean containsLowerCase = false;
            boolean containsUpperCase = false;
            char[] passwordCharacters = password.toCharArray();
            for (char character : passwordCharacters) {
                if (Character.isLowerCase(character)) {
                    containsLowerCase = true;
                }
                ;
            }
            for (char character : passwordCharacters) {
                if (Character.isUpperCase(character)) {
                    containsUpperCase = true;
                }
            }
            if (containsLowerCase == true && containsUpperCase == true) {
                return true;
            }
            return containsUpperAndLowerCase;
        }

        public static boolean isNotWeak (String password){
            String[] weakPasswords = {"password123", "123456", "qwerty", "abc123", "password1", "letmein", "welcome", "123456789", "admin", "Passwort", "iloveyou"};
            if (Arrays.asList(weakPasswords).contains(password)) {
                return false;
            }
            return true;
        }

        public static boolean containsSpecialCharacter (String password){
            boolean containsSpecialCharacter = false;
            char[] passwordCharacters = password.toCharArray();
            for (char character : passwordCharacters) {
                if (!Character.isDigit(character) && !Character.isLetter(character)) {
                    return containsSpecialCharacter = true;
                }
            }
            return containsSpecialCharacter;
        }

        public static boolean matchesAllCriteria (String password){
            boolean matchesAllCriteria = false;
            if (lengthIs8OrLonger(password) == true &&
                    containsDigit(password) == true &&
                    containsUpperAndLowerCase(password) == true &&
                    isNotWeak(password) == true &&
                    containsSpecialCharacter(password) == true) {
                return true;
            }
            return matchesAllCriteria;
        }

    }

    ;