/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import BaseClasses.User;
import java.io.Serializable;

import java.util.ArrayList;
/**
 *
 * @author raren
 */
public final class Parent extends User implements Serializable{
    private ArrayList<String> children;
    
    public Parent(){
         children = null;
         username = "";
         password = "";
         firstname = "";
         middlename="";
         lastname="";
        
    }
    
    public ArrayList<String> getChildren(){
        return this.children;
    }
    
    public void setChildren(ArrayList<String> childrenOfParent){
        for (String child : childrenOfParent){
             children.add(child);
        }
    }
    
    public void addChild(String child){
        children.add(child);
    }
    
    public void removeChild(String child){
        children.remove(child);
    }
}
