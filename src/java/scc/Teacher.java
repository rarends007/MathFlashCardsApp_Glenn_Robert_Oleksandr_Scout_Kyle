/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import abstract_classes.user;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author raren
 */
public final class Teacher extends user implements Serializable {
    private ArrayList<String> classes ;
    private ArrayList<String> students;
    
    public Teacher(){
             username = "";
             password = "";
             firstname = "";
             middlename="";
             lastname="";
             classes = null;
             students = null;
    }
    
    public void setClassesArr(ArrayList<String> classes){
            for (String classData : classes){
                    this.classes.add(classData);
            }
    }
    
    public void setStudentsArr(ArrayList<String> students){
        this.students = new ArrayList<String>();
        
        for (String student : students){
            this.students.add(student);
        }
    }
    
    public ArrayList<String> getClasses(){
        return classes;
    }
    
    public ArrayList<String> getStudents(){
        return students;
    }
}
