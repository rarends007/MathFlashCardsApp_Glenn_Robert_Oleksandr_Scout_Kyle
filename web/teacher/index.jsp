<%-- 
    Document   : studentPortal
    Created on : Feb 17, 2026, 9:51:17 AM
    Author     : mrjel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h1>Teacher Dashboard</h1>
                </div>
            </div>
        </div>
        <div class="wrapper">
            <main>
                <aside>
                    <nav class="sidenav">
                        <ul>
                            <li class="current"><a href="${pageContext.request.contextPath}/Teacher?action=viewMyClasses">Class Overview</a></li>
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/Teacher?action=loadDrills">Drills</a></li>
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/Teacher?action=loadFlashCards">Questions Manager</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <h2>Class Overview</h2>
                    <p>This dashboard provides a real-time summary of your students’ academic performance.
                        Review progress, identify weak skill areas, and monitor readiness for progressive or placement
                        testing.</p>

                    <div>
                        <h2>My Classes</h2>
                        <c:forEach var="classId" items="${classIds}">
                            <div>
                                ${classId}
                                <a href="${pageContext.request.contextPath}/Teacher?action=viewAssignmentsByClass&classId=${classId}" class="fake_link"> View Assignments</a>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </main>
    </div>
    <script src="../scripts/script.js"></script>
</body>
</html>
