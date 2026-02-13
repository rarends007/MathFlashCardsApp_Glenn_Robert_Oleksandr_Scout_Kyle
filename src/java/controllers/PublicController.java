/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import BaseClasses.User;
import scc.Admin;
import scc.Parent;
import scc.Student;
import scc.Teacher;

/**
 *
 * @author raren
 */
public class PublicController extends HttpServlet {

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
        
            HttpSession session = request.getSession();
            ArrayList<String> message = new ArrayList();

            String action = request.getParameter("action");
            String url = "/login.jsp";
           
            if(action.equals("login")){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                try{
                    User user = UserDB.loginUser(username, password, message);
                    
                    if(user != null){
                        String role = user.getRole();
                        switch (role){
                            case "ADM":
                                Admin admin = new Admin();
                                
                                admin.setFirstname(user.getFirstName());
                                admin.setMiddlename(user.getMiddleName());
                                admin.setLastname(user.getLastName());
                                admin.setUsername(user.getUsername());
                                admin.setRole(role);
                                
                                session.setAttribute("admin", admin);
                                System.out.println("A admin has logged in -> username: " + admin.getUsername());
                                url="/UserPortals/adminPortal.jsp";
                                break;
                            case "TCH":
                                Teacher teacher = new Teacher();
               
                                teacher.setFirstname(user.getFirstName());
                                teacher.setMiddlename(user.getMiddleName());
                                teacher.setLastname(user.getLastName());
                                teacher.setUsername(user.getUsername());
                                teacher.setRole(role);
                                
                                session.setAttribute("teacher", teacher);
                                System.out.println("A teacher has logged in -> username: " + teacher.getUsername());
                                url="/UserPortals/teacherPortal.jsp";
                                break;
                            case "PAR":
                                Parent parent = new Parent();
    
                                parent.setFirstname(user.getFirstName());
                                parent.setMiddlename(user.getMiddleName());
                                parent.setLastname(user.getLastName());
                                parent.setUsername(user.getUsername());
                                parent.setRole(role);
                                
                                session.setAttribute("parent", parent);
                                System.out.println("A parent has logged in -> username: " + parent.getUsername());
                                url="/UserPortals/parentPortal.jsp";
                                break;
                            case "STU":
                                Student student = new Student();

                                student.setFirstname(user.getFirstName());
                                student.setMiddlename(user.getMiddleName());
                                student.setLastname(user.getLastName());
                                student.setUsername(user.getUsername());
                                student.setRole(role);
                                
                                session.setAttribute("student", student);
                                System.out.println("A student has logged in -> username: " + student.getUsername());
                                url="/UserPortals/studentPortal.jsp";
                                break;
                             
                        }
                    }else{
                        message.add("Incorrect username or password.");
                        System.out.println("username or password not exist");
                    }
                    
                    
                    
                }catch(NoSuchAlgorithmException ex){
                    System.out.println("No such algorithm exception ->  with login.");
                    message.clear();
                    message.add("Error with hashing algorithm. No such algorithm.");
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

