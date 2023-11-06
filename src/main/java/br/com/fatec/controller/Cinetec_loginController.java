/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.Principal;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_loginController implements Initializable {

    @FXML
    private Button btn_login;
    @FXML
    private TextField txt_user;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private Hyperlink linkCadastro;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void linkCad(ActionEvent event) throws IOException {
       
    }
    
    @FXML
    private void btn_login(ActionEvent event) throws SQLException {
        String email = txt_user.getText();
        String senha = txt_senha.getText();
        
        //veriicar se existe
        //chama outra tela
        //else
        //msg_alert("Conta não cadastrada.");
    
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
        //alerta.setContentText("");
               
        alerta.showAndWait(); //exibe mensagem
    }
 }


