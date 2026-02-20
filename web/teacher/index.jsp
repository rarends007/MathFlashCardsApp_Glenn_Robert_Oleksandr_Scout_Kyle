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
        <title>JSP Page</title>
        <link rel="stylesheet" href="../styles/style.css">
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
                            <li class="current"><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/index.jsp">Class Overview</a></li>
                            <li><a href="">Tests</a></li>
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/drills.jsp">Drills</a></li>
                            <li><a href="">Statistics</a></li>
                            <li><a href="">Students</a></li>
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
                        <h2>Class Summary</h2>
                        <p>📅 Current Term: Spring 2025</p>
                        <p>🏫 Grade Level: 5th Grade Math</p>
                        <p>Class Average: 82%</p>
                    </div>
                </section>
            </main>
        </div>
        <jsp:include page="/login.jsp" />
        <script src="../scripts/script.js"></script>
    </body>
</html>
