<%-- 
    Document   : addOrDeleteQA
    Created on : Feb 19, 2026, 12:00:00 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add or Delete Flashcard</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <jsp:include page="/nav.jsp" />

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
                        <li ><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/index.jsp">Class Overview</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/tests.jsp">Tests</a></li>
                        <li class="current"><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/drills.jsp">Drills</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/statistics.jsp">Statistics</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/students.jsp">Students</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/addOrDeleteQA.jsp">Add or Delete Flashcards</a></li>
                    </ul>
                    </nav>
                </aside>
              
                <section>
                         <h1>Add Flashcard</h1>
                         ${messageAdd}
                         <form action="<c:url value="/Teacher"/>" method="post">
                             <input type="hidden" name="action" value="addNewFlashcard"/><br>
                             
                             <label>Question</label>
                             <input type="text" name="question"/><br>
                             
                             <label>Answer</label>
                             <input type="text" name="answer"/><br>
                             
                             <label>Points</label>
                             <input type="text" name="points"/><br>
                             
                             <label>Difficulty</label>
                             <input type="text" name="difficulty"/><br>
                             
                             <input type="submit" value="Add Flashcard"/>
                         </form>
                         
                         <h1>Delete Flashcard</h1>
                         ${messageDel}
                         <form action="../Teacher" method="post"/>
                         
                            <input type="hidden" name="action" value="deleteFlashcard"./>
                            
                          
                         
                         
                            <br>
                            <form action ="<c:url value="/Teacher"/>" method="post"/>
                                <input type ="hidden" name="action" value="loadFlashcards"/>
                                <input type="submit" value="Load All Flashcards"./>
                            </form>
                         </form>
                         
                         
                         
                </section>
           </main>
        </div>
    </body>
</html>
