<%-- 
    Document   : restrictedResource
    Created on : Feb 24, 2026, 4:10:16 PM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="restricted_page" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restricted Resource</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    </head>
    <body>
        <h1>Sorry, you must login in order to use this functionality.</h1>
        <button class="btn-primary"> <a href="${pageContext.request.contextPath}"> Go Back </a></button>
    </body>
</html>
