/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import static br.com.fatec.database.Database.connect;
import br.com.fatec.model.Cadastrar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Larica
 */
public class LoginDAO {

    //variaveis auxiliares
    private Cadastrar cadastro;
    //auxiliares para acesso aos dados
    
    //para conter os comandos DML
    private PreparedStatement pst; //pacote java.sql
    //para conter os dados vindos do BD
    private ResultSet rs; //pacote java.sql
    
    
    public void insertlogin(Cadastrar dado) throws SQLException{
        try (Connection conn = connect()) {
             
            
            String SQL = "INSERT INTO TBL_LOGIN (email, senha) "
                    + "VALUES(?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            //dados a serem inseridos
            pstmt.setString(1, dado.getEmail());
            pstmt.setString(2, dado.getSenha());
            
            //executa comando
            pstmt.executeUpdate();
            
            //fecha conexão
            conn.close();
        }
    }
    
    public int verificaLogin(String senha, String email) throws SQLException {
        int rowCount = 0;

        try (Connection conn = connect()) {
            String SQL = "SELECT COUNT(*) FROM TBL_LOGIN WHERE senha = ? AND email = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                pstmt.setString(1, senha);
                pstmt.setString(2, email);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    rowCount = rs.getInt(1);
                }
            }
        }

        return rowCount;
    }

}



