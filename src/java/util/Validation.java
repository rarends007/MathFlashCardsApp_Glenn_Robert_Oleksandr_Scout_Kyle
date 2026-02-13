/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import data.UserDB;
import java.util.ArrayList;

/**
 *
 * @author raren
 */
public class Validation {
    
     public static boolean userValidated(String username, String password, String confPassword, String firstname, String middleName, String lastName, ArrayList message){
        //Due to an array list being a reference obj it doesn't need to be a return type, else I would return a special obj, thankfully not needed
       boolean isValid = true;
       message.clear();
       
       if (firstname.length() > 50 || middleName.length() > 50 || lastName.length() > 50){
           isValid = false;
           message.add("A first, middle, or last name cannot be greater than 50 characters in length.");
       }
       
       if(!password.equals(confPassword)){
           isValid = false;
           message.add("The password and confirmed password must be the same.");
       }
       
       if(password.length() > 256){
           isValid = false;
           message.add("A password cannot be greater than 256 characters in length.");
       }
       
       if(username.length() > 10){
           isValid = false;
           message.add("A username cannot be greater than 10 characters in length.");
       }
       
       if (UserDB.usernameExists(username)) {
          isValid = false;
          message.add("This username already exists. Choose a different one.") ;
       }    
       
       return isValid;
    }
    
}
