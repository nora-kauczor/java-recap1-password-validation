package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
    @Test
    void lengthIs8OrLonger_returnsFalse_whenCalledWith7CharString() {
        String password = new String(new char[7]);
        boolean expected = false;
        boolean actual = PasswordValidation.lengthIs8OrLonger(password);
        assertEquals(expected, actual);
    }

    @Test
    void lengthIs8OrLonger_returnsTrue_whenCalledWith25CharString() {
        String password = new String(new char[25]);
        boolean expected = true;
        boolean actual = PasswordValidation.lengthIs8OrLonger(password);
        assertEquals(expected, actual);
    }

    @Test
    void lengthIs8OrLonger_returnsTrue_whenCalledWith8CharString() {
        String password = new String(new char[8]);
        boolean expected = true;
        boolean actual = PasswordValidation.lengthIs8OrLonger(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_returnsTrue_whenCalledWith67ywfo201() {
        String password = "67ywfo201";
        boolean expected = true;
        boolean actual = PasswordValidation.containsDigit(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_returnsFalse_whenCalledWithMarkusMeiersPasswort() {
        String password = "MarkusMeiersPasswort";
        boolean expected = false;
        boolean actual = PasswordValidation.containsDigit(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_returnsTrue_whenCalledWithPassw0rt() {
        String password = "Passw0rt";
        boolean expected = true;
        boolean actual = PasswordValidation.containsDigit(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLowerCase_returnsFalse_whenCalledWithhallomama() {
        String password = "hallomama";
        boolean expected = false;
        boolean actual = PasswordValidation.containsUpperAndLowerCase(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLowerCase_returnsFalse_whenCalledWithDGH6764838HGDHGD() {
        String password = "DGH6764838HGDHGD";
        boolean expected = false;
        boolean actual = PasswordValidation.containsUpperAndLowerCase(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLowerCase_returnsTrue_whenCalledWitheywtwedY() {
        String password = "eywtwedY";
        boolean expected = true;
        boolean actual = PasswordValidation.containsUpperAndLowerCase(password);
        assertEquals(expected, actual);
    }

    @Test
    void isNotWeak_returnsFalse_whenCalledWithPasswort() {
        String password = "Passwort";
        boolean expected = false;
        boolean actual = PasswordValidation.isNotWeak(password);
        assertEquals(expected, actual);
    }

    @Test
    void isNotWeak_returnsFalse_whenCalledWithiloveyou() {
        String password = "iloveyou";
        boolean expected = false;
        boolean actual = PasswordValidation.isNotWeak(password);
        assertEquals(expected, actual);
    }

    @Test
    void isNotWeak_returnsTrue_whenCalledWith382yse9Auif() {
        String password = "382yse9Auif";
        boolean expected = true;
        boolean actual = PasswordValidation.isNotWeak(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialCharacter_returnsFalse_whenCalledWithhallomama() {
        String password = "hallomama";
        boolean expected = false;
        boolean actual = PasswordValidation.containsSpecialCharacter(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialCharacter_returnsTrue_whenCalledWith$$$money$$$() {
        String password = "$$$money$$$";
        boolean expected = true;
        boolean actual = PasswordValidation.containsSpecialCharacter(password);
        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialCharacter_returnsTrue_whenCalledWith$oyuwy() {
        String password = "$oyuwy";
        boolean expected = true;
        boolean actual = PasswordValidation.containsSpecialCharacter(password);
        assertEquals(expected, actual);
    }

    @Test
    void matchesAllCriteria_returnsTrue_whenCalledWith78Yidid4537$() {
        String password = "78Yidid4537$";
        boolean expected = true;
        boolean actual = PasswordValidation.matchesAllCriteria(password);
        assertEquals(expected, actual);
    }

    @Test
    void matchesAllCriteria_returnsTrue_whenCalledWith$$uhdiwdiu546T() {
        String password = "$$uhdiwdiu546T";
        boolean expected = true;
        boolean actual = PasswordValidation.matchesAllCriteria(password);
        assertEquals(expected, actual);
    }

    @Test
    void matchesAllCriteria_returnsFalse_whenCalledWithhallomama() {
        String password = "hallomama";
        boolean expected = false;
        boolean actual = PasswordValidation.matchesAllCriteria(password);
        assertEquals(expected, actual);
    }

    @Test
    void matchesAllCriteria_returnsFalse_whenCalledWithPassw0rd23() {
        String password = "Passw0rd23";
        boolean expected = false;
        boolean actual = PasswordValidation.matchesAllCriteria(password);
        assertEquals(expected, actual);
    }

    @RepeatedTest(100)
    void generatePassword_returnsValidPassword_whenCalled() {
        String password = PasswordValidation.generatePassword();
        assertTrue(PasswordValidation.matchesAllCriteria(password));
    }

}