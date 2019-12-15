<%-- 
    Document   : sair
    Created on : 23/04/2019, 18:00:57
    Author     : joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.removeAttribute("usuario");
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
