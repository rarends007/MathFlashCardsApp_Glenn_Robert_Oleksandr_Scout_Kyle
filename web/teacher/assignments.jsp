<%-- 
    Document   : assignments
    Created on : Feb 22, 2026, 9:22:42 PM
    Author     : mrjel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <li class="current" ><a href="${pageContext.request.contextPath}/Teacher?action=viewMyClasses">Class Overview</a></li>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=loadDrills">Drills</a></li>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=loadFlashCards">Questions Manager</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <h2>My Classes</h2>
                    <c:forEach items="${assessments}" var="entry">
                        <div>                                
                            Assignment #${entry.key}
                            <a class="fake_link" href="${pageContext.request.contextPath}/Teacher?action=viewAssignmentResults&classId=${classId}&assessmentId=${entry.key}">View Details</a>                            

                        </div>
                    </c:forEach>
                </section>
            </main>
        </div>
        <script src="${pageContext.request.contextPath}/scripts/script.js"></script>
    </body>
</html>
