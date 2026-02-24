/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author mrjel
 */
public class StudentAssignment implements Serializable{
    public String username;
    public int assignmentId;
    public double grade;
    public int timeTaken;
    public LocalDateTime date;
    public int difficulty;
    
    public StudentAssignment(){              
    }

    public StudentAssignment(String username, int assignmentId, double grade, int timeTaken, LocalDateTime date, int difficulty) {
        this.username = username;
        this.assignmentId = assignmentId;
        this.grade = grade;
        this.timeTaken = timeTaken;
        this.date = date;
        this.difficulty = difficulty;
    }

    public StudentAssignment(String username, int assignmentId, double grade, int timeTaken, LocalDateTime date) {
        this.username = username;
        this.assignmentId = assignmentId;
        this.grade = grade;
        this.timeTaken = timeTaken;
        this.date = date;
    }    
    

    public StudentAssignment(String username, int assignmentId) {
        this.username = username;
        this.assignmentId = assignmentId;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    
    
}
