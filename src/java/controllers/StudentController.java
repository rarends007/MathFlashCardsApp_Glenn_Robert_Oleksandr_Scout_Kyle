/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import BaseClasses.Assessment;
import data.FlashCardsDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import scc.Student;
import scc.StudentAssignment;

/**
 *
 * @author mrjel
 */
@WebServlet(name = "Student", urlPatterns = {"/Student"})
public class StudentController extends HttpServlet {

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

        System.out.println("current student action is " + action);
        String url = "/student/index.jsp";

        HttpSession session = null;
        Student student = null;

        try {
            session = request.getSession();
            student = (scc.Student) session.getAttribute("student");
        } catch (NullPointerException ex) {
            System.out.println("Non logged in user attempting to access teacher functions." + " " + ex);
        }
        if (student != null) {
            if (student.getRole().equals("STU")) {
                if (action != null) {
                    switch (action) {

                        case "loadDrills":
                            HashMap<Integer, Assessment> drills = FlashCardsDB.selectAssessmentsByType("d");
                            request.setAttribute("drills", drills);
                            url = "/student/drills.jsp";
                            break;                        

                        case "viewAssignmentResults":                            
                            String studentId = student.getUsername();                            

                            HashMap<Integer, StudentAssignment> results = FlashCardsDB.selectStudentAssessments(studentId);

                            request.setAttribute("results", results);

                            url = "/student/assignments.jsp";
                            break;

                    }
                } else {
                    url = "/restrictedResource.jsp";
                }
            } else {
                url = "/restrictedResource.jsp";
            }

            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
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
