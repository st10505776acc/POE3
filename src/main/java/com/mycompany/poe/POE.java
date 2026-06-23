

package com.mycompany.poe;

/*
The POE class contains the main method.
This class simulates a registration and login feature where:
1. A user registers with the required information.
2. A user logins once successfully registered.
*/

//Import Scanner
import java.util.Scanner;
//(Ali, 2025)
//Import Random Number Generator
import java.util.Random;
//Import JSON File
import org.json.JSONObject;


public class POE {

    public static void main(String[] args) {
        //Create scanner object
        Scanner input = new Scanner(System.in);
        
        //Create an instance of the POE class
        Login system = new Login();
        
        /*
        Registration Process:
        The user will register and the inputted information will be captured.
             
        Process flow:
        1. Welcome message
        2. Capture First Name
        3. Capture Last Name
        4. Capture Cellphone Number
        5. Capture Username
        6. Capture Password
        7. Call the registerUser(): Validate and store inputted information
        8. Registration message
        */
        
        /*
        As Lekgetho (2026) advised in a personal conversation, the registration method has been updated to validate the user input line by line using a while loop.
        */
        
        //Welcome message
        System.out.println("-----------REGISTRATION SCREEN------------");
        System.out.println("Welcome  to the POE!");
        System.out.println("Please provide the following information to register.");
        
        //Capture First Name
       System.out.println("Please provide your first name: ");
            String firstName = input.nextLine();
            
            if(system.checkFirstName(firstName)) {
                System.out.println("First name successfully captured.");
            }
        
        
        //Capture Last Name
        System.out.println("Please provide your last name: ");
           String lastName = input.nextLine(); 
           
           if(system.checkLastName(lastName)) {
               System.out.println("Last name successfully captured.");
           }
     
        //Capture Cellphone Number
        System.out.println("Please provide your cellphone number: ");
            String number = input.nextLine();
            
            if(system.checkCellPhoneNumber(number)) {
                System.out.println("Cell phone number successfully captured.");
            }
        
  
        //Capture Username
        
        System.out.println("""
                          Please provide a valid username: 
                          Containing an underscore and no more than 5 characters.
                          """);
        String username = input.nextLine();
         
            if(system.checkUsername(username)) {
                System.out.println("Username successfully captured.");
        }
        
        
        //Capture Password
        System.out.println("""
                           Please provide a valid password: 
                           Eight characters,
                           A capital letter,
                           A number,
                           And a special character.
                           """);
        String password = input.nextLine();
                    
            if(system.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
            }
            
        
        
        //Call the registerUser(): Validate and store inputted information
        String result = system.registerUser(firstName, lastName, username, password, number);
        
        //Registration message
        System.out.println(result);
        
        /*
        Login Process:
        Once the user has successfully registered, they will attempt to log in.
        
        Work flow:
        1. Login Screen Message
        2. Attempt Login
        */
        
        //Login Screen Message
        if(result.equals("Registration was successful! :)"))
        {
            System.out.println("-----------LOGIN SCREEN------------");
            System.out.println("Please provide your login details: ");
            
            //Login unsuccessful loop
            boolean loginSuccess = false;
            for(int attempt = 1; attempt <= 3; attempt++)
            {
                System.out.println("Attempt " + attempt + " of 3");
                
                System.out.println("Please enter your username: ");
                String loginUsername = input.nextLine();
                
                System.out.println("Please enter your password: ");
                String loginPassword = input.nextLine();
              
                
            //Login Successful
            loginSuccess = system.loginUser(loginUsername, loginPassword);
            
            if(loginSuccess)
            {
                System.out.println(system.returnLoginStatus(true));
                break;
            } else {
                System.out.println("Login Failed. Please try again.");
            }
            
            if(attempt == 3 && !loginSuccess)
            {
                System.out.println("Max number of login attemp ts have been reached. \nSystem exiting.");
            }
            }           
        
        }
        
        /*
        POE PART 2: MESSAGING SYSTEM
        */
        
        Messages quickChat = new Messages();
        
        /*
        Numeric Menu:
        Option 1) Send Messages
        Option 2) Show Recent Messages
        (Still in development, so message is "Coming Soon."
        Option 3) Quit
        */
        
        System.out.println("Welcome to QuickChat.");
        //(Gore, 2021)
        //Display menu options
        boolean exit = false;

        while (!exit) 
        {
            System.out.println("\nChoose an option from the main menu below:");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show Recent Messages");
            System.out.println("Option 3) Quit");

            String options = input.nextLine().trim();

            switch (options) {
                case "1" :
                    sendMessages(); //referencing sendMessages method
                    break;
                case "2" : 
                    System.out.println("Coming soon...");
                    break;
                case "3" :                
                    System.out.println("See you soon :)");
                    exit = true;
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid option selected. Please select a valid option from the main menu.");
            }
        }
  
        input.close();
    }
    
    //Option 1: Send Messages method
    public static void sendMessages() {
        
        Messages quickChat = new Messages();
        
        Scanner scan = new Scanner(System.in);
        
        //User to specify how many messages to send
        System.out.println("How many messages would you like to send?");
        int messageCount = scan.nextInt();
        
        //Number each message that is sent
        int messageSentCount = 0;
        
        for (int i = 1; i <= messageCount; i++) {
            System.out.println("\nMessage " + i + " of " + messageCount + ":");
        
        //Call the generateID to form teh Message ID
        String messageID = quickChat.checkMessageID();
        
        //Count messages as they are sent
        int messageNumber = i;
        
        
        
    //Recipient Information
    System.out.println("What is the recipient's cellphone number?");
    String recipient = scan.nextLine();
        
    
    
    //Sending Messages:   
    System.out.println("Enter your message below:");
    String messageText = scan.nextLine();
        
          
    
    //Call Message Hash
    String messageHash = quickChat.checkMessageHash(messageID, messageNumber, messageText);
    
    
    //Prompt user to action Message Menu
    boolean actionCompleted = false;
    
    //(Gore, 2021)
    //Message menu
    while(!actionCompleted)
    {
       System.out.println("\nHow would you like to action this message?");
       System.out.println("\nOption 1) Send Message");
       System.out.println("\nOption 2) Press 0 to delete the message");
       System.out.println("\nOption 3) Save message");
    
       String action = scan.nextLine();
       
       switch (action){
           case "1" :
               messageSentCount++;      
       
                //Display message details:
                 System.out.println("----------------------------");
                 System.out.println("\nMESSAGE DETAILS:");
                 System.out.println("Message ID: " + messageID); 
                 System.out.println("Message Hash: " + messageHash);
                 System.out.println("Recipient: " + recipient);
                 System.out.println("Message: " + messageText);
                 System.out.println("Message " + messageSentCount + " of " + messageCount);
                 System.out.println("\n---------------------------"); 
                 
                 actionCompleted = true;
                 break;
           case "0" :
               actionCompleted = true;
               break;
           case "3" :
       
               //(Shaik, 2026)
               //Store message in JSON file
                JSONObject messageObject = new JSONObject();
                messageObject.put("id", messageID);
                messageObject.put("text", messageText);
                
                actionCompleted = true;               
               break;
           default :
                System.out.println("Please select a valid option from the main menu.");
        
       }
     
    }
 }
        System.out.println("\nTotal messages sent: " + messageSentCount);
        System.out.println("");
    
               
    }
}
