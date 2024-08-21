package org.example;

import java.util.Scanner;

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine(); // TODO richtiger Ort, wo das PW herkommt
    }

    public static boolean lengthIs8OrLonger(String password) {
        return password.length() > 7;
    }


    public static boolean containsDigit(String password) {
        boolean containsDigit = false;
        char[] passwordCharacters = password.toCharArray();
        for (char character : passwordCharacters) {
            if (Character.isDigit(character)) {
                return containsDigit = true;
            }
        }
       return containsDigit;
    }
// public static boolean containsUpperAndLowercase(String password)
// public static boolean isCommon(String password)

}