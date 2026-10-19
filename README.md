# Prog-assignment-p2
# QuickChat Application

This is a Java console application created for my programming assignment. The application is divided into two parts: User Registration/Login and the QuickChat Messaging system.

## Project Structure

The project is organized into the following main classes:

*   **`Login.java`**: Handles the user registration and login logic. It validates the username (must contain an underscore and be <= 5 characters), password complexity (>= 8 chars, capital letter, number, special character), and South African cell phone number format.
*   **`Message.java`**: Manages individual messages. It generates a random 10-digit ID, creates a unique message hash, and validates the recipient's cell number and message length.
*   **`ChatApp.java`**: The main QuickChat application. It provides a menu for the user to send, discard, or store messages and uses an `ArrayList` to keep track of all sent messages.
*   **`Main.java`**: The entry point of the program. It runs the registration and login process, and only starts the QuickChat application if the login is successful.

## Features

*   **User Authentication**: Strict validation for usernames, passwords, and SA cell numbers.
*   **Message Hashing**: Automatically generates a unique hash for every message using the message ID, message number, and the first/last words of the text.
*   **Input Validation**: Ensures cell numbers are correctly formatted (+27...) and messages do not exceed 250 characters.
*   **Message Management**: Users can choose to send, disregard, or store messages, which are then displayed at the end of the session.

## How to Run the Application

1. Open the project in **Apache NetBeans**.
2. Make sure your project is set to use **JDK 17** or **JDK 21** (Right-click the project -> Properties -> Sources).
3. Click **Clean and Build Project** (the hammer icon) to ensure everything compiles correctly.
4. Right-click on `Main.java` and select **Run File** to start the application.
5. Follow the on-screen prompts in the console to register, log in, and use the QuickChat system.

## Test Data

If you need to test the application, use the following data:

*   **Username**: `kyl_1` (Contains underscore, <= 5 chars)
*   **Password**: `Ch&&sec@ke99!` (Has uppercase, number, special char, >= 8 chars)
*   **Cell Number**: `+27838968976` (Starts with +27, exactly 12 characters)
