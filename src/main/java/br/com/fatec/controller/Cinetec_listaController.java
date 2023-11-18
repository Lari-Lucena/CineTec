/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.CadFilmesDAO;
import br.com.fatec.model.CadFilmes;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_listaController implements Initializable {

    @FXML
    private TableView<CadFilmes> tbLista;
    @FXML
    private TableColumn<CadFilmes, Integer> colID;
    @FXML
    private TableColumn<CadFilmes, String> colNome;
    @FXML
    private TableColumn<CadFilmes, String> colGenero;
    @FXML
    private TableColumn<CadFilmes, String> colClassificacao;
    @FXML
    private TableColumn<CadFilmes, String> colSinopse;
    @FXML
    private TableColumn<CadFilmes, String> colDistribuidora;
    @FXML
    private TableColumn<CadFilmes, String> colImagem;

    
    private CadFilmesDAO filmesDAO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         filmesDAO = new CadFilmesDAO(); // Inicializa o DAO

        // Configura as colunas para exibição dos dados
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        colSinopse.setCellValueFactory(new PropertyValueFactory<>("sinopse"));
        colDistribuidora.setCellValueFactory(new PropertyValueFactory<>("distribuidora"));
        colImagem.setCellValueFactory(new PropertyValueFactory<>("image"));

        // Chama o método para carregar os dados do banco na TableView
        try {
            Collection<CadFilmes> filmes = filmesDAO.lista(null); // Pode passar um critério de filtro, se necessário
            tbLista.setItems(FXCollections.observableArrayList(filmes));
        } catch (SQLException e) {
            e.printStackTrace();
            // Lida com exceções, se necessário
        }
    }
        

//    @FXML
//    private void colID(TableColumn.CellEditEvent<CadFilmes, T> event) {
//    }
//
//    @FXML
//    private void colNome(TableColumn.CellEditEvent<S, T> event) {
//    }
//
//    @FXML
//    private void colGenero(TableColumn.CellEditEvent<S, T> event) {
//    }
//
//    @FXML
//    private void colClassificacao(TableColumn.CellEditEvent<S, T> event) {
//    }
//
//    @FXML
//    private void colSinopse(TableColumn.CellEditEvent<S, T> event) {
//    }
//
//    @FXML
//    private void colImagem(TableColumn.CellEditEvent<S, T> event) {
//    }
//
//    @FXML
//    private void tbLista(SortEvent<CadFilmes> event) {
//    }
    
}
