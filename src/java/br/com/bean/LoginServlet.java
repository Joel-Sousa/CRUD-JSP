/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joe
 */
public class LoginServlet extends HttpServlet {

    //private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuarioB = "";
        String senhaB = "";
        
        Connection con;
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
        
        try {
            con = DAO.Conexao();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                usuarioB = rs.getString("usuario");
                senhaB = rs.getString("senha");
            }
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        if (usuarioB.equals(usuario) || senhaB.equals(senha)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        }

    }

}
