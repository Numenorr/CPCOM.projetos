/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/aula1";
    private static final String USER = "postgres";
    private static final String SENHA = "q2w3e4r5";
    
        public static Connection getConnection() {
            
            try{
                Class.forName(DRIVER);
                
                return DriverManager.getConnection(URL, USER, SENHA);
                
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro",ex);
            }
        }
    
}