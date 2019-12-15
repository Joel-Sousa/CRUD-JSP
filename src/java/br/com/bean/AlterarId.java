/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.DAO;
import br.com.DAO.UsuarioDAO;
import br.com.controller.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joe
 */
public class AlterarId extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("Alt");
//        }
        
        int id = Integer.parseInt(request.getParameter("id"));
            
             UsuarioDTO uDTO = new UsuarioDTO();

             Connection con;
             
            try {
                 con = DAO.Conexao();
                   UsuarioDAO uDAO = new UsuarioDAO(con);
                   
                   uDTO = uDAO.pesquisar(id);

                   RequestDispatcher rd = 
                    request.getRequestDispatcher("alterarId.jsp");
                    rd.forward(request, response);}
               catch(Exception e){

                       }
        	String msg = "";
                
		if (uDTO == null) {

			msg = "Não foram encontrados registros.";

			request.setAttribute("msgResposta", msg);

			RequestDispatcher enviar = request
					.getRequestDispatcher("lista.jsp");
			enviar.forward(request, response);

		} else {
			request.setAttribute("id", uDTO.getId());
                        request.setAttribute("usuario", uDTO.getUsuario());
			request.setAttribute("senha", uDTO.getSenha());
                        request.setAttribute("noticia", uDTO.getNoticia());
                        RequestDispatcher lista = request
					.getRequestDispatcher("alterarId.jsp");
			lista.forward(request, response);
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
