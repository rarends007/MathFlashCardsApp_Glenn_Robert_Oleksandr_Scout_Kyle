<%-- 
    Document   : addFlashcards
    Created on : Feb 18, 2026, 10:56:10 AM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                        <li class="current"><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/UserPortals/teacherPortal.jsp">Class Overview</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher_pages/tests.jsp">Tests</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher_pages/drills.jsp">Drills</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher_pages/statistics.jsp">Statistics</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher_pages/students.jsp">Students</a></li>
                        <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher_pages/addOrRemoveFlashcards.jsp">Add or Remove Flashcards</a></li>
                    </ul>
                </nav>
            </aside>
            <section>
        <h1>Add Flashcard</h1>
        ${messageAddFlashcard}
        <form action ="Teacher" method="post">
            <input type="hidden" name="action" value="addNewFlashcard"/>
            
            <label>Question</label>
            <input type="text" name="question" required/>
            
            <label>Answer</label>
            <input type="text" name="answer" required/>
            
            <label>points</label>
            <input type="text" name="points" required/>
            
           <label>difficulty</label>
           <input type="text" name="difficulty" required/>
            
        </form>
         
        ${messageRemoveFlashcard}
        <h1>Remove Flashcard</h1>
        
        <!-- TODO
        1. load the flash cards into a list
        2. export that list here
        3. based on the id chosen, send that flashcard back to the Teacher Controller when they click the 'delete' button-->
            </section>
    </body>
</html>
