/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import java.io.Serializable;

/**
 *
 * @author raren
 */
public class Class implements Serializable {
    private String classID;
    private String name;
    private double grade;
    
    public Class(){
        classID = null;
        name = null;
        grade = -1;
    }
    
    public void setClassID(String classID){
        this.classID = classID;
    }
    
    public void setName(String className){
        name = className;
    }
    
    public void setGrade(double grade){
        this.grade = grade;
    }
    
    public String getClassID(){
        return classID;
    }
    
    public String getName(){
        return name;
    }
   
    public double getGrade(){
        return grade;
    }
}
