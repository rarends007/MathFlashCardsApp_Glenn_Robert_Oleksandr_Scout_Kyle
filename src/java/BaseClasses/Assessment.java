/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseClasses;

import java.time.LocalDateTime;
import java.time.*;
import scc.Quiz;

/**
 *
 * @author raren
 */
public class Assessment {
       private int assessmentID;
       private String subject;
       private int difficulty;
       private double score;
       private String rules;
       private int numQuesitons;
       private boolean isRandom;
       private int attemptsAllowed;
       private LocalDateTime datetime;
       
       public Assessment(){
           assessmentID = -1;
           subject = null;
           difficulty = -1;
           score = 0;
           rules = null;
           numQuesitons = 0;
           isRandom = false;
           attemptsAllowed = 0;
           datetime = null;
                   
       }
       
       
       public void setID(int assessmentID){
           this.assessmentID = assessmentID;
       }
       
       public void setSubject(String subject){
           this.subject = subject;
       }
       
       public void setDifficulty(int difficulty){
           this.difficulty = difficulty;
       }
       
       public void setScore(double score){
           this.score = score;
       }
       
       public void setRules(String rules){
           this.rules = rules;
       }
       
       public void setNumQuestions(int numQuestions){
           this.numQuesitons = numQuestions;
       }
       
       public void setIsRandom(boolean isRandom){
           this.isRandom = isRandom;
       }
       
       public void setAttemptsAllowed(int attemptsAllowed){
           this.attemptsAllowed = attemptsAllowed;
       }
       
       public int getAssessmentID(){
           return assessmentID;
       }
       
       public String getSubject(){
           return subject;
       }
       
       public int getDifficulty(){
           return difficulty;
       }
       
       public double getScore(){
           return score;
       }
       
       public String getRules(){
           return rules;
       }
       
       public int getNumQuestions(){
           return numQuesitons;
       }
       
       public boolean getIsRandom(){
           return isRandom;
       }
       
       public int getAttemptsAllowed(){
           return attemptsAllowed;
       }
       
       public void submitQuiz(Quiz quiz){
           //TODO -> add logic to submit a quiz
       }
       
       public double calculateScore(){
           //TOD -> add logic to calculate the assessment score and return a proper value
           return -1.0;
       }
       
       public LocalDateTime calculateAssessmentTimeTaken(){
           LocalDateTime currentTime =  LocalDateTime.now();
           //TODO -> add logic that calculates the local date time until it equals either the allowed assessment time, or until a student clicks submit to submit the assessment
           return currentTime;
       }
}
