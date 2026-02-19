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
       
       if(isValid){
           message.clear();
       }
       
       return isValid;
    }
     
     
     
    public static boolean qaValid(String question, String answer, String points, String difficulty, ArrayList<String> message){
        boolean isValidQA = true;
        
        if(
            !helper_checkStringNullorBlank("answer", answer, message) ||
            !helper_checkStringNullorBlank("question", question, message) ||
            !helper_checkStringNullorBlank("points", points, message) ||
            !helper_checkStringNullorBlank("difficulty", difficulty, message) 
                ){
            isValidQA = false;
        }
        
        if(
           !helper_checkIsNumber("difficulty", difficulty, message)
                ){
            isValidQA = false;
        }
        
        if(
            !helper_checkIsNumber("points", points, message)
                ){
            isValidQA = false;
         }
        
        return isValidQA;
    }
    
    public static boolean helper_checkStringNullorBlank(String fieldName, String str, ArrayList<String> message){
        boolean notNullOrBlank = true;
        if (str == null || str.equals("")){
            notNullOrBlank = false;
            message.add(str + " must not be blank");
        }
        
        return notNullOrBlank;
    }
    
    public static boolean helper_checkIsNumber(String fieldName, String num, ArrayList<String> message){
        boolean isNum = false;
     
        try{
            Integer.parseInt(num);
            isNum = true;
        }catch(NumberFormatException ex){
           System.out.println("checked for integer");
        }
        
        try{
            Double.parseDouble(num);
            isNum = true;
        }catch(NumberFormatException ex){
            System.out.println("checked for real number");
        }
        
        if(!isNum){
            message.add(fieldName + " must be a number");
            System.out.println("\n\n in .qaValid() -> .helper_checkisNumber()  -> checks determine not a number\n\n");
        }
        
        return isNum;
    }
        
    
}
