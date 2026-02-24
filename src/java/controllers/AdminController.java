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

import data.UserDB;
import java.util.ArrayList;
import scc.Admin;
import scc.Parent;
import scc.Student;
import scc.Teacher;
import util.Validation;


/**
 *
 * @author raren
 */
public class AdminController extends HttpServlet {

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
        
        Admin loggedInAdmin = (Admin) session.getAttribute("admin");
        
        System.out.println("admin props -> admin controller -> admin session obj -> " + loggedInAdmin.getRole() + " " + loggedInAdmin.getUsername());
        ArrayList<String> message = new ArrayList<>();
       
       
        
        //get the user actions
        String action = request.getParameter("action");
        
        if(loggedInAdmin.getRole().equals("ADM")){
            
    
            switch(action){ //All of these insert into the user table, users differentiated by role
                case "register": 
                    //get the data from the jsp
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String firstname = request.getParameter("firstname");
                    String middlename = request.getParameter("middlename");
                    String lastname = request.getParameter("lastname");
                    String confpassword = request.getParameter("confpassword");
                    String role = request.getParameter("role");

                    if(Validation.userValidated(username, password, confpassword, firstname, middlename, lastname, message)){
                        switch(role){
                            case "ADM":

                        Admin admin  = new Admin();

                        admin.setUsername(username);
                        admin.setPassword(password);
                        admin.setFirstname(firstname);
                        admin.setMiddlename(middlename);
                        admin.setLastname(lastname);
                        admin.setRole(role);

                        message.clear();
                        message.add("Dear administrator, thank you for registering a new administrator, username: " + admin.getUsername() );
                        UserDB.insertUser(admin);

                        request.setAttribute("user", admin);
                        request.setAttribute("message", message);


                        break;
                    case "PAR":

                        Parent parent  = new Parent();

                        parent.setUsername(username);
                        parent.setPassword(password);
                        parent.setFirstname(firstname);
                        parent.setMiddlename(middlename);
                        parent.setLastname(lastname);
                        parent.setRole(role);

                        message.clear();
                        message.add("Dear administrator, thank you for registering a new parent, username: " + parent.getUsername() );
                        UserDB.insertUser(parent);

                        request.setAttribute("user", parent);
                        request.setAttribute("message", message);

                        break;
                    case "TCH":

                        Teacher teacher  = new Teacher();

                        teacher.setUsername(username);
                        teacher.setPassword(password);
                        teacher.setFirstname(firstname);
                        teacher.setMiddlename(middlename);
                        teacher.setLastname(lastname);
                        teacher.setRole(role);

                        message.clear();
                        message.add("Dear administrator, thank you for registering a new teacher, username: " + teacher.getUsername() );
                        UserDB.insertUser(teacher);

                        request.setAttribute("user", teacher);
                        request.setAttribute("message", message);

                        break;
                    case "STU": 

                        Student student  = new Student();

                        student.setUsername(username);
                        student.setPassword(password);
                        student.setFirstname(firstname);
                        student.setMiddlename(middlename);
                        student.setLastname(lastname);
                        student.setRole(role);

                        message.clear();
                        message.add("Dear administrator, thank you for registering a new student, username: " + student.getUsername() );
                        UserDB.insertUser(student);

                        request.setAttribute("user", student);
                        request.setAttribute("message", message);

                        break;
                    }//inner switch 1

                }// User Validation block end -> Validation.userValidated
           url = "/admin_pages/registration.jsp";
           request.setAttribute("message", message);
           break;
           case "delete":  
               url = "/admin_pages/deleteUser.jsp";
               String usernameToDelete = request.getParameter("username");
               if(UserDB.usernameExists(usernameToDelete)){
                   try{
                            UserDB.deleteUser(usernameToDelete);
                            message.clear();
                            message.add("Username " + usernameToDelete + " deleted.");
                    }catch (Exception ex){
                            message.clear();
                            message.add("Unable to remove user data.");
                     }
               }else{
                   message.clear();
                   message.add("Username does not exist.");
               }

               if(message.size() > 0){
                   request.setAttribute("message", message);
               }
               break;
               
           case "home": //not in use
               url = "/restrictedResource.jsp";
               break;
               

            }//outer switch
        
        }else{
            url = "/index.jsp";
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
