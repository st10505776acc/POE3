/*
fb-shaik, 2026
Emeris-Distance-PROG5121 [GitHub]
https://github.com/fb-shaik/Emeris-Distance-PROG5121/blob/main/Library_App%20(If-Statement%2C%20For-Loop%2C%20Unit%20Test)/src/main/java/com/mycompany/library_app/LibrarySystem.java
(accessed_17 April 2026)
*/
package com.mycompany.poe;

    /*
Class for user account logic
Information required to login:
* First Name
* Last Name
* Username
* Password
* Cellphone number

Information will be requested and stored to the user's profile.
It will also be validated as per the perameters:
* First name:
    Only letters

*Last name:
    Only letters

* Username:
    _
    <= 5 characters

* Password:
    >= 8 characters
    Capital letter
    Number
    Special Character

* Cellphone:
    <= 10 characters
    +27
*/


public class Login {
    
    
    /*
    User Profile Details: 
    The private variables will store the registered user's details.
    Encapsulation is used to restrict direct access for security.
    */
    private String storedFirstName;
    private String storedLastName;
    private String storedUsername;
    private String storedPassword;
    private String storedNumber;
    
    /*
    Getters & Setters:
    Getting the required user details.
    Setting the value to the attributes of the user's profile.
    */
    
    //First Name

    public String getStoredFirstName() {
        return storedFirstName;
    }
    
    public void setStoredFirstName(String storedFirstName) {
        this.storedFirstName = storedFirstName;
    }
    
    //Last Name

    public String getStoredLastName() {
        return storedLastName;
    }

    public void setStoredLastName(String storedLastName) {
        this.storedLastName = storedLastName;
    }
            
    //Username

    public String getStoredUsername() {
        return storedUsername;
    }
    
    public void setStoredUsername(String storedUsername) {
        this.storedUsername = storedUsername;
    }

    //Password
    
    public String getStoredPassword() {
        return storedPassword;
    }
    
    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }
    
    //Cellphone Number

    public String getStoredNumber() {
        return storedNumber;
    }
    
    public void setStoredNumber(String storedNumber) {
        this.storedNumber = storedNumber;
    }
    
    /*
    Validation Methods:
    Placing the parameters on the required information for the user profile details.
    */ /*
    Process flow:
    1. Username:
    Must contain an underscore (_).
    Have a maximum of 5 characters.
    
    2. Password:
    Have a minimum of 8 characters.
    Contain a capital letter.
    Contain a number.
    Contain a special character.
    
    3. Cellphone Number:
    Have a maximum of 10 characters.
    Contain an international country code (+27 for South Africa)
    
    4. First Name:
    Must contain only letters
    
    5. Last Name:
    Must contain only letters
    
    Returns:
    valid: true
    Invalid: false
    */
    
    //Username:
    public boolean checkUsername(String username)
    {
        return username != null
                && username.length() <= 5 
                && username.contains("_");
    }
    
    //Password:
    public boolean checkPasswordComplexity(String password)
    {
        /*
        GeeksforGeeks. 2025
        How to validate a Password using Regular Expressions in Java.
        GeeksforGeeks
        https://www.geeksforgeeks.org/java/how-to-validate-a-password-using-regular-expressions-in-java/
        [accessed_18 April 2025].
        */
        String regexp = "^(?=.*[0-9])"
                + "(?=.*[a-z])"
                + "(?=.*[A-Z])"
                + "(?=.*[!@#$$%^&*()]).{8,}$"; 
        
        return password != null && password.matches(regexp);
                
    }
    
    //Cellphone Number:    
    public boolean checkCellPhoneNumber(String number)
    {
        /*
        Blackbam. 2020
        What regular expression will match valid international phone numbers?
        Stack Overflow
        https://stackoverflow.com/questions/2113908/what-regular-expression-will-match-valid-international-phone-numbers
        [accessed_18 April 2026].
        */
        //Syntax: Must contain a + or 00. Must use some numbers and only numbers. A minimum of 3 digits, and a maximum of 10.
        String regexc = "^(\\+27|0027)[0-9]{3,12}$";
        return number.matches(regexc);
    }
    
    //First Name:
    public boolean checkFirstName(String firstName)
    {
        /*
        Krishnan, G. 2017
        Tell if string contains a-z chars [duplicate]
        Stack Overflow
        https://stackoverflow.com/questions/24086968/tell-if-string-contains-a-z-chars
        [accessed_18 April 2026].
        */
        String regexf = "[a-zA-Z]+";
        return firstName != null && firstName.matches(regexf);
    }
    
    //Last Name:
    public boolean checkLastName(String lastName)
    {
        String regexl = "[a-zA-Z]+";
        return lastName != null && lastName.matches(regexl);
    }
    
    /*
    Registration Methods:
    This will register the user once the information provided meets the requirements(parameters) placed above.
    
    Process flow:
    1. Validate Username
    2. Validate Password
    3. Validate Cellphone Number
    4. Validate First Name
    5. Validate Last Name
    
    Returns:
    Valid: Successful message
    Invalid: Error message
    */
    
    public String registerUser(String firstName, String lastName, String username, String password, String number)
    {
        /*
        GeeksforGeeks. 2026
        Java if-else Statement
        GeeksforGeeks
        https://www.geeksforgeeks.org/java/java-if-else-statement-with-examples/
        [accessed_18 April 2026]
        */
        //1. Validate username:
        if(!checkUsername(username))
        {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.";
        } 
        
        
        //2. Validate Password
        if(!checkPasswordComplexity(password))
        {
            return "Password is not correctly formatted. Please ensure that the password contains at least: \nEight characters, \nA capital letter, \nA number, \nAnd a special character.";
        }
        
        //3. Validate Cellphone Number
        if(!checkCellPhoneNumber(number))
        {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        //4. Validate First Name
        if(!checkFirstName(firstName))
        {
            return """
                                      
                   First name incorrectly formatted;
                   Please ensure that the first name contains only letters.
                                      
                   """;
        }
        
        //5. Validate Last Name
        if(!checkLastName(lastName))
        {
            return """
                                      
                   Last name incorrectly formatted;
                   Please ensure that the last name contains only letters.
                                      
                   """;
        }
        
        
        //Store the validated data using encapsulation
        
        setStoredUsername(username);
        setStoredPassword(password);
        setStoredNumber(number);
        setStoredFirstName(firstName);
        setStoredLastName(lastName);
        
       
        return "Registration was successful! :)";
        
    }
    
    /*
    Login Methods:
    These methods will verify the provided information from the user against the registration information. 
    If the information corresponds, then the user will successfully log in.
    
    Work Flow:
    1. Login input v stored: Compare input username and password to stored username and password.
    3. Login Status Message: validation log in message.
    
    Returns:
    Valid: Welcome message.
    Invalid: Error message.
    */
    
    //Login input v stored
    public boolean loginUser(String username, String password)
    {
        return username.equals(getStoredUsername()) 
                && password.equals(getStoredPassword());
    }
    
    //Login Status Message
    public String returnLoginStatus(boolean Success)
    {
        if(Success)
        {
            return "Welcome " + getStoredFirstName() + " , " + getStoredLastName() + ". \nIt is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    } 
}
