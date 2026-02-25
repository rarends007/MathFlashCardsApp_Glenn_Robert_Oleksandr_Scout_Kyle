<%-- 
    Document   : drills
    Created on : Feb 17, 2026, 2:22:19 PM
    Author     : mrjel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drills</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    </head>
    <body>
        <jsp:include page="/nav.jsp" />

        <div class=" hero hero_dashboard">
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
                            <li ><a href="${pageContext.request.contextPath}/student/index.jsp">Overview</a></li>
                            <li class="current"><a href="${pageContext.request.contextPath}/Student?action=loadDrills">Drills</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <h2>Drills</h2>
                    <p>Drills are short practice sessions designed to reinforce specific math skills through repetition and adaptive question generation.</p>

                    <div>
                        <h2>Drills List</h2>
                        <br>
                        <ul class="drill_list">
                            <c:forEach var="d" items="${drills}">
                                <li class="drill_container" id='${d.key}_drill'>
                                    <h4>${d.value.rules}</h4>
                                    <div class="drill_body">
                                        <p>Type: <c:choose>
                                                <c:when test="${d.value.isRandom == 'R'}">
                                                    <span>Random</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span>Specific<span>
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                    <p>Difficulty:  <c:choose>
                                                            <c:when test="${d.value.difficulty == 1 || d.value.difficulty == 0}">
                                                                <span>Easy</span>
                                                            </c:when>
                                                            <c:when test="${d.value.difficulty == 2 }">
                                                                <span>Medium</span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span>Hard<span>
                                                                    </c:otherwise>
                                                                </c:choose></p>                            
                                                                </div>
                                                                <div class="drill_footer">
                                                                    <button class="btn-secondary">Take Drill</button>
                                                                </div>
                                                                </li>
                                                            </c:forEach>
                                                            </ul>
                                                            </div>
                                                            </section>
                                                            </main>
                                                            </div>
                                                            <script src="${pageContext.request.contextPath}/scripts/script.js"></script>
                                                            </body>
                                                            </html>
