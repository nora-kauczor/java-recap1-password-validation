package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(
            value = {"67ywfo201, true",
                    "MarkusMeiersPasswort, false",
                    " Passw0rt, true"
            }
    )
    void testContainsDigit(String password, boolean expected) {
        boolean actual = PasswordValidation.containsDigit(password);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"hallomama, false",
                    "DGH6764838HGDHGD, false",
                    " wtwedY, true"
            }
    )
    void testContainsUpperAndLowerCase(String password, boolean expected) {
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