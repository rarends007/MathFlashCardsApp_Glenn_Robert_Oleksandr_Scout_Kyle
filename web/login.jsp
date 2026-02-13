<%-- 
    Document   : login
    Created on : Feb 13, 2026, 12:10:33 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
          <div>
            <h3>${message}</h3>
        </div>
        <div>
            <h1>Hello and welcome to the SCC Math_app.</h1><br>
            <h2>Please enter your username and password below to login.</h2>
        </div>
        <form action="Public" method="post">
            
            <input type="hidden" name="action" value="login"/>
            <label>username</label>
            <input text name="username" id="username"/>
            <br>
            <label>password</label>
            <input type="text" name="password" id="password"/>
            
            <input type="submit" value="Login"/>

            
        </form>
        
    </body>
</html>
