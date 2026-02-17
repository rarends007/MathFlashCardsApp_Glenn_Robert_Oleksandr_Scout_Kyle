<%-- 
    Document   : drills
    Created on : Feb 17, 2026, 2:22:19 PM
    Author     : mrjel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drills</title>
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
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/index.jsp">Class Overview</a></li>
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/tests.jsp">Tests</a></li>
                            <li class="current"><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/drills.jsp">Drills</a></li>
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/statistics.jsp">Statistics</a></li>
                            <li><a href="/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/teacher/students.jsp">Students</a></li>
                        </ul>
                    </nav>
                </aside>
                <section>
                    <h2>Drills</h2>
                    <p>Drills are short practice sessions designed to reinforce specific math skills through repetition and adaptive question generation.</p>

                    <div>
                        <h2>Drills List</h2>
                        <br>
                        <button class="btn-primary" id="drill_create_btn">Create</button>
                        <form class="drill_create_container modular_menu">
                            <h2>Create a drill</h2>
                            <input type="text" placeholder="Title">
                            <select>
                                <option value="">--Please choose difficulty--</option>
                                <option value="easy">Easy</option>
                                <option value="medium">Medium</option>
                                <option value="hard">Hard</option>
                            </select>
                            <input type="number" placeholder="Number of Questions">
                            <!--Questions List will be here-->
                            <ul class="question_container">
                                <li>
                                    <input type="checkbox" value="id">
                                    <label>Question</label>
                                </li>
                            </ul>
                            <!------------------------------->
                            <div class="btn_container">
                                <input class="btn-primary" type="submit" value="Create">
                                <input class="btn-secondary" type="button" value="Close" id="drill_create_close_btn">
                            </div>
                        </form>
                        <ul class="drill_list">
                            <!--========================= Placeholder ======================================-->
                            <li class="drill_container">
                                <h4>Fractions Practice</h4>
                                <div class="drill_body">
                                    <p>Type: Random</p>
                                    <p>Difficulty: Medium</p>
                                    <p>Questions: 10</p>                               
                                </div>
                                <div class="drill_footer">
                                    <button class="btn-primary">Edit</button>
                                    <button class="btn-secondary">View Result</button>
                                    <button class="btn-outline">Delete</button>
                                </div>
                            </li>
                            <li class="drill_container">
                                <h4>Fractions Practice</h4>
                                <div class="drill_body">
                                    <p>Type: Random</p>
                                    <p>Difficulty: Medium</p>
                                    <p>Questions: 10</p>                               
                                </div>
                                <div class="drill_footer">
                                    <button class="btn-primary">Edit</button>
                                    <button class="btn-secondary">View Result</button>
                                    <button class="btn-outline">Delete</button>
                                </div>
                            </li>
                            <li class="drill_container">
                                <h4>Fractions Practice</h4>
                                <div class="drill_body">
                                    <p>Type: Random</p>
                                    <p>Difficulty: Medium</p>
                                    <p>Questions: 10</p>                               
                                </div>
                                <div class="drill_footer">
                                    <button class="btn-primary">Edit</button>
                                    <button class="btn-secondary">View Result</button>
                                    <button class="btn-outline">Delete</button>
                                </div>
                            </li>
                            <li class="drill_container">
                                <h4>Fractions Practice</h4>
                                <div class="drill_body">
                                    <p>Type: Random</p>
                                    <p>Difficulty: Medium</p>
                                    <p>Questions: 10</p>                               
                                </div>
                                <div class="drill_footer">
                                    <button class="btn-primary">Edit</button>
                                    <button class="btn-secondary">View Result</button>
                                    <button class="btn-outline">Delete</button>
                                </div>
                            </li>
                            <!--============================================================================-->
                        </ul>
                    </div>
                </section>
            </main>
        </div>
        <jsp:include page="/login.jsp" />
        <script src="../scripts/script.js"></script>
    </body>
</html>
