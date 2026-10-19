package chatapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ChatApp {
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<Message> sentMessages = new ArrayList<>();
            
            boolean running = true;
            int msgCount = 1;
            
            System.out.println("Welcome to QuickChat.");
            
            while (running) {
                System.out.println("\n1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choose option: ");
                String choice = input.nextLine();
                
                if (choice.equals("1")) {
                    System.out.print("How many messages do you want to enter? ");
                    int total = input.nextInt();
                    input.nextLine();
                    
                    for (int i = 0; i < total; i++) {
                        System.out.println("\n--- Message " + msgCount + " ---");
                        
                        System.out.print("Enter recipient (+27...): ");
                        String rec = input.nextLine();
                        
                        System.out.print("Enter message (max 250 chars): ");
                        String text = input.nextLine();
                        
                        Message newMsg = new Message(msgCount, rec, text);
                        
                        if (newMsg.checkMessageLength() == false) {
                            System.out.println("Please enter a message of less than 250 characters.");
                            i = i - 1;
                        } else if (newMsg.checkRecipientCell() == false) {
                            System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                            i = i - 1;
                        } else {
                            System.out.println("Message Hash: " + newMsg.messageHash);
                            
                            System.out.println("1 - Send Message");
                            System.out.println("2 - Disregard Message");
                            System.out.println("3 - Store Message");
                            System.out.print("Choice: ");
                            int action = input.nextInt();
                            input.nextLine();
                            
                            if (action == 1) {
                                sentMessages.add(newMsg);
                                System.out.println(newMsg.sentMessage(1));
                                msgCount = msgCount + 1;
                            } else if (action == 2) {
                                System.out.println("Message discarded.");
                            } else if (action == 3) {
                                sentMessages.add(newMsg);
                                System.out.println(newMsg.sentMessage(3));
                                msgCount = msgCount + 1;
                            }
                        }
                    }
                } else if (choice.equals("2")) {
                    System.out.println("Coming Soon.");
                } else if (choice.equals("3")) {
                    System.out.println("Goodbye.");
                    running = false;
                } else {
                    System.out.println("Invalid option.");
                }
            }
            
            System.out.println("\n--- List of Sent Messages ---");
            
            for (int i = 0; i < sentMessages.size(); i++) {
                System.out.println("Message ID: " + sentMessages.get(i).messageID);
                System.out.println("Message Hash: " + sentMessages.get(i).messageHash);
                System.out.println("Recipient: " + sentMessages.get(i).recipient);
                System.out.println("Message: " + sentMessages.get(i).message);
                System.out.println("-------------------------");
            }
        }
    }
}