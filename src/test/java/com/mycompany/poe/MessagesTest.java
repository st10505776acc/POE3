 
package com.mycompany.poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MessagesTest {
    
     Messages messages = new Messages();
        
        //Test AssertEquals
        
        //Test message text length
        @Test
        public void testMessageText() {
            String result = messages.checkMessageText("Hi Keegan, did you receive the payment?");
            assertEquals("Message ready to send.", result);
        }
        
        //Recipient Number:
        @Test
        public void testRecipientNumber() {
            String result = messages.checkRecipient("+27718693002");
            assertEquals("Cellphone number successfully captured.", result);
                    
        }
        
        //Message Hash
        @Test
        public void testMessageHash() {
            //Test input:
            String messageID = "0023456789";
            int messageNumber = 1;
            String messageText = "Hi Mike, can you join us for dinner tonight?";
            
            String result = messages.checkMessageHash(messageID, messageNumber, messageText);
            
            assertEquals("00:0:HITONIGHT?", result);
        }
        
        //Message Menu actions selected
        // Option 1) Send message
        @Test
        public void testSendMessage() {
            String result = messages.messageMenu("1");
            assertEquals("Message successfully sent :)", result);
        }
        
        //Option 2) Delete message
        @Test
        public void testDeleteMessage() {
            String result = messages.messageMenu("0");
            assertEquals("Message deleted successfully.", result);
        }
        
        //Option 3) Save Message
        @Test
        public void testSaveMessage() {
            String result = messages.messageMenu("3");
            assertEquals("Message saved successfully.", result);
        }
        
        //Test AssertTrue
        //Message ID is created
        @Test
        public void testMessageID() {
            String result = messages.checkMessageID();
            
            assertTrue(result.startsWith("Message ID generated: "), "Message ID has been generated.");
        }
        
        
    
}
