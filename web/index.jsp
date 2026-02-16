
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Home page --> 
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Education Portal</title>
    <link rel="stylesheet" href="./styles/style.css">
</head>

<body>
    <header>
        <nav>
            <div class="wrapper">
                <ul>
                    <li><a href="index.jsp">Home</a></li> <!-- likely will want to separate this into a separate .jsp file and use jstl to add it to the top of all pages - RA -->
                    <li><a href="http://localhost:8080/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/UserPortals/teacherPortal.jsp">For Teachers</a></li>
                    <li><a href="http://localhost:8080/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/UserPortals/studentPortal.jsp">For Students</a></li>
                    <li><a href="http://localhost:8080/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/UserPortals/parentPortal.jsp">For Parents</a></li>
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
    <div class="hero">
        <div class="wrapper">
            <div class="hero_content">
                <h1>Empowering Math Learning</h1>
                <p>Our adaptive learning platform helps students master math skills through interactive drills,
                    progressive tests, and real-time feedback. Teachers gain powerful insights, and parents stay
                    connected every step of the way.</p>
                <button class="btn-primary" id="get_started">Start Learning</button>
            </div>
            <div class="hero_img"></div>
        </div>
    </div>
    <section>
        <div class="wrapper">
            <h2 class="text_centered">Designed for Students, Teachers, and Parents</h2>
            <p class="text_centered">Our platform creates a connected learning experience. Students improve through
                adaptive drills and earn rewards. Teachers track progress with detailed analytics. Parents stay informed
                and involved in their child’s success.</p>
        </div>
    </section>
<c:import url="login.jsp" />
<script src="scripts/script.js"></script>
</body>
