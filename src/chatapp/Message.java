package chatapp;

import java.util.Random;

public class Message {
    String messageID;
    int messageNumber;
    String recipient;
    String message;
    String messageHash;

    public Message(int num, String rec, String msg) {
        this.messageNumber = num;
        this.recipient = rec;
        this.message = msg;
        this.messageID = makeID();
        this.messageHash = makeHash();
    }

    public String makeID() {
        Random rand = new Random();
        
        long num = (long) (rand.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(num);
    }

    public boolean checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() == 12) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMessageLength() {
        if (message.length() <= 250) {
            return true;
        } else {
            return false;
        }
    }

    public String makeHash() {
        String firstTwo = messageID.substring(0, 2);
        String numStr = String.valueOf(messageNumber);
        
        String cleanMsg = message.trim();
        
        
        String[] words = cleanMsg.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        
        
        lastWord = lastWord.replace(",", "").replace(".", "").replace("!", "").replace("?", "");

        return firstTwo + ":" + numStr + ":" + firstWord + lastWord;
    }

    
    public String sentMessage(int choice) {
        if (choice == 1) {
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            return "Message successfully stored.";
        } else {
            return "Invalid choice.";
        }
    }
}