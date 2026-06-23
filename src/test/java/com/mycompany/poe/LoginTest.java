
package com.mycompany.poe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 /*
Test Units:
Testing of the registration process and its methods. As well as the login process.
*/

public class LoginTest {
    
    
    private Login login;
    
    @BeforeEach
    public void setup() {
        login = new Login();
    }
    
    //Test: assertEquals
    
    /*
    Test Valid Registration:
    
    Test data follows the parameters set out for the first name, last name, username, password, and cellphone number.
    Expected result: Successful registration message.
    */
    @Test
    public void testValidRegistration() {
        String result = login.registerUser("kyle", "Tester", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Registration was successful! :)", result);
    }

    /*
    Test Invalid Registration:
    Multiple tests conducted to have various failed to capture error messages.
    If one of the input requests do not adhere to the parameters, registration will not be successful.
   
    Test Invalid first name
    Test data: "Kyl_1"
    Expected result: Failed to capture first name message.
    */
    @Test
      public void testInvalidFirstName() {
        String result = login.registerUser("Kyl_1", "Tester", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("""
                                      
                   First name incorrectly formatted;
                   Please ensure that the first name contains only letters.
                                      
                   """, result);
    }
    
    /*
    Test Invalid last name
    Test data: "V@nja"
    Expected result: Failed to capture last name message.
    */
    @Test
    public void testInvalidLastName() {
        String result = login.registerUser("kyle", "V@nja", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("""
                                      
                   Last name incorrectly formatted;
                   Please ensure that the last name contains only letters.
                                      
                   """, result);
        }
    
    /*
    Test Invalid Username
    Test data: "kyle!!!!!!!!!"
    Expected result: Failed to capture username message.
    */
    @Test
    public void testInvalidUsername() {
        String result = login.registerUser("kyle", "Tester", "kyle!!!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.", result);
        }
    
    /*
    Test Invalid password
    Test data: "password"
    Expected result: Failed to capture password message.
    */
    @Test
    public void testInvalidPassword() {
        String result = login.registerUser("kyle", "Tester", "kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted. Please ensure that the password contains at least: \nEight characters, \nA capital letter, \nA number, \nAnd a special character.", result);
    }
    
    /*
    Test Invalid Cellphone Number
    Test data: "08966553"
    Expected result: Failed to capture cellphone number message.
    */
    @Test
    public void testInvalidNumber() {
        String result = login.registerUser("kyle", "Tester", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
        }
    
    //Tests: assertTrue
    
    /*
    Test Valid Login:
    
    Test data: correctly supplied username and password
    Expected result: True
    */
    @Test
    public void testLoginSuccess() {
        login.registerUser("Kyle", "Tester", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    /*
    Test First Name Correctly Formatted:
    
    Test data: correctly formatted first name
    Expected result: True
    */
    @Test
      public void testTrueFirstName() {
        assertTrue(login.checkFirstName("Kyle"));
    }
    
    /*
    Test Last Name Correctly Formatted:
    
    Test data: correctly formatted last name
    Expected result: True
    */
    @Test
    public void testTrueLastName() {
        assertTrue(login.checkLastName("Tester"));
    }
            
    /*
    Test Username Correctly Formatted:
    
    Test data: correctly formatted username
    Expected result: True
    */
    @Test
    public void testTrueUsername() {
        assertTrue(login.checkUsername("kyl_1"));
    }
    
    /*
    Test Password Correctly Formatted:
    
    Test data: correctly formatted password
    Expected result: True
    */
    @Test
    public void testTruePassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    /*
    Test Cellphone Number Correctly Formatted:
    
    Test data: correctly formatted cellphone number
    Expected result: True
    */
    @Test
    public void testTrueNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    //Tests: assertFalse
    
    /*
    Test Invalid Login:
    
    Test data 1: incorrectly supplied username, incorret password
    Test data 2: incorrectly supplied password, incorrect username
    Expected result: False
    */
    @Test
       public void testLoginFail() {
        login.registerUser("Kyle", "Tester", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("kyl_1", "password"));
        assertFalse(login.loginUser("kyle!!!!!!!!!", "Ch&&sec@ke99!"));
    }
    
    /*
    Test Invalid first name:
    
    Test data 1: incorrectly supplied first name
    Expected result: False
    */
    @Test
    public void testFirstNameFalse() {
        assertFalse(login.checkFirstName("Kyl_1"));
    }
    
    /*
    Test Invalid last name:
    
    Test data 1: incorrectly supplied last name
    Expected result: False
    */
    @Test
    public void testLastNameFalse() {
        assertFalse(login.checkLastName("V@nja"));
    }
    
    /*
    Test Invalid Username:
    
    Test data 1: incorrectly supplied username
    Expected result: False
    */
    @Test
    public void testUsernameFalse() {
        assertFalse(login.checkUsername("kyle!!!!!!!!!"));
    }
    
    /*
    Test Invalid Password:
    
    Test data 1: incorrectly supplied password
    Expected result: False
    */
    @Test
    public void testPasswordFalse() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    /*
    Test Invalid Cellphone Number:
    
    Test data 1: incorrectly supplied cellphone number
    Expected result: False
    */
    @Test
    public void testNumberFalse() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}
