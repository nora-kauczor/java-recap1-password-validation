package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
@Test
    void lengthIs8OrLonger_returnsFalse_whenCalledWith7CharString(){
    String password = new String(new char[7]);
    boolean expected = false;
    boolean actual = PasswordValidation.lengthIs8OrLonger(password);
            assertEquals(expected, actual);

}
}