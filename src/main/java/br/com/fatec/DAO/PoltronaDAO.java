/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import static br.com.fatec.database.Database.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class PoltronaDAO {
    
        public boolean insertVendas(String poltronasConcatenadas) throws SQLException{
            boolean inseriu;
                
            try (Connection conn = connect()) {
                 
                
                String SQL = "INSERT INTO TBL_VENDAS (sala, hora, nome_cliente, poltronas) "
                        + "VALUES(?, ?, ?, ?)";
                
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS);
                
                //dados a serem inseridos
                pstmt.setString(1, "Sala 12");
                pstmt.setString(2, "15:10");
                pstmt.setString(3, "Larissa Damasceno");
                pstmt.setString(4, poltronasConcatenadas);
                
                //executa comando 
                if(pstmt.executeUpdate() > 0)
                    inseriu = true; //tudo certo com a inserção
                else
                    inseriu = false; 
                
                //fecha conexão
                conn.close();
                return inseriu;
            }
        }
        
        
        public List<String> getPoltronasCompradas(String sala, String hora) throws SQLException {
            List<String> poltronasCompradas = new ArrayList<>();

            try (Connection conn = connect()) {
                String SQL = "SELECT poltronas FROM TBL_VENDAS WHERE sala = ? AND hora = ?";
                PreparedStatement pstmt = conn.prepareStatement(SQL);

                pstmt.setString(1, sala);
                pstmt.setString(2, hora);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String poltronas = rs.getString("poltronas");
                    // Adicione as poltronas compradas à lista
                    poltronasCompradas.add(poltronas);
                }
                
                conn.close();
            }

            return poltronasCompradas;
        }

}
