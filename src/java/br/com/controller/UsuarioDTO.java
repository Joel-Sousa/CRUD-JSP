/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

/**
 *
 * @author joe
 */
public class UsuarioDTO {
    
    //Atributos
    private int id;
    private String usuario;
    private String senha;
    private String noticia;
    
    //Gets
    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNoticia() {
        return noticia;
    }

    //Sets
    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
}
