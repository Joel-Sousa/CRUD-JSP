<%-- 
    Document   : index
    Created on : 19/04/2019, 18:10:01
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
    <center><a href="login.jsp"><input type="button" value="Logar"></a></center>
    <br><center>.:Cadastrar:.</center><br>
    <form action="cadUsr" method="post" name="form">
        <table align="center">
            <tr>
                <td>Usuario:</td>
                <td><input type="text" name="usuario" required="true"></td>
            </tr>
            <tr>
                <td>Senha:</td>
                <td><input type="text" name="senha" required="true"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Cadastrar"></td>
            </tr>
        </table>
    </form>
</body>
</html>
