<%-- 
    Document   : createDrill
    Created on : Feb 24, 2026, 6:16:37 PM
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
                            <li ><a href="${pageContext.request.contextPath}/Teacher?action=viewMyClasses">Class Overview</a></li>
                            <li class="current"><a href="${pageContext.request.contextPath}/Teacher?action=loadDrills">Drills</a></li>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=loadFlashCards">Questions Manager</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <form action="<c:url value="/Teacher"/>" method="post" class="drill_create_container">
                        <h2>Create a drill</h2>
                        <input type="hidden" name="action" value="createDrill">
                        <input type="text" placeholder="Subject" name="subject">

                        <select name="difficulty">
                            <option>--Please choose difficulty--</option>
                            <option value="0">Easy</option>
                            <option value="1">Medium</option>
                            <option value="2">Hard</option>
                        </select>

                        <label>Rules</label>
                        <textarea type="text" name="rules"></textarea>   
                        <input type="number" name="attemptsAllowed" placeholder="Attempts Allowed">

                        <select name="random">
                            <option>--Is it Random or Specific?--</option>
                            <option value="R">Random</option>
                            <option value="S">Specific</option>
                        </select>

                        <input class="btn-primary" type="submit" value="Create">
                    </form>
                </section>
            </main>
        </div>
    </body>
</html>