/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import static br.com.fatec.database.Database.connect;
import br.com.fatec.model.CadFilmes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.control.ComboBox;

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
    
    public boolean removeFilme(CadFilmes dado) throws SQLException {
        try (Connection conn = connect()) {
            String SQL = "DELETE FROM TBL_CAD_FILMES WHERE nome = ? AND genero = ?"; 
            PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, dado.getNome());
            pstmt.setString(2, dado.getGenero());
            //System.out.println(dado.getNome() + ", " + dado.getGenero());

            int res = pstmt.executeUpdate(); 

            conn.close();

            return res != 0;
        } 
    }

    public boolean alterFilme(CadFilmes dado) throws SQLException {
        try (Connection conn = connect()) {
            String SQL;

            if (dado.isUpdateImage()) {
                SQL = "UPDATE TBL_CAD_FILMES SET nome = ?, genero = ?, classificacao = ?, sinopse = ?, distribuidora = ?, image = ? WHERE nome = ? AND genero = ?";
            } else {
                SQL = "UPDATE TBL_CAD_FILMES SET nome = ?, genero = ?, classificacao = ?, sinopse = ?, distribuidora = ? WHERE nome = ? AND genero = ?";
            }

            PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            // associar os dados do objeto CadFilmes com o comando UPDATE
            pstmt.setString(1, dado.getNome());
            pstmt.setString(2, dado.getGenero());
            pstmt.setString(3, dado.getClassificacao());
            pstmt.setString(4, dado.getSinopse());
            pstmt.setString(5, dado.getDistribuidora());

            if (dado.isUpdateImage()) {
                pstmt.setString(6, dado.getImage());
                pstmt.setString(7, dado.getNome());
                pstmt.setString(8, dado.getGenero());
            } else {
                pstmt.setString(6, dado.getNome());
                pstmt.setString(7, dado.getGenero());
            }

            int res = pstmt.executeUpdate(); 
            conn.close();

            // devolve se funcionou ou não
            return res != 0;
        } 
    }

    public CadFilmes buscarFilme(String nome) throws SQLException {
        CadFilmes filmes = null;

        try (Connection conn = connect()) {
            String sqlQuery = "SELECT nome, genero, classificacao, sinopse, distribuidora, image FROM TBL_CAD_FILMES WHERE nome = ?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, nome);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                filmes = new CadFilmes();
                filmes.setNome(rs.getString("nome"));
                filmes.setGenero(rs.getString("genero"));
                filmes.setClassificacao(rs.getString("classificacao"));
                filmes.setSinopse(rs.getString("sinopse"));
                filmes.setDistribuidora(rs.getString("distribuidora"));
                filmes.setImage(rs.getString("image"));
            }
        conn.close();
        }
        return filmes;
    }
    
    public void preencherComboBox(ComboBox<String> cbSelecionar) {
        try (Connection conn = connect()) {
            // Sua consulta SQL para selecionar os nomes
            String sqlQuery = "SELECT nome FROM TBL_CAD_FILMES";

            try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        cbSelecionar.getItems().add(nome); // Adiciona cada nome ao ComboBox
                    }
                }
            }
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções, se necessário
        }
    }
    
        public void preencherComboBoxDistribuidora(ComboBox<String> cb_distribuidora) {
        try (Connection conn = connect()) {
            // Sua consulta SQL para selecionar os nomes
            String sqlQuery = "SELECT nome FROM TBL_CAD_DISTRIBUIDORA";

            try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        cb_distribuidora.getItems().add(nome); // Adiciona cada nome ao ComboBox
                    }
                }
            }
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções, se necessário
        }
    }
        
    public Collection<CadFilmes> lista(String criterio) throws SQLException {
        ArrayList<CadFilmes> lista = new ArrayList<>();
        String sql = "SELECT * FROM TBL_CAD_FILMES ";

        if (criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }

        try (Connection conn = connect()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        CadFilmes filmes = new CadFilmes();
                        filmes.setNome(rs.getString("nome"));
                        filmes.setGenero(rs.getString("genero"));
                        filmes.setClassificacao(rs.getString("classificacao"));
                        filmes.setSinopse(rs.getString("sinopse"));
                        filmes.setDistribuidora(rs.getString("distribuidora"));
                        filmes.setGenero(rs.getString("genero"));
                        filmes.setImage(rs.getString("image"));


                        lista.add(filmes);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções, se necessário
        }

        return lista;
    }
}
