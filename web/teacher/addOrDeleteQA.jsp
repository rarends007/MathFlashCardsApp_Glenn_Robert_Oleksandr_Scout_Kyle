<%-- 
    Document   : addOrDeleteQA
    Created on : Feb 19, 2026, 12:00:00 AM
    Author     : raren -> CSS applied by Oleksandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add or Delete Flashcard</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    </head>
    <body>
        <jsp:include page="../nav.jsp" />

        <div class=" hero hero_dashboard">
            <div class="wrapper">
                <div class="hero_content">
                    <div class="hero_img teacher"></div>
                    <h1>Add or Remove Flashcards</h1>
                </div>
            </div>
        </div>

        <div class="wrapper">
            <main>
                <aside>
                    <nav class="sidenav">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=viewMyClasses">Class Overview</a></li>
                            <li><a href="${pageContext.request.contextPath}/Teacher?action=loadDrills">Drills</a></li>
                            <li class="current"><a href="${pageContext.request.contextPath}/Teacher?action=loadFlashCards">Add or Delete Flashcards</a></li>
                        </ul>
                    </nav>
                </aside>

                <section>
                    <h1>Add Flashcard</h1>
                    ${messageAdd}
                    <form action="<c:url value="/Teacher"/>" method="post" class="add_flashcard_form">
                        <input type="hidden" name="action" value="addNewFlashcard"/><br>

                        <label>Question</label>
                        <input type="text" name="question"/><br>

                        <label>Answer</label>
                        <input type="text" name="answer"/><br>

                        <label>Points</label>
                        <input type="text" name="points"/><br>

                        <label>Difficulty</label>
                        <input type="text" name="difficulty"/><br>

                        <input type="submit" class="btn-primary" value="Add Flashcard"/>
                    </form>

                    <h1>Delete Flashcard</h1>
                    ${messageDelete}
                    <form action="<c:url value="/Teacher"/>" method="post"/>

                    <select name="selectedQuestionToDelete" size="20" multiple="multiple" style="overflow-y: auto;"> <!--<!-- overflow-y chosen because we want a verticle (y-axis) overflow, multiple means they can select more than 1 -> returns a String[] -->
                        <c:forEach var="item" items="${qaHashMap.values()}">
                            <option value="${item.getID()}">Question:  ${item.getQuestion()} &nbsp; Difficulty: ${item.getDifficulty()} &nbsp; Points: ${item.getPoints()}</option>
                        </c:forEach>
                    </select>

                    <br>
                    <input type="hidden" name="action" value="deleteQA">
                    <input type="submit" class="btn-primary" value="Delete Flashcard">

                    </form>
                </section>
            </main>
        </div>
    </body>
</html>
