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
import javafx.scene.image.ImageView;
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
    private Button btnLista;
    @FXML
    private ImageView imgMovie;
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCadFilmes(ActionEvent event) throws IOException {
        cadFilmesTela cad = new cadFilmesTela();
        cad.start(new Stage());
        Stage stage = (Stage) btnCadFilmes.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnCadSessao(ActionEvent event) throws IOException {
        sessaoTela cad = new sessaoTela();
        cad.start(new Stage());
        Stage stage = (Stage) btnCadSessao.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void bntCadCliente(ActionEvent event) throws IOException {
        cadastroTela cad = new cadastroTela();
        cad.start(new Stage());
        Stage stage = (Stage) bntCadCliente.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnCadDis(ActionEvent event) throws IOException {
        distribuidoraTela dis = new distribuidoraTela();
        dis.start(new Stage());
        Stage stage = (Stage) btnCadDis.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void btnLista(ActionEvent event) throws IOException {
        listaTela lista = new listaTela();
        lista.start(new Stage());
        Stage stage = (Stage) btnLista.getScene().getWindow();
        stage.close();
    }
    
}
