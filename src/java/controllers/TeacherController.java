/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import BaseClasses.Assessment;
import data.FlashCardsDB;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import scc.Drill;
import scc.QuestionAndAnswer;
import util.Validation;


/**
 *
 * @author raren
 */
public class TeacherController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ArrayList<String> message = new ArrayList(); //errors here
        
        
        System.out.println("current teacher action is " + action);
        String url = "/teacher/index.jsp";
        
         HashMap<Integer, QuestionAndAnswer> qaHashMap = new HashMap<>(); //looking back, an array list is better here, but I'm not changing it, more work...The key is doing nothing.

        if(action != null){
            switch (action){ //hm, so a switch is secretly a HashMap() in the background, good to know, makes sense, the < (), case: > pair
            case "addNewFlashcard" : 
                //all validity checks done in .qaValid() -> no checks needed here
                String question = request.getParameter("question");
                String answer = request.getParameter("answer");
                String points = request.getParameter("points");
                String difficulty = request.getParameter("difficulty");
                
                if(Validation.qaValid(question, answer, points, difficulty, message)){
                    System.out.println("Teacher controller -> .qaValid = true");
                    message.clear();
                    
                     int difficultyInt = 0;
                     if (difficulty.contains(".")){
                         try{
                             double holder = Double.parseDouble(difficulty);
                             difficultyInt = (int) holder;
                         }catch(NumberFormatException ex){
                             System.out.print(ex);
                         }
                         
                         
                     }

                     double pointsDouble = Double.parseDouble(points); 
                    
                    QuestionAndAnswer qa = new QuestionAndAnswer(question, answer, difficultyInt, pointsDouble);
                    
                    message.add("Flashcard added!");
                    request.setAttribute("messageAdd", message);

                    
                    try{
                        FlashCardsDB.insertQuestionAnswer(qa);
                    }catch (Exception ex){
                        System.out.print("Issue inserting qa into db try-catch block checking .flashCards.insertQuestionAnswer()");
                    }
                    
                   
                    
                    
                }else{
                    System.out.println("for dev -> error -> action addNewFlashcard");
                    //show errors incase validation fails
                    request.setAttribute("messageAdd", message);
                }
                
                     // start ------- Load the flashcards into a HashMap
               try{
                  if (qaHashMap.isEmpty()){
                        FlashCardsDB.loadAllQA(qaHashMap); //loads all QuestionAndAnswer objects into the hashmap 'qa'

                         request.setAttribute("qaHashMap", qaHashMap);
                  }

               }catch(Exception ex){
                   System.out.println("/n/n Error loading  hashmap 'qa' in teacher controller -> errer:  " + ex);
               }
               // end ---------------------------------------------
               
                 url = "/teacher/addOrDeleteQA.jsp"; //bugged url
                 
                 break;
            case "loadFlashCards" :
                        // start ------- Load the flashcards into a HashMap
               try{
                  if (qaHashMap.isEmpty()){
                        FlashCardsDB.loadAllQA(qaHashMap); //loads all QuestionAndAnswer objects into the hashmap 'qa'

                         request.setAttribute("qaHashMap", qaHashMap);
                  }

               }catch(Exception ex){
                   System.out.println("/n/n Error loading  hashmap 'qa' in teacher controller -> errer:  " + ex);
               }
               // end ---------------------------------------------
               
                url = "/teacher/addOrDeleteQA.jsp";
                break;
            case "deleteQA" : 
                System.out.println("entering flashcard delete logic");
                String flashCardToDelete = request.getParameter("selectedQuestionToDelete");
                
                System.out.println("qa id selected = " + flashCardToDelete);
                
                try{
                   int flashcardID = Integer.parseInt(flashCardToDelete);
                   
                   if( FlashCardsDB.deleteQA(flashcardID)){
                       message.clear();
                       message.add("Selected flashcard deleted");
                       System.out.println("Flashcard id: " + flashCardToDelete + " was deleted.");
                   }
                }catch (Exception ex){
                    message.clear();
                    message.add("You must select a flashcard to delete it, no flashcard was deleted.");
                    System.out.println("deleteQA -> error");
                }
                request.setAttribute("messageDelete", message);
                
                url="/teacher/addOrDeleteQA.jsp";
                
                      // start ------- Load the flashcards into a HashMap
               try{
                  if (qaHashMap.isEmpty()){
                        FlashCardsDB.loadAllQA(qaHashMap); //loads all QuestionAndAnswer objects into the hashmap 'qa'

                         request.setAttribute("qaHashMap", qaHashMap);
                  }

               }catch(Exception ex){
                   System.out.println("/n/n Error loading  hashmap 'qa' in teacher controller -> errer:  " + ex);
               }
               // end ---------------------------------------------
                
                //TODO -> add delete method call here
                break;
            case "loadDrills" :
                HashMap<Integer, Assessment> drills = FlashCardsDB.selectAssessmentsByType("d");
                request.setAttribute("drills", drills);
                url = "/teacher/drills.jsp";
                break;
            case "createDrill" :
                System.out.println("Creating new drill");
                String drillSubject = request.getParameter("subject");
                String drillDifficulty = request.getParameter("difficulty");
                String rules = request.getParameter("rules");
                String drillNumQuestions =  request.getParameter("numQuestions");
                String random = request.getParameter("random");
                
                int drillDifficultyInt = 0;
                try {
                    drillDifficultyInt = parseInt(drillDifficulty);
                } catch (NumberFormatException ex){
                    System.out.print(ex);
                }
                
                int drillNumQuestionsInt = 0;
                try {
                    drillNumQuestionsInt = parseInt(drillNumQuestions);
                } catch (NumberFormatException ex){
                    System.out.print(ex);
                }
                
                boolean drillIsRandom = false;
                if (random.equals("true")) {
                    drillIsRandom = true;
                }
                
                Drill drill = new Drill();
                drill.setDifficulty(drillDifficultyInt);
                drill.setSubject(drillSubject);
                drill.setRules(rules);
                drill.setNumQuestions(drillNumQuestionsInt);
                drill.setIsRandom(drillIsRandom);
                
                drills = FlashCardsDB.selectAssessmentsByType("d");
                request.setAttribute("drills", drills);
                
                url = "/teacher/drills.jsp";
                
                break;
            }
        
        }
        
        
            getServletContext()
                   .getRequestDispatcher(url)
                   .forward(request, response);
        
              
   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
