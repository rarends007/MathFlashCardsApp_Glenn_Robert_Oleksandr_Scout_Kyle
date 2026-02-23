/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseClasses;

import java.time.LocalDateTime;
import scc.Quiz;

/**
 *
 * @author raren
 */
public class Assessment {
       private int assessmentID;
       private String subject;
       private int difficulty;
       private String assessmentType; // in db must be d, q, i, p -> d = drill, p = progressionAssessmentTest, i = iniitialAssessmentTest, q = quiz
       private double score;
       private String rules;
       private int numQuesitons;
       private boolean isRandom;
       private int attemptsAllowed;
       private LocalDateTime datetime;
       private int allowed_time;

    public int getNumQuesitons() {
        return numQuesitons;
    }

    public void setNumQuesitons(int numQuesitons) {
        this.numQuesitons = numQuesitons;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public int getAllowed_time() {
        return allowed_time;
    }

    public void setAllowed_time(int allowed_time) {
        this.allowed_time = allowed_time;
    }
       
       public Assessment(){
           assessmentID = -1;
           subject = null;
           difficulty = -1;
           assessmentType = null;
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
       
       public void setAssessmentType(String assessmentType){
           this.assessmentType = assessmentType;
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
       
       public String getAssessmentType(){
           return assessmentType;
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
