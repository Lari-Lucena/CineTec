/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.database.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
    @FXML
    private CheckBox chk_visualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_regiao.getItems().addAll("Zona Norte","Zona Sul", "Zona Leste", "Zona Oeste", "Centro");
        
    }    
    
    @FXML
    private void btn_cadastro(ActionEvent event) throws SQLException {
      
        String nome = txt_nome.getText();
        String apelido = txt_apelido.getText();
        String cpf = txt_cpf.getText();
        String celular = txt_celular.getText();
        java.time.LocalDate selectedDate = txt_bday.getValue();
        LocalDate hoje = LocalDate.now();
        String regiao = cb_regiao.getValue();
        String email = txt_email.getText();
        String senha = txt_senha.getText();
        String rsenha = txt_rsenha.getText();
        

        EmailValidator emailValidator = new EmailValidator();
        if (nome.isEmpty()) {
            msg_alert("Preencha o campo nome.");
            txt_nome.requestFocus();
        } else if (apelido.isEmpty()) {
            msg_alert("Preencha o campo apelido.");
            txt_apelido.requestFocus();
        } else if (!cpf.matches("\\d{11}")) {
            msg_alert("O campo CPF deve ter exatamente 11 dígitos numéricos.");
            txt_cpf.requestFocus();
        } else if (!celular.matches("\\d{11}")) {
            msg_alert("O campo número de celular deve ter exatamente 13 dígitos numéricos.");
            txt_celular.requestFocus();
        } else if (!emailValidator.isValidEmail(email)) {         
            msg_alert("Email inválido.");
            txt_email.requestFocus();
        } else if (senha.isEmpty()) {
            msg_alert("Preencha o campo senha.");
            txt_senha.requestFocus();
        } else if (!senha.equals(rsenha)) {
            msg_alert("Os campos de senha são diferentes.");
            txt_rsenha.requestFocus();
        }
        
        
//        if(!emailValidator.isValidEmail(email)) {
//            //verificar se existe o email no banco senao
//        //SELECT COUNT(EMAIL)  FROM TBL_CADASTRO WHERE EMAIL LIKE 'email'
//        //if retorno da query > 0 entao essa conta já existe
//        //msg_info("email já cadastrada.");
//        //else
//        //msg_info("conta cadastrada.");
//       
//        msg_alert("frty");
//        
//        
//        }
        
        Database.insertlogin(senha, email);
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
    
     public class EmailValidator {
        public boolean isValidEmail(String txt_email) {
            String regexPattern = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(txt_email);
            return matcher.matches();
        }
    }

    @FXML
    private void visualizar(ActionEvent event) {
        if (chk_visualizar.isSelected()) {
           
           
        }
    }
}
