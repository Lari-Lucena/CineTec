/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonardo
 */
public class LoginDao {
    private static final String url = "jdbc:postgresql://ep-divine-bonus-64985368.us-east-2.aws.neon.tech/cinetec";
    private static final String user = "larissa";
    private static final String password = "aQM26xyNgVns";
    
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
             
            
            String SQL = "INSERT INTO TBL_LOGIN (email, senha) "
                    + "VALUES(?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            //dados a serem inseridos
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            
            //executa comando
            pstmt.executeUpdate();
            
            //fecha conexão
            conn.close();
        }
    }
    
        public static void verificaLogin(String senha, String email) throws SQLException{
        try (Connection conn = connect()) {
       
            
            String SQL = "SELECT email FROM login WHERE SENHA LIKE 'senha' "
                    + "VALUES(?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            //executa comando
            pstmt.executeUpdate();
 
            
            //fecha conexão
            conn.close();
        }
    }
}
