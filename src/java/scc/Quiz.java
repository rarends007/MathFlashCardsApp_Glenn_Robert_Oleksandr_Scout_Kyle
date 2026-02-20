/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import BaseClasses.Assessment;
import java.io.Serializable;

/**
 *
 * @author raren
 */
public class Quiz extends Assessment implements Serializable{
    private double gradedPoints;
    
    public Quiz(){
        super();
        gradedPoints = -1;
        
    }
    
    public void setGradedPoints(double gradedPoints){
        this.gradedPoints = gradedPoints;
    }
    
    public double getGradedPoints(){
        return gradedPoints;
    }
}
