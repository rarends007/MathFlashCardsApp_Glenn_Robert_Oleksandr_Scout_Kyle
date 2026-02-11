<%-- 
    Document   : registration
    Created on : Feb 11, 2026, 12:04:53 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register User</h1>
        <p>Please fill out the form below to register a new user.</p>
        
        <p><i>${message}</i></p> <!--  this will be implemented later, error message that helps with user validation -->
        
        <form action="Public" method="post">
            <input type="hidden" name="action" value="register"/><!-- the action passed to the servlet -->
            
            <label>username</label>
            <input type="text" name="username" required/>
            
            <label>firstname</label>
            <input type="text" name="firstname" required/>
            
            <label>middlename</label>
            <input type="text" name="middlename" required/>
            
            <label>lastname</label>
            <input type="text" name="lastname" required/>
            
            <label>password</label>
            <input type="text" name="password" required/>
            
            <label>confirm password</label>
            <input type="text" name="confpassword" required/>
            
            <select name="role">
                <option value="ADM">Admin</option>
                <option value="PAR">Parent</option>
                <option value="STU">Student</option>
                <option value="TCH">Teacher</option>
            </select>
            
            <input type="submit" value="register"/>
            
        </form>
    </body>
</html>
