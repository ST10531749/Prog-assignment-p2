public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedCellPhone;
    private String firstName;
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        
        if (hasUpper == true && hasDigit == true && hasSpecial == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCellPhoneNumber(String cellPhone) {
        
        if (cellPhone.startsWith("+27") && cellPhone.length() == 12) {
            return true;
        } else {
            return false;
        }
    }

    public String registerUser(String username, String password, String cellPhone) {
        if (checkUserName(username) == false) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (checkPasswordComplexity(password) == false) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (checkCellPhoneNumber(cellPhone) == false) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        } else {
            this.storedUsername = username;
            this.storedPassword = password;
            this.storedCellPhone = cellPhone;
            return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
        }
    }

    public boolean loginUser(String username, String password) {
        if (username.equals(this.storedUsername) && password.equals(this.storedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn == true) {
            return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}