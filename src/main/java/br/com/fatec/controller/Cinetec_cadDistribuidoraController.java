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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadDistribuidoraController implements Initializable {

    @FXML
    private Label lblNome;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_responsavel;
    @FXML
    private TextField txt_cnpj;
    @FXML
    private TextField txt_nome;
    @FXML
    private Button btn_cadastro;
    @FXML
    private TextField txt_celular;
    @FXML
    private TextField txt_whats;

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
