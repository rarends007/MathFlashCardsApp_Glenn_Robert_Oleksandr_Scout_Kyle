<%-- 
    Document   : addFlashcards
    Created on : Feb 18, 2026, 10:56:10 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="../styles/style.css">
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
                        <li ><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/index.jsp">Class Overview</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/tests.jsp">Tests</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/drills.jsp">Drills</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/statistics.jsp">Statistics</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/students.jsp">Students</a></li>
                        <li class="current"><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/questions.jsp">Questions Manager</a></li>
                    </ul>
                </nav>
            </aside>
            <section>
                <h2>Questions Pool</h2>
                <button class="btn-primary" id="add_question">Add Question</button>
                <p>${messageAddFlashcard}</p>
                <form class="add_qestion_form" action ="<c:url value="/Teacher"/>" method="post">
                    <input type="hidden" name="action" value="addNewQuestion"/>

                    <label>Question</label>
                    <textarea name="question" required></textarea>


                    <h4>Answers</h4>

                    <ul>
                        <li> 
                            <!--list of answers go here-->
                        </li>
                    </ul>
                    <button class="btn-primary" id="create_answer">Create New Answer</button>
                    <div class="create_answer_container">
                        <label>Answer</label>
                        <div>
                            <textarea name="answer" required></textarea>
                            <input type="checkbox"> Right Answer
                        </div>
                        <button class="btn-secondary" >Add Answer</button>
                    </div>
                    <label>points</label>
                    <input type="number" name="points" required/><br>

                    <label>difficulty</label>
                    <select>
                        <option value="">--Please choose difficulty--</option>
                        <option value="easy">Easy</option>
                        <option value="medium">Medium</option>
                        <option value="hard">Hard</option>
                    </select>

                    <input type="submit" value="Add Flashcard"/>
                </form>

                ${messageRemoveFlashcard}
                <h1>Remove Question</h1>

                <!-- TODO
                1. load the flash cards into a list
                2. export that list here
                3. based on the id chosen, send that flashcard back to the Teacher Controller when they click the 'delete' button-->
            </section>
            <script src="../scripts/script.js"></script>
            </body>
