<%-- 
    Document   : studentPortal
    Created on : Feb 17, 2026, 9:51:17 AM
    Author     : mrjel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Dashboard</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <jsp:include page="/nav.jsp" />

        <div class="hero hero_dashboard">
            <div class="wrapper">
                <div class="hero_content">
                    <div class="hero_img student"></div>
                    <h1>Student Dashboard</h1>
                </div>
            </div>
        </div>
        <div class="wrapper">
            <main>
                <aside>
                    <nav class="sidenav">
                        <ul>
                            <li class="current" ><a href="${pageContext.request.contextPath}/student/index.jsp">Overview</a></li>
                            <li ><a href="${pageContext.request.contextPath}/Student?action=loadDrills">Drills</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <h2>Class Overview</h2>
                    <p>This dashboard provides a real-time summary of your academic performance.
                        Review progress, identify weak skill areas, and monitor readiness for progressive or placement
                        testing.</p>

                    <div>
                        <h2>My Assignments</h2>
                        <p>Here you can review assignment results along with your scores and time spent on each assessment.</p>
                        <div>
                            <button class="btn-primary"><a href="${pageContext.request.contextPath}/Student?action=viewAssignmentResults" > View Assignments</a></button>
                        </div>
                    </div>
                </section>
            </main>
        </div>
        <jsp:include page="/login.jsp" />
        <script src="../scripts/script.js"></script>
    </body>
</html>
