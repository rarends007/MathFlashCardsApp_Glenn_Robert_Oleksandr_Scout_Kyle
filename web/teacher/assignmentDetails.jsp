<%-- 
    Document   : assignentDetails
    Created on : Feb 22, 2026, 9:27:15 PM
    Author     : mrjel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    </head>
    <body>
        <jsp:include page="/nav.jsp" />

        <div class="hero hero_dashboard">
            <div class="wrapper">
                <div class="hero_content">
                    <div class="hero_img teacher"></div>
                    <h1>Assignments</h1>
                </div>
            </div>
        </div>
        <div class="wrapper">
            <main>
                <aside>
                    <nav class="sidenav">
                        <ul>
                            <li class="current"><a href="${pageContext.request.contextPath}/Teacher?action=viewMyClasses">Class Overview</a></li>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=loadDrills">Drills</a></li>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=loadFlashCards">Questions Manager</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <h2>Results for Assessments #${assessmentId}</h2>
                    <table>
                        <tr>
                            <th>Student</th>
                            <th>Grade</th>
                            <th>Time Taken</th>
                            <th>Date</th>
                        </tr>                         
                        <c:forEach items="${results}" var="entry">
                            <tr>
                                <td>${entry.key}</td>
                                <td>${entry.value.grade}</td>
                                <td>
                                    <fmt:formatNumber value="${entry.value.timeTaken / 60}" pattern="00"/>:<fmt:formatNumber value="${entry.value.timeTaken % 60}" pattern="00"/>
                                </td>                                
                                <td>${entry.value.date}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
            </main>
        </div>
        <script src="../scripts/script.js"></script>
    </body>
</html>
