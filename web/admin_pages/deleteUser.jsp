<%-- 
    Document   : deleteUser
    Created on : Feb 13, 2026, 7:09:14 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Account</title>
    </head>
    <body>

        <h1>User Deletion Page</h1>
        <h2>Warning, all of the users entries for their username will be set to "deleted", all other data will be retained, consult a database admin to run a full delete of all data.</h2>
        
        <div>
            <h3>${message}</h3>
        </div>
        <form action="<c:url value="/Admin"/>" method="post">
            <input type="hidden" name="action" value="delete"/><!-- the action passed to the servlet -->
            
            <label>username</label>
            <input type="text" name="username" required/>

            <input type="submit" value="delete"/>
            
        </form>
    </body>
</html>
