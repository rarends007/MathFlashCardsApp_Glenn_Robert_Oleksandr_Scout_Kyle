<%-- 
    Document   : nav
    Created on : Feb 17, 2026, 9:14:43 AM
    Author     : mrjel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
    <header>
        <nav>
            <div class="wrapper">
                <ul>
                    <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/index.jsp">Home</a></li> <!-- likely will want to separate this into a separate .jsp file and use jstl to add it to the top of all pages - RA -->
                    <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/index.jsp">For Teachers</a></li>
                    <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/student/index.jsp">For Students</a></li>
                    <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/parent/index.jsp">For Parents</a></li>
                </ul>
                <div class="sing_in_container">
                    <a href="">
                        <span>Sign</span> In
                    </a>
                    <div class="avatar">?</div>
                </div>
            </div>
        </nav>
    </header>