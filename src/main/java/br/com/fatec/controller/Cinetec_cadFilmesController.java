/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadFilmesController implements Initializable {

    @FXML
    private ComboBox<?> cbSelecionar;
    @FXML
    private Button btn_deletar;
    @FXML
    private Button btn_alterar;
    @FXML
    private TextField txt_distribuidora;
    @FXML
    private Button btn_cadastro;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_genero;
    @FXML
    private TextField txt_classificacao;
    @FXML
    private Label lblNome;
    @FXML
    private TextArea txt_sinopse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cbSelecionar(ActionEvent event) {
    }

    @FXML
    private void btn_deletar(ActionEvent event) {
    }

    @FXML
    private void btn_alterar(ActionEvent event) {
    }

    @FXML
    private void btn_cadastro(ActionEvent event) {
    }
    
}
