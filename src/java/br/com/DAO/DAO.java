/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joe
 */
public class DAO {
    public static Connection Conexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "senha");
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (ClassNotFoundException e1) {
            throw new SQLException(e1);
        }

    }
}
