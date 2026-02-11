/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstract_classes;

/**
 *
 * @author raren
 */
public abstract class user { 
    protected String username; //I want easy access to these fields in the child classes so I am using protected instead of private
    protected String password;
    protected String firstname;
    protected String middlename;
    protected String lastname;
    protected String role;
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getFirstName(){
        return this.firstname;
    }
    
    public String getMiddleName(){
        return this.middlename;
    }
    
    public String getLastName(){
        return this.lastname;
    }
    
    public String getRole(){
        return role;
    }
     public void setUsername(String username){
        this.username = username;
    }
    
     public void setPassword(String password){
        this.password = password;
    }
     
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public void setMiddlename(String middlename){
        this.middlename = middlename;
    }
    
      public void setLastname(String lastname){
       this. lastname = lastname;
    }
      
    public void setRole(String role){
        this.role = role;
    }

}
