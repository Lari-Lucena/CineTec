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
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadastroController implements Initializable {

    @FXML
    private Button btn_cadastro;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_apelido;
    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_celular;
    @FXML
    private DatePicker txt_bday;
    @FXML
    private ComboBox<String> cb_regiao;
    @FXML
    private TextField txt_email;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private PasswordField txt_rsenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_regiao.getItems().addAll("Zona Norte","Zona Sul", "Zona Leste", "Zona Oeste", "Centro");
        
    }    
    
    @FXML
    private void btn_cadastro(ActionEvent event) {
        
      String nome = txt_nome.getText();
      String apelido = txt_apelido.getText();
      String cpf = txt_cpf.getText();
      String celular = txt_celular.getText();
      java.time.LocalDate selectedDate = txt_bday.getValue();
      String regiao = cb_regiao.getValue();
      String email = txt_email.getText();
      String senha = txt_senha.getText();
      String rsenha = txt_rsenha.getText();
      
      
      if (nome.isEmpty()){
          msg_alert("Preencha o campo nome.");
      } else if (apelido.isEmpty()){
          msg_alert("Preencha o campo apelido.");
      } else if (cpf.length() != 11){
          msg_alert("O campo CPF deve ter exatamente 11 dígitos.");
      } else if (celular.length() != 13){
          msg_alert("O campo número de celular deve ter exatamente 13 dígitos.");
      //} else if (selectedDate.isBefore()){
      //    msg_alert("A data deve ser anterior ao dia de hoje.");
      } else if (senha.isEmpty()){
        msg_alert("Preencha o campo senha.");  
        } if (senha != rsenha){
            msg_alert("Os campos de senha são diferentes.");
      }   
      
      // cb_regiao.getValue() != "REGIÃO") 
        
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

    @FXML
    private void options(ActionEvent event) {
    }
}
