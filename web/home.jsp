<%-- 
    Document   : logado
    Created on : 22/04/2019, 22:07:57
    Author     : joe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.DAO.DAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.controller.UsuarioDTO"%>
<%@page import="br.com.DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
       String user = (String) session.getAttribute("usuario");
        %>
     
    <center>Usuario: <%=user%> <a href='sair.jsp'>Sair</a></center> <br>
     
     <table border=1 cellpadding=0 cellspacing=0 width='30%' align="center" style="text-align: center">
            <tr>
                <th>Usuario</th>
                <th>Noticia</th>
                <th>Alterar</th>
                <th>Excluir</th>
            </tr>

            <%
                String id = "";
                String usuario = "";
                String noticia = "";

                Connection con;
                con = DAO.Conexao();
                
                UsuarioDAO uDAO = new UsuarioDAO(con);
                UsuarioDTO uDTO = new UsuarioDTO();

                ArrayList<UsuarioDTO> nomes = uDAO.pesquisarTudo();

                for (int i = 0; i < nomes.size(); i++) {
                    uDTO = nomes.get(i);
                    id = String.valueOf(uDTO.getId());
                    
                    usuario = String.valueOf(uDTO.getUsuario());
                    noticia = String.valueOf(uDTO.getNoticia());
            %>

            <tr>
                <td><%=usuario%></td>
                <td><%=noticia%></td>
                    <%if(user.equals(usuario)){%>
                <td><a href="altId?id=<%=id%>" >Alterar</a></td>
                <td><a href="exc?id=<%=id%>" >Excluir</a></td>
                    <%}else{%>
                    <td></td>
                    <td></td>
                    <%}%>
            </tr>
            <%}%>
        </table>
    </body>
</html>
