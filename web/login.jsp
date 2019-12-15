<%-- 
    Document   : login
    Created on : 19/04/2019, 18:15:09
    Author     : joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><br>
        <center><a href="index.jsp"><input type="button" value="Cadastrar"></a></center>
    <br><center>.:Logar:.</center><br>
    <form action="login" method="post" name="form">
        <table align="center">
            <tr>
                <td>Usuario:</td>
                <td><input type="text" name="usuario" required="true" placeholder="ana"></td>
            </tr>
            <tr>
                <td>Senha:</td>
                <td><input type="text" name="senha" required="true" placeholder="123"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Logar"></td>
            </tr>
        </table>
    </form>
    </body>
</html>
