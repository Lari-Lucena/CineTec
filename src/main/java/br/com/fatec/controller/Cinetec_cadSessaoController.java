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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadSessaoController implements Initializable {

    @FXML
    private Button btn_cadastro;
    @FXML
    private TextField txt_filme;
    @FXML
    private TextField txt_codFilm;
    @FXML
    private TextField txt_nsala;
    @FXML
    private TextField txt_horaSessao;
    @FXML
    private TextField txt_filmeDuracao;
    @FXML
    private TextField txt_classificacao;
    @FXML
    private TextField txt_genero;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_cadastro(ActionEvent event) {
    }
    
}
