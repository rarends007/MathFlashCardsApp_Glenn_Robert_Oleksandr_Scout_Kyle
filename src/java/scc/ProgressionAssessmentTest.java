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
public class ProgressionAssessmentTest extends Assessment implements Serializable {
    private int assignedLevel;

    public ProgressionAssessmentTest() {
        super();
        assignedLevel = -1;
    }
    
    public void setAssignedLevel(int assignedLevel){
        this.assignedLevel = assignedLevel;
    }
    
    public int getAssignedLevel(){
        return assignedLevel;
    }
    
    public void calculateLevel(){
        //TODO -> figire this out, this function however likely isn't needed
    }
    
}
