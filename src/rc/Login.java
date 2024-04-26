package rc;

/**
 * @author Keoagile Mafora (ST10457036)
 */
public class Login {
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    
    //Create constructures - to set default variables

    public Login() {
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.password = "";
    }
    
    //Create the getters/accessor methods

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    //Create setter methods/mutator methods

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //A method to check the username if it has less than 5 letters and has an underscore

       public boolean checkUserName() {
         if (getUserName().contains("_") && getUserName().length() <= 5) {
             return false;
        }
        return true;
       }
       
       //Method that checks the passwords complexity
    
    public boolean checkPasswordComplexity() {
            if (getPassword().length() < 8) {
                return false;
            }
            
            boolean hasCapitalLetter = false;
            boolean hasNumber = false;
            boolean hasSpecialCharacter = false;
            
            for (int i = 0; i < getPassword().length(); i++) {
                char c = getPassword().charAt(i);
                if(Character.isUpperCase(c)) {
                    hasCapitalLetter =true;
                } else if (Character.isDigit(c)) {
                    hasNumber = true;
                }else if (isSpecialCharacter(c)) {
                    hasSpecialCharacter = true;
                }
            }
            
            return hasCapitalLetter && hasNumber && hasSpecialCharacter;
        }
       
    //To enter special characters

    public boolean isSpecialCharacter( char c) {
           String specialCharacters = "~!@#$%^&*_+{}:<>.,';][=-`";
           return specialCharacters.indexOf(c) != -1 ;
       }
    
    //Method that makes sure that the username and the Password is the same as the credentials entered when registering
    public boolean loginUser(String LoginUsername, String loginPassword) {
        if (LoginUsername == userName || loginPassword == password){
        return false;
    }
        else
            return  true;
    }
    
    
    public String returnLogin(boolean status) {
        if (status == true) {
            return "Welcome to EasyKanban";
            
        }
        else
            return "username and password incorrect";
    }
}
