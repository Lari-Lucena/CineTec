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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextField txt_nsala;
    @FXML
    private TextField txt_horaSessao;
    @FXML
    private TextField txt_filmeDuracao;
    @FXML
    private TextField txt_classificacao;
    @FXML
    private TextField txt_genero;
    @FXML
    private ComboBox<?> cbSelecionar;
    @FXML
    private Button btn_deletar;
    @FXML
    private Button btn_alterar;
    @FXML
    private TextField txt_data;
    @FXML
    private Button btn_exibir;

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

    @FXML
    private void cbSelecionar(ActionEvent event) {
        //msg_info("aaa");
    }

    @FXML
    private void btn_deletar(ActionEvent event) {
    }

    @FXML
    private void btn_alterar(ActionEvent event) {
    }

    @FXML
    private void txt_data(ActionEvent event) {
    }

    @FXML
    private void btn_exibir(ActionEvent event) {
    }
    
    
    private void msg_info(String msg){    
        Alert alerta = new Alert (Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");
               
        alerta.showAndWait(); //exibe mensagem
    }
    
    private void msg_alert(String msg){     
        Alert alerta = new Alert (Alert.AlertType.WARNING);
        alerta.setTitle("Atenção!");
        alerta.setHeaderText(msg);
               
        alerta.showAndWait(); //exibe mensagem
    }
}
