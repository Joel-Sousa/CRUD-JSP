<%-- 
    Document   : alterarId
    Created on : 23/04/2019, 18:24:03
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
        String id="";
        String usuario="";
        String senha="";
        String noticia="";

         id = (String) request.getAttribute("id").toString();
         usuario = (String) request.getAttribute("usuario").toString();
         senha = (String) request.getAttribute("senha").toString();
         noticia = (String) request.getAttribute("noticia").toString();
    %>
    
    <br><center>.:Alterar Noticia:.</center><br>
    <form action="alterar" method="post">
        <table align='center'>
            <tr>
                <td colspan="2"><input type="hidden" name="id" value="<%=id%>"></td>
            </tr>
            <tr>
                <td>Usuario</td>
                <td><input type="text" name="usuario" value="<%=usuario%>"></td>
            </tr>
            <tr>
                <td>Senha</td>
                <td><input type="text" name="senha" value="<%=senha%>"></td>
            </tr>
            <tr>
                <td>Noticia</td>
                <td><input type="text" name="noticia" value="<%=noticia%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Alterar"></td>
            </tr>
        </table>
    </form>
    </body>
</html>

