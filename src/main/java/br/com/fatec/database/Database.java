/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonardo
 */
public class Database {
    private static final String url = "jdbc:postgresql://localhost:5433/cinetec";
    private static final String user = "postgres";
    private static final String password = "postgres";
    
    public static Connection connect() {
        Connection conn = null;
        try {
              System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 

        return conn;
    }
    
    public static void insertlogin(String senha, String email) throws SQLException{
        try (Connection conn = connect()) {
            
            String SQL = "INSERT INTO login(password, email) "
                    + "VALUES(?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, senha);
            pstmt.setString(2, email);
            
            pstmt.executeUpdate();
            
            conn.close();
        }
    }
    
        public static void verificaLogin(String senha, String email) throws SQLException{
        try (Connection conn = connect()) {
            
            String SQL = "SELECT email FROM login WHERE SENHA LIKE 'senha' "
                    + "VALUES(?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, senha);
            pstmt.setString(2, email);
            
            pstmt.executeUpdate();
            
            conn.close();
        }
    }
    
}
