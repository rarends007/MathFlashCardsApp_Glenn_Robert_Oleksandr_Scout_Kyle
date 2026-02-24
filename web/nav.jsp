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
                    <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li> <!-- likely will want to separate this into a separate .jsp file and use jstl to add it to the top of all pages - RA -->
                    <li><a href="${pageContext.request.contextPath}/Teacher?action=viewMyClasses">For Teachers</a></li>
                    <li><a href="${pageContext.request.contextPath}/student/index.jsp">For Students</a></li>
                    <li><a href="${pageContext.request.contextPath}/parent/index.jsp">For Parents</a></li>
                    <li><a href="${pageContext.request.contextPath}/Public?action=logout">Logout</a></li>
                </ul>
                <div class="sing_in_container">
                    <c:choose>
                        <c:when test="${not empty sessionScope['admin']}">
                            <p>${sessionScope['admin'].getFirstName()} ${sessionScope['admin'].getLastName()}</p>
                        </c:when>
                        <c:when test="${not empty sessionScope.teacher}">
                            <p>${sessionScope.teacher.getFirstName()} ${sessionScope.teacher.getLastName()}</p>
                        </c:when>
                        <c:when test="${not empty sessionScope['parent']}">
                            <p>${sessionScope['parent'].getFirstName()} ${sessionScope['parent'].getLastName()}</p>
                        </c:when>
                            <c:when test="${not empty sessionScope['student']}">
                            <p>${sessionScope['student'].getFirstName()} ${sessionScope['student'].getLastName()}</p>                
                        </c:when>
                        <c:otherwise>
                            <a href="">
                                <span>Sign</span> In
                            </a>
                            <div class="avatar">?</div>                            
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>
    </header>