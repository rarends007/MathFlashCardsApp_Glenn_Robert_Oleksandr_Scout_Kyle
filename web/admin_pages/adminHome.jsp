<%-- 
    Document   : adminHome
    Created on : Feb 13, 2026, 12:35:19 PM
    Author     : raren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<aside>
    <div>
            <nav>
                <ul>
                    <li>
                        <a href="http://localhost:8080/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/admin_pages/registration.jsp">Registration</a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/MathFlashCardsApp_Glenn_Robert_Oleksandr_Scout_Kyle/admin_pages/deleteUser.jsp">Remove Account</a>
                    </li>
                     <li>
                        <a href="${pageContext.request.contextPath}/Public?action=logout">Logout Admin</a>
                    </li>
                </ul>
            </nav>
        </div>
</aside>
