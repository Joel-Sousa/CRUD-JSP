/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author joe
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DAO.Conexao();
    }
}
