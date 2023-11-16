/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_menuController implements Initializable {

    @FXML
    private Button btnCadFilmes;
    @FXML
    private Button btnCadSessao;
    @FXML
    private Button bntCadCliente;
    @FXML
    private Button btnCadDis;
    @FXML
    private Button bntLogin;
    @FXML
    private Button btnPoltronas;
    @FXML
    private Button btnFilmes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCadFilmes(ActionEvent event) {
        
    }

    @FXML
    private void btnCadSessao(ActionEvent event) {
    }

    @FXML
    private void bntCadCliente(ActionEvent event) throws IOException {
        cadastroTela cad = new cadastroTela();
        cad.start(new Stage());
    }

    @FXML
    private void btnCadDis(ActionEvent event) throws IOException {
        distribuidoraTela dis = new distribuidoraTela();
        dis.start(new Stage());
    }

    @FXML
    private void bntLogin(ActionEvent event) throws IOException {
        loginTela login = new loginTela();
        login.start(new Stage());
    }
    @FXML
    private void btnPoltronas(ActionEvent event) throws IOException {
        poltronasTela poltronas = new poltronasTela();
        poltronas.start(new Stage());
    }

    @FXML
    private void btnFilmes(ActionEvent event) {
    }
    
}
