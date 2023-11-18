/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.Poltronas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_homeController implements Initializable {

    @FXML
    private Button btnUma;
    @FXML
    private Button btnOnze;
    @FXML
    private Button btnTres;
    @FXML
    private Button btnCinco;
    @FXML
    private Button btnDezEmeia;
    @FXML
    private Button btnSeteEDez;

    private Poltronas poltronas = new Poltronas();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnUma(ActionEvent event) throws IOException {
        String hora = "11:00";
        System.out.println(hora);// Exemplo de hora selecionada
        poltronasTela p = new poltronasTela();
        p.receberHoraSelecionada(hora); // Passando a hora selecionada para o controlador das poltronas
        p.start(new Stage()); // Exibindo a tela após configurar a hora
        Stage stage = (Stage) btnUma.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnOnze(ActionEvent event) throws IOException {
        String hora="11:00";
        poltronasTela p = new poltronasTela();
        p.start(new Stage());
        Stage stage = (Stage) btnOnze.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnTres(ActionEvent event) throws IOException {
        String hora="15:00";
        poltronasTela p = new poltronasTela();
        p.start(new Stage());
        Stage stage = (Stage) btnOnze.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnCinco(ActionEvent event) throws IOException {
        String hora="17:00";
        poltronasTela p = new poltronasTela();
        p.start(new Stage());
        Stage stage = (Stage) btnOnze.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void btnDezEmeia(ActionEvent event) throws IOException {
        String hora="22:30";
        poltronasTela p = new poltronasTela();
        p.start(new Stage());
        Stage stage = (Stage) btnOnze.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnSeteEDez(ActionEvent event) throws IOException {
        String hora="19:10";
        poltronasTela p = new poltronasTela();
        p.start(new Stage());
        Stage stage = (Stage) btnOnze.getScene().getWindow();
        stage.close();
    }
    
    private void msg_info(String msg){    
        Alert alerta = new Alert (Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");
               
        alerta.showAndWait(); //exibe mensagem
    }
}
