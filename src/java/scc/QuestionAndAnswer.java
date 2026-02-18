/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

/**
 *
 * @author raren
 */
public class QuestionAndAnswer {

    public int id;
    public String question;
    public String answer;
    public int difficulty;
     public double points;
    
        public QuestionAndAnswer() {
            id = 0;
            question = null;
            answer = null;
            difficulty = 0;
            points = 0.0;
        }

       public QuestionAndAnswer(int id, String question, String answer, int difficulty, double points) {
            this.id = id;
            this.question = question;
            this.answer = answer;
            this.difficulty = difficulty;
            this.points = points;
        }
          
          
        public void setid(int id){
            this.id = id;
        }
        
        public void setQuestion(String question){
            this.question = question;
        }
        
        public void setAnswer(String answer){
            this.answer = answer;
        }
        
        public void setDifficulty(int difficulty){
            this.difficulty = difficulty;
        }
        
        
        public void setPoints(double points){
            this.points = points;
        }
        
        public int getId(){
            return id;
        }
        
        public String getQuestion(){
            return question;
        }
        
        public String getAnswer(){
            return answer;
        }
        
        public int getDifficulty(){
            return difficulty;
        }
        
        public double getPoints(){
            return points;
        }
        
        
     
    
    
}
