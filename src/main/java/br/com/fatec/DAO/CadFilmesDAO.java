/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import static br.com.fatec.database.Database.connect;
import br.com.fatec.model.CadFilmes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonardo
 */
public class CadFilmesDAO {
    
    public boolean insertFilme(CadFilmes dado, String image) throws SQLException{
        boolean inseriu;
            
        try (Connection conn = connect()) {
             
            
            String SQL = "INSERT INTO TBL_CAD_FILMES (nome, genero, classificacao, sinopse, distribuidora, image) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            
            //dados a serem inseridos
            pstmt.setString(1, dado.getNome());
            pstmt.setString(2, dado.getGenero());
            pstmt.setString(3, dado.getClassificacao());
            pstmt.setString(4, dado.getSinopse());
            pstmt.setString(5, dado.getDistribuidora());
            pstmt.setString(6, image);
            

            if(pstmt.executeUpdate() > 0)
                inseriu = true; //tudo certo com a inserção
            else
                inseriu = false; 
            
            //fecha conexão
            conn.close();
            return inseriu;
        }
    }
}
