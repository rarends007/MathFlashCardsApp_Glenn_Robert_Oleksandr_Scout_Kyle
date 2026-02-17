<%-- 
    Document   : login
    Created on : Feb 13, 2026, 12:10:33 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head> <!-- TODO: I need to debug why entering a nonexistent user leads to a blank page and correct it. -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="./styles/style.css">
    </head>
    <body>
        <div>
            <h3>${message}</h3>
        </div>
        <form action="Public" class="log_in_form modular_menu" id="login_form" method="post">
            <h3>Welcome back! Glad to see you, Again!</h2>
                <input type="hidden" name="action" value="login"/>
                <div>
                    <input type="text" placeholder="Enter your username" name="username" id="username">
                    <input type="password" placeholder="Enter your password" name="password" id="password">
                </div>
                <input type="submit" value="Login" class="btn-primary">
                <input type="button" id="login-btn-cancel" value="Cancel" class="btn-secondary">
                </form>
                </body>
                </html>
