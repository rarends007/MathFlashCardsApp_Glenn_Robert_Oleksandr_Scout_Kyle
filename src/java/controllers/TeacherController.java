/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import data.FlashCardsDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String url = "/teacher/index.jsp";
        
        switch (action){
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
                    
                    try{
                        FlashCardsDB.insertQuestionAnswer(qa);
                    }catch (Exception ex){
                        System.out.print("Issue inserting qa into db try-catch block checking .flashCards.insertQuestionAnswer()");
                    }
                    
                   
                    
                    
                }else{
                    System.out.println("error -> action addNewFlashcard");
                    //show errors incase validation fails
                    request.setAttribute("messageAdd", message);
                }
                 url = "/teacher/addOrDeleteQA.jsp"; //bugged url
                break;
                
            case "loadFlashcards" :
                
                break;
            case "deleteFlashcard" : 
                break;
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
