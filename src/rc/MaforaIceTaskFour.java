package rc;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Keoagile Mafora (ST10457036)
 */
public class MaforaIceTaskFour {
    static Login objLogin = new Login();
    public static void main(String[] args) {
    registerUser();
    loginStatus();
    chooseOpt();
    
    
    }
   
    //Method to promt the user for input
    public static void registerUser() {
    
    objLogin.setFirstName(JOptionPane.showInputDialog("Enter First Name"));
    objLogin.setLastName(JOptionPane.showInputDialog("Enter Last Name"));
    
    
    
    do {
        
    objLogin.setUserName(JOptionPane.showInputDialog(null,"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length ","Username Validation",JOptionPane.QUESTION_MESSAGE));
  
    }while (objLogin.checkUserName());
          JOptionPane.showMessageDialog(null, "Username successfully captured", "Thank You", JOptionPane.INFORMATION_MESSAGE);
    do{
    objLogin.setPassword(JOptionPane.showInputDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", "Password Validation", JOptionPane.QUESTION_MESSAGE));
    }while (!objLogin.checkPasswordComplexity());
           JOptionPane.showMessageDialog(null, "Password successfully captured", "Thank You", JOptionPane.INFORMATION_MESSAGE);
           
    }
    
    
    public static void chooseOpt() {
        boolean quit = false;
        
        
        String taskName, taskDescription, taskId, developerDetails;
        int taskNumber;
        
        String[] selection = {"Add tasks", "Show Report", "Quit"};
        do{
        var options = JOptionPane.showOptionDialog(null, "Choose one of these features", "EasyKanban", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, selection,0);
        
        if(options == 0){
           taskName = JOptionPane.showInputDialog("Add Tasks");
           
        taskDescription = JOptionPane.showInputDialog("Add Task description");
        
         int min=1; 
         int max=100;
           
           JOptionPane.showMessageDialog(null, "Generating random numberfor task number " +min+" to "+max);
           Random random = new Random();
           JOptionPane.showMessageDialog(null,"Your task number is " + random.nextInt(max-min+1)+min);
           
        developerDetails = objLogin.getFirstName() + objLogin.getLastName();
        JOptionPane.showMessageDialog(null, "Developer's details" + developerDetails);
           
           
        }
        if(options== 1){
            JOptionPane.showMessageDialog(null,"Coming soon");
        }
        if(options== 2){
            JOptionPane.showMessageDialog(null,"Quiting...");
            quit = true;
        }
        }
        while (quit == false);
    }

    //Method for login 
    
    public static void loginStatus() {
        JOptionPane.showMessageDialog(null, "Welcome,Please log in to your EasyKanban"); 
        String loginUsername, loginPassword;
        loginUsername = JOptionPane.showInputDialog("Enter your registered username:");
        loginPassword = JOptionPane.showInputDialog("Enter your registered password:");
        
        
        
        
        boolean loggedUser = objLogin.loginUser(loginUsername, loginPassword);
        
        
        String status = objLogin.returnLogin(loggedUser);
        JOptionPane.showMessageDialog(null, status);
        
    }
    
    
    
    
}
/*if(selection== 0){
            JOptionPane.showInputDialog("Add Tasks");
        }
        if(selection== 1){
            JOptionPane.showMessageDialog(null,"Coming soon");
        }
        if(selection== 2){
            JOptionPane.showMessageDialog(null,"quit");
        }*/