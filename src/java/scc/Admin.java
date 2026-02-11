/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import abstract_classes.user;
import java.io.Serializable;

/**
 *
 * @author raren
 */
public final class Admin extends user implements Serializable { // I don't want this class inherited by any others.
    
    public Admin(){
         username = "";
         password = "";
         firstname = "";
         middlename="";
         lastname="";
         role="";
    }
    
    
    
}
