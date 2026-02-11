/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AdminDB;
import java.util.ArrayList;
import scc.Admin;


/**
 *
 * @author raren
 */
public class Public extends HttpServlet {

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
        
        String url = "/index.html";
        
        HttpSession session = request.getSession();
        
        ArrayList<String> message = new ArrayList<String>();
       
        //get the user actions
        String action = request.getParameter("action");
        
        switch(action){
            case "register": 
                //get the data from the jsp
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String firstname = request.getParameter("firstname");
                String middlename = request.getParameter("middlename");
                String lastname = request.getParameter("lastname");
                String confpassword = request.getParameter("confpassword");
                String role = request.getParameter("role");
                
                switch(role){
                    case "ADM":
                        Admin admin  = new Admin();
                        
                       admin.setUsername(username);
                       admin.setPassword(password);
                       admin.setFirstname(firstname);
                       admin.setMiddlename(middlename);
                       admin.setLastname(lastname);
                       admin.setRole(role);
                       
                       if (AdminDB.usernameExists(admin.getUsername())) {
                           message.add("This username already exists. Choose a different one.") ;
                       }else{
                           message.clear();
                           url = "/thanks.jsp";
                           AdminDB.insertAdmin(admin);
                       }
                       request.setAttribute("user", admin);
                       request.setAttribute("message", message);
                       
                       
                }
                
                
                break;
            case "PAR":
                break;
            case "TCH":
                break;
            case "STU": 
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
