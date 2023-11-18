/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.CadFilmes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_listaController implements Initializable {

    @FXML
    private TableView<?> tbLista;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colNome;
    @FXML
    private TableColumn<?, ?> colGenero;
    @FXML
    private TableColumn<?, ?> colClassificacao;
    @FXML
    private TableColumn<?, ?> colSinopse;
    @FXML
    private TableColumn<?, ?> colDistribuidora;
    @FXML
    private TableColumn<?, ?> colImagem;
    @FXML
    private TableColumn<?, ?> colDistribuidora1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void colID(TableColumn.CellEditEvent<CadFilmes, T> event) {
    }

    @FXML
    private void colNome(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void colGenero(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void colClassificacao(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void colSinopse(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void colImagem(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void tbLista(SortEvent<CadFilmes> event) {
    }
    
}
