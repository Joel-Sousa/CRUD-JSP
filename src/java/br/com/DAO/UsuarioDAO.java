/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controller.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joe
 */
public class UsuarioDAO {
    
    private Connection con;
    
    public UsuarioDAO(Connection con){
        this.con = con;
    }
        
    public void cadastrarUsuario(UsuarioDTO usr) throws SQLException{
        
        try {
            String sql = "INSERT INTO usuario(usuario,senha) VALUES(?,?) ";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,usr.getUsuario());
            stmt.setString(2, usr.getSenha());
            
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            con.close();
        }
    }   
    
    public ArrayList<UsuarioDTO> pesquisarTudo () throws Exception {
       ArrayList<UsuarioDTO> listaNomes = new ArrayList<UsuarioDTO>();
         try{
         String sql = "SELECT id,usuario,noticia FROM usuario";
         
        PreparedStatement stmt = con.prepareStatement(sql);
         
        ResultSet rs = stmt.executeQuery();
         
         stmt.execute();
         stmt.close();
         
         UsuarioDTO rgsts ;
         while (rs.next()){ 
           rgsts = new UsuarioDTO();
           rgsts.setId(rs.getInt("id"));
           rgsts.setUsuario(rs.getString("usuario"));
           rgsts.setNoticia(rs.getString("noticia"));
           listaNomes.add(rgsts); 
         } 
         con.close();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return listaNomes;
     }
    
    public UsuarioDTO pesquisar(int id) throws Exception {
        try {
            UsuarioDTO registro = new UsuarioDTO();
            
            String sql = "SELECT * FROM usuario where id = "+id+" ";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                registro.setId(rs.getInt("id"));
                registro.setUsuario(rs.getString("usuario"));
                registro.setSenha(rs.getString("senha"));
                 registro.setNoticia(rs.getString("noticia"));
                return registro;
            }
            
        } catch (Exception e) {
        }
        return null;
	}
    
    public void alterar(UsuarioDTO registro)throws Exception{
        try {
            
            String sql = "UPDATE usuario SET usuario=?, senha=?, noticia=? WHERE id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,registro.getUsuario());
            stmt.setString(2, registro.getSenha());
            stmt.setString(3, registro.getNoticia());
            stmt.setInt(4, registro.getId());
            
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
        }
    }
    
    public void deletar(UsuarioDTO nt) throws Exception{
        
         String sql = "delete FROM usuario where id=?";
         
         PreparedStatement stmt = con.prepareStatement(sql);
         
         stmt.setInt(1, nt.getId());
         stmt.execute();
         stmt.close();  
     }
}
